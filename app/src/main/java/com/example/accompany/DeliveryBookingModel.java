package com.example.accompany;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeliveryBookingModel
{
    private String Reference;
    private String DeliveryInstructions;
    private Boolean ItemsRequirePurchase;
    private DeliveryBookingItemModel[] Items;
    private String PickupTime;
    private DeliveryBookingLocationModel PikupDetail;
    private TimeFrameModel DropoffWindow;
    private DeliveryBookingLocationModel DropoffDetail;
    private BigDecimal CustomerFee;
    private String CustomerReference;
    private BigDecimal Tax;
    private Boolean TaxInclusivePrice;
    private BigDecimal Tip;
    private BigDecimal DriverFeePercentage;
    private String DriverMatchCode;
    private int DeliverySequence;
    private JobConstraintModel[] Constraints;
    private String DeliveryRouteIdentifier;
    private DeliveryEventWebhookModel Webhooks;
    private String Template;
    private BigDecimal OrderPrice;
    private OrderPaymentModel Payments;
    private String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'";
    private SimpleDateFormat format = new SimpleDateFormat(pattern);

    public void setReference(String reference){
        this.Reference = reference;
    }

    public String getReference(){
        return this.Reference;
    }

    public void setDeliveryInstructions(String deliveryInstructions){
        this.DeliveryInstructions = deliveryInstructions;
    }

    public String getDeliveryInstructions(){
        return this.DeliveryInstructions;
    }

    public void setItemsRequirePurchase(Boolean itemsRequirePurchase){
        this.ItemsRequirePurchase = itemsRequirePurchase;
    }

    public Boolean getItemsRequirePurchase(){
        return this.ItemsRequirePurchase;
    }

    public void setItems(DeliveryBookingItemModel[] items){
        this.Items = items;
    }

    public DeliveryBookingItemModel[] getItems(){
        return this.Items;
    }

    public void setPickupTime(Date pickupTime) {
        PickupTime = format.format(pickupTime);
    }

    public String getPickupTime(){
        return PickupTime;
    }

    public void setPickupDetail(DeliveryBookingLocationModel pickupDetail){
        this.PikupDetail = pickupDetail;
    }

    public DeliveryBookingLocationModel getPickupDetail(){
        return this.PikupDetail;
    }

    public TimeFrameModel getDropoffWindow(){
        return this.DropoffWindow;
    }

    public void setDropoffWindow(TimeFrameModel dropoffWindow){
        this.DropoffWindow = dropoffWindow;
    }

    public DeliveryBookingLocationModel getDropoffDetail(){
        return this.DropoffDetail;
    }

    public void setDropoffDetail(DeliveryBookingLocationModel dropoffDetail){
        this.DropoffDetail = dropoffDetail;
    }

    public BigDecimal getCustomerFee(){
        return this.CustomerFee;
    }

    public void setCustomerFee(BigDecimal customerFee){
        this.CustomerFee = customerFee;
    }

    public String getCustomerReference(){
        return this.CustomerReference;
    }

    public void setCustomerReference(String customerReference){
        this.CustomerReference = customerReference;
    }

    public BigDecimal getTax(){
        return  this.Tax;
    }

    public void setTax(BigDecimal tax){
        this.Tax = tax;
    }

    public Boolean getTaxInclusivePrice(){
        return this.TaxInclusivePrice;
    }

    public void setTaxInclusivePrice(Boolean taxInclusivePrice){
        this.TaxInclusivePrice = taxInclusivePrice;
    }

    public BigDecimal getTip(){
        return this.Tip;
    }

    public void setTip(BigDecimal tip){
        this.Tip = tip;
    }

    public BigDecimal getDriverFeePercentage(){
        return this.DriverFeePercentage;
    }

    public void setDriverFeePercentage(BigDecimal driverFeePercentage){
        this.DriverFeePercentage = driverFeePercentage;
    }

    public String getDriverMatchCode(){
        return this.DriverMatchCode;
    }

    public void setDriverMatchCode(String driverMatchCode){
        this.DriverMatchCode = driverMatchCode;
    }

    public int getDeliverySequence(){
        return this.DeliverySequence;
    }

    public void setDeliverySequence(int deliverySequence){
        this.DeliverySequence = deliverySequence;
    }

    public JobConstraintModel[] getConstraints(){
        return this.Constraints;
    }

    public void setConstraints(JobConstraintModel[] constraints){
        this.Constraints = constraints;
    }

    public String getDeliveryRouteIdentifier(){
        return this.DeliveryRouteIdentifier;
    }

    public void setDeliveryRouteIdentifier(String deliveryRouteIdentifier){
        this.DeliveryRouteIdentifier = deliveryRouteIdentifier;
    }

    public DeliveryEventWebhookModel getWebhooks(){
        return this.Webhooks;
    }

    public void setWebhooks(DeliveryEventWebhookModel webhooks){
        this.Webhooks = webhooks;
    }

    public String getTemplate(){
        return this.Template;
    }

    public void setTemplate(String template){
        this.Template = template;
    }

    public BigDecimal getOrderPrice(){
        return this.OrderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice){
        this.OrderPrice = orderPrice;
    }

    public OrderPaymentModel getPayments(){
        return this.Payments;
    }

    public void setPayments(OrderPaymentModel payments){
        this.Payments = payments;
    }
}
