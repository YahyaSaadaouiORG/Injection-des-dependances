package Metier;

import Dao.IDao;

public class MetierImplimentation implements IMetier {
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
