package org.example.repository;

import org.example.model.Genre;
import org.example.model.mapper.GenreMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class GenreRepository implements IGenreRepository {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT_GENRE = "insert into genre (genre_name) values (?)";
    private final String SQL_GET_ALL = "select * from genre";
    private final String SQL_FIND_BY_NAME = "select * from genre where genre_name = ?";
    private final String SQL_FIND_BY_ID = "select * from genre where id = ?";
    private final String SQL_UPDATE_GENRE = "update genre set genre_name = ? where id = ?";
    private final String SQL_DELETE_ID = "delete from genre where id = ?";

    public GenreRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Genre create(Genre genre) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_INSERT_GENRE, genre.getGenreName());
            if (result <= 0) {
                throw new Exception("Failed to add genre");
            } else {
                System.out.println("Successfully add genre");
                System.out.println(genre);
            }
            return genre;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Genre> getAll() throws Exception {
        try {
            return jdbcTemplate.query(SQL_GET_ALL, new GenreMapper());
        } catch (DataAccessException e) {
            throw new Exception("Failed to display genre");
        }
    }

    @Override
    public Genre findById(Integer id) throws Exception {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new GenreMapper(), id);
        } catch (DataAccessException e) {
            throw new Exception("Genre not found");
        }
    }

    @Override
    public Optional<Genre> findByName(String genreName) throws Exception {
        try {
            Genre genre = jdbcTemplate.queryForObject(SQL_FIND_BY_NAME, new GenreMapper(), new Object[]{genreName});
            return Optional.ofNullable(genre);
        } catch (DataAccessException e) {
            throw new Exception("Genre not found");
        }
    }

    @Override
    public Genre update(Genre genre, Integer id) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_UPDATE_GENRE, genre.getGenreName(), id);
            if (result <= 0) {
                throw new Exception("Failed to update genre");
            } else {
                System.out.println("Successfully update genre");
                System.out.println("id : "+id);
                System.out.println("genreName : "+genre.getGenreName());
            }
            return genre;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_DELETE_ID, id);
            if (result <= 0) {
                System.out.println("Failed to delete genre");
            } else {
                System.out.println("Successfully deleted genre with id "+id);
            }
        } catch (DataAccessException e) {
            System.out.print("Failed to delete genre");
        }
    }
}
