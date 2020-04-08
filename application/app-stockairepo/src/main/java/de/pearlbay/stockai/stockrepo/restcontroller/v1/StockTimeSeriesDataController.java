package de.pearlbay.stockai.stockrepo.restcontroller.v1;

import de.pearlbay.stockai.common.enums.Function;
import de.pearlbay.stockai.stockrepo.domain.StockTimeSeriesData;
import de.pearlbay.stockai.stockrepo.domain.service.StockTimeSeriesDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * StockTimeSeriesDataController.
 *
 * @author joern ross (pearlbay) 2020
 */
@RestController
@RequestMapping("/stocktimeseriesdata/v1")
public class StockTimeSeriesDataController {

    public static final String DATEPATTERN = "yyyy-MM-dd HH:mm:ss";
    private StockTimeSeriesDataService stockTimeSeriesDataService;

    private static final Logger LOG = LoggerFactory.getLogger(StockTimeSeriesDataController.class);

    public StockTimeSeriesDataController(@Autowired StockTimeSeriesDataService stockTimeSeriesDataService) {
        this.stockTimeSeriesDataService = stockTimeSeriesDataService;
    }

    @SuppressWarnings("checkstyle:NoWhitespaceBefore")
    @RequestMapping(method = RequestMethod.GET, path = "/stocktimeseriesdata", params = {"symbol", "function"})
    public ResponseEntity<StockTimeSeriesData> retrieveStockTimeSeriesDataBySymbolAndFunction(
            @RequestParam("symbol") String symbol
            , @RequestParam("function") Function function) {

        LOG.debug("ENTERED retrieveStockTimeSeriesData Symbol : " + symbol + " Function : " + function.name());
        StockTimeSeriesData result = stockTimeSeriesDataService
                .retrieveStockTimeSeriesDataBySymbolAndFunction(symbol, function);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @SuppressWarnings("checkstyle:NoWhitespaceBefore")
    @RequestMapping(method = RequestMethod.GET, path = "/stocktimeseriesdata"
            , params = {"symbol", "function", "from", "until"})
    public ResponseEntity<StockTimeSeriesData> retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(
            @RequestParam("symbol") String symbol
            , @RequestParam("function") Function function
            , @RequestParam("from") String start
            , @RequestParam("until") String stop) {

        LOG.debug("ENTERED retrieveStockTimeSeriesData Symbol : " + symbol + " Function : " + function.name()
                + " Date start : " + start + " Date stop : " + stop);

        DateTimeFormatter formater = DateTimeFormatter.ofPattern(DATEPATTERN);

        LocalDateTime startDate = LocalDateTime.parse(start, formater);
        LocalDateTime stopDate = LocalDateTime.parse(stop, formater);

        StockTimeSeriesData result = stockTimeSeriesDataService
                .retrieveStockTimeSeriesDataBySymbolAndFunctionAndDate(symbol, function, startDate, stopDate);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
