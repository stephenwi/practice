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
@Table(name = "photo") // le nom que nous lui passons sera le nom present en base de donnée
public class Photo {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 255, name = "url", nullable = false, unique = true) // Ici on specifie la dimension de la colonne url
    private String url;
    @Column(columnDefinition = "TEXT") // cree un une colonne description de type text
    private String description;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "photo_tag",
    joinColumns = @JoinColumn(name = "photo_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;
    @OneToOne(mappedBy = "photo")
    private Metadata metadata;
}
