package de.pearlbay.stockai.common.mapper;

import de.pearlbay.stockai.common.domain.Price;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Pricemapper.
 * @author joern ross (pearlbay) 2020
 */

@Component
@Mapper
public abstract class PriceMapper {

    public Price toPrice(BigDecimal d) {

        if (d == null) {
            return null;
        }

        Price price = new Price();
        price.setAmount(d);

        return price;
    }

    public BigDecimal toBigDecimal(Price price) {

        if (price == null) {
            return null;
        }

        return price.getAmount();
    }

}
