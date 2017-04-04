package analyser;

import java.util.Stack;

public class Postposition
{
	static ByteMeth ByteMeth;
	static String x = "";
	static Stack originalStack;

	public static boolean check(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//System.out.println(x + "PP all");

		//thottu
		if(ByteMeth.endsWith(topElmt,Constant.thottu))
		{
			//System.out.println(x + "thottu");
			s.pop();
			s.push(new Entry(Constant.thottu,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thottu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//muthal
		if(ByteMeth.endsWith(topElmt,Constant.muthal))
		{
			//System.out.println(x + "muthal");
			s.pop();
			s.push(new Entry(Constant.muthal,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.muthal.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vasam
		if(ByteMeth.endsWith(topElmt,Constant.vasam))
		{
			//System.out.println(x + "vasam");
			s.pop();
			s.push(new Entry(Constant.vasam,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vasam.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//later
		/*//varai
		if(ByteMeth.endsWith(topElmt,Constant.varai) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.Ana,Constant.varai)) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.iya,Constant.varai)) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.uLLa,Constant.varai)) &&
			!ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.aRRa,Constant.varai)))
		{
			//System.out.println(x + "varai");
			s.pop();
			s.push(new Entry(Constant.varai,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.varai.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}*/
		//varaiyil
		if(ByteMeth.endsWith(topElmt,Constant.varaiyil))
		{
			//System.out.println(x + "varaiyil");
			s.pop();
			s.push(new Entry(Constant.varaiyil,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.varaiyil.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//varaikkum
		if(ByteMeth.endsWith(topElmt,Constant.varaikkum))
		{
			//System.out.println(x + "varaikkum");
			s.pop();
			s.push(new Entry(Constant.varaikkum,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.varaikkum.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//thORum
		if(ByteMeth.endsWith(topElmt,Constant.thORum))
		{
			//System.out.println(x + "thORum");
			s.pop();
			s.push(new Entry(Constant.thORum,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thORum.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//otti
		if(ByteMeth.endsWith(topElmt,Constant.otti))
		{
			//System.out.println(x + "otti");
			s.pop();
			s.push(new Entry(Constant.otti,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.otti.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			return true;
		}

		//ottiya
		if(ByteMeth.endsWith(topElmt,Constant.ottiya))
		{
			//System.out.println(x + "ottiya");
			s.pop();
			s.push(new Entry(Constant.ottiya,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ottiya.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			return true;
		}
		//kAttilum
		if(ByteMeth.endsWith(topElmt,Constant.kAttilum))
		{
			//System.out.println(x + "kAttilum");
			s.pop();
			s.push(new Entry(Constant.kAttilum,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kAttilum.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//munnittu
		if(ByteMeth.endsWith(topElmt,Constant.munnittu))
		{
			//System.out.println(x + "munnittu");
			s.pop();
			s.push(new Entry(Constant.munnittu,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.munnittu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vita
		if(ByteMeth.endsWith(topElmt,Constant.vita))
		{
			//System.out.println(x + "vita");
			s.pop();
			s.push(new Entry(Constant.vita,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vita.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//vittu
		if(ByteMeth.endsWith(topElmt,Constant.vittu))
		{
			//System.out.println(x + "vittu");
			s.pop();
			s.push(new Entry(Constant.vittu,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vittu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//suRRi
		if(ByteMeth.endsWith(topElmt,Constant.suRRi))
		{
			//System.out.println(x + "suRRi");
			s.pop();
			s.push(new Entry(Constant.suRRi,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.suRRi.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.s(s);
			return true;
		}
		//appAl
		if(ByteMeth.endsWith(topElmt,Constant.appAl))
		{
			//System.out.println(x + "appAl");
			s.pop();
			s.push(new Entry(Constant.appAl,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.appAl.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type4(s);
			return true;
		}
		//appuRam
		if(ByteMeth.endsWith(topElmt,Constant.appuRam))
		{
			//System.out.println(x + "appuRam");
			s.pop();
			s.push(new Entry(Constant.appuRam,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.appuRam.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type4(s);
			return true;
		}
		//n_igarAka
		if(ByteMeth.endsWith(topElmt,Constant.n_igarAka))
		{
			//System.out.println(x + "n_igarAka");
			s.pop();
			s.push(new Entry(Constant.n_igarAka,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.n_igarAka.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//ERpa
		if(ByteMeth.endsWith(topElmt,Constant.ERpa))
		{
			//System.out.println(x + "ERpa");
			s.pop();
			s.push(new Entry(Constant.ERpa,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ERpa.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type4(s);
			return true;
		}
		//n_ikar
		if(ByteMeth.endsWith(topElmt,Constant.n_ikar))
		{
			//System.out.println(x + "n_ikar");
			s.pop();
			s.push(new Entry(Constant.n_ikar,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.n_ikar.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//munpu
		if(ByteMeth.endsWith(topElmt,Constant.munpu))
		{
			//System.out.println(x + "munpu");
			s.pop();
			s.push(new Entry(Constant.munpu,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.munpu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//mERpatta
		if(ByteMeth.endsWith(topElmt,Constant.mERpatta))
		{
			//System.out.println(x + "mERpatta");
			s.pop();
			s.push(new Entry(Constant.mERpatta,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.mERpatta.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//bathilAka
		if(ByteMeth.endsWith(topElmt,Constant.bathilAka))
		{
			//System.out.println(x + "bathilAka");
			s.pop();
			s.push(new Entry(Constant.bathilAka,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.bathilAka.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		//viLaivAka
		if(ByteMeth.endsWith(topElmt,Constant.viLaivAka))
		{
			//System.out.println(x + "viLaivAka");
			s.pop();
			s.push(new Entry(Constant.viLaivAka,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.viLaivAka.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//pEril
		if(ByteMeth.endsWith(topElmt,Constant.pEril))
		{
			//System.out.println(x + "pEril");
			s.pop();
			s.push(new Entry(Constant.pEril,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pEril.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//pOthu
		if(ByteMeth.endsWith(topElmt,Constant.pOthu))
		{
			//System.out.println(x + "pOthu");
			s.pop();
			s.push(new Entry(Constant.pOthu,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pOthu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//pozuthu
		if(ByteMeth.endsWith(topElmt,Constant.pozuthu))
		{
			//System.out.println(x + "pozuthu");
			s.pop();
			s.push(new Entry(Constant.pozuthu,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pozuthu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//irun_thu
		if(ByteMeth.endsWith(topElmt,Constant.irun_thu))
		{
			//System.out.println(x + "irun_thu");
			s.pop();
			s.push(new Entry(Constant.irun_thu,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.irun_thu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type2(s);
			Sandhi.type4(s);
			return true;
		}
		//kuRiththu
		if(ByteMeth.endsWith(topElmt,Constant.kuRiththu))
		{
			//System.out.println(x + "kuRiththu");
			s.pop();
			s.push(new Entry(Constant.kuRiththu,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kuRiththu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//thavira
		if(ByteMeth.endsWith(topElmt,Constant.thavira))
		{
			//System.out.println(x + "thavira");
			s.pop();
			s.push(new Entry(Constant.thavira,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thavira.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.th(s);
			return true;
		}
		//paRRi
		if(ByteMeth.endsWith(topElmt,Constant.paRRi))
		{
			//System.out.println(x + "paRRi");
			s.pop();
			s.push(new Entry(Constant.paRRi,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.paRRi.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		//pOl
		if(ByteMeth.endsWith(topElmt,Constant.pOl))
		{
			//System.out.println(x + "pOl");
			s.pop();
			s.push(new Entry(Constant.pOl,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pOl.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		//pOla
		if(ByteMeth.endsWith(topElmt,Constant.pOla))
		{
			//System.out.println(x + "pOla");
			s.pop();
			s.push(new Entry(Constant.pOla,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pOla.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		//mAthiri
		if(ByteMeth.endsWith(topElmt,Constant.mAthiri))
		{
			//System.out.println(x + "mAthiri");
			s.pop();
			s.push(new Entry(Constant.mAthiri,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.mAthiri.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//kuRiththa
		if(ByteMeth.endsWith(topElmt,Constant.kuRiththa))
		{
			//System.out.println(x + "kuRiththa");
			s.pop();
			s.push(new Entry(Constant.kuRiththa,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kuRiththa.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//paRRiya
		if(ByteMeth.endsWith(topElmt,Constant.paRRiya))
		{
			//System.out.println(x + "paRRiya");
			s.pop();
			s.push(new Entry(Constant.paRRiya,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.paRRiya.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.p(s);
			return true;
		}
		//vaiththu
		if(ByteMeth.endsWith(topElmt,Constant.vaiththu))
		{
			//System.out.println(x + "vaiththu");
			s.pop();
			s.push(new Entry(Constant.vaiththu,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vaiththu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//n_Okki
		if(ByteMeth.endsWith(topElmt,Constant.n_Okki))
		{
			//System.out.println(x + "n_Okki");
			s.pop();
			s.push(new Entry(Constant.n_Okki,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.n_Okki.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//koNdu
		if(ByteMeth.endsWith(topElmt,Constant.koNdu))
		{
			//System.out.println(x + "koNdu");
			s.pop();
			s.push(new Entry(Constant.koNdu,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.koNdu.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		//allAtha
		if(ByteMeth.endsWith(topElmt,Constant.allAtha))
		{
			//System.out.println(x + "allAtha");
			s.pop();
			s.push(new Entry(Constant.allAtha,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.allAtha.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//ethirE
		if(ByteMeth.endsWith(topElmt,Constant.ethirE))
		{
			//System.out.println(x + "ethirE");
			s.pop();
			s.push(new Entry(Constant.ethirE,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ethirE.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//sArbAka
		if(ByteMeth.endsWith(topElmt,Constant.sArbAka))
		{
			//System.out.println(x + "sArbAka");
			s.pop();
			s.push(new Entry(Constant.sArbAka,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.sArbAka.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//sArbil
		if(ByteMeth.endsWith(topElmt,Constant.sArbil))
		{
			//System.out.println(x + "sArbil");
			s.pop();
			s.push(new Entry(Constant.sArbil,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.sArbil.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		/*//pAl
		if(ByteMeth.endsWith(topElmt,Constant.pAl) &&
			!ByteMeth.endsWith(topElmt,Constant.appAl))
		{
			//System.out.println(x + "pAl");
			s.pop();
			s.push(new Entry(Constant.pAl,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pAl.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		*/
		//veLiyE
		if(ByteMeth.endsWith(topElmt,Constant.veLiyE))
		{
			//System.out.println(x + "veLiyE");
			s.pop();
			s.push(new Entry(Constant.veLiyE,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.veLiyE.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//vaziyAka
		if(ByteMeth.endsWith(topElmt,Constant.vaziyAka))
		{
			//System.out.println(x + "vaziyAka");
			s.pop();
			s.push(new Entry(Constant.vaziyAka,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.vaziyAka.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//mUlam
		if(ByteMeth.endsWith(topElmt,Constant.mUlam))
		{
			//System.out.println(x + "mUlam");
			s.pop();
			s.push(new Entry(Constant.mUlam,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.mUlam.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//mUlamAka
		if(ByteMeth.endsWith(topElmt,Constant.mUlamAka))
		{
			//System.out.println(x + "mUlamAka");
			s.pop();
			s.push(new Entry(Constant.mUlamAka,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.mUlamAka.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//padi
		if(ByteMeth.endsWith(topElmt,Constant.padi))
		{
			//System.out.println(x + "padi");
			s.pop();
			s.push(new Entry(Constant.padi,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.padi.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//udaiya
		if(ByteMeth.endsWith(topElmt,Constant.udaiya))
		{
			//System.out.println(x + "udaiya");
			s.pop();
			s.push(new Entry(Constant.udaiya,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.udaiya.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//aLavukku
		if(ByteMeth.endsWith(topElmt,Constant.aLavukku))
		{
			//System.out.println(x + "aLavukku");
			s.pop();
			s.push(new Entry(Constant.aLavukku,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.aLavukku.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//adiyil
		if(ByteMeth.endsWith(topElmt,Constant.adiyil))
		{
			//System.out.println(x + "adiyil");
			s.pop();
			s.push(new Entry(Constant.adiyil,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.adiyil.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//idaiyil
		if(ByteMeth.endsWith(topElmt,Constant.idaiyil))
		{
			//System.out.println(x + "idaiyil");
			s.pop();
			s.push(new Entry(Constant.idaiyil,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.idaiyil.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//idaiyE
		if(ByteMeth.endsWith(topElmt,Constant.idaiyE))
		{
			//System.out.println(x + "idaiyE");
			s.pop();
			s.push(new Entry(Constant.idaiyE,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.idaiyE.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//utpuRaththil
		if(ByteMeth.endsWith(topElmt,Constant.utpuRaththil))
		{
			//System.out.println(x + "utpuRaththil");
			s.pop();
			s.push(new Entry(Constant.utpuRaththil,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.utpuRaththil.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//utpuRam
		if(ByteMeth.endsWith(topElmt,Constant.utpuRam))
		{
			//System.out.println(x + "utpuRam");
			s.pop();
			s.push(new Entry(Constant.utpuRam,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.utpuRam.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//uL
		if(ByteMeth.endsWith(topElmt,Constant.uL))
		{
			//System.out.println(x + "uL");
			s.pop();
			s.push(new Entry(Constant.uL,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.uL.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//uLLE
		if(ByteMeth.endsWith(topElmt,Constant.uLLE))
		{
			//System.out.println(x + "uLLE");
			s.pop();
			s.push(new Entry(Constant.uLLE,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.uLLE.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//kIzE
		if(ByteMeth.endsWith(topElmt,Constant.kIzE))
		{
			//System.out.println(x + "kIzE");
			s.pop();
			s.push(new Entry(Constant.kIzE,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kIzE.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			Sandhi.k(s);
			return true;
		}
		//kIz
		if(ByteMeth.endsWith(topElmt,Constant.kIz))
		{
			//System.out.println(x + "kIz");
			s.pop();
			s.push(new Entry(Constant.kIz,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kIz.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			Sandhi.k(s);
			return true;
		}
		//kuRukkE
		if(ByteMeth.endsWith(topElmt,Constant.kuRukkE))
		{
			//System.out.println(x + "kuRukkE");
			s.pop();
			s.push(new Entry(Constant.kuRukkE,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kuRukkE.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			Sandhi.k(s);
			return true;
		}
		//n_aduvil
		if(ByteMeth.endsWith(topElmt,Constant.n_aduvil))
		{
			//System.out.println(x + "n_aduvil");
			s.pop();
			s.push(new Entry(Constant.n_aduvil,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.n_aduvil.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//n_aduvE
		if(ByteMeth.endsWith(topElmt,Constant.n_aduvE))
		{
			//System.out.println(x + "n_aduvE");
			s.pop();
			s.push(new Entry(Constant.n_aduvE,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.n_aduvE.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//pin
		if(ByteMeth.endsWith(topElmt,Constant.pin))
		{
			//System.out.println(x + "pin");
			s.pop();
			s.push(new Entry(Constant.pin,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pin.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			Sandhi.k(s);
			return true;
		}
		//pinnE
		if(ByteMeth.endsWith(topElmt,Constant.pinnE))
		{
			//System.out.println(x + "pinnE");
			s.pop();
			s.push(new Entry(Constant.pinnE,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pinnE.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			Sandhi.k(s);
			return true;
		}
		//mun
		if(ByteMeth.endsWith(topElmt,Constant.mun))
		{
			//System.out.println(x + "mun");
			s.pop();
			s.push(new Entry(Constant.mun,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.mun.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//munnE
		if(ByteMeth.endsWith(topElmt,Constant.munnE))
		{
			//System.out.println(x + "munnE");
			s.pop();
			s.push(new Entry(Constant.munnE,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.munnE.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//munnar
		if(ByteMeth.endsWith(topElmt,Constant.munnar))
		{
			//System.out.println(x + "munnar");
			s.pop();
			s.push(new Entry(Constant.munnar,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.munnar.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//mEl
		if(ByteMeth.endsWith(topElmt,Constant.mEl))
		{
			//System.out.println(x + "mEl");
			s.pop();
			s.push(new Entry(Constant.mEl,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.mEl.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			return true;
		}
		//piRaku
		if(ByteMeth.endsWith(topElmt,Constant.piRaku))
		{
			//System.out.println(x + "piRaku");
			s.pop();
			s.push(new Entry(Constant.piRaku,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.piRaku.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.postposition(s);
			Sandhi.p(s);
			return true;
		}
		//Aka
		if(ByteMeth.endsWith(topElmt,Constant.Aka) &&
			(ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.iRk,Constant.Aka)) ||
			ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.aRk,Constant.Aka)) ||
			ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.akk,Constant.Aka)) ||
			ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.ukk,Constant.Aka)) ||
			ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.kk,Constant.Aka))))
		{
			//System.out.println(x + "Aka");
			s.pop();
			s.push(new Entry(Constant.Aka,Tag.BoundPostposition));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Aka.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type4(s);
			return true;
		}
		return false;
	}
}
