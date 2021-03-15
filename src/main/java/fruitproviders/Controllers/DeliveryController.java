package fruitproviders.Controllers;

import fruitproviders.Models.Delivery;
import fruitproviders.Classes.BetweenDate;
import fruitproviders.Models.PricePeriod;
import fruitproviders.Services.IDeliveryService;
import fruitproviders.Services.IPricePeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class DeliveryController {

    public IDeliveryService deliveryService;
    public IPricePeriodService pricePeriodService;

    @Autowired
    public void setDeliveryService(IDeliveryService deliveryService){ this.deliveryService = deliveryService; }

    @Autowired
    public void setPricePeriodService(IPricePeriodService pricePeriodService){ this.pricePeriodService = pricePeriodService; }

    @RequestMapping(value = "/deliveries", method = RequestMethod.GET)
    public ModelAndView getPartnersPage() {
        List<Delivery> deliveryList = deliveryService.getAllDeliveries();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deliveries");
        modelAndView.addObject("deliveryList", deliveryList);
        return modelAndView;
    }

    @RequestMapping(value = "/addDelivery", method = RequestMethod.GET)
    public ModelAndView getAddPartnerPage() {
        List<PricePeriod> pricePeriodList = pricePeriodService.getAllPricePeriod();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pricePeriodList", pricePeriodList);
        modelAndView.setViewName("addDelivery");
        return modelAndView;
    }

    @RequestMapping(value = "/addDelivery", method = RequestMethod.POST)
    public ModelAndView addPartner(@ModelAttribute("partner") Delivery delivery) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/deliveries");
        delivery.setPricePeriod(pricePeriodService.getById(delivery.getPricePeriodId()));
        deliveryService.add(delivery);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteDelivery/{id}", method = RequestMethod.GET)
    public ModelAndView deletePartner(@PathVariable("id") UUID id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/deliveries");
        deliveryService.delete(deliveryService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/getDeliveryById/{id}", method = RequestMethod.GET)
    public Delivery getDeliveryById(@PathVariable("id") UUID id)
    {
        return deliveryService.getById(id);
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public ModelAndView getReportPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("report");
        return modelAndView;
    }

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ModelAndView getReport(@ModelAttribute("partner") BetweenDate betweenDate) {
        List<Delivery> deliveryList = deliveryService.getDeliveriesPerPeriod(betweenDate.getDateBegin(), betweenDate.getDateEnd());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("deliveryList", deliveryList);
        modelAndView.setViewName("report");
        return modelAndView;
    }

}
