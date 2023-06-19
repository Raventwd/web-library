package ru.skypro.lessons.springboot.weblibrary.service;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.dto.*;
import java.util.*;

public interface EmployeeService {
    List<EmployeeDto> findAll();
    void addEmployee(Employee employee);
    void deleteById(Integer id);
    Optional<Employee> findById(Integer id);
    List<Employee> getAllEmployeesByName(String name);
    List<Employee> getAllEmployeesByNameAndSalary(String name, int salary);
    List<EmployeeDto> getEmployeeWithHighestSalary();
    List<EmployeeDto> getEmployeeByPosition(int positionId);
    List<EmployeeDto> getEmployeeByPage(int page);


    public int sumSalary();

    public Employee minSalary();

    public Employee maxSalary();

    public List<Employee> salaryAboveAverage();
    Employee getEmployeeByID(Long id) throws EmployeeNotFoundException;
    Employee add(Employee employee);
    void remove(Long id) throws EmployeeNotFoundException;

    Employee editEmployee(Employee employee, Long id) throws EmployeeNotFoundException;

    Collection<Employee> salaryHighterThan(Integer compareSalary);
}
