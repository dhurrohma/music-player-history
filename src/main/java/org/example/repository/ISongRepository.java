package org.example.repository;

import org.example.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongRepository {
    Song create(Song song) throws Exception;
    List<Song> getAll() throws Exception;
    Song findById(Integer id) throws Exception;
    List<Song> getByTitle(String title) throws Exception;
    List<Song> getBySinger(String singerName) throws Exception;
    List<Song> getByGenre(String genreName) throws Exception;
    List<Song> getBySongWriter(String songWriterName) throws Exception;
    List<Song> getByReleaseYear(String year) throws Exception;
    Song update(Song song, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
