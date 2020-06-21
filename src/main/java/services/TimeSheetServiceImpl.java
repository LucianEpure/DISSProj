package services;

import entities.TimeSheet;
import entities.User;
import org.springframework.stereotype.Service;
import repositories.TimeSheetRepository;
import repositories.UserRepository;
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
    public List<TimeSheet> getTodayTimeSheet() {
        Date today = new Date();
        List<TimeSheet> dbTimeSheet = timeSheetRepository.findByDate(today);
        return dbTimeSheet;
    }

    @Override
    public List<TimeSheet> getTimeSheetByUser(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        return dbUser.getAttendance();
    }
}
