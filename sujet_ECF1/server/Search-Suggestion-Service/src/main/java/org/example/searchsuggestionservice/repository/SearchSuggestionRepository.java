package org.example.searchsuggestionservice.repository;


import org.example.searchsuggestionservice.dto.SearchSuggestion;
import org.example.searchsuggestionservice.type.DefaultSuggestionType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SearchSuggestionRepository extends CrudRepository<SearchSuggestion, Long> {
    List<SearchSuggestion> findByTermStartsWith(String term);

    List<SearchSuggestion> findDefaultSuggestions(DefaultSuggestionType type);
}
