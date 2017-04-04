package analyser;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.*;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.*;

public class AnalyserDemo extends JPanel implements ActionListener
{
	public JTextField inputTextField = new JTextField(20);
	JTextArea outputTextArea = new JTextArea(15,12);

	JButton analyse = new JButton("Analyse");

	JButton exit=new JButton("Exit");
	JButton clear =new JButton("Clear");
	JScrollPane outputScrollpane=new JScrollPane(outputTextArea);

	JMenu menu;
	JMenuItem menuItem;
	JMenuBar menuBar;
	ButtonGroup group = new ButtonGroup();
	JRadioButtonMenuItem radioMenu;

	JPopupMenu popup;
	JMenuItem cut,copy,paste,delete;
	JFrame frame;

	final int KEYBOARD_TamilNet_99 = 1;
	final int KEYBOARD_SYSTEM = 2;
	int currnetKeyboard = 2;


	public AnalyserDemo(JFrame frame,String input)
	{
		this.frame = frame;
		setLayout(new BorderLayout());

		JPanel buttonPane = new JPanel();

		buttonPane.add(new JLabel("Input Word: "));
		buttonPane.add(inputTextField);
		//Utils.addUndoRedo(inputTextField);

		analyse.setToolTipText("Analyse the given word");
		clear.setToolTipText("Clear everything");
		exit.setToolTipText("Exit Application");

		analyse.setMnemonic(java.awt.event.KeyEvent.VK_A);
		clear.setMnemonic(java.awt.event.KeyEvent.VK_C);
		exit.setMnemonic(java.awt.event.KeyEvent.VK_X);

		buttonPane.add(analyse);
		buttonPane.add(clear);
		buttonPane.add(exit);

		//keyboard
		menuBar = new JMenuBar();

		menu = new JMenu("KeyBoard");

		//only java keyboard
		//menuBar.add(menu);

		//init
		inputTextField.setText(input);

		radioMenu = new JRadioButtonMenuItem("TamilNet 99");
		menu.add(radioMenu);
		group.add(radioMenu);
		radioMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				currnetKeyboard = KEYBOARD_TamilNet_99;
			}
		});

		radioMenu = new JRadioButtonMenuItem("System");
		radioMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				currnetKeyboard = KEYBOARD_SYSTEM;
			}
		});
		radioMenu.setSelected(true);
		menu.add(radioMenu);
		group.add(radioMenu);

		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(menuBar,BorderLayout.NORTH);
		topPanel.add(buttonPane,BorderLayout.CENTER);

		add(topPanel,BorderLayout.NORTH);
		add(outputScrollpane,BorderLayout.CENTER);

		Font f = new Font("TAB-Anna",0,14);

		inputTextField.setFont(f);
		outputTextArea.setFont(f);

		outputTextArea.setEditable(false);

		outputTextArea.setBorder(new TitledBorder(
				new EtchedBorder(),"Output"));

		popup = new JPopupMenu();

		cut = new JMenuItem("Cut");
		cut.addActionListener(this);
		cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke
			(java.awt.event.KeyEvent.VK_X, java.awt.Event.CTRL_MASK));
		popup.add(cut);

		copy = new JMenuItem("Copy");
		copy.addActionListener(this);
		copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke
			(java.awt.event.KeyEvent.VK_Y, java.awt.Event.CTRL_MASK));
		popup.add(copy);

		paste = new JMenuItem("Paste");
		paste.addActionListener(this);
		paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke
			(java.awt.event.KeyEvent.VK_V, java.awt.Event.CTRL_MASK));
		popup.add(paste);

		popup.addSeparator();

		delete = new JMenuItem("Delete");
		delete.addActionListener(this);
		popup.add(delete);

		MouseListener popupListener = new PopupListener();
		inputTextField.addMouseListener(popupListener);

		analyse.addActionListener(this);
		exit.addActionListener(this);
		clear.addActionListener(this);
		inputTextField.requestFocus();

		addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent fe)
			{
				super.focusGained(fe);
				inputTextField.requestFocus();
			}
		});
	}

	public void actionPerformed(ActionEvent ae)
	{
		Object obj = ae.getSource();
		if(obj == exit)
			frame.dispose();

		else if(obj == clear)
		{
			inputTextField.setText("");
			outputTextArea.setText("");
		}

		else if(obj == analyse)
		{
			try
			{
					outputTextArea.setText(Analyser.analyseF(inputTextField.getText().trim()));
				if(frame != null)
				{
					frame.toFront();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return;
			}
		}

		else if(obj == cut)
			inputTextField.cut();
		if(obj == copy)
			inputTextField.copy();
		if(obj == paste)
			inputTextField.paste();
		if(obj == delete)
			inputTextField.replaceSelection("");

		if(frame != null)
		{
			frame.toFront();
		}
	}

	public static void main(String args[])
	{
		JFrame f = new JFrame();
		JPanel p = new AnalyserDemo(f,"");

		f.setTitle("Atcharam(Tamil Morphological Analyser) 1.0 - Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.getContentPane().add(p);
		f.pack();

		f.setLocation(Utils.getMiddle(f.getSize()));
		f.setVisible(true);
	}

	class PopupListener extends MouseAdapter
	{
		public void mouseReleased(MouseEvent e)
		{
			showPopup(e);
		}

		private void showPopup(MouseEvent e)
		{
			if (e.isPopupTrigger())
			{
				popup.show(e.getComponent(),
				e.getX(), e.getY());
			}
		}
	}

}
