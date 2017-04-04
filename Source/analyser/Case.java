package analyser;

import java.util.Stack;

public class Case
{
	static ByteMeth ByteMeth;
	static String x = "";

	public static boolean check(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//System.out.println(x + "Case");
		//Al
		if(ByteMeth.endsWith(topElmt,Constant.Al))
		{
			//System.out.println(x + "Al");
			s.pop();
			s.push(new Entry(Constant.Al,Tag.InsCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Al.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//il
		if(ByteMeth.endsWith(topElmt,Constant.il))
		{
			//System.out.println(x + "il");
			s.pop();
			s.push(new Entry(Constant.il,Tag.LocCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.il.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//kaN
		if(ByteMeth.endsWith(topElmt,Constant.kaN))
		{
			//System.out.println(x + "kaN");
			s.pop();
			s.push(new Entry(Constant.kaN,Tag.LocCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kaN.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//itam
		if(ByteMeth.endsWith(topElmt,Constant.itam))
		{
			//System.out.println(x + "itam");
			s.pop();
			s.push(new Entry(Constant.itam,Tag.LocCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.itam.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//in
		if(ByteMeth.endsWith(topElmt,Constant.in))
		{
			//System.out.println(x + "in");
			s.pop();
			s.push(new Entry(Constant.in,Tag.GenCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.in.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//athu
		if(ByteMeth.endsWith(topElmt,Constant.athu) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.Ana,Constant.thu)) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.iya,Constant.thu)) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.uLLa,Constant.thu)) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.aRRa,Constant.thu)))
		{
			//System.out.println(x + "athu");
			s.pop();
			s.push(new Entry(Constant.athu,Tag.GenCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.athu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//utaiya
		if(ByteMeth.endsWith(topElmt,Constant.utaiya))
		{
			//System.out.println(x + "utaiya");
			s.pop();
			s.push(new Entry(Constant.utaiya,Tag.GenCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.utaiya.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//iRku
		if(ByteMeth.endsWith(topElmt,Constant.iRku))
		{
			//System.out.println(x + "iRku");
			s.pop();
			s.push(new Entry(Constant.ku,Tag.DatCase));
			s.push(new Entry(Constant.in,Tag.Euphonic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.iRku.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//aRku
		if(ByteMeth.endsWith(topElmt,Constant.aRku))
		{
			//System.out.println(x + "aRku");
			s.pop();
			s.push(new Entry(Constant.ku,Tag.DatCase));
			s.push(new Entry(Constant.an,Tag.Euphonic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.aRku.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//akku
		if(ByteMeth.endsWith(topElmt,Constant.akku))
		{
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.akku.length);
			if(BooleanMethod.is_akku_Pronoun(topElmt))
			{
				//System.out.println(x + "akku");
				s.pop();
				s.push(new Entry(Constant.akku,Tag.DatCase));
				s.push(new Entry(topElmt,-1,oldTopElmt));
				return true;
			}
		}

		//ukku
		if(ByteMeth.endsWith(topElmt,Constant.ukku))
		{
			//System.out.println(x + "ukku");
			s.pop();
			s.push(new Entry(Constant.ukku,Tag.DatCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ukku.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//kku
		if(ByteMeth.endsWith(topElmt,Constant.kku))
		{
			//System.out.println(x + "kku");
			s.pop();
			s.push(new Entry(Constant.kku,Tag.DatCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kku.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//ai
		if(ByteMeth.endsWith(topElmt,Constant.ai) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.Ana,Constant.vai)) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.iya,Constant.vai)) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.uLLa,Constant.vai)) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.aRRa,Constant.vai)))
		{
			//System.out.println(x + "ai");
			s.pop();
			s.push(new Entry(Constant.ai,Tag.AccCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ai.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//utan
		if(ByteMeth.endsWith(topElmt,Constant.utan))
		{
			//System.out.println(x + "utan");
			s.pop();
			s.push(new Entry(Constant.utan,Tag.AssoCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.utan.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}

		//Otu
		if(ByteMeth.endsWith(topElmt,Constant.Otu))
		{
			//System.out.println(x + "Otu");
			s.pop();
			s.push(new Entry(Constant.Otu,Tag.AssoCase));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Otu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			return true;
		}
		return false;
	}
}
