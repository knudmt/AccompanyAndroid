package com.example.accompany;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDataCreator
{
    public static MerchantDeliveryBookingModel CreateTestBooking()
    {
        MerchantDeliveryBookingModel bookingModel = new MerchantDeliveryBookingModel();
        bookingModel.Booking = CreateTestDeliveryBookingModel();

        Log.d("BOOKING", bookingModel.toString());
        return bookingModel;
    }

    private static DeliveryBookingModel CreateTestDeliveryBookingModel()
    {
        DeliveryBookingModel model = new DeliveryBookingModel();
        model.setReference("Testing Auto Gen Android");
        model.setDeliveryInstructions("Terminal B, Gate 26");
        model.setItemsRequirePurchase(false);
        /* Create DeliveryBookingItemModel */
        DeliveryBookingItemModel[] items = new DeliveryBookingItemModel[2];
        DeliveryBookingItemModel itemA = new DeliveryBookingItemModel();
        itemA.setQuanity(1);
        itemA.setSku("123456-456716-16456");
        itemA.setDescription("Veggie Burger");
        itemA.setPrice(new BigDecimal("12.3"));
        items[0] = itemA;
        DeliveryBookingItemModel itemB = new DeliveryBookingItemModel();
        itemB.setQuanity(1);
        itemB.setSku("54564-156461-456465");
        itemB.setDescription("Frise");
        itemB.setPrice(new BigDecimal("3.75"));
        items[1] = itemB;
        /* set items */
        model.setItems(items);
        final long HOUR = 3600*1000;
        model.setPickupTime(new Date(System.currentTimeMillis() + 1 * HOUR));

        /* delivery booking location model */
        DeliveryBookingLocationModel location = new DeliveryBookingLocationModel();
        location.setName("Matthew Knudsen");
        location.setPhone("404-218-4578");
        location.setEmail("knudmt@outlook.com");
        location.setDescription("1st time user matt");

        ExtraAddressDetails addressDetails = new ExtraAddressDetails();
        addressDetails.setStateProvince("Georgia");
        addressDetails.setCountry("US");
        addressDetails.setSuburbLocality("Marietta");
        addressDetails.setPostcode("30062");
        addressDetails.setLatitude(new BigDecimal("34.011250"));
        addressDetails.setLongitude(new BigDecimal("-84.426736"));
        // add the address
        location.setAdditionalAddressDetails(addressDetails);
        // add all the address details
        model.setPickupDetail(location);

        TimeFrameModel dropoffWindow = new TimeFrameModel();

        dropoffWindow.setEarliestTime(new Date(System.currentTimeMillis() + 1 * HOUR));
        dropoffWindow.setLatestTime(new Date(System.currentTimeMillis() + 2 * HOUR));
        model.setDropoffWindow(dropoffWindow);

        model.setWebhooks(null);

        DeliveryBookingLocationModel dropoffDetail = new DeliveryBookingLocationModel();
        dropoffDetail.setName("Terminal B, Gate 26");
        dropoffDetail.setPhone("404-218-4578");
        dropoffDetail.setEmail("knudmt@outlook.com");
        dropoffDetail.setDescription("In the Airport, Gate B, Terminal 26");
        dropoffDetail.setAddress("6000 N Terminal Pkwy, Atlanta, GA 30320");

        ExtraAddressDetails deliveryDetails = new ExtraAddressDetails();
        deliveryDetails.setStateProvince("Georgia");
        deliveryDetails.setCountry("US");
        deliveryDetails.setSuburbLocality("Atlanta");
        deliveryDetails.setPostcode("30320");
        deliveryDetails.setLatitude(new BigDecimal("33.6407"));
        deliveryDetails.setLongitude(new BigDecimal("84.4277"));

        dropoffDetail.setAdditionalAddressDetails(deliveryDetails);
        model.setDropoffDetail(dropoffDetail);
        model.setCustomerFee(new BigDecimal("5.00"));
        model.setCustomerReference("Matthew Knudsen");
        model.setTax(new BigDecimal("3.54"));
        model.setTaxInclusivePrice(false);
        model.setTip(new BigDecimal("3.00"));
        model.setDriverFeePercentage(new BigDecimal("3.5"));
        model.setDriverMatchCode("50399");
        model.setDeliverySequence(1);

        JobConstraintModel[] constraints = new JobConstraintModel[1];
        JobConstraintModel constraint = new JobConstraintModel();
        constraint.setName("Delivery");
        constraint.setValue("Must be able to enter airport");
        constraints[0] = constraint;
        model.setConstraints(constraints);
        model.setDeliveryRouteIdentifier("nothing");
        model.setWebhooks(null);
        model.setTemplate("Testing Template");
        model.setOrderPrice(new BigDecimal("27.57"));
        OrderPaymentModel paymentModel = new OrderPaymentModel();
        paymentModel.setMethod("2");
        paymentModel.setAmount(new BigDecimal("27.57"));

        model.setPayments(paymentModel);
        Log.d("INFO", "created Swift Model");
        return model;
    }
}
