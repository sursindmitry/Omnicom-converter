package com.grodastr;

public class Converter {
    //1 января 2009 года в unix времени
    private final long beginingTime = 1230768000;
    public long searchOmnicom(long unixTime) throws Exception{
        if (unixTime<0) return -1;
        else if (unixTime>0 && unixTime<beginingTime) {
            return -2;
        }
        else {
            long omnicom = unixTime - beginingTime;
            return omnicom;
        }
    }
    public long searchUnix(long omnicom){
        if (omnicom<0)return -1;

        else {
            long unixTime = omnicom + beginingTime;
            if (unixTime<0) return -1;
            return unixTime;
        }
    }
}
