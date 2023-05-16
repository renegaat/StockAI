package de.pearlbay.stockai.stockrepo.repository;


import de.pearlbay.stockai.common.persistence.repository.BaseJpa;
import lombok.*;

import jakarta.persistence.*;
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
    @Column(name = "md_metadata_id")
    private Long id;

    @Column(name = "md_version")
    private int version;

    @Column(name = "md_symbol")
    private String symbol;
    @Column(name = "md_information")
    private String information;

    @Column(name = "md_last_refreshed")
    private LocalDateTime lastRefreshed;

    @Column(name = "md_time_zone")
    private String timeZone;
}
