package com.challenge.finance;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="list")
public class List {
	private Resources resources;

    private Meta meta;

    private String version;

    public Resources getResources ()
    {
        return resources;
    }

    public void setResources (Resources resources)
    {
        this.resources = resources;
    }

    public Meta getMeta ()
    {
        return meta;
    }

    public void setMeta (Meta meta)
    {
        this.meta = meta;
    }

    public String getVersion ()
    {
        return version;
    }

    @XmlAttribute
    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [resources = "+resources+", meta = "+meta+", version = "+version+"]";
    }
}
