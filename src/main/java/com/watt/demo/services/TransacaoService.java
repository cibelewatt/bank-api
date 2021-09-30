package com.watt.demo.services;

import com.watt.demo.models.Transacao;
import com.watt.demo.repository.TransacaoJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoJPARepository transacaoJPARepository;

    public List<Transacao> getTransacoes(Long id) {
        return transacaoJPARepository.findAll()
                .stream()
                .filter(transacao-> transacao.getIdConta()==id)
                .collect(Collectors.toList());
    }

    public Transacao postTransacao(Transacao transacao){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        transacao.setDataTransacao(date);
        return transacaoJPARepository.save(transacao);
    }

}
