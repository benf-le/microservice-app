package com.benfle.employeeservice.command.event;



import com.benfle.employeeservice.command.data.Employee;
import com.benfle.employeeservice.command.data.EmployeeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // tự động phát
public class EmployeeEventHandler {
    @Autowired
    private EmployeeRepository employeeRepository;

//    sau khi xử lý bên EmployeeAggregate, tiếp tục nhảy qua bên class EmployeeEventHandler, có hàm EventHandler  mapping class EmployeeAggregate,
    @EventHandler
    public void on(EmployeeCreateEvent event){
        Employee employee = new Employee();// khởi tạo 1 Employee Entity
        BeanUtils.copyProperties(event, employee);
        employeeRepository.save(employee);
    }

    @EventHandler
    public void on(EmployeeUpdateEvent event) {
        Employee employee = employeeRepository.getById(event.getEmployeeId());
        employee.setFirstName(event.getFirstName());
        employee.setLastName(event.getLastName());
        employee.setKin(event.getKin());
        employee.setDisciplined(event.getDisciplined());
        employeeRepository.save(employee);
    }

    @EventHandler
    public void on(EmployeeDeleteEvent event) {
        try {
            employeeRepository.deleteById(event.getEmployeeId());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }


}
