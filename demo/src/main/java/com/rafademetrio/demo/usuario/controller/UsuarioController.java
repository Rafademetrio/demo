package com.rafademetrio.demo.usuario.controller;

import com.rafademetrio.demo.usuario.model.Usuario;
import com.rafademetrio.demo.usuario.model.UsuarioEmailInputDTO;
import com.rafademetrio.demo.usuario.model.UsuarioInputDTO;
import com.rafademetrio.demo.usuario.model.UsuarioOutputDTO;
import com.rafademetrio.demo.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path="/todos")
    public Iterable<Usuario> getUsuario(){
        return usuarioService.findAll();
    }

    @GetMapping(path="/usuarioPorId")
    public Usuario getUsuarioPorId(@RequestParam int id){
        return usuarioService.findById(id);
    }

    @PatchMapping(path="/atualizarUsuario")
    public ResponseEntity<UsuarioOutputDTO> autualizarUsuario(@RequestBody UsuarioInputDTO usuarioEmailInputDTO){
        return usuarioService.save(usuarioEmailInputDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioOutputDTO> inlucirUsuario(@Valid @RequestBody UsuarioInputDTO usuarioInputDTO){
        return usuarioService.save(usuarioInputDTO);
    }



}
