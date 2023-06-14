package ru.skypro.lessons.springboot.weblibrary.service;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public int sumSalary() {
        List<Employee> employees = employeeRepository.getAllEmployees();
        int sum = 0;
        for (Employee employee : employees) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    @Override
    public Employee minSalary() {
        List<Employee> employees = employeeRepository.getAllEmployees();
        Employee employeeWithMinSalary = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getSalary() < employeeWithMinSalary.getSalary()){
                employeeWithMinSalary = employee;
            }

        }
        return employeeWithMinSalary;
    }

    @Override
    public Employee maxSalary() {
        List<Employee> employees = employeeRepository.getAllEmployees();
        Employee employeeWithMaxSalary = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }

        }
        return employeeWithMaxSalary;
    }

    @Override
    public List<Employee> salaryAboveAverage () {
        List<Employee> employees = employeeRepository.getAllEmployees();
        int averageSalary = sumSalary()/employees.size();
        List<Employee> highSalary = new ArrayList<>();
        for (Employee employee : employees){
            if (employee.getSalary() > averageSalary){
                highSalary.add(employee);
            }
        }

        return highSalary;
    }
}