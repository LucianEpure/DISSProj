package controllers;

import entities.TimeSheet;
import entities.User;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.web.bind.annotation.*;
import services.TimeSheetService;
import services.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TimeSheetController {

    private TimeSheetService timeSheetService;
    private UserService userService;

//    public TimeSheetController(TimeSheetService timeSheetService) {
//        this.timeSheetService = timeSheetService;
//    }

//    @GetMapping("/timesheet")
//    public List<TimeSheet> getTimeSheet() {
//        return (List<TimeSheet>) timeSheetService.getAllTimeSheet();
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

//    @GetMapping("/timesheet")
//    public List<TimeSheet> getAllTimeSheetForUser(User user) {
//        return (List<TimeSheet>) timeSheetService.getAllTimeSheetForUser(User user);
//    }

//    @GetMapping("/timesheet")
//    public List<TimeSheet> getAllTimeSheetForUserBetweenDates(User user, Date startDate, Date endDate) {
//        return (List<TimeSheet>) timeSheetService.getAllTimeSheetForUserBetweenDates(User user, Date startDate, Date endDate);
//    }

//    @GetMapping("/timesheet")
//    public List<TimeSheet> getAllAttendanceForHR() {
//        List<User> employees = userService.getUsers();
//        return (List<TimeSheet>) timeSheetService.getAllAttendanceForHR(employees);
//    }

}

