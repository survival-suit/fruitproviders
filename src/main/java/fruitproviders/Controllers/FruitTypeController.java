package fruitproviders.Controllers;

import fruitproviders.Models.Fruit;
import fruitproviders.Models.FruitType;
import fruitproviders.Services.IFruitService;
import fruitproviders.Services.IFruitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class FruitTypeController {

    private IFruitTypeService fruitTypeService;

    private IFruitService fruitService;

    @Autowired
    public void setFruitTypeService(IFruitTypeService fruitTypeService){
        this.fruitTypeService = fruitTypeService;
    }

    @Autowired
    public void setFruitService(IFruitService fruitService){
        this.fruitService = fruitService;
    }

    //Выводим все типы фруктов из справочкника
    @RequestMapping(value = "/fruitTypes", method = RequestMethod.GET)
    public ModelAndView allFruitTypes() {
        List<FruitType> fruitTypes = fruitTypeService.getAllFruitTypes();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fruitTypes");
        modelAndView.addObject("fruitTypes", fruitTypes);
        return modelAndView;
    }

    //для получения страницы добавления типа фрукта
    @RequestMapping(value = "/addFruitType", method = RequestMethod.GET)
    public ModelAndView addFruitTypePage() {
        List<Fruit> fruits = fruitService.getAllFruits();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addFruitType");
        modelAndView.addObject("fruits", fruits);
        return modelAndView;
    }

    //для добавления
    @RequestMapping(value = "/addFruitType", method = RequestMethod.POST)
    public ModelAndView addFruitType(@ModelAttribute("fruitType") FruitType fruitType) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/fruitTypes");
        fruitType.setFruit(fruitService.getById(fruitType.getFruitId()));
        fruitTypeService.add(fruitType);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteFruitType/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFruitType(@PathVariable("id") UUID id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/fruitTypes");
        fruitTypeService.delete(fruitTypeService.getById(id));
        return modelAndView;
    }

    //проверить
    @RequestMapping(value = "/getFruitTypeById/{id}", method = RequestMethod.GET)
    public FruitType getFruitTypeById(@PathVariable("id") UUID id)
    {
        return fruitTypeService.getById(id);
    }
}
