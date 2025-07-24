package com.daniyal.journalApp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
// lec 13 9:56(for more detailed explanation)
//@Document is like, it tells the mongodb that this is the class(JournalEntry)
//this entity is a mapped entity with the mongodb collection

@Document(collection = "journal_entries")
@Data
@NoArgsConstructor // imp
public class JournalEntry {
    @Id // used to map as primary key
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;
}
