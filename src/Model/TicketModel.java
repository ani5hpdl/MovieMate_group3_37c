package Model;

public class TicketModel {

    private String movieName;
    private String duration;
    private String date;
    private String time;
    private String seatNo;
    private String ticketId;
    private String theaterNo;
    private String vat;
    private String totalAmount;

    public TicketModel() {}

    public TicketModel(String movieName, String duration, String date, String time, String seatNo,
                       String ticketId, String theaterNo, String vat, String totalAmount) {
        this.movieName = movieName;
        this.duration = duration;
        this.date = date;
        this.time = time;
        this.seatNo = seatNo;
        this.ticketId = ticketId;
        this.theaterNo = theaterNo;
        this.vat = vat;
        this.totalAmount = totalAmount;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getTheaterNo() {
        return theaterNo;
    }

    public String getVat() {
        return vat;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setTheaterNo(String theaterNo) {
        this.theaterNo = theaterNo;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
