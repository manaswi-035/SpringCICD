package com.example.attendance;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam int attended,
            @RequestParam int total,
            Model model) {

        // Calculate attendance percentage
        double percentage =
                attendanceService.calculatePercentage(attended, total);

        // Determine eligibility
        String status =
                attendanceService.getStatus(percentage);

        // Send results to HTML page
        model.addAttribute("attended", attended);
        model.addAttribute("total", total);
        model.addAttribute("percentage",
                String.format("%.2f", percentage));
        model.addAttribute("status", status);

        return "index";
    }
}