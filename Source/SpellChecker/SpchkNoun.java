package SpellChecker;

/***********************************************************************

............  Spellchecker for noun with User Interface  ..............

************************************************************************/

//   RCILTS - Tamil,
//   Anna University,
//   Chennai.


import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import analyser.*;

public class SpchkNoun extends JFrame implements ActionListener
{
	static JButton check = new JButton("Check");       // Check & Ok are two buttons
	static JButton close = new JButton("Close");

	Font f=new Font("TAB-Anna",4,16);

	//static JTextField text1 = new JTextField("ñóî¢î¤ô¢",16);  //text field to get the user input
	static JComboBox text1 = new JComboBox();
	static JTextArea text2 = new JTextArea(10,30);     //text field to print the output
	static JTextField text3 = new JTextField("ñóî¢î¤ô¢",20);

	static JComboBox jc = new JComboBox();
    JFrame main;
	static JPanel p1 = new JPanel();
	static JScrollPane p2 = new JScrollPane(text2);
	static JPanel p3 = new JPanel();


	static String sug_after_th[] = {"ä","Ýô¢","Þô¢","Þù¢"};
	static String sug_after_il[] = {"ä","Ýô¢","Þô¢","Þù¢","Ý"};
	static String sug_after_in[] = {"ä","Ýô¢","Ü¶","Þô¢"};
	static String sug_after_it[] = {"ä","Ýô¢","Þô¢","Þù¢","àè¢°","Ý"};
	static String sug_after_iv[] = {"ä","Ýô¢","Þô¢","Þù¢","Ýè","æ´","àè¢°"};
	static String sug_after_iy[] = {"Ýô¢","Þô¢","Þù¢","àè¢°","Ý"};	   // "ò¢"
	static String sug_after_kal[] = {"ä","Ýô¢","Þô¢","Þù¢","Ý","Ü¶"};


	static byte ai[]={9}; // "ä"
	static byte kku[]={14,14,5};  // "è¢°"
	static byte kal[]={14,1,29};static byte ukku[]={5,14,14,5};static byte irku[]={3,30,14,5};static byte ku[]={14,5};
	static byte il[]={3,26};static byte aal[]={2,26};static  byte itam[]={3,18,1,23};
	static byte irunthu[]=tabconvert2.convert("Þ¼ï¢¶");
	static byte utan[]=tabconvert2.convert("àìù¢");static byte aaga[] = {2,14,1};
	static byte l[]={26};static byte akka[]={2,14,1};static byte udia[]={5,18,9,24,1};
	static byte[] odu1 = {11,18,5};
	static byte th[]={20};static byte kk[]={14};static byte kkk[]={14,14};static byte nthth[]={21,20};
	static byte ukk[]={5,14,14};static byte udiadu[] = {5,18,9,24,1,20,5};static byte nth[]={21};byte ya[]={24,1};
	static byte ita[]={3,18,1};static byte in[] = {3,31};static byte adu[] = {1,20,5};

	static String suggest="";static String suggArray[];

	static BTree bTree = new BTree();

	//Adjacent keys
	static byte AdjKey_o1[]={3,25,5,11,10,35};
		static byte AdjKey_a[]={2,35,4,3};
		static byte AdjKey_a1[]={4,1};
		static byte AdjKey_yea1[]={7,9};
		static byte AdjKey_u1[] = {5,9,4,3}; //u1=6
		static byte AdjKey_u[] = {6,9,3,13,11,10};
		static byte AdjKey_e1[] = {2,6,1,3}; // e1=4
		static byte AdjKey_auv[] = {3,1,11}; // auv=12
		static byte AdjKey_e[] = {4,6,1,5,12};
		static byte AdjKey_o[] = {5,13,11};
		static byte AdjKey_ou[] = {6,9,3,13,11,10};
		static byte AdjKey_nn[] = {18,16,20,21};  // nn=19
		static byte AdjKey_n[] = {30,18,22,23}; // n=31
		static byte AdjKey_m[] = {31,18,22,20,25}; // m=23
		static byte AdjKey_th[] = {18,19,23,21}; // th=20
		static byte AdjKey_yea[] = {8,29,14,27,15};
		static byte AdjKey_yi[] = {16,17,21,28};
		static byte AdjKey_va[] = {15,10,7}; // va=27
		static byte AdjKey_ng[] = {27};      // ng=15
		static byte AdjKey_ya[] = {16,21,28};
	//static byte AdjKey_ukku[]={35,6,36,9,3,10,11}

