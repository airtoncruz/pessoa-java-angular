package br.com.softplan.avaliacaoairton.endpoint;

import java.time.LocalDate;

import br.com.softplan.avaliacaoairton.commons.exception.DoubleCpfFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.softplan.avaliacaoairton.AvaliacaoairtonApplication;
import br.com.softplan.avaliacaoairton.model.Pessoa;
import br.com.softplan.avaliacaoairton.service.PessoaService;

/**
 * Endpoint responsável por tratar todas as requests a API relacionadas a @{@link Pessoa}.
 *
 * @author airton.cruz
 * @since 1.0 (29/09/2020)
 */
@RestController
@CrossOrigin(value = AvaliacaoairtonApplication.URL)
@RequestMapping("/pessoa")
@Validated
public class PessoaEndpoint  {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public Page<Pessoa> search(@RequestParam(required=false) String dsNome,
                               @RequestParam(required=false) String cpf,
                               @RequestParam(required=false) String email,
                               @RequestParam(required=false) LocalDate dtNascimento,
                               @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                               @RequestParam(value = "size", required = false, defaultValue = "10") int size) {

        return pessoaService.search(dsNome, cpf, email, dtNascimento, page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findOne(@PathVariable(value = "id") Long id) throws Exception {

        return ResponseEntity.ok().body(pessoaService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa model) throws DoubleCpfFoundException {

        return ResponseEntity.ok().body(pessoaService.save(model));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable(value = "id") Long id, @RequestBody Pessoa model) throws DoubleCpfFoundException {

        return ResponseEntity.ok().body(pessoaService.update(model));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) throws Exception {

        pessoaService.delete(id);
    }
}
