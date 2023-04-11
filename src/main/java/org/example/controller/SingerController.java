package org.example.controller;

import org.example.model.Singer;
import org.example.service.ISingerService;

import java.util.List;
import java.util.Optional;

public class SingerController {
    private ISingerService singerService;

    public SingerController(ISingerService singerService) {
        this.singerService = singerService;
    }

    public Singer create(Singer singer) {
        return singerService.create(singer);
    }

    public void getAll() {
        List<Singer> singers = singerService.getAll();
        singers.stream().map(singer -> singer.toString()).forEach(System.out::println);
    }

    public Singer findById(Integer id) {
        return singerService.getById(id);
    }

    public void findByName(String name) {
        Optional<Singer> singer = singerService.getByName(name);
        singer.stream().map(singer1 -> singer1.toString()).forEach(System.out::println);
    }

    public Singer update(Singer singer, Integer id) {
        return singerService.update(singer, id);
    }

    public void delete(Integer id) {
        singerService.delete(id);
    }
}
