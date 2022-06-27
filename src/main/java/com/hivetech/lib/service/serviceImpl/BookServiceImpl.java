package com.hivetech.lib.service.serviceImpl;

import com.hivetech.lib.config.exception.BadRequestException;
import com.hivetech.lib.model.dto.BookAfterFilter;
import com.hivetech.lib.model.dto.BookDTO;
import com.hivetech.lib.model.entity.Author;
import com.hivetech.lib.model.entity.AuthorBook;
import com.hivetech.lib.model.entity.Book;
import com.hivetech.lib.model.entity.Publisher;
import com.hivetech.lib.model.request.BookRequest;
import com.hivetech.lib.model.request.SearchBookForm;
import com.hivetech.lib.repository.AuthorBookRepository;
import com.hivetech.lib.repository.AuthorRepository;
import com.hivetech.lib.repository.BookRepository;
import com.hivetech.lib.repository.PublisherRepository;
import com.hivetech.lib.service.BookService;
import com.hivetech.lib.utils.ConvertToUpperCase;
import com.hivetech.lib.utils.enum_type.BookStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private ModelMapper mapper;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final AuthorBookRepository authorBookRepository;

    public BookServiceImpl(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository, AuthorBookRepository authorBookRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

        this.authorRepository = authorRepository;
        this.authorBookRepository = authorBookRepository;
    }

    @Override
    public List<BookDTO> getAllBook() {
        return bookRepository.findAll().stream()
                .map(book -> mapper.map(book,BookDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getAllBookAvailable() {
        return bookRepository.findAllByBookStatus(BookStatus.AVAILABLE).stream().map(book ->  mapper.map(book,BookDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BookDTO createBook(BookRequest bookRequest) {
        Optional<Publisher> publisher = publisherRepository.findById(bookRequest.getPublisherId());

        List<Author> authorList = new ArrayList<>();
        for (Long idAuthor : bookRequest.getAuthors()) {
            Author author = authorRepository.findAuthorById(idAuthor);
            authorList.add(author);
        }

        Book book = mapper.map(bookRequest,Book.class);
        book.setSubject(ConvertToUpperCase.convertName(bookRequest.getSubject()));
        book.setTitle(ConvertToUpperCase.convertName(bookRequest.getTitle()));
        book.setLibrary(ConvertToUpperCase.convertName(bookRequest.getLibrary()));
        book.setPublisher(publisher.get());
        book.setBookStatus(BookStatus.AVAILABLE);
        bookRepository.save(book);

        for (Author author : authorList) {
            AuthorBook authorBook = new AuthorBook();
            authorBook.setBook(book);
            authorBook.setAuthor(author);
            authorBookRepository.save(authorBook);
        }


        return mapper.map(book, BookDTO.class);
    }

    @Override
    public BookDTO updateBook(long id, BookRequest bookRequest) {
        Optional<Publisher> publisher = publisherRepository.findById(bookRequest.getPublisherId());

        Book book = bookRepository.findById(id).orElseThrow(() -> new BadRequestException("Book not found"));
        book.setSubject(ConvertToUpperCase.convertName(bookRequest.getSubject()));
        book.setTitle(ConvertToUpperCase.convertName(bookRequest.getTitle()));
        book.setLibrary(ConvertToUpperCase.convertName(bookRequest.getLibrary()));
        book.setNumberOfBook(bookRequest.getNumberOfBook());
        book.setCopyright(bookRequest.getCopyright());
        book.setEdition(bookRequest.getEdition());
        book.setPages(bookRequest.getPages());
        book.setPublisher(publisher.get());
        bookRepository.save(book);

        return mapper.map(book, BookDTO.class);
    }

    @Override
    public Boolean deleteBook(long id) {
        return false;
    }

    @Override
    public BookDTO getBookById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BadRequestException("Book not found"));
        return mapper.map(book, BookDTO.class);
    }

    @Override
    public List<BookAfterFilter> listAllBook() {
        List<BookAfterFilter> listBooks = bookRepository.listAllBook();
        return listBooks;
    }

    @Override
    public List<BookAfterFilter> searchBook(SearchBookForm request) {
        List<BookAfterFilter> listBooks = bookRepository.searchBook(request.getKeyword(), request.getAvailable(),request.getBorrow(),request.getReserve(), request.getEdition());
        return listBooks;
    }
}