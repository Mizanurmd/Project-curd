package com.cns.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project extends CommonEntity {

	@NotBlank(message = "Title is required")
	private String title;

	@NotBlank(message = "Title is required")
	private String description;

}
