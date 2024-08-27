package com.example.er_pw_api_p6_da.repository;

import java.util.List;

import com.example.er_pw_api_p6_da.repository.modelo.Materia;

public interface IMateriaRepository {

    void insertar(Materia materia);

    void eliminar(Integer id);

    void actualizar(Materia materia);

    List<Materia> seleccionarTodos();

    Materia seleccionarPorCodigo(String codigo);
    
}
