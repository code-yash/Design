package com.mycompany.fitclub.models;

import com.mycompany.fitclub.enumpack.Status;
import java.util.UUID;

public class Booking {

    private String bookingId;
    private String userId;
    private String classId;
    public Status status;

    public Booking(String userId, String classId) {
        this.bookingId = UUID.randomUUID().toString();
        this.userId = userId;
        this.classId = classId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getClassId() {
        return classId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
