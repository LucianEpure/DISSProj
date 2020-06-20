package services;

import entities.TimeSheet;
import org.springframework.stereotype.Service;
import repositories.TimeSheetRepository;

@Service
public class TimeSheetServiceImpl implements TimeSheetService{

    private TimeSheetRepository timeSheetRepository;

    public TimeSheetServiceImpl(TimeSheetRepository timeSheetRepository){
        this.timeSheetRepository = timeSheetRepository;
    }

    @Override
    public void insertTimeSheet(TimeSheet timeSheet) {

        timeSheetRepository.save(timeSheet);
    }
}
