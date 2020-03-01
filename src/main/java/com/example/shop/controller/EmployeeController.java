package com.example.shop.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.example.shop.enumaretions.UserRole;
import com.example.shop.model.Employee;
import com.example.shop.model.User;
import com.example.shop.service.EmployeeService;
import com.example.shop.service.UserService;
import javafx.scene.input.ScrollEvent;
import org.hibernate.annotations.LazyToOne;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees/{adminId}")
public class EmployeeController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getEmployees(@PathVariable String adminId){
        User user=userService.getById(Long.parseLong(adminId));

        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(user.getUserRole()!= UserRole.ADMIN){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        List<Employee>employees=employeeService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(employees);

    }

    @RequestMapping(value = "/{employeeId}",method =RequestMethod.GET)
    public ResponseEntity getEmployee(@PathVariable String adminId,@PathVariable String employeeId){
        User user=userService.getById(Long.parseLong(adminId));
        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if(user.getUserRole()!=UserRole.ADMIN){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        Employee employee=employeeService.getById(Long.parseLong(employeeId));
        if(employee==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(employee);

    }

    @RequestMapping (value = "/{employeeId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee(@PathVariable String adminId,@PathVariable String employeeId){
      User user=userService.getById(Long.parseLong(adminId));
      if(user==null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      if(user.getUserRole()!=UserRole.ADMIN){
          return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
      }
      employeeService.deleteById(Long.parseLong(employeeId));
      return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addEmployee(@PathVariable String adminId, @RequestBody Employee employee){

        User user=userService.getById(Long.parseLong(adminId));
        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(user.getUserRole()!=UserRole.ADMIN){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        employeeService.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateEmployee(@PathVariable String adminId,@RequestBody Employee employee){

        User user=userService.getById(Long.parseLong(adminId));
        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(user.getUserRole()!=UserRole.ADMIN){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        employeeService.update(employee);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }



}
