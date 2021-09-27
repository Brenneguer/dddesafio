package com.datainfo.controller.rest;

import com.datainfo.model.Usuario;
import com.datainfo.service.UsuarioService;
import com.datainfo.service.filtros.FiltrosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuarios/")
@CrossOrigin
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        Usuario saveUser = usuarioService.salvarUsuario(usuario);
        return Objects.nonNull(saveUser) ?
                ResponseEntity.ok(saveUser) : ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
        Usuario updateUser = usuarioService.atualizarUsuario(usuario);

        return Objects.nonNull(updateUser) ?
                ResponseEntity.ok(updateUser) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletar(@RequestBody Usuario usuario) {
        boolean deleteUser = usuarioService.deletarUsuario(usuario);
        return deleteUser ?
                ResponseEntity.ok(true) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/inativar/")
    public ResponseEntity<Boolean> desativarUsuario(@RequestBody Usuario usuario) {
        boolean inativar = usuarioService.desativarUsuario(usuario);
        return inativar ? ResponseEntity.ok(true) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/ativar/")
    public ResponseEntity<Boolean> ativarUsuario(@RequestBody Usuario usuario) {
        boolean ativar = usuarioService.ativarUsuario(usuario);
        return ativar ? ResponseEntity.ok(true) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/filtrar/")
    public ResponseEntity<List<Usuario>> filtrarUsuarios(@RequestBody FiltrosUsuario filtro) {
        List<Usuario> usuarios = usuarioService.listarPorFiltro(filtro);

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/cpf/")
    public ResponseEntity<Usuario> buscarPorCpf(@RequestParam String cpf) {
        Usuario usuario = usuarioService.findByCpf(cpf);

        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.badRequest().build();
    }
}
