/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import ch.ubique.inieditor.IniEditor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author TP32447
 */
public class Global {
    private static Global ref;
	private ArrayList arrprops;
	private IniEditor props = null;
	private String conf;

	private Global()
	{
		arrprops = new ArrayList();
		LoadProperties();
	}

	private void LoadProperties()
	{
	    props = new IniEditor();
	    
	    conf = System.getProperty("bii.configuration");
	    
	    if (conf==null)
	    	conf = "./config/config.properties";
	    try {
		    props.load(conf);
		} catch(IOException ex)	{
			return;
		}
		
		List l = props.sectionNames();
        Iterator it = l.iterator();
        while (it.hasNext()) {
            String line = (String) it.next();
            Section sec = new Section();
            List l2 = props.optionNames(line);
            Iterator it2 = l2.iterator();
            sec.setName(line);
            while (it2.hasNext()) {
            	String val  = (String) it2.next();
            	String val2 = props.get(line, val);
            	sec.addItem(val, val2);
            	arrprops.add(sec);
            }
        }
		
	}

	public Section getSections(String SectionName)
	{
		Section r = null;
        Iterator it = arrprops.iterator();
        while (it.hasNext()) {
        	Section sec = (Section)it.next();
        	if (sec.getName().equalsIgnoreCase(SectionName))
        	{
        		r = sec;
        		break;
        	}
        }
        return r;
	}

	public String getPropValue(String SectionName,String PropValue)
	{
		String r = null;
        Iterator it = arrprops.iterator();
        while (it.hasNext()) {
        	Section sec = (Section)it.next();
        	if (sec.getName().equalsIgnoreCase(SectionName))
        	{
        		r = sec.getItem(PropValue);
        		break;
        	}
        }
        return r;
	}

	public void setPropValue(String HeadName, String SectionName,String PropValue)
	{
		props.set(HeadName, SectionName, PropValue);
		try {
			props.save(conf);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
    public static synchronized Global getGlobalProp()
    {
	      if (ref == null)
	          ref = new Global();
	      return ref;
    }

	@Override
	public Object clone() throws CloneNotSupportedException
	{
	    throw new CloneNotSupportedException(); 
	}
}
