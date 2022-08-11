package com.rafademetrio.demo.usuario.controller;

import com.rafademetrio.demo.usuario.entity.Usuario;
import com.rafademetrio.demo.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(path="/todos")
    public Iterable<Usuario> getUsuario(){
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario inlucirUsuario(@RequestParam String nome){
        Usuario usuario = new Usuario(nome);
        usuarioRepository.save(usuario);
        return usuario;
    }


}
