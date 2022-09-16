package es.kiwi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nerea
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

    private int id;
    private String name;
    private String dateOfBirth;
}
