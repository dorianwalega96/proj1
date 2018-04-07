package lab5app;

import java.awt.Color;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import lab5lib.Decorator;

public class GUI extends JFrame{
	
	JEditorPane panel;
	HTMLEditorKit html;
	
	public GUI(){
		super("SUPERHTML");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 320);
		setVisible(true);
		setLayout(null);
		
		panel = new JEditorPane();
		panel.setEditable(false);
		
		html = new HTMLEditorKit();
		panel.setEditorKit(html);
		
		StyleSheet styleSheet = html.getStyleSheet();
		styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
		styleSheet.addRule("h1 {color: blue;}");
		styleSheet.addRule("h2 {color: #ff0000;}");
		styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");
		
		StyledDocument doc = (StyledDocument) html.createDefaultDocument();
		panel.setDocument(doc);
		panel.setText("<html><body><h1>hello world</h1><h2> czesc swiecie </h2></body></html>");
		
		Decorator dec = new Decorator(styleSheet, this, doc);
		dec.setLocation(310, 5);
		dec.setSize(125, 100);
		getContentPane().add(dec);
		
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setSize(300, 200);
		scroll.setBounds(5, 5, 300, 200);
		scroll.setVisible(true);
		
		getContentPane().add(scroll);
		
		repaint();
		validate();
	}
	
}
