package de.pearlbay.stockai.stockrepo.service;

import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesDataRepository;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesDataService;
import org.springframework.beans.factory.annotation.Autowired;

public class StockTimeSeriesDataServiceImpl implements StockTimeSeriesDataService {
    @Autowired
    private StockTimeSeriesDataRepository stockTimeSeriesDataRepository;
}
