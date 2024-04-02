package com.example.activityn1withspring.presentation;
import Metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class PrseSpringXML {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("config.xml");

        IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("Results   :  "+metier.calcul());

    }
}
