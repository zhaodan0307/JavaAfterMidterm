package com.company.wk9;

public class Week9Runner {

    public static void example1(){

    /*
        Thread
            a set of instructions
            own stack
            own statements

        moving：
            multiple people


        states
            new state 新建状态
            running （thread.start();）运行状态
                blocked 线程T1和T2 公用一个东西，如果一个占了，另一个只能被block
                        而且看不到回来的可能性
                timedWait 线程T1想用 in the line,但是需要时间去等
            terminated
    *  指令集                         创建在一个新栈上
    *  -set of instructions          created on a new stack
        Runnable object                 new thread
    * */


        //在java中可有两种方式实现多线程,一种是继承Thread类，一种是实现Runnable接口；

        System.out.println("start example one");
        System.out.println(Thread.currentThread().getName());
        Runnable instructions =()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("hello from our runnable");
            System.out.println("how is it going");
        };

        instructions.run();//create a new thread

        System.out.println("end example one ");

    }

    public static void main(String[] args) {
        example1();


    }
}
