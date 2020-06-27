package converters;

import dtos.TimeSheetDto;
import entities.TimeSheet;

public class TimeSheetConverter {

    public TimeSheetDto convertToDto(TimeSheet timeSheet){
        TimeSheetDto timeSheetDto = new TimeSheetDto();
        timeSheetDto.setUsername(timeSheet.getEmployee().getUsername());
        if (timeSheet.getStart() != null) {
            timeSheetDto.setStartDate(timeSheet.getStart().toString());
        }
        else {
            timeSheetDto.setStartDate(" - ");
        }
        if (timeSheet.getEnd() != null) {
            timeSheetDto.setEndDate(timeSheet.getEnd().toString());
        }
        else {
            timeSheetDto.setEndDate(" - ");
        }
        if (timeSheet.getWorkedHours() != null) {
            timeSheetDto.setWorkedHours(timeSheet.getWorkedHours());
        }
        else {
            timeSheetDto.setWorkedHours(" - ");
        }
        return timeSheetDto;
    }
}
