package com.anrgsh33.crud.repositories;

import com.anrgsh33.crud.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel,Integer>{

}
