package com.example.demoapp.repository;

import com.example.demoapp.entity.TravelLog;
import com.example.demoapp.payload.FilterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JDBCTravelLogRepository implements TravelLogRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int save(TravelLog travelLog) {
        String query = "INSERT INTO travel_log(" +
                "date,vehicle_reg_number," +
                "vehicle_owner_name,odometer_begin,odometer_end," +
                "route,journey_description)" +
                "VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(query,
                travelLog.getDate(),
                travelLog.getVehicleRegNumber(),
                travelLog.getVehicleOwnerName(),
                travelLog.getOdometerBegin(),
                travelLog.getOdometerEnd(),
                travelLog.getRoute(),
                travelLog.getJourneyDescription()
        );
    }

    @Override
    public int update(TravelLog travelLog) {
        String query = "UPDATE travel_log SET " +
                "date = ?," +
                "vehicle_reg_number = ?," +
                "vehicle_owner_name = ?," +
                "odometer_begin = ?," +
                "odometer_end = ?," +
                "route = ?," +
                "journey_description = ? " +
                "WHERE id = ?";
        return jdbcTemplate.update(query,
                travelLog.getDate(),
                travelLog.getVehicleRegNumber(),
                travelLog.getVehicleOwnerName(),
                travelLog.getOdometerBegin(),
                travelLog.getOdometerEnd(),
                travelLog.getRoute(),
                travelLog.getJourneyDescription(),
                travelLog.getId()
        );
    }

    @Override
    public int deleteById(Long id) {
        String query = "DELETE FROM travel_log WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }

    @Override
    public Optional<TravelLog> findById(Long id) {
        return jdbcTemplate.query(
                        "SELECT * FROM travel_log WHERE id = ?",
                        new TravelLogRowMapper(),
                        id
                )
                .stream()
                .findFirst();
    }

    @Override
    public List<TravelLog> findByFilter(FilterDto filterDto) {
        return jdbcTemplate.query(buildFilteredQuery(filterDto),new TravelLogRowMapper());
    }


    public String buildFilteredQuery(FilterDto filterDto){
        boolean addAnd=false;
        StringBuilder query=new StringBuilder("SELECT * FROM travel_log ");
        if (filterDto.isNotNull()){
            query.append(" WHERE ");
        }
        if (!filterDto.isDateNull()) {
            if ((filterDto.isFromDateNull())) {
                filterDto.setFromDate(LocalDate.of(1900, 1, 1));
            } else {
                filterDto.setToDate(LocalDate.now());
            }
            query.append("( date BETWEEN '").append(filterDto.getFromDate()).append("' AND '").append(filterDto.getToDate()).append("' )");
            addAnd=true;
        }
        if (!filterDto.isVehicleOwnerNameNull()){
            if (addAnd)
                query.append(" AND (vehicle_owner_name LIKE '").append(filterDto.getVehicleOwnerName()).append("' ) ");
            else{
                query.append(" ( vehicle_owner_name LIKE '").append(filterDto.getVehicleOwnerName()).append("' ) ");
                addAnd=true;
            }
        }
        if (!filterDto.isVehicleRegNumberNull()){
            if (addAnd)
                query.append(" AND ( vehicle_reg_number LIKE '").append(filterDto.getVehicleRegNumber()).append("' ) ");
            else
                query.append(" ( vehicle_reg_number LIKE '").append(filterDto.getVehicleRegNumber()).append("' ) ");
        }

        query.append(" ORDER BY date,odometer_begin ");
        return query.toString();
    }
}
