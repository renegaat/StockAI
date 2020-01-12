package de.pearlbay.stockai.stockrepo.domain;

import de.pearlbay.stockai.common.domain.Price;
import de.pearlbay.stockai.common.persistence.domain.BaseEntity;
import lombok.*;

import java.time.LocalDateTime;

/**
 * TimeSeries.
 * @author joern ross (pearlbay) 2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class TimeSeries extends BaseEntity {
    private LocalDateTime time;
    private Price open;
    private Price high;
    private Price low;
    private Price close;
    private double volume;
}
