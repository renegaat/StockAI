package de.pearlbay.stockai.stockrepo.domain.mapper;


import java.time.ZoneId;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * ZoneIdMapper.
 * @author joern ross (pearlbay) 2020
 */

@Component
@Mapper
public abstract class ZoneIdMapper {

    public String toString(ZoneId zoneId) {

        if (zoneId == null) {
            return null;
        }
        return zoneId.toString();
    }

    public ZoneId toZoneId(String zoneId) {
        if (zoneId == null) {
            return null;
        }
        return ZoneId.of(zoneId);
    }
}
