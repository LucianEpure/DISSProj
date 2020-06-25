package entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date start;
    private Date end;
    private String workedHours;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User employee;

    public void setId(int id){
        this.id = id;
    }
    public void setStart(Date date){
        this.start = date;
    }
    public void setEnd(Date time) {
        this.end = time;
    }
    public void setWorkedHours(String time) {
        this.workedHours = time;
    }
    public void setEmployee(User employee) {
        this.employee = employee;
    }
    public int getId() {
        return id;
    }
    public Date getStart() {
        return  start;
    }
    public Date getEnd() {
        return end;
    }
    public String getWorkedHours() {
        return workedHours;
    }
    public User getEmployee() {
        return employee;
    }
}
