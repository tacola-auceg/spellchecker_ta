package SpellChecker;

/************************Analyzer for Verb ***********************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.System;
import java.util.Stack;
import java.io.*;
import java.sql.*;
import analyser.*;

public class verb extends JFrame implements ActionListener
    {

		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage(".\\gif.GIF");
		Dimension dim = tk.getScreenSize();
		double d1 = dim.getHeight();

		double d2 = dim.getWidth();
		static JComboBox tf1 = new JComboBox();
		static JTextArea tf2 = new JTextArea(10,20);
		Font f=new Font("TAB-Anna",4,18);
		static JButton but = new JButton("Ok");
		static JButton but1=new JButton("Exit");
		static JPanel p1=new JPanel();
		static JPanel p2= new JPanel();
		static JPanel p3= new JPanel();
		static JScrollPane scrollpane=new JScrollPane(tf2);


        static ByteMeth ByteMeth=new ByteMeth();
     	static Stack s=new Stack();
		static byte[] thth = tabconvert2.convert("î¢î¢");
		static byte[] im=tabconvert2.convert("ñ¢");
		static byte[] ink=tabconvert2.convert("é¢");
		static byte[] odu=tabconvert2.convert("æ´");
		static byte[] odu1 = {11,18,5};
        	static byte aal[]=tabconvert2.convert("Ý÷¢");
		static byte aan[]=tabconvert2.convert("Ýù¢");
		static byte aar[]={2,25};

		static byte adaa[]={1,18,2};static byte adi[]={1,18,3};static byte ae[]={8};
		static byte kal[]={14,1,29};static byte thaan[]={20,2,31};
		static byte avan[]={1,27,1,31};static byte aval1[]={1,27,1,29};
		static byte avar[]={1,27,1,25};static byte avai[]={1,27,9};
		static byte um[]={5,23};static byte iru[]={3,25,5};

		static byte ein[]={8,31};static byte om[]={11,23};
		static byte ana[]={1,31,1};static byte adhu[]={1,20,5};static byte aai[]={2,24};//static byte um[]={2,24};
		static byte aarkal[]={2,25,14,1,29};static byte eerkal[]={4,25,14,1,29};static byte al[]={2,26};
		static byte a[]={1};static byte aa[]={2};static byte ka[]={14,1};static byte e[]={3};static byte u[]={5};
		static byte thal[]={20,1,26};static byte ththal[]={20,20,1,26};
		static byte kir[]={14,3,30};static byte kiru[]={14,3,30,5};static byte kindr[]={14,3,31,30};static byte kindru[]={14,3,31,30,5};
		static byte kkir[]={14,14,3,30};static byte kkiru[]={14,14,3,30,5};
		static byte kkindr[]={14,14,3,31,30};static byte kkindru[]={14,14,3,31,30,5};
		static byte kond[]={14,10,19,18};static byte vidu[]={27,3,18,5};
		static byte kooda[]={14,6,18,1};static byte ai[]={9};
		static byte poyirru[]={22,11,24,3,30,30,5};static byte aayirru[]={2,24,3,30,30,5};
		static byte theer[]={20,4,25};static byte kattu[]={14,1,18,18,5};

public verb()
	{
			super("Morphological Analyser v1");
			tf1.setFont(f);
			setSize(700,400);
			//tf1.setSize(80,800);
			setIconImage(img);
			setLocation(((int)d2-700)/2,((int)d1-400)/2);

			tf2.setFont(f);
			p1.add(tf1);
			p3.add(but);p3.add(but1);
			tf1.setEditable(true);
			tf1.addItem("");
			tf1.addItem("ð®î¢î¤¼è¢è¤ø£ù¢");
			tf1.addItem("Ü®î¢¶è¢ªè£í¢®¼è¢è¤ø£ù¢");
			tf1.addItem("Ìì¢®õ¤ì¢ì£ó¢");
			tf1.addItem("ê¤ó¤î¢¶è¢ªè£í¢®¼è¢è¤ø£ù¢");
			tf1.addItem("ªêò¢¶ªè£í¢®¼ï¢îõ¬ù»ñ¢");
			tf1.addItem("ê¤ó¤î¢¶è¢ªè£í¢®¼ï¢îõ¬÷»ñ¢Ãì");
			tf1.addItem("ªêò¢¶ªè£í¢®¼ï¢îõó¢è¬÷»ñ¢Ãìî¢î£«ùòì£");
			but.addActionListener(this);
			but1.addActionListener(this);
			getContentPane().add(p1,"North");
			getContentPane().add(scrollpane,"Center");
			getContentPane().add(p3,"South");
			show();
		    	addWindowListener(new WindowAdapter()
			 {
				public void windowClosing(WindowEvent e)
				 {
					System.exit(1);
				 }
			 });

	  }


public static void sete(String str)
{
	System.out.println("str in settext : "+str);
	tf1.addItem(str);

}
   public void actionPerformed(ActionEvent ae)
   {
			if(ae.getSource()==but1)
				System.exit(1);
			if(ae.getSource()==but)
              {
					tf2.setText("");
					String str1=((String)tf1.getSelectedItem()).trim();
					/*String str1=tstr;
					tf1.removeAllItems();
					tf1.addItem(str1);*/

					checkverb(str1);
					String temp1="";
					while (!s.empty())
						temp1=temp1+(s.pop().toString())+"\n";
					tf2.append(temp1);
					//int len4=temp1.length();
					//String temp2=temp1.substring(0,len4);
					//Spchkverb.text2.setText("     "+temp2);
					//tf2.append(temp2);
					//tf2.append(" "+temp2);

					//System.out.println("stack content :" + temp2);

		   		}

}

public static Stack checkverb(String str1)
   {
		ByteMeth ByteMeth=new ByteMeth();
		System.out.println("string in checkverb : " + str1);
		String temp1="";
		byte h[]=tabconvert2.convert(str1);
		//System.out.println("string in checkverb : " + tabconvert2.revert(h));
		if(checkAdaaAdi(h))  /********new******************/
			return s;
		if(checkAe(h))
			return s;
		if(checkThaan(h))
			return s;
		if(checkKooda(h))
			return s;
		if(checkAi(h))
			return s;
		if(checkUm(h))
			return s;
		if(checkPoyirru(h))
			return s;
		if(checkAayirru(h))
			return s;
		if(checkTheer(h))
			return s;
		if(checkVidu(h))
			return s;
		if(checkKattu(h))
			return s;
		if(checkIru(h))
			return s;
		if(checkaalaan(h))
		{
			System.out.println("i am inside  check verb's checkaalaan");
			return s;
		}
		else if(checkKa(h))
		{
			System.out.println("i am inside  check verb's checkKa");
			return s;
		}
		else if(checkE(h))
		{
			System.out.println("i am inside  check verb's checkE");
			return s;
		}
		else if(checkU(h))
		{
			System.out.println("i am inside  check verb's checkU");
			return s;
		}
		else if(checkA(h))
		{
			System.out.println("i am inside  check verb's checkA");
			return s;
		}
		else if(checkThal(h))
		{
			System.out.println("i am inside  check verb's checkThal");
			return s;
		}
		/*else if(checkaa(h))
		{
			System.out.println("i am inside checkverb's checkaa"+ str1);
			return s;
		}*/

		else
		{
			try
			{   String spchk;
				System.out.println("checkverb's i am in call to Spellchecker");
				spchk = Spchkverb.checker(tabconvert2.revert(h));
				System.out.println("checkverb's sugg in checkall :" + spchk);
				byte k[]=tabconvert2.convert(spchk);
				checkaalaan(h);
			}
			catch(Exception e)
			{
				System.out.println("exception");
 				e.printStackTrace();
			}
		}

		return s;
   }
  /* public static Stack checkagain(String strin)
   {

   	ByteMeth ByteMeth=new ByteMeth();
   	byte h[]=tabconvert2.convert(strin);
   	if(checkaalaan(h)){
   	System.out.println("entered checkaalaan of checkagain");
   		return s;}
   	else if(checktenses1(h)){
    System.out.println("entered checktenses of checkagain");
		return s;}

   	else if(checkaa(h)){
   	System.out.println("entered checkaa of checkagain");
   		return s;}
    else
   		{
   			Stack st=checkverb(strin);
   			return st;
   		}

	} // end of function checkagain*/

 /*public static boolean checkaa(byte [] s1)
   {
		if(ByteMeth.endsWith(s1,aa))
		{
		   byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
		   byte a[]=ByteMeth.subArray(s1,0,(s1.length-aa.length));
		   s.push("\n"+tabconvert2.revert(r)+"(Question Marker)");
		   checkaalaan(a);
		   return(true);
		 }
		 else
		 return(false);
   }*/

