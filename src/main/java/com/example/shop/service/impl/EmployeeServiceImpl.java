package com.example.shop.service.impl;

import com.example.shop.model.Employee;
import com.example.shop.repository.EmployeeRepository;
import com.example.shop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    @Transactional
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
         employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee getById(long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public Employee getByNameAndSurnameAndPatronymicAndAge(String name, String surname, String patronymic, int age) {
        return employeeRepository.getByNameAndSurnameAndPatronymicAndAge(name,surname,patronymic,age);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