		//byte AdjKey[][] = new byte[30][];//
		//byte[] trettt = {30,18,22,23}; // n=31
		//AdjKey[0][] = trettt;
		//static byte AdjKey[24][] = {16,21,28};  // ya
//		byte AdjKey[][] = {20}{16,21,28};


		/**********************************

		Adjacent keys for all the letters in byte

		***********************************/

//Pronounsiation& Bytecode		    a / 1	  aa/2		e / 3		ee / 4		u / 5			uu/6		yea / 7			 yeaa / 8			ai/9		o/10		oo/11	  auv/12				ka/14		 nga/15		  sa / 16	  Nga/17	ta / 18		  Na / 19		tha/20		  sp - na/21			pa / 22			ma / 23			ya/24	   ra/25		la / 26		va / 27		zha/28	  La / 29		 Ra / 30		na / 31
		static byte AdjKey[][] = {{2,35,4,3},{4,1},{4,6,1,5,12,11},{2,6,1,3},{6,3,9,10,11,13},{4,9,3,5},{8,29,13,14,27,15},{9,35,29,37,13,7},{6,8,5,13},{5,13,11,27},{3,5,12,10},{1,3,11},{},{29,37,30,7,22,15,26},{7,14,27,26},{19,17,21,24},{16,24},{31,19,22,20},{18,16,20,21},{18,19,23,21},{19,16,20,24,28},{30,31,14,23,26,25},{31,18,22,20,25},{16,21,28},{22,23,26},{14,22,15,25},{13,7,10,15},{21,24},{8,36,30,7,14},{29,31,14,22},{30,18,22,23}};




		// Internal code for Similar sounding letters

		static byte na[] = {19,31};   // Na,na
		static byte la[] = {29,26,28}; // La,la,zha
		static byte ra[] = {25,30};    // ra,Ra

	public SpchkNoun()
	{

		bTree.updateDictTree("dic1.txt");
		//bTree.printTree();
		setTitle("SpellChecker");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int ht = d.height;
		int wid = d.width;
        setSize(700,340);
		setLocation((wid-700)/2,(ht-340)/2);
		Image img = tk.getImage(".\\GIF.GIF");
		setIconImage(img);

		p1.add(text1);
		//p1.add(text3);

		p3.add(jc);
		p3.add(check);
		p3.add(close);

		//text2.setBackground(Color.yellow);

		text1.setFont(f);
		text1.setEditable(true);
		text1.addItem("");
		 //text1.addItem("ñóî¢î¤ô¢");
  	 	text1.addItem("ñ£Âè¢èè");
		text1.addItem("ñóî¢î¤÷¢");
		text1.addItem("ðìî¢îø¢°");
		text1.addItem("ðìî¢î£÷¢");
		text1.addItem("ñóî¢î¤ì£ñ¢");
		text1.addItem("ñóî¢¶ìñ¢");
		text1.addItem("ñóî¢É¬ìò");
		//text1.addItem("ñóî¢¶è¢Ã");
		text1.addItem("ñóî¢î¤ô¤Ïï¢¶");
		text1.addItem("ñóî¢î¤ô¤¼ù¢¶");
		text1.addItem("Üõù£¶");
		text1.addItem("Üõªù£´");
		text1.addItem("ÜõÂ¬ìò£¶");
		text1.addItem("ñóé¢èô¢");

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


	public void sugg_from_dictionary(byte[] string,byte[] start,byte[] end)
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
						//jc.addItem(temp);
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
		boolean searchresult=false;

		suggest="";
		boolean status = check_itam_utan(bstr,blen);
		if(status)
			{
				text2.setText(jc.getItemAt(1).toString());
				return suggest;
			}
		else
			{
				status = check_il_aal(bstr,blen);
				if(status)
					{
						text2.setText(jc.getItemAt(1).toString());
						return suggest;
					}
				else
					{
						status = check_udia(bstr,blen);
						if(status)
							{
								text2.setText(jc.getItemAt(1).toString());
								return suggest;
							}
						else
							{
								status = check_u(bstr,blen);
								if(status)
									{
										text2.setText(jc.getItemAt(1).toString());
										return suggest;
									}
								else
									{
										status = check_aaga(bstr,blen);
										if(status)
											{
												text2.setText(jc.getItemAt(1).toString());
												return suggest;
											}
										else
											{
												status = check_kal(bstr,blen);;
												if(status)
													{
														text2.setText(jc.getItemAt(1).toString());
														return suggest;
													}
												else
													{
														if(ByteMeth.endsWith(bstr,ai))
															{
																text2.setText(jc.getItemAt(1).toString());
																return suggest;
															}
														else
															{
																System.out.println("no match");
																return strin;

															}
													}
											}
									}
							}
					}
			}

	}	// end of function checker


