package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.service.CorrentistaService;
import com.dio.santander.bankline.api.service.MovimentacaoService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Correntista;
import model.Movimentacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoController {

	@Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping("/listar")
    public List<Movimentacao> listarCorrentistas(){
        return this.movimentacaoService.listarCorrentistas();
    }

    @PostMapping
    public void addCorrentista(@RequestBody NovaMovimentacao novaMovimentacao){
        this.movimentacaoService.addCorrentista(novaMovimentacao);
    }
}
