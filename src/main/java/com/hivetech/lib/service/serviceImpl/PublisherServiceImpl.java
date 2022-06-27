package com.hivetech.lib.service.serviceImpl;

import com.hivetech.lib.model.dto.PublisherDTO;
import com.hivetech.lib.model.entity.Publisher;
import com.hivetech.lib.model.request.BookRequest;
import com.hivetech.lib.repository.PublisherRepository;
import com.hivetech.lib.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    PublisherRepository publisherRepository;

   @Autowired
   private ModelMapper mapper;

    @Override
    public List<PublisherDTO> getAllPublisher() {
        return publisherRepository.findAll().stream()
                .map(publisher -> mapper.map(publisher,PublisherDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PublisherDTO creatPublisher(BookRequest bookRequest) {
        return null;
    }

    @Override
    public Publisher updatePublisher(long id, Publisher publisher) {
        return null;
    }

    @Override
    public void deletePublisher(long id) {}

    @Override
    public Publisher getPublisherById(long id) {
        return null;
    }
}
