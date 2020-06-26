package controllers;

import converters.TimeSheetConverter;
import converters.UserTimeSheetConverter;
import dtos.TimeSheetDto;
import dtos.UserTimeSheetDto;
import entities.TimeSheet;
import entities.User;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.web.bind.annotation.*;
import services.TimeSheetService;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TimeSheetController {

    private TimeSheetService timeSheetService;
    private UserService userService;
    private TimeSheetConverter timeSheetConverter;
    private UserTimeSheetConverter userTimeSheetConverter;

    public TimeSheetController(TimeSheetService timeSheetService, UserService userService) {
       this.timeSheetService = timeSheetService;
       this.userService = userService;
       this.timeSheetConverter = new TimeSheetConverter();
       this.userTimeSheetConverter = new UserTimeSheetConverter();
   }

 //  @GetMapping("/timesheet")
//   public List<TimeSheet> getTimeSheet() {
//       return (List<TimeSheet>) timeSheetService.getAllTimeSheet();
//    }
//
//    @PostMapping("/timesheet")
//    public void checkIn(@RequestBody User user) {
//        timeSheetService.checkIn(user);
//    }
//
//    @PostMapping("/timesheet")
//    public void checkOut(@RequestBody User user) {
//        timeSheetService.checkOut(user);
//    }

    @GetMapping("/timesheetForEmployee/{username}")
    public List<UserTimeSheetDto> getAllTimeSheetForUser(@PathVariable String username) {
        List<TimeSheet> timeSheets = timeSheetService.getAllTimeSheetForUser(username);
        List<UserTimeSheetDto> displayedTimeSheets = new ArrayList<>();
        for(TimeSheet t: timeSheets){
            displayedTimeSheets.add(userTimeSheetConverter.convertToDto(t));
        }
        return displayedTimeSheets;
    }

//    @GetMapping("/timesheet")
//    public List<TimeSheet> getAllTimeSheetForUserBetweenDates(User user, Date startDate, Date endDate) {
//        return (List<TimeSheet>) timeSheetService.getAllTimeSheetForUserBetweenDates(User user, Date startDate, Date endDate);
//    }

   @GetMapping("/timesheetsForHr")
   public List<TimeSheetDto> getAllAttendanceForHR() {
        List<User> employees = userService.getUsers();
        List<TimeSheet> timeSheets = (List<TimeSheet>) timeSheetService.getAllAttendanceForHR(employees);
        List<TimeSheetDto> displayedTimeSheets = new ArrayList<>();
        for(TimeSheet timeSheet: timeSheets){
            displayedTimeSheets.add(timeSheetConverter.convertToDto(timeSheet));
        }
        return displayedTimeSheets;
   }

}

