package application;

import entities.Message;
import entities.Role;
import entities.TimeSheet;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.RoleRepository;
import services.MessageService;
import services.TimeSheetService;
import services.UserService;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class Bootstrap {
    private MessageService messageService;
    private RoleRepository roleRepository;
    private UserService userService;
    private TimeSheetService timeSheetService;
    @Autowired
    public Bootstrap(MessageService messageService, UserService userService, RoleRepository roleRepository, TimeSheetService timeSheetService){
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.messageService = messageService;
        this.timeSheetService = timeSheetService;
    }

    @PostConstruct
    private void initialize(){
      // initRoles();
       //initUsers();

      //addMessages();
       // seeMessages();

       //initAttendance();
    }

    private void initRoles() {
//        Role admin = new Role("ADMIN");
//        Role humanResources = new Role("HR");
//        Role employee = new Role("EMPLOYEE");
//        roleRepository.save(admin);
//        roleRepository.save(humanResources);
//        roleRepository.save(employee);
    }

    private void initUsers() {
//        User user1 = new User();
//        user1.setUsername("Admin1");
//        user1.setPassword("1234");
//        List<Role> user1Roles = new ArrayList<Role>();
//        Role user1Role = roleRepository.findByRoleName("ADMIN");
//        user1Roles.add(user1Role);
//        user1.setRoles(user1Roles);
//        userService.registerUser(user1);
//
//        User user2 = new User();
//        user2.setUsername("Gigel");
//        user2.setPassword("1234");
//        List<Role> user2Roles = new ArrayList<Role>();
//        Role user2Role = roleRepository.findByRoleName("HR");
//        user2Roles.add(user2Role);
//        user2.setRoles(user2Roles);
//        userService.registerUser(user2);
//
//        User user3 = new User();
//        user3.setUsername("Emp1");
//        user3.setPassword("1234");
//        List<Role> user3Roles = new ArrayList<Role>();
//        Role user3Role = roleRepository.findByRoleName("EMPLOYEE");
//        user3Roles.add(user3Role);
//        user3.setRoles(user3Roles);
//        userService.registerUser(user3);
//
//        User user4 = new User();
//        user4.setUsername("Emp2");
//        user4.setPassword("1234");
//        List<Role> user4Roles = new ArrayList<Role>();
//        Role user4Role = roleRepository.findByRoleName("EMPLOYEE");
//        user4Roles.add(user4Role);
//        user4.setRoles(user4Roles);
//        userService.registerUser(user4);
    }

    private void addMessages() {
        Message message1 = new Message();
        Message message2 = new Message();
        Message message3 = new Message();
        Message message4 = new Message();
        User sender = userService.findUser("Admin1");
        User receiver = userService.findUser("Gigel");
        User receiver2 = userService.findUser("Emp1");
        User receiver3 = userService.findUser("Emp2");
        message1.setAuthor(sender);
        message1.setContent("AAAAAAAAAAAAAAA");
        message1.setTitle("Message 1");
        message1.setMessageDate(new Date());

        List<User> receivers1 = new ArrayList<>();
        message1.setReceivers(receivers1);

        message2.setAuthor(sender);
        message2.setContent("AAAAAAAAAAAAAAA");
        message2.setTitle("Message 2");
        message2.setMessageDate(new Date());
        List<User> receivers2 = new ArrayList<>();
        message2.setReceivers(receivers2);

        message3.setAuthor(sender);
        message3.setContent("AAAAAAAAAAAAAAA");
        message3.setTitle("Message 3");
        message3.setMessageDate(new Date());
        List<User> receivers3 = new ArrayList<>();
        message3.setReceivers(receivers3);

        Message finalMessage1 = messageService.addReceiverToMessage(message1, receiver);
        finalMessage1 = messageService.addReceiverToMessage(finalMessage1, receiver2);
        messageService.sendMessage(finalMessage1);

        Message finalMessage2 = messageService.addReceiverToMessage(message2, receiver3);
        finalMessage2 = messageService.addReceiverToMessage(finalMessage2, receiver2);
        messageService.sendMessage(finalMessage2);

        Message finalMessage3 = messageService.addReceiverToMessage(message3, receiver3);
        finalMessage3 = messageService.addReceiverToMessage(finalMessage3, receiver2);
        finalMessage3 = messageService.addReceiverToMessage(finalMessage3, receiver);
        messageService.sendMessage(finalMessage3);

    }

    private void seeMessages()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // use for date format
        User user1 = userService.findUser("Emp1");
        List<Message> messages1 = messageService.getMessages(user1);
        System.out.println("Emp 1:");
        for(Message m: messages1){
            System.out.println(m.getTitle());
            System.out.println(formatter.format(m.getMessageDate()));
        }

        System.out.println("Emp 2:");
        User user2 = userService.findUser("Emp2");
        List<Message> messages2 = messageService.getMessages(user2);
        for(Message m: messages2){
            System.out.println(m.getTitle());
            System.out.println(formatter.format(m.getMessageDate()));
        }
    }

    private void initAttendance() {
        User user1 = userService.findUser("Gigel");
        User user2 = userService.findUser("Emp1");
        User user3 = userService.findUser("Emp2");
        Date date = null;
        TimeSheet timeSheet1 = new TimeSheet();
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-20 09:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet1.setStart(date);
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-20 17:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet1.setEnd(date);
        timeSheet1.setWorkedHours("08:00");
        timeSheetService.insertTimeSheet(timeSheet1);

        TimeSheet timeSheet2 = new TimeSheet();
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-21 09:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet2.setStart(date);
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-21 17:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet2.setEnd(date);
        timeSheet2.setWorkedHours("08:00");
        timeSheetService.insertTimeSheet(timeSheet2);

        List<TimeSheet> attendance1 = new ArrayList<TimeSheet>();
        attendance1.add(timeSheet1);
        attendance1.add(timeSheet2);
        user1.setAttendance(attendance1);
        userService.addAttendance(user1);

        TimeSheet timeSheet3 = new TimeSheet();
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-22 09:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet3.setStart(date);
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-22 17:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet3.setEnd(date);
        timeSheet3.setWorkedHours("08:00");
        timeSheetService.insertTimeSheet(timeSheet3);

        TimeSheet timeSheet4 = new TimeSheet();
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-23 09:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet4.setStart(date);
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-23 17:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet4.setEnd(date);
        timeSheet4.setWorkedHours("08:00");
        timeSheetService.insertTimeSheet(timeSheet4);

        List<TimeSheet> attendance2 = new ArrayList<TimeSheet>();
        attendance2.add(timeSheet3);
        attendance2.add(timeSheet4);
        user2.setAttendance(attendance2);
        userService.addAttendance(user2);

        TimeSheet timeSheet5 = new TimeSheet();
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-24 09:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet5.setStart(date);
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-24 17:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet5.setEnd(date);
        timeSheet5.setWorkedHours("08:00");
        timeSheetService.insertTimeSheet(timeSheet5);

        TimeSheet timeSheet6 = new TimeSheet();
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-25 09:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet6.setStart(date);
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-25 17:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet6.setEnd(date);
        timeSheet6.setWorkedHours("08:00");
        timeSheetService.insertTimeSheet(timeSheet6);

        TimeSheet timeSheet7 = new TimeSheet();
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-25 09:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet7.setStart(date);
        try {
            date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").parse("2020-06-25 17:45:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeSheet7.setEnd(date);
        timeSheet7.setWorkedHours("08:00");
        timeSheetService.insertTimeSheet(timeSheet7);

        List<TimeSheet> attendance3 = new ArrayList<TimeSheet>();
        attendance3.add(timeSheet5);
        attendance3.add(timeSheet6);
        attendance3.add(timeSheet7);
        user3.setAttendance(attendance3);
        userService.addAttendance(user3);
    }

}
