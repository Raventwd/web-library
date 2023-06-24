package ru.skypro.lessons.springboot.weblibrary.service;
import ru.skypro.lessons.springboot.weblibrary.pojo.Report;
import java.io.IOException;
import java.util.Optional;
public interface ReportService {


    public interface ReportService {

        Integer createReport() throws IOException;
        Optional<Report> getReportById(int id);
    }
}
