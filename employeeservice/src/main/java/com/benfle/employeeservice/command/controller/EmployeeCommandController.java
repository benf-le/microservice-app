package com.benfle.employeeservice.command.controller;


import com.benfle.employeeservice.command.command.CreateEmployeeCommand;
import com.benfle.employeeservice.command.command.DeleteEmployeeCommand;
import com.benfle.employeeservice.command.command.UpdateEmployeeCommand;
import com.benfle.employeeservice.command.model.EmployeeRequestModel;

import org.springframework.web.bind.annotation.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")


public class EmployeeCommandController {

    @Autowired
    private  CommandGateway commandGateway;


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
}
