package com.benfle.bookservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteBookCommand {

    @TargetAggregateIdentifier
    private String bookId;



    //tạo ra contructor
    public DeleteBookCommand(String bookId) {
        this.bookId = bookId;

    }



    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

}
