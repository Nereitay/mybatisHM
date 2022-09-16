package es.kiwi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author nerea
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {

    private Integer id;
    private String name;

    private String specialization;

    private String degree;

    private List<PatientDTO> patientDTOList;

    private LocalDateTime availability;

    private String externalId;
}
