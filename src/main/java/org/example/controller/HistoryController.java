package org.example.controller;

import org.example.model.History;
import org.example.service.IHistoryService;

import java.time.LocalDate;
import java.util.List;

public class HistoryController {
    private IHistoryService historyService;

    public HistoryController(IHistoryService historyService) {
        this.historyService = historyService;
    }

    public History create (History history) {
        return historyService.create(history);
    }

    public void getAll() {
        List<History> histories = historyService.getAll();
        histories.stream().map(history -> history.toString()).forEach(System.out::println);
    }

    public History findById(Integer id) {
        return historyService.getById(id);
    }

    public void findByDate(String datePlay) {
        List<History> histories = historyService.getByDate(LocalDate.parse(datePlay));
        histories.stream().map(history -> history.toString()).forEach(System.out::println);
    }

    public void findBySong(String title) {
        List<History> histories = historyService.getBySong(title);
        histories.stream().map(history -> history.toString()).forEach(System.out::println);
    }

    public History update(History history, Integer id) {
        return historyService.update(history, id);
    }

    public void delete(Integer id){
        historyService.delete(id);
    }
}
