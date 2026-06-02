package com.workflex.challenge;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.workflex.challenge.workation.Workation;
import com.workflex.challenge.workation.WorkationRepository;

@Component
public class DatabasePrefill implements CommandLineRunner {

    private final WorkationRepository workationRepository;
    private final String DATA_FILE_PATH = "csv/workations.csv";

    DatabasePrefill(WorkationRepository workationRepository) {
        this.workationRepository = workationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (workationRepository.count() > 0) {
            System.out.println("[DatabasePrefill] DB already populated. Skipping prefill.");
            return;
        }

        ClassPathResource resource = new ClassPathResource(DATA_FILE_PATH);

        try (InputStream csvData = resource.getInputStream()) {
            if (this.workationRepository.count() > 0) {                
                return;
            }
            
            String csvContent = new String(csvData.readAllBytes(), StandardCharsets.UTF_8);
            String[] lines = csvContent.split("\n");
            List<Workation> workations = new ArrayList<>();

            // Start from index 1 to skip header
            for (int i = 1; i < lines.length; i++) {
                String line = lines[i].trim();
                if (line.isEmpty()) continue;

                String[] columns = line.split(",");
                if (columns.length < 8) continue;

                Workation workation = Workation.builder()
                        .workationId(columns[0])
                        .employee(columns[1])
                        .origin(columns[2])
                        .destination(columns[3])
                        .start(LocalDate.parse(columns[4]))
                        .end(LocalDate.parse(columns[5]))
                        .workingDays(Integer.parseInt(columns[6]))
                        .risk(columns[7])
                        .build();
                
                workations.add(workation);
            }

            this.workationRepository.saveAll(workations);
            System.out.println("[DatabasePrefill] CSV data loaded successfully. Count: " + workations.size());

        } catch (Exception e) {
            System.err.println("[DatabasePrefill] Error loading CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
