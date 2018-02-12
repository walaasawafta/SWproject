

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class calculator extends JFrame {

private double tempNumbers1 = 0;
private double tempNumbers2 = 0;

private byte function = -1;


private JTextField resultJText;

public  calculator (){
           super("Calculator");
           JButton[] numberButtons = new JButton[10];

    for ( int i = 9; i >= 0; i--) {
        numberButtons[i] = new JButton(Integer.toString(i));
    }

    JButton enterButton     = new JButton("Enter");
    JButton cButton         = new JButton("C");
    JButton multiplyButton  = new JButton("*");
    JButton divideButton    = new JButton("/");
    JButton addButton       = new JButton("+");
    JButton substractButton = new JButton("-");
    JButton sqrButton = new JButton("sqr");
    JButton modButton = new JButton("%");
    resultJText = new JTextField();
        resultJText.setPreferredSize(new Dimension(160, 20));
        resultJText.setBackground(Color.WHITE);
        resultJText.setEnabled(false);
        resultJText.setHorizontalAlignment(4);
        resultJText.setDisabledTextColor(Color.BLACK);


    JPanel motherPanel = new JPanel();
        motherPanel.setLayout(new BoxLayout(motherPanel, BoxLayout.Y_AXIS));

    JPanel textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(160, 20));
        textPanel.add(resultJText);

    JPanel numberButtonsPanel = new JPanel();
        numberButtonsPanel.setPreferredSize(new Dimension(160, 100));

        for(int i = 9; i>=0; i--) {
            numberButtonsPanel.add(numberButtons[i]);
        }

    JPanel functionButtonPanel = new JPanel();
        functionButtonPanel.setPreferredSize(new Dimension(160, 35));
        functionButtonPanel.add(enterButton);
        functionButtonPanel.add(cButton);
        functionButtonPanel.add(multiplyButton);
        functionButtonPanel.add(divideButton);
        functionButtonPanel.add(addButton);
        functionButtonPanel.add(substractButton);
        functionButtonPanel.add(sqrButton);
        functionButtonPanel.add(modButton);

    numberButtonsAction[] numberButtonActions = new numberButtonsAction[10];
    for ( int i = 0; i < 10; i++ ) {
        numberButtonActions[i] = new numberButtonsAction(numberButtons[i]);
        numberButtons[i].addActionListener(numberButtonActions[i]);
    }

    EnterButton enter = new EnterButton();
        enterButton.addActionListener(enter);

    CButton c = new CButton();
        cButton.addActionListener(c);

    MultiplyButton multiply = new MultiplyButton();
        multiplyButton.addActionListener(multiply);

    DivideButton divide = new DivideButton();
        divideButton.addActionListener(divide);

    AddButton add = new AddButton();
        addButton.addActionListener(add);

    SubtractButton subtract = new SubtractButton();
        substractButton.addActionListener(subtract);
        
        sqrButton sqr = new sqrButton();
        sqrButton.addActionListener(sqr);
        
        modButton mod = new modButton();
        modButton.addActionListener(mod);

    motherPanel.add(textPanel);
    motherPanel.add(numberButtonsPanel);
    motherPanel.add(functionButtonPanel);
    add(motherPanel);

    
    setSize(180, 290);
    setLocationByPlatform(true);
    setSize(500,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

}

private class numberButtonsAction implements ActionListener {

    private String c;

    public numberButtonsAction(JButton a) {
        this.c = a.getText();
    }

    public void actionPerformed(ActionEvent e) {
        if (!resultJText.getText().equals("0.0")) {
            resultJText.setText(resultJText.getText() + c);
        } else {
            resultJText.setText("");
            actionPerformed(e);
        }
    }
}

private class EnterButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        tempNumbers2 = Double.parseDouble(resultJText.getText());

        if (function == 0) {
            div(tempNumbers1,tempNumbers2);
        } else if (function == 1) {
            mul(tempNumbers1,tempNumbers2);
        } else if (function == 2) {
            add(tempNumbers1,tempNumbers2);
        } else if (function == 3) {
            sub(tempNumbers1,tempNumbers2);
        }
          else if (function == 4) {
        	   tempNumbers1=1;
             sqr(tempNumbers2);
        }  
           else if (function == 5) {
           mod(tempNumbers1,tempNumbers2);
                    
        } else {
            resultJText.setText(String.valueOf(tempNumbers1));
        }
            tempNumbers1 = Double.parseDouble(resultJText.getText());
    }


}
void mul(double tempNumbers1, double tempNumbers2){
	 resultJText.setText(Double.toString(tempNumbers1 * tempNumbers2)) ;
	
}
double mul1(double tempNumbers1, double tempNumbers2){
return Double.parseDouble(resultJText.getText());
}
void div(double tempNumbers1, double tempNumbers2){
	 resultJText.setText(Double.toString((Math.round((tempNumbers1 / tempNumbers2) * 100)) / 100));
}
double div1(double tempNumbers1, double tempNumbers2){
	return Double.parseDouble(resultJText.getText());
}
void add(double tempNumbers1, double tempNumbers2){
	 resultJText.setText(Double.toString(tempNumbers1 + tempNumbers2)) ;

}
double add1(double tempNumbers1, double tempNumbers2){
		 return Double.parseDouble(resultJText.getText());
		 }
void sub(double tempNumbers1, double tempNumbers2){
	 resultJText.setText(Double.toString(tempNumbers1 - tempNumbers2)) ;

}
double sub1(double tempNumbers1, double tempNumbers2){
return Double.parseDouble(resultJText.getText());
}
void mod(double tempNumbers1, double tempNumbers2){
	 resultJText.setText(Double.toString(tempNumbers1 % tempNumbers2)) ;
}
double mod1(double tempNumbers1, double tempNumbers2){
return Double.parseDouble(resultJText.getText());
}
void sqr(double tempNumbers2){
	
	resultJText.setText(Double.toString(Math.sqrt(tempNumbers2) ));
}
double sqr1(double tempNumbers2){
return	Double.parseDouble(resultJText.getText());
}
private class CButton implements ActionListener {

    @Override

    public void actionPerformed(ActionEvent e) {
        resultJText.setText("");
        tempNumbers1 = 0;
        tempNumbers2 = 0;

        function = -1;
    }


}

private class DivideButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tempNumbers1 == 0) {
            tempNumbers1 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        } else {
            tempNumbers2 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        }
        function = 0;
    }

}

private class MultiplyButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tempNumbers1 == 0) {
            tempNumbers1 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        } else {
            tempNumbers2 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        }
        function = 1;
    }


}


private class AddButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tempNumbers1 == 0) {
            tempNumbers1 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        } else {
            tempNumbers2 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        }
        function = 2;
    }

}

private class SubtractButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tempNumbers1 == 0) {
            tempNumbers1 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        } else {
            tempNumbers2 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        }
        function = 3;
    }

}
private class sqrButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tempNumbers1 == 0) {
            tempNumbers1 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");}
         else {
            tempNumbers2 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        }
        function = 4;
    }

}
private class modButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tempNumbers1 == 0) {
            tempNumbers1 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        } else {
            tempNumbers2 = Double.parseDouble(resultJText.getText());
            resultJText.setText("");
        }
        function = 5;
    }

}
public static void main(String[] args) {
	
	 calculator a =new  calculator();

		
	}

}