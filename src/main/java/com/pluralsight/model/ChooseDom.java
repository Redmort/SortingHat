package com.pluralsight.model;

import java.util.Random;

public class ChooseDom {

    private static int diplCount;
    private static int intelCount;
    private static int harmCount;
    private static int idealCount;

    public static String makeChoose(Kid kid){
        System.out.println("Diplomati: " + Diplomati.getCurrentMembers());
        System.out.println("Harmoni: " + Harmoni.getCurrentMembers());
        System.out.println("Intelekti: "+ Intelekti.getCurrentMembers());
        System.out.println("Ideali: " + Ideali.getCurrentMembers());

        long chanceDiplomati = 0;
        long chanceHarmoni = 0;
        long chanceIdeali = 0;
        long chanceIntelekti = 0;

        if(diplCount != 2 || (Harmoni.chance()==0 && Ideali.chance()==0 && Intelekti.chance()==0)){
            chanceDiplomati = Diplomati.chance();
        }

        if(harmCount != 2 || (Diplomati.chance()==0 && Ideali.chance()==0 && Intelekti.chance()==0)){
            chanceHarmoni = Harmoni.chance();
        }

        if(idealCount != 2 || (Diplomati.chance()==0 && Harmoni.chance()==0 && Intelekti.chance()==0)){
            chanceIdeali = Ideali.chance();
        }

        if(intelCount != 2 || (Diplomati.chance()==0 && Harmoni.chance()==0 && Ideali.chance()==0)){
            chanceIntelekti = Intelekti.chance();
        }


        System.out.println("chanceDiplomati: " + chanceDiplomati);
        System.out.println("chanceHarmoni: " + chanceHarmoni);
        System.out.println("chanceIdeali: "+ chanceIdeali);
        System.out.println("chanceIntelekti: " + chanceIntelekti);

        if(chanceDiplomati == 0 && chanceHarmoni == 0 && chanceIdeali == 0 && chanceIntelekti == 0){
            return "0";
        }

        double percentige = 100d/(chanceDiplomati + chanceHarmoni + chanceIdeali + chanceIntelekti);


        long dipl =Math.round(percentige * chanceDiplomati);
        long harm =Math.round(percentige * chanceHarmoni);
        long intel =Math.round(percentige * chanceIntelekti);
        long ideal =Math.round(percentige * chanceIdeali);



        Random r = new Random();

        int random = r.nextInt(100-1) + 1;

        if(random<=dipl) {
            Diplomati.addMember(kid);
            diplCount++;

            intelCount = 0;
            harmCount = 0;
            idealCount = 0;

            return "1";
        }else if(random>dipl && random <= (dipl+harm)){
            Harmoni.addMember(kid);
            harmCount++;

            intelCount = 0;
            diplCount = 0;
            idealCount = 0;

            return "2";
        }else if(random > (dipl+harm) && random <= (dipl+harm+intel)){
            Intelekti.addMember(kid);
            intelCount++;

            harmCount = 0;
            diplCount = 0;
            idealCount = 0;

            return "3";
        }else{
            Ideali.addMember(kid);
            idealCount++;

            intelCount = 0;
            harmCount = 0;
            diplCount = 0;

            return "4";
        }
    }
}
