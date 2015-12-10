package fr.synapsegaming.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortMap implements Comparator {
    Map map;

    public SortMap(Map map) {
        this.map = map;
    }

	@Override
	public int compare(Object a, Object b) {
		if ((Integer)map.get(a) >= (Integer)map.get(b)) {
            return -1;
        } else {
            return 1;
        } 
	}
	
	public TreeMap sortAndResize(int taille){
		TreeMap sort = new TreeMap(this);
		sort.putAll(map);
		while(sort.size()>taille){
			sort.pollLastEntry();
		}
		
		return sort;
	}
	 
}
