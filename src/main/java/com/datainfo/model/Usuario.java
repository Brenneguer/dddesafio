package com.datainfo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="usuario")
public class Usuario implements Comparable<Usuario> {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    private long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Column(name = "is_ativo")
    private boolean isAtivo;
    @ManyToOne
    @JoinColumn(name="funcao_id", foreignKey = @ForeignKey(name="funcao_fk_usuario "))
    private Funcao funcao;
    @ManyToOne
    @JoinColumn(name="perfil_id", foreignKey = @ForeignKey(name="perfil_fk_usuario "))
    private Perfil perfil;


    @Override
    public int compareTo(Usuario usuario) { return this.nome.compareTo(usuario.nome); }
}
