package com.daniyal.journalApp.controller;

import com.daniyal.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryControllerV2 {
    private Map<String, JournalEntry> journalEntries=new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll()
    {
        return new ArrayList(journalEntries.values());
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable String myId)
    {
        return journalEntries.get(myId);
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry)
    {
        journalEntries.put(entry.getId(),entry);
        return true;
    }

    @DeleteMapping("/id/{id}")
    public JournalEntry removeJournalEntryById(@PathVariable String id)
    {
        return journalEntries.remove(id);
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable String id, @RequestBody JournalEntry journalEntry)
    {
        return journalEntries.put(id,journalEntry);
    }
}
