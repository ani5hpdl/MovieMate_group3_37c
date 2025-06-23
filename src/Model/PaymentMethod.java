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


public class Payment {

    private int totalTickets;
    private String seatNo;
    private double amount;
    private String paymentMethod;
    private String selectedShowTitle;
    private String selectedShowImagePath; 
    private String qrCodePath; 

    
    public Payment(int totalTickets, String seatNo, double amount, String paymentMethod, String selectedShowTitle, String selectedShowImagePath, String qrCodePath) {
        this.totalTickets = totalTickets;
        this.seatNo = seatNo;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.selectedShowTitle = selectedShowTitle;
        this.selectedShowImagePath = selectedShowImagePath;
        this.qrCodePath = qrCodePath;
    }

    
    public Payment() {
    }

    
    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getSelectedShowTitle() {
        return selectedShowTitle;
    }

    public void setSelectedShowTitle(String selectedShowTitle) {
        this.selectedShowTitle = selectedShowTitle;
    }

    public String getSelectedShowImagePath() {
        return selectedShowImagePath;
    }

    public void setSelectedShowImagePath(String selectedShowImagePath) {
        this.selectedShowImagePath = selectedShowImagePath;
    }

    public String getQrCodePath() {
        return qrCodePath;
    }

    public void setQrCodePath(String qrCodePath) {
        this.qrCodePath = qrCodePath;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "totalTickets=" + totalTickets +
                ", seatNo='" + seatNo + '\'' +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", selectedShowTitle='" + selectedShowTitle + '\'' +
                ", selectedShowImagePath='" + selectedShowImagePath + '\'' +
                ", qrCodePath='" + qrCodePath + '\'' +
                '}';
    }
}

    
}
