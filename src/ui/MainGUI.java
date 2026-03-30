package ui;

import javax.swing.*;
import java.awt.event.*;
import service.AttendanceManager;
import service.Analytics;
import model.Student;
import model.AttendanceRecord;

public class MainGUI {
    static AttendanceManager manager = new AttendanceManager();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Smart Attendance System");
        frame.setSize(400, 400);
        frame.setLayout(null);

        JLabel title = new JLabel("Attendance System");
        title.setBounds(120, 10, 200, 30);
        frame.add(title);

        JButton addBtn = new JButton("Add Student");
        addBtn.setBounds(100, 60, 200, 30);
        frame.add(addBtn);

        JButton markBtn = new JButton("Mark Attendance");
        markBtn.setBounds(100, 100, 200, 30);
        frame.add(markBtn);

        JButton viewBtn = new JButton("View Report");
        viewBtn.setBounds(100, 140, 200, 30);
        frame.add(viewBtn);

        JButton defBtn = new JButton("Show Defaulters");
        defBtn.setBounds(100, 180, 200, 30);
        frame.add(defBtn);

        JTextArea output = new JTextArea();
        output.setBounds(50, 230, 300, 100);
        frame.add(output);

        // Add Student
        addBtn.addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog("Enter ID:");
            String name = JOptionPane.showInputDialog("Enter Name:");

            int id = Integer.parseInt(idStr);
            manager.addStudent(id, name);
            output.setText("Student added!");
        });

        // Mark Attendance
        markBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
            int choice = JOptionPane.showConfirmDialog(null, "Present?");

            boolean present = (choice == JOptionPane.YES_OPTION);
            manager.markAttendance(id, present);

            output.setText("Attendance marked!");
        });

        // View Report
        viewBtn.addActionListener(e -> {
            output.setText(manager.getReport());
        });

        // Defaulters
        defBtn.addActionListener(e -> {
            output.setText(manager.getDefaulters());
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}