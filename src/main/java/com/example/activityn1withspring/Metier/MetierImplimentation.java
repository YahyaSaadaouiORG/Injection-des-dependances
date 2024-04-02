package com.example.activityn1withspring.Metier;

import Dao.IDao;
import Metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImplimentation implements IMetier {
    @Autowired
    private IDao dao;
    public void setDao(IDao dao) {
        this.dao = dao;
    }
    @Override
    public int calcul() {
        String dateStr = dao.getDate();
        int jour = Integer.parseInt(dateStr.split("-")[2]);
        return jour;
    }
}
