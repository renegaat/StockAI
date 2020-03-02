package de.pearlbay.stockai.stockrepo.service.mapper;

import de.pearlbay.stockai.stockrepo.domain.MetaData;
import de.pearlbay.stockai.stockrepo.restclient.dto.MetaDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * MetaDataDtoMapper.
 *
 * @author joern ross (pearlbay) 2020
 */
@Mapper(uses = {ZoneIdMapper.class})
public interface MetaDataDtoMapper {
    @Mapping(source = "lastRefreshed", target = "lastRefreshed", dateFormat = "yyyy-MM-dd HH:mm:ss")
    MetaDataDto toDto(MetaData metaData);
    @Mapping(source = "lastRefreshed", target = "lastRefreshed", dateFormat = "yyyy-MM-dd HH:mm:ss")
    MetaData fromDto(MetaDataDto metaDataDto);
}
