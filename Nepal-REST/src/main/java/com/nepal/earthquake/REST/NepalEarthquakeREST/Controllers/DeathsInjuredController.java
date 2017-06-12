package com.nepal.earthquake.REST.NepalEarthquakeREST.Controllers;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeathsAndInjured;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.DeathsAndInjuredService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DeathsInjuredDAO;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

//deleted 2 lines, added one

/**
 * Created by Robert on 5/14/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/deaths-injured")
public class DeathsInjuredController {
    @Autowired
    private DeathsAndInjuredService casualtyService;

    @Autowired
    private DeathsInjuredDAO casualtyCount;

    //TODO response body for delete/update

    @RequestMapping(method = RequestMethod.GET)
    public List<DeathsAndInjured> getCasualty(@RequestParam(required = false) Map<String, String> q){
        System.out.println("[DeathsInjured] All entries.");
        return casualtyService.getAll();

    }

    @RequestMapping(value = "/top10Deaths", method = RequestMethod.GET)
    public List<DeathsAndInjured> getTop10Deaths(@RequestParam(required = false)Map<String,String> q){
        System.out.println("[DeathsInjured] Top 10 entries with highest deaths.");
        return casualtyService.getTop10NumberOfDeaths();
    }

    @RequestMapping(value = "/last10Deaths", method = RequestMethod.GET)
    public List<DeathsAndInjured> getLast10Deaths(@RequestParam(required = false)Map<String,String> q){
        System.out.println("[DeathsInjured] Last 10 entries with lowest deaths.");
        return casualtyService.getLast10NumberOfDeaths();
    }

    @RequestMapping(value = "/top10Injuries", method = RequestMethod.GET)
    public List<DeathsAndInjured> getTop10Injuries(@RequestParam(required = false)Map<String,String> q){
        System.out.println("[DeathsInjured] ");
        return casualtyService.getTop10NumberOfInjuries();
    }

    @RequestMapping(value = "/last10Injuries", method = RequestMethod.GET)
    public List<DeathsAndInjured> getLast10Injuries(@RequestParam(required = false)Map<String,String> q){
        System.out.println("[DeathsInjured] Last 10 entries with lowest injuries");
        return casualtyService.getLast10NumberOfInjuries();
    }

    @RequestMapping(value = "/last10Injuries/xml", method = RequestMethod.GET)
    public List<DeathsAndInjured> getLast10InjuriesXml(@RequestParam(required = false)Map<String,String> q){
        /*JSONReader json = new JSONObject(str);
        String xml = XML.toString(json);
        */
        System.out.println("[DeathsInjured] Last 10 entries with lowest injuries.");

        return casualtyService.getLast10NumberOfInjuries();
    }

}
