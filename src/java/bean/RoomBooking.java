/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

public class RoomBooking {
    private String booking_no;
    private String b_date;
    private String room_no;
    private String cust_name;
    private String address;
    private String gender;
    private String contact_no ;
    private String nationality;
    private String purpose;
    private int occupancy;
    private int days;
    private String status;

    public RoomBooking(String booking_no, String b_date, String room_no, String cust_name, String address, String gender, String contact_no, String nationality, String purpose, int occupancy, int days, String status) {
        this.booking_no = booking_no;
        this.b_date = b_date;
        this.room_no = room_no;
        this.cust_name = cust_name;
        this.address = address;
        this.gender = gender;
        this.contact_no = contact_no;
        this.nationality = nationality;
        this.purpose = purpose;
        this.occupancy = occupancy;
        this.days = days;
        this.status = status;
    }

    public String getBooking_no() {
        return booking_no;
    }

    public String getB_date() {
        return b_date;
    }

    public String getRoom_no() {
        return room_no;
    }

    public String getCust_name() {
        return cust_name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getContact_no() {
        return contact_no;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPurpose() {
        return purpose;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public int getDays() {
        return days;
    }

    public String getStatus() {
        return status;
    }
    
  
    
}
