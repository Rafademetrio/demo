package com.rafademetrio.demo.despesas.controller;

import com.rafademetrio.demo.despesas.model.DespesaInputDTO;
import com.rafademetrio.demo.despesas.model.DespesaOutputDTO;
import com.rafademetrio.demo.despesas.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/despesa")
public class DespesaController {

    @Autowired
    DespesaService despesaService;


    @PostMapping
    public ResponseEntity<DespesaOutputDTO> adicionarDespesa(@Valid @RequestBody DespesaInputDTO despesaInputDTO) {
        return despesaService.adicionarDespesa(despesaInputDTO);
    }


}
