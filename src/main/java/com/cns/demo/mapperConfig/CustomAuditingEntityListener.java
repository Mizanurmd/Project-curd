package com.cns.demo.mapperConfig;

import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class CustomAuditingEntityListener extends AuditingEntityListener {
	@PrePersist
	public void prePersist(Object target) {
		if (target instanceof com.cns.demo.pojo.CommonEntity) {
			com.cns.demo.pojo.CommonEntity entity = (com.cns.demo.pojo.CommonEntity) target;
			entity.setCreatedAt(new Date());
			// Do NOT set updatedAt here
		}
	}

	@PreUpdate
	public void preUpdate(Object target) {
		if (target instanceof com.cns.demo.pojo.CommonEntity) {
			com.cns.demo.pojo.CommonEntity entity = (com.cns.demo.pojo.CommonEntity) target;
			entity.setUpdatedAt(new Date());
		}
	}

}
