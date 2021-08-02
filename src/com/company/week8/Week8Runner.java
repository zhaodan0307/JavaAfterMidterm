package com.company.week8;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Week8Runner {
    static void example1(){
        /*
        *
        *   function programming
        *       JDK>=8
        *       using pre-built methods
        *
        *   Stream
        *       set of data
        *           short-lived
        *
        *   lambda
        *       process the data
        *       actioning => methods
        *
        *
        * */

        //count from one to ten
        for(int i=0;i<=10;i++)
        {
            System.out.println(i);
        }

        //包含指定的元素
//        IntStream intStream=IntStream.of(1);
        //返回的int流中的元素是已经排序好的
        IntStream intStream=IntStream.of(1,3,2,5,4,6);


        //下面两种用法一致
        //rangeClosed 的用法是包括10，range（用法是不包括10的）
        IntStream.rangeClosed(0,10).forEach(System.out::println);
        IntStream.rangeClosed(0,10).forEach(e->System.out.println(e));



    }

    static void example2(){
        /*
        * primitive
        *   Int
        *   Long
        *   Double
        * object/reference
        *
        * */
        //五种不同类型的stream
        IntStream one;
        LongStream two;
        DoubleStream three;

        Stream<String> item1;
        Stream<Object> item2;




        IntStream oneToNine = IntStream.range(1,10);
        IntStream oneToTen1 = IntStream.range(1,11);
        IntStream oneToTen2 = IntStream.rangeClosed(1,10);

        //指定这个set的元素
        Stream<Integer> integerStream = Stream.of(12,24,30,1,10);
        //指定这个Stream的类型是string
        item1=Stream.of("hello","world");
        //指定这个Stream的类型是Object
        item2=Stream.of(12,1.2,"hello",true);

        //加入了两个元素 .build()意味着结束了输入
        Stream<Double> item3 = Stream.<Double>builder()
                                .add(12d)
                                .add(100D)
                                .build();

        item3.forEach(e->System.out.println("here"+e));


        String[] names = {"Hello", "World", "comp1011"};
        Stream<String> allNames = Arrays.stream(names);
        Stream<String> firstTwoNames = Arrays.stream(names, 0, 2);

        ArrayList<String> test = new ArrayList<>();
        test.add("hello");
        test.add("there");
        test.add("everyone");

        //convert an arraylist to a stream
        Stream<String> allValues = test.stream();

        SecureRandom srand = new SecureRandom();

        //生成10随机的数字
        IntStream randInts1 = srand.ints(10); // lowerbound     upperbound
        //生成10随机的数字,大于等于1小于5
        IntStream randInts2 = srand.ints(10, 1, 5);


        randInts2.forEach(System.out::println);

        //生成10个小于1大于等于0的double的数字
        DoubleStream randDoubles = srand.doubles(10); // 0 and < 1

        randDoubles.forEach(System.out::println);

    }

    public static void example3(){
        /*
        *
        *   Processing
        *   Actioning
        *   method
        *   series of data = stream
        *
        *   process = method
        *
        *   whatever.methodName1
        *           .methodName2
        * */

        /* interface的类型
        	Consumer 接受一个参数，无返回类型
            Supplier 不接受任何参数，返回类型T的结果。
            Predicate 接收一个类型T的参数，返回了boolean
            Function 接收一个类型T参数，返回一个类型R的结果。
            .map() 返回的类型和输入的那个必须一致
            .filter() 返回一个Boolean type，以删选出一个subset data set
            .forEach() 对于每个元素，都同样的执行一个数据


            two type of operators
                intermediate

                    return a subStream

                terminal (stop)

                    does not return a subStream
        *
        * */




        SecureRandom srand = new SecureRandom();
         srand.ints(3,1,10)
               .sorted()
               .filter(x->x>=7)
                 .forEach(System.out::println);


        //算总数
       IntStream p= srand.ints(3,1,10);
                    p.sum();





        IntStream.of(12,10,1,1,98)
                .map(x->x*2)
                .filter(x->x%2==1)
                .forEach(System.out::println);

        //找出最小数
       int a= IntStream.of(12,10,1,-1,98)
              .min().getAsInt();


        System.out.println("zuixiaoshu "+a);




    }

    public static void example4(){
       /*
            create a series of 5 names all in lowercase
            transform these names all to uppercase and output them

            1) Procedural programming
            2) Functional programming

         */

        //1)
        String[] names = {"chris", "jack", "jason", "sarah", "cameron"};
        for (String name : names) {
            System.out.println(name.toUpperCase());
        }
        //2)

        Stream.of("chris", "jack", "jason", "sarah", "cameron")
                .map(e->e.toUpperCase())
                .forEach(System.out::println);



    }

    public static void  example5(){
        //create this expression yourself
        Stream.of("chris", "jack", "jason", "sarah", "cameron")
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }

    public static void  example6(){
         /*
            Create 10 numbers between 1 and 69
            only keep the numbers that are a factor of 3 and 2
            half all of the numbers above
            output the first number higher than 10
         */
        SecureRandom rand = new SecureRandom();

                        int x=  rand.ints(10,1,70)
                                    .filter(e->e%3==0&&e%2==0)
                                    .map(e->e/2)
                                    .filter(e->e>10)
                                    .findFirst()
                                    .orElse(-1);


                        System.out.println(x);

    }

    public static void main(String[] args) {
        example6();
    }
}
