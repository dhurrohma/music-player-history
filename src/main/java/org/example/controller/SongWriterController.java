package org.example.controller;

import org.example.model.SongWriter;
import org.example.service.ISongWriterService;

import java.util.List;
import java.util.Optional;

public class SongWriterController {
    private ISongWriterService songWriterService;

    public SongWriterController(ISongWriterService songWriterService) {
        this.songWriterService = songWriterService;
    }

    public SongWriter create(SongWriter songWriter) {
        return songWriterService.create(songWriter);
    }

    public void getAll() {
        List<SongWriter> songWriters = songWriterService.getAll();
        songWriters.stream().map(songWriter -> songWriter.toString()).forEach(System.out::println);
    }

    public SongWriter findById(Integer id) {
        return songWriterService.getById(id);
    }

    public void findByName(String name) {
        Optional<SongWriter> songWriter = songWriterService.getByName(name);
        songWriter.stream().map(songWriter1 -> songWriter1.toString()).forEach(System.out::println);
    }

    public SongWriter update(SongWriter songWriter, Integer id) {
        return songWriterService.update(songWriter, id);
    }

    public void delete(Integer id) {
        songWriterService.delete(id);
    }
}
