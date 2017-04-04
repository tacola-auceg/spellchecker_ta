package analyser;

import java.util.Stack;

public class Clitic
{
	static ByteMeth ByteMeth;
	static String x = "";

	static byte rule[][] =
						{
							//8
							{7,3,2,1,8},
							{7,2,1,8},
							{7,3,1,8},
							{6,2,1,8},
							{5,2,1,8},
							{3,2,1,8},
							{3,4,1,8},
							{3,7,1,8},
							{7,1,8},
							{7,2,8},
							{7,3,8},
							{6,1,8},
							{6,2,8},
							{5,1,8},
							{5,2,8},
							{3,1,8},
							{3,4,8},
							{3,5,8},
							{3,7,8},
							{3,2,8},
							{2,1,8},
							{3,8},
							{5,8},
							{3,8},
							{2,8},
							{1,8},
							{8},

							//1
							{7,3,2,1},
							{6,5,2,1},
							{3,5,2,1},
							{3,5,3,1},
							{3,5,6,1},
							{3,5,7,1},
							{7,2,1},
							{7,3,1},
							{6,2,1},
							{6,5,1},
							{5,6,1},
							{5,7,1},
							{3,2,1},
							{3,4,1},
							{3,5,1},
							{5,2,1},
							{5,3,1},
							{3,7,1},
							{2,1},
							{3,1},
							{4,1},
							{5,1},
							{6,1},
							{7,1},
							{1},

							//2
							{7,3,2},
							{6,5,2},
							{3,5,2},
							{7,2},
							{6,2},
							{5,2},
							{3,2},
							{1,2}, //1 after 2
							{2},

							//3
							{3,5,3},
							{7,3},
							{5,3},
							{1,3},	//coz adA also endsWith A
							{3},

							//5
							{6,5},
							{3,5},
							{5},

							//6
							{3,5,6},
							{5,6},
							{6},

							//4
							{3,4},
							{4},

							//7
							{3,5,7},
							{5,7},
							{3,7},
							{7},


						};

	static Stack originalStk;
	public static boolean check(Stack s)
	{
		//System.out.println(x + "Clitic");
		for(int i=0;i<rule.length;i++)
		{
			originalStk = (Stack)s.clone();
			int cRIndex = 0;
			byte currentRule[] = new byte[rule[i].length];

			byte[] topElmt = ((Entry)s.peek()).getPart();
			byte[] oldTopElmt = topElmt;
			for(int j=rule[i].length-1;j>=0;j--)
			{
				switch(rule[i][j])
				{
					case 1:
						if(clitic_1(s,true))
						{
							currentRule[cRIndex] = 1;
							cRIndex++;
						}
						break;
					case 2:
						if(clitic_2(s,true))
						{
							currentRule[cRIndex] = 2;
							cRIndex++;
						}
						break;
					case 3:
						if(clitic_3(s))
						{
							currentRule[cRIndex] = 3;
							cRIndex++;
						}
						break;
					case 4:
						if(clitic_4(s))
						{
							currentRule[cRIndex] = 4;
							cRIndex++;
						}
						break;
					case 5:
						if(clitic_5(s))
						{
							currentRule[cRIndex] = 5;
							cRIndex++;
						}
						break;
					case 6:
						if(clitic_6(s))
						{
							currentRule[cRIndex] = 6;
							cRIndex++;
						}
						break;
					case 7:
						if(clitic_7(s))
						{
							currentRule[cRIndex] = 7;
							cRIndex++;
						}
						break;
					case 8:
						if(clitic_8(s))
						{
							currentRule[cRIndex] = 8;
							cRIndex++;
						}
						break;
				};
			}
			Misc.reverse(currentRule);
			if(ByteMeth.isEqual(rule[i],currentRule))
			{
				return true;
			}
			else
			{
				Misc.backTrack(originalStk,s);
			}
		}
		return false;
	}

