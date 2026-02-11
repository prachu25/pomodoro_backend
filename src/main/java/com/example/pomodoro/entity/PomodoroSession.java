package com.example.pomodoro.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pomodoro_sessions")
public class PomodoroSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "session_type", nullable = false)
    private String sessionType; // STUDY / BREAK

    @Column(nullable = false)
    private Integer minutes;

    @Column(name = "session_date", nullable = false)
    private LocalDate sessionDate;

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }
}
