package org.skypro.skyshop.article;

import java.util.Comparator;
import java.util.TreeSet;

class Main {
    private static final Comparator<Searchable> searchableComparator =
            Comparator.<Searchable>comparingInt(s -> {
                        String name = s.getName();
                        return (name != null) ? name.length() : 0;
                    })
                    .reversed()
                    .thenComparing(s -> {
                        String name = s.getName();
                        return (name != null) ? name : "";
                    });

    public static void main(String[] args) {
        TreeSet<Searchable> results = search("example query");

        for (Searchable item : results) {
            System.out.println(item.getName());
        }
    }

    public static TreeSet<Searchable> search(String query) {
        TreeSet<Searchable> results = new TreeSet<>(searchableComparator);

        results.add(new SearchableItem("Short"));
        results.add(new SearchableItem("Very Long Name Indeed"));
        results.add(new SearchableItem("Medium"));

        return results;
    }
}

class SearchableItem implements Searchable {
    private final String name;

    public SearchableItem(String name) {
        this.name = name;
    }

    @Override
    public String getSearchTerm() {
        return "";
    }

    @Override
    public String getContentType() {
        return "";
    }

    @Override
    public String getName() {
        return name;
    }
}
