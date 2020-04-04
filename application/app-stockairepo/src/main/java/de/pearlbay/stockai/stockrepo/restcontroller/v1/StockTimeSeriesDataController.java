package de.pearlbay.stockai.stockrepo.restcontroller.v1;

import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * StockTimeSeriesDataController.
 * @author joern ross (pearlbay) 2020
 */
@RestController
@RequestMapping("/stocktimeseriesdata/v1")
public class StockTimeSeriesDataController {

    private StockTimeSeriesDataService stockTimeSeriesDataService;

    private static final Logger LOG = LoggerFactory.getLogger(StockTimeSeriesDataController.class);

    public StockTimeSeriesDataController(@Autowired StockTimeSeriesDataService stockTimeSeriesDataService) {
        this.stockTimeSeriesDataService = stockTimeSeriesDataService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/stocktimeseriesdata")
    public void retrieveStockTimeSeriesData() {
        LOG.info("ENTERED retrieveStockTimeSeriesData");
    }
}