public static boolean checkKa(byte [] s1)
	{
		byte t[]={18},l1[]={29},k[]={14};
		if(ByteMeth.endsWith(s1,ka))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-ka.length,s1.length);
			byte a1[]=ByteMeth.subArray(s1,0,(s1.length-ka.length));
			if(ByteMeth.isEqual(a1,tabconvert2.convert("ï")))
				return false;
			if(ByteMeth.endsWith(a1,t))
			{
				a1 = ByteMeth.subArray(a1,0,a1.length-1);
				a1 = ByteMeth.addArray(a1,l1);
			}
			if(ByteMeth.endsWith(a1,k))  // for the case : ï¦è¢è
				return false;
			s.push("\n"+tabconvert2.revert(r)+" < õ¤òé¢«è£÷¢ õ¤¬ùºø¢Á õ¤°î¤ > ");
			s.push("\n"+tabconvert2.revert(a1)+"(õ¤¬ù)");
			return true;
		}
		else
			return false;
	}	// end of function checkKa

public static boolean checkE(byte [] s1)
	{
		byte u[]={5},ll[]={26};
		if(ByteMeth.endsWith(s1,e))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			if(ByteMeth.endsWith(a,ll))
				a = ByteMeth.subArray(a,0,a.length-1);
			else
				a = ByteMeth.addArray(a,u);
			s.push("\n"+tabconvert2.revert(r)+" < õ¤¬ùªòê¢ê õ¤°î¤ > ");
			s.push("\n"+tabconvert2.revert(a)+"(õ¤¬ù)");
			return true;
		}
		else
			return false;
	}	// end of function checkE

public static boolean checkU(byte [] s1)
	{
		byte nthth[]={21,20},thth[]={20,20},ll[]={26},r1[],a1[];
		if(ByteMeth.endsWith(s1,u))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			s.push("\n"+tabconvert2.revert(r)+" < õ¤¬ùªòê¢ê õ¤°î¤ > ");
			if(checktenses(a,u))
				return true;
			else
				return false;
		}
		else
			return false;
	}	// end of function checkU

public static boolean checkA(byte [] s1)
	{
		byte ll[]={26,26},k[]={14},p[]={22};
		if(ByteMeth.endsWith(s1,a))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a1[]=ByteMeth.subArray(s1,0,(s1.length-1));
			if(ByteMeth.endsWith(a1,p))
			{
				a1 = ByteMeth.addArray(a1,u);
				s.push("\n"+tabconvert2.revert(r)+" < õ¤¬ùªòê¢ê õ¤°î¤ > ");
				s.push("\n"+tabconvert2.revert(a1)+" < õ¤¬ù > ");
				return true;
			}
			else if(checktenses1(a1,a))
			{
				return true;
			}
			else
			{
				s.push("\n"+tabconvert2.revert(r)+" < õ¤¬ùªòê¢ê õ¤°î¤ > ");
				if(ByteMeth.endsWith(a1,k))
					a1 = ByteMeth.addArray(a1,u);
				if(ByteMeth.endsWith(a1,ll))
					a1 = ByteMeth.subArray(a1,0,a1.length-1);
				s.push("\n"+tabconvert2.revert(a1)+" < õ¤¬ù > ");
				return true;
			}
		}
		else
			return false;
	}	// end of function checkA


public static boolean checkThal(byte [] s1)
	{
		byte nthth[]={21,20},thth[]={20,20},ll[]={26},r[],a[];
		if(ByteMeth.endsWith(s1,ththal))
		{
			r=ByteMeth.subArray(s1,s1.length-ththal.length,s1.length);
			a=ByteMeth.subArray(s1,0,(s1.length-ththal.length));
			s.push("\n"+tabconvert2.revert(r)+" ( ªî£ö¤ø¢ªðòó¢ õ¤°î¤ ) ");
			s.push("\n"+tabconvert2.revert(a)+" ( õ¤¬ù ) ");
			return true;
		}
		else if(ByteMeth.endsWith(s1,thal))
		{
			r=ByteMeth.subArray(s1,s1.length-thal.length,s1.length);
			a=ByteMeth.subArray(s1,0,(s1.length-thal.length));
			s.push("\n"+tabconvert2.revert(r)+" ( ªî£ö¤ø¢ªðòó¢ õ¤°î¤ ) ");
			s.push("\n"+tabconvert2.revert(a)+" ( õ¤¬ù ) ");
			return true;
		}
		else
			return false;
	}	// end of function checkThal


public static boolean checkKal(byte [] h)
	{

		if((h.length > kal.length)&&ByteMeth.endsWith(h,kal))
		{
			byte plural[]=ByteMeth.subArray(h,h.length-3,h.length);
			byte rem[]=ByteMeth.subArray(h,0,h.length-3);
			s.push("\n"+tabconvert2.revert(plural)+" ( ðù¢¬ñ ) ");
			if(checkaalaan(rem))
				return true;
			else
				return false;
		}
		else
			return false;
	} // end of function checkKal


public static boolean checkAi(byte [] h)
	{

		if((h.length > ai.length)&&ByteMeth.endsWith(h,ai))
		{
			byte caseMarker[]=ByteMeth.subArray(h,h.length-1,h.length);
			byte rem[]=ByteMeth.subArray(h,0,h.length-1);
			s.push("\n"+tabconvert2.revert(caseMarker)+" < «õø¢Á¬ñ à¼¹ > ");
			if(checkKal(rem))
				return true;
			checkaalaan(rem);
			return true;
		}
		else
			return false;
	} // end of function checkAi


