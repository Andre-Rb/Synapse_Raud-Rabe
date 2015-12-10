package fr.synapsegaming.stats.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;

public interface StatsService {
	
	public Map top5Actifs();

	public Map top5Classes();
	
	public Map top5Races();
	
	public Map top5Specialites();
}
