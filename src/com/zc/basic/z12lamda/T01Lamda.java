package com.zc.basic.z12lamda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Lamda语法有三种形式：
 * <p>
 * (参数) ->单行语句；
 * (参数) ->{多行语句}；
 * (参数) ->表达式；
 */
public class T01Lamda {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("线程操作"));

        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        // 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }

        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));

        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }
}
