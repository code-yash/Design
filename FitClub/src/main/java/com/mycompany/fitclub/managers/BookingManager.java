package com.mycompany.fitclub.managers;

import com.mycompany.fitclub.models.Classes;
import com.mycompany.fitclub.models.User;

public class BookingManager {

    private static volatile BookingManager bookingManagerInstance;
    ClassManager classManager = ClassManager.getInstance();
    UserManager userManager = UserManager.getInstance();

    public static BookingManager getInstance() {

        if (bookingManagerInstance == null) {
            synchronized (BookingManager.class) {
                if (bookingManagerInstance == null) {
                    return new BookingManager();
                }
            }
        }
        return bookingManagerInstance;
    }

    public int bookClass(Classes classes, User user) {
        if (classManager.isClassFull(classes)) {
            classManager.addWaitingUser(classes, user);
            System.out.println("Class for " + user.getUserName() + " NOT BOOKED, SENT TO WAITING");
            return 1;
        } else {
            classManager.addclassBooking(classes, user);
            System.out.println("Class for " + user.getUserName() + " Booked!");
            return 0;
        }
    }

    public void cancelBooking(Classes classes, User user) {
        classManager.cancelClassBooking(classes, user);
        User newUser = classManager.getWaitingUser(classes);
        bookClass(classes, newUser);
    }
}
