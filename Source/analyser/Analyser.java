package analyser;

import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Vector;
import java.util.Date;
import java.util.ResourceBundle;

public class Analyser
{
	public static ResourceBundle Tags = ResourceBundle.getBundle("analyser/Tag/English_Expanded");

	public static String analyseF(String input)
	{
		String output = input + ":";
try
{
		Stack allStk = new Stack();

		//for dic ref count
		//output += "- " + Method.analyse(input,allStk);

		Method.analyse(input,allStk);
		int size = allStk.size();
		if(size == 0)
		{
			output += " Unknown";
			return output;
		}
		for(int i=0;i<size;i++)
		{
			Stack outputStack = (Stack)allStk.get(i);
			while (!outputStack.empty())
			{
				Entry entry = (Entry)outputStack.pop();
				String s = TabConverter.revert(entry.getPart());
				output += Utils.newLineStr;
				output += s;
				int tag = entry.getTag();
				if(tag != -1)
				{
					s = " < ";
					s += Tags.getString(String.valueOf(tag));
					s += " > ";
				}
				else
					s = "";
				output += s;
			}
			if(allStk.size() != 1)
				output += Utils.newLineStr + "***";
		}
}catch(Exception e)
{
	System.err.println("Analyser analyseF: " + e);
	e.printStackTrace();
	return input;
}
	return output;
	}

	public static String analyseW(String input)
	{
		String output = input + ":";
try
{
		Stack allStk = new Stack();

		//for dic ref count
		//output += "- " + Method.analyse(input,allStk);

		Method.analyse(input,allStk);
		int size = allStk.size();
		if(size == 0)
		{
			output += " Unknown";
			return output;
		}
		for(int i=0;i<size;i++)
		{
			Stack outputStack = (Stack)allStk.get(i);
			while (!outputStack.empty())
			{
				Entry entry = (Entry)outputStack.pop();
				String s = TabConverter.revert(entry.getPart());
				output += Utils.newLineStr_OS;
				output += s;
				int tag = entry.getTag();
				if(tag != -1)
				{
					s = " < ";
					s += Tags.getString(String.valueOf(tag));
					s += " > ";
				}
				else
					s = "";
				output += s;
			}
			if(allStk.size() != 1)
				output += Utils.newLineStr_OS + "***";
		}
}catch(Exception e)
{
	System.err.println("Analyser analyseW: " + e);
	e.printStackTrace();
	return input;
}
	return output;
	}

	public static Vector analyse(String input)
	{
		Vector output = new Vector();
try
{
		Stack allStk = new Stack();
		Method.analyse(input,allStk);
		for(int i=0;i<allStk.size();i++)
		{
			Stack outputStack = (Stack)allStk.get(i);
			Vector part = new Vector();
			Vector tag = new Vector();
			while (!outputStack.empty())
			{
				Entry entry = (Entry)outputStack.pop();
				String s = TabConverter.revert(entry.getPart());
				part.add(s);
				int tagInt = entry.getTag();
				if(tagInt != -1)
				{
					s = String.valueOf(tagInt);
				}
				else
					s = "";
				tag.add(s);
			}
			output.add(new Element(part,tag));
		}
}catch(Exception e)
{
	System.err.println("Analyser analyse: " + e);
	e.printStackTrace();
	return null;
}
	return output;
	}

	public static void init()
	{
		analyse(TabConverter.revert(Constant.vel));
	}

	public static void main(String args[])
	{
		Vector v = analyse("ªê£ô¢½ñ¢");//soLLum
		System.out.println("isAnalysed: " + isAnalysed(v));
		System.out.println("root: " + getRoot(v));
		System.out.println("isNoun: " + isNoun(v));
		System.out.println("isVerb: " + isVerb(v));

	}

	//for procesing analyser output------------------
	static Set d = new HashSet();
	static String y = "";

	static
	{
		d.add(String.valueOf(Tag.Noun));
		d.add(String.valueOf(Tag.Pronoun));
		d.add(String.valueOf(Tag.InterrogativeNoun));
		d.add(String.valueOf(Tag.ObliquePronoun));
		d.add(String.valueOf(Tag.Verb));
		d.add(String.valueOf(Tag.FiniteVerb));
		d.add(String.valueOf(Tag.NegFiniteVerb));
		d.add(String.valueOf(Tag.Adjective));
		d.add(String.valueOf(Tag.DemonstrativeAdjective));
		d.add(String.valueOf(Tag.InterrogativeAdj));
		d.add(String.valueOf(Tag.Adverb));
		d.add(String.valueOf(Tag.Interjection));
		d.add(String.valueOf(Tag.Conjunction));
		d.add(String.valueOf(Tag.Particle));
		d.add(String.valueOf(Tag.Intensifier));
		d.add(String.valueOf(Tag.Postposition));
	}

	public static boolean isNoun(Vector v)
	{
		for(int i=0; i<v.size(); i++)
		{
			Element elmt = (Element)v.get(i);
			Vector tag = elmt.getTag();
			int index = elmt.containsTag(String.valueOf(Tag.Noun));
			if(index != -1)
			{
				return true;
			}
		}
		return false;
	}

	public static boolean isNoun(String word)
	{
		return isNoun(analyse(word));
	}

	public static boolean isVerb(Vector v)
	{
		for(int i=0; i<v.size(); i++)
		{
			Element elmt = (Element)v.get(i);
			Vector tag = elmt.getTag();
			int index = elmt.containsTag(String.valueOf(Tag.Verb));
			if(index != -1)
			{
				return true;
			}
		}
		return false;
	}

	public static boolean isVerb(String word)
	{
		return isVerb(analyse(word));
	}

	public static String getRoot(Vector v)
	{
		for(int i=0; i<v.size(); i++)
		{
			Element elmt = (Element) v.get(i);
			Vector partV = elmt.getPart();
			String tag = null;

			if(partV.size() > 0)
			{
				return (String)partV.get(0);
			}
		}
		return null;
	}

	public static String getRoot(String word)
	{
		return getRoot(analyse(word));
	}

	public static boolean isAnalysed(Vector v)
	{
		if(v.size() > 0)
			return true;
		return false;
	}

	public static boolean isAnalysed(String input)
	{
		Vector v = analyse(input);
		if(v.size() > 0)
			return true;
		return false;
	}
}
//changes to be done while giving for others
/*
Remove:
1) tagger_a
2) TamilSearch - Dic Search
*/
