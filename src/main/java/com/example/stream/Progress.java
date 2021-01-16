package com.example.stream;

import java.time.Duration;

public class Progress {

    private Duration studyDuration; //수업을 얼마나 진행했는지 확인하는 변수

    private boolean finished;

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }

}
