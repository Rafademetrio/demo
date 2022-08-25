package com.rafademetrio.demo.receitas.service;

import com.rafademetrio.demo.receitas.model.Receita;
import com.rafademetrio.demo.receitas.model.ReceitaInputDTO;
import com.rafademetrio.demo.receitas.model.ReceitaOutputDTO;
import com.rafademetrio.demo.receitas.repository.ReceitaRepository;
import com.rafademetrio.demo.usuario.model.Usuario;
import com.rafademetrio.demo.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository receitaRepository;

    @Autowired
    UsuarioService usuarioService;


    public ResponseEntity<ReceitaOutputDTO> adicionarReceita(ReceitaInputDTO receitaInputDTO) {

        Usuario usuario = usuarioService.findById(receitaInputDTO.getUsuarioId());
        Receita receita = new Receita(receitaInputDTO.getValor(), LocalDate.now(), usuario);
        receitaRepository.save(receita);

        usuarioService.atualizarSaldoReceita(usuario, receita);

        ReceitaOutputDTO receitaResponse = new ReceitaOutputDTO(receita);
        return new ResponseEntity<ReceitaOutputDTO>(receitaResponse, HttpStatus.CREATED);
    }


    public Iterable<Receita> findByUsuarioId(Integer usuarioId) {

        return receitaRepository.findByUsuarioId(usuarioId);
    }

    public Iterable<Receita> findAll(){
        return receitaRepository.findAll();
    }
}
