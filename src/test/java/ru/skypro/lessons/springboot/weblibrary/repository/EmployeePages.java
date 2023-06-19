package ru.skypro.lessons.springboot.weblibrary.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import java.util.*;



public class EmployeePages extends PagingAndSortingRepository<Employee, Integer>{
}
