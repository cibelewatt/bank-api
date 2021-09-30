package com.watt.demo.repository;

import com.watt.demo.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaJPARepository extends JpaRepository<Conta, Long> {

}
