package com.cns.demo.service;

import org.springframework.data.domain.Page;

import com.cns.demo.dto.ProjectDto;
import com.cns.demo.pojo.Project;

public interface ProjectService {
	ProjectDto createProject(ProjectDto projectDto);

	Page<ProjectDto> getAllProject(int page, int size, String sortBy);

	Page<ProjectDto> getFilteredProjects(String keyword, int page, int size, String sortBy);

	Project getSingleProject(Long id);

	ProjectDto updateProject(Long id, ProjectDto projectDto);

	void deleteProject(Long id);

}
