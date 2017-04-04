package analyser;

import java.util.Stack;

public class VerbMisc
{
	static ByteMeth ByteMeth;
	static String x = "";

	public static boolean umpadi(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if(ByteMeth.endsWith(topElmt,Constant.umpadi))
		{
			//System.out.println(x + "umpadi");
			s.pop();
			s.push(new Entry(Constant.pati,Tag.ParticleSuffix));
			s.push(new Entry(Constant.um,Tag.ThirdFutureNeuterSingular_RP));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.umpadi.length);
			if(ByteMeth.isEqual(topElmt,Constant.kEtk))
				topElmt = ByteMeth.replace(topElmt,Constant.L,2);
			if(ByteMeth.isEqual(topElmt,Constant.var) ||
				ByteMeth.isEqual(topElmt,Constant.thar))
				topElmt = ByteMeth.addArray(topElmt,Constant.u);
			if(ByteMeth.isEqual(topElmt,Constant.kaRk) ||
				ByteMeth.isEqual(topElmt,Constant.viRk) ||
				ByteMeth.isEqual(topElmt,Constant.n_iRk))
				topElmt = ByteMeth.replace(topElmt,Constant.l,2);
			if(ByteMeth.isEqual(topElmt,Constant.sAk) ||
				ByteMeth.isEqual(topElmt,Constant.pOk))
				topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.check(s);
			Sandhi.kk(s);
			return true;
		}

