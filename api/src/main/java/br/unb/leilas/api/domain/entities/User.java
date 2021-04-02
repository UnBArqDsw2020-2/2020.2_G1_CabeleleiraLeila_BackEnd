package br.unb.leilas.api.domain.entities;

import javax.persistence.Entity;

import br.unb.leilas.api.domain.entities.base.BaseEntity;

@Entity
public class User extends BaseEntity {

    private String username;
    private String password;
    
    public static  Builder builder(){
        return new Builder();
    }
    public static class Builder {

        private String username;
        private String password;
        private Integer id;

        Builder() {
        }

        public Builder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public Builder username(String username) {
            this.username = username;
            return Builder.this;
        }

        public Builder password(String password) {
            this.password = password;
            return Builder.this;
        }

        public Builder id(Integer id){
            this.id = id;
            return Builder.this;
        }
        
        public User build() {

            return new User(this);
        }
    }

    private User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        super.setId(builder.id);
    }

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

    public User(){
        
    }

}