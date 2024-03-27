package doudizhu2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {

    static HashMap<Integer,String> hashMap = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static {
        String[] color = {"♠","♥","♣","♦"};
        String[] number = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        int index = 1;
        for (String n : number) {
            for (String c : color) {
                hashMap.put(index,c+n);
                list.add(index);
                index++;
            }
        }
        hashMap.put(index,"小王");
        list.add(index);
        index++;
        hashMap.put(index,"大王");
        list.add(index);
        System.out.println(hashMap);

    }

    public PokerGame(){
        //洗牌
        Collections.shuffle(list);
        //发牌
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            if(i <= 2){
                lord.add(list.get(i));
                continue;
            }
            if(i % 3 == 0){
                player1.add(list.get(i));
            } else if (i % 3 == 1) {
                player2.add(list.get(i));
            }else {
                player3.add(list.get(i));
            }
        }
        //看牌
        lookPoker("底牌",lord);
        lookPoker("赵困",player1);
        lookPoker("李海翔",player2);
        lookPoker("王海旭",player3);

    }

    public void lookPoker(String name,TreeSet<Integer> treeSet){
        System.out.println(name + ": ");
        for (Integer index : treeSet) {
            String poker = hashMap.get(index);
            System.out.print(poker + " ");
        }
        System.out.println();
    }



}
