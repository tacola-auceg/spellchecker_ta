package SpellChecker;

//    .............  Spellchecker with User Interface  ..............
//    .............		   postpositionchecking	 	   ..............

import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import analyser.*;

public class Hpostposition extends JFrame implements ActionListener
{
	static JButton check = new JButton("Check");       // Check & Ok are two buttons
	static JButton close = new JButton("Close");

	Font f=new Font("TAB-Anna",4,16);

	static JTextField text1 = new JTextField("ñóî¢î¤ô¢",16);  //text field to get the user input
	static JTextArea text2 = new JTextArea(20,30);     //text field to print the output
	static JTextField text3 = new JTextField("ñóî¢î¤ô¢",20);

	static JComboBox jc = new JComboBox();

	static JPanel p1 = new JPanel();
	static JScrollPane p2 = new JScrollPane(text2);
	static JPanel p3 = new JPanel();

	// byte codes for accusative postpositions
	static byte vida[]={27,3,18,1};
	static byte pola[]={22,11,26,1};
	static byte kondu[]={14,10,19,18,5};
	static byte nokki[]={21,11,14,14,3};
	static byte pattri[]={22,1,30,30,3};
	static byte kuriththu[]={14,5,30,3,20,20,5};
	static byte suttri[]={16,5,30,30,3};
	static byte vittu[]={27,3,18,18,5};
	static byte thavira[]={20,1,27,3,25,1};
	static byte munnittu[]={23,5,31,31,3,18,18,5};
	static byte vendi[]={27,8,19,18,3};
	static byte otti[]={10,18,18,3};
	static byte poruththu[]={22,10,30,5,20,20,5};
	static byte poruththavarai[]={22,10,30,5,20,20,1,27,1,25,9};
	// byte codes for genitive postpositions
	static byte meedhu[]={23,4,20,5};
	static byte vazhiyaaga[]={27,1,28,3,24,2,14,1};
	static byte moolamaaga[]={23,6,26,1,23,2,14,1};
	static byte vaayilaaga[]={27,2,24,3,26,2,14,1};
	static byte poruttu[]={22,10,25,5,18,18,5};
	static byte meethu[]={23,4,20,5};
	static byte meethil[]={23,4,20,3,26};
	// byte codes for locative postposition
	static byte mael[]={23,8,26};
	static byte keezh[]={14,4,28};
	// byte codes for dative postposition
	static byte aaga[]={2,14,1};
	static byte mun[]={23,5,31};
	static byte pin[]={22,3,31};
	static byte endru[]={7,31,30,5};
	static byte ul1[]={5,29};
	static byte ulla[]={5,29,29,1};
	static byte uriya[]={5,25,3,24,1};
	static byte namakkidaiye[]={21,1,23,1,14,14,3,18,9,24,8};
	static byte naduve[]={21,1,18,5,27,8};
	static byte veliye[]={27,7,29,3,24,8};
	static byte maththiyil[]={23,1,20,20,3,24,3,26};
	static byte ethiril[]={7,20,3,25,3,26};
	static byte pakkaththil[]={22,1,14,14,1,20,20,3,26};
	static byte arukil[]={1,25,5,14,3,26};
	static byte pathil[]={22,1,20,3,26};
	static byte thaguntha[]={20,1,14,5,21,20,1};
	static byte maaraaga[]={23,2,30,2,14,1};
	static byte naeraaga[]={21,8,25,2,14,1};


	static String suggest="";
	public Hpostposition()
	{
		setTitle("SpellChecker-Postposition");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int ht = d.height;
		int wid = d.width;
         setSize(800,240);

		Image img = tk.getImage(".\\Hlpglobe.GIF");
		setIconImage(img);

		p1.add(text1);
		p1.add(text3);

		p3.add(jc);
		p3.add(check);
		p3.add(close);


		text1.setFont(f);
		text2.setFont(f);
		text3.setFont(f);
		jc.setFont(f);

		jc.addItem("Suggestion");

		check.addActionListener(this);
		close.addActionListener(this);
		text1.addActionListener(this);
		jc.addActionListener(this);

		getContentPane().add(p1,"North");
		getContentPane().add(p2,"Center");
		getContentPane().add(p3,"South");

		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});

		show();
	  }       // end of constructor

	public static String changearr(byte[] strin,byte[] split)
	{
		int len1,len2;
		len1 = split.length;
		len2 = strin.length;

		for(int j=len1;j>0;j--)
			{
				strin[len2-j] = split[len1-j];
			}
		return(tabconvert2.revert(strin));
	}

	/*public static String spellcheck(String strin)
		{
			byte start[],end[];int i=0,j=0;
			String spchk="",temp1="",temp2="";
			try{
				spchk=checker(strin);
				}
			catch(Exception e)
				{
					System.out.println("exception");
					e.printStackTrace();
				}
			Stack wordstack = verb.checkverb(spchk);
			while(!wordstack.empty())
			{
				temp1=temp1+wordstack.pop().toString();
			}
			int len4=temp1.length();
		     //jc.addItem(temp1);
			temp2="     "+temp1.substring(0,len4-1);
			jc.addItem(temp2);
			return(temp2);

		} // end of function spellcheck*/


