package org.example.repository;

import org.example.model.History;

import java.time.LocalDate;
import java.util.List;

public interface IHistoryRepository {
    History create(History history) throws Exception;
    List<History> getAll() throws Exception;
    History findById(Integer id) throws Exception;
    List<History> getByDate(LocalDate datePlay) throws Exception;
    List<History> getBySong(String title) throws Exception;
    History update(History history, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
