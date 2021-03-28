package br.unb.leilas.api.domain.entities;

import org.springframework.security.core.GrantedAuthority;

public enum RolePermissao implements GrantedAuthority {
    ROLE_CLIENTE, ROLE_ADMIN, ROLE_FUNCIONARIO;

    public String getAuthority() {
      return name();
    }
}