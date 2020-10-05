package br.com.softplan.avaliacaoairton.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO - Descrever o motivo da classe ter sido criada.
 *
 * @author airton.cruz
 * @since 1.0 (29/09/2020)
 */
@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 150)
    private String dsNome;

    @NotNull
    @CPF
    private String cpf;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dtNascimento;

    @NotNull
    @Email
    @Size(max = 400)
    private String email;

    private String foto;

    @NotNull
    private Boolean fgAtivo = true;

}