	public static boolean dicsearch(String root)// throws IOException
	{
		return bTree.contains(new String(root));
	} // ens of function dicsearch



	public static boolean check_u(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		if(blen <= 6)
			return false;
		byte lstlet = bstr[blen-1];
		byte lstlet2 = bstr[blen-2];
		byte lstlet3 = bstr[blen-3];
		byte lstlet43[] = {bstr[blen-4],lstlet3};
		byte lstlet543[] = {bstr[blen-5],bstr[blen-4],lstlet3};
		System.out.println(" i am in cueck_u");
		if(ByteMeth.endsWith(bstr,ukku)||ByteMeth.endsWith(bstr,udiadu)||ByteMeth.endsWith(bstr,irunthu)||ByteMeth.endsWith(bstr,odu1)||ByteMeth.endsWith(bstr,adu))
		{
			text2.setText("string is correct");
			return(true);
		}
		else if(check_pattern_ukku(bstr,ukku))
		{
			System.out.println("ukku-irku");
			set_sugg(bstr,ukku);
			get_sugg(bstr,irku);
			return(true);
		}
		else if(check_pattern_odu1(bstr,odu1))
		{
			set_sugg(bstr,odu1);
			get_sugg(bstr,adu);
			return(true);
		}
		else if(check_pattern_irunthu(bstr,irunthu))
		{
			set_sugg(bstr,irunthu);
			return(true);
		}
		else if(check_pattern_udiadu(bstr,udiadu))
		{
			set_sugg(bstr,udiadu);
			return(true);
		}
		else if(check_pattern_adu(bstr,adu))
		{
				set_sugg(bstr,adu);
				get_sugg(bstr,odu1);
				return(true);
		}
		else
			return(false);

	} // end of function check_u

	public static void set_sugg(byte[] bstr,byte[] marker)
	{
		ByteMeth ByteMeth=new ByteMeth();
		int len = marker.length,blen = bstr.length;
		byte rem[] = ByteMeth.subArray(bstr,0,blen-len);
		suggest = tabconvert2.revert(ByteMeth.addArray(rem,marker));
		jc.addItem(suggest);
		HSugg.model.addElement(suggest);
		noun5_temp.tf1.addItem(suggest);
	} // end of function set_sugg


	public static void get_sugg(byte[] bstr,byte[] marker)
	{
		System.out.println("str in set_sugg :" + tabconvert2.revert(bstr));
		ByteMeth ByteMeth=new ByteMeth();
		int len = marker.length,blen = bstr.length;
		byte rem[] = ByteMeth.subArray(bstr,0,blen-len);
		String str = tabconvert2.revert(ByteMeth.addArray(rem,marker));
		jc.addItem(str);
		HSugg.model.addElement(str);
	} // end of function get_sugg



