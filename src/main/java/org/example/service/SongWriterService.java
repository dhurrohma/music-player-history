package org.example.service;

import org.example.model.SongWriter;
import org.example.repository.ISongWriterRepository;

import java.util.List;
import java.util.Optional;

public class SongWriterService implements ISongWriterService {
    private ISongWriterRepository songWriterRepository;

    public SongWriterService(ISongWriterRepository songWriterRepository) {
        this.songWriterRepository = songWriterRepository;
    }

    @Override
    public SongWriter create(SongWriter songWriter) {
        try {
            return songWriterRepository.create(songWriter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SongWriter> getAll() {
        try {
            return songWriterRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SongWriter getById(Integer id) {
        try {
            SongWriter songWriter = songWriterRepository.findById(id);
            System.out.println(songWriter);
            return songWriter;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<SongWriter> getByName(String name) {
        try {
            return songWriterRepository.getByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SongWriter update(SongWriter songWriter, Integer id) {
        try {
            return songWriterRepository.update(songWriter, id);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            songWriterRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
