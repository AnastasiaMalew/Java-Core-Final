package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (Product product : products) {
            totalCost += product.getCostProduct();
        }
        return totalCost;
    }

    public void printBasketContents() {
        int specialCount = 0;
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (Product product : products) {
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Количество специальных товаров в корзине: " + specialCount);
        }
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removeProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removeProducts.add(product);
                iterator.remove();
            }
        }
        return removeProducts;
    }
}