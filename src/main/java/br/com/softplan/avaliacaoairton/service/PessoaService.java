package br.com.softplan.avaliacaoairton.service;

import java.time.LocalDate;
import java.util.Objects;

import br.com.softplan.avaliacaoairton.commons.exception.DoubleCpfFoundException;
import br.com.softplan.avaliacaoairton.commons.exception.ResourceNotFoundException;
import br.com.softplan.avaliacaoairton.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.softplan.avaliacaoairton.model.Pessoa;
import br.com.softplan.avaliacaoairton.validator.PessoaValidator;

import javax.transaction.Transactional;

/**
 * Service responsável pelas operacoes que envolvem a classe @{@link Pessoa}.
 *
 * @author airton.cruz
 * @since 1.0 (29/09/2020)
 */
@Service
@Transactional
public class PessoaService  {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaValidator pessoaValidator;

    public Page<Pessoa> search(String dsNome, String cpf, String email, LocalDate dtNascimento, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);

        if (Objects.isNull(dsNome) && Objects.isNull(cpf) &&Objects.isNull(email) && Objects.isNull(dtNascimento)) {

            return pessoaRepository.searchWithOutFilter(pageRequest);
        }

        return pessoaRepository.search(dsNome, cpf, email, pageRequest);
    }

    public Pessoa findOne(Long id) throws Exception {

        return pessoaRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Pessoa save(Pessoa pessoa) throws DoubleCpfFoundException {

        pessoaValidator.validate(pessoa);

        return pessoaRepository.save(pessoa);
    }

    public Pessoa update(Pessoa pessoa) throws DoubleCpfFoundException {

        pessoaValidator.validate(pessoa);

        return pessoaRepository.save(pessoa);
    }

    public void delete(Long id) throws Exception {

        pessoaRepository.inative(id);

        //Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        //pessoaRepository.delete(pessoa);

    }
}
