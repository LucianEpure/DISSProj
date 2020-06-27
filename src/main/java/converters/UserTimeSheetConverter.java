package converters;

import dtos.TimeSheetDto;
import dtos.UserTimeSheetDto;
import entities.TimeSheet;

public class UserTimeSheetConverter {

    public UserTimeSheetDto convertToDto(TimeSheet timeSheet){
        UserTimeSheetDto usertimeSheetDto = new UserTimeSheetDto();
        usertimeSheetDto.setStartDate(timeSheet.getStart().toString());
        usertimeSheetDto.setEndDate(timeSheet.getEnd().toString());
        usertimeSheetDto.setWorkedHours(timeSheet.getWorkedHours());
        return usertimeSheetDto;
    }
}
