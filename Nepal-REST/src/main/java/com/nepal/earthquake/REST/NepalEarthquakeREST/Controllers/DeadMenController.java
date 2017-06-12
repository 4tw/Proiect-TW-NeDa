package com.nepal.earthquake.REST.NepalEarthquakeREST.Controllers;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadMen;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.DeadMenService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DeadMenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */

@CrossOrigin
@RestController
@RequestMapping("/deadMen")
public class DeadMenController {

    @Autowired
    private DeadMenService deadMenService;

    @Autowired
    private DeadMenDAO deadMenDAO;

    @RequestMapping(value ="", method = RequestMethod.POST)
    public DeadMen add(@RequestBody DeadMen deadMen){
        System.out.println("[DeadMen] New entry.");
        return deadMenService.add(deadMen);
    }

    @RequestMapping(value ="/{district}", method = RequestMethod.DELETE)
    public void removeByDistrict(@PathVariable("district") String district){
        System.out.println("[DeadMen] Removing by district.");
        deadMenService.removeByDistrict(district);
    }

    @RequestMapping(value ="/{district}/{newNumber}", method = RequestMethod.POST)
    public List<DeadMen> updateNumberByDistrict(@PathVariable("district") String district,@PathVariable("newNumber") int newNumber){
        System.out.println("[DeadMen] Updating number of deaths by district.");
        deadMenService.updateNumberByDistrict(district, newNumber);
        return deadMenService.getByDistrict(district);
    }

    @RequestMapping(value="/{district}", method = RequestMethod.POST)
    public List<DeadMen> updateDistrictName(@RequestBody DeadMen deadMen, @PathVariable("district") String district){
        System.out.println("[DeadMen] Updating district name.");
        deadMenService.updateDistrictName(deadMen, district);

        return deadMenService.getByDistrict(district);

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<DeadMen> getAll(){
        System.out.println("[DeadMen] Sending all info from table.");
        return deadMenService.getAll();
    }

    @RequestMapping(value="/geoReg/{geoRegion}", method = RequestMethod.GET)
    public List<DeadMen> getByGeoRegion(@PathVariable("geoRegion") String geoRegion){
        System.out.println("[DeadMen] Sending info about a specific Geographical Region.");
        return deadMenService.getByGeoRegion(geoRegion);
    }

    @RequestMapping(value = "/devReg/detailed/{devReg}", method = RequestMethod.GET)
    public List<DeadMen> getbyDevReg(@PathVariable("devReg") String devReg){
        System.out.println("[DeadMen] Sending info about a specific Development Region.");
        return deadMenService.getbyDevReg(devReg);
    }

    @RequestMapping(value = "/district/{district}", method = RequestMethod.GET)
    public List<DeadMen> getByDistrict(@PathVariable("district") String district){
        System.out.println("[DeadMen] Sending info about a specific district.");
        return deadMenService.getByDistrict(district);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public List<DeadMen> getById(@PathVariable("id") int id){

        System.out.println("[DeadMen] Sending info by id.");
        return deadMenService.getById(id);
    }

    @RequestMapping(value = "/devReg/{devReg}", method = RequestMethod.GET)
    public List<Object[]> getSimpleResultByDevRegn(@PathVariable("devReg") String devReg){
        System.out.println("[DeadMen] Special query that sends also the number of dead women by Development Region.");
        return deadMenService.getSimpleResultByDevRegn(devReg);
    }

    @RequestMapping(value = "/zone/{zone}", method = RequestMethod.GET)
    public List<Object[]> getSimpleResultByZone(@PathVariable("zone") String zone){
        return deadMenService.getSimpleResultByZone(zone);
    }
}
