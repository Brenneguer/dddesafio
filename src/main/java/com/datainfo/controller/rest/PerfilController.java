package com.datainfo.controller.rest;

import com.datainfo.model.Perfil;
import com.datainfo.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/perfis/")
@CrossOrigin
public class PerfilController {
    private final PerfilRepository perfilRepository;

    @Autowired
    public PerfilController(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> listarTodos() {
        return ResponseEntity.ok(perfilRepository.findAll());
    }

}
