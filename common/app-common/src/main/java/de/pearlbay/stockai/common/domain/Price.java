package de.pearlbay.stockai.common.domain;

import lombok.Value;
import java.math.BigDecimal;

/**
 * Price value object.
 * @author joern ross (pearlbay) 2020
 */
@Value
public class Price {
    private BigDecimal amount;
}
