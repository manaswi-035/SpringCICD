package com.example.attendance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceServiceTest {

    private final AttendanceService attendanceService =
            new AttendanceService();

    @Test
    void shouldCalculateAttendancePercentage() {

        double result =
                attendanceService.calculatePercentage(35, 40);

        assertEquals(87.5, result);
    }

    @Test
    void shouldReturnEligibleFor75Percent() {

        String result =
                attendanceService.getStatus(75);

        assertEquals("Eligible", result);
    }

    @Test
    void shouldReturnEligibleForAbove75Percent() {

        String result =
                attendanceService.getStatus(87.5);

        assertEquals("Eligible", result);
    }

    @Test
    void shouldReturnNotEligibleBelow75Percent() {

        String result =
                attendanceService.getStatus(74.99);

        assertEquals("Not Eligible", result);
    }

    @Test
    void shouldReturnZeroWhenTotalIsZero() {

        double result =
                attendanceService.calculatePercentage(10, 0);

        assertEquals(0, result);
    }
}