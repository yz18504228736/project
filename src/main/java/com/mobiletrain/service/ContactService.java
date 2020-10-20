package com.mobiletrain.service;

import com.mobiletrain.domain.Contact;

import java.util.List;

// 通讯录的业务层
public interface ContactService {

    // 查询所有
    List<Contact> queryAll();
    List<Contact>queryAll(int currentPage, int pageSize);
//查询总页数
//    根据一页几条
    int queryPageCount(int pageSize);
//删除通讯录，返回值 是否删除成功
    boolean deleteById(String contactId);
//根据id查询一个Contact
    Contact queryById(String contactId);

    boolean update(Contact contact);

    boolean add(Contact contact);
}
