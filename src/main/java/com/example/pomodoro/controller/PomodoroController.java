package com.example.pomodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pomodoro.dto.PomodoroRequest;
import com.example.pomodoro.service.PomodoroService;

@RestController
@RequestMapping("/api/pomodoro")
public class PomodoroController {

    @Autowired
    private PomodoroService pomodoroServ;

    // start study
    @PostMapping("/study")
    private String startStudy(@RequestBody PomodoroRequest request) {

        pomodoroServ.startStudy(
                request.getUserId(),
                request.getMinutes());

        return "Study Session started successfully";
    }

    // start break
    @PostMapping("/break")
    public String startBreak(@RequestBody PomodoroRequest request) {
        pomodoroServ.startBreak(
                request.getUserId(),
                request.getMinutes());

        return "Break session start successfully";
    }

}
