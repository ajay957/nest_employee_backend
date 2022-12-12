package com.example.nestemployee.dao;

import com.example.nestemployee.model.Tasks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TaskDao extends CrudRepository<Tasks, Integer> {
    @Query(value = "SELECT e.`designation`, e.`email`, e.`empcode`, e.`empname`, e.`password`, e.`phno`, e.`username`,t.taskname,t.taskstatus FROM `employee` e JOIN tasks t ON e.empcode=t.empid",nativeQuery = true)
    List<Map<String,String>> ViewAllTask();

    @Query(value = "UPDATE `tasks` SET `taskstatus`=:`taskstatus` WHERE `id`=:`id`",nativeQuery = true)
    void UpdateStatus(@Param("id") Integer id,@Param("taskstatus") String taskstatus);
}
