package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void printBasketContents() {
        if (isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        System.out.println("Содержимое корзины:");
        Map<String, Integer> productCountMap = new HashMap<>();
        for (Product product : products) {
            productCountMap.put(product.getName(), productCountMap.getOrDefault(product.getName(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : productCountMap.entrySet()) {
            String productName = entry.getKey();
            int count = entry.getValue();
            System.out.println(productName + " (" + count + " шт.):");
                Optional<Product> exampleProduct = products.stream()
                    .filter(p -> p.getName().equals(productName))
                    .findFirst();

            if (exampleProduct.isPresent()) {
                System.out.println(" - Цена за шт.: " + exampleProduct.get().getPrice() + " руб.");
            }
        }
    }
}