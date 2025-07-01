/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author it solution
 */
public class PaymentMethod {
    private String paymentMethod;     // e.g., "Khalti", "eSewa", "Stripe"
    private String accountNumber;     // Mobile wallet number or card number
    private boolean consent;          // User's confirmation for payment
    private int amount;               // Total ticket price
    private int totalTickets;         // Number of tickets booked
    private String seatNumbers;       // Comma-separated seat numbers, e.g. "A1,A2,A3"
    private String showTitle;         // Movie/show title
    private String transactionId;     // Optional: generated or received from payment gateway
    private String paymentStatus;     // "pending", "success", "failed"
    
    
    public PaymentMethod(String paymentMethod, String accountNumber, boolean consent, int amount, int totalTickets, String seatNumbers, String showTitle,String transactionId, String paymentStatus) {
        this.paymentMethod = paymentMethod;
        this.accountNumber = accountNumber;
        this.consent = consent;
        this.amount = amount;
        this.totalTickets = totalTickets;
        this.seatNumbers = seatNumbers;
        this.showTitle = showTitle;
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isConsent() {
        return consent;
    }

    public void setConsent(boolean consent) {
        this.consent = consent;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public String getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(String seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}


