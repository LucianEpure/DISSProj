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
    private Date startTime;
    private Date endTime;
    private Date workedHours;


    public void setId(int id){
        this.id = id;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public void setStartTime(Date time) {
        this.startTime = time;
    }
    public void setEndTime(Date time) {
        this.endTime = time;
    }
    public void setWorkedHours(Date time) {
        this.workedHours = time;
    }
    public int getId() {
        return id;
    }
    public Date getDate() {
        return  date;
    }
    public Date getStartTime() {
        return startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public Date getWorkedHours() {
        return workedHours;
    }
}
