package analyser;

import java.util.Stack;

public class Infinity
{
	static String x = "";
	static ByteMeth ByteMeth;
	static TabConverter TC;

	public static boolean kka_ka(Stack s)
	{
		//System.out.println(x + "Infinitive kka ka");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//kka
		if(ByteMeth.endsWith(topElmt,Constant.kka))
		{
			//System.out.println(x + "kka");
			s.pop();
			s.push(new Entry(Constant.kka,Tag.Infinitive));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kka.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//ka
		if(ByteMeth.endsWith(topElmt,Constant.ka))
		{
			//System.out.println(x + "ka");
			s.pop();
			s.push(new Entry(Constant.ka,Tag.Infinitive));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ka.length);
			if(ByteMeth.isEqual(topElmt,Constant.kEt))
				topElmt = ByteMeth.replace(topElmt,Constant.L,1);
			if(ByteMeth.isEqual(topElmt,Constant.kaR))
				topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}

	public static boolean a(Stack s)
	{
		//System.out.println(x + "Inf a");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		//a
		if(ByteMeth.endsWith(topElmt,Constant.a))
		{
			//System.out.println(x + "a");
			s.pop();
			s.push(new Entry(Constant.a,Tag.Infinitive));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.a.length);
			if(ByteMeth.isEqual(topElmt,Constant.var) ||
				ByteMeth.isEqual(topElmt,Constant.thar))
			{
				//System.out.println(x + "var,thar - va,tha");
				topElmt = ByteMeth.addArray(topElmt,Constant.u);
			}

			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}


	public static boolean infinitive_Ends(Stack s)
	{
		//System.out.println(x + "Inf End");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//AvittAl
		if(ByteMeth.endsWith(topElmt,Constant.AvittAl))
		{
			//System.out.println(x + "AvittAl");
			s.pop();
			s.push(new Entry(Constant.AvittAl,Tag.NegCondSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.AvittAl.length);
			topElmt = ByteMeth.addArray(topElmt,Constant.a);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//AvittAlum
		if(ByteMeth.endsWith(topElmt,Constant.AvittAlum))
		{
			//System.out.println(x + "AvittAlum");
			s.pop();
			s.push(new Entry(Constant.um,Tag.ConcessiveSuffix));
			s.push(new Entry(Constant.AvittAlum,Tag.NegCondSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.AvittAlum.length);
			topElmt = ByteMeth.addArray(topElmt,Constant.a);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//Amal
		if(ByteMeth.endsWith(topElmt,Constant.Amal))
		{
			//System.out.println(x + "Amal");
			s.pop();
			s.push(new Entry(Constant.Amal,Tag.NegCondSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Amal.length);
			topElmt = ByteMeth.addArray(topElmt,Constant.a);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//Amalum
		if(ByteMeth.endsWith(topElmt,Constant.Amalum))
		{
			//System.out.println(x + "Amalum");
			s.pop();
			s.push(new Entry(Constant.um,Tag.ConcessiveSuffix));
			s.push(new Entry(Constant.Amal,Tag.NegCondSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Amalum.length);
			topElmt = ByteMeth.addArray(topElmt,Constant.a);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//lAm
		if(ByteMeth.endsWith(topElmt,Constant.lAm))
		{
			//System.out.println(x + "lAm");
			s.pop();
			s.push(new Entry(Constant.lAm,Tag.PermSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.lAm.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//ttum
		if(ByteMeth.endsWith(topElmt,Constant.ttum))
		{
			//System.out.println(x + "ttum");
			s.pop();
			s.push(new Entry(Constant.ttum,Tag.PermSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ttum.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vittAl
		if(ByteMeth.endsWith(topElmt,Constant.vittAl))
		{
			//System.out.println(x + "vittAl");
			s.pop();
			s.push(new Entry(Constant.vittAl,Tag.Conditional));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vittAl.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//AthE
		if(ByteMeth.endsWith(topElmt,Constant.AthE))
		{
			//System.out.println(x + "AthE");
			s.pop();
			s.push(new Entry(Constant.E,Tag.SecondPersonSingular));
			s.push(new Entry(Constant.Ath,Tag.ImpNeg_Prohibitive));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.AthE.length);
			topElmt = ByteMeth.addArray(topElmt,Constant.a);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//AthIrkaL
		if(ByteMeth.endsWith(topElmt,Constant.AthIrkaL))
		{
			//System.out.println(x + "AthIrkaL");
			s.pop();
			s.push(new Entry(Constant.IrkaL,Tag.SecondPersonPlural));
			s.push(new Entry(Constant.Ath,Tag.ImpNeg_Prohibitive));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.AthIrkaL.length);
			topElmt = ByteMeth.addArray(topElmt,Constant.a);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//Athu
		if(ByteMeth.endsWith(topElmt,Constant.Athu))
		{
			//System.out.println(x + "Athu");
			s.pop();
			s.push(new Entry(Constant.Athu,Tag.FutureNeg));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Athu.length);
			topElmt = ByteMeth.addArray(topElmt,Constant.a);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//Avitil
		if(ByteMeth.endsWith(topElmt,Constant.Avitil))
		{
			//System.out.println(x + "Avitil");
			s.pop();
			s.push(new Entry(Constant.Avitil,Tag.NegVP));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Avitil.length);
			topElmt = ByteMeth.addArray(topElmt,Constant.a);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vENtumAnAl
		if(ByteMeth.endsWith(topElmt,Constant.vENtumAnAl))
		{
			//System.out.println(x + "vENtumAnAl");
			s.pop();
			s.push(new Entry(Constant.AnAl,Tag.ConjSuffix));
			s.push(new Entry(Constant.vENtum,Tag.Verb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vENtumAnAl.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vENtumena
		if(ByteMeth.endsWith(topElmt,Constant.vENtumena))
		{
			//System.out.println(x + "vENtumena");
			s.pop();
			s.push(new Entry(Constant.ena,Tag.ParticleSuffix));
			s.push(new Entry(Constant.vENtum,Tag.Verb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vENtumena.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vENtumenRu
		if(ByteMeth.endsWith(topElmt,Constant.vENtumenRu))
		{
			//System.out.println(x + "vENtumenRu");
			s.pop();
			s.push(new Entry(Constant.enRu,Tag.ParticleSuffix));
			s.push(new Entry(Constant.vENtum,Tag.Verb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vENtumenRu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}

	public static boolean mAtt(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//mAtt
		if(ByteMeth.endsWith(topElmt,Constant.mAtt))
		{
			//System.out.println(x + "mAtt");
			s.pop();
			s.push(new Entry(Constant.mAtt,Tag.FutureNeg));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.mAtt.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}

	public static boolean check(Stack s)
	{
		Stack originalStack = (Stack)s.clone();
		if(Infinity.kka_ka(s))
		{
			byte[] topElmt = ((Entry)s.peek()).getPart();
			byte[] oldTopElmt = topElmt;
			if(ADictionary.Verb_BTree.endsWith(topElmt,true) != null)
			{
				return true;
			}
		}
		Misc.backTrack(originalStack,s);
		if(Infinity.a(s))
		{
			originalStack = (Stack)s.clone();
			if(Sandhi.type5(s));
			else if(Sandhi.type2(s));
			byte[] topElmt = ((Entry)s.peek()).getPart();
			byte[] oldTopElmt = topElmt;
			if(ADictionary.Verb_BTree.endsWith(topElmt,true) != null)
			{
				return true;
			}
			else
			{
				Misc.backTrack(originalStack,s);
				if(Sandhi.type4(s))
				{
					topElmt = ((Entry)s.peek()).getPart();
					if(ADictionary.Verb_BTree.endsWith(topElmt,true) != null)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}
