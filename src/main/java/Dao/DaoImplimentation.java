package Dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DaoImplimentation implements IDao{
    @Override
    public String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

}
