package com.example.shop.service;

import com.example.shop.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    void  add(Employee employee);

    void delete(Employee employee);

    void deleteById(long id);

    void update(Employee employee);

    Employee getById(long id);

    Employee getByNameAndSurnameAndPatronymicAndAge(String name,String surname,String patronymic,int age);

    List<Employee> getAll();
}
