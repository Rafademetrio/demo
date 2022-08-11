package com.rafademetrio.demo.usuario.repository;

import com.rafademetrio.demo.usuario.entity.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {
}
