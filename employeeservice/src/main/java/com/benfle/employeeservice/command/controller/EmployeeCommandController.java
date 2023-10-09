package com.benfle.employeeservice.command.controller;


import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeCommandController {
    @Autowired
    private CommandGateway commandGateway;

//    gửi đi 1 command
    @PostMapping
    public String addEmployee(@RequestBody EmployeeRequestModel model) {
        CreateBookCommand command =
                new CreateBookCommand(UUID.randomUUID().toString(), model.getName(), model.getAuthor(), true);
        commandGateway.sendAndWait(command);
        return "added Employee";

    }
}
