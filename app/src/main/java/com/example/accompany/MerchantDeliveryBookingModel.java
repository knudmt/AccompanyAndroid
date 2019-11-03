package com.example.accompany;

public class MerchantDeliveryBookingModel
{
    private String ApiKey = "a6940c6c-4ef8-4fbd-b505-25838b94dba7";

    public String getApiKey(){
        return this.ApiKey;
    }

    public DeliveryBookingModel Booking;

    public void setDeliveryBookingModel(DeliveryBookingModel booking){
        this.Booking = booking;
    }

    public DeliveryBookingModel getDeliveryBookingModel(){
        return this.Booking;
    }
}
