package org.skypro.skyshop.article;

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    String getName();

    default String getStringRepresentation() {
        return getName() + "-" + getContentType();
    }

    default boolean contains(String query) {
        return false;
    }
}
