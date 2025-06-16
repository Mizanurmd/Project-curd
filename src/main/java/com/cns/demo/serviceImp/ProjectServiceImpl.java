package com.cns.demo.serviceImp;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cns.demo.customException.ResourceNotFoundException;
import com.cns.demo.dto.ProjectDto;
import com.cns.demo.pojo.Project;
import com.cns.demo.repository.ProjectRepository;
import com.cns.demo.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {
	private final ProjectRepository projectRepository;
	private final ModelMapper mapper;

	public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper mapper) {
		super();
		this.projectRepository = projectRepository;
		this.mapper = mapper;
	}

	@Override
	public ProjectDto createProject(ProjectDto projectDto) {
		Project project = mapper.map(projectDto, Project.class);
		Project save = projectRepository.save(project);
		return mapper.map(save, ProjectDto.class);
	}

	@Override
	public Page<ProjectDto> getAllProject(int page, int size, String sortBy) {
		PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return (Page) projectRepository.findAll(pageable).map(project -> mapper.map(project, ProjectDto.class));
	}

	@Override
	public Project getSingleProject(Long id) {
		Optional<Project> optionalId = Optional.ofNullable(projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Project not found with id :: " + id)));
		if (optionalId.isPresent()) {
			Project p = optionalId.get();
			return p;
		}
		return null;
	}

	@Override
	public ProjectDto updateProject(Long id, ProjectDto projectDto) {
		log.info("Updating project with ID: {}", id);
		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id + " is not found: 404"));

		project.setTitle(projectDto.getTitle());
		project.setDescription(projectDto.getDescription());
		Project updateProject = projectRepository.save(project);
		return mapper.map(updateProject, ProjectDto.class);

	}

	@Override
	public void deleteProject(Long id) {
		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("404, Project not found with id: " + id));

		projectRepository.delete(project);

	}

	@Override
	public Page<ProjectDto> getFilteredProjects(String keyword, int page, int size, String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		    Page<Project> filteredPage = projectRepository.findByTitleContainingIgnoreCase(keyword, pageable);
		    return filteredPage.map(project -> mapper.map(project, ProjectDto.class));
	}

}
