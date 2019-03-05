package com.interviewbit.binary;

public class PowerMod {

    public static void main(String ...args) {

        PowerMod powerMod = new PowerMod();
        int pow = powerMod.pow(2, 3, 3);
        System.out.println(pow);

        pow = powerMod.pow(71045970, 41535484, 64735492);
        System.out.println(pow);


    }

    public int pow(int x, int n, int d) {
        int num = x;
        while (num < 0) {
            num += d;
        }
        num = num % d;
        return (int)powerHelper(num, n, d);
    }

    private long powerHelper(long num, int n, int d) {
        if(n == 0) return 1;
        else if(n == 1) return num % d;
        else if(n % 2 == 0) return powerHelper((num * num) % d, n / 2, d);
        else return ((num %  d) * powerHelper((num * num) % d, n /2, d) % d);
    }

}
