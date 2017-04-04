package analyser;

import java.util.Stack;
public class BooleanMethod
{
	static ByteMeth ByteMeth;
	static TabConverter TC;

	//for noun
	static 	boolean is_akku_Pronoun(byte[] topElmt)
	{
		if(ByteMeth.isEqual(topElmt,Constant.en))
			return true;
		if(ByteMeth.isEqual(topElmt,Constant.than))
			return true;
		if(ByteMeth.isEqual(topElmt,Constant.un))
			return true;
		if(ByteMeth.isEqual(topElmt,Constant.em))
			return true;
		if(ByteMeth.isEqual(topElmt,Constant.tham))
			return true;
		if(ByteMeth.isEqual(topElmt,Constant.um))
			return true;
		if(ByteMeth.isEqual(topElmt,Constant.n_am))
			return true;
		return false;
	}

	static 	boolean endsWith_Adjective(byte[] topElmt)
	{
		for(int i=0; i < Constant.ADJECTIVE.length; i++)
			if(ByteMeth.endsWith(topElmt,Constant.ADJECTIVE[i]))
				return true;
		return false;
	}

	static 	boolean isObliquePronoun(byte[] topElmt)
	{
		for(int i=0; i < Constant.OBLIQUE_PRONOUN.length; i++)
			if(ByteMeth.isEqual(topElmt,Constant.OBLIQUE_PRONOUN[i]))
				return true;
		return false;
	}

	static 	boolean isPronoun(byte[] topElmt)
	{
		for(int i=0; i < Constant.PRONOUN.length; i++)
			if(ByteMeth.isEqual(topElmt,Constant.PRONOUN[i]))
				return true;
		return false;
	}

	static byte[] endswith_doubling_Letter(byte[] topElmt)
	{
		for(int i=0; i < Constant.DOUBLING_LETTER.length; i++)
			if(ByteMeth.endsWith(topElmt,ByteMeth.addArray(Constant.DOUBLING_LETTER[i],
					Constant.DOUBLING_LETTER[i])))
			{
				return Constant.DOUBLING_LETTER[i];
			}
		return null;
	}

	static boolean endsWith_type4_letter(byte[] topElmt)
	{
		if(ByteMeth.endsWith(topElmt,Constant.k))
			return true;
		if(ByteMeth.endsWith(topElmt,Constant.s))
			return true;
		if(ByteMeth.endsWith(topElmt,Constant.t))
			return true;
		if(ByteMeth.endsWith(topElmt,Constant.p))
			return true;
		if(ByteMeth.endsWith(topElmt,Constant.v))
			return true;
		if(ByteMeth.endsWith(topElmt,Constant.th))
			return true;
		if(ByteMeth.endsWith(topElmt,Constant.R))
			return true;
		return false;
	}

	static byte[] endsWith_Clitic_1_verb(byte[] topElmt)
	{
		for(int i=0; i < Constant.CLITIC_1.length; i++)
			if(ByteMeth.endsWith(topElmt,Constant.CLITIC_1[i]) &&
				!ByteMeth.endsWith(topElmt,Constant.idaiyE) &&
				!ByteMeth.endsWith(topElmt,Constant.kuRukkE) &&
				!ByteMeth.endsWith(topElmt,Constant.n_aduvE) &&
				!ByteMeth.endsWith(topElmt,Constant.pinnE) &&
				!ByteMeth.endsWith(topElmt,Constant.munnE) &&
				!ByteMeth.endsWith(topElmt,Constant.pO) &&
				!ByteMeth.endsWith(topElmt,Constant.vA) &&
				!ByteMeth.endsWith(topElmt,Constant.thA) &&
				!ByteMeth.endsWith(topElmt,Constant.kIzE))
			{
				return Constant.CLITIC_1[i];
			}
		return null;
	}

	static byte[] endsWith_Clitic_1_noun(byte[] topElmt)
	{
		for(int i=0; i < Constant.CLITIC_1.length; i++)
			if(ByteMeth.endsWith(topElmt,Constant.CLITIC_1[i]) &&
				!ByteMeth.endsWith(topElmt,Constant.idaiyE) &&
				!ByteMeth.endsWith(topElmt,Constant.kuRukkE) &&
				!ByteMeth.endsWith(topElmt,Constant.n_aduvE) &&
				!ByteMeth.endsWith(topElmt,Constant.pinnE) &&
				!ByteMeth.endsWith(topElmt,Constant.munnE))
			{
				return Constant.CLITIC_1[i];
			}
		return null;
	}

