package analyser;

import java.util.Stack;
import java.util.Vector;

public class ADictionary
{
	static ByteMeth ByteMeth;
	static TabConverter TC;
	static String x = "";
	static String y = "";

	//initialise dictionary
	static BTree Noun_BTree = new BTree();
	static BTree Verb_BTree = new BTree();
	static BTree Adjective_BTree = new BTree();
	static BTree Adverb_BTree = new BTree();
	static BTree Particle_BTree = new BTree();
	static BTree Neg_Finite_Verb_BTree = new BTree();
	static BTree Conjuntion_BTree = new BTree();
	static BTree Interjection_BTree = new BTree();
	static BTree Interrogative_BTree = new BTree();
	static BTree Interrogative_Adj_BTree = new BTree();
	static BTree Demo_Adj_BTree = new BTree();
	static BTree Finite_Verb_BTree = new BTree();
	static BTree Postposition_BTree = new BTree();
	static BTree Intensifier_BTree = new BTree();
	static BTree m_End_Noun_BTree = new BTree();

	//load dictionary in memory
	static
	{
		Verb_BTree.updateDictTree("Dictionary/Verb_vi.txt");
		Noun_BTree.updateDictTree("Dictionary/Noun_pe.txt");
		Adjective_BTree.updateDictTree("Dictionary/Adjective_pe_a.txt");
		Adverb_BTree.updateDictTree("Dictionary/Adverb_vi_a.txt");
		Particle_BTree.updateDictTree("Dictionary/Particle_i_so.txt");
		Postposition_BTree.updateDictTree("Dictionary/Postposition_sollurubu.txt");
		Neg_Finite_Verb_BTree.updateDictTree("Dictionary/Neg_Finite_Verb_e_v_mu.txt");
		Conjuntion_BTree.updateDictTree("Dictionary/Conjuction_i_i_so.txt");
		Interjection_BTree.updateDictTree("Dictionary/Interjection_vi_i_so.txt");
		Interrogative_BTree.updateDictTree("Dictionary/Interrogative_Noun_vi_pe.txt");
		Interrogative_Adj_BTree.updateDictTree("Dictionary/Interrogative_Adj_vi_pe_a.txt");
		Demo_Adj_BTree.updateDictTree("Dictionary/Demon_Adjective_su_pe_a.txt");
		Finite_Verb_BTree.updateDictTree("Dictionary/Finite_Verb_vi_mu.txt");

		Intensifier_BTree.updateDictTree("Dictionary/Intensifier.txt");
		m_End_Noun_BTree.updateDictTree("Dictionary/m_End_Noun.txt");
	}

	public static void reloadDic()
	{
		System.out.println("Reloading Dictionary...");

		Verb_BTree.makeEmpty();
		Noun_BTree.makeEmpty();
		Adjective_BTree.makeEmpty();
		Adverb_BTree.makeEmpty();
		Particle_BTree.makeEmpty();
		Postposition_BTree.makeEmpty();
		Neg_Finite_Verb_BTree.makeEmpty();
		Conjuntion_BTree.makeEmpty();
		Interjection_BTree.makeEmpty();
		Interrogative_BTree.makeEmpty();
		Interrogative_Adj_BTree.makeEmpty();
		Demo_Adj_BTree.makeEmpty();
		Finite_Verb_BTree.makeEmpty();
		Intensifier_BTree.makeEmpty();
		m_End_Noun_BTree.makeEmpty();

		Verb_BTree.updateDictTree("Dictionary/Verb_vi.txt");
		Noun_BTree.updateDictTree("Dictionary/Noun_pe.txt");
		Adjective_BTree.updateDictTree("Dictionary/Adjective_pe_a.txt");
		Adverb_BTree.updateDictTree("Dictionary/Adverb_vi_a.txt");
		Particle_BTree.updateDictTree("Dictionary/Particle_i_so.txt");
		Postposition_BTree.updateDictTree("Dictionary/Postposition_sollurubu.txt");
		Neg_Finite_Verb_BTree.updateDictTree("Dictionary/Neg_Finite_Verb_e_v_mu.txt");
		Conjuntion_BTree.updateDictTree("Dictionary/Conjuction_i_i_so.txt");
		Interjection_BTree.updateDictTree("Dictionary/Interjection_vi_i_so.txt");
		Interrogative_BTree.updateDictTree("Dictionary/Interrogative_Noun_vi_pe.txt");
		Interrogative_Adj_BTree.updateDictTree("Dictionary/Interrogative_Adj_vi_pe_a.txt");
		Demo_Adj_BTree.updateDictTree("Dictionary/Demon_Adjective_su_pe_a.txt");
		Finite_Verb_BTree.updateDictTree("Dictionary/Finite_Verb_vi_mu.txt");

		Intensifier_BTree.updateDictTree("Dictionary/Intensifier.txt");
		m_End_Noun_BTree.updateDictTree("Dictionary/m_End_Noun.txt");
	}

