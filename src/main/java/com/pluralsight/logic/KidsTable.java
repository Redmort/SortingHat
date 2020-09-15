package com.pluralsight.logic;

import com.pluralsight.model.Kid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KidsTable {

    public static int count = 0;

    private static List<Kid> kids = new ArrayList<>();

    private static String text ="Дарян,Горянов,0 Димана,Панчева,0 Живодара,Петрова,0 Лора,Джурова,0 Никола,Гелов,0 " +
            "Александър,Билкиевич,1 Андрий,Лазаров,1 Асен,Станев,1 Дария,Кликчиева,1 Емил,Димитров,1 Йоан,Томас,1 Мария,Варадинова,1 Рада,Иванова,1 Стефан,Иванов,1 Стоян,Апостолов,1 " +
            "Емил,Гайнутдинов,2 Марта,Маркова,2 Никол,Станулова,2 Никола,Гайдарски,2 Петър,Минков,2 Радослав,Минков,2 Белослава,Венева,2 Боряна,Стоянова,2 Боян,Димитров,2 Васил,Радков,2 Дарина,Колева,2 Емили,Харгрийвз,2 Карина,Халачева,2 Платон,Климов,2 София,Бакалова,2 " +
            "Александър,Петров,3 Ирина,Светославова,3 Адриан-Джеймс,Томас,3 Борислав,Кръстев,3 Георги,Бакалов,3 Емми,Илиева,3 Кристиан,Петров,3 Купен,Купенов,3 София,Билкиевич,3 Филип,Кереков,3 " +
            "Антониос,Слатичис,4 Константин,Добрев,4 Радослав,Цветков,4 Тея,Дочеф,4 Уилям,Харгрийвз,4 Ян,Борисов,4 " +
            "Благовест,Петров,5 Ема,Гайдарска,5 Мирела,Георгиева,5 " +
            "Георги,Светославов,6 Зара,Гюлева,6 Калина,Богданова,6 Линда-Мариа,Васарайнен,6 Любомир,Иванов,6";


    public static List<Kid> getKids(){
        return kids;
    }

    public static void generateKids(){

        List<String> kidsInfo = new ArrayList<>();
        kidsInfo = Arrays.asList(text.split(" "));

        long id = 1L;
        for (String kidInfo : kidsInfo){
            String[] info = kidInfo.split(",");
            String firstName = info[0];
            String family = info[1];
            String level = info[2];
            int level1 = Integer.parseInt(level);
            Kid kid = new Kid(id, firstName, family, level1);
            kids.add(kid);
            id++;
        }

//        sortKids();
    }

    public static Kid getKid(){
        System.out.println(KidsTable.count);
        Kid kid = kids.get(KidsTable.count);
        KidsTable.count++;

        System.out.println(KidsTable.count);
        return kid;
    }

    public static Kid getPreviousKid(){
        return kids.get(KidsTable.count-1);
    }

    private static void sortKids(){

        Collections.sort(kids);

    }

    public static int kidsCount(){
        return kids.size();
    }

}
