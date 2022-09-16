package es.kiwi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class HospitalDTO {

    private List<DoctorDTO> doctors;

    public void addDoctor(DoctorDTO doctorDTO) {
        if (doctors == null) {
            doctors = new ArrayList<>();
        }

        doctors.add(doctorDTO);
    }

}