	//verb
	static boolean verb(Stack s)
	{
		if(clitic_1(s,false))
			return true;
		if(clitic_2(s,false))
			return true;
		if(clitic_3(s))
			return true;
		if(clitic_4(s))
			return true;
		if(clitic_5(s))
			return true;
		//no um
		if(clitic_7(s))
			return true;
		if(clitic_8(s))
			return true;
		return false;
	}

	//A,O,E
	static boolean clitic_1(Stack s,boolean noun)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		byte[] clitic = null;
		if(noun)
			clitic = BooleanMethod.endsWith_Clitic_1_noun(topElmt);
		else
			clitic = BooleanMethod.endsWith_Clitic_1_verb(topElmt);
		if(clitic != null)
		{
			//System.out.println(x + "Clitic 1 - A");
			s.pop();
			s.push(new Entry(clitic,Tag.Clitic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-clitic.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.clitic(s);
			return true;
		}
		return false;
	}

	//thAn
	static boolean clitic_2(Stack s,boolean noun)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		byte[] clitic = null;
		if(noun)
			clitic = BooleanMethod.endsWith_Clitic_2_noun(topElmt);
		else
			clitic = BooleanMethod.endsWith_Clitic_2_verb(topElmt);
		if(clitic != null)
		{
			//System.out.println(x + "Clitic 2 - thAn");
			s.pop();
			s.push(new Entry(clitic,Tag.Clitic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-clitic.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.th(s);
			return true;
		}
		return false;
	}

	//mattum
	static boolean clitic_3(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		byte[] clitic = BooleanMethod.endsWith_Clitic_3(topElmt);
		if(clitic != null)
		{
			//System.out.println(x + "Clitic 3 - mattum");
			s.pop();
			s.push(new Entry(clitic,Tag.Clitic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-clitic.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.clitic(s);
			return true;
		}
		return false;
	}

	//ennum
	static boolean clitic_4(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		byte[] clitic = BooleanMethod.endsWith_Clitic_4(topElmt);
		if(clitic != null)
		{
			//System.out.println(x + "Clitic 4 - ennum");
			s.pop();
			s.push(new Entry(clitic,Tag.Clitic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-clitic.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.clitic(s);
			return true;
		}
		return false;
	}

	//kUda
	static boolean clitic_5(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		byte[] clitic = BooleanMethod.endsWith_Clitic_5(topElmt);
		if(clitic != null)
		{
			//System.out.println(x + "Clitic 5 - kUda");
			s.pop();
			s.push(new Entry(clitic,Tag.Clitic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-clitic.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.k(s);
			return true;
		}
		return false;
	}

	//um
	static boolean clitic_6(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(ByteMeth.endsWith(topElmt,Constant.irukkattum) ||
			ByteMeth.endsWith(topElmt,Constant.Akum) ||
			ByteMeth.endsWith(topElmt,Constant.kAttilum))
			return false;

		byte[] clitic = BooleanMethod.endsWith_Clitic_6(topElmt);
		if(clitic != null)
		{
			//System.out.println(x + "Clitic 6 - um");
			s.pop();
			s.push(new Entry(clitic,Tag.Clitic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-clitic.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.clitic(s);
			return true;
		}
		return false;
	}

	//Avathu
	static boolean clitic_7(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		byte[] clitic = BooleanMethod.endsWith_Clitic_7(topElmt);
		if(clitic != null)
		{
			//System.out.println(x + "Clitic 7 - Avathu");
			s.pop();
			s.push(new Entry(clitic,Tag.Clitic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-clitic.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.clitic(s);
			return true;
		}
		return false;
	}

	//aDA
	static boolean clitic_8(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		byte[] clitic = BooleanMethod.endsWith_Clitic_8(topElmt);
		if(clitic != null)
		{
			//System.out.println(x + "Clitic 8 - aDA");
			s.pop();
			s.push(new Entry(clitic,Tag.Clitic));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.
				length-clitic.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			Sandhi.clitic(s);
			return true;
		}
		return false;
	}
}
