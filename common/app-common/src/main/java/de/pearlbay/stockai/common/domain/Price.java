package de.pearlbay.stockai.common.domain;

import lombok.Data;
import java.math.BigDecimal;

/**
 * Price value object.
 * @author joern ross (pearlbay) 2020
 */
@Data
public class Price {
    private BigDecimal value;
}