public static boolean checkUm(byte [] h)   /*****new***/
	{
		byte y[]={24};
		if((h.length > um.length)&&ByteMeth.endsWith(h,um))
		{
			byte clitic[]=ByteMeth.subArray(h,h.length-2,h.length);
			byte rem[]=ByteMeth.subArray(h,0,h.length-2);
			s.push("\n"+tabconvert2.revert(clitic)+" < Þ¬ìê¢ªê£ô¢ > ");
			if(ByteMeth.endsWith(rem,y))
				rem = ByteMeth.subArray(rem,0,rem.length-1);
			if(checkKal(rem))
				return true;
			if(checkAi(rem))
				return true;
			checkaalaan(rem);
			return true;
		}
		else
			return false;
	} // end of function checkUm


public static boolean checkKooda(byte [] h)   /*****new***/
	{
		byte y[]={24},k[]={14};
		if((h.length > kooda.length)&&ByteMeth.endsWith(h,kooda))
		{
			byte clitic[]=ByteMeth.subArray(h,h.length-kooda.length,h.length);
			byte rem[]=ByteMeth.subArray(h,0,h.length-kooda.length);
			s.push("\n"+tabconvert2.revert(clitic)+" < Þ¬ìê¢ªê£ô¢ > ");
			if(ByteMeth.endsWith(rem,k))
				rem = ByteMeth.subArray(rem,0,rem.length-1);
			if(checkUm(rem))
				return true;
			if(checkAi(rem))
				return true;
			checkaalaan(rem);
			return true;
		}
		else
			return false;
	} // end of function checkKooda


public static boolean checkAe(byte [] h)   /*****new***/
	{
		byte y[]={24},k[]={14},iv[]={27};
		if((h.length > ae.length)&&ByteMeth.endsWith(h,ae))
		{
			byte clitic[]=ByteMeth.subArray(h,h.length-1,h.length);
			byte rem[]=ByteMeth.subArray(h,0,h.length-1);
			s.push("\n"+tabconvert2.revert(clitic)+" < Þ¬ìê¢ªê£ô¢ > ");
			if(ByteMeth.endsWith(rem,y)||ByteMeth.endsWith(rem,iv))
				rem = ByteMeth.subArray(rem,0,rem.length-1);
			if(checkKooda(rem))
				return true;
			if(checkThaan(rem))
				return true;
			if(checkUm(rem))
				return true;
			if(checkKal(rem))
				return true;
			if(checkAi(rem))
				return true;
			checkaalaan(rem);
			return true;
		}
		else
			return false;
	} // end of function checkAe



public static boolean checkAdaaAdi(byte [] h)   /*****new***/
	{
		byte y[]={24},k[]={14};
		if((h.length > adaa.length)&&(ByteMeth.endsWith(h,adaa)||ByteMeth.endsWith(h,adi)))
		{
			byte clitic[]=ByteMeth.subArray(h,h.length-adaa.length,h.length);
			byte rem[]=ByteMeth.subArray(h,0,h.length-adaa.length);
			s.push("\n"+tabconvert2.revert(clitic)+" < Þ¬ìê¢ªê£ô¢ > ");
			if(ByteMeth.endsWith(rem,y))
				rem = ByteMeth.subArray(rem,0,rem.length-1);
			if(checkAe(rem))
				return true;
			if(checkThaan(rem))
				return true;
			if(checkUm(rem))
				return true;
			if(checkAi(rem))
				return true;
			checkaalaan(rem);
			return true;
		}
		else
			return false;
	} // end of function checkAdaaAdi


	public static boolean checkThaan(byte [] h)   /*****new***/
		{
			byte th[]={20},iv[]={27};
			if((h.length > thaan.length)&&ByteMeth.endsWith(h,thaan))
			{
				byte clitic[]=ByteMeth.subArray(h,h.length-thaan.length,h.length);
				byte rem[]=ByteMeth.subArray(h,0,h.length-thaan.length);
				s.push("\n"+tabconvert2.revert(clitic)+" < Þ¬ìê¢ªê£ô¢ > ");
				if(ByteMeth.endsWith(rem,th)||ByteMeth.endsWith(rem,iv))
					rem = ByteMeth.subArray(rem,0,rem.length-1);
				if(checkAe(rem))
					return true;
				if(checkKooda(rem))
					return true;
				if(checkUm(rem))
					return true;
				if(checkKal(rem))
					return true;
				if(checkAi(rem))
					return true;
				checkaalaan(rem);
				return true;
			}
			else
				return false;
	} // end of function checkThaan



public static boolean checkPoyirru(byte [] s1)   /*****updated***/
	{
		byte p[]={22};
		if(s1.length < poyirru.length)
			return false;
		else if(ByteMeth.endsWith(s1,poyirru))
		{
			byte suffix[]=ByteMeth.subArray(s1,s1.length-poyirru.length,s1.length);
			byte rem[]=ByteMeth.subArray(s1,0,s1.length-poyirru.length);
			s.push("\n"+tabconvert2.revert(suffix)+" < ¶¬íõ¤¬ù > ");
			if(ByteMeth.endsWith(rem,p))
				rem = ByteMeth.subArray(rem,0,rem.length-1);
			if(checkVbp(rem))
				return true;
			else
			{
				s.push("\n"+tabconvert2.revert(rem)+" (õ¤¬ù) ");
				return true;
			}
		}
		else
			return false;

	}	// end of function checkPoyirru



	public static boolean checkAayirru(byte [] s1)   /*****updated***/
		{
			byte p[]={22};
			if(s1.length < aayirru.length)
				return false;
			else if(ByteMeth.endsWith(s1,aayirru))
			{
				byte suffix[]=ByteMeth.subArray(s1,s1.length-aayirru.length,s1.length);
				byte rem[]=ByteMeth.subArray(s1,0,s1.length-aayirru.length);
				s.push("\n"+tabconvert2.revert(suffix)+" < ¶¬íõ¤¬ù > ");
				if(ByteMeth.endsWith(rem,p))
					rem = ByteMeth.subArray(rem,rem.length-1,rem.length);
				if(checkVbp(rem))
					return true;
				else
				{
					s.push("\n"+tabconvert2.revert(rem)+" (õ¤¬ù) ");
					return true;
				}
			}
			else
				return false;

		}	// end of function checkAayirru



