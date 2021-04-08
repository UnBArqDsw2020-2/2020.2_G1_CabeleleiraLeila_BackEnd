package br.unb.leilas.api.services.validator;

import br.unb.leilas.api.domain.entities.dto.PessoaDTO;

public interface SignupProcess  {

    void next(SignupProcess signupProcessor);
    void validate(PessoaDTO pessoaDTO);
}
