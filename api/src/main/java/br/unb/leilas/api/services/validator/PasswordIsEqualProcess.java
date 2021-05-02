package br.unb.leilas.api.services.validator;

import br.unb.leilas.api.domain.entities.dto.ClienteDTO;

public class PasswordIsEqualProcess implements SignupProcess {

    @Override
    public void next(SignupProcess signupProcessor) {
    }

    @Override
    public void validate(ClienteDTO clienteDTO) {
        if (!clienteDTO.getPassword1().equals(clienteDTO.getPassword2())) {
            throw new RuntimeException("Senhas não são iguais");
        }
    }

}
