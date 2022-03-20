package com.company;

import com.company.Enums.*;
import com.company.classes.Coordinates;
import com.company.classes.Person;
import com.company.classes.StudyGroup;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class FileCreate {


    //метод для чтения файла, данные которого записываются в коллекцию
    public static void readFile() {
        try {

            //FileInputStream fileInputStream = new FileInputStream(Main.file);
            //InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            File file = new File(System.getenv("LABA"));
            //FileInputStream fileInputStream = new FileInputStream(file);
            //InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {

                String[] asplit = line.split(";");

                for (int i = 0; i <= asplit.length; i++) {
                    switch (i) {
                        case 0: {
                            if (!Pattern.compile("\\d").matcher(asplit[i]).matches()) {
                                if (Long.parseLong(asplit[i]) <= 0) {
                                    System.out.println("Неправильные данные id в файле. Проверьте данные и повторите попытку. ");
                                    System.exit(1);
                                }
                                for (int k = 0; k <= 10000; k++) {
                                    if (Main.AllId[k] == null) {
                                        Main.AllId[k] = asplit[i];
                                        break;
                                    }
                                }
                            }
                        }
                        case 1: {
                            if (!Pattern.compile("\\S+").matcher(asplit[i]).matches()) {
                                System.out.println("Неправильные данные name в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }

                        }
                        case 2: {
                            if ((!Pattern.compile("\\d+(\\.*)+(\\d*)").matcher(asplit[i]).matches()) && (Double.parseDouble(asplit[i]) > 887)) {
                                System.out.println("Неправильные данные x в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }

                        }
                        case 3: {
                            if (!Pattern.compile("\\d").matcher(asplit[i]).matches()) {
                                System.out.println("Неправильные данные y в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }
                        }
                        case 4: {
                            if (!Pattern.compile("\\d{4}+-+\\d{2}+-+\\d{2}").matcher(asplit[i]).matches()) {
                                System.out.println("Неправильные данные creationDate в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }

                        }
                        case 5: {
                            if ((!Pattern.compile("\\d").matcher(asplit[i]).matches())&& (Long.parseLong(asplit[i]) <= 0)) {
                                System.out.println("Неправильные данные studentsCount в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }

                        }
                        case 6: {
                            if (!Pattern.compile("DISTANCE_EDUCATION|FULL_TIME_EDUCATION|EVENING_CLASSES").matcher(asplit[i]).matches()) {
                                System.out.println("Неправильные данные formOfEducation в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }

                        }
                        case 7: {
                            if (!Pattern.compile("FIFTH|SIXTH|SEVENTH").matcher(asplit[i]).matches()) {
                                System.out.println("Неправильные данные semesterEnum в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }

                        }
                        case 8: {
                            if (!Pattern.compile("\\S+").matcher(asplit[i]).matches()) {
                                System.out.println("Неправильные данные name в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }

                        }
                        case 9: {
                            if ((!Pattern.compile("\\S+").matcher(asplit[i]).matches()) && (String.valueOf(asplit[i]).length()) > 31) {
                                System.out.println("Неправильные данные passportID в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }

                        }
                        case 10: {
                            if (!Pattern.compile("GREEN|YELLOW|ORANGE|WHITE").matcher(asplit[i]).matches()) {
                                System.out.println("Неправильные данные eyeColor в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }

                        }
                        case 11: {
                            if (!Pattern.compile("GREEN|RED|YELLOW|WHITE").matcher(asplit[i]).matches()) {
                                System.out.println("Неправильные данные hairColorв в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }

                        }

                        case 12: {
                            if (!Pattern.compile("RUSSIA|GERMANY|CHINA|NORTH_KOREA").matcher(asplit[i]).matches()) {
                                System.out.println("Неправильные данные nationality в файле. Проверьте данные и повторите попытку. ");
                                System.exit(1);
                            }

                        }
                        default:
                            System.out.println("Error");
                    }
                }

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date date = formatter.parse(asplit[4]);

                Coordinates coordinates = new Coordinates(Double.parseDouble(asplit[2]), Integer.valueOf(asplit[3]));
                Person person = new Person(String.valueOf(asplit[8]), String.valueOf(asplit[9]), ColorY.valueOf(asplit[10]), ColorH.valueOf(asplit[11]), Country.valueOf(asplit[12]));
                StudyGroup studyGroup = new StudyGroup(Long.valueOf(asplit[0]), String.valueOf(asplit[1]), coordinates, date, Long.valueOf(asplit[5]), FormOfEducation.valueOf(asplit[6]), Semester.valueOf(asplit[7]), person);

                Main.collection.add(studyGroup);
            }
            bufferedReader.close();

        } catch (IOException | ParseException |NumberFormatException e) {
            System.out.println("Неправильно введены данные в файле.");
            System.exit(1);
        }

    }


    //метод для записи коллекции в файл
    public static void writeFile() throws IOException {
        String file = System.getenv("LABA");
        FileWriter fileWriter = new FileWriter(String.valueOf(file));
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.flush();
        bufferedWriter.write(String.valueOf(Main.collection));
        bufferedWriter.close();
    }
}


