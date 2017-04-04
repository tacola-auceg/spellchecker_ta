package analyser;

import java.util.*;

public class Verb
{
	static String x = "";
	static Stack originalStack;
	static Stack originalStack1;
	static TabConverter TC;

	public static boolean check(Stack allStk, String inputString)
	{
		//System.out.println(x + "VERB ANALYSER");

		Stack s = new Stack();
		s.push(new Entry(TC.convert(inputString),-1));
		Sandhi.kctp(s);

		//ISM - tA, ti
		originalStack = (Stack)s.clone();
		if(VerbMisc.imperativeSingular1(s))
		{
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			else
				Misc.backTrack(originalStack,s);
		}

		//ISM - utA, uti
		originalStack = (Stack)s.clone();
		if(VerbMisc.imperativeSingular2(s))
		{
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			else
				Misc.backTrack(originalStack,s);
		}

		//IPM1 - unkaL
		originalStack = (Stack)s.clone();
		if(VerbMisc.imperativePlural1(s))
		{
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			else
				Misc.backTrack(originalStack,s);
		}

		//IPM2 - nkaL
		originalStack = (Stack)s.clone();
		if(VerbMisc.imperativePlural2(s))
		{
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			else
				Misc.backTrack(originalStack,s);
		}

		//Clitic
		if(Clitic.verb(s))
		{
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
		}

		originalStack = (Stack)s.clone();
		if(VerbMisc.pronominal(s))
		{
			if(RelativeParticiple.check(s))
			{
				if(Tense.check(s))
				{
					if(ADictionary.verb(s))
					{
						allStk.push(s);
						return true;
					}
				}
			}
		}
		Misc.backTrack(originalStack,s);

		//Finite Verb
		if(VerbMisc.finiteVerb(s))
		{
			originalStack = (Stack)s.clone();
			if(Infinity.check(s))
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			Misc.backTrack(originalStack,s);
		}

		//Auxiliary Verb
		originalStack = (Stack)s.clone();
		if(AuxiliaryVerb.check(s))
		{
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
		}
		Misc.backTrack(originalStack,s);

		//umpati
		if(VerbMisc.umpadi(s))
		{
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
		}

		//Infinitive + endings
		originalStack = (Stack)s.clone();
		if(Infinity.infinitive_Ends(s))
		{
			if(Infinity.check(s))
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			else
				Misc.backTrack(originalStack,s);
		}

		//Past Tense + Cond. Al
		if(VerbMisc.pastTM_Al(s))
		{
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
		}

		//PNG
		if(PNG.check(s))
		{
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			//Tense
			else if(Tense.check(s))
			{
				if(ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
				//Auxiliary verb
				else
				{
					originalStack = (Stack)s.clone();
					if(AuxiliaryVerb.check(s))
					{
						if(ADictionary.verb(s))
						{
							allStk.push(s);
							return true;
						}
					}
					Misc.backTrack(originalStack,s);
				}
			}
			//mAtt
			else if(Infinity.mAtt(s))
			{
				if(Infinity.check(s))
				if(ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}

		//Infinitive
		originalStack = (Stack)s.clone();
		if(Infinity.check(s))
		if(ADictionary.verb(s))
		{
			allStk.push(s);
			return true;
		}
		Misc.backTrack(originalStack,s);

		//RP
		originalStack = (Stack)s.clone();
		if(RelativeParticiple.check(s))
		{
			originalStack1 = (Stack)s.clone();
			Infinity.check(s);
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
			else
				Misc.backTrack(originalStack1,s);
			if(Tense.check(s))
			{
				if(ADictionary.verb(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}
		Misc.backTrack(originalStack,s);

		//VP
		if(VerbalParticiple.check(s))
		{
			if(ADictionary.verb(s))
			{
				allStk.push(s);
				return true;
			}
		}

		return false;
	}
}
