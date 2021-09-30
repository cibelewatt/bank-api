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
public class Transacao {

    @Id
    @GeneratedValue
    private Long idTransacao;
    private Long idConta;
    private Double valor;
    private Date dataTransacao;
}
