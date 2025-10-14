package org.skypro.skyshop.product;
import org.skypro.skyshop.article.Searchable;

public abstract class Product implements Searchable {

    private String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }
    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract double getCostProduct();

    public abstract double getPrice();

    public abstract boolean isSpecial();

}