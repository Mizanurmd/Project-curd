package com.cns.demo.repository;

import com.cns.demo.pojo.WeeklyHolidaySetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyHolidaySetupRepository extends JpaRepository<WeeklyHolidaySetup, Long> {

}
