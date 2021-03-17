package br.unb.leilas.api.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "C")
public class Cliente extends Pessoa {

    @ElementCollection
    private List<String> interesses = new ArrayList<>();
    @ElementCollection
    private List<String> observacoes = new ArrayList<>();

    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        this.interesses = interesses;
    }

    public List<String> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<String> observacoes) {
        this.observacoes = observacoes;
    }

}
