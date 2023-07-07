package ru.skypro.lessons.springboot.weblibrary.repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.modelmapper.ModelMapper;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDto;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import java.util.*;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private final ModelMapper modelMapper;

    public EmployeeRepositoryImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Query("SELECT e FROM Employee e")
    List<Employee> getAllEmployees();


    @Override
    public Employee getEmployeeById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    public EmployeeDto addEmployee(EmployeeDto employee) {
        Employee entity = modelMapper.map(employee, Employee.class);
        entityManager.persist(entity);
        return modelMapper.map(entity, EmployeeDto.class);
    }

    @Override
    public void removeEmployee(Long id) throws EmployeeNotFoundException {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }

        @Override
        public Employee editEmployee (Long id, Employee employee) throws EmployeeNotFoundException {
            Employee existingEmployee = entityManager.find(Employee.class, id);
            if (existingEmployee != null) {
                existingEmployee.setName(employee.getName());
                existingEmployee.setSalary(employee.getSalary());
                existingEmployee.setPosition(employee.getPosition());
                entityManager.merge(existingEmployee);
            }
            return existingEmployee;
        }

    }
}
