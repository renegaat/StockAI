package de.pearlbay.stockai.common.domain;

import lombok.Value;
import java.math.BigDecimal;
    
@Value
public class Price {
    BigDecimal amount;
}
