package br.com.softplan.avaliacaoairton.repository;

import br.com.softplan.avaliacaoairton.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Interface de repositorio de {@link Pessoa}.
 *
 * @author airton.cruz
 * @since 1.0 (29/09/2020)
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("FROM Pessoa c WHERE (:dsNome is not null and LOWER(c.dsNome) like %:dsNome%) OR (:cpf is not null and c.cpf like %:cpf%) OR (:email is not null and c.email like %:email%) AND fgAtivo = true")
    Page<Pessoa> search(@Param("dsNome") String dsNome, @Param("cpf") String cpf, @Param("email") String email, Pageable pageable);

    @Query("FROM Pessoa p WHERE fgAtivo = true")
    Page<Pessoa> searchWithOutFilter(Pageable pageable);

    @Query("SELECT COUNT(p) FROM Pessoa p WHERE p.cpf like %:cpf% AND p.id != :id")
    Long countByCpf(@Param("cpf") String cpf, @Param("id") Long id);

    @Modifying
    @Query("update Pessoa p set p.fgAtivo = false WHERE p.id = :id")
    int inative(@Param("id") Long id);

}
