package org.example.service;

import org.example.model.Song;

import java.util.List;

public interface ISongService {
    Song create(Song song);
    List<Song> getAll();
    Song findById(Integer id);
    List<Song> getByTitle(String title);
    List<Song> getBySinger(String singerName);
    List<Song> getByGenre(String genreName);
    List<Song> getBySongWriter(String songWriterName);
    List<Song> getByReleaseYear(String year);
    Song update(Song song, Integer id);
    void delete(Integer id);
}
