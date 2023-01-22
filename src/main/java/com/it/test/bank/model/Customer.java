package com.it.test.bank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor // les constructeurs
@AllArgsConstructor // Tous les getters and setters
@Entity // On dit a spring que cette classe represente une entité dans la base de donnée
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Photo> photos;
}
