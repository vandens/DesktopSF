/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author TP32447
 */
public class Section {
    
	private String name;
	private ArrayList items;
	
	public Section()
	{
		items = new ArrayList();
	}
	
	public void setName(String newVal) {
		this.name = newVal;
	}

	public String getName() {
		return this.name;
	}

	public void addItem(String name,String value) {
		String s[] = new String[2];
		s[0]=name;
		s[1]=value;
		items.add(s);
	}

	public String getItem(String name) {
		String r="";
        Iterator it = items.iterator();
        while (it.hasNext()) {
        	String s[] = (String[])it.next();
        	if (s[0].equalsIgnoreCase(name))
        	{
        		r=s[1];
        		break;
        	}
        }
        return r;
	}
}

