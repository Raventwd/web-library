package ru.skypro.lessons.springboot.weblibrary.dto;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;
import java.util.stream.Collectors;


public class EmployeeToDto {
    public static EmployeeDto fromEmployee(Employee employee){
        String positionName = employee.getPosition() == null ? "No position" : employee.getPosition().getName();
        return new EmployeeDto(employee.getId(), employee.getName(), employee.getSalary(), positionName);
    }
    public static List<EmployeeDto> fromEmployee(List<Employee> employees) {
        return employees.stream().map(EmployeeToDto::fromEmployee).collect(Collectors.toList());
    }
}
