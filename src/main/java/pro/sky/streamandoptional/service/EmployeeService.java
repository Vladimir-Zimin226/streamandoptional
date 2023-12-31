package pro.sky.streamandoptional.service;


import pro.sky.streamandoptional.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String surname, String name, int departmentId, int salary);


    Employee remove(String surname, String name, int departmentId, int salary);


    Employee find(String surname, String name, int departmentId, int salary);

    Collection<Employee> findAll();
}
