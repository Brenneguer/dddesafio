package com.datainfo.service;

import com.datainfo.model.QUsuario;
import com.datainfo.model.Usuario;
import com.datainfo.repository.UsuarioRepository;
import com.datainfo.service.filtros.FiltrosUsuario;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario novoUsuario) {
        Usuario usuario = usuarioRepository.findById(novoUsuario.getId()).orElse(null);
        if (usuario != null) {
            return usuario;
        }

        return usuarioRepository.save(novoUsuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        if (usuario.getId() == 0) {
            return null;
        }
        return usuarioRepository.save(usuario);
    }

    public boolean deletarUsuario(Usuario usuario) {
        Optional<Usuario> user = usuarioRepository.findById(usuario.getId());
        if (user.isEmpty()) {
            return false;
        }
        usuarioRepository.delete(usuario);
        return true;
    }

    public boolean ativarUsuario(Usuario usuario) {
        Optional<Usuario> user = usuarioRepository.findById(usuario.getId());
        if (user.isEmpty()) {
            return false;
        }
        usuario.setAtivo(true);
        usuarioRepository.save(usuario);
        return true;
    }

    public boolean desativarUsuario(Usuario usuario) {
        Optional<Usuario> user = usuarioRepository.findById(usuario.getId());
        if (user.isEmpty()) {
            return false;
        }
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
        return true;
    }

    public List<Usuario> listarTodos() {
        List<Usuario> usuarios;
        usuarios = usuarioRepository.findAll();
        Collections.sort(usuarios);
        return usuarios;
    }

    public List<Usuario> listarPorFiltro(FiltrosUsuario filtro) {
        List<Usuario> usuarios = new ArrayList<>();
        QUsuario qUsuario = QUsuario.usuario;
        final BooleanBuilder where = new BooleanBuilder();

        if (filtro.getNome() != null) {
            where.and(qUsuario.nome.likeIgnoreCase("%"+filtro.getNome()+"%"));
        }
        if (filtro.getPerfil() != null) {
            where.and(qUsuario.perfil.eq(filtro.getPerfil()));
        }
        if (filtro.isAtivo()) {
            where.and(qUsuario.isAtivo.eq(filtro.isAtivo()));
        }
        if (filtro.isInativo()) {
            where.and(qUsuario.isAtivo.eq(!filtro.isInativo()));
        }

        usuarioRepository.findAll(where).forEach(usuarios::add);
        Collections.sort(usuarios);
        return usuarios;
    }

    public Usuario findByCpf(String cpf) {
        if (cpf == null) {
            return null;
        }
        return usuarioRepository.cpf(cpf);
    }
}
