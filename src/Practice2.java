import java.util.Arrays;

public class Practice2 {
    public static void main(String[] args) {
        System.out.println("Повторение каждого символа n раз:");
        System.out.println(repeat("met",3));
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));
        System.out.println("Разница между максимальным и минимальным значением в массиве:");
        System.out.println(differenceMaxMin(new int []  {10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(differenceMaxMin(new int []  {44, 32, 86, 19}));
        System.out.println("Является ли среднее значение всех элементов массива целым числом или нет:");
        System.out.println(isAvgWhole(new int []  {1,3}));
        System.out.println(isAvgWhole(new int []  {1, 2, 3, 4}));
        System.out.println(isAvgWhole(new int []  {1, 5, 6}));
        System.out.println(isAvgWhole(new int []  {1, 1, 1}));
        System.out.println(isAvgWhole(new int []  {9, 2, 2, 5}));
        System.out.println("Вывод значений массива сложенных с самим собой и предыдущими элементами:");
        System.out.println(Arrays.toString(cumulativeSum(new int [] {1, 2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int [] {1, -2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int [] {3, 3, -2, 408, 3, 3})));
        System.out.println("Сколько десятичных знаков у цифры:");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));
        System.out.println("Метод, который при заданном числе возвращает соответствующее число Фибоначчи:");
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(12));
        System.out.println("Метод, чтобы определить, является ли входные данные действительным почтовым индексом:");
        System.out.println(isValid("59001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));
        System.out.println("Метод, который возвращает true, если пара строк представляет собой странную пару, и false в противном случае:");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));
        System.out.println("Метод, должен возвращать true, если он начинается с префиксного аргумента, иначе false:");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println("Метод, должен возвращать true, если он заканчивается аргументом суффикса, иначе false:");
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isSuffix("vocation", "-logy"));
        System.out.println("Метод, который принимает число (шаг) в качестве аргумента и возвращает количество полей на этом шаге последовательности:");
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));
    }
    //Повторение каждого символа n раз
    public static String repeat(String s, int n){
        String resultS = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < n; j++) {
                resultS += s.charAt(i);
            }
        }
        return resultS;
    }
    //Разница между максимальным и минимальным значением в массиве
    public static int differenceMaxMin (int [] mas){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mas.length; i++) {
            if(mas[i] > max){
                max = mas[i];
            }
            else{
                if(mas[i] < min){
                    min = mas[i];
                }
            }
        }
        return max - min;
    }
    //Среднее значение массива
    public static boolean isAvgWhole (int [] mas){
        int total = 0;
        for (int i = 0; i < mas.length; i++) {
            total += mas[i];
        }
        return (total % mas.length) == 0;
    }
    //Вывод значений массива сложенных с самим собой и предыдущими элементами
    public static int[] cumulativeSum(int[] array){
        int[] array1 = new int[array.length];
        int a = 0;
        for(int i = 0; i < array.length; i++) {
            a += array[i];
            array1[i] = a;
        }
        return array1;
    }
    // Сколько десятичных знаков
    public static int getDecimalPlaces(String s){
        int point_index = s.indexOf(".") + 1;
        if(point_index == -1){
            return 0;
        }
        else{
            return s.length() - point_index;
        }
    }
    // Числа фибоначи
    public static int fibonacci(int n)
    {
        int[] fibArray = {0, 1};
        int fibNum = 0;
        for (int i = 0; i < n; ++i) {
            fibNum = fibArray[0] + fibArray[1];
            fibArray[0] = fibArray[1];
            fibArray[1] = fibNum;
        }
        return fibNum;
    }
    //Проверка почтовых индексов
    public static boolean isValid(String s){
        boolean flag = true;
        String symbolsAndSigns = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()[]{}";
        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            if(symbolsAndSigns.indexOf(charS) != -1){
                flag = false;
            }
        }
        if(s.length() > 5 || s.contains(" ")){
            flag = false;
        }
        return flag;
    }
    //Пара строк по определ условиям
    //Если две строки пустые или первый символ равняется последнему символу второй строки
    // и последний символ первой строки равняется первому символу второй строки метод возвращает true, иначе false
    public static boolean isStrangePair(String s, String s2){
        boolean flag = false;
        if ((s.isEmpty() && s2.isEmpty()) || (s.charAt(0) == s2.charAt(s2.length() - 1) && s.charAt(s.length() - 1) == s2.charAt(0))) {
            flag = true;
        }
        return flag;
    }
    //Префикс
    public static boolean isPrefix (String a, String b){
        boolean flag = false;
        for (int i = 0; i < b.length()-2; i++) {
            if(a.charAt(i) == b.charAt(i)){
                flag = true;
            }
            else flag = false;
        }
        return flag;
    }
    //Суффикс
    public static boolean isSuffix (String a, String b){
        String b2 = "";
        for(int i = 1; i < b.length(); i++){
            b2 += b.charAt(i);
        }
        if (a.endsWith(b2)){
            return true;
        }else{
            return false;
        }
    }
    //Шаги-клетки
    public static int boxSeq(int n){
        int count = 0;
        if (n == 0) return 0;
        for (int i = 1; i <= n; i++) {
            if(i % 2 != 0) count += 3;
            else count--;
        }
        return count;
    }
}