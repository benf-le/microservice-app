package com.benfle.bookservice.command.aggregate;


import com.benfle.bookservice.command.command.CreateBookCommand;
import com.benfle.bookservice.command.command.DeleteBookCommand;
import com.benfle.bookservice.command.command.UpdateBookCommand;
import com.benfle.bookservice.command.event.BookCreateEvent;
import com.benfle.bookservice.command.event.BookDeleteEvent;
import com.benfle.bookservice.command.event.BookUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class BookAggregate {

    @AggregateIdentifier
    private String bookId;
    private String name;
    private String author;
    private Boolean isReady;


    public BookAggregate() {

    }

    @CommandHandler
    public BookAggregate(CreateBookCommand createBookCommand) {

//        khởi tạo 1 cái event
        BookCreateEvent bookCreateEvent = new BookCreateEvent();
//        copy all thuật tính của createBookCommand sang bookCreateEnvent, 2 cái đó dùng chung thuật tính nên dùng hàm đó
        BeanUtils.copyProperties(createBookCommand, bookCreateEvent);
// apply cái event này
        AggregateLifecycle.apply(bookCreateEvent);
    }
//    khi mà phát ra cái AggregateLifecycle.apply(bookCreateEnvent); thì nó sẽ nhảy vào hàm on
//    hàm on: lấy data từ BookCreateEvent thông qua event, sau đó cập nhật lại cho BookAggregate
  @CommandHandler
    public void handle(UpdateBookCommand updateBookCommand) {

//        khởi tạo 1 cái event
        BookUpdateEvent bookUpdateEvent = new BookUpdateEvent();
//        copy all thuật tính của createBookCommand sang bookCreateEnvent, 2 cái đó dùng chung thuật tính nên dùng hàm đó
        BeanUtils.copyProperties(updateBookCommand, bookUpdateEvent);
// apply cái event này
        AggregateLifecycle.apply(bookUpdateEvent);
    }
//    khi mà phát ra cái AggregateLifecycle.apply(bookCreateEnvent); thì nó sẽ nhảy vào hàm on
//    hàm on: lấy data từ BookCreateEvent thông qua event, sau đó cập nhật lại cho BookAggregate
  @CommandHandler

    public void handle(DeleteBookCommand deleteBookCommand) {

//        khởi tạo 1 cái event
        BookDeleteEvent bookDeleteEvent = new BookDeleteEvent();
//        copy all thuật tính của createBookCommand sang bookCreateEnvent, 2 cái đó dùng chung thuật tính nên dùng hàm đó
        BeanUtils.copyProperties(deleteBookCommand, bookDeleteEvent);
// apply cái event này
        AggregateLifecycle.apply(bookDeleteEvent);
    }
//    khi mà phát ra cái AggregateLifecycle.apply(bookCreateEnvent); thì nó sẽ nhảy vào hàm on
//    hàm on: lấy data từ BookCreateEvent thông qua event, sau đó cập nhật lại cho BookAggregate
    @EventSourcingHandler
    public void on(BookCreateEvent event){
        this.bookId= event.getBookId();
        this.author = event.getAuthor();
        this.isReady = event.getIsReady();
        this.name = event.getName();
    }

    public void on(BookUpdateEvent event){
        this.bookId= event.getBookId();
        this.author = event.getAuthor();
        this.isReady = event.getIsReady();
        this.name = event.getName();
    }

    public void on(BookDeleteEvent event){
        this.bookId= event.getBookId();

    }



}
