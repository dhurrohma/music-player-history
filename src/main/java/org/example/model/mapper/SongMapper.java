package org.example.model.mapper;

import org.example.model.Song;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongMapper implements RowMapper<Song> {
    @Override
    public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
        Song song = new Song();
        song.setId(rs.getInt("id"));
        song.setTitle(rs.getString("title"));
        song.setSingerId(rs.getInt("singer_id"));
        song.setGenreId(rs.getInt("genre_id"));
        song.setSongWriterId(rs.getInt("song_writer_id"));
        song.setReleaseYear(rs.getString("release_year"));
        return song;
    }
}
