package com.ysfaltn.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ysfaltn.entity.TaskEntity;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Integer>
{
	@Query("from TaskEntity t where t.status='ACTIVE' or t.status='DONE'")
	public Iterable<TaskEntity> getAll();
}
