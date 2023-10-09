package com.benfle.bookservice.query.projection;

import com.benfle.bookservice.command.data.Book;
import com.benfle.bookservice.command.data.BookRepository;
import com.benfle.bookservice.query.model.BookResponseModel;
import com.benfle.bookservice.query.queries.GetAllBooksQuery;
import com.benfle.bookservice.query.queries.GetBookQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookProjection {
    @Autowired
    private BookRepository bookRepository;

    @QueryHandler
    public BookResponseModel handle(GetBookQuery getBookQuery){
        BookResponseModel model = new BookResponseModel();

        Book book = bookRepository.getById(getBookQuery.getBookId());

        BeanUtils.copyProperties(book,model);

        return model;
    }


    @QueryHandler List<BookResponseModel> handle(GetAllBooksQuery getAllBooksQuery){

        List<Book> listEntity = bookRepository.findAll();
        List<BookResponseModel> listbook = new ArrayList<>();
        listEntity.forEach(s ->{
            BookResponseModel model = new BookResponseModel();
            BeanUtils.copyProperties(s, model);
            listbook.add(model);
        });
        return listbook;
    }
}
