package ticket.booking.entities;

import java.util.List;

public class Users {
    private String UserName;
    private String userId;
    private String password;
    private String hashedPassword;
    private String emailId;
    private List<Ticket> ticketbook;

    public Users(String name, String password, String hashedPassword, List<Ticket> ticketsBooked, String userId, String emailId) {
        this.UserName = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.ticketbook = ticketsBooked;
        this.userId = userId;
        this.emailId = emailId;
    }

    public Users() {}

    public String getName() {
        return UserName;
    }

    public String getPassword() {
        return password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public List<Ticket> getTicketbook() {
        return ticketbook;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmailId() {
        return emailId;
    }


//    public void printTickets(){
//        for (Ticket ticket : ticketbook) {
//            System.out.println(ticket.getTicketInfo());
//        }
//    }


    public void setName(String name) {
        this.UserName = name;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        this.ticketbook = ticketsBooked;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
