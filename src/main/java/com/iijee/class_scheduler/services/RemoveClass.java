package com.iijee.class_scheduler.services;

import com.iijee.class_scheduler.connection.ConnectionProvider;
import com.iijee.class_scheduler.model.Days;
import com.iijee.class_scheduler.model.Meeting;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalTime;

public class RemoveClass {

    public static void removeMeeting(Long dayId, Long meetingId){
        System.out.println("remove got the call");
        EntityManager entityManager = new ConnectionProvider().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Days day = entityManager.find(Days.class, dayId);
        Meeting meeting = entityManager.find(Meeting.class, meetingId);
        LocalTime startingTime = meeting.getStartingTime();
        LocalTime endingTime = meeting.getEndingTime();
        int startingIndex = AddClass.authenticateStartTime(dayId, startingTime);
        int endingIndex = AddClass.authenticateEndTime(dayId, endingTime);
        try {
            entityTransaction.begin();
            day.getMeetingList().remove(meeting);
            for (int index = startingIndex; index <= endingIndex; ++index){
                day.authenticateSPlan().get(index).setOccupied(false);
                day.authenticateEPlan().get(index).setOccupied(false);
            }
            entityTransaction.commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
