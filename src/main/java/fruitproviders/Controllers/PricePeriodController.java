package fruitproviders.Controllers;

import fruitproviders.Models.*;
import fruitproviders.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class PricePeriodController {

    private IPricePeriodService pricePeriodService;
    private IFruitTypeService fruitTypeService;
    private IPartnerService partnerService;

    @Autowired
    public void setPricePeriodService(IPricePeriodService pricePeriodService){ this.pricePeriodService = pricePeriodService; }

    @Autowired
    public void setFruitTypeService(IFruitTypeService fruitTypeService){
        this.fruitTypeService = fruitTypeService;
    }

    @Autowired
    public void setPartnerService(IPartnerService partnerService){
        this.partnerService = partnerService;
    }

    @RequestMapping(value = "/pricePeriods", method = RequestMethod.GET)
    public ModelAndView getPartnersPage() {
        List<PricePeriod> pricePeriodList = pricePeriodService.getAllPricePeriod();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pricePeriods");
        modelAndView.addObject("pricePeriodList", pricePeriodList);
        return modelAndView;
    }

    @RequestMapping(value = "/addPricePeriod", method = RequestMethod.GET)
    public ModelAndView getAddPricePeriodPage() {
        List<FruitType> fruitTypesList = fruitTypeService.getAllFruitTypes();
        List<Partner> partnersList = partnerService.getAllPartners();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("fruitTypesList", fruitTypesList);
        modelAndView.addObject("partnersList", partnersList);
        modelAndView.setViewName("addPricePeriod");
        return modelAndView;
    }

    @RequestMapping(value = "/addPricePeriod", method = RequestMethod.POST)
    public ModelAndView addPricePeriod(@ModelAttribute("pricePeriod") PricePeriod pricePeriod) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pricePeriods");
        pricePeriod.setFruitType(fruitTypeService.getById(pricePeriod.getFruitTypeId()));
        pricePeriod.setPartner(partnerService.getById(pricePeriod.getPartnerId()));
        pricePeriodService.add(pricePeriod);
        return modelAndView;
    }

    @RequestMapping(value = "/deletePricePeriod/{id}", method = RequestMethod.GET)
    public ModelAndView deletePartner(@PathVariable("id") UUID id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pricePeriods");
        pricePeriodService.delete(pricePeriodService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/getPricePeriodById/{id}", method = RequestMethod.GET)
    public PricePeriod getPricePeriodById(@PathVariable("id") UUID id)
    {
        return pricePeriodService.getById(id);
    }
}
