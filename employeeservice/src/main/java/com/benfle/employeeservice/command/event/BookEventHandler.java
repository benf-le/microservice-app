package com.benfle.bookservice.command.event;

import com.benfle.bookservice.command.data.Employee;
import com.benfle.bookservice.command.data.EmployeeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // tự động phát
public class BookEventHandler {



    @Autowired
    private EmployeeRepository employeeRepository;

//    sau khi xử lý bên EmployeeAggregate, tiếp tục nhảy qua bên class BookEventHandler, có hàm EventHandler  mapping class EmployeeAggregate,
    @EventHandler
    public void on(BookCreateEnvent event){
        Employee employee = new Employee();// khởi tạo 1 Employee Entity
        BeanUtils.copyProperties(event, employee);
        employeeRepository.save(employee);
    }
}
