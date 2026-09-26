package com.iijee.class_scheduler.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

public class Days {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Time> timeList;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("startingTime ASC")
    private List<Meeting> meetingList;




    public List<LocalTime> authenticateTime(){
        List<LocalTime> authenticated = new ArrayList<>();
        Collections.addAll(authenticated,
                LocalTime.of(9, 0),
                LocalTime.of(10, 0),
                LocalTime.of(11, 0),
                LocalTime.of(12, 0),
                LocalTime.of(13, 0),
                LocalTime.of(14, 0),
                LocalTime.of(15, 0),
                LocalTime.of(16, 0),
                LocalTime.of(17, 0));
        return authenticated;
    }


    public List<Time> getIterablePlan(){
        List<Time> iterablePlan = authenticateSPlan();
        return iterablePlan;
    }



    public List<Time> authenticateSPlan(){
        List<Time> editablePlan = new ArrayList<>();
        Collections.addAll(editablePlan,
                timeList.get(0),
                timeList.get(2),
                timeList.get(4),
                timeList.get(6),
                timeList.get(8),
                timeList.get(10),
                timeList.get(12),
                timeList.get(14));
        return editablePlan;
    }
    public List<Time> authenticateEPlan(){
        List<Time> editablePlan = new ArrayList<>();
        Collections.addAll(editablePlan,
                timeList.get(1),
                timeList.get(3),
                timeList.get(5),
                timeList.get(7),
                timeList.get(9),
                timeList.get(11),
                timeList.get(13),
                timeList.get(15));
        return editablePlan;
    }

}
