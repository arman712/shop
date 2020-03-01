package com.example.shop.repository;

import com.example.shop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee getById(long id);
    Employee getByNameAndSurnameAndPatronymicAndAge(String name,String surname,String patronymic,int age);
    void deleteById(long id);

}
