package com.cns.demo.contorller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cns.demo.dto.ProjectDto;
import com.cns.demo.pojo.Project;
import com.cns.demo.response.ApiResponse;
import com.cns.demo.service.ProjectService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ProjectController {

	private final ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}

	@PostMapping("/save")
	public ResponseEntity<ApiResponse<ProjectDto>> saveProject(@RequestBody @Valid ProjectDto projectDto) {
		return ResponseEntity.ok(new ApiResponse<>("Save Successfully.", projectService.createProject(projectDto)));

	}

	@GetMapping("/projects")
	public ResponseEntity<ApiResponse<Page<ProjectDto>>> getAllProjects(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sortBy) {

		Page<ProjectDto> result = projectService.getAllProject(page, size, sortBy);
		return ResponseEntity.ok(new ApiResponse<>("All data retrieve successful.", result));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Project>> getProject(@PathVariable("id") Long id) {
		Project p = projectService.getSingleProject(id);
		return ResponseEntity.ok(new ApiResponse<>("Single data retrieve successful.", p));

	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<ProjectDto>> updateProject(@PathVariable("id") long id,
			@RequestBody ProjectDto projectDto) {
		ProjectDto proUpdate = projectService.updateProject(id, projectDto);

		log.debug("Fetching all projects"+ proUpdate);
		return ResponseEntity.ok(new ApiResponse<>("Project is successfully updated.", proUpdate));
	}

	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable("id") Long id) {
		projectService.deleteProject(id);

	}

	@GetMapping("/search")
	public ResponseEntity<Page<ProjectDto>> searchProjects(@RequestParam String keyword,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "title") String sortBy) {

		Page<ProjectDto> result = projectService.getFilteredProjects(keyword, page, size, sortBy);
		return ResponseEntity.ok(result);
	}

}