public void sugg_from_dictionary(byte[] start,byte[] end)
{

	ByteMeth ByteMeth=new ByteMeth();
	byte dicword[]=null,tempbyte[]=null;
	String temp="";
	BufferedReader dic = null;
	try{

	//modified by anu on 26/12/02 while integrating
	try
	{
		dic = new BufferedReader(new InputStreamReader(getClass().
			getResourceAsStream("dictionary.txt")));
	}catch(Exception e)
	{
		e.printStackTrace();
	}

	StreamTokenizer input = new StreamTokenizer(dic);
	int tokentype = 0;
	while((tokentype = input.nextToken()) != StreamTokenizer.TT_EOF)
	{
		if(tokentype == StreamTokenizer.TT_WORD)
		{
			temp=input.sval;
			tempbyte = tabconvert2.convert(temp);
			if(ByteMeth.startsWith(tempbyte,start)&&ByteMeth.endsWith(tempbyte,end))
				{
					jc.addItem(temp);
					System.out.println("i am inside if of sug_dic");
				}

		}

	}}catch(Exception e){e.printStackTrace();}


} // end of function sugg_from_dictionary


public static String checker(String strin) throws Exception//it checks for special cases,
{							  	     //searches the dictionary & returns
	ByteMeth ByteMeth=new ByteMeth();
	byte bstr[] = tabconvert2.convert(strin);
	int blen = bstr.length;
	String temp="";
	Stack s1;
	boolean searchresult=true;
	System.out.println("str in checker :"+ strin);
	suggest="";
	boolean status = check_accusative(bstr,blen);
	if(status)
		{
			temp = "accusative-ok";
			jc.addItem(temp);
			return suggest;
		}
	else
		{
			status = check_genitive(bstr,blen);
			if(status)
				{
					temp = "genitive-ok-ok";
					jc.addItem(temp);
					return suggest;
				}
			else
				{
					status = check_lacative(bstr,blen);
					if(status)
						{
							temp = "lacative-ok";
							jc.addItem(temp);
							return suggest;
						}
					else
						{
							status = check_dative(bstr,blen);
							if(status)
								{
									temp = "dative-ok";
									jc.addItem(temp);
									return suggest;
								}
							else
								{
									temp = "no-match";
									jc.addItem(temp);
									return temp;
									/*status = check_aaga(bstr,blen);
									if(status)
										{
											temp = "aaga-ok";
											return suggest;
										}
									else
										{
											status = check_kal(bstr,blen);
											if(status)
												{
													temp = "kal-ok";
													//jc.addItem(temp);
													return suggest;
												}
											else
												{
													if(ByteMeth.endsWith(bstr,ai))
														{
															temp = "ai-ok";
															//jc.addItem(temp);
															return suggest;
														}
													else
														{

															try{
																 searchresult = dicsearch(strin);}catch(Exception e){e.printStackTrace();}
																System.out.println("the string is correct-match found in dictionary");
																if(searchresult == true)
																{
																	temp = "the string is correct";
																	text2.setText(temp);
																	//jc.addItem("the string is correct");
																	return(temp );
																}
																else
																{
																	temp = "no-match";
																	text2.setText(temp);
																	return temp;
																}



														}
												}
										}*/
								}
						}
				}
		}

}	// end of function checker



//modified by anu on 26/12/02 while integrating
public boolean dicsearch(String root)// throws IOException
 {
	  BufferedReader dic = null;
	try{

	//modified by anu on 26/12/02 while integrating
	try
	{
		dic = new BufferedReader(new InputStreamReader(getClass().
			getResourceAsStream("dictionary.txt")));
	}catch(Exception e)
	{
		e.printStackTrace();
	}

	StreamTokenizer input = new StreamTokenizer(dic);
	int tokentype = 0;
	while((tokentype = input.nextToken()) != StreamTokenizer.TT_EOF)
	{
		if(tokentype == StreamTokenizer.TT_WORD)
		{
			if(root.equals(input.sval))
				return true;

		}

	}}catch(Exception e){e.printStackTrace();}
	return false;

} // ens of function dicsearch


public static boolean check_accusative(byte[] bstr,int blen)
{
	if(check_u(bstr,blen))  //check munnittu,poruththu,vittu,kondu,kuriththu
		return true;
	else if(check_e(bstr,blen)) // check suttri,pattri,vendi,otti,nokki
		return true;
	else
		return false;

} // end of function check_accusative postposition


public static boolean check_dative(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	if(blen <= pakkaththil.length)
		return false;
	if(ByteMeth.endsWith(bstr,ul1)||ByteMeth.endsWith(bstr,uriya)||ByteMeth.endsWith(bstr,ulla)||ByteMeth.endsWith(bstr,mun)||ByteMeth.endsWith(bstr,pin)||ByteMeth.endsWith(bstr,aaga)||ByteMeth.endsWith(bstr,pathil)||ByteMeth.endsWith(bstr,naeraaga)||ByteMeth.endsWith(bstr,maaraaga)||ByteMeth.endsWith(bstr,maththiyil)||ByteMeth.endsWith(bstr,pakkaththil)||ByteMeth.endsWith(bstr,arukil)||ByteMeth.endsWith(bstr,ethiril)||ByteMeth.endsWith(bstr,thaguntha)||ByteMeth.endsWith(bstr,namakkidaiye)||ByteMeth.endsWith(bstr,veliye)||ByteMeth.endsWith(bstr,naduve)||ByteMeth.endsWith(bstr,endru))
		{
			jc.addItem("string is correct");
			return true;
		}
	if(check_naeraaga_maaraaga(bstr,blen))
		return true;
	else if(check_il(bstr,blen))
		return true;
	else if(check_thaguntha(bstr,blen))  // check aaga
		return true;
	else if(check_uriya(bstr,blen))  // check aaga
		return true;
	else if(check_ul1_ulla(bstr,blen))
		return true;
	else if(check_ae(bstr,blen))
		return true;
	else if(check_endru(bstr,blen))
		return true;
	else if(check_mun_pin(bstr,blen))  // check mun & pin
		return true;
	else if(check_aaga(bstr,blen))  // check aaga
		return true;
	else
		return false;

} // end of function check_dative postposition


