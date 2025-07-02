/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author anish
 */

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import util.StripeConfig;

public class CheckoutController {

    public static String createCheckoutSession() {
        StripeConfig.init(); // Set your API key

        SessionCreateParams params = SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl("http://localhost:4242/success")
            .setCancelUrl("http://localhost:4242/cancel")
            .addLineItem(
                SessionCreateParams.LineItem.builder()
                    .setQuantity(1L)
                    .setPriceData(
                        SessionCreateParams.LineItem.PriceData.builder()
                            .setCurrency("usd")
                            .setUnitAmount(5000L) // $50
                            .setProductData(
                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                    .setName("Movie Ticket")
                                    .build())
                            .build())
                    .build())
            .build();

        try {
            Session session = Session.create(params);
            return session.getUrl(); // Return the Stripe-hosted checkout page
        } catch (StripeException e) {
            return "Error: " + e.getMessage();
        }
    }
}
