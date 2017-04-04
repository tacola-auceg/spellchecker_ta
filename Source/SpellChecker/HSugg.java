package SpellChecker;

/************************************************************************

                 User interface for Suggestions

*************************************************************************/

//   RCILTS - Tamil,
//   Anna University,
//   Chennai.


import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.lang.*;
import java.sql.*;

//modified by anu on 27/12/02 while integrating
import javax.swing.text.JTextComponent;

public class HSugg extends JFrame implements ActionListener
{

		Font f=new Font("TAB-Anna",4,14);

		static DefaultListModel model = new DefaultListModel();
		static JList suggest = new JList(model);
		JLabel changeto = new JLabel("ñ£ø¢Á");
		JLabel suggestion = new JLabel("Ý«ô£ê¬ù   ");
		static JTextField text2 = new JTextField(15);
		JButton change,ignore,close,addword;
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();

		JTextComponent textComponent;
		String missSpeltWord = "";

		//modified by anu on 30/12/02 while integrating
		public HSugg(JTextComponent textComponent, String missSpeltWord)
		{
			//anu
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		    setTitle("Spell Check Option");
		    setSize(450,300);
		    this.textComponent = textComponent;
		    this. missSpeltWord = missSpeltWord;

		    change = addButton(p2,"ñ£ø¢Á");
		    ignore = addButton(p2,"õ¤ì¢´õ¤´");
			close = addButton(p2,"Í´");
			addword = addButton(p2,"«êó¢");

			p4.add(changeto);
			p4.add(text2);

			p5.add(suggestion);


			 //modify this to ListSelectionListener - anu

			 MouseListener ml_listener = new MouseListener()
			     {
					  public void mouseClicked(MouseEvent Mevent)
					  {
						  if(Mevent.getClickCount()==1)
						    {
								text2.setText( suggest.getSelectedValue().toString());
							}

					  }
					  public void mouseEntered(MouseEvent Mevent)
					  { }
					  public void mouseExited(MouseEvent m)
					  { }
					  public void mousePressed(MouseEvent m)
					  { }
					  public void mouseReleased(MouseEvent m)
					  { }
				  };


			suggest.addMouseListener(ml_listener);

            //suggest.addMouseListener(this);
 			p5.add(suggest);
			suggest.setFont(f);
			changeto.setFont(f);
			suggestion.setFont(f);
			suggest.setVisibleRowCount(6);
			suggest.setFixedCellWidth(150);
			suggest.setFixedCellHeight(20);

			/*model.addElement("");
			model.addElement("");
			model.addElement("");
			model.addElement("");
			model.addElement("");
			model.addElement("");*/

			p1.add(change);
			p1.add(ignore);
			p1.add(addword);
			p1.add(close);
			p2.setLayout(new BorderLayout());
  			p2.add(p5,"North");
			p2.add(p1,"South");

            text2.setFont(f);
		    getContentPane().add(p3,"North");
			getContentPane().add(p4,"Center");
            getContentPane().add(p2,"South");

		    show();
		}

	public JButton addButton(JPanel pa,String name)
		{
		    JButton but = new JButton(name);

	    	//modified by anu on 31/12/02 while integrating
	    	but.addActionListener(this);

		   	but.setFont(f);
		    pa.add(but);
		    return but;
  		}

	//modified by anu on 31/12/02 while integrating
	public void actionPerformed(ActionEvent ae)
	{
		model.removeAllElements();
		if(ae.getSource()==close)
		{
			text2.setText("");
			setVisible(false);
			dispose();
		}

		else if(ae.getSource()==addword)
		{
			//implement this - anu
			setVisible(false);
			dispose();
		}

		else if(ae.getSource()==ignore)
		{
			//do nothing
			setVisible(false);
			dispose();
		}

		//enable this only if there is some text in text2 - anu
		else if(ae.getSource()==change)
		{
			String correctedWord = text2.getText().trim();

			String text = "";
			try
			{
				Document doc = textComponent.getDocument();
				text = doc.getText(0,doc.getLength());
			}catch(BadLocationException ble)
			{
				ble.printStackTrace();
			}

			//don't use this. - anu
			//first occurance will be changed in case of 2/more
			int position = text.indexOf(missSpeltWord);

			if(position == -1)
			{
				//change this to : alert as a message
				System.out.println("string not found!");
			}
			else
			{
				if(position >= 0 && correctedWord.length() > 0)
				{
					//modified by anu on 27/12/02 while integrating

					textComponent.setSelectionStart(position);
					textComponent.setSelectionEnd(position+missSpeltWord.length());
					textComponent.replaceSelection(correctedWord);
				}
			}

			setVisible(false);
			dispose();
		}
		text2.setText("");

	}	// end of function actionPerformed

}