public static boolean checkaalaan(byte [] s1)
	{
		String suffix=" ";
		byte ththu[]={20,20,5},nththu[]={21,20,5},nthth[]={21,20},thu[]={20,5},aamal[]={2,23,1,26};
		byte e[]={3},y[]={24},yy[]={24,24},va[]={27,1},th[]={20},pp[]={22,22},kk[]={14,14};
		if(s1.length <= 2)
			return false;
		if((s1.length > eerkal.length)&&(ByteMeth.endsWith(s1,aal)	||ByteMeth.endsWith(s1,al)||ByteMeth.endsWith(s1,adhu)
		||ByteMeth.endsWith(s1,avan)||ByteMeth.endsWith(s1,aval1)||ByteMeth.endsWith(s1,avar)||ByteMeth.endsWith(s1,avai)
		||ByteMeth.endsWith(s1,aan)||ByteMeth.endsWith(s1,ein)||ByteMeth.endsWith(s1,om)||ByteMeth.endsWith(s1,ana)
		||ByteMeth.endsWith(s1,aai)||ByteMeth.endsWith(s1,um)||ByteMeth.endsWith(s1,aar)||ByteMeth.endsWith(s1,aarkal)||ByteMeth.endsWith(s1,eerkal)))
		{
				System.out.println("Entered checkaalaan");
			    byte r[]=ByteMeth.subArray(s1,s1.length-2,s1.length);
			    byte a[]=ByteMeth.subArray(s1,0,(s1.length-2));
				if(ByteMeth.endsWith(s1,al))
					s.push("\n"+tabconvert2.revert(r)+" < ðìó¢è¢¬è ªðí¢ð£ô¢ å¼¬ñ > ");
				if(ByteMeth.endsWith(s1,aai))
					s.push("\n"+tabconvert2.revert(r)+" < Üçø¤¬í > ");
				if(ByteMeth.endsWith(s1,aal))
					s.push("\n"+tabconvert2.revert(r)+" < ðìó¢è¢¬è ªðí¢ð£ô¢ å¼¬ñ >");
				if(ByteMeth.endsWith(s1,aan))
					s.push("\n"+tabconvert2.revert(r)+" < ðìó¢è¢¬è Ýí¢ð£ô¢ å¼¬ñ > ");
				if(ByteMeth.endsWith(s1,ein))
					s.push("\n"+tabconvert2.revert(r)+" < îù¢¬ñ å¼¬ñ õ¤¬ùºø¢Á õ¤°î¤> ");
				if(ByteMeth.endsWith(s1,om))
					s.push("\n"+tabconvert2.revert(r)+" < îù¢¬ñ ðù¢¬ñ > ");
				if(ByteMeth.endsWith(s1,um))
					s.push("\n"+tabconvert2.revert(r)+" < Üçø¤¬í > ");
				if(ByteMeth.endsWith(s1,aar))
					s.push("\n"+tabconvert2.revert(r)+" < àòó¢ð£ô¢  >");
				if(ByteMeth.endsWith(s1,avan)) /**********new****************/
				{
					r=ByteMeth.subArray(s1,s1.length-avan.length,s1.length);
			        a=ByteMeth.subArray(s1,0,(s1.length-avan.length));
					s.push("\n"+tabconvert2.revert(r)+" < ²ì¢´ªðòó¢ > ");
				}
				if(ByteMeth.endsWith(s1,avar)) /**********new****************/
				{
					r=ByteMeth.subArray(s1,s1.length-avar.length,s1.length);
					a=ByteMeth.subArray(s1,0,(s1.length-avar.length));
					s.push("\n"+tabconvert2.revert(r)+" < ²ì¢´ªðòó¢ > ");
				}
				if(ByteMeth.endsWith(s1,aval1)) /**********new****************/
				{
					r=ByteMeth.subArray(s1,s1.length-aval1.length,s1.length);
					a=ByteMeth.subArray(s1,0,(s1.length-aval1.length));
					s.push("\n"+tabconvert2.revert(r)+" < ²ì¢´ªðòó¢ > ");
				}
				if(ByteMeth.endsWith(s1,avai)) /**********new****************/
				{
					r=ByteMeth.subArray(s1,s1.length-avai.length,s1.length);
					a=ByteMeth.subArray(s1,0,(s1.length-avai.length));
					s.push("\n"+tabconvert2.revert(r)+" < ²ì¢´ªðòó¢ > ");
				}
				if((s1.length > aarkal.length)&&(ByteMeth.endsWith(s1,aarkal)||ByteMeth.endsWith(s1,eerkal)))
				{
						r=ByteMeth.subArray(s1,s1.length-5,s1.length);
						a=ByteMeth.subArray(s1,0,(s1.length-5));
						if(ByteMeth.endsWith(s1,eerkal))
							s.push("\n"+tabconvert2.revert(r)+" < 2nd psn singular > ");
						if(ByteMeth.endsWith(s1,aarkal))
							s.push("\n"+tabconvert2.revert(r)+" < 3rd psn plural > ");
				}
				if((s1.length > ana.length)&&(ByteMeth.endsWith(s1,ana)||ByteMeth.endsWith(s1,adhu)))
				{
						r=ByteMeth.subArray(s1,s1.length-3,s1.length);
						a=ByteMeth.subArray(s1,0,(s1.length-3));
						if(ByteMeth.endsWith(s1,ana))
							s.push("\n"+tabconvert2.revert(r)+" (nueter plural)");
						if(ByteMeth.endsWith(s1,adhu))
							s.push("\n"+tabconvert2.revert(r)+"(nueter singular)");
				}
				if(checktenses(a,tabconvert2.convert(suffix)))
				{
					if(checkAuxIru())
						return true;
					else if(checkAuxVidu())
						return true;
					else if(checkAuxKattu())
						return true;
					else if(checkAuxTheer())
						return true;
					else
						return false;

				}
				else
					return false;
		}
		else
			return false;

	}

public static boolean checkAuxIru()/****new*****/
 {

		String temp1=s.pop().toString();
		int verbindex = temp1.indexOf("(õ¤¬ù"); /**up**/

		if(verbindex!= -1)
		{
			String verb = temp1.substring(1,verbindex-1).trim();
			byte byteVerb[] = tabconvert2.convert(verb);
			if(checkIru(byteVerb))
				return true;
			/*if((byteVerb.length > iru.length)&&ByteMeth.endsWith(byteVerb,iru))
			{
				byte auxVerb[]=ByteMeth.subArray(byteVerb,byteVerb.length-iru.length,byteVerb.length);
				byte mainVerb[]=ByteMeth.subArray(byteVerb,0,(byteVerb.length-iru.length));
				s.push("\n"+tabconvert2.revert(auxVerb)+" (¶¬íõ¤¬ù)");
				if(ByteMeth.endsWith(mainVerb,y))
					mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
				if(ByteMeth.endsWith(mainVerb,ae))
				{
					mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
					s.push("\n"+tabconvert2.revert(ae)+" (Þ¬ìê¢ªê£ô¢)");
				}
				if(checkAuxVerb2(mainVerb))
					return true;
				else
					checkVbp(mainVerb);
					return true;
			}*/
			else
			{
				s.push(temp1);
				return false;
			}
		}
		else
		{
			s.push(temp1);
			return false;
		}
 }	// end of function checkAuxIru



 public static boolean checkIru(byte[] byteVerb) /****new*****/
   {
 		byte ththu[]={20,20,5},nththu[]={21,20,5},nthth[]={21,20},thu[]={20,5},aamal[]={2,23,1,26};
		byte ae[]={8},e[]={3},y[]={24},yy[]={24,24},va[]={27,1},th[]={20},pp[]={22,22},kk[]={14,14},r[]={25};
 		if((byteVerb.length > iru.length)&&ByteMeth.endsWith(byteVerb,iru))
		{
			byte auxVerb[]=ByteMeth.subArray(byteVerb,byteVerb.length-iru.length,byteVerb.length);
			byte mainVerb[]=ByteMeth.subArray(byteVerb,0,(byteVerb.length-iru.length));
			s.push("\n"+tabconvert2.revert(auxVerb)+" (¶¬íõ¤¬ù)");
			if(ByteMeth.endsWith(mainVerb,y))
				mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
			if(ByteMeth.endsWith(mainVerb,ae))
			{
				mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
				s.push("\n"+tabconvert2.revert(ae)+" (Þ¬ìê¢ªê£ô¢)");
			}
			if(checkAuxVerb2(mainVerb))
				return true;
			else
				checkVbp(mainVerb);
			return true;
		}
 		else
 			return false;

  }	// end of function checkIru


 public static boolean checkAuxVerb2(byte[] Verb) /****new*****/
  {
 	 	byte ththu[]={20,20,5},nththu[]={21,20,5},nthth[]={21,20},thu[]={20,5},aamal[]={2,23,1,26};
 		byte e[]={3},y[]={24},yy[]={24,24},va[]={27,1},th[]={20},pp[]={22,22},kk[]={14,14},k[]={14},r[]={25};
 		if((Verb.length > kond.length)&&ByteMeth.endsWith(Verb,kond))
 		{
 			System.out.println("Auxverb2");
 			byte auxVerb[]=ByteMeth.subArray(Verb,Verb.length-kond.length,Verb.length);
 			auxVerb = ByteMeth.addArray(auxVerb,u);
 			byte mainVerb[]=ByteMeth.subArray(Verb,0,(Verb.length-kond.length));
			s.push("\n"+tabconvert2.revert(auxVerb)+" (¶¬íõ¤¬ù)");
			if(ByteMeth.endsWith(mainVerb,k))
				mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
			checkVbp(mainVerb);
			return true;
		}
		else
			return false;

   }	// end of function checkAuxVerb2


