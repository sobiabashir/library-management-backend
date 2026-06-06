package com.sobia.library_management.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
// Authors entity structure
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String firstName;

    @Column (nullable = false)
    private String lastName;

    @Column(unique = true)
    private String email;

    // link to books
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

}
