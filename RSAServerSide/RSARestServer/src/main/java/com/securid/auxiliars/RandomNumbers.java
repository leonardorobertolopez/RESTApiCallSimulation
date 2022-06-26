package com.securid.auxiliars;

import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import java.awt.Font;
import java.lang.StringBuffer;

public class RandomNumbers {

	
	public static String random() {
	// Los caracteres de interés en un array de char.
	char [] chars = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

	// Longitud del array de char.
	int charsLength = chars.length;

	// Instanciamos la clase Random
	Random random = new Random();

	// Un StringBuffer para componer la cadena aleatoria de forma eficiente
	StringBuffer buffer = new StringBuffer();
//	StringBuffer buffer = new StringBuffer();

	// Bucle para elegir una cadena de 10 caracteres al azar
	for (int i=0;i<10;i++){

	   // Añadimos al buffer un caracter al azar del array
	   buffer.append(chars[random.nextInt(charsLength)]);
	}

	// Y solo nos queda hacer algo con la cadena
	return buffer.toString();
	}
	
	public static int box(String step) {
		//to show on the top of other windows.
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);    
		
		String longString=step + "\n\n\n" + "'Yes' to proceed, 'No' to Cancel.";
		JTextArea textArea = new JTextArea(longString);
        textArea.setColumns(25);
        textArea.setRows(5);
        textArea.setLineWrap( true );
        textArea.setBackground(null);
        textArea.setFont(null);
        textArea.setWrapStyleWord( true );
      
        textArea.setFont(new Font("Arial", 0, 30));
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,35))); 
 
        int l_iResult = JOptionPane.showConfirmDialog( dialog, textArea , "DDBB",JOptionPane.YES_NO_OPTION );                                              
	    return l_iResult;
		
	}
}
