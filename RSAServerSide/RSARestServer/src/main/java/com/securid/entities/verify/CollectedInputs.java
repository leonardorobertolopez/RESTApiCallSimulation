package com.securid.entities.verify;

public class CollectedInputs {
	    private String name;
	    private String value;
	    private String dataType;

	    public String getDataType ()
	    {
	        return dataType;
	    }

	    public void setDataType (String dataType)
	    {
	        this.dataType = dataType;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public String getValue ()
	    {
	        return value;
	    }

	    public void setValue (String value)
	    {
	        this.value = value;
	    }

	  public CollectedInputs() {
		// TODO Auto-generated constructor stub
	}

	public CollectedInputs(String name, String value, String dataType) {
		super();
		this.name = name;
		this.value = value;
		this.dataType = dataType;
	}

	@Override
	public String toString() {
		return "CollectedInputs [name=" + name + ", value=" + value + ", dataType=" + dataType + "]";
	}
	  
	  
	  
	  
}
