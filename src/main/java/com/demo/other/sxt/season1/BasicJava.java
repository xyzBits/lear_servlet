package com.demo.other.sxt.season1;

import com.google.learn.adt.bag.BagInterface;

public class BasicJava {
    int a;
    double b;
    char c = '\u0004';
    boolean d;

    static int aa;

    static {
        System.out.println("hhhhhhhhh");
        System.out.println("aa = " + aa);
    }
    public static void main(String[] args) {
	    for (int i = 0; i < 10; i++ ) {
		    //System.out.println("hello world " + i);
	    }

        BasicJava basicJava = new BasicJava();
	    System.out.println(basicJava.a);
	    System.out.println(basicJava.b);
	    System.out.println(basicJava.c);
	    System.out.println(basicJava.d);





        {
            int status = 1;
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
            System.out.println(status);

            int i = 3;
            int j = i + 4;
        }


    }
}
