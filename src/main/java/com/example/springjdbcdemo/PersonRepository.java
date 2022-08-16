package com.example.springjdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setData(rs.getString("name"));
            return person;
        }
    }


    public List<Person> findAll(){
        return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> findCustomAll(){
        return jdbcTemplate.query("select * from Person", new PersonRowMapper());
    }

    public Person findById(String id){
        return jdbcTemplate.queryForObject("select * from Person where id = ?",
                new BeanPropertyRowMapper<>(Person.class), id);
    }

    public int deleteById(String id){
        return jdbcTemplate.update("delete from Person where id = ?", id);
    }
}