public static boolean check_genitive(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	if(blen <= poruttu.length)
		return false;
	if(ByteMeth.endsWith(bstr,poruttu)||ByteMeth.endsWith(bstr,meethu)||ByteMeth.endsWith(bstr,meethil))
		return true;
	else if(check_ga(bstr,blen))  // check moolamaga & vaayilaga
		return true;
	else if(check_poruttu(bstr,blen))
		return true;
	else if(check_meethu_meethil(bstr,blen))
		return true;
	else
		return false;

} // end of function check_genitive postposition

public static boolean check_lacative(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	if(blen <= keezh.length)
		return false;
	if(ByteMeth.endsWith(bstr,keezh)||ByteMeth.endsWith(bstr,mael))
		return true;
	else if(check_keezh(bstr,blen))  // check mael & keezh
		return true;
	else if(check_mael(bstr,blen))
		return true;
	else
		return false;

} // end of function check_lacative postposition


public static boolean check_u(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	if(blen <= munnittu.length)
		return false;
	if(ByteMeth.endsWith(bstr,kondu)||ByteMeth.endsWith(bstr,kuriththu)||ByteMeth.endsWith(bstr,vittu)||ByteMeth.endsWith(bstr,munnittu)||ByteMeth.endsWith(bstr,poruththu))
	{
		text2.setText("string is correct");
		return(true);
	}
	else if(check_pattern_munnittu(bstr,munnittu))
	{
		get_sugg(bstr,munnittu);
		return(true);
	}
	else if(check_pattern_kondu(bstr,kondu))
	{
		set_sugg(bstr,kondu);
		return(true);
	}
	else if(check_pattern_poruththu(bstr,poruththu))
	{
			get_sugg(bstr,poruththu);
			set_sugg(bstr,poruttu);
			return(true);
	}
	else if(check_pattern_kuriththu(bstr,kuriththu))
	{
		get_sugg(bstr,kuriththu);
		return(true);
	}

	else if(check_pattern_vittu(bstr,vittu))
	{
		get_sugg(bstr,vittu);
		System.out.println("suggest in check_pattern_irunthu :" + suggest);
		return(true);
	}


	else
		return(false);

} // end of function check_u


public static boolean check_e(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	if(blen <= nokki.length)
		return false;
	if(ByteMeth.endsWith(bstr,nokki)||ByteMeth.endsWith(bstr,pattri)||ByteMeth.endsWith(bstr,suttri)||ByteMeth.endsWith(bstr,vendi)||ByteMeth.endsWith(bstr,otti))
	{
		text2.setText("string is correct");
		return(true);
	}
	else if(check_pattern_nokki(bstr,nokki))
	{
		get_sugg(bstr,nokki);
		set_sugg(bstr,pattri);
		set_sugg(bstr,suttri);
		return(true);
	}
	else if(check_pattern_vendi(bstr,vendi))
	{
		get_sugg(bstr,vendi);
		return(true);
	}
	else if(check_pattern_pattri_suttri(bstr,suttri))
	{
		return(true);
	}
	else if(check_pattern_otti(bstr,otti))
	{
		get_sugg(bstr,otti);
		return(true);
	}
	else
		return(false);

} // end of function check_e


public static boolean check_ga(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	if(blen <= moolamaaga.length)
		return false;
	if(ByteMeth.endsWith(bstr,moolamaaga)||ByteMeth.endsWith(bstr,vaayilaaga)||ByteMeth.endsWith(bstr,vazhiyaaga))
	{
		text2.setText("string is correct");
		return(true);
	}
	else if(check_pattern_moolamaaga_vaayilaaga_vazhiyaaga(bstr,vaayilaaga))
		return(true);
	else
		return(false);

} // end of function check_ga



public static void set_sugg(byte[] bstr,byte[] marker)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = marker.length,blen = bstr.length;
	byte rem[] = ByteMeth.subArray(bstr,0,blen-len);
	String sugg = tabconvert2.revert(ByteMeth.addArray(rem,marker));
	jc.addItem(sugg);
	HSugg.model.addElement(sugg);
} // end of function set_sugg


public static void get_sugg(byte[] bstr,byte[] marker)
{
	System.out.println("str in set_sugg :" + tabconvert2.revert(bstr));
	ByteMeth ByteMeth=new ByteMeth();
	int len = marker.length,blen = bstr.length;
	byte rem[] = ByteMeth.subArray(bstr,0,blen-len);
	suggest= tabconvert2.revert(ByteMeth.addArray(rem,marker));
	jc.addItem(suggest);
	text3.setText(suggest);
	HSugg.model.addElement(suggest);
} // end of function get_sugg



public static boolean check_pattern_kondu(byte[] bstr,byte[] marker)
{
	ByteMeth ByteMeth=new ByteMeth();
	int blen = bstr.length;
	int len = marker.length;
	if(blen <= len)
		return false;
	byte kon[]={14,10,19},ndu[]={19,18,5},ond[]={10,19,18};
	if(blen>5)
	{
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
		byte end234[] = {end[1],end[2],end[3]};
		if(ByteMeth.startsWith(end,kon)||ByteMeth.endsWith(bstr,ndu)|| ByteMeth.isEqual(end234,ond))
			return(true);
		else
			return(false);
	}
	else
		return(false);
} // end of function check_pattern_kondu


