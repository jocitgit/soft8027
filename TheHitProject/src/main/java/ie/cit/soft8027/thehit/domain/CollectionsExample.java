package ie.cit.soft8027.thehit.domain;

import java.util.*;

public class CollectionsExample {

	private List <String> instrumentList;
	private Set<String>  instrumentSet;
	private Map<Integer, String>  instrumentMap;
	private Properties instrumentProp;
	
	private String msg;


	public List<String> getInstrumentList() {
		System.out.println("List Elements :"  + instrumentList);
		return instrumentList;
	}

	public void setInstrumentList(List<String> instrumentList) {
		this.instrumentList = instrumentList;
	}

	public Set<String> getInstrumentSet() {
		System.out.println("Set Elements :"  + instrumentSet);
		return instrumentSet;
	}

	public void setInstrumentSet(Set<String> instrumentSet) {
		// sysout not performed when bean uses setters to set properties. Suppressed?
		msg = " Set passed in is: " + instrumentSet;
		// duplicate set values are not passed in to this method
		this.instrumentSet = instrumentSet;
		msg += ". The instrument set is now: " + this.instrumentSet;
	}
	

	public Map<Integer, String> getInstrumentMap() {
		System.out.println("Map Elements :"  + instrumentMap);
		return instrumentMap;
	}

	public void setInstrumentMap(Map<Integer, String> instrumentMap) {
		this.instrumentMap = instrumentMap;
	}

	public Properties getInstrumentProp() {
		System.out.println("Prop Elements :"  + instrumentProp);
		return instrumentProp;
	}

	public void setInstrumentProp(Properties instrumentProp) {
		this.instrumentProp = instrumentProp;
	}	
	
	
	public String getMsg() {
		System.out.println("Msg: " + msg);
		return msg;
	}
}
