package ru.skypro.lessons.springboot.weblibrary.service;
import io.github.classgraph.Resource;
import org.springframework.http.ResponseEntity;
import ru.skypro.lessons.springboot.weblibrary.pojo.Report;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
public interface ReportService {


    public interface ReportService {

        int createReport() throws IOException;

        ResponseEntity<Resource> downloadFileById(int id) throws FileNotFoundException;
    }
}
