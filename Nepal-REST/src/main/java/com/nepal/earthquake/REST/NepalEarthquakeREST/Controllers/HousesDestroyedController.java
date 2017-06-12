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


    @RequestMapping(value = "", method = RequestMethod.POST)
    public HousesDestroyed add(@RequestBody HousesDestroyed housesDestroyed){
        System.out.println("[HousesDestroyed] Adding entry.");
        return housesDestroyedService.add(housesDestroyed);
    }

    @RequestMapping(value = "/{district}", method = RequestMethod.DELETE)
    public void removeByDistrict(String district){
        System.out.println("[HousesDestroyed] Removing by district name.");
        housesDestroyedService.removeByDistrict(district);
    }


    @RequestMapping(value = "/{district}/{newNumber}", method = RequestMethod.POST)
    public List<HousesDestroyed> updateNumberByDistrict(@PathVariable("district") String district,@PathVariable("newNumber") int newNumber){
        System.out.println("[HousesDestroyed] Updating number of houses destroyed by district.");
        housesDestroyedService.updateNumberByDistrict(district, newNumber);
        return housesDestroyedService.getByDistrict(district);

    }

    @RequestMapping(value = "/{district}", method = RequestMethod.POST)
    public List<HousesDestroyed> updateDistrictName(@RequestBody HousesDestroyed housesDestroyed,@PathVariable("district") String district){
        System.out.println("[HousesDestroyed] Updating district name.");
        housesDestroyedService.updateDistrictName(housesDestroyed, district);
        return housesDestroyedService.getByDistrict(district);

    }

    @RequestMapping(value = "/coord/{district}/{latitude}/{longitude}/", method = RequestMethod.POST)
    public List<HousesDestroyed> updateCoordinatesByDistrict(@PathVariable("district") String district,
                                                             @PathVariable("latitude") Float latitude,
                                                             @PathVariable("longitude") Float longitude){
        System.out.println("[HousesDestroyed] Updating coordinates by district.");
        return housesDestroyedService.updateCoordinatesByDistrict(district,
                latitude,
                longitude);
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<HousesDestroyed> getAll(){
        System.out.println("[HousesDestroyed] All entries.");
        return housesDestroyedService.getAll();
    }

    @RequestMapping(value = "/short", method = RequestMethod.GET)
    public List<Object[]> getLatLongNumber(){
        System.out.println("[HousesDestroyed] Returning lat, long and number of houses destroyed.");
        return housesDestroyedDAO.getShortAll();
    }

    @RequestMapping(value = "/geoReg/{geoReg}", method = RequestMethod.GET)
    public List<HousesDestroyed> getByGeoRegion(@PathVariable("geoReg") String geoRegion){
        System.out.println("[HousesDestroyed] Entries by geographical region.");
        return housesDestroyedService.getByGeoRegion(geoRegion);
    }

    @RequestMapping(value = "/devReg/{devReg}", method = RequestMethod.GET)
    public List<HousesDestroyed> getbyDevReg(@PathVariable("devReg") String devReg){
        System.out.println("[HousesDestroyed] Entries by development region.");
        return housesDestroyedService.getbyDevReg(devReg);

    }

    @RequestMapping(value = "/district/{district}", method = RequestMethod.GET)
    public List<HousesDestroyed> getByDistrict(String district){
        System.out.println("[HousesDestroyed] Entries by district.");
        return housesDestroyedService.getByDistrict(district);
    }

    //TODO
    public List<HousesDestroyed> getById(int id){
        return null;
    }

    @RequestMapping(value = "/zone/{zone}", method = RequestMethod.GET)
    public List<Object[]> getSimpleResultByZone(String zone){
        System.out.println("[HousesDestroyed] Return lat, long, district name, number of houses destroyed.");
        return housesDestroyedService.getSimpleResultByZone(zone);
    }


}
