package ru.skypro.lessons.springboot.weblibrary.repository;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import java.util.*;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Long idGenerator = 1L;
    private final List<Employee> employeeList = List.of(
            new Employee(idGenerator++,"Катя", 90_000),
            new Employee(idGenerator++, "Дима", 102_000),
            new Employee(idGenerator++,"Олег", 80_000),
            new Employee(idGenerator++,"Вика", 165_000));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeByID(Long id) throws EmployeeNotFoundException {
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Employee addEmployee(Employee employee) {
        employee.setId(idGenerator++);
        employeeList.add(employee);
        return employee;
    }
    @Override
    public void removeEmployee(Long id) throws EmployeeNotFoundException {
        int index = - 1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee editEmployee(Long id, Employee employee) throws EmployeeNotFoundException {
        int index = - 1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                index = i;
                employeeList.set(i, employee);
                break;
            }
        }
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return employeeList.get(index);
    }

}

