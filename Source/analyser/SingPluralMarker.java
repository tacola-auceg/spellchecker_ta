package analyser;

import java.util.Stack;

//Plural and Singular MArker
public class SingPluralMarker
{
	static ByteMeth ByteMeth;
	static String x = "";

	static boolean check(Stack s)
	{
		//System.out.println(x + "SingPluralMarker");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;

		//1
		if(!ByteMeth.endsWith(((Entry)s.peek()).getPart(),Constant.nAyanmArkaL) &&
			!ByteMeth.isEqual(((Entry)s.peek()).getPart(),Constant.mArkaL) &&
			!ByteMeth.endsWith(((Entry)s.peek()).getPart(),Constant.sumArkaL) &&
			ByteMeth.endsWith(((Entry)s.peek()).getPart(),Constant.mArkaL))
		{
			//System.out.println(x + "mArkaL");
			s.pop();
			s.push(new Entry(Constant.mArkaL,Tag.Plural));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.mArkaL.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//2
		if(ByteMeth.endsWith(((Entry)s.peek()).getPart(),Constant.mAr))
		{
			//System.out.println(x + "mAr");
			s.pop();
			s.push(new Entry(Constant.mAr,Tag.SingularPlural));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.mAr.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		//3
		if(ByteMeth.endsWith(((Entry)s.peek()).getPart(),Constant.kkaL))
		{
			//System.out.println(x + "kkaL");
			s.pop();
			s.push(new Entry(Constant.kkaL,Tag.Plural));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.kkaL.length);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		if(ByteMeth.endsWith(((Entry)s.peek()).getPart(),Constant.kaL))
		{
			//System.out.println(x + "kaL");
			s.pop();
			s.push(new Entry(Constant.kaL,Tag.Plural));
			topElmt = ByteMeth.subArray(topElmt,0,topElmt.length-Constant.kaL.length);
			//ng to m
			if(ByteMeth.endsWith(topElmt,Constant.ng))
				topElmt = ByteMeth.addArray(ByteMeth.subArray(topElmt,0,topElmt.length-1),Constant.m);
			//t to L
			else if(ByteMeth.endsWith(topElmt,Constant.t))
				topElmt = ByteMeth.addArray(ByteMeth.subArray(topElmt,0,topElmt.length-1),Constant.L);
			//R to l
			else if(ByteMeth.endsWith(topElmt,Constant.R))
				topElmt = ByteMeth.addArray(ByteMeth.subArray(topElmt,0,topElmt.length-1),Constant.l);
			s.push(new Entry(topElmt,-1,oldTopElmt));
			return true;
		}
		return false;
	}
}
