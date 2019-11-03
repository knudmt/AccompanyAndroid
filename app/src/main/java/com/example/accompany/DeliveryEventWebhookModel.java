package com.example.accompany;

public class DeliveryEventWebhookModel
{
    private String EventName;
    private String Url;

    public String getEventName(){
        return this.EventName;
    }

    public void setEventName(String eventName){
        this.EventName = eventName;
    }

    public String getUrl(){
        return this.Url;
    }

    public void setUrl(String url){
        this.Url = url;
    }
}
