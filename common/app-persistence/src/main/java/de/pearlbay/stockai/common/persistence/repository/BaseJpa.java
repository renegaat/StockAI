package de.pearlbay.stockai.common.persistence.repository;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Basisklasse für alle änderbaren Entitäten.
 **
 * @author joern ross (pearlbay) 2020
 */
@MappedSuperclass
@Data
public class BaseJpa {
    @Version
    private int version;
}
