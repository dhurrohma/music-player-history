package org.example.repository;

import org.example.model.SongWriter;
import org.example.model.mapper.SongWritterMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class SongWriterRepository implements ISongWriterRepository{
    private JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT_SONG_WRITER = "insert into song_writer (name) values (?)";
    private final String SQL_GET_ALL = "select * from song_writer";
    private final String SQL_FIND_BY_ID = "select * from song_writer where id = ?";
    private final String SQL_FIND_BY_NAME = "select * from song_writer where name like ?";
    private final String SQL_UPDATE_SONG_WRITER = "update song_writer set name = ? where id = ?";
    private final String SQL_DELETE_BY_ID = "delete from song_writer where id = ?";

    public SongWriterRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public SongWriter create(SongWriter songWriter) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_INSERT_SONG_WRITER, songWriter.getName());
            if(result <= 0) {
                throw new Exception("Failed to add song writer");
            } else {
                System.out.println("Successfully add song writer "+songWriter.getName());
            }
            return songWriter;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SongWriter> getAll() throws Exception {
        try {
            return jdbcTemplate.query(SQL_GET_ALL, new SongWritterMapper());
        } catch (DataAccessException e) {
            throw new Exception("Failed to display song writer");
        }
    }

    @Override
    public SongWriter findById(Integer id) throws Exception {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new SongWritterMapper(), id);
        } catch (DataAccessException e) {
            throw new Exception("Song writer not found");
        }
    }

    @Override
    public Optional<SongWriter> getByName(String name) throws Exception {
        try {
            SongWriter songWriter = jdbcTemplate.queryForObject(SQL_FIND_BY_NAME, new SongWritterMapper(), "%"+name+"%");
            return Optional.ofNullable(songWriter);
        } catch (DataAccessException e) {
            throw new Exception("Song writer not found");
        }
    }

    @Override
    public SongWriter update(SongWriter songWriter, Integer id) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_UPDATE_SONG_WRITER, songWriter.getName(), id);
            if (result <= 0) {
                throw new Exception("Failed to update song writer");
            } else {
                System.out.println("Successfully update song writer");
                System.out.println("id : "+id);
                System.out.println("name : "+songWriter.getName());
            }
            return songWriter;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_DELETE_BY_ID, id);
            if (result <= 0) {
                System.out.println("Failed to delete song writer");
            } else {
                System.out.println("Successfully deleted song writer with id "+id);
            }
        } catch (DataAccessException e) {
            System.out.println("Failed to delete song writer");
        }
    }
}
