package com.company;

import com.company.Enums.*;
import com.company.classes.Coordinates;
import com.company.classes.Person;
import com.company.classes.StudyGroup;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;


public class Commands  {

   Class<Commands> clas = Commands.class;

    @Annotation(name = "clear")
    public void clear(String[] args) {
        if (args.length != 0){

            System.out.println("У этой команды нет аргумента, попробуйте ещё раз.\n "  +
                    "Подсказка: Используйте команду help, которая выводит справку по доступным кома");

        }else {
            Main.collection.clear();
            System.out.println("Была произведена очистка коллекции. Коллекция: ");
        }
    }

     @Annotation(name = "help")
    public void help(String[] args){

         if (args.length != 0){

             System.out.println("У этой команды нет аргумента, попробуйте ещё раз.\n "  +
                     "Подсказка: Используйте команду help, которая выводит справку по доступным кома");

         }else {

             System.out.println("help : вывести справку по доступным командам\n" +
                     "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                     "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                     "add {element} : добавить новый элемент в коллекцию\n" +
                     "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                     "remove_by_id id : удалить элемент из коллекции по его id\n" +
                     "clear : очистить коллекцию\n" +
                     "save : сохранить коллекцию в файл\n" +
                     "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                     "exit : завершить программу (без сохранения в файл)\n" +
                     "head : вывести первый элемент коллекции\n" +
                     "remove_head : вывести первый элемент коллекции и удалить его\n" +
                     "history : вывести последние 15 команд (без их аргументов)\n" +
                     "remove_any_by_students_count studentsCount : удалить из коллекции один элемент, значение поля studentsCount которого эквивалентно заданному\n" +
                     "average_of_students_count : вывести среднее значение поля studentsCount для всех элементов коллекции\n" +
                     "filter_by_form_of_education formOfEducation : вывести элементы, значение поля formOfEducation которых равно заданному");

         }
    }

    @Annotation(name = "info")
    public void info(String[] args){

        if (args.length != 0){

            System.out.println("У этой команды нет аргумента, попробуйте ещё раз.\n "  +
                    "Подсказка: Используйте команду help, которая выводит справку по доступным кома");

        }else{

        System.out.println(" Информация о коллекции:\n" +
                "Тип коллекции - PriorityQueue\n" +
                "Дата инициализации - " + LocalDate.now() + "\n" +
                "Количество эллементов - " + Main.collection.size());
        }
    }

   @Annotation(name = "show")
    public void show(String[] args){
       if (args.length != 0){

           System.out.println("У этой команды нет аргумента, попробуйте ещё раз.\n "  +
                   "Подсказка: Используйте команду help, которая выводит справку по доступным кома");

       }else {
           System.out.println(Main.collection + " - коллекция "
           );
       }
    }

