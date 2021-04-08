package br.unb.leilas.api.services.validator;

import br.unb.leilas.api.domain.entities.dto.PessoaDTO;

public class UsernameIsNotEmptyProcess implements SignupProcess{
    private SignupProcess nextProcess;

    @Override
    public void next(SignupProcess signupProcessor) {
        this.nextProcess = signupProcessor;
    }

    @Override
    public void validate(PessoaDTO pessoaDTO) {

        if(pessoaDTO.getUsername() == null){
            throw new RuntimeException("Nome de usuário ausente");
        }
        this.nextProcess.validate(pessoaDTO);
    }
}

   
