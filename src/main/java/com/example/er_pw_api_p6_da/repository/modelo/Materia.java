package com.example.er_pw_api_p6_da.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "materia")
public class Materia {

    @GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
    @Id
    @Column(name = "mate_id")
    private Integer id;

    @Column(name = "mate_codigo")
    private String codigo;

    @Column(name = "mate_nombre")
    private String nombre;

    @Column(name = "mate_descripcion")
    private String descripcion;

    @Column(name = "mate_numero_creditos")
    private Integer numCreditos;

}
