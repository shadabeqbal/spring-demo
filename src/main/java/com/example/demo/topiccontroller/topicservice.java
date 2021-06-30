package com.example.demo.topiccontroller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class topicservice {
    private List<topic> topics = new ArrayList<>(Arrays.asList(
            new topic("1","Spring","Spring Framework"),
            new topic("2","Java","Learning Java"),
            new topic("3","DS/Algo","Learning Data Structures and Algorithms")
    ));

    public List<topic> getAlltopics(){
        return topics;
    }

    public topic getsingletopic(String id){
        topic tp=new topic();
        for(topic x:getAlltopics()){
            if(x.getId().equals(id)) {
                tp = x;
                break;
            }
        }

        return tp;
    }

    public void addTopic(topic t){
        topics.add(t);
    }

    public void updateTopic(topic t,String id) {
        for(topic x:getAlltopics()) {
            if(x.getId().equals(id)){
                x=t;
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t->t.getId().equals(id));
    }
}
