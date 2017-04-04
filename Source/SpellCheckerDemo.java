import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.sql.*;

import SpellChecker.*;
//Analyser
import analyser.*;

public class SpellCheckerDemo extends JFrame implements ActionListener
{
	Font f=new Font("TAB-Anna",4,14);
	JTextPane textPane = new JTextPane();
	JScrollPane scrollPane = new JScrollPane(textPane);

	JButton browse,spellCheck,analyse,clear,exit;

	FileInputStream fileinputstream;
	JFileChooser jfc_filename = new JFileChooser(".");

	DefaultHighlighter.DefaultHighlightPainter dhp = new
		DefaultHighlighter.DefaultHighlightPainter(Color.lightGray);


	public SpellCheckerDemo()
	{
		setTitle("Annam (Tamil Spell Checker) - RCILTS-Tamil");
		textPane.setFont(f);

		//setSize(700,400);
		Utils.sizeScreen(this);

		JPanel buttonPane = new JPanel();
		browse = addButton(buttonPane,"«è£ð¢¹");
		spellCheck = addButton(buttonPane,"êó¤ð£ó¢");
		analyse = addButton(buttonPane,"ð¤ó¤");
		clear = addButton(buttonPane,"ï¦è¢°");
		exit = addButton(buttonPane,"Í´");

		//init
		/*textPane.setText("Üõù¤ì£ñ¢ å¼ «ðù£ ñì¢´«ñ à÷¢÷¶. " + "\n" +
			"ÜõÛ¬ìò «ðù£õô¢ â¿î º®òõ¤ô¢¬ô. " + "\n" +
			"ÜõÂè¢è£è ï£ù¢ åù¢Á îï¢«îù¢.");
			*/

		getContentPane().add(scrollPane,BorderLayout.CENTER);
		getContentPane().add(buttonPane,BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setVisible(true);

	}

	public JButton addButton(JPanel panel,String name)
	{
		JButton button = new JButton(name);
		button.addActionListener(this);
		button.setFont(f);
		panel.add(button);
		return button;
	}

	public void actionPerformed(ActionEvent ae)
	{
		Object eventObject = ae.getSource();
		if(eventObject==browse)
		{
			textPane.setText("");
			int option = jfc_filename.showOpenDialog(this);
			if(option == JFileChooser.APPROVE_OPTION)
			{
				try
				{
					String string = "";
					fileinputstream=new FileInputStream(jfc_filename.getSelectedFile());
					try
					{
						while(fileinputstream.available()!=0)
						{
							int finputstream=fileinputstream.read();
							string=string+(char)finputstream;
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					textPane.setText(string);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		else if(eventObject==spellCheck)
		{
			new SpellChecker(textPane,dhp);
		}

		//Analyser
		else if(eventObject==analyse)
		{
			JFrame f = new JFrame("Atcharam (Tamil Morphological Analyser) - RCILTS-Tamil");
			JPanel p = new analyser.AnalyserDemo(f,textPane.getSelectedText().trim());

			f.setTitle("Atcharam(Tamil Morphological Analyser) 1.0 - Demo");
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			f.getContentPane().add(p);
			f.pack();

			f.setLocation(Utils.getMiddle(f.getSize()));
			f.setVisible(true);
		}

		else if(eventObject==clear)
		{
			textPane.setText("");
		}

		else if(eventObject==exit)
			System.exit(0);

	}

	public static void main(String args[])
	{
		new SpellCheckerDemo();
	}

}
