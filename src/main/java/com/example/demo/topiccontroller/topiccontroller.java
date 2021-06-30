package com.example.demo.topiccontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class topiccontroller {

    @Autowired
    private topicservice ts;

    @RequestMapping("/")
    public String sayHi(){
        return "Hello Everyone, building an deploying an api";
    }

    @RequestMapping("/topics")
    public List<topic> getAllTopics(){
        return ts.getAlltopics();
    }

    @RequestMapping("/topic/{foo}")
    public topic getsingletopic(@PathVariable("foo") String id){return ts.getsingletopic(id);}

    @RequestMapping(value = "/topics",method = RequestMethod.POST)
    public void addTopic(@RequestBody topic t){
        ts.addTopic(t);
    }

    @RequestMapping(value = "/topics/{id}",method = RequestMethod.PUT)
    public void updateTopic(@RequestBody topic t,@PathVariable("id") String id){
        ts.updateTopic(t,id);
    }

    @RequestMapping(value = "/topics/{id}",method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable("id") String id){
        ts.deleteTopic(id);
    }
}
