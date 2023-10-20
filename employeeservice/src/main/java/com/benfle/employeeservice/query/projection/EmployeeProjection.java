package com.benfle.employeeservice.query.projection;


import com.benfle.employeeservice.command.data.Employee;
import com.benfle.employeeservice.command.data.EmployeeRepository;
import com.benfle.employeeservice.query.model.EmployeeResponseModel;
import com.benfle.employeeservice.query.queries.GetAllEmployeesQuery;
import com.benfle.employeeservice.query.queries.GetEmployeeQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProjection {
    @Autowired
    private EmployeeRepository employeeRepository;


    @QueryHandler
    public EmployeeResponseModel handle(GetEmployeeQuery getEmployeeQuery){
        EmployeeResponseModel model = new EmployeeResponseModel();
        Employee employee = employeeRepository.getById(getEmployeeQuery.getEmployeeId());
        BeanUtils.copyProperties(employee, model);

        return model;
    }

    @QueryHandler
    public List<EmployeeResponseModel> handle(GetAllEmployeesQuery getAllEmployeesQuery){
        List<EmployeeResponseModel> listModel = new ArrayList<>();
        List<Employee> listEntity = employeeRepository.findAll();
        listEntity.stream().forEach(s->{
            EmployeeResponseModel model = new EmployeeResponseModel();
            BeanUtils.copyProperties(s, model);
            listModel.add(model);
        });

        return listModel;
    }
}
