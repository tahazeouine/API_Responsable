package com.si.responsableapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "responsables")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Responsable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(unique = true, nullable = false)
    private String email;

}