public static boolean check_pattern_poruththu(byte[] bstr,byte[] marker)
{
	ByteMeth ByteMeth=new ByteMeth();
	int blen = bstr.length;
	int len = marker.length;
	if(blen <= len)
		return false;
	byte poru[]={22,10,30,5};
	byte por[]={22,10,30};
	byte oruthth[]={10,30,5,20,20};
	byte ruththu[]={30,5,20,20,5};
	byte uththu[]={5,20,20,5};
	byte ththu[]={20,20,5},pp[]={22};
	if(blen>7)
		{
			byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
			byte end23456[] = {end[1],end[2],end[3],end[4],end[5]};
			if(ByteMeth.startsWith(end,por)||ByteMeth.startsWith(bstr,poru)||ByteMeth.endsWith(bstr,ruththu)||ByteMeth.endsWith(bstr,uththu)||(ByteMeth.endsWith(bstr,ththu)&&ByteMeth.startsWith(bstr,pp))|| ByteMeth.isEqual(end23456,oruthth))
				return(true);
			else
				return(false);
		}
	else
		return false;
} // end of function check_pattern_poruththu


public static boolean check_pattern_munnittu(byte[] bstr,byte[] marker)
{
	ByteMeth ByteMeth=new ByteMeth();
	int blen = bstr.length;
	int len = marker.length;
	if(blen <= len)
		return false;
	byte munn[]={23,5,31},ittu[]={3,18,18,5},unni[]={5,31,31,3},itt[]={3,18,18};
	if(blen>8)
	{
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen),od[]={11,18},o[]={11},du[]={18,5};
		byte end2345[] = {end[1],end[2],end[3],end[4]};
		byte end567[]={end[4],end[5],end[6]};
		if(ByteMeth.startsWith(end,munn)||ByteMeth.endsWith(bstr,ittu)|| ByteMeth.isEqual(end2345,unni)|| ByteMeth.isEqual(end567,itt))
			return(true);
		else
			return(false);
	}
	else
		return(false);
} // end of function check_pattern_munnittu

public static boolean check_pattern_kuriththu(byte[] bstr,byte[] marker)
{
	ByteMeth ByteMeth=new ByteMeth();
	int blen = bstr.length;
	int len = marker.length;
	if(blen <= len)
		return false;
	byte kuri[]={14,5,30},ththu[]={20,20,5},urith[]={5,30,3,20},ithth[]={3,20,20},ku[]={14,5},kk[]={14};
	if(blen>7)
	{
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
		byte end2345[] = {end[1],end[2],end[3],end[4]};
		byte end456[] = {end[3],end[4],end[5]};
		if(ByteMeth.startsWith(end,kuri)||ByteMeth.endsWith(bstr,ththu)|| ByteMeth.isEqual(end2345,urith)|| (ByteMeth.isEqual(end456,ithth) && ByteMeth.startsWith(bstr,kk)))
			return(true);
		else
			return(false);
	}
	else
		return(false);
} // end of function check_pattern_kuriththu


public static boolean check_pattern_vittu(byte[] bstr,byte[] marker)
{
	ByteMeth ByteMeth=new ByteMeth();
	int blen = bstr.length;
	int len = marker.length;
	if(blen <= len)
		return false;
	if(blen>5)
	{
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
		byte vit[]={27,3,18},itt[]={3,18,18},ttu[]={18,18,5},iv[]={27};
		byte end234[] = {end[1],end[2],end[3]};
		if(ByteMeth.startsWith(end,vit)||(ByteMeth.startsWith(end,iv)&&ByteMeth.endsWith(bstr,ttu))|| ByteMeth.isEqual(end234,itt))
			return(true);
		else
			return(false);
	}
	else
		return(false);
} // end of function check_pattern_vittu


public static boolean check_pattern_nokki(byte[] bstr,byte[] marker)
{
	ByteMeth ByteMeth=new ByteMeth();
	int blen = bstr.length;
	int len = marker.length;
	if(blen <= len)
		return false;
	byte nok[]={21,11,14},okk[]={11,14,14},kki[]={14,14,3},nth[]={21},kk[]={14,14};
	if(blen>=5)
	{
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
		byte end234[] = {end[1],end[2],end[3]},end34[]={end[2],end[3]};
		if(ByteMeth.startsWith(end,nok)||ByteMeth.endsWith(bstr,kki)|| ByteMeth.isEqual(end234,okk)||(ByteMeth.startsWith(end,nth) && ByteMeth.isEqual(end34,kk)))
			return(true);
		else
			return(false);
	}
	else
		return(false);
} // end of function check_pattern_nokki


public static boolean check_pattern_pattri_suttri(byte[] bstr,byte[] marker)
{
	ByteMeth ByteMeth=new ByteMeth();
	int blen = bstr.length;
	int len = marker.length;
	if(blen <= len)
		return false;
	if(ByteMeth.endsWith(bstr,suttri)||ByteMeth.endsWith(bstr,pattri))
	{
		jc.addItem("string is correct");
		return true;
	}
	byte attri[]={1,30,30,3},pat[]={22,1,30},ttri[]={30,30,3},uttr[]={1,30,30},attr[]={1,30,30},ich[]={16},ip[]={22},irir[]={30,30};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	byte end234[] = {end[1],end[2],end[3]},end34[]={end[2],end[3]};
	if(ByteMeth.endsWith(bstr,attri))
	{
			set_sugg(bstr,suttri);
			set_sugg(bstr,pattri);
			return true;
	}
	else if(ByteMeth.endsWith(bstr,ttri)|| ByteMeth.isEqual(end234,attr)||(ByteMeth.isEqual(end234,uttr))||(ByteMeth.startsWith(bstr,ip)&&ByteMeth.isEqual(end34,irir))||(ByteMeth.startsWith(end,ich)&&ByteMeth.isEqual(end34,irir)))
	{
		if(ByteMeth.startsWith(end,ip))
		{
			get_sugg(bstr,pattri);
			set_sugg(bstr,suttri);
		}
		else
		{
			get_sugg(bstr,suttri);
			set_sugg(bstr,pattri);
		}
		return(true);
	}
	else
		return false;

} // end of function check_pattern_pattri_suttri


