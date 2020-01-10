package com.example.accompany;

import java.math.BigDecimal;

public class PriceModel
{
    private BigDecimal Cost;
    private int CostCents;

    public BigDecimal getCost(){
        return this.Cost;
    }

    public void setCost(BigDecimal cost){
        this.Cost = cost;
    }

    public int getCostCents(){
        return this.CostCents;
    }

    public void setCostCents(int costCents){
        this.CostCents = costCents;
    }
}
