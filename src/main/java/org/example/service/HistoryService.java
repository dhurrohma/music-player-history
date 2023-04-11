package org.example.service;

import org.example.model.History;
import org.example.repository.IHistoryRepository;

import java.time.LocalDate;
import java.util.List;

public class HistoryService implements IHistoryService{
    private IHistoryRepository historyRepository;

    public HistoryService(IHistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public History create(History history) {
        try {
            return historyRepository.create(history);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<History> getAll() {
        try {
            return historyRepository.getAll();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public History getById(Integer id) {
        try {
            History history = historyRepository.findById(id);
            System.out.println(history);
            return history;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<History> getByDate(LocalDate datePlay) {
        try {
            return historyRepository.getByDate(datePlay);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<History> getBySong(String title) {
        try {
            return historyRepository.getBySong(title);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public History update(History history, Integer id) {
        try {
            return historyRepository.update(history, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            historyRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
