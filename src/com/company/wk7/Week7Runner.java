package com.company.wk7;

import java.util.*;
import java.util.function.DoubleToIntFunction;

public class Week7Runner {

    /*
    * collections:
    *   series of interfaces
    *       list of requirements
    *   storing series of object/reference data-type pointers
    *
    *   Collection(Interface )
    * 下面的这些都是extend father interface
    *
    * List           Queue               Set             Map
    *
    *Arraylist      PriorityQueue       HashSet         HashMap
    *LinkedList                         TreeSet         TreeMap
    *
    *
    * List: Series of sequential object/reference data type
    *       duplicated data is allowed (value)
    *       no ordering of value
    *
    *
    * Queue: value are ordered. ASC
    *        FIFO: line-up
    *
    * Set: duplicated values are NOT allowed
    *
    *
    * Map:KEY-VALUE pairs
    *   associative arrays
    *
    *
    *    Class: Key: instance variable
    *           value:value of instance variable
    *
    *
    * Scenario:
    *   1) A security guard needs to control the store crowd and only let 10 people inside at a time.
        The others need to wait in line.
            Queue
    *
    * 2) A magazine collector wants to store all of his/her magazines in a box. What interface would
        he or she use?
            Maps: value = magazine, key = magazine type?
            list:
    * 3）A person likes to store their bills (money) from lowest to highest. What interface?
            Queue
    *
    * 4) A shoe collector wants to own one pair of every Jordan brand shoe ever exiting.
        Set
    *
    * 5）A person is renovating their kitchen and wants to take photos of it at every stage of
        the way. Which interface?

            key = day 1, value = photo 1
            key = day 10, value = photo 2
    *
    *
    * */


    public static void main(String[] args) {
            example2();
    }


    public static void example1(){

        /*
            primitive data types cannot be used in Collection interface or Collection object

            Class-Wrappers
                final classes that BOX primitive data types

            int         Integer

            boolean     Boolean
            byte        Byte
            double      Double

         */
        ArrayList<Boolean> one = new ArrayList<>();
        LinkedList<Boolean> two = new LinkedList<>();

        PriorityQueue<Byte> three = new PriorityQueue<>();
        TreeSet<Double> four = new TreeSet<>();
        HashMap<String, String> five = new HashMap<>();


        //加一个元素
        one.add(true);
        two.add(false);
        three.add((byte)12);

        four.add(9.0);
        five.put("first","January");

        //add four more values for each Collection objects.
        one.add(false);
        two.add(true);
        three.add((byte)1);
        four.add(2.0);
        five.put("second","Feb");



    }
    public static void example2(){

        ArrayList<Integer> one = new ArrayList<>();
        LinkedList<Integer> two = new LinkedList<>();
        PriorityQueue<Integer> three = new PriorityQueue<>();
        TreeSet<Integer> four = new TreeSet<>();
        HashSet<Integer> four1 = new HashSet<>();
        HashMap<String, String> five = new HashMap<>();

        one.add(1);one.add(100);one.add(10);
        two.add(1);two.add(100);two.add(10);
        three.add(1);three.add(100);three.add(10);

        four.add(1);four.add(100);four.add(10);
        four1.add(1);four1.add(100);four1.add(10);


        iterate(one);


        //Iterator
        //an Object where you can cycle through the items with built-in methods (features)
        //only applicable for List interface
        //Iterator,             ListIterator
        //ArrayList, Set,       LinkedList

        //对于arrayList是单箭头，0指向1，1 指向2，we just know something after it
        //对于linkedList 是双箭头，每一个都是指向前面一个和后面一个，two way pointer
       /*
          <=  0   =>    <=  1   =>    <=  2    =>   <=  3 =>
         ^（这个是指针位置）                                          ^
            10          20          30          40

        */

        Iterator<Integer> iterator = one.iterator();
        //arrayList 是不是有下一个
        //Iterator的遍历可以从哪个开始哪个结束,have more control，可以控制，但是只有一个方向
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        //only for linkedlist,后面的括号里面可以写从哪个index开始，他继承了Iterator的接口
        /*判断是否有下一个元素：hasNext();
            获取下一个元素： next();
            删除迭代器指向的元素：remove(); ...
            判断是否有前一个元素：hasPrevious();
            获取前一个元素： previous();
            添加元素： add(e);

        *
        *
        * */
        ListIterator<Integer> listIterator = two.listIterator();
        System.out.println(listIterator.hasPrevious());

        //listIterator.previous();

        /*Query,只有两个操作，把元素增加在末尾，然后从开头取出了元素
        * List可以在任意的位置增加元素
        * 检索（retrieve）or 获取（fetch），remove 头部元素 :poll()
        *
        * peek() only retrieve头部元素
        *
        * */

        System.out.println(three.size());
        System.out.println(three.peek());//fetch
        System.out.println(three.poll());//retrieve,fetch and remove
        three.add(15);//add元素在队尾
        /*
        * Sorting algerithm
        * saving
        *
        *   Tree（问自己，是不是需要order）
        *       closet that is ordered
        *       by value
        *   Hash（如果不需要order，那么就用hash）
        *       may not be ordered
        *       hashCode
        *           a unique identifier for an object
        *       16 drawers
        *       16 categories
        *
        *       GUID:
        *           Global Unique Identifier
        *
        *
        *       What drawers you use
                total number of items in drawers

                efficient in storage
                efficient in speed/processing


                100 items, using 3 drawers
                100 items, using 16 drawers
        *
        * */

        //排序，headset是小于30的，这个sortSet是一个subTree
        SortedSet<Integer> sortSet = four.headSet(30);
        System.out.println(sortSet);
        //倒叙排列
        Iterator<Integer> it1 = four.descendingIterator();
        //如果是four1（hashset）的话就没有倒叙排列，因为根本没有顺序


        //map,key的值不可以重复
        five.put("key","value");
        five.put("key1","value2");
        five.get("key");

        Set<String> keys=five.keySet();
        System.out.println(keys);
    }

    private static void iterate(Collection<Integer> e){
        //这种遍历方式只能从第一个到最后一个
        for(Integer item:e){
            //boxing意思是说，从primitive data type变成了wrapper data type
            //unboxing的意思就是说，从wrapper data type又变成了 primitive data type
            System.out.println(item);
        }
    }





}
