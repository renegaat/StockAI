package de.pearlbay.stockai.common.persistence.domain;

import lombok.Data;

/**
 * Baseclass for all entities.
 * @author joern ross (pearlbay) 2020
 */

@Data
public class BaseEntity {
    private int version;
}
