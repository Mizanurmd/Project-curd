package com.cns.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "weekly_holiday_setup")
public class WeeklyHolidaySetup extends CommonEntity {
    private String holidayEnglish;
    private String holidayBangla;
    private String timeBetweenEnglish;
    private String timeBetweenBangla;
    private String hotlineNoEnglish;
    private String hotlineNoBangla;
    private String phoneEnglish;
    private String phoneBangla;
    private String specialNoteEnglish;
    private String specialNoteBangla;
    private boolean currentYN;


}
