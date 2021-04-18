package br.unb.leilas.api.domain.entities.dto;

import br.unb.leilas.api.domain.entities.base.BaseEntity;

public abstract class BaseDTO<T extends BaseEntity> {

    private Integer id;

    public abstract T paraEntidade();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