	public static boolean check_pattern_ukku(byte[] bstr,byte[] marker)
	{
		ByteMeth ByteMeth=new ByteMeth();
		int blen = bstr.length;
		int len = marker.length;
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen),uk[]={5,14};
		byte end12[] = {end[0],end[1]};byte end34[] = {end[2],end[3]};byte end234[] = {end[1],end[2],end[3]};
		if(ByteMeth.isEqual(end12,uk) || ByteMeth.isEqual(end34,ku) || ByteMeth.isEqual(end234,kku))
			{
				System.out.println("ukku-pattern");
				return(true);
			}
		else
			return(false);
	} // end of function check_pattern_ukku




	public static boolean check_pattern_adu(byte[] bstr,byte[] marker)
	{
		ByteMeth ByteMeth=new ByteMeth();
		int blen = bstr.length;
		int len = marker.length;
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen),thu[]={20,5},ath[]= {1,20};
		byte end12[] = {end[0],end[1]};byte end23[] = {end[1],end[2]};
		if(ByteMeth.isEqual(end12,ath) || ByteMeth.isEqual(end23,thu))
			return(true);
		else
			return(false);
	} // end of function check_pattern_adu

	public static boolean check_pattern_odu1(byte[] bstr,byte[] marker)
	{
		ByteMeth ByteMeth=new ByteMeth();
		int blen = bstr.length;
		int len = marker.length;
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen),od[]={11,18},o[]={11},du[]={18,5};
		byte end1[] = {end[0]},end12[] = {end[0],end[1]};byte end23[] = {end[1],end[2]};
		if(ByteMeth.isEqual(end12,od) || ByteMeth.isEqual(end23,du) || ByteMeth.isEqual(end1,o))
			return(true);
		else
			return(false);
	} // end of function check_pattern_odu1

	public static boolean check_pattern_irunthu(byte[] bstr,byte[] marker)
	{
		ByteMeth ByteMeth=new ByteMeth();
		int blen = bstr.length;
		int len = marker.length;
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
		byte iru[]={3,25,5},runth[]={25,5,21},nthu[]={21,20,5};
		byte end456[] = {end[3],end[4],end[5]},end234[] = {end[1],end[2],end[3]};byte end123[] = {end[0],end[1],end[2]};
		if(ByteMeth.isEqual(end123,iru) || ByteMeth.isEqual(end234,runth) || ByteMeth.isEqual(end456,nthu))
			return(true);
		else
			return(false);
	} // end of function check_pattern_irunthu

	public static boolean check_pattern_udiadu(byte[] bstr,byte[] marker)
	{
		ByteMeth ByteMeth=new ByteMeth();

		int blen = bstr.length;
		int len = marker.length;
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen);
		byte udi[]={5,18,9},dia[]={18,9,24,1},yadu[]={24,1,20,5};
		byte end123[] = {end[0],end[1],end[2]};byte end4567[] = {end[3],end[4],end[5],end[6]},end2345[] = {end[1],end[2],end[3],end[4]};
		if(ByteMeth.isEqual(end123,udi) || ByteMeth.isEqual(end2345,dia) || ByteMeth.isEqual(end4567,yadu))
			return(true);
		else
			return(false);
	} // end of function check_pattern_udiadu


	public static boolean check_il_aal(byte[] bstr,int blen)
	{
				ByteMeth ByteMeth=new ByteMeth();
				byte n1[]={19};
				if(blen < il.length)
					return false;
				byte lstlet = bstr[blen-1];
				byte lstlet2 = bstr[blen-2];
				byte lstlet3 = bstr[blen-3];
				System.out.println("str in check_il_ALL before if(1):" + tabconvert2.revert(bstr));
				if((ByteMeth.endsWith(bstr,il))||(ByteMeth.endsWith(bstr,aal)))
				{
					text2.setText("string is correct");
					return(true);
				}
				else if(((lstlet2 == 3)||(lstlet2 == 2)||(lstlet == 26))&&(lstlet3 != 14))
				{
					if((lstlet2 == 2))
					{
						set_sugg(bstr,aal);
						get_sugg(bstr,il);
						get_sugg(bstr,in);
						return(true);
					}
					else if((lstlet2 == 3))
					{
						if(ByteMeth.endsWith(bstr,n1))
						{
							set_sugg(bstr,in);
							get_sugg(bstr,il);
						}
						else
						{	set_sugg(bstr,il);
							get_sugg(bstr,in);
						}
						get_sugg(bstr,aal);
						return(true);
					}










					else
					{
						set_sugg(bstr,aal);
						get_sugg(bstr,il);
						get_sugg(bstr,in);
						return(true);
					}
				}
				else
					return(false);


		} // end of function check_il_aal

	public static boolean check_itam_utan(byte[] bstr,int blen)
		{
				ByteMeth ByteMeth=new ByteMeth();
				if(blen <= utan.length)
					return false;

				byte[] temp = bstr;
				byte tam[]={18,1,23},it[]={3,18},ut[]={5,18};
				byte lstlet = bstr[blen-1];
				byte lstlet2 = bstr[blen-2];
				byte bstr1[]= new byte[blen-1],bstr2[]= new byte[blen-2];//last char is trimmed
				System.out.println("str in beginning of check_itam_utan :" + tabconvert2.revert(bstr));
				if(ByteMeth.endsWith(bstr,itam)||ByteMeth.endsWith(bstr,utan))
				{
					text2.setText("string is correct");
					return(true);
				}
				for(int t=0;t<blen-1;t++)
					bstr1[t]=bstr[t];
				for(int t=0;t<blen-2;t++)
					bstr2[t]=bstr[t];
				if(ByteMeth.endsWith(bstr1,ita) || ByteMeth.endsWith(bstr,tam)||ByteMeth.endsWith(bstr2,it))
				{													// itam
					set_sugg(bstr,itam);
					get_sugg(bstr,utan);
					return(true);
				}
				else if(ByteMeth.endsWith(bstr1,tabconvert2.convert("àì"))||ByteMeth.endsWith(bstr,tabconvert2.convert("ìù¢"))||ByteMeth.endsWith(bstr2,ut))
				{
					set_sugg(bstr,utan);
					get_sugg(bstr,itam);
					return(true);
				}

				// Check all the adjacent key of a1
				else if(lstlet2 == 2)
				{
					for(int i=0;i<2;i++)
						{
							temp[blen-2]=AdjKey_a1[i];
							if(check_itam_utan(temp,blen))
							{
								suggest = tabconvert2.revert(temp);
								jc.addItem(suggest);
								return(true);
							}
						}
					return(false);
				}

				else
					{
						System.out.println("utan-false");
						return(false);
					}
		} // end of function check_itam_utan

	public static boolean check_udia(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		if(blen < udia.length)
			return false;
		boolean enter_if=false;
		String split1 ,sugg;
		byte rem[];
		byte[] temp = bstr;
		byte lstlet = bstr[blen-1];
		byte lstlet2 = bstr[blen-2];
		byte lstlet3 = bstr[blen-3];
		byte lstlet8 = bstr[blen-8];
		byte bstr1[]= new byte[blen-1],bstr2[]= new byte[blen-2];//last char is trimmed
		System.out.println("in udia");
		if(ByteMeth.endsWith(bstr,udia))
		{
			text2.setText("string is correct");
			return(true);
		}

		for(int t=0;t<blen-1;t++)
			bstr1[t]=bstr[t];
		for(int t=0;t<blen-2;t++)
			bstr2[t]=bstr[t];
		if(ByteMeth.endsWith(bstr1,tabconvert2.convert("à¬ìò¢")) || ByteMeth.endsWith(bstr2,tabconvert2.convert("à¬ì")) || ByteMeth.endsWith(bstr2,tabconvert2.convert("¬ì")) || ByteMeth.endsWith(bstr,tabconvert2.convert("¬ìò")))
		{																										// udi										// di											// dia
			split1 = "à¬ìò";
			rem = ByteMeth.subArray(bstr,0,blen-5);
			suggest = tabconvert2.revert(ByteMeth.addArray(rem,tabconvert2.convert(split1)));
			jc.addItem(suggest);
			noun5_temp.tf1.addItem(suggest);
			return(true);
		}

		// Checking all the adjacent key of yea1
		// Check it's with a1 adjacent keys
		else if(lstlet3==8)
		{

			for(int i=0;i<2;i++)
			{
				temp[blen-3]=AdjKey_yea1[i];
				if(check_udia(temp,blen))
				{
					suggest = tabconvert2.revert(temp);
					jc.addItem(suggest);
					return(true);
				}
			}
			return(false);

		}

		// Check it's with u adjacent keys

		else if(lstlet3==5)
		{

			for(int i=0;i<2;i++)
			{
				temp[blen-3]=AdjKey_u[i];
				if(check_udia(temp,blen))
				{
					suggest = tabconvert2.revert(temp);
					jc.addItem(suggest);
					return(true);
				}
			}
			return(false);

		}

		else if(lstlet2==16)
				{

					for(int i=0;i<2;i++)
					{
						temp[blen-3]=AdjKey_ya[i];
						if(check_udia(temp,blen))
						{
							suggest = tabconvert2.revert(temp);
							jc.addItem(suggest);
							return(true);
						}
					}
					return(false);

		}



		else
			return(false);
	} // end of function check_udia


	public static boolean check_aaga(byte[] bstr,int blen)
		{
			ByteMeth ByteMeth=new ByteMeth();
			if(blen < aaga.length)
				return false;
			String sugg="";
			byte rem[];
			byte lstlet = bstr[blen-1];
			byte lstlet2 = bstr[blen-2];
			byte bstr1[]= new byte[blen-1],bstr2[]= new byte[blen-2];//last char is trimmed
			if(ByteMeth.endsWith(bstr,aaga))
			{
				text2.setText("string is correct");
				return(true);
			}
			else
			{
				for(int t=0;t<blen-1;t++)
					bstr1[t]=bstr[t];
				for(int t=0;t<blen-2;t++)
					bstr2[t]=bstr[t];
				if(ByteMeth.endsWith(bstr1,tabconvert2.convert("Ýè¢")) || ByteMeth.endsWith(bstr2,tabconvert2.convert("Ý")) || ByteMeth.endsWith(bstr,tabconvert2.convert("è")))
					{									// aak											// aa										 // ka
						String split1 = "Ýè";
						System.out.println("aaga");
						rem = ByteMeth.subArray(bstr,0,blen-3);
						suggest = tabconvert2.revert(ByteMeth.addArray(rem,tabconvert2.convert(split1)));
						jc.addItem(suggest);
						noun5_temp.tf1.addItem(suggest);
						return(true);
					}

				else
					{
						System.out.println("false - aaga");
						return(false);
					}
			}


		} // end of function check_aaga

	public static boolean check_kal(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		if(blen < kal.length)
			return false;
		boolean searchresult = false;
		String split1 ,sugg;
		byte rem[],al1[]={1,29},th[]={20},nk[]={15};;
		byte lstlet = bstr[blen-1];
		byte bstr1[]= new byte[blen-1],bstr2[]= new byte[blen-2],bstr3[]= new byte[blen-3];//last char is trimmed
		for(int t=0;t<blen-1;t++)
			bstr1[t]=bstr[t];
		/*for(int t=0;t<blen-3;t++)
			bstr3[t]=bstr[t];*/
		if(ByteMeth.endsWith(bstr,kal))
			{
				text2.setText("string is correct");
				return(true);
			}
		else if(searchresult = dicsearch(tabconvert2.revert(bstr)))
		{
			return false;
		}
		else if(ByteMeth.endsWith(bstr1,tabconvert2.convert("è")) || lstlet == 29)  // if ends with '÷¢'
			{																// kal
				split1 = "è÷¢";
				rem = ByteMeth.subArray(bstr,0,blen-3);
				suggest = tabconvert2.revert(ByteMeth.addArray(rem,tabconvert2.convert(split1)));
				System.out.println(suggest);
				jc.addItem(suggest);
				noun5_temp.tf1.addItem(suggest);
				return(true);
			}
		else
			return(false);

	} // end of function check_kal

