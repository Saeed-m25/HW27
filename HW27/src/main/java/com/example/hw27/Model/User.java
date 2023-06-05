package com.example.hw27.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private Integer password;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy ="User")
    private Set<Blog> blogSet;

    public boolean getUserId() {
    }
}
