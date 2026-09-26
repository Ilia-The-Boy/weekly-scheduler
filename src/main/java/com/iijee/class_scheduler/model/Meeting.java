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
public class Meeting implements Comparable<Meeting>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private LocalTime startingTime;

    @Column
    private LocalTime endingTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Days day;

    @Override
    public int compareTo(Meeting other) {
        return this.getStartingTime().compareTo(other.getStartingTime());
    }


}
