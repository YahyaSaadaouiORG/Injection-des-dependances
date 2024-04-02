import Dao.DaoImplimentation;
import Dao.IDao;
import Metier.IMetier;
import Metier.MetierImplimentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.Class.forName;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, FileNotFoundException {

        // Methode statique
        IDao dao = new DaoImplimentation();
        MetierImplimentation metier = new MetierImplimentation();
        metier.setDao(dao);
        int resultat = metier.calcul();
        System.out.println("Résultat : " + resultat);



    }
}