	public static boolean check(Stack allStk, String inputString)
	{
		//System.out.println(x + "Dictionary");

		Stack s2 = new Stack();
		s2.push(new Entry(TC.convert(inputString),-1));
		Sandhi.kctp(s2);
		allStk.push(s2);

		Stack s1 = (Stack)allStk.pop();
		byte[] topElmt = ((Entry)s1.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		String input = TC.revert(topElmt);

		boolean found = false;
		if(BooleanMethod.isPronoun(topElmt))
		{
			//System.out.println(x + "Pronoun");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(topElmt,Tag.Pronoun));
			allStk.push(s);
			found = true;
		}
		if(BooleanMethod.isObliquePronoun(topElmt))
		{
			//System.out.println(x + "Oblique Pronoun");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(topElmt,Tag.ObliquePronoun));
			allStk.push(s);
			found = true;
		}
		if(Demo_Adj_BTree.contains(input))
		{
			//System.out.println(x + "Demo Adj");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.DemonstrativeAdjective));
			allStk.push(s);
			found = true;
		}
		if(Neg_Finite_Verb_BTree.contains(input))
		{
			//System.out.println(x + "NegFiniteVerb");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.NegFiniteVerb));
			allStk.push(s);
			found = true;

		}
		if(Finite_Verb_BTree.contains(input))
		{
			//System.out.println(x + "Finite Verb");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.FiniteVerb));
			allStk.push(s);
			found = true;

		}
		if(Interjection_BTree.contains(input))
		{
			//System.out.println(x + "Interjection");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.Interjection));
			allStk.push(s);
			found = true;

		}
		if(Interrogative_BTree.contains(input))
		{
			//System.out.println(x + "InterrogativeNoun");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.InterrogativeNoun));
			allStk.push(s);
			found = true;
		}
		if(Interrogative_Adj_BTree.contains(input))
		{
			//System.out.println(x + "InterrogativeAdj");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.InterrogativeAdj));
			allStk.push(s);
			found = true;
		}
		if(Conjuntion_BTree.contains(input))
		{
			//System.out.println(x + "IIS");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.Conjunction));
			allStk.push(s);
			found = true;
		}
		if(Adjective_BTree.contains(input))
		{
			//System.out.println(x + "ADJ");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.Adjective));
			allStk.push(s);
			found = true;

		}
		if(Intensifier_BTree.contains(input))
		{
			//System.out.println(x + "Intensifier");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.Intensifier));
			allStk.push(s);
			found = true;
		}

		if(Particle_BTree.contains(input))
		{
			//System.out.println(x + "Particle");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.Particle));
			allStk.push(s);
			found = true;
		}
		if(Postposition_BTree.contains(input))
		{
			//System.out.println(x + "Postposition");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.Postposition));
			allStk.push(s);
			found = true;
		}
		if(Verb_BTree.contains(input))
		{
			//System.out.println(x + "Verb");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.Verb));
			allStk.push(s);
			found = true;
		}
		if(Adverb_BTree.contains(input))
		{
			//System.out.println(x + "Adverb");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.Adverb));
			allStk.push(s);
			found = true;
		}

		if(m_End_Noun_BTree.contains(input))
		{
			//System.out.println(x + "m_End_Noun");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.Adjective));
			allStk.push(s);
			found = true;
		}

		if(Noun_BTree.contains(input))
		{
			//System.out.println(x + "Noun");
 			Stack s = (Stack)s1.clone();
 			s.pop();
			s.push(new Entry(TC.convert(input),
				Tag.Noun));
			allStk.push(s);
			found = true;
		}
		if(!found)
		{
			return false;
		}
		return true;
	}

	public static boolean noun_Pronoun_InterrogativeNoun(Stack s)
	{
		String x = "";
		//System.out.println(x + "Noun/Pronoun/Interrogative Noun");
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(Noun_BTree.contains(TabConverter.revert(topElmt)))
		{
			//System.out.println(x + "Noun");
			s.push(new Entry(((Entry)s.pop()).getPart(),Tag.Noun));
			return true;
		}
		if(BooleanMethod.isPronoun(topElmt))
		{
			//System.out.println(x + "Pronoun");
			s.push(new Entry(((Entry)s.pop()).getPart(),Tag.Pronoun));
			return true;
		}
		if(BooleanMethod.isObliquePronoun(topElmt))
		{
			//System.out.println(x + "Oblique Pronoun");
			s.push(new Entry(((Entry)s.pop()).getPart(),Tag.ObliquePronoun));
			return true;
		}
		if(Interrogative_BTree.contains(TabConverter.revert(topElmt)))
		{
			//System.out.println(x + "Interrogative Noun");
			s.push(new Entry(((Entry)s.pop()).getPart(),Tag.InterrogativeNoun));
			return true;
		}
		return false;
	}

	public static boolean postposition(Stack s)
	{
		String x = "";
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(Postposition_BTree.contains(TabConverter.revert(topElmt)))
		{
			//System.out.println(x + "Postposition");
			s.push(new Entry(((Entry)s.pop()).getPart(),Tag.Postposition));
			return true;
		}
		return false;
	}

	public static boolean noun(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(Noun_BTree.contains(TabConverter.revert(topElmt)))
		{
			//System.out.println(x + "Noun");
			s.push(new Entry(((Entry)s.pop()).getPart(),Tag.Noun));
			return true;
		}
		return false;
	}

	//Adverb
	public static boolean adverb(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(Adverb_BTree.contains(TabConverter.revert(topElmt)))
		{
			//System.out.println(x + "Adverb");
			s.push(new Entry(((Entry)s.pop()).getPart(),Tag.Adverb));
			return true;
		}
		return false;
	}

	//Verb
	public static boolean verb(Stack s)
	{
		byte[] topElmt = ((Entry)s.peek()).getPart();
		byte[] oldTopElmt = topElmt;
		if(Verb_BTree.contains(TabConverter.revert(topElmt)))
		{
			//System.out.println(x + "Verb");
			s.push(new Entry(((Entry)s.pop()).getPart(),Tag.Verb));
			return true;
		}
		return false;
	}

}
