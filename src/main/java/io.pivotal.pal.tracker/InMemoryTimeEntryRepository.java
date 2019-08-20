package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long,TimeEntry> entries = new HashMap<>();
    private long nextId = 1;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id = nextId++;

        TimeEntry newEntry = new TimeEntry(id, timeEntry.getProjectId(),
                timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());

        entries.put(id, newEntry);
        return newEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return entries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(entries.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry t = entries.get(id);
        if (t==null){
            return null;
        }
        timeEntry.setId(id);
        entries.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(long id) {
        entries.remove(id);
    }
}
