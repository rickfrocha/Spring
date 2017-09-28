package com.example.testeDB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ricardo on 27/09/17.
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Integer>{
}
