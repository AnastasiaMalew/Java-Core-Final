package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProducts(String productName) {
        return products.remove(productName) != null
                ? products.remove(productName)
                : Collections.emptyList();
    }

    public List<Product> getProductsByName(String productName) {
        List<Product> result = products.get(productName);
        return result != null ? result : Collections.emptyList();
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
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            String productName = entry.getKey();
            List<Product> productList = entry.getValue();

            System.out.println(productName + " (" + productList.size() + " шт.):");
            for (Product product : productList) {
                System.out.println(" - " + product.getName() + ", цена: " + product.getPrice() + " руб.");
            }
        }
    }
}