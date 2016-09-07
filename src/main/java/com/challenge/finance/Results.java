package com.challenge.finance;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="results")
public class Results {
	private Quote quote;

    public Quote getQuote ()
    {
        return quote;
    }

    public void setQuote (Quote quote)
    {
        this.quote = quote;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [quote = "+quote+"]";
    }
}
