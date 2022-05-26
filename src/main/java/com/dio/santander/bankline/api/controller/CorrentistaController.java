package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.service.CorrentistaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Correntista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
@AllArgsConstructor
@NoArgsConstructor
public class CorrentistaController {

	@Autowired
    private CorrentistaService correntistaService;

    @GetMapping("/listar")
    public List<Correntista> listarCorrentistas(){
        return this.correntistaService.listarCorrentistas();
    }

    @PostMapping
    public void addCorrentista(@RequestBody NovoCorrentista novoCorrentista){
        this.correntistaService.addCorrentista(novoCorrentista);
    }
}
