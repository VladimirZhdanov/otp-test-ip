package com.otp;

import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 * На вход программе задаются два IP адреса, программа перебирает все
 * допустимые адреса в введенном диапазоне и выдает их на экран.
 * Желательно разработать функциональные тесты для модуля программы с
 * использованием JUnit.
 * Пример:
 * пользователь вводит с клавиатуры
 * 192.168.0.1 и 192.168.0.5
 * Программа должна выдать
 * 192.168.0.2
 * 192.168.0.3
 * 192.168.0.4
 */
public class App {
    public static void main(String[] args) throws UnknownHostException {
        MessageControler messageControler = new MessageControler();
        Algorithm algorithm = new Algorithm();
        Scanner sc = new Scanner(System.in);

        String firstIP;
        String secondIP;

        System.out.println("Enter IPv4:");

        firstIP = sc.nextLine();
        System.out.println("Firs IPv4: " + firstIP);

        secondIP = sc.nextLine();
        System.out.println("Second IPv4: " + secondIP);

        algorithm.setResult(firstIP, secondIP);
        algorithm.getResult().forEach(System.out::println);
    }
}
