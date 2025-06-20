package com.cns.demo.service;

import com.cns.demo.pojo.WeeklyHolidaySetup;

import java.util.List;

public interface WeeklyHolidaySetupService {
    WeeklyHolidaySetup saveWeeklyHolidaySetup(WeeklyHolidaySetup weeklyHolidaySetup);
    List<WeeklyHolidaySetup> getAllWeeklyHolidaySetup();
    WeeklyHolidaySetup getWeeklyHolidaySetupById(Long id);
    WeeklyHolidaySetup updateWeeklyHolidaySetup(Long id, WeeklyHolidaySetup weeklyHolidaySetup);
    void deleteWeeklyHolidaySetup(Long id);
}
