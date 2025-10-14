package org.skypro.skyshop.article;

import org.skypro.skyshop.article.Searchable;
import java.util.ArrayList;
import java.util.List;


public class SearchEngine {
    private List<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new ArrayList<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public List<Searchable> search(String query) {
        List<Searchable> result = new ArrayList<>();
        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }
}