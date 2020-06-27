package dtos;

public class UserTimeSheetDto {

    private String startDate;
    private String endDate;
    private String workedHours;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        if (startDate != null) {
            this.startDate = startDate;
        }
        else {
            this.startDate = "";
        }
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        if (endDate != null) {
            this.endDate = endDate;
        }
        else {
            this.endDate = "";
        }
    }

    public String getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(String workedHours) {
        if (workedHours != null) {
            this.workedHours = workedHours;
        }
        else {
            this.workedHours = "";
        }
    }

}
