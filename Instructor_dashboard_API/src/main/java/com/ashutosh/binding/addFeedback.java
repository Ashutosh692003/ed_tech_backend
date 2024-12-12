package com.ashutosh.binding;

import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class addFeedback {
    private Integer studentId;
    private Integer instructorId;
    @Lob
    private String feedback;
}
