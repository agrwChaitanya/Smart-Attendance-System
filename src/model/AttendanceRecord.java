package model;

public class AttendanceRecord {
    private int totalClasses = 0;
    private int attendedClasses = 0;

    public void mark(boolean present) {
        totalClasses++;
        if (present) attendedClasses++;
    }

    public double getPercentage() {
        if (totalClasses == 0) return 0;
        return (attendedClasses * 100.0) / totalClasses;
    }
}
