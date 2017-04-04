package analyser;

import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Stack;

public class Utils
{
	public static String newLineStr = "\n";
	public static String newLineStr_OS = System.getProperty("line.separator");

	/*public static void showErrorDialog(boolean userFriendly,JFrame parent,Throwable e)
	{
		String msg = e.getClass().getName() + newLineStr;
		msg += e.getMessage() + newLineStr;

		if(userFriendly || !System.getProperty("java.version").startsWith("1.4"))
		{
			JOptionPane.showMessageDialog(parent,msg,"Exception",
				JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			StackTraceElement ste[] = e.getStackTrace();
			JDialog errorDialog = new JDialog(parent, "Exception", true);
			JTextArea textArea = new JTextArea();
			textArea.setWrapStyleWord(true);
			textArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(textArea);

			for(int i=0; i < ste.length; i++)
			{
				msg += "@ " + ste[i].toString() + newLineStr;
			}
			textArea.setText(msg);

			Container c = new Container();
			c.setLayout(new BorderLayout());
			c.add(scrollPane);
			errorDialog.setContentPane(c);

			errorDialog.setSize(errorDialog.getPreferredSize());
			if(parent != null)
			{
				errorDialog.setLocation(getMiddle(parent.getSize(),errorDialog.getSize()));
			}
			errorDialog.show();
			errorDialog.dispose();
		}

	}*/

	public static void printStack(Stack s,String title,JTextArea t)
	{
		Stack s1 = (Stack)s.clone();
		String output = newLineStr + title + ":";
		while (!s1.empty())
		{
			Entry entry = (Entry)s1.pop();
			String str = TabConverter.revert(entry.getPart());
			output += (newLineStr + str);
			int tag = entry.getTag();
			if(tag != -1)
				str = " < " + analyser.Analyser.Tags.getString(String.valueOf(tag)) + " > ";
			else str = "";

			output += (str);
		}

		output += newLineStr + "---------------";
		t.append(output);
	}

	public static Point getMiddle(Dimension dimension)
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int)(screenSize.width-dimension.width)/2;
		int y = (int)(screenSize.height-dimension.height)/2;
		return new Point(x,y);
	}

	public static Point getMiddle(Dimension d1,Dimension d2)
	{
		int x = (int)(d1.width-d2.width)/2;
		int y = (int)(d1.height-d2.height)/2;
		return new Point(x,y);
	}

	public static void sizeScreen(JFrame frame)
	{
			sizeScreen_v3(frame);
	}
	public static void sizeScreen_v3(JFrame fInStream)
	{
		Dimension dimScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		fInStream.setSize(dimScreenSize);
		fInStream.setVisible(true);
		java.awt.Rectangle rectVisible = fInStream.getRootPane().getVisibleRect();
		int iWidth = (int)rectVisible.getWidth();
		int iHeight = (int)rectVisible.getHeight();
		int iX = (int)rectVisible.x;
		int iY = (int)rectVisible.y;
		fInStream.setBounds(iX,iY,iWidth,iHeight);
	}

}
