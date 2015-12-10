package fr.synapsegaming.stats.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.synapsegaming.social.dao.ForumPostDao;
import fr.synapsegaming.social.dao.ForumReplyDao;
import fr.synapsegaming.social.entity.ForumReply;
import fr.synapsegaming.stats.service.StatsService;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;
import fr.synapsegaming.user.service.UserService;
import fr.synapsegaming.utils.SortMap;


@Service("StatsService")
@Transactional
public class StatsServiceImpl implements StatsService {

	@Autowired
	UserService userService;
	
	@Autowired
	ForumPostDao postsDAO;
	@Autowired
	ForumReplyDao replysDAO;

	@Override
	public Map top5Classes() {
		HashMap<Clazz, Integer> tableClasses = new HashMap <Clazz, Integer>();
		try {
			for(User utilisateur : userService.getAllUsers()){
				if(tableClasses.containsKey(utilisateur.getClazz())){
					tableClasses.put(utilisateur.getClazz(), tableClasses.get(utilisateur.getClazz())+1);
				} else{
					tableClasses.put(utilisateur.getClazz(), 1);
				}
			}

			SortMap sort = new SortMap(tableClasses);
			return sort.sortAndResize(5);
			
		} catch (Exception e){
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Map top5Races() {
		HashMap<Race, Integer> tableRaces = new HashMap <Race, Integer>();
		try{
			for(User utilisateur : userService.getAllUsers()){
				if(tableRaces.containsKey(utilisateur.getRace())){
					tableRaces.put(utilisateur.getRace(), tableRaces.get(utilisateur.getRace())+1);
				} else{
					tableRaces.put(utilisateur.getRace(), 1);
				}
			}
			
			SortMap sort = new SortMap(tableRaces);
			return sort.sortAndResize(5);
			
		} catch (Exception e){
				System.out.println(e);
				return null;
			}
	}

	@Override
	public Map top5Actifs() {
		HashMap<User, Integer> tableActifs = new HashMap <User, Integer>();
		try{
			for(User utilisateur : userService.getAllUsers()){
				
					System.out.println(postsDAO.getNbPostByUser(utilisateur) + " nbposts");
					tableActifs.put(utilisateur, (int)(postsDAO.getNbPostByUser(utilisateur)+replysDAO.getNbReplyByUser(utilisateur)));
			}
			
			SortMap sort = new SortMap(tableActifs);
			return sort.sortAndResize(5);
			
		} catch (Exception e){
			System.out.println(e);
			return null;
		}		
	}

	@Override
	public Map top5Specialites() {
		HashMap<Specialization, Integer> tableSpecs = new HashMap <Specialization, Integer>();
		try {
			for(User utilisateur : userService.getAllUsers()){				
					if(tableSpecs.containsKey(utilisateur.getSpec())){
						tableSpecs.put(utilisateur.getSpec(), tableSpecs.get(utilisateur.getSpec())+1);
					} else {
						tableSpecs.put(utilisateur.getSpec(), 1);
					}							
			}			
			
			SortMap sort = new SortMap(tableSpecs);
			return sort.sortAndResize(5);
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}		
	}
}
