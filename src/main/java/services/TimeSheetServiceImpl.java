package services;

import entities.Role;
import entities.TimeSheet;
import entities.User;
import org.hibernate.internal.util.ZonedDateTimeComparator;
import org.springframework.stereotype.Service;
import repositories.TimeSheetRepository;
import repositories.UserRepository;
import sun.jvm.hotspot.utilities.Interval;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeSheetServiceImpl implements TimeSheetService{

    private TimeSheetRepository timeSheetRepository;
    private UserRepository userRepository;

    public TimeSheetServiceImpl(TimeSheetRepository timeSheetRepository, UserRepository userRepository){
        this.timeSheetRepository = timeSheetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void insertTimeSheet(TimeSheet timeSheet) {
        timeSheetRepository.save(timeSheet);
    }

    @Override
    public List<TimeSheet> getTimeSheetByUser(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        List<TimeSheet> timeSheetList = timeSheetRepository.findAll();
        List<TimeSheet> attendance = new ArrayList<>();
        if (timeSheetList != null) {
            for (TimeSheet presence : timeSheetList) {
                if(presence.getEmployee().getId() == dbUser.getId()) {
                    attendance.add(presence);
                }
            }
        }
        return attendance;
    }

    @Override
    public List<TimeSheet> getAllTimeSheet() {
        List<TimeSheet> timeSheetList = timeSheetRepository.findAll();
        return timeSheetList;
    }

    @Override
    public Boolean alreadyCheckedIn(User user) {
        List<TimeSheet> attendance = getTimeSheetByUser(user);
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if (attendance != null) {
            for (TimeSheet t:attendance) {
                if (sdf.format(today).equals(sdf.format(t.getStart()))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public TimeSheet getTimeSheetByDateAndUser(Date date, User user) {
        List<TimeSheet> attendance = getTimeSheetByUser(user);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        TimeSheet timeSheet = null;
        if (attendance != null) {
            for (TimeSheet t:attendance) {
                if (sdf.format(date).equals(sdf.format(t.getStart()))) {
                    timeSheet = t;
                }
            }
        }
        return timeSheet;
    }

    @Override
    public void checkIn(User user) {
        if (alreadyCheckedIn(user) == false) {
            TimeSheet timeSheet = new TimeSheet();
            timeSheet.setStart(new Date());
            timeSheet.setEmployee(user);
            insertTimeSheet(timeSheet);
        }
    }

    @Override
    public void checkOut(User user) {
        if (alreadyCheckedIn(user) == true) {
            TimeSheet timeSheet = getTimeSheetByDateAndUser(new Date(), user);
            timeSheet.setEnd(new Date());
            long diff = timeSheet.getEnd().getTime() - timeSheet.getStart().getTime();
            long diffMinutes = diff / (60 * 1000);
            long diffHours = diff / (60 * 60 * 1000);
            String hours = "";
            String minutes = "";
            if (diffHours < 10) {
                hours = hours + "0";
            }
            hours = hours + diffHours;
            if (diffMinutes < 10) {
                minutes = minutes + "0";
            }
            minutes = minutes + diffMinutes;
            String workedHours = hours + ":" + minutes;
            timeSheet.setWorkedHours(workedHours);
            insertTimeSheet(timeSheet);
        }
    }
}
