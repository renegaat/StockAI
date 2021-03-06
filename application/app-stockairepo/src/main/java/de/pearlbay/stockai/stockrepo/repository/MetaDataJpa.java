package de.pearlbay.stockai.stockrepo.repository;


import de.pearlbay.stockai.common.persistence.repository.BaseJpa;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * MetaDataJpa.
 * @author joern ross (pearlbay) 2020
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "metadata")
@Data
@EqualsAndHashCode(callSuper = true)
public class MetaDataJpa extends BaseJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "metadata_id_seq")
    @SequenceGenerator(name = "metadata_id_seq", sequenceName = "metadata_id_seq")
    @Column(name = "metadata_id")
    private Long id;

    private String symbol;
    private String information;

    @Column(name = "last_refreshed")
    private LocalDateTime lastRefreshed;

    @Column(name = "time_zone")
    private String timeZone;
}
