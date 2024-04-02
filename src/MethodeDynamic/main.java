package MethodeDynamic;
import Dao.IDao;
import Metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static java.lang.Class.forName;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, FileNotFoundException {
        // Methode Dynamique
        Scanner c = new Scanner(new File("config.txt"));
        String doaClassName = c.nextLine();
        Class cDao = forName("doaClassName");
        IDao dao1 = (IDao)cDao.newInstance();

        String MetierClassName = c.nextLine();
        Class cMetier = forName("MetierClassName");
        IMetier metier1 = (IMetier)cMetier.newInstance();

        // Invocation de la méthode setDao en utilisant la réflexion
        Method method = cMetier.getMethod("setDao", IDao.class);
        method.invoke(metier1, dao1);

        // Affichage du résultat
        System.out.println("Résultat Dynamique = " + metier1.calcul());

        // Fermeture du scanner
        c.close();
    }
}
