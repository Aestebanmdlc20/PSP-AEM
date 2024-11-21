package org.example;

public class Mesa {

    static Object tenedor1 ;
    static Object tenedor2 ;
    static Object tenedor3 ;
    static Object tenedor4 ;
    static Object tenedor5 ;

    public Mesa() {
        this.tenedor1 = new Object();
        this.tenedor2 = new Object();
        this.tenedor3 = new Object();
        this.tenedor4 = new Object();
        this.tenedor5 = new Object();
    }

    public Object getTenedor1() {
        return tenedor1;
    }

    public Object getTenedor2() {
        return tenedor2;
    }

    public Object getTenedor3() {
        return tenedor3;
    }

    public Object getTenedor4() {
        return tenedor4;
    }

    public Object getTenedor5() {
        return tenedor5;
    }

}
