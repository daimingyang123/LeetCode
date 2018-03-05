package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2018/3/5
 */
public class IntegertoRoman {
    
    String[] single = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] hundred = {"", "C", "CC", "CCC", "CD", "DC", "DCC", "DCCC", "CM"};
    String[] thousand = {"", "M", "MM", "MMM"};
    
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            if (num > 1000) {
                int count = num % 1000;
                num -= count * 1000;
                res.append(thousand[count]);
            } else if (num > 100) {
                int count = num % 100;
                num -= count * 100;
                res.append(hundred[count]);
            } else if (num > 10) {
                int count = num % 10;
                num -= count * 10;
                res.append(ten[count]);
            } else if (num > 0) {
                num = 0;
                res.append(single[num]);
            }
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        int num = 80;
        String res = new IntegertoRoman().intToRoman(num);
        System.out.println(res);
    }
}
