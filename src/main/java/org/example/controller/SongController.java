package org.example.controller;

import org.example.model.Song;
import org.example.service.ISongService;

import java.util.List;

public class SongController {
    private ISongService songService;

    public SongController(ISongService songService) {
        this.songService = songService;
    }

    public Song create(Song song) {
        return songService.create(song);
    }

    public void getAll() {
        List<Song> songs = songService.getAll();
        songs.stream().map(song -> song.toString()).forEach(System.out::println);
    }

    public Song findById(Integer id) {
        return songService.findById(id);
    }

    public void findByTitle(String title) {
        List<Song> songs = songService.getByTitle(title);
        songs.stream().map(song -> song.toString()).forEach(System.out::println);
    }

    public void findBySinger(String singerName) {
        List<Song> songs = songService.getBySinger(singerName);
        songs.stream().map(song -> song.toString()).forEach(System.out::println);
    }

    public void findByGenre(String genreName) {
        List<Song> songs = songService.getByGenre(genreName);
        songs.stream().map(song -> song.toString()).forEach(System.out::println);
    }

    public void findBySongWriter(String songWriterName) {
        List<Song> songs = songService.getBySongWriter(songWriterName);
        songs.stream().map(song -> song.toString()).forEach(System.out::println);
    }

    public void findByReleaseYear(String year) {
        List<Song> songs = songService.getByReleaseYear(year);
        songs.stream().map(song -> song.toString()).forEach(System.out::println);
    }

    public Song update(Song song, Integer id) {
        return songService.update(song, id);
    }

    public void delete(Integer id) {
        songService.delete(id);
    }
}
