/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinformationsystem;

/**
 *
 * @author 348676487
 */
public class Student implements Comparable {

    String gender;
    String first;
    String last;
    String tele;
    String course;
    String section;
    String mark;

    public Student(String gender, String first, String last, String tele, String course, String section, String mark) {
        this.gender = gender;
        this.first = first;
        this.last = last;
        this.tele = tele;
        this.course = course;
        this.section = section;
        this.mark = mark;
    }

    @Override
    public int compareTo(Object o) {
        Student current = (Student) o;
        return course.compareTo(current.course);
    }

    public String toString() {
        return gender + "   " + first + "   " + last + "   " + tele + "   " + course + "   " + section + "   " + mark;
    }
    
}
