package es.kiwi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author nerea
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO {

    private int id;
    private String name;
    private LocalDate dateOfBirth;
}
