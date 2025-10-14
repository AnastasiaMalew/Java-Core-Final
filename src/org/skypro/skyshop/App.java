package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Searchable;

import java.util.Arrays;
import java.util.List;


public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        // Создаем продукты
        SimpleProduct apple = new SimpleProduct("Яблоки", 45);
        SimpleProduct meat = new SimpleProduct("Мясо", 150);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 10, 115);
        DiscountedProduct egg = new DiscountedProduct("Яйцо", 15, 54);
        FixPriceProduct chocolate = new FixPriceProduct("Шоколад");
        SimpleProduct apple2 = new SimpleProduct("Яблоки", 50);

        List<Product> removed = basket.removeProductsByName("Яблоки");
        System.out.println("Удалённые продукты:");
        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product p : removed) {
                System.out.println(p.getName());
            }
        }

        basket.printBasketContents();

        List<Product> removedNonExist = basket.removeProductsByName("Апельсины");
        System.out.println("Удалённые продукты:");
        if (removedNonExist.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product p : removedNonExist) {
                System.out.println(p.getName());
            }
        }

        basket.printBasketContents();

        List<Searchable> results = Arrays.asList(
                new SimpleProduct("Яблоки", 45),
                new SimpleProduct("Яйцо", 54),
                new SimpleProduct("Шоколад", 120)
        );

        System.out.println("Результаты поиска:");
        if (results.isEmpty()) {
            System.out.println("Нет подходящих товаров");
        } else {
            for (Searchable item : results) {
                System.out.println(item.getSearchTerm());
            }
        }
    }
}