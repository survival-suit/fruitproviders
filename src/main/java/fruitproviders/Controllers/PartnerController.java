package fruitproviders.Controllers;

import fruitproviders.Models.Partner;
import fruitproviders.Services.IPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class PartnerController {

    private IPartnerService partnerService;

    @Autowired
    public void setPartnerService(IPartnerService partnerService){
        this.partnerService = partnerService;
    }

    @RequestMapping(value = "/partners", method = RequestMethod.GET)
    public ModelAndView getPartnersPage() {
        List<Partner> partnerList = partnerService.getAllPartners();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("partners");
        modelAndView.addObject("partnerList", partnerList);
        return modelAndView;
    }

    @RequestMapping(value = "/addPartner", method = RequestMethod.GET)
    public ModelAndView getAddPartnerPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPartner");
        return modelAndView;
    }

    @RequestMapping(value = "/addPartner", method = RequestMethod.POST)
    public ModelAndView addPartner(@ModelAttribute("partner") Partner partner) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/partners");
        partnerService.add(partner);
        return modelAndView;
    }

    @RequestMapping(value = "/deletePartner/{id}", method = RequestMethod.GET)
    public ModelAndView deletePartner(@PathVariable("id") UUID id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/partners");
        partnerService.delete(partnerService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/getPartnerById/{id}", method = RequestMethod.GET)
    public Partner getPartnerById(@PathVariable("id") UUID id)
    {
        return partnerService.getById(id);
    }
}