/*	public static String getsugg_th(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		String sugg[] = new String[4];
		for(int i=0;i<4;i++)
		{
			if(sug_after_th[i] == "ä")
				{
					byte rem[] = ByteMeth.subArray(bstr,0,blen-2);
					sugg[i] = tabconvert2.revert(ByteMeth.addArray(rem,ai));
				}
			else
				{
					sugg[i] = changearr(bstr,tabconvert2.convert(sug_after_th[i]));
				}
			noun5_temp.sete(sugg[i]);
			jc.addItem(sugg[i]);
			noun5_temp.tf1.addItem(suggest);
			System.out.println(sugg[i]);
		}
		return(sugg[1]);
	}		// end of function getsugg_th



	public static String getsugg_il(byte[] bstr,int blen)
		{
			ByteMeth ByteMeth=new ByteMeth();
			String sugg[] = new String[5];
			byte rem[] = ByteMeth.subArray(bstr,0,blen-2);
			for(int i=0;i<5;i++)
			{
				sugg[i] = tabconvert2.revert(ByteMeth.addArray(rem,tabconvert2.convert(sug_after_il[i])));
				noun5_temp.sete(sugg[i]);
				jc.addItem(sugg[i]);
				noun5_temp.tf1.addItem(suggest);
				System.out.println(sugg[i]);
			}
			return(sugg[1]);
		}		// end of function getsugg_il

	public static String getsugg_in(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		String sugg[] = new String[4];
		for(int i=0;i<4;i++)
		{
			if(sug_after_in[i] == "ä")
				{
					byte rem[] = ByteMeth.subArray(bstr,0,blen-2);
					sugg[i] = tabconvert2.revert(ByteMeth.addArray(rem,ai));
				}
			else if(sug_after_in[i] == "Ü¶")
				{
					byte rem[] = ByteMeth.subArray(bstr,0,blen-2);
					sugg[i] = tabconvert2.revert(ByteMeth.addArray(rem,tabconvert2.convert(sug_after_in[2])));
				}
			else
				{
					sugg[i] = changearr(bstr,tabconvert2.convert(sug_after_in[i]));
				}
			noun5_temp.sete(sugg[i]);
			jc.addItem(sugg[i]);
			noun5_temp.tf1.addItem(suggest);
			System.out.println(sugg[i]);
		}
		return(sugg[1]);
	}		// end of function getsugg_in


	public static String getsugg_it(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		String sugg[] = new String[6];
		byte rem[];
		for(int i=0;i<6;i++)
		{
			if(sug_after_it[i] == "Ý")
				rem = ByteMeth.subArray(bstr,0,blen-3);
			else
				rem = ByteMeth.subArray(bstr,0,blen-2);
			sugg[i] = tabconvert2.revert(ByteMeth.addArray(rem,tabconvert2.convert(sug_after_it[i])));
			noun5_temp.sete(sugg[i]);
			jc.addItem(sugg[i]);
			noun5_temp.tf1.addItem(suggest);
			System.out.println(sugg[i]);
		}
		return(sugg[1]);
	}		// end of function getsugg_it


	public static String getsugg_iv(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		String sugg[] = new String[7];
		byte rem[] = ByteMeth.subArray(bstr,0,blen-2);
		for(int i=0;i<7;i++)
		{
				sugg[i] = tabconvert2.revert(ByteMeth.addArray(rem,tabconvert2.convert(sug_after_iv[i])));
				noun5_temp.sete(sugg[i]);
				jc.addItem(sugg[i]);
				noun5_temp.tf1.addItem(suggest);
				System.out.println(sugg[i]);
		}
		return(sugg[1]);
	}		// end of function getsugg_iv



	public static String getsugg_iy(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		String sugg[] = new String[5];
		for(int i=0;i<5;i++)
		{
			if(sug_after_iy[i] == "àè¢°")
				{
					byte rem[] = ByteMeth.subArray(bstr,0,blen-3);
					sugg[i] = tabconvert2.revert(ByteMeth.addArray(rem,kku));
				}
			else if(sug_after_iy[i] == "Ý")
				{
					byte rem[] = ByteMeth.subArray(bstr,0,blen-2);
					sugg[i] = tabconvert2.revert(ByteMeth.addArray(rem,tabconvert2.convert(sug_after_iy[i])));
				}
			else
				{
					sugg[i] = changearr(bstr,tabconvert2.convert(sug_after_iy[i]));
				}
			noun5_temp.sete(sugg[i]);
			jc.addItem(sugg[i]);
			noun5_temp.tf1.addItem(suggest);
			System.out.println(sugg[i]);
		}
		return(sugg[1]);
	}		// end of function getsugg_iy


	public static String getsugg_kal(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		String sugg[] = new String[6];
		byte rem[] = ByteMeth.subArray(bstr,0,blen-2);
		for(int i=0;i<6;i++)
		{
			sugg[i] = tabconvert2.revert(ByteMeth.addArray(rem,tabconvert2.convert(sug_after_kal[i])));
			noun5_temp.sete(sugg[i]);
			jc.addItem(sugg[i]);
			noun5_temp.tf1.addItem(suggest);
			System.out.println(sugg[i]);
		}
		return(sugg[1]);
	}		// end of function getsugg_kal*/


	public void actionPerformed(ActionEvent ae)
	{
	}	// end of function actionPerformed

	public static void main(String args[])
		{
			SpchkNoun sp = new SpchkNoun();

		}
}

