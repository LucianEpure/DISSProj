package services;

import entities.TimeSheet;
import entities.User;

import java.util.List;

public interface TimeSheetService {

    public void insertTimeSheet(TimeSheet timeSheet);

    public List<TimeSheet> getTimeSheetByUser(User user);

}
