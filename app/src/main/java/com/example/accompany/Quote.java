package com.example.accompany;

import java.math.BigDecimal;
import java.util.Date;

public class Quote
{
    private Date Created;
    private Date Start;
    private BigDecimal DistanceKm;
    private PriceModel Fee;
    private QuoteLocationDetail Pickup;
    private QuoteLocationDetail Dropoff;

    public Date getCreated(){
        return this.Created;
    }

    public void setCreated(Date created){
        this.Created = created;
    }

    public Date getStart(){
        return this.Start;
    }

    public void setStart(Date start){
        this.Start = start;
    }

    public BigDecimal getDistanceKm(){
        return this.DistanceKm;
    }

    public void setDistanceKm(BigDecimal distanceKm){
        this.DistanceKm = distanceKm;
    }

    public PriceModel getFee(){
        return  this.Fee;
    }

    public void setFee(PriceModel fee){
        this.Fee = fee;
    }

    public QuoteLocationDetail getPickup(){
        return this.Pickup;
    }

    public void setPickup(QuoteLocationDetail pickup){
        this.Pickup = pickup;
    }

    public QuoteLocationDetail getDropoff(){
        return this.Dropoff;
    }

    public void setDropoff(QuoteLocationDetail dropoff){
        this.Dropoff = dropoff;
    }
}
