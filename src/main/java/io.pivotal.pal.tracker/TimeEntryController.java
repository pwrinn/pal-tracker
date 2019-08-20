package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(TimeEntry timeEntryToCreate) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        return null;
    }

    // ????
    public ResponseEntity<List<TimeEntry>> list() {
        return null;
    }

    @PutMapping
    public ResponseEntity update(long timeEntryId, TimeEntry expected) {
        return null;
    }

    @DeleteMapping
    public ResponseEntity delete(long timeEntryId) {
        return null;
    }
}
