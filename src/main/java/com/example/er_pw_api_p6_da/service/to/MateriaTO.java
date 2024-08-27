package com.example.er_pw_api_p6_da.service.to;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MateriaTO extends RepresentationModel<MateriaTO>{

    private Integer id;

    private String codigo;
    private String nombre;

    private String descripcion;

    private Integer numCreditos;
    
}
