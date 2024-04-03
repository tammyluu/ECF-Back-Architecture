package org.example.searchsugesstionservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchSuggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String term;

    // define a separate table for storing the collection elements, linked to the main entity table by a foreign key.
    @ElementCollection
    @Column(name = "suggestion")
    private List<String> suggestions;



}
