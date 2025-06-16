package com.cns.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cns.demo.pojo.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


}
