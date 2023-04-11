package org.example.repository;

import org.example.model.History;
import org.example.model.mapper.HistoryMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

public class HistoryRepository implements IHistoryRepository{
    private JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT_HISTORY = "insert into history (date_play, song_id) values (?, ?)";
    private final String SQL_GET_ALL = "select * from history";
    private final String SQL_FIND_BY_ID = "select * from history where id = ?";
    private final String SQL_FIND_BY_DATE = "select * from history where date_play = ?";
    private final String SQL_FIND_BY_SONG = "select history.* from history join song on history.song_id = song.id where song.title like ?";
    private final String SQL_UPDATE_HISTORY = "update history set date_play = ?, song_id = ? where id = ?";
    private final String SQL_DELETE_BY_ID = "delete from history where id = ?";

    public HistoryRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public History create(History history) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_INSERT_HISTORY, history.getDatePlay(), history.getSongId());
            if (result <= 0) {
                throw new Exception("Failed to add history");
            } else {
                System.out.println("Successfully add history");
                System.out.println(history);
            }
            return history;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<History> getAll() throws Exception {
        try {
            return jdbcTemplate.query(SQL_GET_ALL, new HistoryMapper());
        } catch (DataAccessException e) {
            throw new Exception("Failed to display history");
        }
    }

    @Override
    public History findById(Integer id) throws Exception {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new HistoryMapper(), id);
        } catch (DataAccessException e) {
            throw new Exception("History not found");
        }
    }

    @Override
    public List<History> getByDate(LocalDate datePlay) throws Exception {
        try {
            return jdbcTemplate.query(SQL_FIND_BY_DATE, new HistoryMapper(), datePlay);
        } catch (DataAccessException e) {
            throw new Exception("History not found");
        }
    }

    @Override
    public List<History> getBySong(String title) throws Exception {
        try {
            return jdbcTemplate.query(SQL_FIND_BY_SONG, new HistoryMapper(), "%"+title+"%");
        } catch (DataAccessException e){
            throw new Exception("History not found");
        }
    }

    @Override
    public History update(History history, Integer id) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_UPDATE_HISTORY, history.getDatePlay(), history.getSongId(), id);
            if (result <= 0) {
                throw new Exception("Failed to update history");
            } else {
                System.out.println("Successfully update history with id "+id);
                System.out.println(history);
            }
            return history;
        } catch (DataAccessException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            int result = jdbcTemplate.update(SQL_DELETE_BY_ID, id);
            if (result <= 0){
                System.out.println("Failed to delete history");
            } else {
                System.out.println("Successfully deleted history with id "+id);
            }
        } catch (DataAccessException e){
            System.out.println("Failed to delete history");
        }
    }
}
