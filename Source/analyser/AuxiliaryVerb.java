package analyser;

import java.util.*;

public class AuxiliaryVerb
{
	static String x = "";

	public static boolean infinitive(Stack s)
	{
		//System.out.println(x + "Aux Verb - Infinitive");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//patu
		if(ByteMeth.endsWith(topElmt,Constant.patu))
		{
			//System.out.println(x + "patu");
			s.pop();
			s.push(new Entry(Constant.patu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.patu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		return false;
	}

	public static boolean verbalParticiple(Stack s)
	{
		//System.out.println(x + "Aux Verb - VP");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//n_il
		if(ByteMeth.endsWith(topElmt,Constant.n_il))
		{
			//System.out.println(x + "n_il");
			s.pop();
			s.push(new Entry(Constant.n_il,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.n_il.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//tholai
		if(ByteMeth.endsWith(topElmt,Constant.tholai))
		{
			//System.out.println(x + "tholai");
			s.pop();
			s.push(new Entry(Constant.tholai,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.tholai.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//thIr
		if(ByteMeth.endsWith(topElmt,Constant.thIr))
		{
			//System.out.println(x + "thIr");
			s.pop();
			s.push(new Entry(Constant.thIr,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thIr.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//thiri
		if(ByteMeth.endsWith(topElmt,Constant.thiri))
		{
			//System.out.println(x + "thiri");
			s.pop();
			s.push(new Entry(Constant.thiri,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thiri.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//thA
		if(ByteMeth.endsWith(topElmt,Constant.thA))
		{
			//System.out.println(x + "thA");
			s.pop();
			s.push(new Entry(Constant.thA,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thA.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//sey
		if(ByteMeth.endsWith(topElmt,Constant.sey))
		{
			//System.out.println(x + "sey");
			s.pop();
			s.push(new Entry(Constant.sey,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.sey.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.s(s);
			return true;
		}
		//koL
		if(ByteMeth.endsWith(topElmt,Constant.koL))
		{
			//System.out.println(x + "koL");
			s.pop();
			s.push(new Entry(Constant.koL,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.koL.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//kotu
		if(ByteMeth.endsWith(topElmt,Constant.kotu))
		{
			//System.out.println(x + "kotu");
			s.pop();
			s.push(new Entry(Constant.kotu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kotu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//kUtu
		if(ByteMeth.endsWith(topElmt,Constant.kUtu))
		{
			//System.out.println(x + "kUtu");
			s.pop();
			s.push(new Entry(Constant.kUtu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kUtu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//kuvi
		if(ByteMeth.endsWith(topElmt,Constant.kuvi))
		{
			//System.out.println(x + "kuvi");
			s.pop();
			s.push(new Entry(Constant.kuvi,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kuvi.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//kita
		if(ByteMeth.endsWith(topElmt,Constant.kita))
		{
			//System.out.println(x + "kita");
			s.pop();
			s.push(new Entry(Constant.kita,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kita.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//kAnpi
		if(ByteMeth.endsWith(topElmt,Constant.kAnpi))
		{
			//System.out.println(x + "kAnpi");
			s.pop();
			s.push(new Entry(Constant.kAnpi,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kAnpi.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//kAttu
		if(ByteMeth.endsWith(topElmt,Constant.kAttu))
		{
			//System.out.println(x + "kAttu");
			s.pop();
			s.push(new Entry(Constant.kAttu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kAttu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//kattu
		if(ByteMeth.endsWith(topElmt,Constant.kattu))
		{
			//System.out.println(x + "kattu");
			s.pop();
			s.push(new Entry(Constant.kattu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kattu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//Ongku
		if(ByteMeth.endsWith(topElmt,Constant.Ongku))
		{
			//System.out.println(x + "Ongku");
			s.pop();
			s.push(new Entry(Constant.Ongku,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Ongku.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}
		//ozi
		if(ByteMeth.endsWith(topElmt,Constant.ozi))
		{
			//System.out.println(x + "ozi");
			s.pop();
			s.push(new Entry(Constant.ozi,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ozi.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}
		//eri
		if(ByteMeth.endsWith(topElmt,Constant.eri))
		{
			//System.out.println(x + "eri");
			s.pop();
			s.push(new Entry(Constant.eri,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.eri.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}
		//ezu
		if(ByteMeth.endsWith(topElmt,Constant.ezu))
		{
			//System.out.println(x + "ezu");
			s.pop();
			s.push(new Entry(Constant.ezu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ezu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}
		//etu
		if(ByteMeth.endsWith(topElmt,Constant.etu))
		{
			//System.out.println(x + "etu");
			s.pop();
			s.push(new Entry(Constant.etu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.etu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}
		//itu
		if(ByteMeth.endsWith(topElmt,Constant.itu))
		{
			//System.out.println(x + "itu");
			s.pop();
			s.push(new Entry(Constant.itu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.itu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}
		/*//Aku
		if(ByteMeth.endsWith(topElmt,Constant.Aku))
		{
			//System.out.println(x + "Aku");
			s.pop();
			s.push(new Entry(Constant.Aku,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Aku.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}*/
		/*//Akku
		if(ByteMeth.endsWith(topElmt,Constant.Akku))
		{
			//System.out.println(x + "Akku");
			s.pop();
			s.push(new Entry(Constant.Akku,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Akku.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}*/
		//aruL
		if(ByteMeth.endsWith(topElmt,Constant.aruL))
		{
			//System.out.println(x + "aruL");
			s.pop();
			s.push(new Entry(Constant.aruL,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.aruL.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}
		//ati
		if(ByteMeth.endsWith(topElmt,Constant.ati) &&
			!ByteMeth.isEqual(topElmt,Constant.pati))
		{
			//System.out.println(x + "ati");
			s.pop();
			s.push(new Entry(Constant.ati,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ati.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}
		return false;
	}

	public static boolean infinitive_VP(Stack s)
	{
		//System.out.println(x + "Aux Verb - VP and Infinitive");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//vai
		if(ByteMeth.endsWith(topElmt,Constant.vai))
		{
			//System.out.println(x + "vai");
			s.pop();
			s.push(new Entry(Constant.vai,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vai.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vitu
		if(ByteMeth.endsWith(topElmt,Constant.vitu))
		{
			//System.out.println(x + "vitu");
			s.pop();
			s.push(new Entry(Constant.vitu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vitu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vA
		if(ByteMeth.endsWith(topElmt,Constant.vA))
		{
			//System.out.println(x + "vA");
			s.pop();
			s.push(new Entry(Constant.vA,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vA.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//pOtu
		if(ByteMeth.endsWith(topElmt,Constant.pOtu))
		{
			//System.out.println(x + "pOtu");
			s.pop();
			s.push(new Entry(Constant.pOtu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pOtu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		//pO
		if(ByteMeth.endsWith(topElmt,Constant.pO))
		{
			//System.out.println(x + "pO");
			s.pop();
			s.push(new Entry(Constant.pO,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pO.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		//pEsu
		if(ByteMeth.endsWith(topElmt,Constant.pEsu))
		{
			//System.out.println(x + "pEsu");
			s.pop();
			s.push(new Entry(Constant.pEsu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pEsu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		//peRu
		if(ByteMeth.endsWith(topElmt,Constant.peRu))
		{
			//System.out.println(x + "peRu");
			s.pop();
			s.push(new Entry(Constant.peRu,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.peRu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		//piti
		if(ByteMeth.endsWith(topElmt,Constant.piti))
		{
			//System.out.println(x + "piti");
			s.pop();
			s.push(new Entry(Constant.piti,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.piti.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		//pAr
		if(ByteMeth.endsWith(topElmt,Constant.pAr))
		{
			//System.out.println(x + "pAr");
			s.pop();
			s.push(new Entry(Constant.pAr,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pAr.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		//nEr
		if(ByteMeth.endsWith(topElmt,Constant.nEr))
		{
			//System.out.println(x + "nEr");
			s.pop();
			s.push(new Entry(Constant.nEr,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.nEr.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//iru
		if(ByteMeth.endsWith(topElmt,Constant.iru))
		{
			//System.out.println(x + "iru");
			s.pop();
			s.push(new Entry(Constant.iru,Tag.AuxVerb));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.iru.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}
		return false;
	}

	public static boolean check(Stack s)
	{
		VerbMisc.finiteVerb(s);
		VerbMisc.adverbial_Particle(s);
		if(Infinity.infinitive_Ends(s))
			Infinity.check(s);
		if(check1(s))
			return true;
		return false;
	}

	public static boolean check1(Stack s)
	{
		if(AuxiliaryVerb.infinitive_VP(s))
		{
			if(VerbalParticiple.check(s))
			{
				check(s);
				return true;
			}
			else if(Infinity.check(s))
			{
				check(s);
				return true;
			}
		}
		if(AuxiliaryVerb.verbalParticiple(s))
		{
			if(VerbalParticiple.check(s))
			{
				check(s);
				return true;
			}
		}
		if(AuxiliaryVerb.infinitive(s))
		{
			if(Infinity.check(s))
			{
				check(s);
				return true;
			}
		}
		if(RelativeParticiple.check(s))
		{
			if(Tense.check(s))
			{
				check(s);
				return true;
			}
		}

		return false;
	}
}
