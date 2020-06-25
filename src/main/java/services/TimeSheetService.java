package services;

import entities.TimeSheet;
import entities.User;

import java.util.Date;
import java.util.List;

public interface TimeSheetService {

    public void insertTimeSheet(TimeSheet timeSheet);

    public List<TimeSheet> getTimeSheetByUser(User user);

    public List<TimeSheet> getAllTimeSheet();

    public void checkIn(User user);

    public void checkOut(User user);

    public Boolean alreadyCheckedIn(User user);

    public TimeSheet getTimeSheetByDateAndUser(Date date, User user);

}
