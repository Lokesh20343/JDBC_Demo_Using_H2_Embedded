package com.JDBC.JDBCdemo.repo;

import com.JDBC.JDBCdemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlienRepo {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void saveAlien(Alien alien){
        String sql = "insert into alien_table (id,name,age) values (?,?,?)";
        int rows = jdbcTemplate.update(sql,alien.getId(),alien.getName(),alien.getAge());
        System.out.println("Rows Effected" + rows);
    }
    public List<Alien>  findAllAlien() {
        String sql = "select * from alien_table";
        RowMapper<Alien> rowMapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien a = new Alien();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setAge(rs.getInt("age"));
                return a;
            }
        };
        List<Alien> aliens =   jdbcTemplate.query(sql, rowMapper);
        return aliens;
    }
}
