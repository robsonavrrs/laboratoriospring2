package com.example.route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RouteRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<ZuulProperties.ZuulRoute> findAll() {
        return jdbcTemplate.query("select * from zuul_routes", 
                new RouteRowMapper());
    }

    class RouteRowMapper implements RowMapper<ZuulProperties.ZuulRoute>
    {
        

		@Override
		public ZuulRoute mapRow(ResultSet resultSet, int rowNum) throws SQLException {

            return new ZuulProperties.ZuulRoute(
                    resultSet.getString("id"),
                    resultSet.getString("path"),
                    resultSet.getString("service_id"),
                    resultSet.getString("url"),
                    resultSet.getBoolean("strip_prefix"),
                    resultSet.getBoolean("retryable"),
                    null
            );
		} 
    }
    
}