public static boolean check_pattern_vendi(byte[] bstr,byte[] marker)
{
	ByteMeth ByteMeth=new ByteMeth();
	int blen = bstr.length;
	int len = marker.length;
	if(blen <= len)
		return false;
	if(ByteMeth.endsWith(bstr,vendi))
	{
		jc.addItem("string is correct");
		return true;
	}
	byte ve[]={27,8},di[]={18,3},ven[]={27,8,19},ndi[]={19,18,3},yend[]={8,19,18},iv[]={27},init[]={19,18};
	if(blen>5)
	{
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
		byte end234[] = {end[1],end[2],end[3]},end34[]={end[2],end[3]};
		if(ByteMeth.startsWith(end,ven)||ByteMeth.endsWith(bstr,ndi)|| ByteMeth.isEqual(end234,yend)||(ByteMeth.startsWith(end,iv)&&ByteMeth.isEqual(end34,init))||(ByteMeth.startsWith(end,ve)&&ByteMeth.endsWith(bstr,di)))
			return(true);
		else
			return(false);
	}
	else
		return(false);
} // end of function check_pattern_vendi


public static boolean check_pattern_otti(byte[] bstr,byte[] marker)
{
	ByteMeth ByteMeth=new ByteMeth();
	int blen = bstr.length;
	int len = marker.length;
	if(blen <= len)
		return false;
	if(ByteMeth.endsWith(bstr,otti))
	{
		jc.addItem("string is correct");
		return true;
	}
	byte ot[]={10,18},tti[]={18,18,3},o1[]={11},itit[]={18,18};
	if(blen>=5)
	{
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
		byte end23[] = {end[1],end[2]};
		if(ByteMeth.startsWith(end,ot)||ByteMeth.endsWith(bstr,tti)||(ByteMeth.isEqual(end23,itit)&&ByteMeth.startsWith(end,o1)))
			return(true);
		else
			return(false);
	}
	else
		return(false);
} // end of function check_pattern_otti


