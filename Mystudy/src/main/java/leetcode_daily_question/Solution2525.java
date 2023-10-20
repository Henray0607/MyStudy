package leetcode_daily_question;

public class Solution2525 {
    public static String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = false;
        boolean isHeavy = false;
        long volume = (long) length * (long) width * (long) height;
        if (length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000) {
            isBulky = true;
        }
        if (mass >= 100) {
            isHeavy = true;
        }

        if (isBulky) {
            if (isHeavy) {
                return "Both";
            } else {
                return "Bulky";
            }
        } else {
            if (isHeavy) {
                return "Heavy";
            } else {
                return "Neither";
            }
        }
    }

    public static void main(String[] args) {
        /*int length1 = 1000;
        int width1 = 35;
        int height1 = 700;
        int mass1 = 300;
        System.out.println(categorizeBox(length1, width1, height1, mass1));*/

        int length2 = 2909;
        int width2 = 3968;
        int height2 = 3272;
        int mass2 = 727;
        System.out.println(categorizeBox(length2, width2, height2, mass2));
    }
}
