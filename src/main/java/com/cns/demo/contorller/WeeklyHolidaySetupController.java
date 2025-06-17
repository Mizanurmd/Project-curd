package com.cns.demo.contorller;

import com.cns.demo.pojo.WeeklyHolidaySetup;
import com.cns.demo.response.ApiResponse;
import com.cns.demo.service.WeeklyHolidaySetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/holidays")
public class WeeklyHolidaySetupController {
    private final WeeklyHolidaySetupService weeklyHolidaySetupService;

    @Autowired
    public WeeklyHolidaySetupController(WeeklyHolidaySetupService weeklyHolidaySetupService) {
        this.weeklyHolidaySetupService = weeklyHolidaySetupService;
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<WeeklyHolidaySetup>> createWeeklyHolidaySetup(@RequestBody WeeklyHolidaySetup weeklyHolidaySetup) {
        WeeklyHolidaySetup save = weeklyHolidaySetupService.saveWeeklyHolidaySetup(weeklyHolidaySetup);
        return ResponseEntity.ok(new ApiResponse<>("Weekly holiday setup save successfully", save));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<WeeklyHolidaySetup>>> getAllWeeklyHolidaySetups() {
        List<WeeklyHolidaySetup> allHolidaySetups = weeklyHolidaySetupService.getAllWeeklyHolidaySetup();
        return ResponseEntity.ok(new ApiResponse<>("Weekly holiday setup retrieve successfully", allHolidaySetups));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<WeeklyHolidaySetup>> getWeeklyHolidaySetupById(@PathVariable("id") Long id) {
        WeeklyHolidaySetup weeklyHolidaySetup = weeklyHolidaySetupService.getWeeklyHolidaySetupById(id);
        return ResponseEntity.ok(new ApiResponse<>("Weekly holiday setup retrieve successfully", weeklyHolidaySetup));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<WeeklyHolidaySetup>> updateWeeklyHolidaySetup(@PathVariable("id") Long id, @RequestBody WeeklyHolidaySetup weeklyHolidaySetup) {
        WeeklyHolidaySetup updateHoliday = weeklyHolidaySetupService.updateWeeklyHolidaySetup(id, weeklyHolidaySetup);
        return ResponseEntity.ok(new ApiResponse<>("Weekly holiday setup update successfully", updateHoliday));
    }


    @DeleteMapping("/{id}")
    public void deleteWeeklyHolidaySetupById(@PathVariable("id") Long id) {
        weeklyHolidaySetupService.deleteWeeklyHolidaySetup(id);
    }


}
