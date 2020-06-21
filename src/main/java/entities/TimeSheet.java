package entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private String timeSheetType;
    private Time time;
/*
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

 */

}
