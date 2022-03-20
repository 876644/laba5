package com.company.classes;

import com.company.Enums.FormOfEducation;
import com.company.Enums.Semester;

public class StudyGroup {

    private Long id;
    private String name;
    private Coordinates coordinates;
    private java.util.Date creationDate;
    private Long studentsCount;
    private FormOfEducation formOfEducation;
    private Semester semesterEnum;
    private Person groupAdmin;

    public StudyGroup( Long id,String name, Coordinates coordinates, java.util.Date creationDate, Long studentsCount, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.studentsCount = studentsCount;
        this.formOfEducation = formOfEducation;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
    }

}
