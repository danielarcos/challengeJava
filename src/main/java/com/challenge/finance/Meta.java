package com.challenge.finance;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="meta")
public class Meta {
	private String type;

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [type = "+type+"]";
    }
}
