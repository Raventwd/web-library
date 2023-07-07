package ru.skypro.lessons.springboot.weblibrary.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.classgraph.Resource;
import org.junit.platform.commons.logging.*;
import org.junit.platform.engine.reporting.ReportEntry;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.pojo.Report;
import ru.skypro.lessons.springboot.weblibrary.repository.*;

import java.io.*;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public int createReport() throws IOException {
        List<ReportEntry> reportEntries = reportRepository.getReport();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(reportEntries);
        Report report = new Report(json);
        reportRepository.save(report);
        int reportId = report.getId();
        logger.info("Report with id = {} was created: {}", reportId, report);
        logger.debug("Database was updated");
        return reportId;
    }

    @Override
    public ResponseEntity<Resource> downloadFileById(int id) throws FileNotFoundException {
        try {
            Report report = reportRepository.findById(id).orElseThrow(FileNotFoundException::new);
            String json = report.getJson();
            Resource resource = new ByteArrayResource(json.getBytes());
            ResponseEntity<Resource> file = ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"report.json\"")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(resource);
            logger.info("File was find by id = {}: {}", id, file);
            return file;
        } catch (FileNotFoundException e) {
            logger.error("There is no report with id = " + id, e);
            throw new FileNotFoundException();
        }

    }
}