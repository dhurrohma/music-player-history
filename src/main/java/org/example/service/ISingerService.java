package org.example.service;

import org.example.model.Singer;

import java.util.List;
import java.util.Optional;

public interface ISingerService {
    Singer create(Singer singer);
    List<Singer> getAll();
    Singer getById(Integer id);
    Optional<Singer> getByName(String name);
    Singer update(Singer singer, Integer id);
    void delete(Integer id);
}
