package com.example.pomodoro.dto;

import com.example.pomodoro.entity.PomodoroSession;
import java.util.List;

public class DashboardResponse {

    private long studySessions;
    private long breakSessions;
    private int totalStudyMinutes;
    private List<PomodoroSession> sessions;

    public long getStudySessions() {
        return studySessions;
    }

    public void setStudySessions(long studySessions) {
        this.studySessions = studySessions;
    }

    public long getBreakSessions() {
        return breakSessions;
    }

    public void setBreakSessions(long breakSessions) {
        this.breakSessions = breakSessions;
    }

    public int getTotalStudyMinutes() {
        return totalStudyMinutes;
    }

    public void setTotalStudyMinutes(int totalStudyMinutes) {
        this.totalStudyMinutes = totalStudyMinutes;
    }

    public List<PomodoroSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<PomodoroSession> sessions) {
        this.sessions = sessions;
    }
}
