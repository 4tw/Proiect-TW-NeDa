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

@CrossOrigin
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
        System.out.println("[Donations] ");
        donationsService.removeDonationsByDonor(donorName);
    }

    @RequestMapping(value = "/remove/fundation/{fundationName}", method = RequestMethod.DELETE)
    public void deleteDonationsByFundation(@PathVariable("fundationName") String fundationName){
        System.out.println("[Donations] ");
        donationsService.removeDonationsByFundation(fundationName);

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addDonation(@RequestBody Donations donation){
        System.out.println("[Donations] ");
        donationsService.addDonations(donation);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Donations> getAllDonations(){
        System.out.println("[Donations] All donations.");
        return donationsService.getAllDonations();
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public List<Donations> getTop10Donations(){
        System.out.println("[Donations] Last 10 donations.");
        return donationsService.getTopDonations(10);
    }

    @RequestMapping(value = "/top/{top}", method = RequestMethod.GET)
    public List<Donations> getTopDonations(@PathVariable int top){
        System.out.println("[Donations] Top n donations.");
        return donationsService.getTopDonations(top);
    }

    @RequestMapping(value = "/last", method = RequestMethod.GET)
    public List<Donations> getLast10Donations(){
        System.out.println("[Donations] Last 10 entries with lowest amount of donation.");
        return donationsService.getLastDonations(10);
    }

    @RequestMapping(value = "/last/{last}", method = RequestMethod.GET)
    public List<Donations> getLastDonations(@PathVariable int last){
        System.out.println("[Donations] Entries with lowest amount of donation.");
        return donationsService.getLastDonations(last);
    }

    @RequestMapping(value = "/{fundation}", method = RequestMethod.GET)
    public List<Object[]> getDonationsByFundation(@PathVariable("fundation") String fundation){
        System.out.println("[Donations] All donations by fundation.");
        return donationsService.getDonationsByFundation(fundation, 0);
    }

    @RequestMapping(value = "/{fundation}/{limit}", method = RequestMethod.GET)
    public List<Donations> getDonationsByFundation(@PathVariable("fundation") String fundation, @PathVariable("limit") int limit){
        System.out.println("[Donations] All donations by a specific fundation.(with limit)");
        return donationsService.getDetailedDonationsByFundation(fundation, limit);
    }

    @RequestMapping(value = "/sumByFundation", method = RequestMethod.GET)
    public List<Object[]> getDonationsSumByFundation(){
        System.out.println("[Donations] All donations' sum by fundation.");
        return donationsDAO.getDonationsSumByFundation();
    }

    @RequestMapping(value = "/donor/{donorName}", method = RequestMethod.GET)
    public List<Donations> getDonationByDonor(@PathVariable String donorName){
        System.out.println("[Donations] All donations by donor.");
        return donationsService.getDonationsByDonor(donorName);
    }
}
