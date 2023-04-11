package org.example.model.mapper;

import org.example.model.SongWriter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongWritterMapper implements RowMapper<SongWriter> {

    @Override
    public SongWriter mapRow(ResultSet rs, int rowNum) throws SQLException {
        SongWriter songWriter = new SongWriter();
        songWriter.setId(rs.getInt("id"));
        songWriter.setName(rs.getString("name"));
        return songWriter;
    }
}
