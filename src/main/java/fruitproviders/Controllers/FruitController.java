package fruitproviders.Controllers;

import fruitproviders.Models.Fruit;
import fruitproviders.Services.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.UUID;

@Controller
public class FruitController {

    private IFruitService fruitService;

    @Autowired
    public void setFruitService(IFruitService fruitService){
        this.fruitService = fruitService;
    }

    //Выводим все фрукты из справочкника
    @RequestMapping(value = "/fruits", method = RequestMethod.GET)
    public ModelAndView allFruits() {
        List<Fruit> fruits = fruitService.getAllFruits();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fruits");
        modelAndView.addObject("fruits", fruits);
        return modelAndView;
    }

    //для получения страницы добавления фрукта
    @RequestMapping(value = "/addFruit", method = RequestMethod.GET)
    public ModelAndView addFruitPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addFruit");
        return modelAndView;
    }

    //для добавления
    @RequestMapping(value = "/addFruit", method = RequestMethod.POST)
    public ModelAndView addFruit(@ModelAttribute("fruit") Fruit fruit) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/fruits");
        fruitService.add(fruit);
        return modelAndView;
    }

    //для получения страницы удаления фрукта
    @RequestMapping(value = "/deleteFruit/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFruitPage(@PathVariable("id") UUID id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/fruits");
        fruitService.delete(fruitService.getById(id));
        return modelAndView;
    }

    //для получения страницы редактирования фрукта
    @RequestMapping(value = "/editFruit/{id}", method = RequestMethod.GET)
    public ModelAndView editFruitPage(@PathVariable("id") UUID id) {
        Fruit fruit = fruitService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editFruit");
        modelAndView.addObject("fruit", fruit);
        return modelAndView;
    }

    //Само редактирование
    @RequestMapping(value = "/editFruit/{id}", method = RequestMethod.POST)
    public ModelAndView editFruit(@PathVariable("id") UUID id, @ModelAttribute("fruit") Fruit fruit) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/fruits");
        fruit.setId(id);
        fruitService.edit(fruit);
        return modelAndView;
    }

    //проверить
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Fruit getById(@PathVariable("id") UUID id)
        {
            return fruitService.getById(id);
        }
}
