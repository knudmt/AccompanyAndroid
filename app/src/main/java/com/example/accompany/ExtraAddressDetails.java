package com.example.accompany;

import java.math.BigDecimal;

public class ExtraAddressDetails
{
    private String StateProvince;
    private String Country;
    private String SuburbLocality;
    private String Postcode;
    private BigDecimal Latitude;
    private BigDecimal Longitude;

    public String getStateProvince(){
        return this.StateProvince;
    }

    public void setStateProvince(String stateProvince){
        this.StateProvince = stateProvince;
    }

    public String getCountry(){
        return this.Country;
    }

    public void setCountry(String country){
        this.Country = country;
    }

    public String getSuburbLocality(){
        return this.SuburbLocality;
    }

    public void setSuburbLocality(String suburbLocality){
        this.SuburbLocality = suburbLocality;
    }

    public String getPostcode(){
        return this.Postcode;
    }

    public void setPostcode(String postcode){
        this.Postcode = postcode;
    }

    public BigDecimal getLatitude(){
        return this.Latitude;
    }

    public void setLatitude(BigDecimal latitude){
        this.Latitude = latitude;
    }

    public BigDecimal getLongitude(){
        return this.Longitude;
    }

    public void setLongitude(BigDecimal longitude){
        this.Longitude = longitude;
    }
}
