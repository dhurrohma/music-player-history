package org.example.model.mapper;

import org.example.model.History;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryMapper implements RowMapper<History> {
    @Override
    public History mapRow(ResultSet rs, int rowNum) throws SQLException {
        History history = new History();
        history.setId(rs.getInt("id"));
        history.setDatePlay(rs.getDate("date_play").toLocalDate());
        history.setSongId(rs.getInt("song_id"));
        return history;
    }
}
