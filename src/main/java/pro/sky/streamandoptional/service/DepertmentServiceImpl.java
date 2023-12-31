package pro.sky.streamandoptional.service;

import org.springframework.stereotype.Service;
import pro.sky.streamandoptional.Employee;
import pro.sky.streamandoptional.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepertmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepertmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departamentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departamentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departamentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departamentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartamentSortedByNameSurname() {
        return employeeService
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getSurname).thenComparing(Employee::getName))
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

    @Override
    public Collection<Employee> findEmployeesByDepartamentSortedByNameSurname(int departamentId) {
        return employeeService
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getSurname).thenComparing(Employee::getName))
                .collect(Collectors.toList());
    }
}
