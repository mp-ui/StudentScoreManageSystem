/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 22:52
 */

package com.prince.util;

public class ScoreUtils {

    public static double getJiDian(int score){
        if(score >= 90){
            return 4.0;
        }
        if(score < 60){
            return 0.0;
        }
        return 4.0 - (90 - score) * 0.1;
    }
}
