package com.example.pocFavorecido;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ricardo on 05/01/18.
 */
@Repository
public interface FavorecidoRepository  extends MongoRepository<Favorecido, String> {

    List<Favorecido> findByFeatureName(final String name);

    List<Favorecido> findByIdtUser(final String idtUser);


}
