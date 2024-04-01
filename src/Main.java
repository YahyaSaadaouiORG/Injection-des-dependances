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


// Chargement dynamique des noms de classes à partir de config.txt
        Scanner scanner = new Scanner(new File("src/config.txt"));

        String daoClassName = scanner.nextLine().trim(); // Supprimer les espaces inutiles avant/après le nom de classe
        String metierClassName = scanner.nextLine().trim();

        // Chargement dynamique de la classe Dao
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> cDao = classLoader.loadClass(daoClassName);
        IDao dao1 = (IDao) cDao.newInstance();

        // Chargement dynamique de la classe Metier
        Class<?> cMetier = classLoader.loadClass(metierClassName);
        IMetier metier1 = (IMetier) cMetier.newInstance();

        // Invocation de la méthode setDao en utilisant la réflexion
        Method method = cMetier.getMethod("setDao", IDao.class);
        method.invoke(metier1, dao1);

        // Affichage du résultat
        System.out.println("Résultat Dynamique = " + metier1.calcul());

        // Fermeture du scanner
        scanner.close();
    }
}