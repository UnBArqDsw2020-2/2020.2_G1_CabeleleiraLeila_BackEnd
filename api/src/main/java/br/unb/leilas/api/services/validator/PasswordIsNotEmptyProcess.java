package br.unb.leilas.api.services.validator;

import br.unb.leilas.api.domain.entities.dto.ClienteDTO;

public class PasswordIsNotEmptyProcess implements SignupProcess {

    private SignupProcess nextProcess;

    @Override
    public void next(SignupProcess signupProcessor) {
        this.nextProcess = signupProcessor;

    }

    @Override
    public void validate(ClienteDTO clienteDTO) {

        if (clienteDTO.getPassword1() == null || clienteDTO.getPassword2() == null) {
            throw new RuntimeException("Senha vazia");
        }
        this.nextProcess.validate(clienteDTO);
    }

}
