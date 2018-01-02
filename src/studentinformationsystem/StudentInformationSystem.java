/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinformationsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 348676487
 */
public class StudentInformationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StudentInformationSystem helper = new StudentInformationSystem();

        Student[] unsorted = helper.loadList("registration.csv");
        helper.sortAndDisplay(unsorted);
        helper.courseList(unsorted);
    }

    public Student[] loadList(String fileName) {
        File f = new File(fileName);

        ArrayList<Student> temp = new ArrayList();

        Student[] list = null;

        Scanner s = null;
        try {
            s = new Scanner(f);
            while (s.hasNextLine()) {
                String info = s.nextLine();
                String[] split = info.split(",");
                Student nextStudent = new Student(split[0], split[1], split[2], split[3], split[4], split[5], split[6]);
                temp.add(nextStudent);
            }

            list = temp.toArray(new Student[temp.size()]);
            s.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");
        }
        return list;
    }

    public void sortAndDisplay(Student[] list) {
        Arrays.sort(list);

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public void courseList(Student[] list) {

        Scanner s = new Scanner(in);

        System.out.println("Enter the course code:");
        String section = null;
        do {
            section = s.nextLine();
        } while (!section.equals("1") && !section.equals("2") && !section.equals("3"));

        String code = null;
        do {
            System.out.println("Enter the course code:");
            code = s.nextLine();
        } while ((!code.equals("TEJ2O") && !code.equals("ICS2O") && !code.equals("ICS3U") && !code.equals("TEJ3M") && !code.equals("ICS3C") && !code.equals("ICS4U") && !code.equals("TEJ4M") && !code.equals("ICS4C")));

        
         File f = new File("ICS3U-02.CSV");
         PrintWriter pw = null;
         try {
         pw = new PrintWriter(new FileWriter(f, false));
         for (int i = 0; i < list.length; i++) {
         if (list[i].section.compareTo(section) == 0 && list[i].course.compareTo(code) == 0) {
         pw.println(list[i].first + "," + list[i].last + "," + list[i].gender + "," + list[i].mark + ",");
         }
         }
         pw.close();
         } catch (IOException ex) {
         System.out.println("IO Error");
         }
         
    }

}
