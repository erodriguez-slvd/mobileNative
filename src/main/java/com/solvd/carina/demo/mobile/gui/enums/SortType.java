package com.solvd.carina.demo.mobile.gui.enums;

public enum SortType {
    PRICE_LOW_TO_HIGH("Price (low to high)"), PRICE_HIGH_TO_LOW("Price (high to low)"), AZ("Name (A to Z)"), ZA("Name (Z to A)");

    private final String sortType;

    SortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortType() {
        return sortType;
    }
}
