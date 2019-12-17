package de.pearlbay.stockai.common.persistence.domain;

import lombok.Data;

/**
 * Baseclass fort all Entities.
 * @author jross
 */

@Data
public class BaseEntity {
    private Long id;
    private int version;
}
