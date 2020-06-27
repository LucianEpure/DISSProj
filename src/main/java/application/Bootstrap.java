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
import java.time.Instant;
import java.util.*;

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
//       initRoles();
//       initUsers();
//
//       addMessages();
//       seeMessages();
//
//       initAttendance();
//       seeAttendance();
    }

    private void initRoles() {
        Role admin = new Role("ADMIN");
        Role humanResources = new Role("HR");
        Role employee = new Role("EMPLOYEE");
        roleRepository.save(admin);
        roleRepository.save(humanResources);
        roleRepository.save(employee);
    }

    private void initUsers() {
        User user1 = new User();
        user1.setUsername("AdamsBaker");
        user1.setPassword("1234");
        List<Role> user1Roles = new ArrayList<Role>();
        Role user1Role = roleRepository.findByRoleName("ADMIN");
        user1Roles.add(user1Role);
        user1.setRoles(user1Roles);
        userService.registerUser(user1);

        User user2 = new User();
        user2.setUsername("ClarkDavis");
        user2.setPassword("1234");
        List<Role> user2Roles = new ArrayList<Role>();
        Role user2Role = roleRepository.findByRoleName("HR");
        user2Roles.add(user2Role);
        user2.setRoles(user2Roles);
        userService.registerUser(user2);

        User user3 = new User();
        user3.setUsername("EvansFrank");
        user3.setPassword("1234");
        List<Role> user3Roles = new ArrayList<Role>();
        Role user3Role = roleRepository.findByRoleName("HR");
        user3Roles.add(user3Role);
        user3.setRoles(user3Roles);
        userService.registerUser(user3);

        User user4 = new User();
        user4.setUsername("GhoshHills");
        user4.setPassword("1234");
        List<Role> user4Roles = new ArrayList<Role>();
        Role user4Role = roleRepository.findByRoleName("EMPLOYEE");
        user4Roles.add(user4Role);
        user4.setRoles(user4Roles);
        userService.registerUser(user4);

        User user5 = new User();
        user5.setUsername("IrwinJones");
        user5.setPassword("1234");
        List<Role> user5Roles = new ArrayList<Role>();
        Role user5Role = roleRepository.findByRoleName("EMPLOYEE");
        user5Roles.add(user5Role);
        user5.setRoles(user5Roles);
        userService.registerUser(user5);

        User user6 = new User();
        user6.setUsername("KleinLopez");
        user6.setPassword("1234");
        List<Role> user6Roles = new ArrayList<Role>();
        Role user6Role = roleRepository.findByRoleName("EMPLOYEE");
        user6Roles.add(user6Role);
        user6.setRoles(user6Roles);
        userService.registerUser(user6);

        User user7 = new User();
        user7.setUsername("MasonNalty");
        user7.setPassword("1234");
        List<Role> user7Roles = new ArrayList<Role>();
        Role user7Role = roleRepository.findByRoleName("EMPLOYEE");
        user7Roles.add(user7Role);
        user7.setRoles(user7Roles);
        userService.registerUser(user7);
    }

    private void addMessages() {
        Message message1 = new Message();
        Message message2 = new Message();
        Message message3 = new Message();
        Message message4 = new Message();
        Message message5 = new Message();

        User sender = userService.findUser("AdamsBaker");

        User sender1 = userService.findUser("ClarkDavis");
        User sender2 = userService.findUser("EvansFrank");

        User receiver1 = userService.findUser("GhoshHills");
        User receiver2 = userService.findUser("IrwinJones");
        User receiver3 = userService.findUser("KleinLopez");
        User receiver4 = userService.findUser("MasonNalty");

        message1.setAuthor(sender);
        message1.setContent("Welcome aboard new buddy! We are sure that you will prove to be a great addition to our team and the office!");
        message1.setTitle("Welcome onboard!");
        message1.setMessageDate(Date.from(Instant.parse("2020-06-08T00:00:00.000Z")));
        List<User> receivers1 = new ArrayList<>();
        message1.setReceivers(receivers1);

        message2.setAuthor(sender1);
        message2.setContent("Hey Team, great job this week! As a bonus for your hard work, please take Monday off!");
        message2.setTitle("Hey Team, great job this week!");
        message2.setMessageDate(Date.from(Instant.parse("2020-06-15T00:00:00.000Z")));
        List<User> receivers2 = new ArrayList<>();
        message2.setReceivers(receivers2);

        message3.setAuthor(sender1);
        message3.setContent("Here’s a reminder that corporate offices will be closed June 23 – July 4.");
        message3.setTitle("Happy holidays!");
        message3.setMessageDate(Date.from(Instant.parse("2020-06-15T00:00:00.000Z")));
        List<User> receivers3 = new ArrayList<>();
        message3.setReceivers(receivers3);

        message4.setAuthor(sender2);
        message4.setContent("We’re holding a group interview next week. Are you available Monday from 9-11?");
        message4.setTitle("Thank you again for your excellent resume.");
        message4.setMessageDate(Date.from(Instant.parse("2020-06-15T00:00:00.000Z")));
        List<User> receivers4 = new ArrayList<>();
        message4.setReceivers(receivers4);

        message5.setAuthor(sender2);
        message5.setContent("We have a development role that’s right up your alley. Shoot me a text back if you’re interested.");
        message5.setTitle("Hey Mason, how are you doing?");
        message5.setMessageDate(Date.from(Instant.parse("2020-06-15T00:00:00.000Z")));
        List<User> receivers5 = new ArrayList<>();
        message5.setReceivers(receivers5);

        Message finalMessage1 = messageService.addReceiverToMessage(message1, receiver1);
        finalMessage1 = messageService.addReceiverToMessage(finalMessage1, receiver2);
        finalMessage1 = messageService.addReceiverToMessage(finalMessage1, receiver3);
        finalMessage1 = messageService.addReceiverToMessage(finalMessage1, receiver4);
        messageService.sendMessage(finalMessage1);

        Message finalMessage2 = messageService.addReceiverToMessage(message2, receiver3);
        finalMessage2 = messageService.addReceiverToMessage(finalMessage2, receiver4);
        messageService.sendMessage(finalMessage2);

        Message finalMessage3 = messageService.addReceiverToMessage(message3, receiver1);
        finalMessage3 = messageService.addReceiverToMessage(finalMessage3, receiver2);
        finalMessage3 = messageService.addReceiverToMessage(finalMessage3, receiver3);
        finalMessage3 = messageService.addReceiverToMessage(finalMessage3, receiver4);
        messageService.sendMessage(finalMessage3);
//
        Message finalMessage4 = messageService.addReceiverToMessage(message4, receiver1);
        messageService.sendMessage(finalMessage4);

        Message finalMessage5 = messageService.addReceiverToMessage(message5, receiver4);
        messageService.sendMessage(finalMessage5);

    }

    private void seeMessages()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // use for date format
        User user1 = userService.findUser("Emp1");
        List<Message> messages1 = messageService.getMessages(user1.getUsername());
        System.out.println("Emp 1:");
        for(Message m: messages1){
            System.out.println(m.getTitle());
            System.out.println(formatter.format(m.getMessageDate()));
        }

        System.out.println("Emp 2:");
        User user2 = userService.findUser("Emp2");
        List<Message> messages2 = messageService.getMessages(user2.getUsername());
        for(Message m: messages2){
            System.out.println(m.getTitle());
            System.out.println(formatter.format(m.getMessageDate()));
        }
    }

    private void initAttendance() {
        User user1 = userService.findUser("GhoshHills");
        User user2 = userService.findUser("IrwinJones");
        User user3 = userService.findUser("KleinLopez");
        User user4 = userService.findUser("MasonNalty");

        TimeSheet timeSheet1 = new TimeSheet();
        timeSheet1.setStart(Date.from(Instant.parse("2020-06-15T08:00:00.000Z")));
        timeSheet1.setEnd(Date.from(Instant.parse("2020-06-15T17:00:00.000Z")));
        timeSheet1.setWorkedHours("09:00");
        timeSheet1.setEmployee(user1);
        timeSheetService.insertTimeSheet(timeSheet1);

        TimeSheet timeSheet2 = new TimeSheet();
        timeSheet2.setStart(Date.from(Instant.parse("2020-06-16T08:30:00.000Z")));
        timeSheet2.setEnd(Date.from(Instant.parse("2020-06-16T17:00:00.000Z")));
        timeSheet2.setWorkedHours("08:30");
        timeSheet2.setEmployee(user1);
        timeSheetService.insertTimeSheet(timeSheet2);

        TimeSheet timeSheet3 = new TimeSheet();
        timeSheet3.setStart(Date.from(Instant.parse("2020-06-17T08:30:00.000Z")));
        timeSheet3.setEnd(Date.from(Instant.parse("2020-06-17T17:00:00.000Z")));
        timeSheet3.setWorkedHours("08:30");
        timeSheet3.setEmployee(user1);
        timeSheetService.insertTimeSheet(timeSheet3);

        TimeSheet timeSheet4 = new TimeSheet();
        timeSheet4.setStart(Date.from(Instant.parse("2020-06-18T08:30:00.000Z")));
        timeSheet4.setEnd(Date.from(Instant.parse("2020-06-18T17:00:00.000Z")));
        timeSheet4.setWorkedHours("08:30");
        timeSheet4.setEmployee(user1);
        timeSheetService.insertTimeSheet(timeSheet4);

        TimeSheet timeSheet5 = new TimeSheet();
        timeSheet5.setStart(Date.from(Instant.parse("2020-06-19T08:30:00.000Z")));
        timeSheet5.setEnd(Date.from(Instant.parse("2020-06-19T17:00:00.000Z")));
        timeSheet5.setWorkedHours("08:30");
        timeSheet5.setEmployee(user1);
        timeSheetService.insertTimeSheet(timeSheet5);

        TimeSheet timeSheet6 = new TimeSheet();
        timeSheet6.setStart(Date.from(Instant.parse("2020-06-22T08:30:00.000Z")));
        timeSheet6.setEnd(Date.from(Instant.parse("2020-06-22T17:00:00.000Z")));
        timeSheet6.setWorkedHours("08:30");
        timeSheet6.setEmployee(user1);
        timeSheetService.insertTimeSheet(timeSheet6);

        TimeSheet timeSheet7 = new TimeSheet();
        timeSheet7.setStart(Date.from(Instant.parse("2020-06-23T08:30:00.000Z")));
        timeSheet7.setEnd(Date.from(Instant.parse("2020-06-23T17:00:00.000Z")));
        timeSheet7.setWorkedHours("08:30");
        timeSheet7.setEmployee(user1);
        timeSheetService.insertTimeSheet(timeSheet7);

        TimeSheet timeSheet8 = new TimeSheet();
        timeSheet8.setStart(Date.from(Instant.parse("2020-06-24T08:30:00.000Z")));
        timeSheet8.setEnd(Date.from(Instant.parse("2020-06-24T17:00:00.000Z")));
        timeSheet8.setWorkedHours("08:30");
        timeSheet8.setEmployee(user1);
        timeSheetService.insertTimeSheet(timeSheet8);

        TimeSheet timeSheet9 = new TimeSheet();
        timeSheet9.setStart(Date.from(Instant.parse("2020-06-25T08:30:00.000Z")));
        timeSheet9.setEnd(Date.from(Instant.parse("2020-06-25T17:00:00.000Z")));
        timeSheet9.setWorkedHours("08:30");
        timeSheet9.setEmployee(user1);
        timeSheetService.insertTimeSheet(timeSheet9);

        TimeSheet timeSheet10 = new TimeSheet();
        timeSheet10.setStart(Date.from(Instant.parse("2020-06-26T08:30:00.000Z")));
        timeSheet10.setEnd(Date.from(Instant.parse("2020-06-26T17:00:00.000Z")));
        timeSheet10.setWorkedHours("08:30");
        timeSheet10.setEmployee(user1);
        timeSheetService.insertTimeSheet(timeSheet10);

        TimeSheet timeSheet11 = new TimeSheet();
        timeSheet11.setStart(Date.from(Instant.parse("2020-06-15T08:00:00.000Z")));
        timeSheet11.setEnd(Date.from(Instant.parse("2020-06-15T17:00:00.000Z")));
        timeSheet11.setWorkedHours("09:00");
        timeSheet11.setEmployee(user2);
        timeSheetService.insertTimeSheet(timeSheet11);

        TimeSheet timeSheet12 = new TimeSheet();
        timeSheet12.setStart(Date.from(Instant.parse("2020-06-16T08:30:00.000Z")));
        timeSheet12.setEnd(Date.from(Instant.parse("2020-06-16T17:00:00.000Z")));
        timeSheet12.setWorkedHours("08:30");
        timeSheet12.setEmployee(user2);
        timeSheetService.insertTimeSheet(timeSheet12);

        TimeSheet timeSheet13 = new TimeSheet();
        timeSheet13.setStart(Date.from(Instant.parse("2020-06-17T08:30:00.000Z")));
        timeSheet13.setEnd(Date.from(Instant.parse("2020-06-17T17:00:00.000Z")));
        timeSheet13.setWorkedHours("08:30");
        timeSheet13.setEmployee(user2);
        timeSheetService.insertTimeSheet(timeSheet13);

        TimeSheet timeSheet14 = new TimeSheet();
        timeSheet14.setStart(Date.from(Instant.parse("2020-06-18T08:30:00.000Z")));
        timeSheet14.setEnd(Date.from(Instant.parse("2020-06-18T17:00:00.000Z")));
        timeSheet14.setWorkedHours("08:30");
        timeSheet14.setEmployee(user2);
        timeSheetService.insertTimeSheet(timeSheet14);

        TimeSheet timeSheet15 = new TimeSheet();
        timeSheet15.setStart(Date.from(Instant.parse("2020-06-19T08:30:00.000Z")));
        timeSheet15.setEnd(Date.from(Instant.parse("2020-06-19T17:00:00.000Z")));
        timeSheet15.setWorkedHours("08:30");
        timeSheet15.setEmployee(user2);
        timeSheetService.insertTimeSheet(timeSheet15);

        TimeSheet timeSheet16 = new TimeSheet();
        timeSheet16.setStart(Date.from(Instant.parse("2020-06-22T08:30:00.000Z")));
        timeSheet16.setEnd(Date.from(Instant.parse("2020-06-22T17:00:00.000Z")));
        timeSheet16.setWorkedHours("08:30");
        timeSheet16.setEmployee(user2);
        timeSheetService.insertTimeSheet(timeSheet16);

        TimeSheet timeSheet17 = new TimeSheet();
        timeSheet17.setStart(Date.from(Instant.parse("2020-06-23T08:30:00.000Z")));
        timeSheet17.setEnd(Date.from(Instant.parse("2020-06-23T17:00:00.000Z")));
        timeSheet17.setWorkedHours("08:30");
        timeSheet17.setEmployee(user2);
        timeSheetService.insertTimeSheet(timeSheet17);

        TimeSheet timeSheet18 = new TimeSheet();
        timeSheet18.setStart(Date.from(Instant.parse("2020-06-24T08:30:00.000Z")));
        timeSheet18.setEnd(Date.from(Instant.parse("2020-06-24T17:00:00.000Z")));
        timeSheet18.setWorkedHours("08:30");
        timeSheet18.setEmployee(user3);
        timeSheetService.insertTimeSheet(timeSheet18);

        TimeSheet timeSheet19 = new TimeSheet();
        timeSheet19.setStart(Date.from(Instant.parse("2020-06-25T08:30:00.000Z")));
        timeSheet19.setEnd(Date.from(Instant.parse("2020-06-25T17:00:00.000Z")));
        timeSheet19.setWorkedHours("08:30");
        timeSheet19.setEmployee(user3);
        timeSheetService.insertTimeSheet(timeSheet19);

        TimeSheet timeSheet20 = new TimeSheet();
        timeSheet20.setStart(Date.from(Instant.parse("2020-06-26T08:30:00.000Z")));
        timeSheet20.setEnd(Date.from(Instant.parse("2020-06-26T17:00:00.000Z")));
        timeSheet20.setWorkedHours("08:30");
        timeSheet20.setEmployee(user3);
        timeSheetService.insertTimeSheet(timeSheet20);

        TimeSheet timeSheet21 = new TimeSheet();
        timeSheet21.setStart(Date.from(Instant.parse("2020-06-15T08:00:00.000Z")));
        timeSheet21.setEnd(Date.from(Instant.parse("2020-06-15T17:00:00.000Z")));
        timeSheet21.setWorkedHours("09:00");
        timeSheet21.setEmployee(user3);
        timeSheetService.insertTimeSheet(timeSheet21);

        TimeSheet timeSheet22 = new TimeSheet();
        timeSheet22.setStart(Date.from(Instant.parse("2020-06-16T08:30:00.000Z")));
        timeSheet22.setEnd(Date.from(Instant.parse("2020-06-16T17:00:00.000Z")));
        timeSheet22.setWorkedHours("08:30");
        timeSheet22.setEmployee(user3);
        timeSheetService.insertTimeSheet(timeSheet22);

        TimeSheet timeSheet23 = new TimeSheet();
        timeSheet23.setStart(Date.from(Instant.parse("2020-06-17T08:30:00.000Z")));
        timeSheet23.setEnd(Date.from(Instant.parse("2020-06-17T17:00:00.000Z")));
        timeSheet23.setWorkedHours("08:30");
        timeSheet23.setEmployee(user3);
        timeSheetService.insertTimeSheet(timeSheet23);

        TimeSheet timeSheet24 = new TimeSheet();
        timeSheet24.setStart(Date.from(Instant.parse("2020-06-18T08:30:00.000Z")));
        timeSheet24.setEnd(Date.from(Instant.parse("2020-06-18T17:00:00.000Z")));
        timeSheet24.setWorkedHours("08:30");
        timeSheet24.setEmployee(user3);
        timeSheetService.insertTimeSheet(timeSheet24);

        TimeSheet timeSheet25 = new TimeSheet();
        timeSheet25.setStart(Date.from(Instant.parse("2020-06-19T08:30:00.000Z")));
        timeSheet25.setEnd(Date.from(Instant.parse("2020-06-19T17:00:00.000Z")));
        timeSheet25.setWorkedHours("08:30");
        timeSheet25.setEmployee(user3);
        timeSheetService.insertTimeSheet(timeSheet25);

        TimeSheet timeSheet26 = new TimeSheet();
        timeSheet26.setStart(Date.from(Instant.parse("2020-06-22T08:30:00.000Z")));
        timeSheet26.setEnd(Date.from(Instant.parse("2020-06-22T17:00:00.000Z")));
        timeSheet26.setWorkedHours("08:30");
        timeSheet26.setEmployee(user3);
        timeSheetService.insertTimeSheet(timeSheet26);

        TimeSheet timeSheet27 = new TimeSheet();
        timeSheet27.setStart(Date.from(Instant.parse("2020-06-19T08:30:00.000Z")));
        timeSheet27.setEnd(Date.from(Instant.parse("2020-06-19T17:00:00.000Z")));
        timeSheet27.setWorkedHours("08:30");
        timeSheet27.setEmployee(user4);
        timeSheetService.insertTimeSheet(timeSheet27);

        TimeSheet timeSheet28 = new TimeSheet();
        timeSheet28.setStart(Date.from(Instant.parse("2020-06-22T08:30:00.000Z")));
        timeSheet28.setEnd(Date.from(Instant.parse("2020-06-22T17:00:00.000Z")));
        timeSheet28.setWorkedHours("08:30");
        timeSheet28.setEmployee(user4);
        timeSheetService.insertTimeSheet(timeSheet28);

        TimeSheet timeSheet29 = new TimeSheet();
        timeSheet29.setStart(Date.from(Instant.parse("2020-06-23T08:30:00.000Z")));
        timeSheet29.setEnd(Date.from(Instant.parse("2020-06-23T17:00:00.000Z")));
        timeSheet29.setWorkedHours("08:30");
        timeSheet29.setEmployee(user4);
        timeSheetService.insertTimeSheet(timeSheet29);

        TimeSheet timeSheet30 = new TimeSheet();
        timeSheet30.setStart(Date.from(Instant.parse("2020-06-24T08:30:00.000Z")));
        timeSheet30.setEnd(Date.from(Instant.parse("2020-06-24T17:00:00.000Z")));
        timeSheet30.setWorkedHours("08:30");
        timeSheet30.setEmployee(user4);
        timeSheetService.insertTimeSheet(timeSheet30);

        TimeSheet timeSheet31 = new TimeSheet();
        timeSheet31.setStart(Date.from(Instant.parse("2020-06-25T08:30:00.000Z")));
        timeSheet31.setEnd(Date.from(Instant.parse("2020-06-25T17:00:00.000Z")));
        timeSheet31.setWorkedHours("08:30");
        timeSheet31.setEmployee(user4);
        timeSheetService.insertTimeSheet(timeSheet31);

    }

    private void seeAttendance() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // use for date format
        User user1 = userService.findUser("Emp1");
        List<TimeSheet> attendance1 = timeSheetService.getTimeSheetByUser(user1.getUsername());
        System.out.println("Emp 1:");
        for(TimeSheet t: attendance1){
            System.out.println(formatter.format(t.getStart()) + " " + formatter.format(t.getEnd()) + " " + t.getWorkedHours());
        }

        User user2 = userService.findUser("Emp2");
        List<TimeSheet> attendance2 = timeSheetService.getTimeSheetByUser(user2.getUsername());
        System.out.println("Emp 2:");
        for(TimeSheet t: attendance2){
            System.out.println(formatter.format(t.getStart()) + " " + formatter.format(t.getEnd()) + " " + t.getWorkedHours());
        }

        User user3 = userService.findUser("Gigel");
        List<TimeSheet> attendance3 = timeSheetService.getTimeSheetByUser(user3.getUsername());
        System.out.println("Emp 2:");
        for(TimeSheet t: attendance3){
            System.out.println(formatter.format(t.getStart()) + " " + formatter.format(t.getEnd()) + " " + t.getWorkedHours());
        }
    }

}
