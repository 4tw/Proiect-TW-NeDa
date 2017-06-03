package com.nepal.earthquake.REST.NepalEarthquakeREST.Controllers;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadWomen;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.DeadWomenService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DeadWomenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
@RestController
@RequestMapping("/deadWomen")
public class DeadWomenController {

    @Autowired
    private DeadWomenDAO deadWomenDAO;

    @Autowired
    private DeadWomenService deadWomenService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<DeadWomen> getAll(){
        return deadWomenService.getAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public DeadWomen add(@RequestBody DeadWomen deadWomen){
        return deadWomenService.add(deadWomen);
    }

    @RequestMapping(value = "/district/{district}", method = RequestMethod.DELETE)
    public void removeByDistrict(@PathVariable("district") String district){
        deadWomenService.removeByDistrict(district);
    }

    @RequestMapping(value = "/number/{district}/{newNumber}", method = RequestMethod.POST)
    public DeadWomen updateNumberByDistrict(@PathVariable("district") String district,@PathVariable("newNumber") int newNumber){
        return deadWomenService.updateNumberByDistrict(district, newNumber);
    }

    @RequestMapping(value = "/district/{oldDistrictName}/{newDistrictName}", method = RequestMethod.POST)
    public DeadWomen updateDistrictName(@PathVariable("oldDistrictName") String oldDistrictName,@PathVariable("newDistrictName") String newDistrictName){
        return deadWomenService.updateDistrictName(oldDistrictName, newDistrictName);

    }

    @RequestMapping(value = "/geographicalRegion/{geoRegion}", method = RequestMethod.GET)
    public List<DeadWomen> getByGeoRegion(@PathVariable("geoRegion") String geoRegion){
        return deadWomenService.getByGeoRegion(geoRegion);
    }

    @RequestMapping(value = "/developmentRegion/{devReg}", method = RequestMethod.GET)
    public List<DeadWomen> getbyDevReg(String devReg){
        return deadWomenService.getbyDevReg(devReg);
    }

    @RequestMapping(value = "/district/{district}", method = RequestMethod.GET)
    public DeadWomen getByDistrict(String district){
        return deadWomenService.getByDistrict(district);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public DeadWomen getById(int id){
        return deadWomenService.getById(id);
    }

    @RequestMapping(value = "/devReg/{devReg}", method = RequestMethod.GET)
    List<Object[]> getSimpleResultByDevRegn(String devReg){
        return deadWomenService.getSimpleResultByDevRegn(devReg);

    }
}
