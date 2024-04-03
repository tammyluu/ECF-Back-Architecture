package org.example.searchsugesstionservice.service.serviceImp;

import org.example.searchsugesstionservice.entity.SearchSuggestion;
import org.example.searchsugesstionservice.enum1.DefaultSuggestionType;
import org.example.searchsugesstionservice.repository.SearchSuggestionRepository;
import org.example.searchsugesstionservice.service.SearchSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class SearchSuggestionServiceImpl  implements SearchSuggestionService {
    @Autowired(required = false)
    private SearchSuggestionRepository searchSuggestionRepository;
    @Override
    public List<String> getSuggestions(String searchTerm) {
        List<SearchSuggestion> existingSuggestions = searchSuggestionRepository.findByTermStartsWith(searchTerm);
        List<String> suggestions = new ArrayList<>();
        for (SearchSuggestion suggestion : existingSuggestions) {
            suggestions.add(suggestion.getTerm());
        }
        return suggestions;
    }

    @Override
    public List<String> getDefaultSuggestion() {
        List<SearchSuggestion> defaultSuggestions = searchSuggestionRepository.findDefaultSuggestions(DefaultSuggestionType.DEFAULT);
        List<String> suggestionList = new ArrayList<>();
        for (SearchSuggestion suggestion : defaultSuggestions) {
            suggestionList.add(suggestion.getTerm());
        }
        return suggestionList;
    }


}
