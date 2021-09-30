package com.watt.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue
    private Long idConta;
    private Long idPessoa;
    private Double saldo;
    private Double limiteSaqueDiario;
    private Boolean flagAtivo;
    private Long tipoConta;
    private Date dataCriacao;

}
