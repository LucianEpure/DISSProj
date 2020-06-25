package converters;

import dtos.TimeSheetDto;
import entities.TimeSheet;

public class TimeSheetConverter {

    public TimeSheetDto convertToDto(TimeSheet timeSheet){
        TimeSheetDto timeSheetDto = new TimeSheetDto();
        timeSheetDto.setUsername(timeSheet.getEmployee().getUsername());
        timeSheetDto.setStartDate(timeSheet.getStart().toString());
        timeSheetDto.setEndDate(timeSheet.getEnd().toString());
        timeSheetDto.setWorkedHours(timeSheet.getWorkedHours());
        return timeSheetDto;
    }
}
