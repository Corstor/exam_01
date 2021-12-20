package ex2016.a01.t2.e2;

import java.util.Random;

import javax.swing.*;

public class GUI {
	
	private final static int MAX_RANGE = 100;
	private final static int MIN_RANGE = 1;
	
	private int number = 0;
	String sequence = "";
	Random randomIntegers = new Random();
    
    public GUI(String fileName){
        JFrame jf = new JFrame();
        JButton jbInc = new JButton("INCINC");
        JButton jbRand = new JButton("RAND");
        JButton jbUno = new JButton("UNO");
        JButton jbOK = new JButton("OK");
        JPanel jp = new JPanel();
        jp.add(jbInc);
        jp.add(jbRand);
        jp.add(jbUno);
        jp.add(jbOK);
        jf.getContentPane().add(jp);
        jf.pack();
        jf.setVisible(true);
        
        jbInc.addActionListener(e -> {
        	this.number += 2;
        	this.sequence += this.number + "\n";
        });
        
        jbRand.addActionListener(e -> this.sequence += "-" + (randomIntegers.nextInt(MAX_RANGE) + MIN_RANGE) + "\n");
        
        jbUno.addActionListener(e -> this.sequence += "1\n");
        
        jbOK.addActionListener(e -> {
        	System.out.println(this.sequence);
        	this.sequence = "";
        	this.number = 0;
        });
    }

}
