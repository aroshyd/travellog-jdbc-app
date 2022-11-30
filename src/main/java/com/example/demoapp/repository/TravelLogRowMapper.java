package com.example.demoapp.repository;

import com.example.demoapp.entity.TravelLog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TravelLogRowMapper implements RowMapper<TravelLog> {

    @Override
    public TravelLog mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TravelLog(
                rs.getLong("id"),
                rs.getDate("date").toLocalDate(),
                rs.getString("vehicle_reg_number"),
                rs.getString("vehicle_owner_name"),
                rs.getLong("odometer_begin"),
                rs.getLong("odometer_end"),
                rs.getString("route"),
                rs.getString("journey_description"));
    }
}