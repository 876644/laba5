package com.company;

import com.company.classes.StudyGroup;

import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

    public static PriorityQueue<StudyGroup> collection= new PriorityQueue<com.company.classes.StudyGroup>();//Создала коллекцию

    //public static String file = System.getenv("LABA");

    public static String[] AllId = new String[10000];

    public static void main(String[] args) throws IOException {

        FileCreate.readFile();
        System.out.println(collection + " - Коллекция, данные которой записаны из файла ");
        //noinspection InfiniteLoopStatement
        while (true) {
            constructor.mm();
        }
    }





}


//ОШИБКА ИНПУТ
//массив для history
//метод, который делает сортировку по умолчаю
//дописать команды
//Все классы в программе должны быть задокументированы в формате javadoc.