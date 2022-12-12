package com.example.nestemployee.controller;

import com.example.nestemployee.dao.TaskDao;
import com.example.nestemployee.model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    private TaskDao tdao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "addtask",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addTask(@RequestBody Tasks t){
        System.out.println(t.getEmpid());
        System.out.println(t.getTaskname());
        System.out.println(t.getDescription());
        System.out.println(t.getCompletedate());
        System.out.println(t.getTaskstatus());
        tdao.save(t);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewall")
    public List<Map<String,String>> ViewAllTask(){
        return (List<Map<String,String>>) tdao.ViewAllTask();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/update",consumes = "application/json",produces = "application/json")
    public Map<String,String> UpdateStatus(@RequestBody Tasks t){
        String id=String.valueOf(t.getId());
        String taskstatus=t.getTaskstatus();
        System.out.println(id);
        System.out.println(taskstatus);
        tdao.UpdateStatus(t.getId(),t.getTaskstatus());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

}
