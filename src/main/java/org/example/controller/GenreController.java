package org.example.controller;

import org.example.model.Genre;
import org.example.service.IGenreService;

import java.util.List;
import java.util.Optional;

public class GenreController {
    private IGenreService genreService;

    public GenreController(IGenreService genreService) {
        this.genreService = genreService;
    }

    public Genre create(Genre genre) {
        return genreService.create(genre);
    }

    public void getAll(){
        List<Genre> genres = genreService.getAll();
        genres.stream().map(genre -> genre.toString()).forEach(System.out::println);
    }

    public Genre findById(Integer id) {
        Genre genre = genreService.getById(id);
        System.out.println(genre);
        return genre;
    }

    public void findByName(String genreName) {
        Optional<Genre> genre = genreService.getByName(genreName);
        genre.stream().map(genre1 -> genre1.toString()).forEach(System.out::println);
    }

    public Genre update(Genre genre, Integer id) {
        return genreService.update(genre, id);
    }

    public void delete(Integer id) {
        genreService.delete(id);
    }
}
