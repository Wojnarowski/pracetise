package com.paul.java.lock;

/**
 * @ClassName ReentrantLockDemo2
 * @Description TODO
 * @Author paul
 * @Date 2021/9/30 9:26
 * Vertion 1.0
 * -------------------------------------------------------------_ooOoo_
 * ------------------------------------------------------------o8888888o
 * ------------------------------------------------------------88"-.-"88
 * ------------------------------------------------------------(|--_--|)
 * ------------------------------------------------------------O\--=--/O
 * ---------------------------------------------------------____/`---'\____
 * -------------------------------------------------------.'--\\|-----|//--`.
 * ------------------------------------------------------/--\\|||--:--|||//--\
 * -----------------------------------------------------/--_|||||--:--|||||---\
 * -----------------------------------------------------|---|-\\\-----///-|---|
 * -----------------------------------------------------|-\_|--''\---/''--|---|
 * -----------------------------------------------------\--.-\__--`-`--___/-.-/
 * ---------------------------------------------------___`.-.'--/--.--\--`.-.-__
 * ------------------------------------------------.""-'<--`.___\_<|>_/___.'-->'"".
 * -----------------------------------------------|-|-:--`--\`.;`\-_-/`;.`/---`-:-|-|
 * -----------------------------------------------\--\-`-.---\_-__\-/__-_/---.-`-/--/
 * ---------------------------------------======`-.____`-.___\_____/___.-`____.-'======
 * -------------------------------------------------------------`=---='
 * ---------------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * -----------------------------------------------------佛祖保佑--------永无BUG
 */
public class ReentrantLockDemo2 {

    Object object = new Object();

    public void sychronizedMethod(){
        new Thread(()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"\t"+"外层....");
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"\t"+"中层....");
                    synchronized (object){
                        System.out.println(Thread.currentThread().getName()+"\t"+"内层....");
                    }
                }
            }
        },"Thread A").start();
    }

    public synchronized void m1() {
        System.out.println("===外");
        m2();
    }

    public synchronized void m2() {
        System.out.println("===中");
        m3();
    }

    public synchronized void m3() {
        System.out.println("===内");

    }

    public static void main(String[] args) {
        //new ReentrantLockDemo2().sychronizedMethod();
        new ReentrantLockDemo2().m1();
    }


}

