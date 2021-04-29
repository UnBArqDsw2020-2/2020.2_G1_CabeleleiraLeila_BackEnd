package br.unb.leilas.api.services.validator;

import br.unb.leilas.api.domain.entities.dto.ClienteDTO;

public interface SignupProcess  {

    void next(SignupProcess signupProcessor);
    void validate(ClienteDTO clienteDTO);
}
