package org.example.service;

import org.example.model.Genre;
import org.example.repository.IGenreRepository;

import java.util.List;
import java.util.Optional;

public class GenreService implements IGenreService {
    private IGenreRepository genreRepository;

    public GenreService(IGenreRepository bookRepository) {
        this.genreRepository = bookRepository;
    }

    @Override
    public Genre create(Genre genre) {
        try {
            return genreRepository.create(genre);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Genre> getAll() {
        try {
            return genreRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Genre getById(Integer id) {
        try {
            return genreRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Genre> getByName(String genreName) {
        try {
            return genreRepository.findByName(genreName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Genre update(Genre genre, Integer id){
        try {
            return genreRepository.update(genre, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            genreRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
