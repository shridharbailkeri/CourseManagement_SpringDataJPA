package com.aliboucoding.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@Table(name = "AUTHOR_TBL")
public class Author extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            name = "f_name",
            length = 36
    )
    private String firstName;

    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private int age;

    @ManyToMany(mappedBy = "authors",
    fetch = FetchType.EAGER)
    private List<Course> courses;



    // entity means make all fields private and have getters and setters

}
