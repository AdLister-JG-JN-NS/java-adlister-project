package com.codeup.adlister.util;

public class utils {
    private int flipper = 1;
    public String getClassforIndex(int pos){

        if(pos == 0){
            return "zen-i-tl";
        }else if(pos == 1){
            return "zen-i-tr";
        }else {
            return pos % 2 == 0 ? "zen-i-l" : "zen-i-r";
        }
    }

    public String colorAlternator(){
        flipper++;
        if(flipper > 4){
            flipper = 1;
        }
        if(flipper == 3 || flipper == 4)
            return "peach";
        else
            return "lt-peach";
    }
}
