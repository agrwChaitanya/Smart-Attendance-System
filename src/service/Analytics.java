package service;

import java.util.*;
import model.Student;
import model.AttendanceRecord;

public class Analytics {
    public static String getDefaulters(Map<Integer, Student> students,
                                       Map<Integer, AttendanceRecord> records) {
        StringBuilder sb = new StringBuilder("Defaulters (<75%):\n");

        for (int id : students.keySet()) {
            double p = records.get(id).getPercentage();
            if (p < 75) {
                sb.append(students.get(id).getName())
                        .append(" - ")
                        .append(String.format("%.2f", p))
                        .append("%\n");
            }
        }
        return sb.toString();
    }
}