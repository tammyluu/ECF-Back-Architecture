package org.example.searchsuggestionservice.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchSuggestionService {
    List<String> getSuggestions(String q);
    List<String> getDefaultSuggestion();


}
