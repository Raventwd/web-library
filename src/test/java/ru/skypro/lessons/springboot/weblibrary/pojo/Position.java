package ru.skypro.lessons.springboot.weblibrary.pojo;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}