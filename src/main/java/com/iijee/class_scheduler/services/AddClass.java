package com.iijee.class_scheduler.services;

import com.iijee.class_scheduler.connection.ConnectionProvider;
import com.iijee.class_scheduler.model.Days;
import com.iijee.class_scheduler.model.Meeting;
import com.iijee.class_scheduler.model.Time;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

public class AddClass {

    public static int authenticateStartTime(Long id, LocalTime start){
        EntityManager entityManager = new ConnectionProvider().getEntityManager();
        Days day = entityManager.find(Days.class, id);
        int index = -1;
        if (day.authenticateTime().contains(start))
            index = day.authenticateTime().indexOf(start);
        return index;
    }
    public static int authenticateEndTime(Long id, LocalTime end){
        EntityManager entityManager = new ConnectionProvider().getEntityManager();
        Days day = entityManager.find(Days.class, id);
        int index = -1;
        if (day.authenticateTime().contains(end))
            index += day.authenticateTime().indexOf(end);
        return index;
    }
    public static boolean authenticateAvailableTime(Long id, String name, LocalTime start, LocalTime end){
        EntityManager entityManager = new ConnectionProvider().getEntityManager();
        Days day = entityManager.find(Days.class, id);
        boolean isValidMeeting = true;
        if (authenticateStartTime(id, start) != -1 && authenticateEndTime(id, end) != -1 && start.isBefore(end)){
            int startingIndex = authenticateStartTime(id, start);
            int endingIndex = authenticateEndTime(id, end);
            boolean busyInBetween = false;
            boolean notAvailable = false;
            for (int index = startingIndex; index <= endingIndex; ++index){
                if ((day.authenticateSPlan().get(index).isOccupied()) || day.authenticateEPlan().get(index).isOccupied()){
                    busyInBetween = true;
                    break;
                }
                if (!day.authenticateSPlan().get(index).isAvailable() || !day.authenticateEPlan().get(index).isAvailable()){
                    notAvailable = true;
                    break;
                }

            }
            if (busyInBetween){
                System.out.println("occupied times");
                isValidMeeting = false;
            }else if (notAvailable){
                System.out.println("unavailable times");
                isValidMeeting = false;

            }

        }else {
            System.out.println("invalid times");
            isValidMeeting = false;
        }
        if (isValidMeeting){
            EntityTransaction entityTransaction = entityManager.getTransaction();
            int startingIndex = authenticateStartTime(id, start);
            int endingIndex = authenticateEndTime(id, end);
            entityTransaction.begin();

            for (int index = startingIndex; index <= endingIndex; ++index){
                day.authenticateSPlan().get(index).setOccupied(true);
                day.authenticateEPlan().get(index).setOccupied(true);
            }
            Meeting meeting = Meeting.builder().name(name).startingTime(start).endingTime(end).build();
            entityManager.persist(meeting);
            if (day.getMeetingList() == null)
                day.setMeetingList(new ArrayList<>());
            day.getMeetingList().add(meeting);

            entityTransaction.commit();
            return true;
        }else
            return false;

    }
}
