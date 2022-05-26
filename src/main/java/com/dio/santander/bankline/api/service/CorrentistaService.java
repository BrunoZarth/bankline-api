package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Conta;
import model.Correntista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CorrentistaService {

	@Autowired
    private CorrentistaRepository correntistaRepository;

    public List<Correntista> listarCorrentistas(){
        return correntistaRepository.findAll();
    }

    public void addCorrentista(NovoCorrentista novoCorrentista) {
        Correntista correntista = new Correntista();
        correntista.setNome(novoCorrentista.getNome());
        correntista.setCpf(novoCorrentista.getCpf());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());
        correntista.setConta(conta);

        this.correntistaRepository.save(correntista);
    }
}
