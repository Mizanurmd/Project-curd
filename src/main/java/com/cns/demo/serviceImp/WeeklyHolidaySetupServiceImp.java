package com.cns.demo.serviceImp;

import com.cns.demo.customException.ResourceNotFoundException;
import com.cns.demo.pojo.WeeklyHolidaySetup;
import com.cns.demo.repository.WeeklyHolidaySetupRepository;
import com.cns.demo.service.WeeklyHolidaySetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeeklyHolidaySetupServiceImp implements WeeklyHolidaySetupService {
    private final WeeklyHolidaySetupRepository weeklyHolidaySetupRepository;

    @Autowired
    public WeeklyHolidaySetupServiceImp(WeeklyHolidaySetupRepository weeklyHolidaySetupRepository) {
        this.weeklyHolidaySetupRepository = weeklyHolidaySetupRepository;
    }


    @Override
    public WeeklyHolidaySetup saveWeeklyHolidaySetup(WeeklyHolidaySetup weeklyHolidaySetup) {
        WeeklyHolidaySetup result = weeklyHolidaySetupRepository.save(weeklyHolidaySetup);
        return result;
    }

    @Override
    public List<WeeklyHolidaySetup> getAllWeeklyHolidaySetup() {
        List<WeeklyHolidaySetup> listHolidays = weeklyHolidaySetupRepository.findAll();
        return listHolidays;
    }

    @Override
    public WeeklyHolidaySetup getWeeklyHolidaySetupById(Long id) {
        WeeklyHolidaySetup holidaySetupId = weeklyHolidaySetupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Weekly Holiday Setup Not Found id:" + id));
        return holidaySetupId;
    }

    @Override
    public WeeklyHolidaySetup updateWeeklyHolidaySetup(Long id, WeeklyHolidaySetup weeklyHolidaySetup) {
        WeeklyHolidaySetup holidaySetup = weeklyHolidaySetupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Weekly Holiday Setup Not Found id:" + id));
        holidaySetup.setHolidayEnglish(weeklyHolidaySetup.getHolidayEnglish());
        holidaySetup.setTimeBetweenEnglish(weeklyHolidaySetup.getTimeBetweenEnglish());
        holidaySetup.setTimeBetweenBangla(weeklyHolidaySetup.getTimeBetweenBangla());
        holidaySetup.setHotlineNoBangla(weeklyHolidaySetup.getHotlineNoBangla());
        holidaySetup.setHotlineNoBangla(weeklyHolidaySetup.getHotlineNoBangla());
        holidaySetup.setPhoneEnglish(weeklyHolidaySetup.getPhoneEnglish());
        holidaySetup.setPhoneBangla(weeklyHolidaySetup.getPhoneBangla());
        holidaySetup.setSpecialNoteEnglish(weeklyHolidaySetup.getSpecialNoteEnglish());
        holidaySetup.setSpecialNoteBangla(weeklyHolidaySetup.getSpecialNoteBangla());
        holidaySetup.setCurrentYN(weeklyHolidaySetup.isCurrentYN());
        WeeklyHolidaySetup result = weeklyHolidaySetupRepository.save(holidaySetup);

        return result;
    }

    @Override
    public void deleteWeeklyHolidaySetup(Long id) {
        WeeklyHolidaySetup weeklyHolidaySetup = weeklyHolidaySetupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Weekly Holiday Setup Not Found id:" + id));
        weeklyHolidaySetupRepository.delete(weeklyHolidaySetup);

    }
}
