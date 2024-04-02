package com.example.activityn1withspring.Dao;

import Dao.IDao;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component("dao")
public class DaoImplimentation implements IDao {
    @Override
    public String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

}
