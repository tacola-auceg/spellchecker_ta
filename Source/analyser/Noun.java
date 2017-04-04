package analyser;

import java.util.*;

public class Noun
{
	static String x = "";
	static TabConverter TC;
	static int c = 0;

	public static int check(Stack allStk, String inputString, boolean isRoot)
	{
		//System.out.println(x + "NOUN ANALYSER");
		boolean isNoun = false;

		c = 0;
		if(rule_c1(allStk,inputString,isRoot))
			isNoun = true;
		if(rule_c(allStk,inputString,isRoot))
			return c;

		if(rule_b(allStk,inputString))
			isNoun = true;
		if(rule_e(allStk,inputString))
			isNoun = true;
		if(rule_d(allStk,inputString))
			return c;

		if(rule_f(allStk,inputString))
			return c;

		return c;
	}

	//rule a <Noun/Pronoun/InterrogativeNoun+Clitic>
	public static boolean rule_a(Stack allStk, String inputString)
	{
		//System.out.println(x + "Rule a");

		Stack s = new Stack();
		s.push(new Entry(TC.convert(inputString),-1));
		Sandhi.kctp(s);

		if(Clitic.check(s))
		{
			c++;
			if(ADictionary.noun_Pronoun_InterrogativeNoun(s))
			{
				allStk.push(s);
				return true;
			}
		}
		return false;
	}

	//rule b <Postposition/Adverb+Clitic>
	public static boolean rule_b(Stack allStk, String inputString)
	{
		//System.out.println(x + "Rule b");

		Stack s = new Stack();
		s.push(new Entry(TC.convert(inputString),-1));
		Sandhi.kctp(s);

		if(Clitic.check(s))
		{
			c++;
			if(ADictionary.postposition(s))
			{
				allStk.push(s);
				return true;
			}
			c++;
			if(ADictionary.adverb(s))
			{
				allStk.push(s);
				return true;
			}
		}
		return false;
	}

	//rule c <Noun/Noun+Plural/Pronoun/InterrogativeNoun+Case+Postposition+Clitic>
	public static boolean rule_c(Stack allStk, String inputString,
		boolean isRoot)
	{
		//System.out.println(x + "Rule c");

		Stack s = new Stack();
		s.push(new Entry(TC.convert(inputString),-1));
		Sandhi.kctp(s);

		boolean anySuffixFound = false,
			hasSth = false;

		if(Clitic.check(s))
			hasSth = true;

		if(Postposition.check(s))
			hasSth = true;

		Stack originalStack = (Stack)s.clone();
		if(Case.check(s))
			anySuffixFound = true;

		if(anySuffixFound)
		{
			c++;
			if(ADictionary.noun_Pronoun_InterrogativeNoun(s))
			{
				allStk.push(s);
				return true;
			}
			if(Sandhi.handleException(s))
			{
				c++;
				if(ADictionary.noun_Pronoun_InterrogativeNoun(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}

		if(anySuffixFound && SingPluralMarker.check(s))
		{
			c++;
			if(ADictionary.noun(s))
			{
				allStk.push(s);
				return true;
			}
		}

		return false;
	}

	//rule c1 <Noun/Noun+Plural/Pronoun/InterrogativeNoun+Postposition+Clitic>
	public static boolean rule_c1(Stack allStk, String inputString,
		boolean isRoot)
	{
		//System.out.println(x + "Rule c1");

		Stack s = new Stack();
		s.push(new Entry(TC.convert(inputString),-1));
		Sandhi.kctp(s);

		boolean anySuffixFound = false;

		if(Clitic.check(s))
			anySuffixFound = true;

		if(Postposition.check(s))
			anySuffixFound = true;

		if(anySuffixFound)
		{
			c++;
			if(ADictionary.noun_Pronoun_InterrogativeNoun(s))
			{
				allStk.push(s);
				return true;
			}
			if(Sandhi.handleException(s))
			{
				c++;
				if(ADictionary.noun_Pronoun_InterrogativeNoun(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}

		if(SingPluralMarker.check(s))
		{
			c++;
			if(ADictionary.noun(s))
			{
				allStk.push(s);
				return true;
			}
		}

		return false;
	}

	//rule d <Noun/angu_ingu_engu+AdjSuffix+Pronominal+Plural+Case+Postposition+Clitic>
	public static boolean rule_d(Stack allStk, String inputString)
	{
		//System.out.println(x + "Rule d");

		Stack s = new Stack();
		s.push(new Entry(TC.convert(inputString),-1));
		Sandhi.kctp(s);

		boolean anySuffixFound = false,
			hasSth = false,
			pp = false;

		if(Clitic.check(s))
			hasSth = true;

		if(Postposition.check(s))
			pp = true;

		if(Case.check(s))
			hasSth = true;

		if(SingPluralMarker.check(s))
			hasSth = true;

		if(NounMisc.pronominal(s))
			anySuffixFound = true;

		if(NounMisc.adjective(s))
			anySuffixFound = true;

		if(pp)
		{
			if(NounMisc.angu_ingu_engu(s))//angku, ingku, engku
			{
				allStk.push(s);
				return true;
			}
		}
		if(anySuffixFound)
		{
			c++;
			if(ADictionary.noun(s))
			{
				allStk.push(s);
				return true;
			}
			if(NounMisc.angu_ingu_engu(s))//angku, ingku, engku
			{
				allStk.push(s);
				return true;
			}
			if(Sandhi.handleException(s))
			{
				c++;
				if(ADictionary.noun(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}

		if(SingPluralMarker.check(s))
		{
			c++;
			if(ADictionary.noun(s))
			{
				allStk.push(s);
				return true;
			}
		}
		return false;
	}

	//rule e <Noun/Noun+Plural/Pronoun/InterrogativeNoun+AdvSuffix/FiniteVerb+Clitic>
	public static boolean rule_e(Stack allStk, String inputString)
	{
		//System.out.println(x + "Rule e");

		Stack s = new Stack();
		s.push(new Entry(TC.convert(inputString),-1));
		Sandhi.kctp(s);

		boolean anySuffixFound = false,
			hasClitic = false;

		if(Clitic.check(s))
			hasClitic = true;

		if(NounMisc.adverb(s))
			anySuffixFound = true;

		if(NounMisc.finiteVerb(s))
			anySuffixFound = true;

		if(anySuffixFound)
		{
			c++;
			if(ADictionary.noun_Pronoun_InterrogativeNoun(s))
			{
				allStk.push(s);
				return true;
			}
			if(SingPluralMarker.check(s))
			{
				c++;
				if(ADictionary.noun(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}
		return false;
	}

	//rule f <Noun/Pronoun/InterrogativeNoun+Case+AdjSuffix>
	public static boolean rule_f(Stack allStk, String inputString)
	{
		//System.out.println(x + "Rule f");

		Stack s = new Stack();
		s.push(new Entry(TC.convert(inputString),-1));
		Sandhi.kctp(s);

		boolean hasAdj = false,
			hasCase = false;

		if(NounMisc.adjective(s))
			hasAdj = true;

		if(Case.check(s))
			hasCase = true;

		if(hasAdj && hasCase)
		{
			c++;
			if(ADictionary.noun_Pronoun_InterrogativeNoun(s))
			{
				allStk.push(s);
				return true;
			}
			if(Sandhi.handleException(s))
			{
				c++;
				if(ADictionary.noun_Pronoun_InterrogativeNoun(s))
				{
					allStk.push(s);
					return true;
				}
			}
		}
		return false;
	}
}
