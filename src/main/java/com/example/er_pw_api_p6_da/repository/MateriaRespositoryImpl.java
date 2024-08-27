package com.example.er_pw_api_p6_da.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.er_pw_api_p6_da.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRespositoryImpl implements IMateriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

@Override
public void insertar(Materia materia) {
    this.entityManager.persist(materia);
}

@Override
public void eliminar(Integer id) {
    this.entityManager.remove(this.entityManager.find(Materia.class, id));
}

@Override
public void actualizar(Materia materia) {
    this.entityManager.merge(materia);
}

@Override
public List<Materia> seleccionarTodos() {
    TypedQuery<Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m", Materia.class);
    return query.getResultList();
}

@Override
public Materia seleccionarPorCodigo(String codigo) {
    TypedQuery<Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo=:codigo", Materia.class);
    query.setParameter("codigo", codigo);
    return query.getSingleResult();
};
    
}
