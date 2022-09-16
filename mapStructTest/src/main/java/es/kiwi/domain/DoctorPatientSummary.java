package es.kiwi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DoctorPatientSummary {

    private int doctorId;
    private int patientCount;
    private String doctorName;
    private String specialization;
    private String institute;
    private List<Integer> patientIds;

}
