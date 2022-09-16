package es.kiwi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nerea
 */

@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    /**
     * User type with description
     */
    Java("000", "Java developer engineer"),
    DB("001", "Database Administrator"),
    LINUX("002", "Linux devops");

    private final String value;
    private final String title;

}
