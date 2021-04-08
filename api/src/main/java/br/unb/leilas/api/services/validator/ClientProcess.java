package br.unb.leilas.api.services.validator;

import br.unb.leilas.api.domain.entities.dto.PessoaDTO;

public class ClientProcess {

    public void validate(PessoaDTO pessoaDTO) {
        SignupProcess usernameIsNotEmptyProcess = new UsernameIsNotEmptyProcess();
        SignupProcess passwordIsNotEmptyProcess = new PasswordIsNotEmptyProcess();
        SignupProcess passwordIsEqualProcess = new PasswordIsEqualProcess();

        usernameIsNotEmptyProcess.next(passwordIsNotEmptyProcess);
        passwordIsNotEmptyProcess.next(passwordIsEqualProcess);

        usernameIsNotEmptyProcess.validate(pessoaDTO);

    }

}
