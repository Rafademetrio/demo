package com.rafademetrio.demo.receitas.repository;

import com.rafademetrio.demo.receitas.model.Receita;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReceitaRepository extends PagingAndSortingRepository<Receita, Integer> {

//    @Query(value = "SELECT * FROM receita WHERE receita.usuario_id = :usuario_id", nativeQuery = true)
    public Iterable<Receita> findByUsuarioId(Integer usuarioId);

}
