package com.challenge.finance;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="query")
public class Query {
	private Results results;

    public Results getResults ()
    {
        return results;
    }

    public void setResults (Results results)
    {
        this.results = results;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+"]";
    }
}
