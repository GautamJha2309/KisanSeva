package com.example.sih_v2.retailer;

public class post {
    String Address;
    String  Agency_name;
    String Contact;
    long Dealer_ID;
    String District;
    String Person_Name;
    String State;

    //Primary constructor
    //Enter->Generate->Constructor->select none
    public post() {

    }
    //Method to string()
    //Enter->Generate->toString()->select all values and press OK

    @Override
    public String toString() {
        return "post{" +
                "Address='" + Address + '\'' +
                ", Agency_name='" + Agency_name + '\'' +
                ", contact='" + Contact + '\'' +
                ", Dealer_ID='" + Dealer_ID + '\'' +
                ", District='" + District + '\'' +
                ", Person_Name='" + Person_Name + '\'' +
                ", State='" + State + '\'' +
                '}';
    }

    //Getter n Setter for all
    // Enter->Generate->Getter Setter->Select all values and press OK

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAgency_name() {
        return Agency_name;
    }

    public void setAgency_name(String agency_name) {
        Agency_name = agency_name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public long getDealer_ID() {
        return Dealer_ID;
    }

    public void setDealer_ID(long dealer_ID) {
        Dealer_ID = dealer_ID;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getPerson_Name() {
        return Person_Name;
    }

    public void setPerson_Name(String person_Name) {
        Person_Name = person_Name;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
