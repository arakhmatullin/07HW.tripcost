public class TripCost {
    int getCost(int boardingTaxInRubl, int kilometerTaxInRubl, int tripDistanceInKm) {
        int ammount = boardingTaxInRubl + kilometerTaxInRubl * tripDistanceInKm;
        int discount = 0;
        if (ammount > 1000) {
            discount = ammount * 5 / 100;
            if (discount > 100) {
                discount = 100;
            }
        }
        return ammount - discount;
    }
}
