package com.example.er_pw_api_p6_da.service;

import java.util.List;

import com.example.er_pw_api_p6_da.service.to.MateriaTO;

public interface IMateriaService {

     void guardar(MateriaTO materiaTO);

    void borrar(Integer id);

    void actualizar(MateriaTO materiaTO);

    List<MateriaTO> buscarTodos();

    MateriaTO buscarPorCodigo(String codigo);
    
}
