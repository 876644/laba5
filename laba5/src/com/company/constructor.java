package com.company;

import java.util.*;
import java.lang.reflect.*;

public class constructor {

    private static final HashMap<String, Method> map = new HashMap<>();//Создадим объект класса HashMap:

    private static final Commands com = new Commands();//Объект класса с командами

    static {

        for (Method met : com.getClass().getDeclaredMethods()) {//Берем список всех методов в классе Commands

            if (met.isAnnotationPresent(Annotation.class)) {//Смотрим, есть ли у метода нужная нам Аннотация
                Annotation ant = met.getAnnotation(Annotation.class);//Берем объект нашей Аннотации
                map.put(ant.name(), met);//Кладем в качестве ключа нашей карты параметр name() и метод
            }
        }
    }

    public static String[] his = new String[15];

    public static void sdvig(){
        for (int i = 13; i >= -1; i--){
            his[i+1] = his[i];
        }
    }

    public static void mm()  {
            try {
                    System.out.print("Введите команду:");//Ввожу строку
                    Scanner console = new Scanner(System.in);
                    String a = console.nextLine();
                    String[] strSplit = a.split(" ");
                    String strComanda = strSplit[0].toLowerCase();//Разделяю первое слово от остальных
                    String[] strArguments = Arrays.copyOfRange(strSplit, 1, strSplit.length);

                    Method met = map.get(strComanda);//(strComanda-первое слово в строке или команда)

                    met.invoke(com, (Object) strArguments);
                     sdvig();
                     his[0]=strComanda;

            }
            catch (ArrayIndexOutOfBoundsException | NullPointerException | IllegalAccessException | InvocationTargetException e) {
                    System.out.println("Неправильно введена команда, попробуйте заново.\n " +
                            "Подсказка: Используйте команду help, которая выводит справку по доступным командам ");
            }
    }
}

