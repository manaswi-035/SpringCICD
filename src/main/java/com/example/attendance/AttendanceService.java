package com.example.attendance;

import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    public double calculatePercentage(int attended, int total) {

        if (total <= 0) {
            return 0;
        }

        return ((double) attended / total) * 100;
    }

    public String getStatus(double percentage) {

        if (percentage >= 75) {
            return "Eligible";
        } else {
            return "Not Eligible";
        }
    }
}