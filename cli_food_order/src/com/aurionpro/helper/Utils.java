package com.aurionpro.helper;

import java.util.Random;

public class Utils {
    private static final String[] deliveryPartners = { "Swiggy", "Zomato" };

    public static String assignRandomDeliveryPartner() {
        Random rand = new Random();
        return deliveryPartners[rand.nextInt(deliveryPartners.length)];
    }
}
