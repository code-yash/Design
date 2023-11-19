package com.mycompany.fitclub;

import com.mycompany.fitclub.managers.BookingManager;
import com.mycompany.fitclub.managers.ClassManager;
import com.mycompany.fitclub.managers.UserManager;
import com.mycompany.fitclub.models.Classes;
import com.mycompany.fitclub.models.User;

public class FitClub {

    public static void main(String[] args) {
        System.out.println("Hello User!");
        BookingManager bookingManager = BookingManager.getInstance();
        UserManager userManager = UserManager.getInstance();

        User user1 = userManager.registerUser("Yash");
        User user2 = userManager.registerUser("Shah");

        ClassManager classManager = ClassManager.getInstance();

        Classes classes1 = classManager.registerClass("YogaClass", "YOGA", 1, "12/12/2023 23:30:00", 30);

        bookingManager.bookClass(classes1, user1);
        bookingManager.bookClass(classes1, user2);
        bookingManager.cancelBooking(classes1, user1);
    }
}
