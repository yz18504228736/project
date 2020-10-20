package com.mobiletrain.dao.impl;

import com.mobiletrain.dao.ContactDAO;
import com.mobiletrain.domain.Contact;
import com.mobiletrain.utils.DataBaseUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ContactDAOImpl implements ContactDAO {
    JdbcTemplate jdbcTemplate = DataBaseUtils.getJdbcTemplate();

    @Override
    public List<Contact> queryAll() {
            String sql = "SELECT * FROM contact where del=0" ;
            List<Contact> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class));
        return result;
    }

    @Override
    public List<Contact> queryAll(int pageOffset, int pageSize) {
            String sql = "SELECT * FROM contact  where del=0 limit ?,?";
        List<Contact>result= jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class),pageOffset, pageSize);
        return result;
    }

    @Override
    public int queryCount() {
        String sql="select Count(*) from contact where del=0";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int deleteById(String contactId) {
        String sql="update contact set del=1 where id=?";
        return jdbcTemplate.update(sql,contactId);
    }

    @Override
    public Contact queryById(String contactId) {
        String sql = "SELECT * FROM contact WHERE id=? AND del=0";
        List<Contact> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class), contactId);
        if (query.size() == 1) {
            return query.get(0);
        } else {
            return null;
        }
    }

    @Override
    public int update(Contact contact) {
        String sql = "UPDATE contact SET name=?, gender=?, birthday=?, birthplace=?, mobile=?, email=? WHERE id=?";
        return jdbcTemplate.update(sql,
                contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail(),
                contact.getId());
    }

    @Override
    public int add(Contact contact) {
        String sql = "INSERT INTO contact(`name`, `gender`, `birthday`, `birthplace`, `mobile`, `email`) VALUES(?,?,?,?,?,?)";
        return  jdbcTemplate.update(sql,
                contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail());
    }
}
