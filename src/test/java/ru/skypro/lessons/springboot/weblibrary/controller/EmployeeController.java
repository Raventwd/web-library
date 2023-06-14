package ru.skypro.lessons.springboot.weblibrary.controller;
import org.springframework.web.bind.annotation.*;
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

}
