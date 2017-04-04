package analyser;

import java.util.Stack;
import java.util.Vector;

public class Misc
{
	static void backTrack(Stack o, Stack s)
	{
		while(!s.empty()) s.pop();
		for(int i=0; i < o.size(); i++)
		{
			s.push((Entry)o.get(i));
		}
	}

	public static void reverse(byte[] n)
	{
		for(int k=0; k<n.length/2;k++)
		{
			byte t = n[k];
			n[k] = n[n.length-k-1];
			n[n.length-k-1] = t;
		}
	}
}
