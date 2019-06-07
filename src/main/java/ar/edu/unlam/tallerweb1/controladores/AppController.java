package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Commerce;
import ar.edu.unlam.tallerweb1.modelo.Item;
import ar.edu.unlam.tallerweb1.modelo.Message;

import ar.edu.unlam.tallerweb1.servicios.ItemService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Controller

public class AppController {

    @Inject
    private ItemService itemService;

    @RequestMapping("/home")
    public ModelAndView home() {

        ModelMap model = new ModelMap();

        Message message = new Message();
        model.put("message", message);

        return new ModelAndView("home", model);
    }

    @RequestMapping(path = "/buscar", method = RequestMethod.POST)
    public ModelAndView buscar(@ModelAttribute("message") Message message, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        List<Object[]> items = itemService.searchItems(message);
        model.put("items", items);
        return new ModelAndView("itemList", model);
    }


    // Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {
        return new ModelAndView("redirect:/home");
    }
    
    

    
	@RequestMapping(path="/buscarProductoPorMarca",method=RequestMethod.GET)
	public ModelAndView buscarProducto() {
		
		
		itemService.crearItems();
		

		return new ModelAndView("buscar");
	}
    
	@RequestMapping(path="/ComerciosEncontrados",method=RequestMethod.GET)
	public ModelAndView detalleProducto(@RequestParam String marca) {
		
		  ModelMap model = new ModelMap();
		
		List<Item>listaDeProductos=itemService.obtenerProductoPorMarca(marca);
		

		
		Set<Commerce>comercios=	 listaDeProductos.get(0).getCommerces();
		
		List <Commerce> comerciosList = new ArrayList <Commerce> (comercios);
		
		
		// Covert List to Json
		Gson gson = new Gson();
		String jsonString = gson.toJson(comerciosList);
		

		  model.put("items", listaDeProductos);
		  model.put("comercios", comerciosList);
		  model.put("jsonString", jsonString);
	
		
		return new ModelAndView("itemList",model);
			//	return new ModelAndView("resultado",model);
	}
	

	
	
	
	
	
	
    
}
