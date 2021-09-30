package com.watt.demo.services;

import com.watt.demo.models.Conta;
import com.watt.demo.repository.ContaJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaJPARepository contaJPARepository;

    public Conta postConta(Conta conta) {//inserir anotacao para esperar que seja informado o json e parsear
        return contaJPARepository.save(conta);
    }

    public Conta editContaSaldo(Long id, Double valor) {
        Conta conta = contaJPARepository.getById(id);
        if ((conta.getSaldo()+valor)<0){
            new RuntimeException("Nao é possível abater mais do que o saldo.");
            return null;
        } else {
            return contaJPARepository.save(contaJPARepository.findById(id).map((contraRetrieved)->{
                contraRetrieved.setSaldo(contraRetrieved.getSaldo()+valor);
                return contraRetrieved;
            }).orElseThrow(()-> new RuntimeException("Conta não encontrada")));
        }
    }

    public Conta findByIdConta(Long id) {
        return contaJPARepository.findById(id).orElseThrow(()-> new RuntimeException("Conta não encontrada"));
    }

    public Conta bloqueiaConta(Long id) {
        return contaJPARepository.save(contaJPARepository.findById(id).map((contraRetrieved)->{
            contraRetrieved.setFlagAtivo(false);
            return contraRetrieved;
        }).orElseThrow(()-> new RuntimeException("Conta não encontrada")));
    }

}
