package br.unb.leilas.api.domain.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.unb.leilas.api.domain.entities.base.BaseEntity;

@Entity
@Table(name = "permissao")
public class Permissao extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
}
