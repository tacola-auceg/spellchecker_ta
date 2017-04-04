package analyser;

import java.util.Stack;

public class Sandhi
{
	static ByteMeth ByteMeth;
	static String x = "";

	//later
	static String kctp_exception(Stack s)
	{
		return null;
	}

	static void euphonic(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if(ByteMeth.isEqual(topElmt,Constant.athan) ||
			ByteMeth.isEqual(topElmt,Constant.ithan) ||
			ByteMeth.isEqual(topElmt,Constant.ethan))
		{
			euphonic_an(s);
		}
		else
		{
			euphonic_in(s);
		}
	}

	static void euphonic_in(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if(ByteMeth.endsWith(topElmt,Constant.in))
		{
			//System.out.println(x + "Euphonic in");
			s.pop();
			s.push(new Entry(Constant.in,Tag.Euphonic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.in.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return;
		}
	}

	static void euphonic_an(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(ByteMeth.endsWith(topElmt,Constant.an))
		{
			//System.out.println(x + "Euphonic an");
			s.pop();
			s.push(new Entry(Constant.an,Tag.Euphonic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.an.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return;
		}
	}

	public static boolean handleException(Stack s)
	{
		//System.out.println(x + "Sandhi Exception");

		int size = s.size();
		if(size < 2)
			return false;

		byte[] entry1 = ((Entry) s.get(size-1)).getPart();
		byte[] entry2Part = ((Entry) s.get(size-2)).getPart();
		int entry2Tag = ((Entry) s.get(size-2)).getTag();

		if(ByteMeth.isEqual(entry2Part,Constant.v) &&
			(entry2Tag == Tag.Sandhi))
		{
			//System.out.println(x + "ME:v - vu");
			s.pop();
			s.pop();
			s.push(new Entry(ByteMeth.addArray(entry1,Constant.vu),-1));
			return true;
		}

		if(ByteMeth.isEqual(entry2Part,Constant.aththu) &&
			(entry2Tag == Tag.Oblique))
		{
			//System.out.println(x + "ME:m+aththu - ththu");
			s.pop();
			s.pop();
			entry1 = ByteMeth.subArray(entry1,0,entry1.length-Constant.m.length);
			s.push(new Entry(ByteMeth.addArray(entry1,Constant.ththu),-1));
			return true;
		}
		if(ByteMeth.endsWith(entry1,Constant.ttu))
		{
			//System.out.println(x + "ME:ttu - tu");
			s.pop();
			entry1 = ByteMeth.replace(entry1,Constant.tu,3);
			s.push(new Entry(entry1,-1));
			return true;
		}
		if(ByteMeth.endsWith(entry1,Constant.RRu))
		{
			//System.out.println(x + "ME:RRu - Ru");
			s.pop();
			entry1 = ByteMeth.replace(entry1,Constant.Ru,3);
			s.push(new Entry(entry1,-1));
			return true;
		}
		return false;
	}

	static void clitic(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if(BooleanMethod.isPronoun(topElmt))
			return;
		if(type2(s))
			return;
		if(type4(s))
			return;
		if(type5(s))
			return;
	}

	static void postposition(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		if(ByteMeth.isEqual(topElmt,Constant.athan) ||
			ByteMeth.isEqual(topElmt,Constant.ithan) ||
			ByteMeth.isEqual(topElmt,Constant.ethan))
		{
			euphonic_an(s);
		}
		else
		{
			euphonic_in(s);
		}
		if(type1(s))
			return;
		if(type2(s))
			return;
		if(type3(s))
			return;
		if(type4(s))
			return;
		if(type5(s))
			return;
	}

	static void check(Stack s)
	{
		//System.out.println(x + "Sandhi");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(ByteMeth.isEqual(topElmt,Constant.athan) ||
			ByteMeth.isEqual(topElmt,Constant.ithan) ||
			ByteMeth.isEqual(topElmt,Constant.ethan))
		{
			euphonic_an(s);
		}
		else
		{
			euphonic_in(s);
		}
		if(type1(s))
			return;
		if(type2(s))
			return;
		if(type3(s))
			return;
		if(type5(s))
			return;
		if(type4(s))
			return;
	}

	static boolean type1(Stack s)
	{
		//1 - aRRu
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(ByteMeth.endsWith(topElmt,Constant.vaRR))
		{
			//System.out.println(x + "type 1");
			s.pop();
			topElmt = ByteMeth.subArray(topElmt,0,
				topElmt.length-Constant.vaRR.length);
			s.push(new Entry(Constant.aRRu,Tag.Oblique));
			if(ByteMeth.isEqual(topElmt,Constant.ellA))
			{
				topElmt = ByteMeth.addArray(topElmt,Constant.m);
				s.push(new Entry(topElmt,Tag.Noun));
				return true;
			}
			s.push(new Entry(topElmt,-1,oldTopElmt));
		}
		return false;
	}

	static boolean type2(Stack s)
	{
		//2 - v,y sandhi
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(topElmt.length >= 2)
		{
			if(ByteMeth.endsWith(topElmt,Constant.y))
			{
				if(topElmt[topElmt.length-2] == Constant.i[0] ||
					topElmt[topElmt.length-2] == Constant.I[0] ||
					topElmt[topElmt.length-2] == Constant.E[0] ||
					topElmt[topElmt.length-2] == Constant.ai[0])
				{
					//System.out.println(x + "type 2a");
					s.pop();
					topElmt = ByteMeth.subArray(topElmt,0,
						topElmt.length-Constant.y.length);
					s.push(new Entry(Constant.y,Tag.Sandhi));
					s.push(new Entry(topElmt,-1,oldTopElmt));
					return true;
				}
			}
			else if(ByteMeth.endsWith(topElmt,Constant.v))
			{
				if(topElmt[topElmt.length-2] == Constant.a[0] ||
					topElmt[topElmt.length-2] == Constant.A[0] ||
					topElmt[topElmt.length-2] == Constant.u[0] ||
					topElmt[topElmt.length-2] == Constant.U[0] ||
					topElmt[topElmt.length-2] == Constant.O[0] ||
					topElmt[topElmt.length-2] == Constant.au[0])
				{
					//System.out.println(x + "type 2b");
					s.pop();
					topElmt = ByteMeth.subArray(topElmt,0,
						topElmt.length-Constant.v.length);
					s.push(new Entry(Constant.v,Tag.Sandhi));
					s.push(new Entry(topElmt,-1,oldTopElmt));
					return true;
				}
			}
		}
		return false;
	}

	static boolean type3(Stack s)
	{
		//3 - aththu
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(ByteMeth.endsWith(topElmt,Constant.athth))
		{
			//System.out.println(x + "type 3");
			s.pop();
			topElmt = ByteMeth.subArray(topElmt,0,
				topElmt.length-Constant.thth.length);
			topElmt = ByteMeth.addArray(topElmt,Constant.m);
			s.push(new Entry(Constant.aththu,Tag.Oblique));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}

	static boolean type4(Stack s)
	{
		//4 - add u
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(BooleanMethod.endsWith_type4_letter(topElmt))
		{
			//System.out.println(x + "type 4");
			s.pop();

			topElmt = ByteMeth.addArray(topElmt,Constant.u);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}

	static boolean type5(Stack s)
	{
		//5 - doubling
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		byte[] sandhi = BooleanMethod.endswith_doubling_Letter(topElmt);
		if(sandhi != null)
		{
			//System.out.println(x + "type 5");
			s.pop();
			topElmt = ByteMeth.subArray(topElmt,0,
				topElmt.length-sandhi.length);
			s.push(new Entry(sandhi,Tag.Sandhi));
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}

	//remove later
	static boolean type6(Stack s)
	{
		//6 - t - oblique
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(ByteMeth.endsWith(topElmt,Constant.tt))
		{
			//System.out.println(x + "type 6");
			s.pop();
			s.push(new Entry(Constant.t,Tag.Oblique));
			topElmt = ByteMeth.subArray(topElmt,0,
				topElmt.length-Constant.t.length);
			topElmt = ByteMeth.addArray(topElmt,Constant.u);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}

	static void kk(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(ByteMeth.endsWith(topElmt,Constant.kku))
		{
			//System.out.println(x + "kk");
			s.pop();
			s.push(new Entry(Constant.kk,Tag.Sandhi));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.kku.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
		}
	}

	static void kctp(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(!ByteMeth.endsWith(topElmt,Constant.Rk) &&
			!ByteMeth.endsWith(topElmt,Constant.ss) &&
			!ByteMeth.endsWith(topElmt,Constant.thth) &&
			!ByteMeth.endsWith(topElmt,Constant.pp) &&
			(ByteMeth.endsWith(topElmt,Constant.k)||
			ByteMeth.endsWith(topElmt,Constant.s)||
			ByteMeth.endsWith(topElmt,Constant.th)||
			ByteMeth.endsWith(topElmt,Constant.p)))
			{
				//System.out.println(x + "KCTP");
				s.pop();
				s.push(new Entry(new byte[]{topElmt[topElmt.length-1]},Tag.Sandhi));
				topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.k.length);
				s.push(new Entry(topElmt,-1,oldTopElmt));
			}
	}

	static void k(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(ByteMeth.endsWith(topElmt,Constant.k) &&
			!ByteMeth.endsWith(topElmt,Constant.Rk))
			{
				//System.out.println(x + "k");
				s.pop();
				s.push(new Entry(Constant.k,Tag.Sandhi));
				topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.k.length);
				s.push(new Entry(topElmt,-1,oldTopElmt));
			}
	}

	static void s(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(ByteMeth.endsWith(topElmt,Constant.s) &&
			!ByteMeth.endsWith(topElmt,Constant.ss))
			{
				//System.out.println(x + "s");
				s.pop();
				s.push(new Entry(Constant.s,Tag.Sandhi));
				topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.s.length);
				s.push(new Entry(topElmt,-1,oldTopElmt));
			}
	}

	static void th(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(ByteMeth.endsWith(topElmt,Constant.th) &&
			!ByteMeth.endsWith(topElmt,Constant.thth))
			{
				//System.out.println(x + "th");
				s.pop();
				s.push(new Entry(Constant.th,Tag.Sandhi));
				topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.th.length);
				s.push(new Entry(topElmt,-1,oldTopElmt));
			}
	}

	static void p(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(ByteMeth.endsWith(topElmt,Constant.p))
		{
			//System.out.println(x + "p");
			s.pop();
			s.push(new Entry(Constant.p,Tag.Sandhi));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.p.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
		}
	}
}
