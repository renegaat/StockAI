package de.pearlbay.stockai.stockrepo.domain;

import de.pearlbay.stockai.common.persistence.domain.BaseEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * MetaData.
 * @author joern ross (pearlbay) 2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class MetaData extends BaseEntity {
    private String symbol;
    private String information;
    private LocalDateTime lastRefreshed;
    private ZoneId timeZone;
}
