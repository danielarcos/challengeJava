package com.challenge.finance;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="resources")
public class Resources {
	
	private String count;

    private String start;

    
    private Resource resource;

    public String getCount ()
    {
        return count;
    }

    @XmlAttribute
    public void setCount (String count)
    {
        this.count = count;
    }

    public String getStart ()
    {
        return start;
    }

    @XmlAttribute
    public void setStart (String start)
    {
        this.start = start;
    }

    public Resource getResource ()
    {
        return resource;
    }

    public void setResource (Resource resource)
    {
        this.resource = resource;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [count = "+count+", start = "+start+", resource = "+resource+"]";
    }
}
