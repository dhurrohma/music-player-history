package org.example.service;

import org.example.model.Genre;

import java.util.List;
import java.util.Optional;

public interface IGenreService {
    Genre create(Genre genre);
    List<Genre> getAll();
    Genre getById(Integer id);
    Optional<Genre> getByName(String genreName);
    Genre update(Genre genre, Integer id);
    void delete(Integer id);
}
