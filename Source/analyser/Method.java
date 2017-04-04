package analyser;

import java.util.*;

public class Method
{
	static String x = "";
	static String y = "";
	static TabConverter TC;
	static ADictionary dictionary;
	static Stack originalStack;
	static Stack originalStack1;

	public static int analyse(String inputString, Stack allStk)
	{
try
{
		//System.out.println(x + "Word: " + inputString);
		//later
		//inputString = Sandhi.kctp_expception(inputString);

		int c = 0;

		//root word
		boolean isRoot = ADictionary.check(allStk,inputString);
		c = 17;

		//noun analysis
		c += Noun.check(allStk,inputString, isRoot);

		//verb analysis
		Verb.check(allStk,inputString);

		/*int size = allStk.size();

		if(size == 0)
		{
			Stack s = new Stack();
			s.push(new Entry(TabConverter.convert(inputString),Tag.Unknown));
			allStk.push(s);
		}
		*/
		return c;
}catch(Exception ex)
{
	String xxx = "";
	System.out.println(xxx + "Error while analysing input string: " + inputString);
	ex.printStackTrace();
	return 0;
}

	}
}


/*
to copy:
Utils.printStack(s,"b4 n:",demo.AnalyserPane.st);
*/
