package com.rafademetrio.demo.receitas.controller;

import com.rafademetrio.demo.receitas.model.Receita;
import com.rafademetrio.demo.receitas.model.ReceitaInputDTO;
import com.rafademetrio.demo.receitas.model.ReceitaOutputDTO;
import com.rafademetrio.demo.receitas.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/receita")
public class ReceitaController {


    @Autowired
    ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<ReceitaOutputDTO> adicionarReceita(@Valid @RequestBody ReceitaInputDTO receitaInputDTO){
       return receitaService.adicionarReceita(receitaInputDTO);

    }

    @GetMapping(path = "/receitaporusuario/{usuarioId}")
    public Iterable<Receita> findByUsuarioId(@PathVariable int usuarioId){
        return receitaService.findByUsuarioId(usuarioId);
    }

    @GetMapping(path = "/receitaporusuario")
    public Iterable<Receita> findByUsuarioIdReqest(@RequestParam int usuarioId){
        return receitaService.findByUsuarioId(usuarioId);
    }


    @GetMapping(path = "/todasreceitas")
    public Iterable<Receita> getReceitas(){
        return receitaService.findAll();
    }

}
