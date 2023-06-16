package ru.skypro.lessons.springboot.weblibrary.controller;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/salary/sum")
    public int sumSalary() {
        return employeeService.sumSalary();
    }

    @GetMapping("/salary/min")
    public Employee minSalary() {
        return employeeService.minSalary();
    }

    @GetMapping("/salary/max")
    public Employee maxSalary() {
        return employeeService.maxSalary();

    }

    @GetMapping("/high-salary")
    public List<Employee> salaryAboveAverage() {
        return employeeService.salaryAboveAverage();
    }
    
    @GetMapping
    public Collection<Employee> getAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.add(employee);
    }

    @GetMapping("/{id}")
    public Employee getByID(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        employeeService.remove(id);
    }

    @GetMapping("/salaryHigherThan")
    public Collection<Employee> getEmployeesWithSalaryHigherThan(@RequestParam("salary") Integer compareSalary) {
        return employeeService.salaryHighterThan(compareSalary);
    }
}