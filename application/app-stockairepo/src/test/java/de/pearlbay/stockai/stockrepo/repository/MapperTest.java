package de.pearlbay.stockai.stockrepo.repository;


import de.pearlbay.stockai.stockrepo.domain.MetaData;
import de.pearlbay.stockai.stockrepo.repository.mapper.MetaDataJpaMapperImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



import java.time.LocalDateTime;
import java.time.ZoneId;

public class MapperTest {

    @Test
    public void shouldMapMetaDataToJpaAndBack(){

        MetaDataJpaMapperImpl metaDataJpaMapper = new MetaDataJpaMapperImpl();

        MetaData metaData = MetaData.builder().information("Information").lastRefreshed(LocalDateTime.now())
                .symbol("Symbol").timeZone(ZoneId.systemDefault()).build();

        MetaDataJpa metaDataJpa = metaDataJpaMapper.toJpa(metaData);
        MetaData result = metaDataJpaMapper.fromJpa(metaDataJpa);

        assertEquals(metaData, result);
    }
}
