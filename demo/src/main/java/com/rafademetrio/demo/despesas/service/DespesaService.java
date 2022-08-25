package com.rafademetrio.demo.despesas.service;

import com.rafademetrio.demo.despesas.model.Despesa;
import com.rafademetrio.demo.despesas.model.DespesaInputDTO;
import com.rafademetrio.demo.despesas.model.DespesaOutputDTO;
import com.rafademetrio.demo.despesas.repository.DespesaRepository;
import com.rafademetrio.demo.usuario.model.Usuario;
import com.rafademetrio.demo.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DespesaService {

    @Autowired
    DespesaRepository despesaRepository;

    @Autowired
    UsuarioService usuarioService;

    public ResponseEntity<DespesaOutputDTO> adicionarDespesa (DespesaInputDTO despesaInputDTO){
        Usuario usuario = usuarioService.findById(despesaInputDTO.getUsuarioId());
        Despesa despesa = new Despesa(despesaInputDTO.getValor(), LocalDate.now(), usuario);
        despesaRepository.save(despesa);

        usuarioService.atualizarSaldoDespesa(usuario, despesa);

        DespesaOutputDTO despesaResponse = new DespesaOutputDTO(despesa);


        return new ResponseEntity<>(despesaResponse, HttpStatus.CREATED);
    }
}