public static boolean checkAuxVidu() /****new*****/
  {
 	 	byte ththu[]={20,20,5},nththu[]={21,20,5},nthth[]={21,20},thu[]={20,5},aamal[]={2,23,1,26};
		byte ae[]={8},e[]={3},y[]={24},yy[]={24,24},va[]={27,1},th[]={20},pp[]={22,22},kk[]={14,14},r[]={25};
		String temp1=s.pop().toString();
		int verbindex = temp1.indexOf("(õ¤¬ù");
		if(verbindex!= -1)
		{
			String Verb = temp1.substring(1,verbindex-1).trim();
			System.out.println("verb :"+ Verb);
			byte byteVerb[] = tabconvert2.convert(Verb);
			String verb1 = tabconvert2.revert(byteVerb);
			if(checkVidu(byteVerb))
				return true;
			else
			{
				s.push(temp1);
				return false;
			}
		}
		else
		{
			s.push(temp1);
			return true;
		}

   }	// end of function checkAuxVerb3


public static boolean checkVidu(byte[] byteVerb) /****new*****/
  {
		if((byteVerb.length > vidu.length)&&ByteMeth.endsWith(byteVerb,vidu))
		{
			System.out.println("checkVidu");
			byte auxVerb[]=ByteMeth.subArray(byteVerb,byteVerb.length-vidu.length,byteVerb.length);
			byte mainVerb[]=ByteMeth.subArray(byteVerb,0,(byteVerb.length-vidu.length));
			s.push("\n"+tabconvert2.revert(auxVerb)+" (¶¬íõ¤¬ù)");
			checkVbp(mainVerb);
			checkAuxTheer();
			checkAuxKattu();
			return true;
		}
		else
			return false;

  }	// end of function checkVidu



public static boolean checkAuxTheer() /****new*****/
  {
 	 	byte ththu[]={20,20,5},nththu[]={21,20,5},nthth[]={21,20},thu[]={20,5},aamal[]={2,23,1,26};
		byte ae[]={8},e[]={3},y[]={24},yy[]={24,24},va[]={27,1},th[]={20},pp[]={22,22},kk[]={14,14},r[]={25};
		String temp1=s.pop().toString();
		int verbindex = temp1.indexOf("(õ¤¬ù");
		if(verbindex!= -1)
		{
			String Verb = temp1.substring(1,verbindex-1).trim();
			byte byteVerb[] = tabconvert2.convert(Verb);
			String verb1 = tabconvert2.revert(byteVerb);
			if(checkTheer(byteVerb))
				return true;
			else
			{
				s.push(temp1);
				return false;
			}
		}
		else
		{
			s.push(temp1);
			return true;
		}

   }	// end of function checkAuxTheer

public static boolean checkTheer(byte[] str) /****new*****/
 {
		byte th[]={20};
		if((str.length > theer.length)&&ByteMeth.endsWith(str,theer))
		{
			System.out.println("checkTheer");
			byte auxVerb[]=ByteMeth.subArray(str,str.length-theer.length,str.length);
			byte mainVerb[]=ByteMeth.subArray(str,0,(str.length-theer.length));
			s.push("\n"+tabconvert2.revert(auxVerb)+" (¶¬íõ¤¬ù)");
			if(ByteMeth.endsWith(mainVerb,th))
				mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
			checkVbp(mainVerb);
			return true;
		}
		else
			return false;
}	// end of function checkTheer


public static boolean checkAuxKattu() /****new*****/
  {
 	 	byte ththu[]={20,20,5},nththu[]={21,20,5},nthth[]={21,20},thu[]={20,5},aamal[]={2,23,1,26};
		byte ae[]={8},e[]={3},y[]={24},yy[]={24,24},va[]={27,1},th[]={20},pp[]={22,22},kk[]={14,14},r[]={25};
		String temp1=s.pop().toString();
		int verbindex = temp1.indexOf("(õ¤¬ù");
		if(verbindex!= -1)
		{
			System.out.println("checkAuxKattu");
			String Verb = temp1.substring(1,verbindex-1).trim();
			byte byteVerb[] = tabconvert2.convert(Verb);
			String verb1 = tabconvert2.revert(byteVerb);
			if(checkKattu(byteVerb))
				return true;
			else
			{
				s.push(temp1);
				return false;
			}
		}
		else
		{
			s.push(temp1);
			return true;
		}

   }	// end of function checkAuxKatttu


public static boolean checkKattu(byte[] str) /****new*****/
 {
		byte k[]={14};
		if((str.length > kattu.length)&&ByteMeth.endsWith(str,kattu))
		{
			System.out.println("checkKattu");
			byte auxVerb[]=ByteMeth.subArray(str,str.length-kattu.length,str.length);
			byte mainVerb[]=ByteMeth.subArray(str,0,(str.length-kattu.length));
			s.push("\n"+tabconvert2.revert(auxVerb)+" (¶¬íõ¤¬ù)");
			if(ByteMeth.endsWith(mainVerb,k))
				mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
			checkVbp(mainVerb);
			return true;
		}
		else
			return false;
}	// end of function checkKattu


