package com.benfle.bookservice.command.event;

import com.benfle.bookservice.command.data.Book;
import com.benfle.bookservice.command.data.BookRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // tự động phát
public class BookEventHandler {



    @Autowired
    private BookRepository bookRepository;

//    sau khi xử lý bên BookAggregate, tiếp tục nhảy qua bên class BookEventHandler, có hàm EventHandler  mapping class BookAggregate,
    @EventHandler
    public void on(BookCreateEnvent event){
        Book book = new Book();// khởi tạo 1 Book Entity
        BeanUtils.copyProperties(event,book);
        bookRepository.save(book);
    }
}
