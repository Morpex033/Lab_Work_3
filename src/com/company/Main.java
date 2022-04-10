package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int tasks = 3;
	    for (int i = 1; i <= tasks; i++) {
            System.out.println((23 +(i - 1)* 23)%57 + (211%3));
        }
        task13();
        task24();
        task47();
    }

    /*
    Дана строка. Подсчитать количество содержащихся в ней цифр.
     */
    public static void task13() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 13.\nДана строка. Подсчитать количество содержащихся в ней цифр.");
        System.out.println("Введите любую строку");
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int numberInString = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(chars[i])) {
                numberInString++;
            } else {
                continue;
            }
        }
        System.out.println("Количество цифр в строке: " + numberInString);
    }

    /*
    Дана строка, изображающая двоичную запись целого положительного числа.
    Вывести строку, изображающую десятичную запись этого же числа.
     */
    public static void task24(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 24.\nДана строка, изображающая двоичную запись целого положительного числа.\n" +
                "    Вывести строку, изображающую десятичную запись этого же числа.");
        System.out.println("Введите запись двоичного числа");
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int result = Binary_to_decimal(chars);
        System.out.println("Десятичная запись числа: " + result);
    }

    //Перевод двоичной записи в десятичную
    public static int Binary_to_decimal(char[] binary) {
        int[] Powers_of_two = new int[binary.length];
        int result = 0;
        for (int i = 2; i <= Powers_of_two.length; i++) {
            Powers_of_two[Powers_of_two.length - 1] = 1;
            Powers_of_two[Powers_of_two.length - i] = (int) Math.pow(2, i-1);
        }
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == '1') {
                result += Powers_of_two[i];
            } else if (binary[i] == '0') {
                result += 0;
            }
        }
        return result;
    }

    /*
    Дана строка, состоящая из слов кириллицей, разделенных пробелами (одним или несколькими).
    Вывести строку, содержащую эти же слова, разделенные одним символом «.» (точка).
    В конце строки точку не ставить.
     */
    public static void task47(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 47.\nДана строка, состоящая из слов кириллицей, разделенных пробелами (одним или несколькими).\n" +
                "    Вывести строку, содержащую эти же слова, разделенные одним символом «.» (точка).\n" +
                "    В конце строки точку не ставить.");
        System.out.println("Введите строку");
        String string = new StringBuffer(scanner.nextLine()).toString();
        String[] words = string.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                result.append(words[i]);
                break;
            }
            if (!Objects.equals(words[i], "")) {
                result.append(words[i]).append(".");
            }
        }
        System.out.println(result);
    }

}
