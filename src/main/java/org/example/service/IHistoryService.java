package org.example.service;

import org.example.model.History;

import java.time.LocalDate;
import java.util.List;

public interface IHistoryService {
    History create(History history);
    List<History> getAll();
    History getById(Integer id);
    List<History> getByDate(LocalDate datePlay);
    List<History> getBySong(String title);
    History update(History history, Integer id);
    void delete(Integer id);
}
