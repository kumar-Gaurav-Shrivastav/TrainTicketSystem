package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ticket.booking.entities.Train;
import ticket.booking.entities.Users;
import ticket.booking.utils.UserServiceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
    private Users user;
    private List<Users> userList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String USER_Path = "app/src/main/java/ticket/booking/localDb/user.json";

    public UserBookingService(Users user1) throws IOException {
        this.user = user1;
        File userFile = new File(USER_Path);
        userList = objectMapper.readValue(userFile, new TypeReference<List<Users>>() {
        });
    }

    public UserBookingService() throws IOException {
        File userFile = new File(USER_Path);
        userList = objectMapper.readValue(userFile, new TypeReference<List<Users>>() {
        });
    }

    public Boolean loginUser() {
        Optional<Users> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName())
                    && UserServiceUtils.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(Users user1) {
        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }

    public void saveUserListToFile() throws IOException {
        File file = new File(USER_Path);
        objectMapper.writeValue(file, userList);
    }

    public void fetchBooking() {
        user.printTickets();
    }

    public List<Train> fetchTrain(String source, String destination) {
        try {
            TrainBookingService trainBookingService = new TrainBookingService();
            return trainBookingService.searchTrains(source, destination);
            
        } catch (IOException ex) {
            return new ArrayList<>();
        }
    }

    public Boolean cancellbooking(String ticketId) {
        try {
            Optional<List<Users>> data = Optional.of(userList.stream().map(user1 -> {
                if (user1.getListTicketsBooked().contains(ticketId)) {
                    user1.getListTicketsBooked().remove(ticketId);
                }
                return user1;
            }).toList());
            if (data.isPresent()) {
                File newUserList = new File(USER_Path);
                objectMapper.writeValue(newUserList, userList);
            }
            return Boolean.TRUE;
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }

    public List<List<Integer>> fetchSeats(Train train){
            return train.getSeats();
    }

    public Boolean bookTrainSeat(Train train, int row, int seat) {
        try{
            TrainBookingService trainService = new TrainBookingService();
            List<List<Integer>> seats = train.getSeats();
            if (row >= 0 && row < seats.size() && seat >= 0 && seat < seats.get(row).size()) {
                if (seats.get(row).get(seat) == 0) {
                    seats.get(row).set(seat, 1);
                    train.setSeats(seats);
                    trainService.addTrain(train);
                    return true; // Booking successful
                } else {
                    return false; // Seat is already booked
                }
            } else {
                return false; // Invalid row or seat index
            }
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }

}
