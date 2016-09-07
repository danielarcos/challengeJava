package com.challenge.finance;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="resource")
public class Resource {
	private Field[] field;

    private String classname;

    public Field[] getField ()
    {
        return field;
    }
    
    public void setField (Field[] field)
    {
        this.field = field;
    }

    public String getClassname ()
    {
        return classname;
    }

    @XmlAttribute
    public void setClassname (String classname)
    {
        this.classname = classname;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [field = "+field+", classname = "+classname+"]";
    }
}
