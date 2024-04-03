package org.example.searchsugesstionservice.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchSuggestionService {
    List<String> getSuggestions(String search);
    List<String> getDefaultSuggestion();


}
