package assignment2;

import java.awt.Color;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.swing.JLabel;
import javax.swing.JTextArea;
/*
 * OutputTerminal is where users questions and the bots answers will be displayed
 */

public class OutputTerminal extends JTextArea{
	ChatBot chatbot = new ChatBot();

	public OutputTerminal() {
		setBackground(Color.white);
		setOpaque(false);
		setLineWrap(true);
		setEditable(false);
		setFocusable(false);
		setText("");

	}
	/*
	 * takes in String send it to chat bot then prints both input String and chatBot output in Terminal area
	 */
	public void askQuestion(String s) {
		String translated = "";
		if(s.length() != 0) {
			try {
				translated = TranslateToEnglish.translate(s);
			} catch (IOException | GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (translated.length() > 0) {
				String response = chatbot.getResponse(translated);
				setText(getText() + "\n human: " + s);
				setText(getText() + "\n Bot: " + response + "\n");
				POSTagger.checkUserInput(translated);
			}
			else {
				String response = chatbot.getResponse(s);
				setText(getText() + "\n human: " + s);
				setText(getText() + "\n Bot: " + response + "\n");
				POSTagger.checkUserInput(s);
			}
		}
	}
}
