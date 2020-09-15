package com.pluralsight.model;

public class Kid implements Comparable<Kid>  {

    private long id;
    private String firstName;
    private String family;
    private String house;
    private int level;

    public Kid(long id, String firstName, String family){
        this.id = id;
        this.firstName = firstName;
        this.family = family;
    }

    public Kid(long id, String firstName, String family, int level){
       this(id, firstName, family);
        this.level =level;
    }

    public long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getFamily() {
        return this.family;
    }

    public String getHouse() {
        return this.house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int compareTo(Kid kid) {

        if(this.level > kid.level){
            return 1;
        }else if(this.level < kid.level){
            return -1;
        }else{
            return (this.firstName + this.family).compareTo(kid.firstName + kid.family);
        }
    }
}
