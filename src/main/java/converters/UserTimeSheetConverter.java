package converters;

import dtos.TimeSheetDto;
import dtos.UserTimeSheetDto;
import entities.TimeSheet;

public class UserTimeSheetConverter {

    public UserTimeSheetDto convertToDto(TimeSheet timeSheet){
        UserTimeSheetDto usertimeSheetDto = new UserTimeSheetDto();
        if (timeSheet.getStart() != null) {
            usertimeSheetDto.setStartDate(timeSheet.getStart().toString());
        }
        else {
            usertimeSheetDto.setStartDate(" - ");
        }
        if (timeSheet.getEnd() != null) {
            usertimeSheetDto.setEndDate(timeSheet.getEnd().toString());
        }
        else {
            usertimeSheetDto.setEndDate(" - ");
        }
        if (timeSheet.getWorkedHours() != null) {
            usertimeSheetDto.setWorkedHours(timeSheet.getWorkedHours());
        }
        else {
            usertimeSheetDto.setWorkedHours(" - ");
        }

        return usertimeSheetDto;
    }
}
