package repositories;

import entities.TimeSheet;
import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface TimeSheetRepository extends JpaRepository<TimeSheet, Integer> {
    List<TimeSheet> findByDate(Date date);
}
