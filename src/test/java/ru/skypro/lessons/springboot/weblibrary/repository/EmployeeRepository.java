package ru.skypro.lessons.springboot.weblibrary.repository;

import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();
    public Employee getEmployeeByID(Long id) throws EmployeeNotFoundException;

    Employee addEmployee(Employee employee);
    void removeEmployee(Long id) throws EmployeeNotFoundException;
    Employee editEmployee(Long id, Employee employee) throws EmployeeNotFoundException;
}