public static boolean check_pattern_moolamaaga_vaayilaaga_vazhiyaaga(byte[] bstr,byte[] marker)
{
	ByteMeth ByteMeth=new ByteMeth();
	int blen = bstr.length;
	int len = marker.length;
	if(blen <= len)
		return false;
	if(ByteMeth.endsWith(bstr,moolamaaga)||ByteMeth.endsWith(bstr,vaayilaaga)||ByteMeth.endsWith(bstr,vazhiyaaga))
	{
		jc.addItem("string is correct");
		return true;
	}
	byte im[]={23},la[]={26,1},am[]={1,23},ka[]={14,1},moo[]={23,6};
	byte pat[]={22,1,30},ttri[]={30,30,3},uttr[]={1,30,30},attr[]={1,30,30};
	byte ich[]={16},ip[]={22},irir[]={30,30},laaga[]={26,2,14,1};
	byte vaai[]={27,2,24},iv[]={27},yil[]={24,3,26},zhiy[]={28,3,24};
	byte vazhi[]={27,1,28,3},maaga[]={23,2,14,1},lamaa[]={26,1,23,2},yilaa[]={24,3,26,2};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen),yaaga[]={24,2,14,1},zhiyaa[]={28,3,24,2};
	byte end3456[]={end[2],end[3],end[4],end[5]};
	byte end34[] = {end[2],end[3]},end45[]={end[3],end[4]},end345[] = {end[2],end[3],end[4]},end78[]={end[6],end[7]};
	if((ByteMeth.endsWith(bstr,maaga)&&ByteMeth.startsWith(end,im))||ByteMeth.isEqual(end3456,lamaa)|| (ByteMeth.isEqual(end45,am)&&ByteMeth.isEqual(end78,ka))||(ByteMeth.startsWith(end,im)&&ByteMeth.isEqual(end78,ka)&&ByteMeth.isEqual(end34,la)))
	{
		get_sugg(bstr,moolamaaga);
		set_sugg(bstr,vaayilaaga);
		set_sugg(bstr,vazhiyaaga);
		return(true);
	}
	else if(ByteMeth.endsWith(bstr,laaga)||ByteMeth.startsWith(end,vaai)|| ByteMeth.isEqual(end3456,yilaa)||(ByteMeth.startsWith(end,iv)&&ByteMeth.isEqual(end345,yil)))
	{
		get_sugg(bstr,vaayilaaga);
		set_sugg(bstr,vazhiyaaga);
		set_sugg(bstr,moolamaaga);
		return(true);
	}
	else if((ByteMeth.startsWith(end,iv)&&ByteMeth.endsWith(bstr,yaaga))||ByteMeth.isEqual(end3456,zhiyaa)||ByteMeth.startsWith(end,vazhi)|| (ByteMeth.startsWith(end,iv)&&ByteMeth.isEqual(end345,zhiy)))
	{
		get_sugg(bstr,vazhiyaaga);
		set_sugg(bstr,vaayilaaga);
		set_sugg(bstr,moolamaaga);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_moolamaaga_vaayilaaga



public static boolean check_poruttu(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = poruttu.length;
	if(blen <= len)
		return false;
	if(ByteMeth.endsWith(bstr,poruttu))
	{
		jc.addItem("string is correct");
		return true;
	}
	byte ttu[]={18,18,5},ip[]={22},poru[]={22,10,25,5},rutt[]={25,5,18,18};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	byte end3456[]={end[2],end[3],end[4],end[5]};
	if(blen>=7)
	{
		if((ByteMeth.endsWith(bstr,ttu)&&ByteMeth.startsWith(end,ip))||ByteMeth.startsWith(end,poru)|| ByteMeth.isEqual(end3456,rutt))
		{
			get_sugg(bstr,poruttu);
			set_sugg(bstr,poruththu);
			return(true);
		}
		else
			return false;

	}
	else
		return(false);
} // end of function check_poruttu

public static boolean check_meethu_meethil(byte[] bstr,int blen)
{
		if(check_pattern_meethil(bstr,blen))  // check meethu & meetyhil
			return true;
		else if(check_pattern_meethu(bstr,blen))
			return true;
		else
			return false;
} // end of function check_meethu_meethil



public static boolean check_pattern_meethil(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = meethil.length;
	if(blen <= len)
		return false;
	if(ByteMeth.endsWith(bstr,meethil))
	{
		jc.addItem("string is correct");
		return true;
	}
	byte im[]={23},meeth[]={23,4,20},thil[]={20,3,26},mee[]={23,4},il[]={26},il1[]={3,26};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	if(ByteMeth.endsWith(bstr,thil)||(ByteMeth.endsWith(bstr,il1)&&ByteMeth.startsWith(end,im))||(ByteMeth.endsWith(bstr,il)&&ByteMeth.startsWith(end,mee)))
	{
		get_sugg(bstr,meethil);
		set_sugg(bstr,meethu);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_meethil

public static boolean check_pattern_meethu(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = meethu.length;
	if(blen <= len)
		return false;
	if(ByteMeth.endsWith(bstr,meedhu))
	{
		jc.addItem("string is correct");
		return true;
	}
	byte im[]={23},meeth[]={23,4,20},thu[]={20,5},mee[]={23,4};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	if(ByteMeth.startsWith(end,meeth)||(ByteMeth.endsWith(bstr,thu)&&ByteMeth.startsWith(end,im)))
	{
		get_sugg(bstr,meethu);
		//set_sugg(bstr,meethil);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_meethu


public static boolean check_keezh(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = keezh.length;
	if(blen <= len)
		return false;
	if(ByteMeth.endsWith(bstr,keezh))
	{
		jc.addItem("string is correct");
		return true;
	}
	byte ik[]={14},eezh[]={4,28},kee[]={14,4},zh[]={28};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	if(blen>=3)
	{
		if(ByteMeth.startsWith(end,kee)||(ByteMeth.endsWith(bstr,zh)&&ByteMeth.startsWith(end,ik))||ByteMeth.endsWith(bstr,eezh))
		{
			get_sugg(bstr,keezh);
			return(true);
		}
		else
			return false;

	}
	else
		return(false);
} // end of function check_pattern_keezh


public static boolean check_mael(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = mael.length;
	if(blen <= len)
		return false;
	if(ByteMeth.endsWith(bstr,mael))
	{
		jc.addItem("string is correct");
		return true;
	}
	byte il[]={26},mae[]={23,8},ael[]={8,26},im[]={23};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	//byte end3456[]={end[2],end[3],end[4],end[5]};
	if(blen>=3)
	{
		if(ByteMeth.startsWith(end,mae)||(ByteMeth.endsWith(bstr,il)&&ByteMeth.startsWith(end,im))||ByteMeth.endsWith(bstr,ael))
		{
			get_sugg(bstr,mael);
			jc.addItem(tabconvert2.revert(end));
			return(true);
		}
		else
			return false;

	}
	else
		return(false);
} // end of function check_pattern_mael


public static boolean check_mun_pin(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = mun.length;
	if(blen <= len)
		return false;
	byte mu[]={23,5},pi[]={22,3},un[]={5,31},in[]={3,31},im[]={23},ip[]={22},nn[]={31};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	if(blen>=3)
	{
		if(ByteMeth.startsWith(end,mu)||ByteMeth.endsWith(bstr,un)||(ByteMeth.startsWith(end,im)&&ByteMeth.endsWith(end,nn)))
		{
			get_sugg(bstr,mun);
			set_sugg(bstr,pin);
			return(true);
		}
		if(ByteMeth.startsWith(end,pi)||ByteMeth.endsWith(bstr,in)||(ByteMeth.startsWith(end,ip)&&ByteMeth.endsWith(end,nn)))
		{
			get_sugg(bstr,pin);
			set_sugg(bstr,mun);
			return(true);
		}
		else
			return false;
	}
	else
		return(false);
} // end of function check_pattern_mun_pin


public static boolean check_naeraaga_maaraaga(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = naeraaga.length;
	if(blen <= len)
		return false;
	byte naer[]={21,8,25},raaga[]={25,2,14,1},nth[]={21},maar1[]={23,2,30},raaga1[]={30,2,14,1},im[]={23};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen),ga[]={14,1};
	byte end3456[]={end[2],end[3],end[4],end[5]};
	if((ByteMeth.endsWith(bstr,aaga)&&ByteMeth.startsWith(end,nth))||ByteMeth.startsWith(end,naer)|| ByteMeth.isEqual(end3456,raaga)||(ByteMeth.endsWith(end,ga)&&ByteMeth.startsWith(end,nth)))
	{
		if(ByteMeth.startsWith(end,nth))
		{
			get_sugg(bstr,naeraaga);
			set_sugg(bstr,maaraaga);
		}
		else
		{
			get_sugg(bstr,maaraaga);
			set_sugg(bstr,naeraaga);
		}
		return(true);
	}
	else if((ByteMeth.endsWith(bstr,aaga)&&ByteMeth.startsWith(end,im))||ByteMeth.startsWith(end,maar1)|| ByteMeth.isEqual(end3456,raaga1)||(ByteMeth.endsWith(end,ga)&&ByteMeth.startsWith(end,im)))
	{
		get_sugg(bstr,maaraaga);
		set_sugg(bstr,naeraaga);
		return(true);
	}
	else
		return false;
} // end of function check_naeraaga_maaraaga

public static boolean check_il(byte[] bstr,int blen)
{
	if(check_pattern_maththiyil(bstr,blen))
		return true;
	else if(check_pattern_pakkaththil(bstr,blen))
		return true;
	else if(check_pattern_ethiril(bstr,blen))
		return true;
	else if(check_pattern_arukil(bstr,blen))
		return true;
	else if(check_pattern_pathil(bstr,blen))
		return true;
	else
		return false;

} // end of function check_il

public static boolean check_ae(byte[] bstr,int blen)
{
	if(check_pattern_namakkidaiye(bstr,blen))
		return true;
	else if(check_pattern_veliye(bstr,blen))
		return true;
	else if(check_pattern_naduve(bstr,blen))
		return true;
	else
		return false;

} // end of function check_ae

public static boolean check_thaguntha(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = thaguntha.length;
	if(blen <= len)
		return false;
	byte thagu[]={20,1,14,5},ntha[]={21,20,1},th[]={20},unth[]={5,21,20};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	byte end456[]={end[3],end[4],end[5]};
	if((ByteMeth.endsWith(bstr,ntha)&&ByteMeth.startsWith(end,th))||ByteMeth.startsWith(end,thagu)||ByteMeth.isEqual(end456,unth))
	{
		get_sugg(bstr,thaguntha);
		return(true);
	}
	else
		return false;

} // end of function check_thaguntha

public static boolean check_uriya(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = uriya.length;
	if(blen <= len)
		return false;
	byte uri[]={5,25,3},iya[]={3,24,1},iy[]={24},riy[]={25,3,24},ya[]={24,1},u[]={5};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	byte end234[]={end[1],end[2],end[3]};
	if((ByteMeth.endsWith(bstr,ya)&&ByteMeth.startsWith(end,u))||ByteMeth.startsWith(end,uri)||ByteMeth.isEqual(end234,riy)||ByteMeth.endsWith(end,iya))
	{
		get_sugg(bstr,uriya);
		return(true);
	}
	else
		return false;

} // end of function check_uriya

public static boolean check_endru(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = endru.length;
	if(blen <= len)
		return false;
	if(ByteMeth.endsWith(bstr,endru))
	{
		jc.addItem("string is correct");
		return true;
	}
	byte en[]={7,31},ndru[]={31,30,5},ae[]={7},u[]={5};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	if((ByteMeth.endsWith(bstr,u)&&ByteMeth.startsWith(end,ae))||ByteMeth.startsWith(end,en)||ByteMeth.endsWith(end,ndru))
	{
		get_sugg(bstr,endru);
		return(true);
	}
	else
		return false;

} // end of function check_endru

public static boolean check_aaga(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = aaga.length;
	if(blen <= len)
		return false;
	if(ByteMeth.endsWith(bstr,aaga))
	{
		jc.addItem("string is correct");
		return true;
	}
	byte aak[]={2,14},ka[]={14,1},aa[]={2},a[]={1};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	if(ByteMeth.endsWith(bstr,ka)||(ByteMeth.startsWith(end,aa)&&ByteMeth.endsWith(end,a))||ByteMeth.startsWith(end,aak))
	{
		get_sugg(bstr,aaga);
		return(true);
	}
	else
		return false;

} // end of function check_aaga

public static boolean check_pattern_namakkidaiye(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = namakkidaiye.length;
	if(blen <= len)
		return false;
	byte na[]={21,1},kidaiye[]={14,3,18,9,24,8},dai[]={18,9,24};
	byte daiye[]={18,9,24,8},namak[]={21,1,23,1,14},ye[]={24,8};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	byte end8910[]={end[7],end[8],end[9]};
	if(ByteMeth.endsWith(bstr,kidaiye)||ByteMeth.startsWith(end,namak)||(ByteMeth.startsWith(end,na)&&(ByteMeth.endsWith(end,daiye)||ByteMeth.isEqual(end8910,dai))))
	{
		get_sugg(bstr,namakkidaiye);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_namakkidaiye

public static boolean check_pattern_veliye(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = veliye.length;
	if(blen <= len)
		return false;
	byte veli[]={27,7,29,3},iye[]={3,9,24,8},dai[]={18,9,24},iv[]={27};
	byte liy[]={29,3,24},ve[]={27,7},iy[]={24},eli[]={7,29,3};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	byte end345[]={end[2],end[3],end[4]},end5[]={end[4]},end234[]={end[1],end[2],end[3]};
	System.out.println("postposition :");
	for(int i=0;i<len;i++)
		System.out.println("byte["+i+"] :" + end[i]);
	System.out.println("string :");
		for(int i=0;i<blen;i++)
		System.out.println("byte["+i+"] :" + bstr[i]);
	if(ByteMeth.endsWith(bstr,iye)||ByteMeth.startsWith(end,veli)||ByteMeth.isEqual(end234,eli)||(ByteMeth.startsWith(end,iv)&&ByteMeth.isEqual(end345,liy))||(ByteMeth.startsWith(end,ve)&&ByteMeth.isEqual(end5,iy)))
	{
		get_sugg(bstr,veliye);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_veliye

public static boolean check_pattern_naduve(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = naduve.length;
	if(blen <= len)
		return false;
	byte nadu[]={21,1,18,5},uve[]={5,27,8},na[]={21,1};
	byte iv[]={27},ve[]={27,8},nad[]={21,1,18},nth[]={21};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	byte end5[]={end[4]};
	if(ByteMeth.endsWith(bstr,uve)||ByteMeth.startsWith(end,nadu)||(ByteMeth.startsWith(end,nth)&&ByteMeth.endsWith(end,ve))||(ByteMeth.startsWith(end,nad)&&ByteMeth.isEqual(end5,iv)))
	{
		get_sugg(bstr,naduve);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_naduve


public static boolean check_ul1_ulla(byte[] bstr,int blen)
{
	if(check_pattern_ul1(bstr,blen))
		return true;
	else if(check_pattern_ulla(bstr,blen))
		return true;
	else
		return false;

} // end of function check_ul1_ulla

public static boolean check_pattern_ul1(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = ul1.length;
	if(blen <= len)
		return false;
	byte u[]={5},l1[]={29},l[]={25};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	if((ByteMeth.endsWith(bstr,l)&&ByteMeth.startsWith(end,u))||ByteMeth.endsWith(bstr,l1)||ByteMeth.startsWith(end,u))
	{
		get_sugg(bstr,ul1);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_ul1

public static boolean check_pattern_ulla(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = ulla.length;
	if(blen <= len)
		return false;
	byte u[]={5},la[]={29,1},a[]={1};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	if(ByteMeth.endsWith(bstr,la)||ByteMeth.startsWith(end,ul1)||(ByteMeth.startsWith(end,u)&&ByteMeth.endsWith(end,a)))
	{
		get_sugg(bstr,ulla);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_ulla


public static boolean check_pattern_maththiyil(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = maththiyil.length;
	if(blen <= len)
		return false;
	byte aththi[]={1,20,20,3},math[]={23,1,20},il[]={26},im[]={23},yil[]={24,3,26},maththi[]={23,1,20,20,3};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	byte end2345[]={end[1],end[2],end[3],end[4]};
	if((ByteMeth.endsWith(bstr,yil)&&ByteMeth.startsWith(end,im))||(ByteMeth.endsWith(bstr,il)&&ByteMeth.startsWith(end,math))||ByteMeth.startsWith(end,maththi)|| ByteMeth.isEqual(end2345,aththi))
	{
		get_sugg(bstr,maththiyil);
		set_sugg(bstr,pakkaththil);
		set_sugg(bstr,arukil);
		set_sugg(bstr,ethiril);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_maththiyil

public static boolean check_pattern_pakkaththil(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = pakkaththil.length;
	if(blen <= len)
		return false;
	byte pakka[]={22,1,14,14,1},aththil[]={1,20,20,3,26},il[]={26},ith[]={20},akkath[]={1,14,14,1,20},ih[]={20},pakkath[]={22,1,14,14,1,20},ip[]={22};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
	byte end23456[]={end[1],end[2],end[3],end[4],end[5]},end5[]={end[4]};
	if(ByteMeth.startsWith(end,pakkath)||ByteMeth.endsWith(bstr,aththil)||(ByteMeth.startsWith(end,pakka)&&(ByteMeth.endsWith(end,il)||ByteMeth.isEqual(end5,ith)))|| ByteMeth.isEqual(end23456,akkath))
	{
		get_sugg(bstr,pakkaththil);
		set_sugg(bstr,ethiril);
		set_sugg(bstr,arukil);
		set_sugg(bstr,maththiyil);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_pakkaththil

public static boolean check_pattern_ethiril(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = ethiril.length;
	if(blen <= len)
		return false;
	byte ethir[]={7,20,3,25},thiril[]={20,3,25,3,26},eth[]={7,20},ir[]={25},ethi[]={7,20,3},il[]={26};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen),end4[]={end[3]};
	if(ByteMeth.startsWith(end,ethir)||(ByteMeth.endsWith(bstr,il)&&ByteMeth.startsWith(end,ethi))||(ByteMeth.startsWith(end,eth)&& ByteMeth.isEqual(end4,ir))||ByteMeth.endsWith(end,thiril))
	{
		get_sugg(bstr,ethiril);
		set_sugg(bstr,arukil);
		set_sugg(bstr,maththiyil);
		set_sugg(bstr,pakkaththil);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_ethiril

public static boolean check_pattern_arukil(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = arukil.length;
	if(blen <= len)
		return false;
	byte a[]={1},il[]={26},kil[]={14,3,26},aruk[]={1,25,5,14},ruk[]={25,5,14},uk[]={5,14},rukil[]={25,5,14,3,26};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen),end4[]={end[3]},end34[]={end[2],end[3]};
	byte end234[]={end[1],end[2],end[3]};
	if(ByteMeth.startsWith(end,aruk)||ByteMeth.endsWith(bstr,rukil)||(ByteMeth.startsWith(end,a)&&(ByteMeth.endsWith(end,kil)||ByteMeth.isEqual(end34,uk)))|| (ByteMeth.isEqual(end234,ruk)&&ByteMeth.endsWith(end,il)))
	{
		get_sugg(bstr,arukil);
		set_sugg(bstr,pakkaththil);
		set_sugg(bstr,ethiril);
		set_sugg(bstr,maththiyil);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_arukil

public static boolean check_pattern_pathil(byte[] bstr,int blen)
{
	ByteMeth ByteMeth=new ByteMeth();
	int len = pathil.length;
	if(blen <= len)
		return false;
	byte ip[]={22},thil[]={20,3,26},pathi[]={22,1,20,3},il[]={26},path[]={22,1,20},ith[]={20};
	byte end[] = ByteMeth.subArray(bstr,blen-len,blen),end4[]={end[3]};
	if((ByteMeth.endsWith(bstr,il)&&ByteMeth.startsWith(end,path))||(ByteMeth.endsWith(bstr,thil)&&ByteMeth.startsWith(end,ip))||ByteMeth.startsWith(end,pathi))
	{
		get_sugg(bstr,pathil);
		set_sugg(bstr,arukil);
		set_sugg(bstr,ethiril);
		set_sugg(bstr,maththiyil);
		set_sugg(bstr,pakkaththil);
		return(true);
	}
	else
		return false;

} // end of function check_pattern_pathil

public void actionPerformed(ActionEvent ae)
{
}	// end of function actionPerformed

public static void main(String args[])
	{
		Hpostposition postposition = new Hpostposition();

	}
}

