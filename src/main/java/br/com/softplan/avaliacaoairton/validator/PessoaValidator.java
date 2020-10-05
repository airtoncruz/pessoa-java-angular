package br.com.softplan.avaliacaoairton.validator;

import br.com.softplan.avaliacaoairton.commons.exception.DoubleCpfFoundException;
import br.com.softplan.avaliacaoairton.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.softplan.avaliacaoairton.model.Pessoa;

/**
 * Classe responsável por validar as operacoes que envolvem {@link Pessoa}.
 *
 * @author airton.cruz
 * @since 1.0 (29/09/2020)
 */
@Component
public class PessoaValidator {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void validate(Pessoa pessoa) throws DoubleCpfFoundException {

        if (pessoaRepository.countByCpf(pessoa.getCpf(), pessoa.getId()) > 0) {

            throw new DoubleCpfFoundException();
        }
    }
}
