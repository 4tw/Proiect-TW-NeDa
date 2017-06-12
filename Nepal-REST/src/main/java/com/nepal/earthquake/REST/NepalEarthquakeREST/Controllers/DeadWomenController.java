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

@CrossOrigin
@RestController
@RequestMapping("/deadWomen")
public class DeadWomenController {

    @Autowired
    private DeadWomenDAO deadWomenDAO;

    @Autowired
    private DeadWomenService deadWomenService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<DeadWomen> getAll(){
        System.out.println("[DeadWomen] Sending all info from table.");
        return deadWomenService.getAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public DeadWomen add(@RequestBody DeadWomen deadWomen){
        System.out.println("[DeadWomen] Adding an entry.");
        return deadWomenService.add(deadWomen);
    }

    @RequestMapping(value = "/district/{district}", method = RequestMethod.DELETE)
    public void removeByDistrict(@PathVariable("district") String district){
        System.out.println("[DeadWomen] Removing entries by district.");
        deadWomenService.removeByDistrict(district);
    }

    @RequestMapping(value = "/number/{district}/{newNumber}", method = RequestMethod.POST)
    public List<DeadWomen> updateNumberByDistrict(@PathVariable("district") String district,@PathVariable("newNumber") int newNumber){
        System.out.println("[DeadWomen] Updating number of dead women by district.");
        deadWomenService.updateNumberByDistrict(district, newNumber);
        return deadWomenService.getByDistrict(district);
    }

    @RequestMapping(value = "/district/{oldDistrictName}/{newDistrictName}", method = RequestMethod.POST)
    public List<DeadWomen> updateDistrictName(@PathVariable("oldDistrictName") String oldDistrictName,@PathVariable("newDistrictName") String newDistrictName){
        System.out.println("[DeadWomen] Updating district name.");
        deadWomenService.updateDistrictName(oldDistrictName, newDistrictName);
        return deadWomenService.getByDistrict(newDistrictName);

    }

    @RequestMapping(value = "/geographicalRegion/{geoRegion}", method = RequestMethod.GET)
    public List<DeadWomen> getByGeoRegion(@PathVariable("geoRegion") String geoRegion){
        System.out.println("[DeadWomen] Sending all from a specific geographical region.");
        return deadWomenService.getByGeoRegion(geoRegion);
    }

    @RequestMapping(value = "/developmentRegion/{devReg}", method = RequestMethod.GET)
    public List<DeadWomen> getbyDevReg(String devReg){
        System.out.println("[DeadWomen] Sending info from a specific development region.");
        return deadWomenService.getbyDevReg(devReg);
    }

    @RequestMapping(value = "/district/{district}", method = RequestMethod.GET)
    public List<DeadWomen> getByDistrict(String district){
        System.out.println("[DeadWomen] Sending info from a specific district.");
        return deadWomenService.getByDistrict(district);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public List<DeadWomen> getById(int id){
        System.out.println("[DeadWomen] Sending info by id.");
        return deadWomenService.getById(id);
    }

    @RequestMapping(value = "/devReg/{devReg}", method = RequestMethod.GET)
    public List<Object[]> getSimpleResultByDevRegn(String devReg){
        System.out.println("[DeadWomen] Sending district name and number for all entries in the db.");
        return deadWomenService.getSimpleResultByDevRegn(devReg);
    }

}
