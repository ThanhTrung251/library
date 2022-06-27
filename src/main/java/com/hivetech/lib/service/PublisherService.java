package com.hivetech.lib.service;

import com.hivetech.lib.model.dto.PublisherDTO;
import com.hivetech.lib.model.entity.Publisher;
import com.hivetech.lib.model.request.BookRequest;

import java.util.List;

public interface PublisherService {
    List<PublisherDTO> getAllPublisher();

    PublisherDTO creatPublisher(BookRequest bookRequest);

    Publisher updatePublisher(long id, Publisher publisher);

    void deletePublisher(long id);

    Publisher getPublisherById(long id);
}
