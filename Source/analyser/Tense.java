package analyser;

import java.util.Stack;

public class Tense
{
	static ByteMeth ByteMeth;
	static String x = "";
	public static boolean check(Stack s)
	{
		//System.out.println(x + "Tense");

		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//present
		//15-kkinRu
		if(ByteMeth.endsWith(topElmt,Constant.kkinR))
		{
			//System.out.println(x + "kkinRu");
			s.pop();
			s.push(new Entry(Constant.kkinRu,Tag.PresentTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kkinR.length);
			if(ByteMeth.isEqual(topElmt,Constant.kEt))
				topElmt = ByteMeth.replace(topElmt,Constant.L,1);
			else if(ByteMeth.endsWith(topElmt,Constant.R))
				topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//14-kkiRu
		if(ByteMeth.endsWith(topElmt,Constant.kkiR))
		{
			//System.out.println(x + "kkiRu");
			s.pop();
			s.push(new Entry(Constant.kkiRu,Tag.PresentTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kkiR.length);
			if(ByteMeth.isEqual(topElmt,Constant.kEt))
				topElmt = ByteMeth.replace(topElmt,Constant.L,1);
			else if(ByteMeth.endsWith(topElmt,Constant.R))
				topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//kiR
		else if(ByteMeth.endsWith(topElmt,Constant.kiR))
		{
			//System.out.println(x + "kiRu");
			s.pop();
			s.push(new Entry(Constant.kiRu,Tag.PresentTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kiR.length);
			if(ByteMeth.isEqual(topElmt,Constant.kEt))
				topElmt = ByteMeth.replace(topElmt,Constant.L,1);
			else if(ByteMeth.endsWith(topElmt,Constant.R))
				topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//15-kinRu
		else if(ByteMeth.endsWith(topElmt,Constant.kinR))
		{
			//System.out.println(x + "kinRu");
			s.pop();
			s.push(new Entry(Constant.kinRu,Tag.PresentTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.kinR.length);
			if(ByteMeth.isEqual(topElmt,Constant.kEt))
				topElmt = ByteMeth.replace(topElmt,Constant.L,1);
			else if(ByteMeth.endsWith(topElmt,Constant.R))
				topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//past
		//1-in
		else if(ByteMeth.endsWith(topElmt,Constant.in))
		{
			//System.out.println(x + "in");

			s.pop();
			s.push(new Entry(Constant.in,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.in.length);
			if(ByteMeth.endsWith(topElmt,Constant.k) ||
				ByteMeth.endsWith(topElmt,Constant.s) ||
				ByteMeth.endsWith(topElmt,Constant.t) ||
				ByteMeth.endsWith(topElmt,Constant.th) ||
				ByteMeth.endsWith(topElmt,Constant.p) ||
				ByteMeth.endsWith(topElmt,Constant.R) ||
				ByteMeth.endsWith(topElmt,Constant.v))
					topElmt = ByteMeth.addArray(topElmt,Constant.u);

			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//n_th
		else if(ByteMeth.endsWith(topElmt,Constant.n_th))
		{
			//System.out.println(x + "n_th");
			s.pop();
			s.push(new Entry(Constant.n_th,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.n_th.length);
			if(ByteMeth.isEqual(topElmt,Constant.va) ||
				ByteMeth.isEqual(topElmt,Constant.tha) ||
				ByteMeth.isEqual(topElmt,Constant.se))
			{
					topElmt = ByteMeth.replace(topElmt,Constant.A,1);
			}
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//thth
		else if(ByteMeth.endsWith(topElmt,Constant.thth))
		{
			//System.out.println(x + "thth");
			s.pop();
			s.push(new Entry(Constant.thth,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thth.length);
			if(ByteMeth.isEqual(topElmt,Constant.va) ||
				ByteMeth.isEqual(topElmt,Constant.tha) ||
				ByteMeth.isEqual(topElmt,Constant.se))
			{
					topElmt = ByteMeth.replace(topElmt,Constant.A,1);
			}
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//th
		else if(ByteMeth.endsWith(topElmt,Constant.th))
		{
			//System.out.println(x + "th");
			s.pop();
			s.push(new Entry(Constant.th,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.th.length);
			if(ByteMeth.isEqual(topElmt,Constant.va) ||
				ByteMeth.isEqual(topElmt,Constant.tha) ||
				ByteMeth.isEqual(topElmt,Constant.se))
			{
					topElmt = ByteMeth.replace(topElmt,Constant.A,1);
			}
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//8-n
		else if(ByteMeth.endsWith(topElmt,Constant.n))
		{
			//System.out.println(x + "n");
			s.pop();
			s.push(new Entry(Constant.n,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.n.length);
			if(ByteMeth.endsWith(topElmt,Constant.n) &&
				!ByteMeth.isEqual(topElmt,Constant.thin))
					topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//9-t
		else if(ByteMeth.endsWith(topElmt,Constant.t) &&
			!ByteMeth.endsWith(topElmt,Constant.mAtt))
		{
			//System.out.println(x + "t");
			s.pop();
			s.push(new Entry(Constant.t,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.t.length);

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

		//10-R
		else if(ByteMeth.endsWith(topElmt,Constant.R))
		{
			//System.out.println(x + "R");
			s.pop();
			s.push(new Entry(Constant.R,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.R.length);
			if(ByteMeth.isEqual(topElmt,Constant.kaR) ||
				ByteMeth.isEqual(topElmt,Constant.viR))
				topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			if(ByteMeth.endsWith(topElmt,Constant.R))
				topElmt = ByteMeth.addArray(topElmt,Constant.u);
			else if(ByteMeth.endsWith(topElmt,Constant.n) &&
				!ByteMeth.isEqual(topElmt,Constant.thin))
					topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//3-y
		else if(ByteMeth.endsWith(topElmt,Constant.y))
		{
			//System.out.println(x + "y");
			s.pop();
			s.push(new Entry(Constant.y,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.y.length);
			if(ByteMeth.endsWith(topElmt,Constant.i))
				topElmt = ByteMeth.replace(topElmt,Constant.u,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//future
		//17-v
		else if(ByteMeth.endsWith(topElmt,Constant.v))
		{
			//System.out.println(x + "v");
			s.pop();
			s.push(new Entry(Constant.v,Tag.FutureTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.v.length);
			if(ByteMeth.isEqual(topElmt,Constant.kEt))
				topElmt = ByteMeth.replace(topElmt,Constant.L,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//18-pp
		else if(ByteMeth.endsWith(topElmt,Constant.pp))
		{
			//System.out.println(x + "pp");
			s.pop();
			s.push(new Entry(Constant.pp,Tag.FutureTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.pp.length);
			if(ByteMeth.isEqual(topElmt,Constant.kEt))
				topElmt = ByteMeth.replace(topElmt,Constant.L,1);
			else if(ByteMeth.endsWith(topElmt,Constant.R))
				topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//18-p
		else if(ByteMeth.endsWith(topElmt,Constant.p))
		{
			//System.out.println(x + "p");
			s.pop();
			s.push(new Entry(Constant.p,Tag.FutureTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.p.length);
			if(ByteMeth.isEqual(topElmt,Constant.kEt))
				topElmt = ByteMeth.replace(topElmt,Constant.L,1);
			else if(ByteMeth.endsWith(topElmt,Constant.R))
				topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}

	public static boolean human(Stack s)
	{
		//System.out.println(x + "Tense human");

		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//1-in
		if(ByteMeth.endsWith(topElmt,Constant.in))
		{
			//System.out.println(x + "in");

			s.pop();
			s.push(new Entry(Constant.in,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.in.length);
			if(ByteMeth.endsWith(topElmt,Constant.k) ||
				ByteMeth.endsWith(topElmt,Constant.s) ||
				ByteMeth.endsWith(topElmt,Constant.t) ||
				ByteMeth.endsWith(topElmt,Constant.th) ||
				ByteMeth.endsWith(topElmt,Constant.p) ||
				ByteMeth.endsWith(topElmt,Constant.R) ||
				ByteMeth.endsWith(topElmt,Constant.v))
					topElmt = ByteMeth.addArray(topElmt,Constant.u);

			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//n_th
		else if(ByteMeth.endsWith(topElmt,Constant.n_th))
		{
			//System.out.println(x + "n_th");
			s.pop();
			s.push(new Entry(Constant.n_th,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.n_th.length);
			if(ByteMeth.isEqual(topElmt,Constant.va) ||
				ByteMeth.isEqual(topElmt,Constant.tha) ||
				ByteMeth.isEqual(topElmt,Constant.se))
			{
					topElmt = ByteMeth.replace(topElmt,Constant.A,1);
			}
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//thth
		else if(ByteMeth.endsWith(topElmt,Constant.thth))
		{
			//System.out.println(x + "thth");
			s.pop();
			s.push(new Entry(Constant.thth,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.thth.length);
			if(ByteMeth.isEqual(topElmt,Constant.va) ||
				ByteMeth.isEqual(topElmt,Constant.tha) ||
				ByteMeth.isEqual(topElmt,Constant.se))
			{
					topElmt = ByteMeth.replace(topElmt,Constant.A,1);
			}
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//th
		else if(ByteMeth.endsWith(topElmt,Constant.th))
		{
			//System.out.println(x + "th");
			s.pop();
			s.push(new Entry(Constant.th,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.th.length);
			if(ByteMeth.isEqual(topElmt,Constant.va) ||
				ByteMeth.isEqual(topElmt,Constant.tha) ||
				ByteMeth.isEqual(topElmt,Constant.se))
			{
					topElmt = ByteMeth.replace(topElmt,Constant.A,1);
			}
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//8-n
		else if(ByteMeth.endsWith(topElmt,Constant.n))
		{
			//System.out.println(x + "n");
			s.pop();
			s.push(new Entry(Constant.n,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.n.length);
			if(ByteMeth.endsWith(topElmt,Constant.n) &&
				!ByteMeth.isEqual(topElmt,Constant.thin))
					topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		//9-t
		else if(ByteMeth.endsWith(topElmt,Constant.t) &&
			!ByteMeth.endsWith(topElmt,Constant.mAtt))
		{
			//System.out.println(x + "t");
			s.pop();
			s.push(new Entry(Constant.t,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.t.length);

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

		//10-R
		else if(ByteMeth.endsWith(topElmt,Constant.R))
		{
			//System.out.println(x + "R");
			s.pop();
			s.push(new Entry(Constant.R,Tag.PastTenseMarker));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-Constant.R.length);
			if(ByteMeth.isEqual(topElmt,Constant.kaR) ||
				ByteMeth.isEqual(topElmt,Constant.viR))
				topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			if(ByteMeth.endsWith(topElmt,Constant.R))
				topElmt = ByteMeth.addArray(topElmt,Constant.u);
			else if(ByteMeth.endsWith(topElmt,Constant.n) &&
				!ByteMeth.isEqual(topElmt,Constant.thin))
					topElmt = ByteMeth.replace(topElmt,Constant.l,1);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}

		return false;
	}
}

/*
future pbm:
endsWith and isEqual while going for Aux.
eg:
seithukoNtAL:endsWith
koNtAL:isEqual
*/
