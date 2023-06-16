package ru.skypro.lessons.springboot.weblibrary.service;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import java.util.*;

public interface EmployeeService {


    public int sumSalary();

    public Employee minSalary();

    public Employee maxSalary();

    public List<Employee> salaryAboveAverage();
    Employee getEmployeeByID(Long id) throws EmployeeNotFoundException;
    Employee add(Employee employee);
    void remove(Long id) throws EmployeeNotFoundException;

    Employee editEmployee(Employee employee, Long id) throws EmployeeNotFoundException;
    Collection<Employee> findAll();

    Collection<Employee> salaryHighterThan(Integer compareSalary);
}
