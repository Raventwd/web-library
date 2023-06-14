package ru.skypro.lessons.springboot.weblibrary.service;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import java.util.*;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    public int sumSalary();

    public Employee minSalary();

    public Employee maxSalary();

    public List<Employee> salaryAboveAverage();

}
