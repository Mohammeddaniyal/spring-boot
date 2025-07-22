package com.daniyal.journalApp.controller;

import com.daniyal.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries=new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll()
    {
        return new ArrayList(journalEntries.values());
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable long myId)
    {
        return journalEntries.get(myId);
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry)
    {
        journalEntries.put(entry.getId(),entry);
        return true;
    }
}
