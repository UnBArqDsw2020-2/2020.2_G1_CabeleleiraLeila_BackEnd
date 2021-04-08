package br.unb.leilas.api.services.validator;

import br.unb.leilas.api.domain.entities.dto.PessoaDTO;

public class PasswordIsNotEmptyProcess implements SignupProcess {

    private SignupProcess nextProcess;

    @Override
    public void next(SignupProcess signupProcessor) {
        this.nextProcess = signupProcessor;

    }

    @Override
    public void validate(PessoaDTO pessoaDTO) {

        if (pessoaDTO.getPassword1() == null || pessoaDTO.getPassword2() == null) {
            throw new RuntimeException("Senha vazia");
        }
        this.nextProcess.validate(pessoaDTO);
    }

}
