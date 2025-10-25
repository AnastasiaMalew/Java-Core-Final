package org.skypro.skyshop;

import org.skypro.skyshop.article.SearchEngine;
import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.product.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<String, List<Product>> productMap = new HashMap<>();

        SimpleProduct apple = new SimpleProduct("Яблоки", 230);
        SimpleProduct meat = new SimpleProduct("Мясо", 150);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 10, 115);
        DiscountedProduct egg = new DiscountedProduct("Яйцо", 15, 54);
        FixPriceProduct chocolate = new FixPriceProduct("Шоколад");
        SimpleProduct apple2 = new SimpleProduct("Яблоки", 50);

        addProductToMap(productMap, apple);
        addProductToMap(productMap, meat);
        addProductToMap(productMap, milk);
        addProductToMap(productMap, egg);
        addProductToMap(productMap, chocolate);
        addProductToMap(productMap, apple2);

        System.out.println("Результаты поиска:");
        List<Product> foundApples = productMap.get("Яблоки");
        if (foundApples != null && !foundApples.isEmpty()) {
            System.out.println("Найденные яблоки:");
            for (Product product : foundApples) {
                System.out.println(product.getName() + " - " + product.getPrice() + " руб.");
            }
        } else {
            System.out.println("Продукт «Яблоки» не найден");
        }

        System.out.println("\nСодержимое корзины (все продукты):");
        printProductMap(productMap);

        SearchEngine engine = new SearchEngine();

        engine.register(apple);
        engine.register(meat);
        engine.register(milk);
        engine.register(egg);
        engine.register(chocolate);
        engine.register(apple2);

        String searchQuery = "яблоки";
        Map<String, Searchable> results = engine.search(searchQuery);

        System.out.println("Результаты поиска по запросу \"" + searchQuery + "\":");

        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (Map.Entry<String, Searchable> entry : results.entrySet()) {
                String name = entry.getKey();
                Searchable item = entry.getValue();

                System.out.printf(
                        "  %s",
                        name
                );
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

    private static void printProductMap(Map<String, List<Product>> map) {
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<Product> products = entry.getValue();
            System.out.println("Товар: " + name);
            for (Product product : products) {
                System.out.println("  - Цена: " + product.getPrice() + " руб.");
            }
        }
    }
}