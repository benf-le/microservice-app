package com.benfle.borrowingservice.query.controller;



import com.benfle.employeeservice.query.model.EmployeeResponseModel;
import com.benfle.employeeservice.query.queries.GetAllEmployeesQuery;
import com.benfle.employeeservice.query.queries.GetEmployeeQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/{employeeId}")
    public EmployeeResponseModel getEmployeeDetail(@PathVariable String employeeId){
        GetEmployeeQuery getEmployeesQuery = new GetEmployeeQuery();
        getEmployeesQuery.setEmployeeId(employeeId);

        EmployeeResponseModel employeeResponseModel =
                queryGateway.query(getEmployeesQuery,
                        ResponseTypes.instanceOf(EmployeeResponseModel.class))
                        .join();

        return employeeResponseModel;
    }

    @GetMapping
    public List<EmployeeResponseModel> getAllBook(){

        GetAllEmployeesQuery getAllEmployeesQuery = new GetAllEmployeesQuery();

        List<EmployeeResponseModel> list = queryGateway.query(getAllEmployeesQuery, ResponseTypes.multipleInstancesOf(EmployeeResponseModel.class))
                .join();
        return list;
    }
}
