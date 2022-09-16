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
public class Education {

    private String degreeName;
    private String institute;
    private Integer yearOfPassing;

}
