package com.watt.demo;

import com.watt.demo.models.Conta;
import com.watt.demo.models.Transacao;
import com.watt.demo.services.ContaService;
import com.watt.demo.services.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/banco")
@AllArgsConstructor
public class BankController {

    private final ContaService contaService;
    private final TransacaoService transacaoService;

    @PostMapping
    public Conta postConta(@RequestBody Conta conta) {
        return contaService.postConta(conta);
    }

    @PostMapping(path="/transact")
    public Conta postTransacao(@RequestBody Transacao transacao){
        transacaoService.postTransacao(transacao);
        return contaService.editContaSaldo(transacao.getIdConta(), transacao.getValor());
    }

    @GetMapping(path = "/{id}")
    public Conta findByIdConta(@PathVariable Long id){ //nome da variavel tem que ser o mesmo do path
        return contaService.findByIdConta(id);
    }

    @PutMapping(path = "/block/{id}")
    public Conta bloqueiaConta(@PathVariable Long id){
        return contaService.bloqueiaConta(id);
    }

    @GetMapping(path = "/conta-transactions/{id}")
    public List<Transacao> getTransacoesConta(@PathVariable Long id){
        return transacaoService.getTransacoes(id);
    }
}
