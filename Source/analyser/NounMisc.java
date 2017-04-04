package analyser;

import java.util.Stack;

public class NounMisc
{
	static ByteMeth ByteMeth;
	static String x = "";

	public static boolean adjective(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//System.out.println(x + "Adjective");
		//Ana
		if(ByteMeth.endsWith(topElmt,Constant.Ana))
		{
			//System.out.println(x + "Ana");
			s.pop();
			s.push(new Entry(Constant.Ana,Tag.AdjectivalSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Ana.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		//iya
		if(ByteMeth.endsWith(topElmt,Constant.iya) &&
			!ByteMeth.endsWith(topElmt,Constant.ottiya))
		{
			//System.out.println(x + "iya");
			s.pop();
			s.push(new Entry(Constant.iya,Tag.AdjectivalSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.iya.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		//uLLa
		if(ByteMeth.endsWith(topElmt,Constant.uLLa))
		{
			//System.out.println(x + "uLLa");
			s.pop();
			s.push(new Entry(Constant.uLLa,Tag.AdjectivalSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.uLLa.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		//aRRa
		if(ByteMeth.endsWith(topElmt,Constant.aRRa))
		{
			//System.out.println(x + "aRRa");
			s.pop();
			s.push(new Entry(Constant.aRRa,Tag.AdjectivalSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.aRRa.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}
		return false;
	}

	public static boolean angu_ingu_engu(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//System.out.println(x + "AIE - angku, ingku, engku");
		//angku
		if(ByteMeth.isEqual(topElmt,Constant.angku))
		{
			//System.out.println(x + "angku");
			s.pop();
			s.push(new Entry(Constant.angku,Tag.Adverb));
			return true;
		}

		//ingku
		if(ByteMeth.isEqual(topElmt,Constant.ingku))
		{
			//System.out.println(x + "ingku");
			s.pop();
			s.push(new Entry(Constant.ingku,Tag.Adverb));
			return true;
		}

		//engku
		if(ByteMeth.isEqual(topElmt,Constant.engku))
		{
			//System.out.println(x + "engku");
			s.pop();
			s.push(new Entry(Constant.engku,Tag.InterrogativeNoun));
			return true;
		}

		return false;
	}

	public static boolean adverb(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//System.out.println(x + "Adverb");
		//aRRu
		if(ByteMeth.endsWith(topElmt,Constant.aRRu))
		{
			//System.out.println(x + "aRRu");
			s.pop();
			s.push(new Entry(Constant.aRRu,Tag.AdverbialSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.aRRu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		//Aka
		if(ByteMeth.endsWith(topElmt,Constant.Aka) &&
			!ByteMeth.endsWith(topElmt,Constant.viLaivAka) &&
			!ByteMeth.endsWith(topElmt,Constant.sArbAka))
		{
			//System.out.println(x + "Aka");
			s.pop();
			s.push(new Entry(Constant.Aka,Tag.AdverbialSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Aka.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		//Ay
		if(ByteMeth.endsWith(topElmt,Constant.Ay))
		{
			//System.out.println(x + "Ay");
			s.pop();
			s.push(new Entry(Constant.Ay,Tag.AdverbialSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Ay.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}
		return false;
	}

	public static boolean pronominal(Stack s)
	{
		//System.out.println(x + "Noun Misc Pronominal");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//van
		if(ByteMeth.endsWith(topElmt,Constant.van))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.van.length);
			if(!BooleanMethod.endsWith_Adjective(topElmt1))
				return false;

			//System.out.println(x + "v + an");
			s.pop();
			s.push(new Entry(Constant.an,Tag.ProThirdPersonMasSingular));
			s.push(new Entry(Constant.v,Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.van.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vaL
		if(ByteMeth.endsWith(topElmt,Constant.vaL))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vaL.length);
			if(!BooleanMethod.endsWith_Adjective(topElmt1))
				return false;
			//System.out.println(x + "v + aL");
			s.pop();
			s.push(new Entry(Constant.aL,Tag.ProThirdPersonFemSingular));
			s.push(new Entry(Constant.v,Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vaL.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//var
		if(ByteMeth.endsWith(topElmt,Constant.var))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.var.length);
			if(!BooleanMethod.endsWith_Adjective(topElmt1))
				return false;
			//System.out.println(x + "v + ar");
			s.pop();
			s.push(new Entry(Constant.ar,Tag.ProThirdPersonMasFemSingular));
			s.push(new Entry(Constant.v,Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.var.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//varkaL
		if(ByteMeth.endsWith(topElmt,Constant.varkaL))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.varkaL.length);
			if(!BooleanMethod.endsWith_Adjective(topElmt1))
				return false;
			//System.out.println(x + "v + arkaL");
			s.pop();
			s.push(new Entry(Constant.arkaL,Tag.ProThirdPersonPlural));
			s.push(new Entry(Constant.v,Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.varkaL.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//athu
		if(ByteMeth.endsWith(topElmt,Constant.thu))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thu.length);
			if(!BooleanMethod.endsWith_Adjective(topElmt1))
				return false;
			//System.out.println(x + "athu");
			s.pop();
			s.push(new Entry(Constant.thu,Tag.ProNeuterSingular));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vai
		if(ByteMeth.endsWith(topElmt,Constant.vai))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vai.length);
			if(!BooleanMethod.endsWith_Adjective(topElmt1))
				return false;
			//System.out.println(x + "v + ai");
			s.pop();
			s.push(new Entry(Constant.ai,Tag.ProNeuterPlural));
			s.push(new Entry(Constant.v,Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vai.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vaikaL
		if(ByteMeth.endsWith(topElmt,Constant.vaikaL))
		{
			byte[] topElmt1 = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vaikaL.length);
			if(!BooleanMethod.endsWith_Adjective(topElmt1))
				return false;
			//System.out.println(x + "v + aikaL");
			s.pop();
			s.push(new Entry(Constant.aikaL,Tag.ProNeuterPlural));
			s.push(new Entry(Constant.v,Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vaikaL.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		return false;
	}

	public static boolean finiteVerb(Stack s)
	{
		//System.out.println(x + "Finite Verb");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//AyiRRu
		if(ByteMeth.endsWith(topElmt,Constant.AyiRRu))
		{
			//System.out.println(x + "AyiRRu");
			s.pop();
			s.push(new Entry(Constant.AyiRRu,Tag.FiniteVerbSuffix));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.AyiRRu.length);

			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		//irukkattum
		if(ByteMeth.endsWith(topElmt,Constant.irukkattum))
		{
			//System.out.println(x + "irukkattum");
			s.pop();
			s.push(new Entry(Constant.irukkattum,Tag.FiniteVerbSuffix));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.irukkattum.length);

			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		//uNtu
		if(ByteMeth.endsWith(topElmt,Constant.uNtu))
		{
			//System.out.println(x + "uNtu");
			s.pop();
			s.push(new Entry(Constant.uNtu,Tag.FiniteVerbSuffix));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.uNtu.length);

			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		//uLLathu
		if(ByteMeth.endsWith(topElmt,Constant.uLLathu))
		{
			//System.out.println(x + "uLLathu");
			s.pop();
			s.push(new Entry(Constant.uLLathu,Tag.FiniteVerbSuffix));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.uLLathu.length);

			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		//AkAthu
		if(ByteMeth.endsWith(topElmt,Constant.AkAthu))
		{
			//System.out.println(x + "AkAthu");
			s.pop();
			s.push(new Entry(Constant.AkAthu,Tag.NegFiniteVerbSuffix));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.AkAthu.length);

			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		//iLLai
		if(ByteMeth.endsWith(topElmt,Constant.iLLai))
		{
			//System.out.println(x + "iLLai");
			s.pop();
			s.push(new Entry(Constant.iLLai,Tag.NegFiniteVerbSuffix));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.iLLai.length);

			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}
		return false;
	}
}
