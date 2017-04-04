package analyser;

import java.util.*;

public class VerbalParticiple
{
	static String x = "";

	public static boolean check(Stack s)
	{
		//System.out.println(x + "VP");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//i
		if(ByteMeth.endsWith(topElmt,Constant.i))
		{
			//System.out.println(x + "i");
			s.pop();
			s.push(new Entry(Constant.i,Tag.VPSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.i.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.type4(s);
			Sandhi.type5(s);
			return true;
		}

		//n_thu
		if(ByteMeth.endsWith(topElmt,Constant.n_thu))
		{
			//System.out.println(x + "n_thu");
			s.pop();
			s.push(new Entry(Constant.u,Tag.VPSuffix));
			s.push(new Entry(Constant.n_th,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.n_thu.length);
			if(ByteMeth.isEqual(topElmt,Constant.va) ||
				ByteMeth.isEqual(topElmt,Constant.tha) ||
				ByteMeth.isEqual(topElmt,Constant.se))
			{
					topElmt = ByteMeth.replace(topElmt,Constant.A,1);
			}
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//ththu
		if(ByteMeth.endsWith(topElmt,Constant.ththu))
		{
			//System.out.println(x + "ththu");
			s.pop();
			s.push(new Entry(Constant.u,Tag.VPSuffix));
			s.push(new Entry(Constant.thth,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.ththu.length);
			if(ByteMeth.isEqual(topElmt,Constant.va) ||
				ByteMeth.isEqual(topElmt,Constant.tha) ||
				ByteMeth.isEqual(topElmt,Constant.se))
			{
					topElmt = ByteMeth.replace(topElmt,Constant.A,1);
			}
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//thu
		if(ByteMeth.endsWith(topElmt,Constant.thu))
		{
			//System.out.println(x + "thu");
			s.pop();
			s.push(new Entry(Constant.u,Tag.VPSuffix));
			s.push(new Entry(Constant.th,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thu.length);
			if(ByteMeth.isEqual(topElmt,Constant.va) ||
				ByteMeth.isEqual(topElmt,Constant.tha) ||
				ByteMeth.isEqual(topElmt,Constant.se))
			{
				topElmt = ByteMeth.replace(topElmt,Constant.A,1);
			}
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//tu
		if(ByteMeth.endsWith(topElmt,Constant.tu))
		{
			//System.out.println(x + "tu");
			s.pop();
			s.push(new Entry(Constant.u,Tag.VPSuffix));
			s.push(new Entry(Constant.t,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.tu.length);
			if(ByteMeth.isEqual(topElmt,Constant.kaN))
				topElmt = ByteMeth.replace(topElmt,Constant.AN,2);
			else if(ByteMeth.endsWith(topElmt,Constant.N) &&
					!ByteMeth.isEqual(topElmt,Constant.uN) &&
					!ByteMeth.isEqual(topElmt,Constant.pUN))
				topElmt = ByteMeth.replace(topElmt,Constant.L,1);
			else if(ByteMeth.isEqual(topElmt,Constant.kEt))
				topElmt = ByteMeth.replace(topElmt,Constant.L,1);
			else if(ByteMeth.endsWith(topElmt,Constant.t))
					topElmt = ByteMeth.addArray(topElmt,Constant.u);

			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//Ru
		if(ByteMeth.endsWith(topElmt,Constant.Ru))
		{
			//System.out.println(x + "Ru");
			s.pop();
			s.push(new Entry(Constant.u,Tag.VPSuffix));
			s.push(new Entry(Constant.R,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.Ru.length);
			if(ByteMeth.isEqual(topElmt,Constant.kaR) ||
				ByteMeth.isEqual(topElmt,Constant.viR))
				topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			if(ByteMeth.endsWith(topElmt,Constant.R))
				topElmt = ByteMeth.addArray(topElmt,Constant.u);
			if(ByteMeth.endsWith(topElmt,Constant.R))
				topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			else if(ByteMeth.endsWith(topElmt,Constant.n) &&
				!ByteMeth.isEqual(topElmt,Constant.thin))
					topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//y
		if(ByteMeth.endsWith(topElmt,Constant.y))
		{
			//System.out.println(x + "y");
			s.pop();
			s.push(new Entry(Constant.y,Tag.VPSuffix));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.y.length);
			//doubt
			if(ByteMeth.endsWith(topElmt,Constant.i))
				topElmt = ByteMeth.replace(topElmt,Constant.u,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}
}
