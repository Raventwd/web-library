package ru.skypro.lessons.springboot.weblibrary.service;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.*;
import ru.skypro.lessons.springboot.weblibrary.dto.*;
import org.springframework.data.domain.*;
import java.util.*;
import java.util.stream.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final EmployeePages employeePages;

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return EmployeeToDto.fromEmployee(employees);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getAllEmployeesByNameAndSalary(String name, int salary) {
        return employeeRepository.findByNameAndSalary(name, salary);
    }

    @Override
    public List<EmployeeDto> getEmployeeWithHighestSalary() {
        return EmployeeToDto.fromEmployee(employeeRepository.findEmployeeWithBiggestSalary());
    }

    @Override
    public List<EmployeeDto> getEmployeeByPosition(int positionId) {
        return EmployeeToDto.fromEmployee(employeeRepository.findAllByPositionId(positionId));
    }

    @Override
    public List<EmployeeDto> getEmployeeByPage(int pageIndex) {
        Pageable employeeOfConcretePage = PageRequest.of(pageIndex, 10);
        Page<Employee> page = employeePages.findAll(employeeOfConcretePage);
        return EmployeeToDto.fromEmployee(page.stream().toList());
    }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeePages employeePages) {
        this.employeeRepository = employeeRepository;
        this.employeePages = employeePages;
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

    @Override
    public Employee getEmployeeByID(Long id) throws EmployeeNotFoundException {
        return employeeRepository.getEmployeeByID(id);
    }

    @Override
    public Employee add(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public void remove(Long id) throws EmployeeNotFoundException {
        employeeRepository.removeEmployee(id);
    }


    @Override
    public Employee editEmployee(Employee employee, Long id) throws EmployeeNotFoundException {
        return employeeRepository.editEmployee(id, employee);
    }



    @Override
    public Collection<Employee> salaryHighterThan(Integer compareSalary) {
        Collection<Employee> salaryHighter = new ArrayList<>();
        for (Employee employee : findAll()) {
            if (employee.getSalary() > compareSalary) {
                salaryHighter.add(employee);
            }
        }
        return salaryHighter;
    }
}