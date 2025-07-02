/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import com.stripe.Stripe;

/**
 *
 * @author anish
 */
public class StripeConfig {
    public static void init(){
        Stripe.apiKey = "Stripe_api_key";
    }
}
