package org.example.repository;

import org.example.model.SongWriter;

import java.util.List;
import java.util.Optional;

public interface ISongWriterRepository {
    SongWriter create(SongWriter songWriter) throws Exception;
    List<SongWriter> getAll() throws Exception;
    SongWriter findById(Integer id) throws Exception;
    Optional<SongWriter> getByName(String name) throws Exception;
    SongWriter update(SongWriter songWriter, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
