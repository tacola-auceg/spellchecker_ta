package analyser;

import java.util.Stack;

public class PNG
{
	static ByteMeth ByteMeth;
	static String x = "";

	public static boolean check(Stack s)
	{
		//System.out.println(x + "PNG");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if(ByteMeth.endsWith(topElmt,Constant.An))//1
		{
			//System.out.println(x + "An");
			s.pop();
			s.push(new Entry(Constant.An,Tag.ThirdPersonMasSingular));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.An.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.AL))//2
		{
			//System.out.println(x + "AL");
			s.pop();
			s.push(new Entry(Constant.AL,Tag.ThirdPersonFemSingular));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.AL.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.Ar))//3
		{
			//System.out.println(x + "Ar");
			s.pop();
			s.push(new Entry(Constant.Ar,Tag.ThirdPersonMasFemSingular));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.Ar.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.ArkaL))//4
		{
			//System.out.println(x + "ArkaL");
			s.pop();
			s.push(new Entry(Constant.ArkaL,Tag.ThirdPersonPlural));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.ArkaL.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.athu))//5
		{
			//System.out.println(x + "athu");
			s.pop();
			s.push(new Entry(Constant.athu,Tag.NeuterSingular));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.athu.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.avai))//5
		{
			//System.out.println(x + "avai");
			s.pop();
			s.push(new Entry(Constant.avai,Tag.NeuterPlural));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.avai.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.ana))//6
		{
			//System.out.println(x + "ana");
			s.pop();
			s.push(new Entry(Constant.ana,Tag.NeuterPlural));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.ana.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.IrkaL) &&
			!ByteMeth.endsWith(topElmt,Constant.AthIrkaL))//7
		{
			//System.out.println(x + "IrkaL");
			s.pop();
			s.push(new Entry(Constant.IrkaL,Tag.SecondPersonPlural));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.IrkaL.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.Ir))//8
		{
			//System.out.println(x + "Ir");
			s.pop();
			s.push(new Entry(Constant.Ir,Tag.SecondPersonSingular));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.Ir.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.Ay))//9
		{
			//System.out.println(x + "Ay");
			s.pop();
			s.push(new Entry(Constant.Ay,Tag.SecondPersonSingular));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.Ay.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.Om))//10
		{
			//System.out.println(x + "Om");
			s.pop();
			s.push(new Entry(Constant.Om,Tag.FirstPersonPlural));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.Om.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.En))//11
		{
			//System.out.println(x + "En");
			s.pop();
			s.push(new Entry(Constant.En,Tag.FirstPersonSingular));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.En.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.anar))//12
		{
			//System.out.println(x + "anar");
			s.pop();
			s.push(new Entry(Constant.anar,Tag.ThirdPersonPlural));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.anar.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.ar))//13
		{
			//System.out.println(x + "ar");
			s.pop();
			s.push(new Entry(Constant.ar,Tag.ThirdPersonPlural));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.ar.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.Or))//14
		{
			//System.out.println(x + "Or");
			s.pop();
			s.push(new Entry(Constant.Or,Tag.ThirdPersonPlural));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.Or.length));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		else if(ByteMeth.endsWith(topElmt,Constant.um))//15
		{
			//System.out.println(x + "um");
			s.pop();
			s.push(new Entry(Constant.um,Tag.ThirdFutureNeuterSingular_RP));
			topElmt = ByteMeth.subArray(topElmt,0,(topElmt.length-Constant.um.length));
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
			Sandhi.type4(s);
			Sandhi.type5(s);
			Sandhi.kk(s);
			return true;
		}


		return false;
	}

}
