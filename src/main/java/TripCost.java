public class TripCost {
    int getCost(int boardingTaxInRuble, int kilometerTaxInRuble, int tripDistanceInKm) {
        int ammount = boardingTaxInRuble + kilometerTaxInRuble * tripDistanceInKm;
        int discount = 0;
        if (ammount > 1000) {
            discount = Math.min(ammount * 5 / 100,100);
        }
        return ammount - discount;
    }
}
