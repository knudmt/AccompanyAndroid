package com.example.accompany;

import java.math.BigDecimal;

public class AppUser
{
    private String UserName;
    private String Phone;
    private String Email;
    private String Terminal;
    private String Gate;
    private BigDecimal Tip;

    public AppUser(String user, String phone, String email, String terminal, String gate, BigDecimal tip){
        this.UserName = user;
        this.Phone = phone;
        this.Email = email;
        this.Terminal = terminal;
        this.Gate = gate;
        this.Tip = tip;
    }

    public String getUserName(){
        return this.UserName;
    }

    public void setUserName(String username){
        this.UserName = username;
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

    public String getTerminal(){
        return this.Terminal;
    }

    public void setTerminal(String terminal){
        this.Terminal = terminal;
    }

    public String getGate(){
        return this.Gate;
    }

    public void setGate(String gate){
        this.Gate = gate;
    }

    public BigDecimal getTip(){
        return this.Tip;
    }

    public void setTip(BigDecimal tip){
        this.Tip = tip;
    }
}
