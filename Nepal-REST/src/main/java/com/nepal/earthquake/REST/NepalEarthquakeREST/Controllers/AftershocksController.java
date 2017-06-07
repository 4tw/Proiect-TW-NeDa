package com.nepal.earthquake.REST.NepalEarthquakeREST.Controllers;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.Aftershocks;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.AftershocksService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.AftershocksDAO;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Robert on 5/20/2017.
 */

@CrossOrigin
@RestController
@RequestMapping("/aftershocks")
public class AftershocksController {

    @Autowired
    private AftershocksDAO aftershocksDAO;

    @Autowired
    private AftershocksService aftershocksService;


    //TODO response body for delete/update

    @RequestMapping(value = "/delete/{districtName}", method = RequestMethod.DELETE)
    public void deleteByDistrictName(@PathVariable String districtName){
        aftershocksService.deleteDistrictRecord(districtName);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Aftershocks add(@RequestBody Aftershocks aftershocks){
        aftershocksService.addNewRecord(aftershocks);
        return aftershocks;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Aftershocks> getAllRecords(){
        return aftershocksService.getAll();
    }

    @RequestMapping(value = "/top3", method = RequestMethod.GET)
    public List<Aftershocks> getTop3Records(){
        return aftershocksService.getTop3ByMagnitude();
    }

    @RequestMapping(value = "/last3", method = RequestMethod.GET)
    public List<Aftershocks> getLast3Records(){
        return aftershocksService.getLast3ByMagnitude();
    }
}
