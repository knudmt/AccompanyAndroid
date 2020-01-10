package com.example.accompany;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.List;

public class AppDelivery
{
    @SerializedName("User")
    @Expose
    private AppUser User;

    @SerializedName("Items")
    @Expose
    private List<AppItems> Items = null;

    @SerializedName("Instructions")
    @Expose
    private String Instructions;

    @SerializedName("ConcessionName")
    @Expose
    private String ConcessionName;

    @SerializedName("Total")
    @Expose
    private BigDecimal Total;

    public AppUser getUser(){
        return this.User;
    }

    public void setUser(AppUser user)
    {
        this.User = user;
    }

    public List<AppItems> getItems()
    {
        return this.Items;
    }

    public void setItems(List<AppItems> items){
        this.Items = items;
    }

    public String getInstructions(){
        return this.Instructions;
    }

    public void setInstructions(String instructions){
        this.Instructions = instructions;
    }

    public String getConcessionName(){
        return this.ConcessionName;
    }

    public void setConcessionName(String concessionName){
        this.ConcessionName = concessionName;
    }

    public BigDecimal getTotal(){
        return this.Total;
    }

    public void setTotal(BigDecimal total){
        this.Total = total;
    }
}
