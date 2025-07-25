package com.daniyal.journalApp.service;

import com.daniyal.journalApp.entity.JournalEntry;
import com.daniyal.journalApp.entity.User;
import com.daniyal.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private UserService userService;

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Transactional
    public void saveEntry(JournalEntry journalEntry,String username)
    {
        try
        {
            User user=userService.findByUsername(username);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved=journalEntryRepository.save(journalEntry);
            user.getJournalEntryList().add(saved);
            userService.saveEntry(user);
        }catch(Exception e)
        {
            throw new RuntimeException("An error occured while saving the entry "+e);
        }
    }

    public void saveEntry(JournalEntry journalEntry)
    {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll()
    {
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id)
    {
        return journalEntryRepository.findById(id);
    }
    public void deleteById(ObjectId id,String username)
    {
        User user=userService.findByUsername(username);
        user.getJournalEntryList().removeIf(x-> x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }
}


