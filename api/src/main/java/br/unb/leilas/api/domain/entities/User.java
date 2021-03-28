package br.unb.leilas.api.domain.entities;

import javax.persistence.Entity;

import br.unb.leilas.api.domain.entities.base.BaseEntity;

@Entity
public class User extends BaseEntity {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    
    
}