public static boolean checkVbp(byte[] mainVerb) /****new*****/
{
 	 	byte ththu[]={20,20,5},nththu[]={21,20,5},nthth[]={21,20},thu[]={20,5},aamal[]={2,23,1,26};
 		byte e[]={3},y[]={24},yy[]={24,24},va[]={27,1},th[]={20},pp[]={22,22};
 		byte kk[]={14,14},k[]={14},r[]={25},ll[]={26,26};

		if(ByteMeth.endsWith(mainVerb,y))
		{
			byte verbPart[]=ByteMeth.subArray(mainVerb,mainVerb.length-1,mainVerb.length);
			mainVerb=ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
			if(ByteMeth.endsWith(mainVerb,e))
			{
				mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
				if(ByteMeth.endsWith(mainVerb,ll))
					mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
				else
					mainVerb = ByteMeth.addArray(mainVerb,u);
			}
			s.push("\n"+tabconvert2.revert(verbPart)+" (õ¤¬ùªòê¢êñ¢)");
			s.push("\n"+tabconvert2.revert(mainVerb)+" (õ¤¬ù)");
			return true;
		}
		if(ByteMeth.endsWith(mainVerb,e))
		{
			byte verbPart[]=ByteMeth.subArray(mainVerb,mainVerb.length-1,mainVerb.length);
			mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
			if((mainVerb.length > ll.length)&&ByteMeth.endsWith(mainVerb,ll))
				mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
			else
				mainVerb = ByteMeth.addArray(mainVerb,u);
			s.push("\n"+tabconvert2.revert(verbPart)+" (õ¤¬ùªòê¢êñ¢)");
			s.push("\n"+tabconvert2.revert(mainVerb)+" (õ¤¬ù)");
			return true;
		}
		if((mainVerb.length > ththu.length)&&(ByteMeth.endsWith(mainVerb,ththu)||ByteMeth.endsWith(mainVerb,nththu)))
		{
			byte verbPart[]=ByteMeth.subArray(mainVerb,mainVerb.length-3,mainVerb.length);
			mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-3);
			if(ByteMeth.isEqual(mainVerb,va))
				mainVerb = tabconvert2.convert("õ£");
			s.push("\n"+tabconvert2.revert(verbPart)+" (õ¤¬ùªòê¢êñ¢)");
			s.push("\n"+tabconvert2.revert(mainVerb)+" (õ¤¬ù)");
			return true;
		}
		if((mainVerb.length > ththu.length)&&(ByteMeth.endsWith(mainVerb,thth)||ByteMeth.endsWith(mainVerb,nthth)))
		{
			byte verbPart[]=ByteMeth.subArray(mainVerb,mainVerb.length-2,mainVerb.length);
			verbPart = ByteMeth.addArray(verbPart,u);
			mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-2);
			if(ByteMeth.isEqual(mainVerb,va))
				mainVerb = tabconvert2.convert("õ£");
			s.push("\n"+tabconvert2.revert(verbPart)+" (õ¤¬ùªòê¢êñ¢)");
			s.push("\n"+tabconvert2.revert(mainVerb)+" (õ¤¬ù)");
			return true;
		}
		if((mainVerb.length > ththu.length)&&ByteMeth.endsWith(mainVerb,thu))
		{
			byte verbPart[]=ByteMeth.subArray(mainVerb,mainVerb.length-thu.length,mainVerb.length);
			mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-2);
			s.push("\n"+tabconvert2.revert(verbPart)+" (õ¤¬ùªòê¢êñ¢)");
			s.push("\n"+tabconvert2.revert(mainVerb)+" (õ¤¬ù)");
			return true;
		}
		if(ByteMeth.endsWith(mainVerb,th))
		{
			byte verbPart[]=ByteMeth.subArray(mainVerb,mainVerb.length-1,mainVerb.length);
			verbPart = ByteMeth.addArray(verbPart,u);
			mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
			s.push("\n"+tabconvert2.revert(verbPart)+" (õ¤¬ùªòê¢êñ¢)");
			s.push("\n"+tabconvert2.revert(mainVerb)+" (õ¤¬ù)");
			return true;
		}
		if((mainVerb.length > ththu.length)&&ByteMeth.endsWith(mainVerb,aamal))
		{
			mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-aamal.length);
			byte verbPart[]=tabconvert2.convert("ñô¢");
			byte negMarker[]=tabconvert2.convert("Ý");
			if(ByteMeth.endsWith(mainVerb,yy))
				mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-1);
			if(ByteMeth.endsWith(mainVerb,pp)||ByteMeth.endsWith(mainVerb,r))
				mainVerb = ByteMeth.addArray(mainVerb,u);
			if(ByteMeth.endsWith(mainVerb,kk))
				mainVerb = ByteMeth.subArray(mainVerb,0,mainVerb.length-2);
			s.push("\n"+tabconvert2.revert(verbPart)+" (õ¤¬ùªòê¢êñ¢)");
			s.push("\n"+tabconvert2.revert(negMarker)+" (âî¤ó¢ñ¬ø Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(mainVerb)+" (õ¤¬ù)");
			return true;
		}
		else
		{
			s.push("\n"+tabconvert2.revert(mainVerb)+" (õ¤¬ù)");
			return true;
		}


}	// end of function checkVbp


