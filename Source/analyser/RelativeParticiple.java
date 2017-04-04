package analyser;

import java.util.*;

public class RelativeParticiple
{
	static String x = "";

	public static boolean check(Stack s)
	{
		//System.out.println(x + "RP");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//Atha
		if(ByteMeth.endsWith(topElmt,Constant.Atha))
		{
			//System.out.println(x + "Atha");
			s.pop();
			s.push(new Entry(Constant.a,Tag.RPSuffix));
			s.push(new Entry(Constant.Athu,Tag.FutureNeg));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Atha.length);
			topElmt = ByteMeth.addArray(topElmt,Constant.a);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			//Sandhi.kk(s);
			return true;
		}
		//a
		if(ByteMeth.endsWith(topElmt,Constant.a) &&
			!ByteMeth.endsWith(topElmt,Constant.ana))
		{
			//System.out.println(x + "a");
			s.pop();
			s.push(new Entry(Constant.a,Tag.RPSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.a.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		return false;
	}
}
