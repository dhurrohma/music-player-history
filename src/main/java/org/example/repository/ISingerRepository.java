package org.example.repository;

import org.example.model.Singer;

import java.util.List;
import java.util.Optional;

public interface ISingerRepository {
    Singer create(Singer singer) throws Exception;
    List<Singer> getAll() throws Exception;
    Singer findById(Integer id) throws Exception;
    Optional<Singer> getByName(String name) throws Exception;
    Singer update(Singer singer, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
