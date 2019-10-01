package ru.itpark;

public class TripCost {
    private int boardingTaxInRuble;
    private int kilometerTaxInRuble;
    private int maxDiscountInRuble;
    private int discountInPercent;
    private int minAmountForDiscount;

    public TripCost(int boardingTaxInRuble, int kilometerTaxInRuble, int maxDiscountInRuble, int discountInPercent, int minAmountForDiscount) {
        setBoardingTaxInRuble(boardingTaxInRuble);
        setKilometerTaxInRuble(kilometerTaxInRuble);
        setMinAmountForDiscount(minAmountForDiscount);
        setMaxDiscountInRuble(maxDiscountInRuble);
        setDiscountInPercent(discountInPercent);
    }

    public void setBoardingTaxInRuble(int boardingTaxInRuble) {
        this.boardingTaxInRuble = boardingTaxInRuble;
    }

    public void setKilometerTaxInRuble(int kilometerTaxInRuble) {
        if (kilometerTaxInRuble < 0) {
            kilometerTaxInRuble = 0;
        }
        this.kilometerTaxInRuble = kilometerTaxInRuble;
    }

    public void setMaxDiscountInRuble(int maxDiscountInRuble) {
        if (maxDiscountInRuble < 0) {
            maxDiscountInRuble = 0;
        }
        this.maxDiscountInRuble = maxDiscountInRuble;
    }

    public void setDiscountInPercent(int discountInPercent) {
        if (discountInPercent < 0) {
            discountInPercent = 0;
        } else if (discountInPercent >= 100) {
            discountInPercent = 100;
        }
        this.discountInPercent = discountInPercent;
    }

    public void setMinAmountForDiscount(int minAmountForDiscount) {
        if (minAmountForDiscount < 0) {
            minAmountForDiscount = 0;
        }
        this.minAmountForDiscount = minAmountForDiscount;
    }

    public int getCost(int tripDistanceInKm) {
        int amount = boardingTaxInRuble + kilometerTaxInRuble * tripDistanceInKm;
        int discount = 0;
        if (amount > minAmountForDiscount) {
            discount = Math.min(amount * discountInPercent / 100, maxDiscountInRuble);
        }
        return Math.max(amount - discount, 0);
    }

}
