package analyser;

import java.util.Vector;
import java.util.Date;
public class Element
{
	Vector part;
	Vector tag;
	public Element(Vector part, Vector tag)
	{
		this.part = part;
		this.tag = tag;
	}

	public Vector getPart()
	{
		return part;
	}

	public Vector getTag()
	{
		return tag;
	}

	public int containsTag(String s)
	{
		if(tag.contains(s))
		{
			return tag.indexOf(s);
		}
		return -1;
	}

}
