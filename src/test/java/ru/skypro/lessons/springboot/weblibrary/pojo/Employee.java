package ru.skypro.lessons.springboot.weblibrary.pojo;
import lombok.*;
@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {
    private long id;
    private String name;
    private int salary;

}
