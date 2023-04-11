package org.example.service;

import org.example.model.Song;
import org.example.repository.ISongRepository;

import java.util.List;

public class SongService implements ISongService{
    private ISongRepository songRepository;

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song create(Song song){
        try {
            return songRepository.create(song);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> getAll(){
        try {
            return songRepository.getAll();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Song findById(Integer id){
        try {
            Song song = songRepository.findById(id);
            System.out.println(song);
            return song;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> getByTitle(String title){
        try {
            return songRepository.getByTitle(title);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> getBySinger(String singerName){
        try {
            return songRepository.getBySinger(singerName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> getByGenre(String genreName){
        try {
            return songRepository.getByGenre(genreName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> getBySongWriter(String songWriterName) {
        try {
            return songRepository.getBySongWriter(songWriterName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> getByReleaseYear(String year) {
        try {
            return songRepository.getByReleaseYear(year);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Song update(Song song, Integer id) {
        try {
            return songRepository.update(song, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            songRepository.delete(id);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
