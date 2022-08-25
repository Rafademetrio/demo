package com.rafademetrio.demo.despesas.repository;

import com.rafademetrio.demo.despesas.model.Despesa;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DespesaRepository extends PagingAndSortingRepository<Despesa, Integer> {

    public Iterable<Despesa> findByUsuarioId(Integer usuarioId);


}
