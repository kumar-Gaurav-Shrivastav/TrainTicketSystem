package ticket.booking.entities;

import java.util.Date;
import java.util.List;

public class Ticket {
    private String TicketId;
    private String seatNo;
    private String userId;
    private String origin;
    private String destination;
    private Date dateOfTravel;
    private Train train;
    private String ticketInfo;

    public Ticket(String ticketId, String seatNo, String userId, String origin, String destination, Date dateOfTravel, Train train, String ticketInfo) {
        this.TicketId = ticketId;
        this.seatNo = seatNo;
        this.userId = userId;
        this.origin = origin;
        this.destination = destination;
        this.dateOfTravel = dateOfTravel;
        this.train = train;
        this.ticketInfo = ticketInfo;   
    }

    public Ticket() {}

    public String getTicketId() {
        return TicketId;
    }
    public String getSeatNo() {
        return seatNo;
    }
    public String getUserId() {
        return userId;
    }
    public String getOrigin() {
        return origin;
    }
    public String getDestination() {
        return destination;
    }
    public Train getTrain() {
        return train;
    }

    public String getTicketInfo() {
        return ticketInfo;
    }

    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setTicketId(String TicketId) {
         this.TicketId = TicketId;
    }
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void getDestination(String destination) {
        this.destination = destination;
    }
    public void setTrain(Train train) {
        this.train = train;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

}
