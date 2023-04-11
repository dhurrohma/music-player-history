package org.example.service;

import org.example.model.Singer;
import org.example.repository.ISingerRepository;

import java.util.List;
import java.util.Optional;

public class SingerService implements ISingerService {
    private ISingerRepository singerRepository;

    public SingerService(ISingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    @Override
    public Singer create(Singer singer) {
        try {
            return singerRepository.create(singer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Singer> getAll() {
        try {
            return singerRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Singer getById(Integer id) {
        try {
            Singer singer = singerRepository.findById(id);
            System.out.println(singer);
            return singer;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Singer> getByName(String name) {
        try {
            return singerRepository.getByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Singer update(Singer singer, Integer id) {
        try {
            return singerRepository.update(singer, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            singerRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
