public class TripCost {
    int getCost(int boardingTaxInRuble, int kilometerTaxInRuble, int tripDistanceInKm) {
        int amount = boardingTaxInRuble + kilometerTaxInRuble * tripDistanceInKm;
        int discount = 0;
        int maxDiscountInRuble = 100;
        int discountInPercent = 5;
        int minAmountForDiscount = 1000;
        if (amount > minAmountForDiscount) {
            discount = Math.min(amount * discountInPercent / 100, maxDiscountInRuble);
        }
        return amount - discount;
    }
}
