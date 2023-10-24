package com.benfle.employeeservice.command.controller;


import com.benfle.employeeservice.command.command.CreateEmployeeCommand;
import com.benfle.employeeservice.command.command.DeleteEmployeeCommand;
import com.benfle.employeeservice.command.command.UpdateEmployeeCommand;
import com.benfle.employeeservice.command.model.EmployeeRequestModel;




import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.cloud.stream.messaging.Source;
import com.fasterxml.jackson.core.JsonProcessingException;


import org.springframework.cloud.stream.messaging.Source;

import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.support.MessageBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api/v1/employees")
@EnableBinding(Source.class)



public class EmployeeCommandController {

    @Autowired
    private  CommandGateway commandGateway;

    @Autowired
    private MessageChannel output;



    @PostMapping
    public String addEmployee(@RequestBody EmployeeRequestModel model) {
        CreateEmployeeCommand command =
                new CreateEmployeeCommand(UUID.randomUUID().toString(),model.getFirstName(), model.getLastName(), model.getKin(), false);

        commandGateway.sendAndWait(command);

        return "emmployee added";
    }

    @PutMapping
    public String updateEmployee(@RequestBody EmployeeRequestModel model) {
        UpdateEmployeeCommand command =
                new UpdateEmployeeCommand(model.getEmployeeId(),model.getFirstName(),model.getLastName(),model.getKin(),model.getDisciplined());
        commandGateway.sendAndWait(command);
        return "employee updated";
    }
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        DeleteEmployeeCommand command = new DeleteEmployeeCommand(employeeId);
        commandGateway.sendAndWait(command);
        return "emmployee deleted";
    }

    @PostMapping("/sendMessage")
    public void SendMessage(@RequestBody String message) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(message);
            output.send(MessageBuilder.withPayload(json).build());
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
