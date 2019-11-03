package com.example.accompany;

import java.math.BigDecimal;

public class OrderPaymentModel
{
    private String Method;
    private BigDecimal Amount;

    public String getMethod(){
        return this.Method;
    }

    public void setMethod(String method){
        this.Method = method;
    }

    public BigDecimal getAmount(){
        return this.Amount;
    }

    public void setAmount(BigDecimal amount){
        this.Amount = amount;
    }
}
