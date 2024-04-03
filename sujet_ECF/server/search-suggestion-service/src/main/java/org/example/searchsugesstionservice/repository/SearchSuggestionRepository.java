package org.example.searchsugesstionservice.repository;

import org.example.searchsugesstionservice.entity.SearchSuggestion;
import org.example.searchsugesstionservice.enum1.DefaultSuggestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SearchSuggestionRepository extends CrudRepository<SearchSuggestion, Long> {
    List<SearchSuggestion> findByTermStartsWith(String term);

    List<SearchSuggestion> findDefaultSuggestions(DefaultSuggestionType type);
}
