package fr.synapsegaming.stats.dao.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;

import fr.synapsegaming.commons.dao.AbstractDao;
import fr.synapsegaming.social.dao.ForumDao;
import fr.synapsegaming.social.entity.Forum;
import fr.synapsegaming.stats.dao.StatsDao;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;
import fr.synapsegaming.user.service.ClazzService;
import fr.synapsegaming.user.service.RaceService;
import fr.synapsegaming.user.service.SpecializationService;
import fr.synapsegaming.user.service.UserService;

public class StatsDaoImpl extends AbstractDao<User, Long> implements StatsDao{
	
	/*@Autowired
	UserService userService;
	
	@Autowired
	ClazzService clazzService;
	
	@Autowired
	RaceService raceService;
	
	@Autowired
	SpecializationService specialiteService;	
	
	public List<User> utilisateurs = userService.getAllUsers();
	public List<Clazz> clazzs = clazzService.list();
	public List<Race> races = raceService.list();	
	public List<Specialization> specialites = specialiteService.list();	
	
	@Override
	public Hashtable<String, Integer> top5Actifs() {
		Session session = this.getSession();		
		
		Hashtable<String, Integer> tableSocial = new Hashtable<>();
		Hashtable<String, Integer> tableSort = new Hashtable<>();
		
		for (User utilisateur : utilisateurs) {
			try{
				Query query = session.createQuery("from ForumPost fp group by id_user where id_user = :id_user");
				query.setParameter("id_user", utilisateur.getId());
				int nbPost = query.list().size();

				Query query2 = session.createQuery("from ForumReply fr group by id_user where id_user = :id_user");
				query.setParameter("id_user", utilisateur.getId());
				int nbReply = query2.list().size();
				
				tableSocial.put(utilisateur.getNickname(), nbReply+nbPost);
			}
			catch (Exception e){
				System.out.println(e);
			}			
		}
	    
		Vector v = new Vector(tableSocial.keySet());
	    Collections.sort(v);
	    Iterator it = v.iterator();
	    while (it.hasNext()) {
	       String element =  (String)it.next();
	       tableSort.put(element, tableSocial.get(element)); 
	    }
	    
	    for (int i = 5; i < tableSort.size(); i++){
	    	tableSort.remove(i);
	    }
	    
		return tableSort;
	}

	@Override
	public Hashtable<String, Integer> top5Classes() {
		Session session = this.getSession();
		
		Hashtable<String, Integer> tableClazzes = new Hashtable<>();
		Hashtable<String, Integer> tableSort = new Hashtable<>();
			
		for (Clazz clazz : clazzs){
			tableClazzes.put(clazz.getName(), 0);
		}
		for (User utilisateur : utilisateurs) {
			try{
				Query query = session.createQuery("from User");

				tableClazzes.put(utilisateur.getClazz().getName(), tableClazzes.get(utilisateur.getClazz().getName()+1));
			}
			catch (Exception e){
				System.out.println(e);
			}			
		}
		Vector v = new Vector(tableClazzes.keySet());
	    Collections.sort(v);
	    Iterator it = v.iterator();
	    while (it.hasNext()) {
	       String element =  (String)it.next();
	       tableSort.put(element, tableClazzes.get(element)); 
	    }
	    
	    for (int i = 5; i < tableSort.size(); i++){
	    	tableSort.remove(i);
	    }
		return tableSort;
	}

	@Override
	public Hashtable<String, Integer> top5Races() {
		Session session = this.getSession();
		
		Hashtable<String, Integer> tableRaces = new Hashtable<>();
		Hashtable<String, Integer> tableSort = new Hashtable<>();
			
		for (Race race : races){
			tableRaces.put(race.getName(), 0);
		}
		for (User utilisateur : utilisateurs) {
			try{
				Query query = session.createQuery("from User");

				tableRaces.put(utilisateur.getRace().getName(), tableRaces.get(utilisateur.getRace().getName()+1));
			}
			catch (Exception e){
				System.out.println(e);
			}			
		}
		Vector v = new Vector(tableRaces.keySet());
	    Collections.sort(v);
	    Iterator it = v.iterator();
	    while (it.hasNext()) {
	       String element =  (String)it.next();
	       tableSort.put(element, tableRaces.get(element)); 
	    }
	    
	    for (int i = 5; i < tableSort.size(); i++){
	    	tableSort.remove(i);
	    }
		return tableSort;
	}

	@Override
	public Hashtable<String, Integer> top5Specialites() {
		Session session = this.getSession();
		
		Hashtable<String, Integer> tableSpecialites = new Hashtable<>();
		Hashtable<String, Integer> tableSort = new Hashtable<>();
			
		for (Specialization specialite : specialites){
			tableSpecialites.put(specialite.getName(), 0);
		}
		for (User utilisateur : utilisateurs) {
			try{
				Query query = session.createQuery("from User");

				tableSpecialites.put(utilisateur.getSpec().getName(), tableSpecialites.get(utilisateur.getSpec().getName()+1));
			}
			catch (Exception e){
				System.out.println(e);
			}			
		}
		Vector v = new Vector(tableSpecialites.keySet());
	    Collections.sort(v);
	    Iterator it = v.iterator();
	    while (it.hasNext()) {
	       String element =  (String)it.next();
	       tableSort.put(element, tableSpecialites.get(element)); 
	    }
	    
	    for (int i = 5; i < tableSort.size(); i++){
	    	tableSort.remove(i);
	    }
		return tableSort;
	}
*/
}
