package ru.skypro.lessons.springboot.weblibrary.dto;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

@Component
public class EmployeeToDtoImpl implements EmployeeToDto {
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeDtoConverterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto convertToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public Employee convertToEntity(EmployeeDto employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }
}