    @Annotation(name = "add")
    public void add(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String nameG = Arrays.toString(args);
        String[] elemets = new String[13];

        try {
            if ((!Pattern.compile("\\S+").matcher(nameG).matches()) && (args.length == 0)) {
                System.out.println("Аргумент неправильно ввдедён или отсутствует.");

            }else{

                Random random = new Random();
                Integer idRandom = random.nextInt();

                for (int i = 0;i<=10000;i++){
                    if(Main.AllId[i].equals(String.valueOf(idRandom))){
                        idRandom = random.nextInt();
                    }else elemets[0] = String.valueOf(idRandom);
                }


                elemets[1] = nameG;

                System.out.println("Введите координату x: ");
                String x = scanner.nextLine();

                while ((!Pattern.compile("\\d+(\\.*)+(\\d*)").matcher(x).matches()) && (Double.parseDouble(x) > 887)) {
                    System.out.println("Неправильно введены данные координаты х. Повторите попытку");
                    x = scanner.nextLine();
                }
                elemets[2] = x;

                System.out.println("Введите координату y");
                String y = scanner.nextLine();

                while (!Pattern.compile("\\d").matcher(y).matches()) {
                    System.out.println("Неправильно введены данные координаты y. Повторите попытку");
                    y = scanner.nextLine();
                }
                elemets[3] = y;

                elemets[4] = String.valueOf(LocalDate.now());

                System.out.println("Введите колличество студентов");
                String sC = scanner.nextLine();

                while ((!Pattern.compile("\\d").matcher(sC).matches()) && (Long.parseLong(sC) <= 0)) {
                    System.out.println("Неправильно введены данные колличества студентов. Повторите попытку");
                    sC = scanner.nextLine();
                }
                elemets[5] = sC;

                System.out.println("Введите форму образования.");
                String fE = scanner.nextLine();

                while (!Pattern.compile("DISTANCE_EDUCATION|FULL_TIME_EDUCATION|EVENING_CLASSES").matcher(fE).matches()) {
                    System.out.println("Неправильно введены данные формы образования. Повторите попытку");
                    fE = scanner.nextLine();
                }
                elemets[6] = fE;

                System.out.println("Введите семестр.");
                String sem = scanner.nextLine();

                while (!Pattern.compile("FIFTH|SIXTH|SEVENTH").matcher(sem).matches()) {
                    System.out.println("Неправильно введены данные семестра. Повторите попытку");
                    sem = scanner.nextLine();
                }
                elemets[7] = sem;

                System.out.println("Введите имя студента.");
                String nameS = scanner.nextLine();

                while (!Pattern.compile("\\S+").matcher(nameS).matches()) {
                    System.out.println("Неправильно введены данные имени студента. Повторите попытку");
                    nameS = scanner.nextLine();
                }
                elemets[8] = nameS;

                System.out.println("Введите иданные паспорта.");
                String pid = scanner.nextLine();

                while ((!Pattern.compile("\\S+").matcher(pid).matches()) && (String.valueOf(pid).length()) > 31) {
                    System.out.println("Неправильно введены данные паспорта. Повторите попытку");
                    nameS = scanner.nextLine();
                }
                // проверка на уникальность id
                elemets[9] = pid;

                System.out.println("Введите цвет глаз.");
                String cY = scanner.nextLine();

                while (!Pattern.compile("GREEN|YELLOW|ORANGE|WHITE").matcher(cY).matches()) {
                    System.out.println("Неправильно введены данные цвета глаз. Повторите попытку");
                    cY = scanner.nextLine();
                }

                elemets[10] = cY;

                System.out.println("Введите цвет волос.");
                String cH = scanner.nextLine();

                while (!Pattern.compile("GREEN|RED|YELLOW|WHITE").matcher(cH).matches()) {
                    System.out.println("Неправильно введены данные цвета волос. Повторите попытку");
                    cH = scanner.nextLine();
                }

                elemets[11] = cH;

                System.out.println("Введите национальность.");
                String n = scanner.nextLine();

                while (!Pattern.compile("RUSSIA|GERMANY|CHINA|NORTH_KOREA").matcher(n).matches()) {
                    System.out.println("Неправильно введены данные национальности. Повторите попытку");
                    n = scanner.nextLine();
                }

                elemets[12] = n;

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date date = formatter.parse(elemets[4]);

                Coordinates coordinates = new Coordinates(Double.parseDouble(elemets[2]), Integer.valueOf(elemets[3]));
                Person person = new Person(String.valueOf(elemets[8]), String.valueOf(elemets[9]), ColorY.valueOf(elemets[10]), ColorH.valueOf(elemets[11]), Country.valueOf(elemets[12]));
                StudyGroup studyGroup = new StudyGroup(Long.valueOf(elemets[0]), String.valueOf(elemets[1]), coordinates, date, Long.valueOf(elemets[5]), FormOfEducation.valueOf(elemets[6]), Semester.valueOf(elemets[7]), person);

                Main.collection.add(studyGroup);
                System.out.println("Объект был добавлен в коллекцию.");

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


        @Annotation(name = "update")
    public void update(String[] args){
        System.out.println("update done");
    }

    @Annotation(name = "remove")
    public void remove(String[] args){

        if ((args.length == 0) && (!Pattern.compile("\\d").matcher(Arrays.toString(args)).matches()) && (Long.parseLong(Arrays.toString(args)) <= 0)){

        }

    }

    @Annotation(name = "save")
    public void save (String[] args) throws IOException {
        if (args.length != 0){

            System.out.println("У этой команды нет аргумента, попробуйте ещё раз.\n "  +
                    "Подсказка: Используйте команду help, которая выводит справку по доступным кома");

        }else {
           // File.writeFile();
            System.out.println("Данные коллекции сохранены в файл.");
        }
    }

    @Annotation(name = "execute")
    public void execute(String[] args){
        System.out.println("execute done");
    }

    @Annotation(name = "exit")
    public void exit(String[] args){
        if (args.length != 0){

            System.out.println("У этой команды нет аргумента, попробуйте ещё раз.\n "  +
                    "Подсказка: Используйте команду help, которая выводит справку по доступным кома");

        }else {
            System.out.println("Работа программы завершается без сохранения данных.");
            System.exit(0);
        }
    }

    @Annotation(name = "head")
    public void head(String[] args){
        if (args.length != 0){

            System.out.println("У этой команды нет аргумента, попробуйте ещё раз.\n "  +
                    "Подсказка: Используйте команду help, которая выводит справку по доступным кома");

        }else {
            if (Main.collection.element() != null) {
                System.out.println(Main.collection.element() + " - первый элемент коллекции .");
            } else System.out.println("В коллекции нет эллементов.");
        }
    }

    @Annotation(name = "remove_head")
    public void remove_head(String[] args) {
        if (args.length != 0){

            System.out.println("У этой команды нет аргумента, попробуйте ещё раз.\n "  +
                    "Подсказка: Используйте команду help, которая выводит справку по доступным кома");

        }else {
            if (Main.collection.element() != null) {
                System.out.println("Первый элемент коллекции - " + Main.collection.poll() + " - был удалён.");
            } else System.out.println("В коллекции нет эллементов.");
        }
    }

    @Annotation(name = "remove_any_by_students_count")
    public void remove_any_by_students_count(String[] args){
        System.out.println("remove_any_by_students_count done");
    }

    @Annotation(name = "average_of_students_count ")
    public void average_of_students_count (String[] args){
        if (args.length != 0){

            System.out.println("У этой команды нет аргумента, попробуйте ещё раз.\n "  +
                    "Подсказка: Используйте команду help, которая выводит справку по доступным кома");

        }else {
            System.out.println("average_of_students_count  done");
        }
    }

    @Annotation(name = "filter_by_form_of_education")
    public void filter_by_form_of_education(String[] args){

    }

    @Annotation(name = "history")
    public void history(String[] args){
        if (args.length != 0){

            System.out.println("У этой команды нет аргумента, попробуйте ещё раз.\n "  +
                    "Подсказка: Используйте команду help, которая выводит справку по доступным кома");

        }else {
            for (int i = 0; i <= 15; i++) {
                System.out.println(constructor.his[i]);
            }
        }
    }
}
