package com.example.accompany;

public class QuoteResponse
{
    private Quote Quote;
    private DeliveryBookingModel Request;

    public Quote getQuote(){
        return this.Quote;
    }

    public void setQuote(Quote quote){
        this.Quote = quote;
    }

    public DeliveryBookingModel getRequest(){
        return this.Request;
    }

    public void setRequest(DeliveryBookingModel request){
        this.Request = request;
    }
}