		return false;
	}

	public static boolean pastTM_Al(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if(BooleanMethod.endsWith_PastTMHuman_Al(topElmt))
		{
			//System.out.println(x + "TM_Al");
			s.pop();
			s.push(new Entry(Constant.Al,Tag.Conditional));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Al.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));

			Tense.human(s);
			return true;
		}

		return false;
	}

	public static boolean imperativeSingular1(Stack s)
	{
		//System.out.println(x + "ISM 1 - ta,ti");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//tA
		if(ByteMeth.endsWith(topElmt,Constant.tA))
		{
			//System.out.println(x + "tA");
			s.pop();
			s.push(new Entry(Constant.tA,Tag.ImperativeSingular));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.tA.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//ti
		if(ByteMeth.endsWith(topElmt,Constant.ti))
		{
			//System.out.println(x + "ti");
			s.pop();
			s.push(new Entry(Constant.ti,Tag.ImperativeSingular));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ti.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//mmA
		if(ByteMeth.endsWith(topElmt,Constant.mmA))
		{
			//System.out.println(x + "mmA");
			s.pop();
			s.push(new Entry(Constant.mmA,Tag.ImperativeSingular));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.mmA.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//ppA
		if(ByteMeth.endsWith(topElmt,Constant.ppA))
		{
			//System.out.println(x + "ppA");
			s.pop();
			s.push(new Entry(Constant.ppA,Tag.ImperativeSingular));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ppA.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//yyA
		if(ByteMeth.endsWith(topElmt,Constant.yyA))
		{
			//System.out.println(x + "yyA");
			s.pop();
			s.push(new Entry(Constant.yyA,Tag.ImperativeSingular));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.yyA.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		return false;
	}

	public static boolean imperativeSingular2(Stack s)
	{
		//System.out.println(x + "ISM 2 - uta,uti");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//utA
		if(ByteMeth.endsWith(topElmt,Constant.utA))
		{
			//System.out.println(x + "utA");
			s.pop();
			s.push(new Entry(Constant.utA,Tag.ImperativeSingular));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.utA.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type5(s);
			return true;
		}
		//uti
		if(ByteMeth.endsWith(topElmt,Constant.uti))
		{
			//System.out.println(x + "uti");
			s.pop();
			s.push(new Entry(Constant.uti,Tag.ImperativeSingular));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.uti.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type5(s);
			return true;
		}
		//ummA
		if(ByteMeth.endsWith(topElmt,Constant.ummA))
		{
			//System.out.println(x + "ummA");
			s.pop();
			s.push(new Entry(Constant.ummA,Tag.ImperativeSingular));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ummA.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type5(s);
			return true;
		}
		//uppA
		if(ByteMeth.endsWith(topElmt,Constant.uppA))
		{
			//System.out.println(x + "uppA");
			s.pop();
			s.push(new Entry(Constant.uppA,Tag.ImperativeSingular));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.uppA.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type5(s);
			return true;
		}
		//uyyA
		if(ByteMeth.endsWith(topElmt,Constant.uyyA))
		{
			//System.out.println(x + "uyyA");
			s.pop();
			s.push(new Entry(Constant.uyyA,Tag.ImperativeSingular));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.uyyA.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type5(s);
			return true;
		}

		return false;
	}

	public static boolean imperativePlural1(Stack s)
	{
		//System.out.println(x + "IPM1");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//ungkaL
		if(ByteMeth.endsWith(topElmt,Constant.ungkaL))
		{
			//System.out.println(x + "ungkaL");
			s.pop();
			s.push(new Entry(Constant.ungkaL,Tag.ImperativePlural));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ungkaL.length);
			if(ByteMeth.isEqual(topElmt,Constant.vAr) ||
				ByteMeth.isEqual(topElmt,Constant.thAr))
				topElmt = ByteMeth.replace(topElmt,Constant.aru,2);
			if(ByteMeth.isEqual(topElmt,Constant.sAk))
				topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type5(s);
			return true;
		}
		return false;
	}

	public static boolean imperativePlural2(Stack s)
	{
		//System.out.println(x + "IPM2");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if(ByteMeth.endsWith(topElmt,Constant.ngkaL))
		{
			//System.out.println(x + "ngkaL");
			s.pop();
			s.push(new Entry(Constant.ngkaL,Tag.ImperativePlural));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ngkaL.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type5(s);
			return true;
		}
		return false;
	}

	public static boolean finiteVerb(Stack s)
	{
		//System.out.println(x + "Verb Sandhi - Finite Verb");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//kUtum
		if(ByteMeth.endsWith(topElmt,Constant.kUtum))
		{
			//System.out.println(x + "kUtum");
			s.pop();
			s.push(new Entry(Constant.kUtum,Tag.FiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kUtum.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//kUtAthu
		if(ByteMeth.endsWith(topElmt,Constant.kUtAthu))
		{
			//System.out.println(x + "kUtAthu");
			s.pop();
			s.push(new Entry(Constant.kUtAthu,Tag.FiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kUtAthu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//illai
		if(ByteMeth.endsWith(topElmt,Constant.illai))
		{
			//System.out.println(x + "illai");
			s.pop();
			s.push(new Entry(Constant.illai,Tag.FiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.illai.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			return true;
		}
		//vENtAm
		if(ByteMeth.endsWith(topElmt,Constant.vENtAm))
		{
			//System.out.println(x + "vENtAm");
			s.pop();
			s.push(new Entry(Constant.vENtAm,Tag.FiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vENtAm.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//mutiyAthu
		if(ByteMeth.endsWith(topElmt,Constant.mutiyAthu))
		{
			//System.out.println(x + "mutiyAthu");
			s.pop();
			s.push(new Entry(Constant.mutiyAthu,Tag.FiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.mutiyAthu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vitAthu
		if(ByteMeth.endsWith(topElmt,Constant.vitAthu))
		{
			//System.out.println(x + "vitAthu");
			s.pop();
			s.push(new Entry(Constant.vitAthu,Tag.FiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vitAthu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vENtum
		if(ByteMeth.endsWith(topElmt,Constant.vENtum))
		{
			//System.out.println(x + "vENtum");
			s.pop();
			s.push(new Entry(Constant.vENtum,Tag.FiniteVerbSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vENtum.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}

	public static boolean adverbial_Particle(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//kayil
		if(ByteMeth.endsWith(topElmt,Constant.kayil))
		{
			//System.out.println(x + "kayil");
			s.pop();
			s.push(new Entry(Constant.kayil,Tag.ParticleSuffix));//change
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kayil.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}

		return false;
	}

	public static boolean pronominal(Stack s)
	{
		//System.out.println(x + "Verb Misc Pronominal");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//van
		if(ByteMeth.endsWith(topElmt,Constant.van))
		{
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
			//System.out.println(x + "v + arkaL");
			s.pop();
			s.push(new Entry(Constant.arkaL,Tag.ProThirdPersonPlural));
			s.push(new Entry(Constant.v,Tag.Sandhi));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.varkaL.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		/*//athu
		if(ByteMeth.endsWith(topElmt,Constant.thu))
		{
			//System.out.println(x + "athu");
			s.pop();
			s.push(new Entry(Constant.thu,Tag.ProNeuterSingular));

			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}*/
		//vai
		if(ByteMeth.endsWith(topElmt,Constant.vai))
		{
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
}
//last 27_07_03 in _rules folder