public static boolean checktenses(byte [] s1,byte[] suffix)
 {
	ByteMeth ByteMeth=new ByteMeth();byte th[]={20};byte nth[]={21};byte nthth[]={21,20};
	byte t[]={18},tt[]={18,18},l1[]={29};byte kkir[]={14,14,3,30};byte kkindru[]={14,14,3,31,30},k[]={14};
	byte p[]={22},va[]={27,1},n[]={31},n1[]={19};byte u[]={5};byte iv[]={27};byte kir[]={14,3,30};byte kindru[]={14,3,31,30};byte pp[]={22,22};byte thth[]={20,20};byte in[]={3,31};
	byte kan[]={14,1,19};byte kar1[]={14,1,30},tha[]={20,1},rr1[]={30,30},r1[]={30},l[]={26},nn[]={31,31},ka[]={14,1},vi[]={27,3};
	byte se[]={16,7},nththa[]={21,20,1};

		if(ByteMeth.endsWith(s1,in))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-2,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-2));
			if(ByteMeth.endsWith(a,t))
				a = ByteMeth.addArray(a,u);
			if(ByteMeth.endsWith(a,th)||ByteMeth.endsWith(a,iv)||ByteMeth.endsWith(a,r1)||ByteMeth.endsWith(a,k))
				a = ByteMeth.addArray(a,u);
			s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		if(ByteMeth.endsWith(s1,nthth))
		{
			byte a1[]=ByteMeth.subArray(s1,s1.length-2,s1.length);
			byte a2[]=ByteMeth.subArray(s1,0,(s1.length-2));
			if(ByteMeth.isEqual(a2,va))
				a2 = tabconvert2.convert("õ£");
			if(ByteMeth.isEqual(a2,tha))
				a2 = tabconvert2.convert("î£");
			s.push("\n"+tabconvert2.revert(a1)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a2)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,thth))
		{
			byte a1[]=ByteMeth.subArray(s1,s1.length-2,s1.length);
			byte a2[]=ByteMeth.subArray(s1,0,(s1.length-2));
			if(ByteMeth.isEqual(a2,se))
				a2 = tabconvert2.convert("ê£");
			s.push("\n"+tabconvert2.revert(a1)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a2)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,th))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,nn))/**********new***********/
		{
			byte a1[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a2[]=ByteMeth.subArray(s1,0,(s1.length-2));
			a2 = ByteMeth.addArray(a2,l);
			s.push("\n"+tabconvert2.revert(a1)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a2)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,n))/**********new***********/
		{
			byte a1[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a2[]=ByteMeth.subArray(s1,0,(s1.length-1));
			s.push("\n"+tabconvert2.revert(a1)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a2)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,t)) /************updated*****************/
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			if(ByteMeth.isEqual(a,kan))
			{
				a = tabconvert2.convert("è£í¢");
				s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
				s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
				return(true);
			}
			if(ByteMeth.endsWith(a,n1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l1);
			}
			if(ByteMeth.endsWith(s1,tt))
			{
				if(ByteMeth.startsWith(s1,tabconvert2.convert("«è")))
				{
					a = ByteMeth.subArray(a,0,a.length-1);
					a = ByteMeth.addArray(a,l1);
				}
				else	/***********updated****************/
					a = ByteMeth.addArray(a,u);
			}

			s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,pp))
		{
			byte a1[]=ByteMeth.subArray(s1,s1.length-2,s1.length);
			byte a2[]=ByteMeth.subArray(s1,0,(s1.length-2));
			s.push("\n"+tabconvert2.revert(a1)+" (âî¤ó¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a2)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,iv))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			s.push("\n"+tabconvert2.revert(r)+" (âî¤ó¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,p))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			if(ByteMeth.isEqual(a,tabconvert2.convert("«èì¢")))
				a = tabconvert2.convert("«è÷¢");
			if(ByteMeth.isEqual(a,kar1))
			{
				a = tabconvert2.convert("èô¢");
			}
			if(ByteMeth.endsWith(a,r1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l);
			}
			s.push("\n"+tabconvert2.revert(r)+" (âî¤ó¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if((s1.length > kkir.length)&&ByteMeth.endsWith(s1,kkir))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-4,s1.length);
			byte r2[]=ByteMeth.addArray(r,u);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-4));
			if(ByteMeth.endsWith(a,t))
				a = ByteMeth.addArray(a,u);

			s.push("\n"+tabconvert2.revert(r2)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if((s1.length > kkiru.length)&&ByteMeth.endsWith(s1,kkiru))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-5,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-5));
			if(ByteMeth.endsWith(a,t))
				a = ByteMeth.addArray(a,u);
			s.push("\n"+tabconvert2.revert(r)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}

		else if((s1.length > kkindr.length)&&ByteMeth.endsWith(s1,kkindr))
		{
			System.out.println("Entered checkkindru");
			byte r[]=ByteMeth.subArray(s1,s1.length-5,s1.length);
			byte r2[]=ByteMeth.addArray(r,u);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-5));
			s.push("\n"+tabconvert2.revert(r2)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if((s1.length > kkindru.length)&&ByteMeth.endsWith(s1,kkindru))
		{
			System.out.println("Entered checkkindru");
			byte r[]=ByteMeth.subArray(s1,s1.length-6,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-6));
			s.push("\n"+tabconvert2.revert(r)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if((s1.length > kir.length)&&ByteMeth.endsWith(s1,kir))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-3,s1.length);
			byte r2[]=ByteMeth.addArray(r,u);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-3));
			if(ByteMeth.endsWith(a,r1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l);
			}
			if(ByteMeth.isEqual(a,tabconvert2.convert("«èì¢")))
				a = tabconvert2.convert("«è÷¢");
			if(ByteMeth.endsWith(a,t))
				a = ByteMeth.addArray(a,u);
			//System.out.println("verb : " + tabconvert2.revert(a) + " tense : " + tabconvert2.revert(r2));
			s.push("\n"+tabconvert2.revert(r2)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if((s1.length > kiru.length)&&ByteMeth.endsWith(s1,kiru))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-4,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-4));
			if(ByteMeth.endsWith(a,r1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l);
			}
			if(ByteMeth.isEqual(a,tabconvert2.convert("«èì¢")))
				a = tabconvert2.convert("«è÷¢");
			if(ByteMeth.endsWith(a,t))
				a = ByteMeth.addArray(a,u);
			//System.out.println("verb : " + tabconvert2.revert(a) + " tense : " + tabconvert2.revert(r2));
			s.push("\n"+tabconvert2.revert(r)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,kindru))
		{
			System.out.println("Entered checkkindru");
			byte r[]=ByteMeth.subArray(s1,s1.length-5,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-5));
			if(ByteMeth.isEqual(a,tabconvert2.convert("«èì¢")))
				a = tabconvert2.convert("«è÷¢");
			if(ByteMeth.endsWith(a,r1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l);
			}
			s.push("\n"+tabconvert2.revert(r)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			System.out.println("entered kindru");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,kindr))
		{
			System.out.println("Entered checkkindru");
			byte r[]=ByteMeth.subArray(s1,s1.length-4,s1.length);
			byte r2[]=ByteMeth.addArray(r,u);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-4));
			if(ByteMeth.isEqual(a,tabconvert2.convert("«èì¢")))
				a = tabconvert2.convert("«è÷¢");
			if(ByteMeth.endsWith(a,r1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l);
			}
			s.push("\n"+tabconvert2.revert(r2)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			System.out.println("entered kindru");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,rr1))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			byte a1[]=ByteMeth.subArray(s1,0,(s1.length-2));
			if(ByteMeth.isEqual(a1,ka) || ByteMeth.isEqual(a1,vi))
			{
				a = ByteMeth.addArray(a1,l);
			}
			else
				a = ByteMeth.addArray(a,u);
			s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,r1))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			if(ByteMeth.endsWith(a,n))
			{
				byte r2[] = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(r2,l);
			}
			s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else
		{
			try
			{   String spchk;
				System.out.println("check tenses i am in call to Spellchecker");
				spchk = Spchkverb.checker(tabconvert2.revert(s1));
				System.out.println("sugg in checktenses :" + spchk);
				byte str[]=tabconvert2.convert(spchk);
				if(checktenses1(str,suffix))
					return(true);
				else
				    return(false);
			}
			catch(Exception e)
			{
				System.out.println("exception");
				e.printStackTrace();
			}
		return(false);
		}



	}
