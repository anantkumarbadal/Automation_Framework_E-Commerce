package com.store.Utilities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class EmailGenerator {

    // Generate a unique email address based on timestamp
    public static String generateUniqueEmail() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        String email = "test_" + timestamp + "@mailinator.com";
        return email;
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println("Timestamp-based email: " + generateUniqueEmail());

    }


}
