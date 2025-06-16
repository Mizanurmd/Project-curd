package com.cns.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectDto {

	private Long id;

	@NotBlank(message = "Title is mandatory")
	@Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
	private String title;

	@NotBlank(message = "Description is mandatory")
	private String description;

}
