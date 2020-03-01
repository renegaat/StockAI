package de.pearlbay.stockai.stockrepo.service.mapper;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

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
