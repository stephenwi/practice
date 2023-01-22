package com.it.test.bank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor // les constructeurs
@AllArgsConstructor // Tous les getters and setters
@Entity // On dit a spring que cette classe represente une entité dans la base de donnée
@Table(name = "metadatas")
public class Metadata {

    @Id
    @GeneratedValue
    private Integer id;
    private Date createdAt;
    private Integer height;
    private Integer width;
    @OneToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photo photo;
}
