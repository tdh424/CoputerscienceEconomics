package com.reservation;

public class Booking {
    private String bookingID;
    private String startDate;
    private String endDate;
    private Client client;
    private Object item;

    public Booking(String bookingID, String startDate, String endDate, Client client, Object item) {
        this.bookingID = bookingID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.item = item;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingID + ", Client: " + client + ", Item: " + item + ", From: " + startDate + " To: " + endDate;
    }
}
