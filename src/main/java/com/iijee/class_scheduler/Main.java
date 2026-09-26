package com.iijee.class_scheduler;

import com.iijee.class_scheduler.connection.ConnectionProvider;
import com.iijee.class_scheduler.model.Days;
import com.iijee.class_scheduler.model.Time;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        EntityManager entityManager = new ConnectionProvider().getEntityManager();
//
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//
//
//        List<Time> timesList0 = new ArrayList<>();
//        for (int hour = 9; hour <= 17; hour++){
//            if (9 < hour && hour < 17){
//                Time newTime1 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                Time newTime2 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList0.add(newTime1);
//                timesList0.add(newTime2);
//            }else{
//                Time newTime = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList0.add(newTime);
//            }
//        }
//
//
//        List<Time> timesList1 = new ArrayList<>();
//        for (int hour = 9; hour <= 17; hour++){
//            if (9 < hour && hour < 17){
//                Time newTime1 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                Time newTime2 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList1.add(newTime1);
//                timesList1.add(newTime2);
//            }else{
//                Time newTime = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList1.add(newTime);
//            }
//        }
//        List<Time> timesList2 = new ArrayList<>();
//        for (int hour = 9; hour <= 17; hour++){
//            if (9 < hour && hour < 17){
//                Time newTime1 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                Time newTime2 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList2.add(newTime1);
//                timesList2.add(newTime2);
//            }else{
//                Time newTime = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList2.add(newTime);
//            }
//        }
//        List<Time> timesList3 = new ArrayList<>();
//        for (int hour = 9; hour <= 17; hour++){
//            if (9 < hour && hour < 17){
//                Time newTime1 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                Time newTime2 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList3.add(newTime1);
//                timesList3.add(newTime2);
//            }else{
//                Time newTime = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList3.add(newTime);
//            }
//        }
//        List<Time> timesList4 = new ArrayList<>();
//        for (int hour = 9; hour <= 17; hour++){
//            if (9 < hour && hour < 17){
//                Time newTime1 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                Time newTime2 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList4.add(newTime1);
//                timesList4.add(newTime2);
//            }else{
//                Time newTime = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList4.add(newTime);
//            }
//        }
//        List<Time> timesList5 = new ArrayList<>();
//        for (int hour = 9; hour <= 17; hour++){
//            if (hour == 9){
//                Time newTime = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList5.add(newTime);
//            }else if (9 < hour && hour < 14){
//                Time newTime1 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                Time newTime2 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).build();
//                timesList5.add(newTime1);
//                timesList5.add(newTime2);
//            }else if (hour == 14){
//                Time newTime1 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).isAvailable(true).build();
//                Time newTime2 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).isAvailable(false).build();
//                timesList5.add(newTime1);
//                timesList5.add(newTime2);
//
//            } else if (hour == 15 || hour == 16){
//                Time newTime1 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).isAvailable(false).build();
//                Time newTime2 = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).isAvailable(false).build();
//                timesList5.add(newTime1);
//                timesList5.add(newTime2);
//            }else {
//                Time newTime = Time.builder().time(LocalTime.of(hour, 0)).isOccupied(false).isAvailable(false).build();
//                timesList5.add(newTime);
//            }
//        }
//
//
//
//
//
//
//        Days weekdays0 = Days.builder().name("Saturday").timeList(timesList0).build();
//        Days weekdays1 = Days.builder().name("Sunday").timeList(timesList1).build();
//        Days weekdays2 = Days.builder().name("Monday").timeList(timesList2).build();
//        Days weekdays3 = Days.builder().name("Tuesday").timeList(timesList3).build();
//        Days weekdays4 = Days.builder().name("Wednesday").timeList(timesList4).build();
//        Days weekdays5 = Days.builder().name("Thursday").timeList(timesList5).build();
//        entityTransaction.begin();
//
//
//        entityManager.persist(weekdays0);
//        entityManager.persist(weekdays1);
//        entityManager.persist(weekdays2);
//        entityManager.persist(weekdays3);
//        entityManager.persist(weekdays4);
//        entityManager.persist(weekdays5);
//
//        entityTransaction.commit();
//        entityManager.close();

    }
}
