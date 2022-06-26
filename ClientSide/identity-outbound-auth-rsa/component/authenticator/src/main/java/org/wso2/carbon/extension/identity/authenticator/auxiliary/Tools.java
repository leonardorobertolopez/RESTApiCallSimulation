package org.wso2.carbon.extension.identity.authenticator.auxiliary;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class Tools {

	
	
	public static int box(String step) {
		// to show on the top of other windows.
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);

		String longString = step + "\n\n\n" + "'Yes' to proceed, 'No' to Cancel.";
		JTextArea textArea = new JTextArea(longString);
		textArea.setColumns(25);
		textArea.setRows(5);
		textArea.setLineWrap(true);
		textArea.setBackground(null);
		textArea.setFont(null);
		textArea.setWrapStyleWord(true);
       
		textArea.setFont(new Font("Arial", 0, 30));

		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 35)));

		int l_iResult = JOptionPane.showConfirmDialog(dialog, textArea, step, JOptionPane.YES_NO_OPTION);
			
		return l_iResult;
       
	}
	
	public static String boxInput(String message) {

		// to show on the top of other windows.
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
        dialog.setResizable(true);
		
		String longString = message + "\n\n\n" + "'Yes' to proceed, 'No' to Cancel.";
		JTextArea textArea = new JTextArea(longString);
		textArea.setColumns(15);
		textArea.setRows(5);
		textArea.setLineWrap(false);
		textArea.setBackground(null);
		textArea.setFont(new Font("Arial", 0, 130));
		textArea.setWrapStyleWord(false);
      
		textArea.setFont(new Font("Arial", 0, 30));
	
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 35)));
		
		String l_iResult = JOptionPane.showInputDialog(dialog, textArea, "STATUS", JOptionPane.OK_CANCEL_OPTION);
        return l_iResult;
		


			
	}
	
	
}
