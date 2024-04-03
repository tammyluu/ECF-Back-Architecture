package org.example.searchsugesstionservice.controller;

import org.example.searchsugesstionservice.service.SearchSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SearchSuggestionController {
    @Autowired
    private SearchSuggestionService searchSuggestionService;

    @GetMapping("/search-suggestion?q={term}")
    public List<String> getSuggestions(@PathVariable String term) {
        return searchSuggestionService.getSuggestions(term);
    }

    @GetMapping("/default-search-suggestion")
    public ResponseEntity<List<String>> getDefaultSuggestions() {
        List<String> suggestions = searchSuggestionService.getDefaultSuggestion();
        return ResponseEntity.ok(suggestions);
    }
}
