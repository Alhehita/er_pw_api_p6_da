package com.example.er_pw_api_p6_da.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.er_pw_api_p6_da.service.IMateriaService;
import com.example.er_pw_api_p6_da.service.to.MateriaTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin
@RequestMapping("/materias")
@RestController
public class MateriaController {

    @Autowired
    private IMateriaService materiaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaTO> guardar(@RequestBody MateriaTO materiaTO) {
        this.materiaService.guardar(materiaTO);
        return ResponseEntity.ok().body(materiaTO);
    }

    @PutMapping(path = "/{codigo}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaTO> actualizar(@RequestBody MateriaTO materiaTO, @PathVariable String codigo) {
        materiaTO.setCodigo(codigo);

        MateriaTO materiaTO2 = this.materiaService.buscarPorCodigo(materiaTO.getCodigo());

        if (materiaTO.getCodigo() != null) {
            materiaTO2.setCodigo(materiaTO.getCodigo());
        }

        if (materiaTO.getNombre() != null) {
            materiaTO2.setNombre(materiaTO.getNombre());

        }

        if (materiaTO.getDescripcion() != null) {
            materiaTO2.setDescripcion(materiaTO.getDescripcion());
        }

        if (materiaTO.getNumCreditos() != null) {
            materiaTO2.setNumCreditos(materiaTO.getNumCreditos());
        }

        this.materiaService.actualizar(materiaTO2);

        return ResponseEntity.ok().body(materiaTO2);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> borrar(@PathVariable Integer id) {
        this.materiaService.borrar(id);
        return ResponseEntity.ok().body("Materia eliminada");
    }

    @GetMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaTO> buscarPorCodigo(@PathVariable String codigo) {
        MateriaTO materiaTO = this.materiaService.buscarPorCodigo(codigo);
        return ResponseEntity.ok().body(materiaTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MateriaTO> buscarTodos() {
        List<MateriaTO> materiaTOs = this.materiaService.buscarTodos();

        for (MateriaTO materiaTO : materiaTOs) {
            Link link = linkTo(methodOn(MateriaController.class).buscarPorCodigo(materiaTO.getCodigo()))
                    .withRel("Materias");
                materiaTO.add(link);
        }

        return materiaTOs;
    }

    //https://8082/API/v1.0/Matricula/materias

}
