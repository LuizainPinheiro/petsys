package com.petsys.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private LocalDateTime dtCreated;

    @Column(nullable = false)
    private PetCategoria categoria;

    @ManyToOne
    @JoinColumn(name = "dono_id") // FK
    private Dono dono;

    @OneToMany(mappedBy = "pet")
    private List<Servico> servicos;

    @PrePersist
    protected void onCreated(){
        dtCreated = LocalDateTime.now();
    }

}
