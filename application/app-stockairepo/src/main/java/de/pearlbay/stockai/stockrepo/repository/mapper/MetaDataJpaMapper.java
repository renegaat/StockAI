package de.pearlbay.stockai.stockrepo.repository.mapper;

import de.pearlbay.stockai.stockrepo.domain.MetaData;
import de.pearlbay.stockai.stockrepo.domain.mapper.ZoneIdMapper;
import de.pearlbay.stockai.stockrepo.repository.MetaDataJpa;
import org.mapstruct.Mapper;

/**
 * MetaDataJpaMapper.
 * @author joern ross (pearlbay) 2020
 */
@Mapper(uses = {ZoneIdMapper.class})
public interface MetaDataJpaMapper {
    MetaDataJpa toJpa(MetaData m);
    MetaData fromJpa(MetaDataJpa jpa);
}
