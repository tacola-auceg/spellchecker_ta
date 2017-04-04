package SpellChecker;

//    .............  Spellchecker with User Interface  ..............
//    .............  			verb endings           ..............

import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import analyser.*;

public class Spchkverb extends JFrame implements ActionListener
{
	static JButton check = new JButton("Check");       // Check & Ok are two buttons
	static JButton close = new JButton("Close");
	Font f=new Font("TAB-Anna",4,14);
	//static JTextField text1 = new JTextField("Éé¢°è¤í¢ªøù¢",30);  //text field to get the user input
	static JComboBox text1 = new JComboBox();
	static JTextArea text2 = new JTextArea(10,30);     //text field to print the output
	static JTextField text3 = new JTextField("",20);
	JFrame main;

	static JComboBox jc = new JComboBox();

	static JPanel p1 = new JPanel();
	static JScrollPane p2 = new JScrollPane(text2);
	static JPanel p3 = new JPanel();

	static byte eerkal[]={4,25,14,1,29}; // "ß£¢è÷¢"
	static byte aarkal[]={2,25,14,1,29};  // "Ý£¢è÷¢"
	static byte om[]={11,23}; // "æñ¢"
	static byte yen[]={8,31};static byte eer[]={4,25};
	static byte aan[]={2,31};static byte aal[]={2,29};static byte aar[]={2,25};
	static byte athu[]={1,20,5};
	static byte ana[]={1,31,1};
	static byte kal[]={14,1,29};static byte rka[]={25,14,1};
	static byte kiru[]={14,3,30,5};
	static byte kindru[]={14,3,31,30,5},tempbstr[]=null;
	static String suggest="";
	public Spchkverb()
	{
		setTitle("SpellChecker");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int ht = d.height;
		int wid = d.width;

		//setSize(wid/2,ht/2);
		//setLocation(wid/4,ht/4);
		setSize(600,350);
        setLocation((int)(wid-600)/2,(int)(ht-350)/2);
		Image img = tk.getImage(".\\Hlpglobe.GIF");
		setIconImage(img);

		p1.add(text1);
		//p1.add(text3);
		text1.addItem("");
		text1.addItem("ªêò¢î£¶");
		text1.addItem("Éé¢°è¤í¢ªøù¢");
		text1.addItem("ð®ð¢ªðù¢");
		text1.addItem("Ü¿ªõù¢");
		text1.addItem("Ü¿ªõù");
		text1.addItem("«èì¢ðù¢");
		text1.addItem("Ìì¢´õó¢è÷¢");
		text1.addItem("ªêò¢îó¢");
		text1.addItem("ªêò¢ªî£ñ¢");
		p3.setLayout(new FlowLayout(1));
		p3.add(jc);
		p3.add(check);
		p3.add(close);

		//text2.setBackground(Color.yellow);


		text1.setFont(f);
		text2.setFont(f);
		text3.setFont(f);

		text1.setEditable(true);
		jc.setFont(f);


		//jc.addItem("Suggestion");

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

	public static String spellcheck(String strin)
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
				System.out.println("temp1"+temp1);
				temp1=temp1+wordstack.pop().toString();
			}
			int len4=temp1.length();
		     //jc.addItem(temp1);
			//temp2="     "+temp1.substring(0,len4-1);
			jc.addItem(temp2);
			return(temp2);

		} // end of function spellcheck


	public static String checker(String strin)  //it checks for special cases,
	{							  	     //searches the dictionary & returns
		ByteMeth ByteMeth=new ByteMeth();
		byte bstr[] = tabconvert2.convert(strin);
		System.out.println("bstr in checker :" + tabconvert2.revert(bstr));
		System.out.println("str in checker :" + strin);
		int blen = bstr.length;
		String temp1="",temp2="";
		Stack s1;

		//jc.addItem("Suggestion");
		String temp;

		boolean status = check_eerkal_aarkal(bstr,blen);
		if(status)
			{
				text2.setText(jc.getItemAt(1).toString());
				return suggest;
			}
		else
			{
				 status = check_kiru_kindru(bstr,blen);
				 if(status)
				 {
					 text2.setText(jc.getItemAt(1).toString());
					 return(suggest);
				 }
				 else
					{
						status = check_athu(bstr,blen);
						if(status)
							{
								text2.setText(jc.getItemAt(1).toString());
								return suggest;
							}
						else
							{

								status = check_ana(bstr,blen);
								if(status)
									{
										text2.setText(jc.getItemAt(1).toString());
										return suggest;
									}
								else
									{
										status = check_aal_aan_aar_yen_om_eer(bstr,blen);
										if(status)
											{
												text2.setText(jc.getItemAt(1).toString());
												return suggest;
											}
										else
											{
												return strin;

											}
									}
							}
					}
			}

	}	// end of function checker

	public static boolean check_eerkal_aarkal(byte[] bstr,int blen)
	{
		if(blen < eerkal.length)
			return false;
		System.out.println("str in chk_er_ar :" + tabconvert2.revert(bstr));
		ByteMeth ByteMeth=new ByteMeth();
		if(ByteMeth.endsWith(bstr,eerkal)||ByteMeth.endsWith(bstr,aarkal))
		{
			text2.setText("str is correct");
			return true;
		}
		else if(check_pattern_eerkal(bstr))
		{
		 	get_sugg(bstr,eerkal);
			set_sugg(bstr,aarkal);
			return(true);
		}
		else if(check_pattern_aarkal(bstr))
		{
			get_sugg(bstr,aarkal);
			set_sugg(bstr,eerkal);
			return(true);
		}
		else
			return(false);
	}	// end of function check_eerkal_aarkal

	public static boolean check_athu(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		if(blen < athu.length)
			return false;
		if(ByteMeth.endsWith(bstr,athu))
		{
			text2.setText("str is correct");
			return true;
		}
		else if(check_pattern_athu(bstr))
		{
			get_sugg(bstr,athu);
			set_sugg(bstr,ana);
			return(true);
		}
		else
			return(false);
	}	// end of function check_athu

	public static boolean check_ana(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		if(blen < ana.length)
			return false;
		if(ByteMeth.endsWith(bstr,ana))
		{
			text2.setText("str is correct");
			return true;
		}
		else if(check_pattern_ana(bstr))
		{
			get_sugg(bstr,ana);
			//set_sugg(bstr,aan);
			set_sugg(bstr,athu);
			return(true);
		}
		else
			return(false);
	}	// end of function check_ana

	/*public static boolean check_eer(byte[] bstr,int blen)
		{
			ByteMeth ByteMeth=new ByteMeth();
			if(ByteMeth.endsWith(bstr,eer))
			{
				text2.setText("str is correct");
				return true;
			}
		else if(check_pattern_eer(bstr))
			{
				get_sugg(bstr,eer);
				set_sugg(bstr,aar);
				return(true);
			}
			else
				return(false);
	}	// end of function check_eer */

	public static boolean check_aal_aan_aar_yen_om_eer(byte[] bstr,int blen)
	{
		ByteMeth ByteMeth=new ByteMeth();
		if(blen < aal.length)
			return false;
		if(ByteMeth.endsWith(bstr,aal)||ByteMeth.endsWith(bstr,eer)||ByteMeth.endsWith(bstr,aan)||ByteMeth.endsWith(bstr,aar)||ByteMeth.endsWith(bstr,yen)||ByteMeth.endsWith(bstr,om))
		{
			text2.setText("str is correct");
			return true;
		}
		else if(check_pattern_aal_aan_aar_yen_om_eer(bstr))
		{
			/*get_sugg(bstr,aal);
			set_sugg(bstr,aan);
			set_sugg(bstr,aar);
			set_sugg(bstr,yen);
			set_sugg(bstr,om);
			set_sugg(bstr,eer);*/
			return(true);
		}
		/*else if(check_pattern_aan(bstr))
		{
			if(bstr[blen-1] == 1)
			{
				get_sugg(bstr,aan);
				set_sugg(bstr,yen);

			}
			if(bstr[blen-1] == 7)
			{
				get_sugg(bstr,yen);
				set_sugg(bstr,aan);
			}
			set_sugg(bstr,aal);
			set_sugg(bstr,aar);
			set_sugg(bstr,yen);
			set_sugg(bstr,om);
			set_sugg(bstr,eer);
			return(true);
		}
		else if(check_pattern_aar(bstr))
		{
			get_sugg(bstr,aar);
			set_sugg(bstr,aan);
			set_sugg(bstr,aal);
			set_sugg(bstr,yen);
			set_sugg(bstr,om);
			set_sugg(bstr,eer);
			return(true);
		}
		else if(check_pattern_yen(bstr))
		{
			get_sugg(bstr,yen);
			set_sugg(bstr,aal);
			set_sugg(bstr,aan);
			set_sugg(bstr,aar);
			set_sugg(bstr,om);
			set_sugg(bstr,eer);
			return(true);
		}
		else if(check_pattern_om(bstr))
		{
			get_sugg(bstr,om);
			set_sugg(bstr,aal);
			set_sugg(bstr,aan);
			set_sugg(bstr,aar);
			set_sugg(bstr,yen);
			set_sugg(bstr,eer);
			return(true);
		}
		else if(check_pattern_eer(bstr))
		{
			get_sugg(bstr,eer);
			set_sugg(bstr,aal);
			set_sugg(bstr,aan);
			set_sugg(bstr,aar);
			set_sugg(bstr,yen);
			set_sugg(bstr,om);

			return(true);
		}*/
		else
			return(false);
	}	// end of function check_aal_aan_aar_yen

			//	*************    problem with eer & eerkal   ***********

	public static boolean check_kiru_kindru(byte[] bstr,int blen)
		{
			ByteMeth ByteMeth=new ByteMeth();
			if(blen < kiru.length)
				return false;
			if(ByteMeth.endsWith(bstr,kiru)||ByteMeth.endsWith(bstr,kindru))
			{
				text2.setText("str is correct");
				return true;
			}
			else if(check_pattern_kindru(bstr))
			{
				bstr=tempbstr;

				get_sugg(bstr,kindru);
				System.out.println("suggestion kindru :" + suggest);
				//set_sugg(bstr,kiru);
				return(true);
			}
			else if(check_pattern_kiru(bstr))
			{
				bstr=tempbstr;
				get_sugg(bstr,kiru);
				//set_sugg(bstr,kindru);
				return(true);
			}

			else
				return(false);
		}	// end of function check_kiru_kindru

	public static boolean check_pattern_kiru(byte[] bstr)
		{
			ByteMeth ByteMeth=new ByteMeth();
			int blen = bstr.length;
			int len = kiru.length;
			if(blen < len)
				return false;
			byte ru[]={30,5},kir[]={14,3,30},ki[]={14,3},u[]={5};
			byte bstr1[]= new byte[blen-1];
			for(int t=0;t<blen-1;t++)
				bstr1[t]=bstr[t];
			if(ByteMeth.endsWith(bstr,ru)||ByteMeth.endsWith(bstr,kir)||ByteMeth.endsWith(bstr1,ki))
			{
				/*byte rem[] = ByteMeth.subArray(bstr,0,blen-3);
				System.out.println("rem hai******:" + tabconvert2.revert(rem));*/
				//suggest= tabconvert2.revert(ByteMeth.addArray(rem,kiru));
				tempbstr=ByteMeth.addArray(bstr,u);
				return(true);
			}
			else
				return(false);
	}	// end of function check_pattern_kiru



	public static boolean check_pattern_kindru(byte[] bstring)
		{
			ByteMeth ByteMeth=new ByteMeth();
			int blen = bstring.length;
			int len = kindru.length;
			if(blen < len)
				return false;
			byte indru[]={31,30,5},ki[]={14,3},kin[]={14,3,31},u[]={5},indr[]={31,30},r1[]={30},kk[]={14};
			byte bstr1[]= new byte[blen-1],bstr2[]= new byte[blen-2];
			byte end[] = ByteMeth.subArray(bstring,blen-len,blen);
			for(int t=0;t<blen-1;t++)
				bstr1[t]=bstring[t];
			for(int t=0;t<blen-2;t++)
				bstr2[t]=bstring[t];
			System.out.println("string before u added :" + tabconvert2.revert(bstring));
			if(ByteMeth.endsWith(bstring,indru)||ByteMeth.endsWith(bstr2,ki)||ByteMeth.endsWith(bstr1,kin)||ByteMeth.endsWith(bstring,indr))
				{
					tempbstr=ByteMeth.addArray(bstring,u);
					System.out.println("u added string :" + tabconvert2.revert(tempbstr));
					/*if(ByteMeth.endsWith(bstr1,kin))
					{
						bstr=ByteMeth.addArray(bstr,u);
						System.out.println("u added string :" + tabconvert2.revert(bstr));
					}*/
						return(true);
				}
			if(ByteMeth.endsWith(end,r1)&&ByteMeth.startsWith(end,kk))
			{
				tempbstr=ByteMeth.addArray(bstring,u);
				System.out.println("i am sorry" + tabconvert2.revert(tempbstr));

				return(true);
			}
			else
				return(false);
	}	// end of function check_pattern_kindru


	/*public static boolean check_pattern_eer(byte[] bstr)
		{
			ByteMeth ByteMeth=new ByteMeth();
			int blen = bstr.length;
			int len = eer.length;
			byte ee[]={4},rr[]={25};
			byte end[] = ByteMeth.subArray(bstr,blen-len,blen),end1[]={end[0]},end2[]={end[1]};
			if(ByteMeth.isEqual(end1,ee) || ByteMeth.endsWith(end2,rr))
				return(true);
			else
				return(false);
	}	// end of function check_pattern_eer

	public static boolean check_pattern_yen(byte[] bstr)
	{
		ByteMeth ByteMeth=new ByteMeth();
		int blen = bstr.length;
		int len = yen.length;
		byte ye[]={8},nn[]={31};
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen),end1[]={end[0]},end2[]={end[1]};
		if(ByteMeth.isEqual(end1,ye) || ByteMeth.endsWith(end2,nn))
			return(true);
		else
			return(false);
	}	// end of function check_pattern_yen*/

	public static boolean check_pattern_aal_aan_aar_yen_om_eer(byte[] bstr)
	{
		ByteMeth ByteMeth=new ByteMeth();
		int blen = bstr.length;
		int len = aal.length;
		if(blen < len)
				return false;
		byte a[]={1},aa[]={2},ll[]={29},A[]={7},O[]={11},mm[]={23},rr[]={25},E[]={4},ll1[]={26},nn1[]={19},rr1[]={30},nn[]={31};
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen),end1[]={end[0]},end2[]={end[1]};

		if(ByteMeth.isEqual(end1,aa)||(ByteMeth.endsWith(end1,a)&&(ByteMeth.endsWith(bstr,nn1)||ByteMeth.endsWith(bstr,ll1)||ByteMeth.endsWith(bstr,ll))))  // checking all,aan,aar
		{
			if(ByteMeth.endsWith(bstr,ll1)||ByteMeth.endsWith(bstr,ll))
			{
				get_sugg(bstr,aal);
				set_sugg(bstr,aan);
				set_sugg(bstr,aar);
				set_sugg(bstr,yen);
				set_sugg(bstr,om);
				set_sugg(bstr,eer);
				return(true);
			}
			else if(ByteMeth.endsWith(bstr,nn1))
			{
				System.out.println("-------------yen");
				get_sugg(bstr,aan);
				set_sugg(bstr,yen);
				set_sugg(bstr,aal);
				set_sugg(bstr,aar);
				set_sugg(bstr,eer);
				set_sugg(bstr,om);
				return(true);
			}
			else if(ByteMeth.endsWith(bstr,rr1))
			{
				get_sugg(bstr,aar);
				set_sugg(bstr,aal);
				set_sugg(bstr,aar);
				set_sugg(bstr,yen);
				set_sugg(bstr,eer);
				set_sugg(bstr,om);
				return(true);
			}
			else
			{
				get_sugg(bstr,aan);
				set_sugg(bstr,aal);
				set_sugg(bstr,aar);
				set_sugg(bstr,eer);
				set_sugg(bstr,yen);
				set_sugg(bstr,om);
				return(true);
			}

		}
		else if(ByteMeth.endsWith(bstr,nn))  // checking aan,yen
		{
			if(ByteMeth.isEqual(end1,A))
			{
				get_sugg(bstr,yen);
				set_sugg(bstr,aan);

			}
			else
			{
				get_sugg(bstr,aan);
				set_sugg(bstr,yen);
			}
			set_sugg(bstr,aal);
			set_sugg(bstr,aar);
			set_sugg(bstr,eer);
			set_sugg(bstr,om);
			return(true);
		}							// checking om
		else if(ByteMeth.isEqual(end1,O)||ByteMeth.endsWith(bstr,mm))
		{
			get_sugg(bstr,om);
			set_sugg(bstr,aan);
			set_sugg(bstr,yen);
			set_sugg(bstr,aal);
			set_sugg(bstr,aar);
			set_sugg(bstr,eer);
			return(true);
		}							// checking eer
		else if(ByteMeth.isEqual(end1,E)||ByteMeth.endsWith(bstr,rr))
		{
			get_sugg(bstr,eer);
			set_sugg(bstr,aar);
			set_sugg(bstr,aal);
			set_sugg(bstr,aan);
			set_sugg(bstr,yen);
			set_sugg(bstr,om);
			return(true);
		}
		else
			return(false);
	}	// end of function aal_aan_aar_yen_om_eer


	public static boolean check_pattern_athu(byte[] bstr)
	{
		ByteMeth ByteMeth=new ByteMeth();
		int blen = bstr.length;
		int len = athu.length;
		if(blen < len)
			return false;
		byte ath[]={1,20},thu[]={20,5};
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen),end23[]={end[1],end[2]},end12[]={end[0],end[1]};
		if(ByteMeth.isEqual(end12,ath) || ByteMeth.endsWith(end23,thu))
			return(true);
		else
			return(false);
	}	// end of function check_pattern_athu

	public static boolean check_pattern_ana(byte[] bstr)
	{
		ByteMeth ByteMeth=new ByteMeth();
		int blen = bstr.length;
		int len = ana.length;
		if(blen < len)
			return false;
		byte ath[]={1,20},na[]={31,1},an[]={1,31},a[]={1};
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen),end23[]={end[1],end[2]},end12[]={end[0],end[1]},end1[]={end[0]};
		if(ByteMeth.isEqual(end12,an)||ByteMeth.endsWith(end23,na)||ByteMeth.endsWith(end1,a))
			return(true);
		else
			return(false);
	}	// end of function check_pattern_ana



	public static boolean check_pattern_eerkal(byte[] bstr)
		{
			System.out.println("str in chk_pat_er_ar :" + tabconvert2.revert(bstr));
			ByteMeth ByteMeth=new ByteMeth();
			int blen = bstr.length;
			int len = 5;
			if(blen < len)
				return false;
			byte kk[]={14} ;
			byte end[] = ByteMeth.subArray(bstr,blen-len,blen),end2[]={end[2]};
			//System.out.println("end in check_pattern_erkal_aarkal :" + tabconvert2.revert(end));
			byte end12[] = {end[0],end[1]};byte end345[] = {end[2],end[3],end[4]};byte end234[] = {end[1],end[2],end[3]};
			if(ByteMeth.isEqual(end12,eer)||ByteMeth.isEqual(end345,kal) || ByteMeth.isEqual(end234,rka))
				return(true);
			else
				return(false);
	} // end of function check_pattern_eerkal

	public static boolean check_pattern_aarkal(byte[] bstr)
	{
		ByteMeth ByteMeth=new ByteMeth();
		int blen = bstr.length;
		int len = aarkal.length;
		if(blen < len)
			return false;
		byte kk[]={14};
		byte end[] = ByteMeth.subArray(bstr,blen-len,blen),end2[]={end[2]};
		byte end12[] = {end[0],end[1]};byte end345[] = {end[2],end[3],end[4]};byte end234[] = {end[1],end[2],end[3]};
		if(/*ByteMeth.isEqual(end2,kk) || */ByteMeth.isEqual(end12,aar) || ByteMeth.isEqual(end345,kal) || ByteMeth.isEqual(end234,rka))
			return(true);
		else
			return(false);
	} // end of function check_pattern_aarkal


	public static void set_sugg(byte[] bstr,byte[] marker)
	{
		System.out.println("str in set_sugg :" + tabconvert2.revert(bstr));
		ByteMeth ByteMeth=new ByteMeth();
		int len = marker.length,blen = bstr.length;
		byte rem[] = ByteMeth.subArray(bstr,0,blen-len);
		System.out.println("rem :" + tabconvert2.revert(rem));
		String sugg= tabconvert2.revert(ByteMeth.addArray(rem,marker));
		jc.addItem(sugg);
		HSugg.model.addElement(sugg);
		verb.tf1.addItem(sugg);
	} // end of function set_sugg


	public static void get_sugg(byte[] bstr,byte[] marker)
		{
			System.out.println("str in set_sugg :" + tabconvert2.revert(bstr));
			ByteMeth ByteMeth=new ByteMeth();
			int len = marker.length,blen = bstr.length;
			byte rem[] = ByteMeth.subArray(bstr,0,blen-len);
			String str= tabconvert2.revert(ByteMeth.addArray(rem,marker));
			jc.addItem(str);
			HSugg.model.addElement(str);
			verb.tf1.addItem(str);

		} // end of function get_sugg





	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		String str1,result;

		if(str.equals("Check"))
		   {
		   		str1=((String)text1.getSelectedItem()).trim();
				//jc.removeAllItems();
				//System.out.println("str in action_performed :" + str1);
			    jc.removeAllItems();
				jc.addItem("suggestions");
				result=spellcheck(str1);

				String teststr = (String)jc.getItemAt(2);
				text2.setText(teststr);
				if(result.equals("stack_empty"))
					{
						System.out.println("error");
						//text2.setText(result);
					}
				else if(result.equals(""))
					{
				      //text2.setText("");
					}
				else
					{
						//text2.setText(result);
						//System.out.println(result);
					}
		   }
		else if(str.equals("Close"))
		   {        this.dispose();
					main = new SChecker();
				    main.show();
		   }

	}	// end of function actionPerformed

	public static void main(String args[])
		{
			Spchkverb sp = new Spchkverb();

		}
}



