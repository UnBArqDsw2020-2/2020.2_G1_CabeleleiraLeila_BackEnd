package br.unb.leilas.api.services.validator;

import br.unb.leilas.api.domain.entities.dto.PessoaDTO;

public class PasswordIsEqualProcess implements SignupProcess {

    @Override
    public void next(SignupProcess signupProcessor) {
    }

    @Override
    public void validate(PessoaDTO pessoaDTO) {
        if (!pessoaDTO.getPassword1().equals(pessoaDTO.getPassword2())) {
            throw new RuntimeException("Senhas não são iguais");
        }
    }

}
