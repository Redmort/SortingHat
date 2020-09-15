package com.pluralsight.model;

import com.pluralsight.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ideali {


    private static int maxMembers = Constants.MAX_ZERO_GRADE;
    private static int currentMembers;

    private static final Map<Integer, List<Kid>> kidMap = new HashMap<>();

    public static void addMember(Kid kid){
        if(!kidMap.containsKey(kid.getLevel())){
            kidMap.put(kid.getLevel(), new ArrayList<Kid>());
        }
        kidMap.get(kid.getLevel()).add(kid);
        currentMembers++;
    }

    public static int getCurrentMembers(){
        return currentMembers;
    }

    public static long chance(){
        if(currentMembers==0){
            return 100;
        }

        if (currentMembers==maxMembers){
            return 0;
        }

        double test = (((maxMembers-currentMembers)/1d)/maxMembers)*100;

        return Math.round(test);
    }

    public static Integer getCountOfGrade(Integer grade){
        return kidMap.get(grade).size();
    }

    public static void addGrade(int grade){
        switch (grade) {
            case 1:
                maxMembers = currentMembers + Constants.MAX_FIRST_GRADE;
                currentMembers = currentMembers + Constants.CHILD_FIRST_IDEAL;
                break;
            case 2:
                maxMembers = currentMembers + Constants.MAX_SECOND_GRADE;
                currentMembers = currentMembers + Constants.CHILD_SECOND_IDEAL;
                break;
            case 3:
                maxMembers = Constants.MAX;
                currentMembers = currentMembers + Constants.CHILD_THIRD_IDEAL;
                break;
            case 4:
                currentMembers = currentMembers + Constants.CHILD_FOURTH_IDEAL;
                break;
            case 5:
                currentMembers = currentMembers + Constants.CHILD_FIFTH_IDEAL;
                break;
            case 6:
                currentMembers = currentMembers + Constants.CHILD_SIXTH_IDEAL;
                break;

        }
    }
}
