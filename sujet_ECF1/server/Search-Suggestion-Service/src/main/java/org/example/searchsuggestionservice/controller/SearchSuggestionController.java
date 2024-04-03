package org.example.searchsuggestionservice.controller;


import org.example.searchsuggestionservice.service.SearchSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SearchSuggestionController {
    @Autowired
    private SearchSuggestionService searchSuggestionService;

    @GetMapping("/test-search-suggestion")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("success");
    }

    @GetMapping("/search-suggestion?q={term}")
    public List<String> getSuggestions(@RequestParam String q) {
        return searchSuggestionService.getSuggestions(q);
    }

    @GetMapping("/default-search-suggestion")
    public ResponseEntity<List<String>> getDefaultSuggestions() {
        List<String> suggestions = searchSuggestionService.getDefaultSuggestion();
        return ResponseEntity.ok(suggestions);
    }
}
