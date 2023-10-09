package com.benfle.employeeservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class EmployeeBookCommand {
    @TargetAggregateIdentifier
    private String employeeId;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisciplined;



//tạo ra contructor
    public EmployeeBookCommand(String employeeId, String firstName, String lastName, String kin, Boolean isDisciplined) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.kin = kin;
        this.isDisciplined = isDisciplined;
    }
}
