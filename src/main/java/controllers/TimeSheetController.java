package controllers;

import entities.TimeSheet;
import entities.User;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.web.bind.annotation.*;
import services.TimeSheetService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TimeSheetController {

    private TimeSheetService timeSheetService;

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
}

