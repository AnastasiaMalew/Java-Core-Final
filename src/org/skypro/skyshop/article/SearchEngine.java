package org.skypro.skyshop.article;

import org.skypro.skyshop.article.Searchable;

import java.util.*;

public class SearchEngine {
    private final Map<String, Searchable> registry = new HashMap<>();


    public void register(Searchable item) {
        registry.put(item.getName(), item);
    }

    public Map<String, Searchable> search(String query) {
        if (query == null || query.trim().isEmpty()) {
            return Collections.emptyMap();
        }

        String lowerQuery = query.trim().toLowerCase();
        Map<String, Searchable> result = new TreeMap<>();

        for (Map.Entry<String, Searchable> entry : registry.entrySet()) {
            if (entry.getKey().toLowerCase().contains(lowerQuery)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }
}