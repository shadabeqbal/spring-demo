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
        return "<h2 style='text-align: center;'>Hello Everyone, building an deploying an api</h2><br><br> Try with endpoints:<br><br> <a href='https://javaspring-restapi.herokuapp.com/topics'>topics</a><br><a href='https://javaspring-restapi.herokuapp.com/topic/1'>topic 1</a><br><a href='https://javaspring-restapi.herokuapp.com/topic/2'>topic 2</a><br><a href='https://javaspring-restapi.herokuapp.com/topic/3'>topic 3</a>";
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
