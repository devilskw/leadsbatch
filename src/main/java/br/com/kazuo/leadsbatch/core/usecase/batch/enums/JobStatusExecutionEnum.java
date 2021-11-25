package br.com.kazuo.leadsbatch.core.usecase.batch.enums;

import java.util.Arrays;

public enum JobStatusExecutionEnum {
    COMPLETED("COMPLETED"),
    FAILED("FAILED");

    private String description;

    JobStatusExecutionEnum(String description) {
        this.description = description;
    }

    public static JobStatusExecutionEnum getByDescription(String description) {
        return Arrays.stream(JobStatusExecutionEnum.values()).filter(st -> st.description.equalsIgnoreCase(description)).findFirst().orElse(JobStatusExecutionEnum.FAILED);
    }
}
