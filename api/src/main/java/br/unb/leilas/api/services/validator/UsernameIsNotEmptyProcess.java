package br.unb.leilas.api.services.validator;

import br.unb.leilas.api.domain.entities.dto.ClienteDTO;

public class UsernameIsNotEmptyProcess implements SignupProcess{
    private SignupProcess nextProcess;

    @Override
    public void next(SignupProcess signupProcessor) {
        this.nextProcess = signupProcessor;
    }

    @Override
    public void validate(ClienteDTO clienteDTO) {

        if(clienteDTO.getUsername() == null){
            throw new RuntimeException("Nome de usuário ausente");
        }
        this.nextProcess.validate(clienteDTO);
    }
}

   
