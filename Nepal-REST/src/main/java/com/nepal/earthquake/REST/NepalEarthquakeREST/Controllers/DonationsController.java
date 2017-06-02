package com.nepal.earthquake.REST.NepalEarthquakeREST.Controllers;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.Donations;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.DonationsService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DonationsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Robert on 5/20/2017.
 */
@RestController
@RequestMapping("/donations")
public class DonationsController {
    @Autowired
    private DonationsService donationsService;

    @Autowired
    private DonationsDAO donationsDAO;

    //TODO response body for delete/update


    @RequestMapping(value = "/remove/donor/{donorName}", method = RequestMethod.DELETE)
    public void deleteDonation ( @PathVariable("donorName") String donorName){
        donationsService.removeDonationsByDonor(donorName);
    }

    @RequestMapping(value = "/remove/fundation/{fundationName}", method = RequestMethod.DELETE)
    public void deleteDonationsByFundation(@PathVariable("fundationName") String fundationName){
        donationsService.removeDonationsByFundation(fundationName);

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addDonation(@RequestBody Donations donation){
        donationsService.addDonations(donation);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Donations> getAllDonations(){
        return donationsService.getAllDonations();
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public List<Donations> getTop10Donations(){
        return donationsService.getTopDonations(10);
    }

    @RequestMapping(value = "/top/{top}", method = RequestMethod.GET)
    public List<Donations> getTopDonations(@PathVariable int top){
        return donationsService.getTopDonations(top);
    }

    @RequestMapping(value = "/last", method = RequestMethod.GET)
    public List<Donations> getLast10Donations(){
        return donationsService.getLastDonations(10);
    }

    @RequestMapping(value = "/last/{last}", method = RequestMethod.GET)
    public List<Donations> getLastDonations(@PathVariable int last){
        return donationsService.getLastDonations(last);
    }

    @RequestMapping(value = "/{fundation}", method = RequestMethod.GET)
    public List<Object[]> getDonationsByFundation(@PathVariable("fundation") String fundation){
        return donationsService.getDonationsByFundation(fundation, 0);
    }

    @RequestMapping(value = "/{fundation}/{limit}", method = RequestMethod.GET)
    public List<Donations> getDonationsByFundation(@PathVariable("fundation") String fundation, @PathVariable("limit") int limit){
        return donationsService.getDetailedDonationsByFundation(fundation, limit);
    }

    @RequestMapping(value = "/sumByFundation", method = RequestMethod.GET)
    public List<Donations> getDonationsSumByFundation(){
        return donationsDAO.getDonationsSumByFundation();
    }

    @RequestMapping(value = "/donor/{donorName}", method = RequestMethod.GET)
    public List<Donations> getDonationByDonor(@PathVariable String donorName){
        return donationsService.getDonationsByDonor(donorName);
    }
}
