package com.watt.demo.repository;

import com.watt.demo.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoJPARepository extends JpaRepository<Transacao, Long> {

}
