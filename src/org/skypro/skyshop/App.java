package org.skypro.skyshop;

import org.skypro.skyshop.article.SearchEngine;
import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.product.*;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Set<String> productSet = new HashSet<>();
        Map<String, List<Product>> productMap = new HashMap<>();

        SimpleProduct apple = new SimpleProduct("Яблоки", 230);
        SimpleProduct meat = new SimpleProduct("Мясо", 150);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 10, 115);
        DiscountedProduct egg = new DiscountedProduct("Яйцо", 15, 54);
        FixPriceProduct chocolate = new FixPriceProduct("Шоколад");
        SimpleProduct apple2 = new SimpleProduct("Яблоки", 50);

        addProductToSet(productSet, apple);
        addProductToSet(productSet, meat);
        addProductToSet(productSet, milk);
        addProductToSet(productSet, egg);
        addProductToSet(productSet, chocolate);
        addProductToSet(productSet, apple2);

        System.out.println("Результаты поиска:");
        for (String productName : productSet) {
            if (productName.toLowerCase().contains("яблоки")) {
                System.out.println("Найден: " + productName);
            }
        }

        System.out.println("\nСодержимое корзины (все продукты):");
        printProductSet(productSet);

        SearchEngine engine = new SearchEngine();

        engine.register(apple);
        engine.register(meat);
        engine.register(milk);
        engine.register(egg);
        engine.register(chocolate);
        engine.register(apple2);

        String searchQuery = "яблоки";
        Set<String> results = engine.search(searchQuery);

        System.out.println("Результаты поиска по запросу \"" + searchQuery + "\":");
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (String name : results) {
                System.out.println("  " + name);
            }
        }
    }

    private static void addProductToMap(Map<String, List<Product>> map, Product product) {
        String name = product.getName();
        if (!map.containsKey(name)) {
            map.put(name, new ArrayList<>());
        }
        map.get(name).add(product);
    }

    private static void addProductToSet(Set<String> set, Product product) {
        set.add(product.getName());
    }

    private static void printProductSet(Set<String> productSet) {
        for (String productName : productSet) {
            System.out.println("Товар: " + productName);
        }
    }

}