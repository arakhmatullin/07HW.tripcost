package ru.itpark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripCostTest {
    @Test
    void getCostWithoutDiscount(){
        TripCost tripCost = new TripCost(100,20,100,5,1000);
        int amount = tripCost.getCost(5);
        assertEquals(200,amount);
    }
    @Test
    void getCostWithDiscount(){
        TripCost tripCost = new TripCost(100,20,100,5,1000);
        int amount = tripCost.getCost(25);
        assertEquals(600,amount);

    }
    @Test
    void getCostWithMaxDiscount(){
        TripCost tripCost = new TripCost(100,20,100,5,1000);
        int amount = tripCost.getCost(50);
        assertEquals(1045,amount);

    }
    @Test
    void negativeBoardingTaxInRubleWithoutDiscount(){
        TripCost tripCost = new TripCost(-100,20,100,5,1000);
        int amount = tripCost.getCost(4);
        assertEquals(0,amount);
    }
    @Test
    void negativeKilometerTaxInRuble(){
        TripCost tripCost = new TripCost(100,-20,100,5,1000);
        int amount = tripCost.getCost(6);
        assertEquals(100,amount);
    }
    @Test
    void negativeMaxDiscountInRuble(){
        TripCost tripCost = new TripCost(100,20,-100,5,1000);
        int amount = tripCost.getCost(50);
        assertEquals(1100,amount);
    }
    @Test
    void discountInPercentLessZero(){
        TripCost tripCost = new TripCost(100,20,100,-5,1000);
        int amount = tripCost.getCost(50);
        assertEquals(1100,amount);
    }
    @Test
    void discountInPercentMore100(){
        TripCost tripCost = new TripCost(100,20,100,150,1000);
        int amount = tripCost.getCost(50);
        assertEquals(1000,amount);
    }
    @Test
    void negativeMinAmountForDiscount(){
        TripCost tripCost = new TripCost(100,20,100,5,-1000);
        int amount = tripCost.getCost(5);
        assertEquals(190,amount);
    }
}