	static byte[] endsWith_Clitic_2_verb(byte[] topElmt)
	{
		for(int i=0; i < Constant.CLITIC_2.length; i++)
			if(ByteMeth.endsWith(topElmt,Constant.CLITIC_2[i]) &&
				!ByteMeth.endsWith(topElmt,Constant.ththAn) &&
				!ByteMeth.endsWith(topElmt,Constant.n_thAn))
			{
				return Constant.CLITIC_2[i];
			}
		return null;
	}

	static byte[] endsWith_Clitic_2_noun(byte[] topElmt)
	{
		for(int i=0; i < Constant.CLITIC_2.length; i++)
			if(ByteMeth.endsWith(topElmt,Constant.CLITIC_2[i]))
			{
				return Constant.CLITIC_2[i];
			}
		return null;
	}

	static byte[] endsWith_Clitic_3(byte[] topElmt)
	{
		for(int i=0; i < Constant.CLITIC_3.length; i++)
			if(ByteMeth.endsWith(topElmt,Constant.CLITIC_3[i]))
			{
				return Constant.CLITIC_3[i];
			}
		return null;
	}

	static byte[] endsWith_Clitic_4(byte[] topElmt)
	{
		for(int i=0; i < Constant.CLITIC_4.length; i++)
			if(ByteMeth.endsWith(topElmt,Constant.CLITIC_4[i]))
			{
				return Constant.CLITIC_4[i];
			}
		return null;
	}

	static byte[] endsWith_Clitic_5(byte[] topElmt)
	{
		for(int i=0; i < Constant.CLITIC_5.length; i++)
			if(ByteMeth.endsWith(topElmt,Constant.CLITIC_5[i]))
			{
				return Constant.CLITIC_5[i];
			}
		return null;
	}

	static byte[] endsWith_Clitic_6(byte[] topElmt)
	{
		for(int i=0; i < Constant.CLITIC_6.length; i++)
			if(ByteMeth.endsWith(topElmt,Constant.CLITIC_6[i]) &&
				!ByteMeth.endsWith(topElmt,Constant.mattum) &&
				!ByteMeth.endsWith(topElmt,Constant.ennum) &&
				!ByteMeth.endsWith(topElmt,Constant.Akilum) &&
				!ByteMeth.endsWith(topElmt,Constant.Ayinum ))
			{
				return Constant.CLITIC_6[i];
			}
		return null;
	}

	static byte[] endsWith_Clitic_7(byte[] topElmt)
	{
		for(int i=0; i < Constant.CLITIC_7.length; i++)
			if(ByteMeth.endsWith(topElmt,Constant.CLITIC_7[i]))
			{
				return Constant.CLITIC_7[i];
			}
		return null;
	}

	static byte[] endsWith_Clitic_8(byte[] topElmt)
	{
		for(int i=0; i < Constant.CLITIC_8.length; i++)
			if(ByteMeth.endsWith(topElmt,Constant.CLITIC_8[i]))
			{
				if(!ByteMeth.endsWith(topElmt,Constant.pati))
					return Constant.CLITIC_8[i];
			}
		return null;
	}

	//for verb
	static boolean endsWith_PastTMHuman_Al(byte[] topElmt)
	{
	 	for( int i=0;i<Constant.PAST_TM_HUMAN.length;i++)
			if(ByteMeth.before_endswith(topElmt,Constant.PAST_TM_HUMAN[i],Constant.Al))
				return true;
		return false;
	}

	//general
	static boolean is_y_take_Vowel(byte b)
	{
		if(b == Constant.i[0] ||
			b == Constant.I[0] ||
			b == Constant.E[0] ||
			b == Constant.ai[0])
				return true;
		return false;
	}

	static boolean is_v_take_Vowel(byte b)
	{
		if(b == Constant.A[0] ||
			b == Constant.u[0] ||
			b == Constant.U[0] ||
			b == Constant.O[0] ||
			b == Constant.au[0])
				return true;
		return false;
	}
}
