package com.codeup.adlister.util;

import java.util.ArrayList;

public class utils {
    private int flipper = 1;
    public String getClassforIndex(int pos, int total){
        if(pos == 0){
            if (total > 2) {
                return "zen-i-tl";
            }else {
                return "zen-i-sl";
            }
        }else if(pos == 1){
            if (total > 3) {
                return "zen-i-tr";
            }else {
                return "zen-i-sr";
            }
        }else {
            if(pos < total - 2) {
                return pos % 2 == 0 ? "zen-i-l" : "zen-i-r";
            }else if(pos + 1 == total || pos + 2 == total){
                return pos % 2 == 0 ? "zen-i-bl" : "zen-i-br";
            }
        }
        return "";
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
