package ru.skypro.lessons.springboot.weblibrary.service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.dto.*;

import java.io.IOException;
import java.util.*;

public interface EmployeeService {
    List<EmployeeDto> findAll();
    void addEmployee(Employee employee);
    void deleteById(Long id);
    Optional<Employee> findById(Integer id);
    List<Employee> getAllEmployeesByName(String name);
    List<Employee> getAllEmployeesByNameAndSalary(String name, int salary);
    List<EmployeeDto> getEmployeeWithHighestSalary();
    List<EmployeeDto> getEmployeeByPosition(int positionId);
    List<EmployeeDto> getEmployeeByPage(int page);


    public int sumSalary();

    public Employee minSalary();

    public Employee maxSalary();

     List<Employee> getEmployeesByParams(Integer salary);

    public List<Employee> salaryAboveAverage();
    Employee getEmployeeById(Long id) throws EmployeeNotFoundException;
    Employee add(Employee employee);
    void remove(Long id) throws EmployeeNotFoundException;

    Employee editEmployee(Long id, Employee employee) throws EmployeeNotFoundException;

    Collection<Employee> salaryHighterThan(Integer compareSalary);
    void saveEmployeeFromJson(MultipartFile file) throws IOException;



}
