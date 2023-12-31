package pro.sky.streamandoptional.service;

import pro.sky.streamandoptional.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(int departamentId);
    Employee findEmployeeWithMinSalary(int departamentId);

    Map<Integer, List<Employee>> findEmployeesByDepartamentSortedByNameSurname();

    Collection<Employee> findEmployeesByDepartamentSortedByNameSurname(int departamentId);


}
