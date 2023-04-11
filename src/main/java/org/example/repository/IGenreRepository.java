package org.example.repository;

import org.example.model.Genre;

import java.util.List;
import java.util.Optional;

public interface IGenreRepository {
    Genre create(Genre genre) throws Exception;
    List<Genre> getAll() throws Exception;
    Genre findById(Integer id) throws Exception;
    Optional<Genre> findByName(String genreName) throws Exception;
    Genre update(Genre genre, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