public static boolean checktenses1(byte [] s1,byte[] suffix)
 {
	ByteMeth ByteMeth=new ByteMeth();
	byte th[]={20};byte nth[]={21};byte nthth[]={21,20};
	byte ta[]={18};byte kkir[]={14,14,3,30};byte kkindru[]={14,14,3,31,30};
	byte p[]={22};byte u[]={5};byte iv[]={27};byte kiru[]={14,3,30};byte kindru[]={14,3,31,30};
	byte pp[]={22,22};byte thth[]={20,20};byte in[]={3,31};
	byte kar1[]={14,1,30},tha[]={20,1},r1[]={30},l[]={26},se[]={16,7},nththa[]={21,20,1};
	byte t[]={18},tt[]={18,18},n1[]={19},rr1[]={30,30},nn[]={31,31},l1[]={29},vi[]={27,3};byte k[]={14};byte kan[]={14,1,19};byte va[]={27,1},n[]={31};

		if(ByteMeth.endsWith(s1,in))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-2,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-2));
			if(ByteMeth.endsWith(a,t))
				a = ByteMeth.addArray(a,u);
			if(ByteMeth.endsWith(a,th)||ByteMeth.endsWith(a,iv)||ByteMeth.endsWith(a,r1)||ByteMeth.endsWith(a,k))
				a = ByteMeth.addArray(a,u);
			s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		if(ByteMeth.endsWith(s1,nthth))
		{
			byte a1[]=ByteMeth.subArray(s1,s1.length-2,s1.length);
			byte a2[]=ByteMeth.subArray(s1,0,(s1.length-2));
			if(ByteMeth.isEqual(a2,va))
				a2 = tabconvert2.convert("õ£");
			if(ByteMeth.isEqual(a2,tha))
				a2 = tabconvert2.convert("î£");
			s.push("\n"+tabconvert2.revert(a1)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a2)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,thth))
		{
			byte a1[]=ByteMeth.subArray(s1,s1.length-2,s1.length);
			byte a2[]=ByteMeth.subArray(s1,0,(s1.length-2));
			if(ByteMeth.isEqual(a2,se))
				a2 = tabconvert2.convert("ê£");
			s.push("\n"+tabconvert2.revert(a1)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a2)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,th))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,nn))/**********new***********/
		{
			byte a1[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a2[]=ByteMeth.subArray(s1,0,(s1.length-2));
			a2 = ByteMeth.addArray(a2,l);
			s.push("\n"+tabconvert2.revert(a1)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a2)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,n))/**********new***********/
		{
			byte a1[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a2[]=ByteMeth.subArray(s1,0,(s1.length-1));
			s.push("\n"+tabconvert2.revert(a1)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a2)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,t)) /************updated*****************/
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			if(ByteMeth.isEqual(a,kan))
			{
				a = tabconvert2.convert("è£í¢");
				s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
				s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
				return(true);
			}
			if(ByteMeth.endsWith(a,n1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l1);
			}
			if(ByteMeth.endsWith(s1,tt))
			{
				if(ByteMeth.startsWith(s1,tabconvert2.convert("«è")))
				{
					a = ByteMeth.subArray(a,0,a.length-1);
					a = ByteMeth.addArray(a,l1);
				}
				else	/***********updated****************/
					a = ByteMeth.addArray(a,u);
			}

			s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,pp))
		{
			byte a1[]=ByteMeth.subArray(s1,s1.length-2,s1.length);
			byte a2[]=ByteMeth.subArray(s1,0,(s1.length-2));
			s.push("\n"+tabconvert2.revert(a1)+" (âî¤ó¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a2)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,iv))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			s.push("\n"+tabconvert2.revert(r)+" (âî¤ó¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,p))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			if(ByteMeth.isEqual(a,tabconvert2.convert("«èì¢")))
				a = tabconvert2.convert("«è÷¢");
			if(ByteMeth.isEqual(a,kar1))
			{
				a = tabconvert2.convert("èô¢");
			}
			if(ByteMeth.endsWith(a,r1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l);
			}
			s.push("\n"+tabconvert2.revert(r)+" (âî¤ó¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if((s1.length > kkir.length)&&ByteMeth.endsWith(s1,kkir))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-4,s1.length);
			byte r2[]=ByteMeth.addArray(r,u);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-4));
			if(ByteMeth.endsWith(a,t))
				a = ByteMeth.addArray(a,u);

			s.push("\n"+tabconvert2.revert(r2)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if((s1.length > kkiru.length)&&ByteMeth.endsWith(s1,kkiru))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-5,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-5));
			if(ByteMeth.endsWith(a,t))
				a = ByteMeth.addArray(a,u);
			s.push("\n"+tabconvert2.revert(r)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}

		else if((s1.length > kkindr.length)&&ByteMeth.endsWith(s1,kkindr))
		{
			System.out.println("Entered checkkindru");
			byte r[]=ByteMeth.subArray(s1,s1.length-5,s1.length);
			byte r2[]=ByteMeth.addArray(r,u);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-5));
			s.push("\n"+tabconvert2.revert(r)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if((s1.length > kkindru.length)&&ByteMeth.endsWith(s1,kkindru))
		{
			System.out.println("Entered checkkindru");
			byte r[]=ByteMeth.subArray(s1,s1.length-6,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-6));
			s.push("\n"+tabconvert2.revert(r)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if((s1.length > kir.length)&&ByteMeth.endsWith(s1,kir))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-3,s1.length);
			byte r2[]=ByteMeth.addArray(r,u);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-3));
			if(ByteMeth.endsWith(a,r1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l);
			}
			if(ByteMeth.isEqual(a,tabconvert2.convert("«èì¢")))
				a = tabconvert2.convert("«è÷¢");
			if(ByteMeth.endsWith(a,t))
				a = ByteMeth.addArray(a,u);
			//System.out.println("verb : " + tabconvert2.revert(a) + " tense : " + tabconvert2.revert(r2));
			s.push("\n"+tabconvert2.revert(r2)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if((s1.length > kiru.length)&&ByteMeth.endsWith(s1,kiru))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-4,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-4));
			if(ByteMeth.endsWith(a,r1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l);
			}
			if(ByteMeth.isEqual(a,tabconvert2.convert("«èì¢")))
				a = tabconvert2.convert("«è÷¢");
			if(ByteMeth.endsWith(a,t))
				a = ByteMeth.addArray(a,u);
			//System.out.println("verb : " + tabconvert2.revert(a) + " tense : " + tabconvert2.revert(r2));
			s.push("\n"+tabconvert2.revert(r)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,kindru))
		{
			System.out.println("Entered checkkindru");
			byte r[]=ByteMeth.subArray(s1,s1.length-5,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-5));
			if(ByteMeth.isEqual(a,tabconvert2.convert("«èì¢")))
				a = tabconvert2.convert("«è÷¢");
			if(ByteMeth.endsWith(a,r1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l);
			}
			s.push("\n"+tabconvert2.revert(r)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			System.out.println("entered kindru");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,kindr))
		{
			System.out.println("Entered checkkindru");
			byte r[]=ByteMeth.subArray(s1,s1.length-4,s1.length);
			byte r2[]=ByteMeth.addArray(r,u);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-4));
			if(ByteMeth.isEqual(a,tabconvert2.convert("«èì¢")))
				a = tabconvert2.convert("«è÷¢");
			if(ByteMeth.endsWith(a,r1))
			{
				a = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(a,l);
			}
			s.push("\n"+tabconvert2.revert(r)+" (ï¤èö¢è£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			System.out.println("entered kindru");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,rr1))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			byte a1[]=ByteMeth.subArray(s1,0,(s1.length-2));
			if(ByteMeth.isEqual(a1,ka) || ByteMeth.isEqual(a1,vi))
			{
				a = ByteMeth.addArray(a1,l);
			}
			else
				a = ByteMeth.addArray(a,u);
			s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else if(ByteMeth.endsWith(s1,r1))
		{
			byte r[]=ByteMeth.subArray(s1,s1.length-1,s1.length);
			byte a[]=ByteMeth.subArray(s1,0,(s1.length-1));
			if(ByteMeth.endsWith(a,n))
			{
				byte r2[] = ByteMeth.subArray(a,0,a.length-1);
				a = ByteMeth.addArray(r2,l);
			}
			s.push("\n"+tabconvert2.revert(r)+" (Þøï¢îè£ô Þ¬ìï¤¬ô)");
			s.push("\n"+tabconvert2.revert(a)+" (õ¤¬ù)");
			return(true);
		}
		else
			return(false);
	}
 public static void main(String args[])
	     {
         	   verb mor = new verb();
      	     }
       }
