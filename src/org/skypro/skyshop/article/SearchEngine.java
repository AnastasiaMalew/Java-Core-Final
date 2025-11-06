package org.skypro.skyshop.article;

import org.skypro.skyshop.article.Searchable;
import java.util.*;

public class SearchEngine {
    private final Set<Searchable> registry = new HashSet<>();

    public void register(Searchable item) {
        registry.add(item);
    }

    public Set<String> search(String query) {
        if (query == null || query.trim().isEmpty()) {
            return Collections.emptySet();
        }

        String lowerQuery = query.trim().toLowerCase();
        Set<String> result = new TreeSet<>();

        for (Searchable item : registry) {
            if (item.getName().toLowerCase().contains(lowerQuery)) {
                result.add(item.getName());
            }
        }

        return result;
    }
}