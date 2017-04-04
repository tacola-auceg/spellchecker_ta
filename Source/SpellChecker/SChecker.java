package SpellChecker;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SChecker extends JFrame implements ActionListener{

  JLabel label =  new JLabel("Spell Checker");

  JFrame verbobj;
  JFrame nounobj;
  JButton ok,cancel,exit;

  JPanel p1 = new JPanel();
  JPanel p2 = new JPanel();
  JPanel p3 = new JPanel();
  JPanel p4 = new JPanel();
  boolean selected=true;
  JRadioButton verb = new JRadioButton("Verb");
  JRadioButton noun = new JRadioButton("Noun");
  ButtonGroup bg = new ButtonGroup();


  Toolkit tk = Toolkit.getDefaultToolkit();
  String nstrin[]={"","ñóñ¢","î£÷¢","Ì","¹î¢îèñ¢","Ý»îñ¢","ß"};
  Image img = tk.getImage(".//GIF.GIF");
  Dimension dim = tk.getScreenSize();
  double d1 = dim.getHeight();
  double d2 = dim.getWidth();
  Font f;

  public SChecker()
   {
     f = label.getFont();
     Font f1 = new Font(f.getName(),f.getStyle(),f.getSize()+10);
     label.setFont(f1);
     setTitle("Spell Checker");
     setIconImage(img);

     bg.add(verb);
     bg.add(noun);
     p4.setLayout(new BorderLayout());
     p4.add(verb,"North");
     p4.add(noun,"South");
     verb.addActionListener(this);
     noun.addActionListener(this);
     p1.add(label);
     p2.add(p4);

     ok=addButton(p3,"Ok");
     cancel=addButton(p3,"Cancel");
     exit=addButton(p3,"Exit");
     getContentPane().add(p1,"North");
     getContentPane().add(p2,"Center");
     getContentPane().add(p3,"South");
     setLocation((int)(d1-250)/2,(int)(d2-400)/2);
     setSize(400,210);

	 addWindowListener(new WindowAdapter()
     {
             	public void windowClosing(WindowEvent e)
   	      	    {
            	  System.exit(1);
                }
             });
     show();
}

public JButton addButton(JPanel pa,String name)
  {
    JButton but = new JButton(name);
    but.addActionListener(this);
    pa.add(but);
    return but;
  }
public void actionPerformed(ActionEvent ae)
 {
   if(ae.getSource()==ok)
   {

   	if(verb.isSelected())
   		{
		 verbobj = new Spchkverb();
   		 this.dispose();
   		 verbobj.show();
	    }
	else if(noun.isSelected())
   		{
   		 nounobj = new SpchkNoun();
   		 this.dispose();
   		 nounobj.show();
	    }
	}
   if(ae.getSource()==cancel)
     {
		 verb.setSelected(false);
		 noun.setSelected(false);
	 }

   if(ae.getSource()==exit) {System.exit(0);}
   }
public static void main(String a[]){
  new SChecker();
}
}


