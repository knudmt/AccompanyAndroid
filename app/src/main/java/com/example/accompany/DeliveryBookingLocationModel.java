package com.example.accompany;

public class DeliveryBookingLocationModel
{
    private String Name;
    private String Phone;
    private String Email;
    private String Description;
    private String Address;
    private ExtraAddressDetails AdditionalAddressDetails;

    public String getName(){
        return this.Name;
    }

    public void setName(String name){
        this.Name = name;
    }

    public String getPhone(){
        return this.Phone;
    }

    public void setPhone(String phone){
        this.Phone = phone;
    }

    public String getEmail(){
        return this.Email;
    }

    public void setEmail(String email){
        this.Email = email;
    }

    public String getDescription(){
        return this.Description;
    }

    public void setDescription(String description){
        this.Description = description;
    }

    public String getAddress(){
        return this.Address;
    }

    public void setAddress(String address){
        this.Address = address;
    }

    public ExtraAddressDetails getAdditionalAddressDetails(){
        return this.AdditionalAddressDetails;
    }

    public void setAdditionalAddressDetails(ExtraAddressDetails additionalAddressDetails){
        this.AdditionalAddressDetails = additionalAddressDetails;
    }
}
