package ru.skypro.lessons.springboot.weblibrary.pojo;
import jakarta.persistence.*;
import lombok.*;
@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;
}