package com.example.er_pw_api_p6_da.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.er_pw_api_p6_da.repository.IMateriaRepository;
import com.example.er_pw_api_p6_da.repository.modelo.Materia;
import com.example.er_pw_api_p6_da.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService{

    @Autowired
    private IMateriaRepository materiaRepository;

    @Override
    public void guardar(MateriaTO materiaTO) {
        this.materiaRepository.insertar(convertirTO(materiaTO));
    }

    @Override
    public void borrar(Integer id) {
        this.materiaRepository.eliminar(id);
    }

    @Override
    public void actualizar(MateriaTO materiaTO) {
        this.materiaRepository.actualizar(convertirTO(materiaTO));
    }

    @Override
    public List<MateriaTO> buscarTodos() {
        List<Materia> materias = this.materiaRepository.seleccionarTodos();
        return convertirLista(materias);
    }

    @Override
    public MateriaTO buscarPorCodigo(String codigo) {
        Materia materia = this.materiaRepository.seleccionarPorCodigo(codigo);
        return convertir(materia);
    }

    private MateriaTO convertir(Materia materia){
        if(materia ==null){
            return null;
        }

        return new MateriaTO(
            materia.getId(),
            materia.getCodigo(),
            materia.getNombre(),
            materia.getDescripcion(),
            materia.getNumCreditos()
        
        );
    }

    private Materia convertirTO(MateriaTO materiaTO){
        Materia materia = new Materia();

            materia.setId(materiaTO.getId());
            materia.setCodigo(materiaTO.getCodigo());
            materia.setNombre(materiaTO.getNombre());
            materia.setDescripcion(materiaTO.getDescripcion());
            materia.setNumCreditos(materiaTO.getNumCreditos());

        return materia;

    }

    private List<MateriaTO> convertirLista(List<Materia> materias){
        List<MateriaTO> materiaTOs = new ArrayList<>();

        for(Materia materia: materias){
            materiaTOs.add(convertir(materia));
        }

        return materiaTOs;
    }
    
}
