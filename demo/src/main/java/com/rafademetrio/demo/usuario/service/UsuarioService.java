package com.rafademetrio.demo.usuario.service;

import com.rafademetrio.demo.despesas.model.Despesa;
import com.rafademetrio.demo.receitas.model.Receita;
import com.rafademetrio.demo.usuario.model.Usuario;
import com.rafademetrio.demo.usuario.model.UsuarioInputDTO;
import com.rafademetrio.demo.usuario.model.UsuarioOutputDTO;
import com.rafademetrio.demo.usuario.repository.UsuarioRepository;
import com.rafademetrio.demo.usuario.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario findById(int id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElseThrow(() -> new ObjectNotFoundException("usuario não encontrado! ID: " + id));
    }

    public Iterable<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }


    public ResponseEntity<UsuarioOutputDTO> save(UsuarioInputDTO usuarioInputDTO) {
        Usuario usuario;
        if(usuarioInputDTO.getId() == null) {
            usuario = criarUsuario(usuarioInputDTO);
        } else{
            Usuario usuarioBanco = this.findById(usuarioInputDTO.getId());
            usuario = atualizarCampos(usuarioInputDTO,usuarioBanco);
        }
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        UsuarioOutputDTO usuarioResponse = new UsuarioOutputDTO();

        return new ResponseEntity<UsuarioOutputDTO>(usuarioResponse, HttpStatus.CREATED);
    }



    private static Usuario criarUsuario(UsuarioInputDTO usuarioInputDTO) {
        Usuario usuario = new Usuario();
        return atualizarCampos(usuarioInputDTO, usuario);
    }

    private static Usuario atualizarCampos(UsuarioInputDTO usuarioDTO, Usuario usuario) {
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setSaldo(usuarioDTO.getSaldo());
        return usuario;
    }

    public ResponseEntity<UsuarioOutputDTO> atualizarSaldoReceita (Usuario usuario, Receita receita){
        usuario.setSaldo(usuario.getSaldo() + receita.getValor());
        usuarioRepository.save(usuario);

        return new ResponseEntity<UsuarioOutputDTO>(new UsuarioOutputDTO(usuario), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<UsuarioOutputDTO> atualizarSaldoDespesa (Usuario usuario, Despesa despesa){
        usuario.setSaldo(usuario.getSaldo() - despesa.getValor());
        usuarioRepository.save(usuario);


        return new ResponseEntity<UsuarioOutputDTO>(new UsuarioOutputDTO(usuario), HttpStatus.ACCEPTED);
    }


}
