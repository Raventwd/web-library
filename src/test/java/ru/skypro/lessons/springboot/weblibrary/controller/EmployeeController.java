package ru.skypro.lessons.springboot.weblibrary.controller;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.dto.*;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.io.IOException;
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("value = {id}")
    public EmployeeDto findById(@PathVariable (name = "id") Integer id) throws EmployeeNotFoundException {
        return EmployeeDto.fromEmployee(employeeService.findById(id).orElseThrow(EmployeeNotFoundException::new));
    }

    @GetMapping()
    public List<Employee> getEmployeesByParams(@RequestParam("salary") Integer salary) {
        return employeeService.getEmployeesByParams(salary);
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
    public ResponseEntity<Void> updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody EmployeeDto employeeDTO) throws EmployeeNotFoundException {
        employeeService.editEmployee(id, employeeDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        employeeService.remove(id);
    }

    @GetMapping("/salaryHigherThan")
   public Collection<Employee> getEmployeesWithSalaryHigherThan(@RequestParam("salary") Integer compareSalary) {
        return employeeService.salaryHighterThan(compareSalary);
    }
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        employeeService.saveEmployeeFromJson(multipartFile);

    }
}
