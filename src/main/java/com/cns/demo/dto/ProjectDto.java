package com.cns.demo.dto;

import com.cns.demo.pojo.CommonEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectDto extends CommonEntity {

	@NotBlank(message = "Title is mandatory")
	@Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
	private String title;

	@NotBlank(message = "Description is mandatory")
	private String description;

}
