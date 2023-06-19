package ru.skypro.lessons.springboot.weblibrary.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.dto.*;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import java.util.*;

import static java.util.Objects.isNull;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public List<EmployeeDto> getAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }
    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        employeeService.deleteById(id);
    }
    @GetMapping("value = /employees/{id}")
    public EmployeeDto findById(@PathVariable (name = "id") Integer id) throws EmployeeNotFoundException {
        return EmployeeDto.fromEmployee(employeeService.findById(id).orElseThrow(EmployeeNotFoundException::new));
    }

    @GetMapping()
    public List<Employee> getEmployeesByParams(@RequestParam Map<String, String> params) {
        String salary = params.get("salary");
        String name = params.get("name");

        if (isNull(salary)){
            return employeeService.getAllEmployeesByName(name);
        }else {
            int salaryInt = Integer.parseInt(salary);
            return employeeService.getAllEmployeesByNameAndSalary(name, salaryInt);
        }
    }
    @GetMapping("/withHighestSalary")
    public List<EmployeeDto> getEmployeeWithHighSalary() {
        return employeeService.getEmployeeWithHighestSalary();

    }

    @GetMapping("/byPosition")
    public List<EmployeeDto> getEmployeesByPosition(@RequestParam(name = "position", required = false) Integer positionId) {
        if (isNull(positionId)) {
            return employeeService.findAll();
        } else {
            return employeeService.getEmployeeByPosition(positionId);
        }
    }

    @GetMapping("/page")
    public List<EmployeeDto> getEmployeeByPage(@RequestParam(name = "page") int page) {
        return employeeService.getEmployeeByPage(page);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee, @PathVariable Long id) throws EmployeeNotFoundException {
        Employee foundStudent = employeeService.editEmployee(employee, id);
        return ResponseEntity.ok(foundStudent);
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