package com.reservation;

public class Client {
    private String clientID;
    private String name;
    private String birthDate;
    private String contactInfo;
    private MembershipType membership;

    public enum MembershipType {
        REGULAR(0), SILVER(10), GOLD(20);

        private int discount;

        MembershipType(int discount) {
            this.discount = discount;
        }

        public int getDiscount() {
            return discount;
        }
    }

    public Client(String clientID, String name, String birthDate, String contactInfo, MembershipType membership) {
        this.clientID = clientID;
        this.name = name;
        this.birthDate = birthDate;
        this.contactInfo = contactInfo;
        this.membership = membership;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public MembershipType getMembership() {
        return membership;
    }

    public void setMembership(MembershipType membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return name + " (ID: " + clientID + ", Membership: " + membership + ")";
    }
}
