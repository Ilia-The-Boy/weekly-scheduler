package com.iijee.class_scheduler.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalTime time;

    @Column
    private boolean isOccupied;

    @Column
    @Builder.Default
    private boolean isAvailable = true;


}
