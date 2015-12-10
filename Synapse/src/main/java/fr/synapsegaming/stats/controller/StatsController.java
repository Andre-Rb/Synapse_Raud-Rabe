package fr.synapsegaming.stats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.synapsegaming.commons.controller.AbstractController;
import fr.synapsegaming.media.service.ArticleService;
import fr.synapsegaming.raid.service.ExtensionService;
import fr.synapsegaming.stats.service.StatsService;
import fr.synapsegaming.ui.service.ResourceService;

@Controller("StatsController")
@SessionAttributes(value = { "user", "userResources" })
@RequestMapping("/stats")
public class StatsController extends AbstractController{

	
	 private static final String STATS_VIEW_NAME = "Stats";
	    
	 private static final String EXTENSION_HTTP_ATTRIBUTE = "extension";

	 private static final String PROMS_HTTP_ATTRIBUTE = "proms";

	 private static final String RESOURCES_HTTP_ATTRIBUTE = "resources";
	 
	 private static final String STATS_HTTP_ATTRIBUTE = "stats";
	 
	 private static final String STATS_CLAZZ = "top5Classes";
	 
	 private static final String STATS_RACE = "top5Races";
	 
	 private static final String STATS_SPEC = "top5Specs";
	 
	 private static final String STATS_ACTIF = "top5Actifs";
	 

	 @Autowired
	 ArticleService articleService;

	 @Autowired
	 ResourceService resourceService;

	 @Autowired
	 ExtensionService extensionService;
	 
	 @Autowired
	 StatsService statsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView statistiques(){
    	page = new ModelAndView("Stats");
        page.addObject(RESOURCES_HTTP_ATTRIBUTE, resourceService.listMainMenu());
        page.addObject(EXTENSION_HTTP_ATTRIBUTE,
                extensionService.getLastExtension());
        page.addObject(STATS_ACTIF, statsService.top5Actifs());
        page.addObject(STATS_CLAZZ, statsService.top5Classes()); 
        page.addObject(STATS_RACE, statsService.top5Races());   
        page.addObject(STATS_SPEC, statsService.top5Specialites());           
    	page.setViewName(STATS_VIEW_NAME);
    	return page;
    
    }
	
	
	
}