package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Autowired
    private InMemoryTimeEntryRepository inMemoryTimeEntryRepository;

    public TimeEntryRepository getTimeEntryRepository() {
        return inMemoryTimeEntryRepository;
    }
}

