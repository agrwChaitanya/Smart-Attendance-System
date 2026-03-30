package service;

import java.util.*;
import model.Student;
import model.AttendanceRecord;

public class AttendanceManager {
    Map<Integer, Student> students = new HashMap<>();
    Map<Integer, AttendanceRecord> records = new HashMap<>();

    public void addStudent(int id, String name) {
        students.put(id, new Student(id, name));
        records.put(id, new AttendanceRecord());
    }

    public void markAttendance(int id, boolean present) {
        if (records.containsKey(id)) {
            records.get(id).mark(present);
        }
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        for (int id : students.keySet()) {
            Student s = students.get(id);
            double p = records.get(id).getPercentage();
            sb.append(s.getName()).append(" - ").append(String.format("%.2f", p)).append("%\n");
        }
        return sb.toString();
    }
    public Map<Integer, Student> getStudents() {
        return students;
    }

    public Map<Integer, AttendanceRecord> getRecords() {
        return records;
    }
    public String getDefaulters() {
        return Analytics.getDefaulters(students, records);
    }
}
