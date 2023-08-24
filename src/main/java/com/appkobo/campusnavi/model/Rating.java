package com.appkobo.campusnavi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private double quality;

    @Column(nullable = false)
    private double difficulty;

    @Column(nullable = false)
    private boolean wouldTakeAgain;

    @Column(nullable = false)
    private double grade;

    @Column(nullable = false)
    private boolean attendance;

    @Column(nullable = false)
    private boolean textbook;

    @Column(nullable = false)
    private boolean homework;

    @Column(nullable = false)
    private boolean essay;

    @Column(nullable = false)
    private boolean openNotes;

    @Column(nullable = false)
    private Integer likes;

    @Column(nullable = false)
    private Integer dislikes;
}
