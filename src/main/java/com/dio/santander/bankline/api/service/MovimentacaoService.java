package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Conta;
import model.Correntista;
import model.Movimentacao;
import model.MovimentacaoTipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoService {

	@Autowired
    private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;

    public List<Movimentacao> listarCorrentistas(){
        return movimentacaoRepository.findAll();
    }

    public void addCorrentista(NovaMovimentacao novaMovimentacao) {
    	
    	Double valor = novaMovimentacao.getMovimentacaoTipo()==MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setMovimentacaoTipo(novaMovimentacao.getMovimentacaoTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista != null) {
        	correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
        	correntistaRepository.save(correntista);
        }
        
        this.movimentacaoRepository.save(movimentacao);
    }
}
