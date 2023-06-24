package ru.skypro.lessons.springboot.weblibrary.repository;
import org.springframework.data.jpa.repository.*;
import ru.skypro.lessons.springboot.weblibrary.dto.ReportDto;
import ru.skypro.lessons.springboot.weblibrary.pojo.Report;

import java.util.List;


public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Query(value = "SELECT new ru.skypro.lessons.springboot.weblibrary.dto.ReportDto(p.name, count(e.id), max(e.salary), min(e.salary), avg(e.salary)) " +
            "FROM Employee e left join Position p on p.id = e.position.id GROUP BY p.id")
    List<ReportDto> createReport();
}