package org.example.repository;

import org.example.model.Singer;
import org.example.model.mapper.SingerMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class SingerRepository implements ISingerRepository{
    private JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT_SINGER = "insert into singer (name) values (?)";
    private final String SQL_GET_ALL = "select * from singer";
    private final String SQL_FIND_BY_ID = "select * from singer where id = ?";
    private final String SQL_FIND_BY_NAME = "select * from singer where name like ?";
    private final String SQL_UPDATE_SINGER = "update singer set name = ? where id = ?";
    private final String SQL_DELETE_ID = "delete from singer where id = ?";

    public SingerRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Singer create(Singer singer) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_INSERT_SINGER, singer.getName());
            if (result <= 0) {
                throw new Exception("Failed to add singer");
            } else {
                System.out.println("Successfully add singer "+singer.getName());
            }
            return singer;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Singer> getAll() throws Exception {
        try {
            return jdbcTemplate.query(SQL_GET_ALL, new SingerMapper());
        } catch (DataAccessException e) {
            throw new Exception("Failed to display singer");
        }
    }

    @Override
    public Singer findById(Integer id) throws Exception {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new SingerMapper(), id);
        } catch (DataAccessException e) {
            throw new Exception("Singer not found");
        }
    }

    @Override
    public Optional<Singer> getByName(String name) throws Exception {
        try {
            Singer singer = jdbcTemplate.queryForObject(SQL_FIND_BY_NAME, new SingerMapper(), "%"+name+"%");
            return Optional.ofNullable(singer);
        } catch (DataAccessException e) {
            throw new Exception("Singer not found");
        }
    }

    @Override
    public Singer update(Singer singer, Integer id) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_UPDATE_SINGER, singer.getName(), id);
            if (result <= 0) {
                throw new Exception("Failed to update singer");
            } else {
                System.out.println("Successfully update singer");
                System.out.println("id : "+id);
                System.out.println("name : "+singer.getName());
            }
            return singer;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_DELETE_ID, id);
            if (result <= 0) {
                System.out.println("Failed to delete singer");
            } else {
                System.out.println("Successfully deleted singer with id "+id);
            }
        } catch (DataAccessException e) {
            System.out.println("Failed to delete singer");
        }
    }
}
