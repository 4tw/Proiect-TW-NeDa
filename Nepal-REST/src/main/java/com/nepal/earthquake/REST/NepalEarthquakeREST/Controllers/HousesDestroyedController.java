package com.nepal.earthquake.REST.NepalEarthquakeREST.Controllers;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.HousesDestroyed;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.HousesDestroyedService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.HousesDestroyedDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 * */

@CrossOrigin
@RestController
@RequestMapping("/housesDestroyed")
public class HousesDestroyedController{

    @Autowired
    private HousesDestroyedDAO housesDestroyedDAO;

    @Autowired
    private HousesDestroyedService housesDestroyedService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<HousesDestroyed> getAll(){
        return housesDestroyedService.getAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public HousesDestroyed add(@RequestBody HousesDestroyed housesDestroyed){
        return housesDestroyedService.add(housesDestroyed);
    }

    @RequestMapping(value = "/{district}", method = RequestMethod.DELETE)
    public void removeByDistrict(String district){
        housesDestroyedService.removeByDistrict(district);
    }


    @RequestMapping(value = "/{district}/{newNumber}", method = RequestMethod.POST)
    public List<HousesDestroyed> updateNumberByDistrict(@PathVariable("district") String district,@PathVariable("newNumber") int newNumber){
        housesDestroyedService.updateNumberByDistrict(district, newNumber);

        return housesDestroyedService.getByDistrict(district);

    }

    @RequestMapping(value = "/{district}", method = RequestMethod.POST)
    public List<HousesDestroyed> updateDistrictName(@RequestBody HousesDestroyed housesDestroyed,@PathVariable("district") String district){
        housesDestroyedService.updateDistrictName(housesDestroyed, district);
        return housesDestroyedService.getByDistrict(district);

    }

    @RequestMapping(value = "/coord/{district}/{latitude}/{longitude}/", method = RequestMethod.POST)
    public List<HousesDestroyed> updateCoordinatesByDistrict(@PathVariable("district") String district,
                                                             @PathVariable("latitude") Float latitude,
                                                             @PathVariable("longitude") Float longitude){
        return housesDestroyedService.updateCoordinatesByDistrict(district,
                latitude,
                longitude);
    }

    @RequestMapping(value = "/geoReg/{geoReg}", method = RequestMethod.GET)
    public List<HousesDestroyed> getByGeoRegion(@PathVariable("geoReg") String geoRegion){
        return housesDestroyedService.getByGeoRegion(geoRegion);
    }

    @RequestMapping(value = "/devReg/{devReg}", method = RequestMethod.GET)
    public List<HousesDestroyed> getbyDevReg(@PathVariable("devReg") String devReg){
        return housesDestroyedService.getbyDevReg(devReg);

    }

    @RequestMapping(value = "/district/{district}", method = RequestMethod.GET)
    public List<HousesDestroyed> getByDistrict(String district){
        return housesDestroyedService.getByDistrict(district);
    }

    //TODO
    public List<HousesDestroyed> getById(int id){
        return null;
    }

    @RequestMapping(value = "/zone/{zone}", method = RequestMethod.GET)
    public List<Object[]> getSimpleResultByZone(String zone){
        return housesDestroyedService.getSimpleResultByZone(zone);
    }


}
