package org.example.pro.level2;

import java.util.Arrays;
import java.util.Optional;

public enum JobType {
    SOLDIER("군인"),
    STUDENT("학생"),
    CITIZEN("일반인");

    private final String label;

    JobType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Optional<JobType> findByLabel(String label) {
        return Arrays.stream(values())
                .filter(job -> job.getLabel().equals(label))
                .findFirst();
    }
}
