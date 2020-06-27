package services;

import entities.TimeSheet;
import entities.User;

import java.util.Date;
import java.util.List;

public interface TimeSheetService {

    public void insertTimeSheet(TimeSheet timeSheet);

    public List<TimeSheet> getTimeSheetByUser(String username);

    public List<TimeSheet> getAllTimeSheet();

    public void checkIn(String user);

    public void checkOut(String user);

    public Boolean alreadyCheckedIn(String user);

    public TimeSheet getTimeSheetByDateAndUser(Date date, User user);

    public List<TimeSheet> getAllTimeSheetForUser(String username);

    public List<TimeSheet> getAllTimeSheetForUserBetweenDates(User user, Date startDate, Date endDate);

    public List<TimeSheet> getAllAttendanceForHR(List<User> employees);

    public TimeSheet getTimeSheetWithBiggestDate(List<TimeSheet> timeSheets);

}
