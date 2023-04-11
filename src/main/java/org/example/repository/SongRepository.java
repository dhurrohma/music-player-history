package org.example.repository;

import org.example.model.Song;
import org.example.model.mapper.SongMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class SongRepository implements ISongRepository{
    private JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT_SONG = "insert into song (title, singer_id, genre_id, song_writer_id, release_year) values (?, ?, ?, ?, ?)";
    private final String SQL_GET_ALL = "select * from song";
    private final String SQL_FIND_BY_ID = "select * from song where id = ?";
    private final String SQL_FIND_BY_TITLE = "select * from song where title like ?";
    private final String SQL_FIND_BY_SINGER = "select song.* from song join singer on song.singer_id = singer.id where singer.name like ?";
    private final String SQL_FIND_BY_GENRE = "select song.* from song join genre on song.genre_id = genre.id where genre.genre_name like ?";
    private final String SQL_FIND_BY_SONG_WRITER = "select song.* from song join song_writer on song.song_writer_id = song_writer.id where song_writer.name like ?";
    private final String SQL_FIND_BY_RELEASE_YEAR = "select * from song where release_year = ?";
    private final String SQL_UPDATE_SONG = "update song set title = ?, singer_id = ?, genre_id = ?, song_writer_id = ?, release_year = ? where id = ?";
    private final String SQL_DELETE_ID = "delete from song where id = ?";

    public SongRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Song create(Song song) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_INSERT_SONG, song.getTitle(), song.getSingerId(), song.getGenreId(), song.getSongWriterId(), song.getReleaseYear());
            if (result <= 0) {
                throw new Exception("Failed to add song");
            } else {
                System.out.println("Successfully add song");
                System.out.println(song);
            }
            return song;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> getAll() throws Exception {
        try {
            return jdbcTemplate.query(SQL_GET_ALL, new SongMapper());
        } catch (DataAccessException e) {
            throw new Exception("Failed to display song");
        }
    }

    @Override
    public Song findById(Integer id) throws Exception {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new SongMapper(), id);
        } catch (DataAccessException e) {
            throw new Exception("Song not found");
        }
    }

    @Override
    public List<Song> getByTitle(String title) throws Exception {
        try {
            return jdbcTemplate.query(SQL_FIND_BY_TITLE, new SongMapper(), "%"+title+"%");
        } catch (DataAccessException e) {
            throw new Exception("Song not found");
        }
    }

    @Override
    public List<Song> getBySinger(String singerName) throws Exception {
        try {
            return jdbcTemplate.query(SQL_FIND_BY_SINGER, new SongMapper(), "%"+singerName+"%");
        } catch (DataAccessException e) {
            throw new Exception("Song not found");
        }
    }

    @Override
    public List<Song> getByGenre(String genreName) throws Exception {
        try {
            return jdbcTemplate.query(SQL_FIND_BY_GENRE, new SongMapper(), "%"+genreName+"%");
        } catch (DataAccessException e) {
            throw new Exception("Song not found");
        }
    }

    @Override
    public List<Song> getBySongWriter(String songWriterName) throws Exception {
        try {
            return jdbcTemplate.query(SQL_FIND_BY_SONG_WRITER, new SongMapper(), "%"+songWriterName+"%");
        } catch (DataAccessException e) {
            throw new Exception("Song not found");
        }
    }

    @Override
    public List<Song> getByReleaseYear(String year) throws Exception {
        try {
            return jdbcTemplate.query(SQL_FIND_BY_RELEASE_YEAR, new SongMapper(), year);
        } catch (DataAccessException e) {
            throw new Exception("Song not found");
        }
    }

    @Override
    public Song update(Song song, Integer id) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_UPDATE_SONG, song.getTitle(), song.getSingerId(), song.getGenreId(), song.getSongWriterId(), song.getReleaseYear(), id);
            if (result <= 0) {
                throw new Exception("Failed to update song");
            } else {
                System.out.println("Successfully update singer with id "+id);
                System.out.println(song);
            }
            return song;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_DELETE_ID, id);
            if (result <= 0){
                System.out.println("Failed to delete song");
            } else {
                System.out.println("Successfully deleted song with id "+id);
            }
        } catch (DataAccessException e){
            System.out.println("Failed to delete song");
        }
    }
}
