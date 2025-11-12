package org.skypro.skyshop.article;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lengthDiff = Integer.compare(s2.getName().length(), s1.getName().length()); // длиннее по убыванию
        if (lengthDiff != 0) {
            return lengthDiff;
        }
        return s1.getName().compareTo(s2.getName()); // при равенстве — по алфавиту
    }
}