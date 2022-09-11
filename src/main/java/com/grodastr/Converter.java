package com.grodastr;

public class Converter {
    //1 января 2009 года в unix времени
    private final long beginingTime = 1230768000;
    public long searchOmnicom(long unixTime){
        if (unixTime<0) return -1;
        else {
            long omnicom = unixTime - beginingTime;
            System.out.println("Время Omnicom:");
            System.out.println(omnicom);
            return omnicom;
        }
    }
    public long searchUnix(long omnicom){
        if (omnicom<0){
            return -1;
        }
        else {
            long unixTime = omnicom + beginingTime;
            if (unixTime<0) return -1;
            System.out.println("Время Unix:");
            System.out.println(unixTime);
            return unixTime;
        }
    }
}
