package org.example.service;

import org.example.model.SongWriter;

import java.util.List;
import java.util.Optional;

public interface ISongWriterService {
    SongWriter create(SongWriter songWriter);
    List<SongWriter> getAll();
    SongWriter getById(Integer id);
    Optional<SongWriter> getByName(String name);
    SongWriter update(SongWriter songWriter, Integer id);
    void delete(Integer id);
}
