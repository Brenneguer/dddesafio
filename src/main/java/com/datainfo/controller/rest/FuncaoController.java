package com.datainfo.controller.rest;

import com.datainfo.model.Funcao;
import com.datainfo.repository.FuncaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/funcoes/")
public class FuncaoController {
    private final FuncaoRepository funcaoRepository;

    public FuncaoController(FuncaoRepository funcaoRepository) {
        this.funcaoRepository = funcaoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Funcao>> listarTodos() {
        return ResponseEntity.ok(funcaoRepository.findAll());
    }
}
