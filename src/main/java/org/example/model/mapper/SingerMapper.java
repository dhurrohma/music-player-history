package org.example.model.mapper;

import org.example.model.Singer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SingerMapper implements RowMapper<Singer> {

    @Override
    public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Singer singer = new Singer();
        singer.setId(rs.getInt("id"));
        singer.setName(rs.getString("name"));
        return singer;
    }
}
