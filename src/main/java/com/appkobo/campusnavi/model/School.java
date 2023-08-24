package com.appkobo.campusnavi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String prefecture;

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Department> departments = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Professor> professors = new ArrayList<>();
}
