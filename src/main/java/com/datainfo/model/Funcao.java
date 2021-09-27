package com.datainfo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "funcao")
public class Funcao {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    private int id;
    private String nome;
    @Column(name = "is_ativo")
    private boolean isAtivo;
}
