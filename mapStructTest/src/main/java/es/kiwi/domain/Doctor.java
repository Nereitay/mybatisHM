package es.kiwi.domain;

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
@Builder
public class Doctor {

    private int id;
    private String name;

    private String speciality;

    private List<Patient> patients;

    private LocalDateTime availability;

    private String externalId;



}
