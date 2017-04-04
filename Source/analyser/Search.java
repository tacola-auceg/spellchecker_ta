package analyser;

import java.io.BufferedReader;
import java.io.StreamTokenizer;
import java.io.InputStreamReader;

/**
 * program to search the dictionary for defective types of verb category
 */
public class Search
{
	public static boolean dicSearch(String word,String fileName)
	{
		BufferedReader dic = null;
		try
		{
			try
			{
				dic = new BufferedReader(new InputStreamReader(Search.class.getResourceAsStream(fileName)));
			}
			catch(Exception i)
			{
				System.err.println("Search Ex: " + i);
				//Utils.showErrorDialog(false,null,i);
				return false;
			}
			StreamTokenizer input = new StreamTokenizer(dic);
			int tokentype = 0;
			while((tokentype = input.nextToken()) != StreamTokenizer.TT_EOF)
			{
				if(tokentype == StreamTokenizer.TT_WORD)
				{
					if(input.sval.equals(word))
						return true;
				}
			}
		}
		catch(Exception i)
		{
			System.err.println("Search Ex: " + i);
			//Utils.showErrorDialog(false,null,i);
			return false;
		}
		return false;
	}
}
