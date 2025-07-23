package com.daniyal.journalApp.controller;

import com.daniyal.journalApp.entity.JournalEntry;
import com.daniyal.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;
    @GetMapping
    public List<JournalEntry> getAll()
    {
     return null;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable String myId)
    {
        return null;
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry)
    {
        journalEntryService.saveEntry(entry);
        return true;
    }

    @DeleteMapping("/id/{id}")
    public JournalEntry removeJournalEntryById(@PathVariable String id)
    {
        return null;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable String id, @RequestBody JournalEntry journalEntry)
    {
        return null;
    }
}
