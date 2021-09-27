package com.datainfo.service.filtros;

import com.datainfo.model.Perfil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltrosUsuario {
    private String nome;
    private boolean ativo;
    private boolean inativo;
    private Perfil perfil;
}
