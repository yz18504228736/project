package com.mobiletrain.dao;

import com.mobiletrain.domain.Contact;

import java.util.List;

public interface ContactDAO {
//    查询所有
    List<Contact> queryAll();
    List<Contact>queryAll(int pageOffset, int pageSize);
//查询记录条数
    int queryCount();
//删除，根据id删除，返回收影响的条数
    int deleteById(String contactId);
    // 根据id查Contact
    Contact queryById(String contactId);
//更新通讯录记录
    int update(Contact contact);

    int add(Contact contact);
}
