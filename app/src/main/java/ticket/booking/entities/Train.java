package ticket.booking.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainName;
    private String trainNo;
    private List<List<Integer>> seats;
    private Map<String, Date> stationTimes;
    private List<String> stations;
    private String trainInfo;

    public Train(String trainId, String trainName, String trainNo, List<List<Integer>> seats, Map<String, Date> stationTimes, List<String> stations, String trainInfo) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.trainNo = trainNo;
        this.seats = seats;
        this.stationTimes = stationTimes;
        this.stations = stations;
        this.trainInfo = "Train ID: " + this.trainId + " Train No: " + this.trainNo;
    }

    public Train() {}

    public String getTrainId() {
        return trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public Map<String, Date> getStationTimes() {
        return stationTimes;
    }

    public List<String> getStations() {
        return stations;
    }

    public String getTrainInfo() {
        return trainInfo;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public void setStationTimes(Map<String, Date> stationTimes) {
        this.stationTimes = stationTimes;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }
}
