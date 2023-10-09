package com.benfle.employeeservice.command.aggregate;



import com.benfle.employeeservice.command.command.CreateEmployeeCommand;
import com.benfle.employeeservice.command.command.DeleteEmployeeCommand;
import com.benfle.employeeservice.command.command.UpdateEmployeeCommand;
import com.benfle.employeeservice.command.event.EmployeeCreateEvent;
import com.benfle.employeeservice.command.event.EmployeeDeleteEvent;
import com.benfle.employeeservice.command.event.EmployeeUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class EmployeeAggregate {

    @AggregateIdentifier
    private String employeeId;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisciplined;


    public EmployeeAggregate(){}

    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand command){
        EmployeeCreateEvent event = new EmployeeCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateEmployeeCommand command) {
        EmployeeUpdateEvent event = new EmployeeUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }
    @CommandHandler
    public void handle(DeleteEmployeeCommand command) {
        EmployeeDeleteEvent event = new EmployeeDeleteEvent();
        event.setEmployeeId(command.getEmployeeId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(EmployeeCreateEvent event){
        this.employeeId = event.getEmployeeId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.kin = event.getKin();
        this.isDisciplined = event.getDisciplined();
    }
    @EventSourcingHandler
    public void on(EmployeeUpdateEvent event){
        this.employeeId = event.getEmployeeId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.kin = event.getKin();
        this.isDisciplined = event.getDisciplined();
    }
    @EventSourcingHandler
    public void on(EmployeeDeleteEvent event){
        this.employeeId = event.getEmployeeId();
      }

}
