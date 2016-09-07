package com.challenge.finance;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="field")
public class Field {
	private String content;

    private String name;

    public String getContent ()
    {
        return content;
    }

    @XmlValue
    public void setContent (String content)
    {
        this.content = content;
    }

    public String getName ()
    {
        return name;
    }

    @XmlAttribute
    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", name = "+name+"]";
    }
}
