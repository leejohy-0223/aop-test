package com.blogcode.event;

import com.blogcode.aspect.PerfLogging;
import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService{

//    @PerfLogging
    @Override
    public void createEvent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("create an event");
    }

//    @PerfLogging
    @Override // 여기에는 PerfLogging 적용 안함
    public void deleteEvent() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Delete an event");
    }

}
