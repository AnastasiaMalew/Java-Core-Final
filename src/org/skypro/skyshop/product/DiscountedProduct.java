package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    public double basePrice;
    public int discount;

    public DiscountedProduct(String name, int discount, double basePrice) {
        super(name);
        this.discount = discount;
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public double getCostProduct() {
        return basePrice - (basePrice * discount / 100);
    }

    @Override
    public double getPrice() {
        return basePrice - (basePrice * discount / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
