package ru.skypro.lessons.springboot.weblibrary.dto;
import org.springframework.context.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;


public interface EmployeeToDto {
    EmployeeDto convertToDto(Employee employee);

    Employee convertToEntity(EmployeeDto employeeDTO);
}
