package com.challenge.finance;

public class LastTradeWithTime {
	private String content;

    private String b;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getB ()
    {
        return b;
    }

    public void setB (String b)
    {
        this.b = b;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", b = "+b+"]";
    }
}
