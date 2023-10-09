package com.benfle.employeeservice.command.aggregate;



import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class EmployeeAggregate {

    @AggregateIdentifier
    private String bookId;
    private String name;
    private String author;
    private Boolean isReady;


    public EmployeeAggregate() {

    }

    @CommandHandler
    public EmployeeAggregate(CreateBookCommand createBookCommand) {

//        khởi tạo 1 cái event
        BookCreateEnvent bookCreateEnvent = new BookCreateEnvent();
//        copy all thuật tính của createBookCommand sang bookCreateEnvent, 2 cái đó dùng chung thuật tính nên dùng hàm đó
        BeanUtils.copyProperties(createBookCommand, bookCreateEnvent);
// apply cái event này
        AggregateLifecycle.apply(bookCreateEnvent);
    }
//    khi mà phát ra cái AggregateLifecycle.apply(bookCreateEnvent); thì nó sẽ nhảy vào hàm on
//    hàm on: lấy data từ BookCreateEnvent thông qua event, sau đó cập nhật lại cho EmployeeAggregate
    @EventSourcingHandler
    public void on(BookCreateEnvent event){
        this.bookId= event.getBookId();
        this.author = event.getAuthor();
        this.isReady = event.getIsReady();
        this.name = event.getName();
    }



}
