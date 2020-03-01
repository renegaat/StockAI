package de.pearlbay.stockai.stockrepo.service.mapper;

import de.pearlbay.stockai.stockrepo.domain.MetaData;
import de.pearlbay.stockai.stockrepo.restclient.dto.MetaDataDto;
import org.mapstruct.Mapper;

/**
 * MetaDataDtoMapper.
 *
 * @author joern ross (pearlbay) 2020
 */
@Mapper(uses = {ZoneIdMapper.class})
public interface MetaDataDtoMapper {
    MetaDataDto toDto(MetaData metaData);
    MetaData fromDto(MetaDataDto metaDataDto);
}
