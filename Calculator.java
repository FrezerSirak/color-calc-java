
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame  {
	
	
   static JTextField inputField  = new JTextField () , outputField = new JTextField ();
	
   JButton clearButton,resetButton,divisionButton ,timesButton ,minusButton ,plusButton , equalsButton,pointButton,AnsButton;
   JButton oneButton,twoButton,threeButton,fourButton,fiveButton,sixButton,sevenButton,eightButton,nineButton,zeroButton;
   JButton changeGreen,changeMagenta,changeBlue,changeRed,changeDefault,changeOrange,aboutCalculator;
	
   static String preValue = "";
   static double result = 0;
   
   static boolean pointCheck = true;
   static boolean operatorCheck = true;
   static boolean plusCheck = true;
   static boolean minusCheck = true;
   static boolean keyLock = false; 
    
   
    
    Calculator(String title)
   {
	 super (title);		
	 setDefaultCloseOperation(Calculator.EXIT_ON_CLOSE);
	 setSize(530,300);
	 setLocation(345,90);
	 setLayout(new GridLayout(1,0));  
	
	 inputField.setText("0");
	 inputField.setEditable(false);
	 inputField.setHorizontalAlignment(JTextField.RIGHT);
	 inputField.setFont(inputField.getFont().deriveFont(20.0f));
	 inputField.setBackground(Color.WHITE);
	 
	 outputField.setEditable(false);  
	 outputField.setHorizontalAlignment(JTextField.RIGHT);
	 outputField.setFont(inputField.getFont().deriveFont(20.0f));
	 outputField.setBackground(Color.WHITE);
	 
	 
	 JPanel leftMainPanel = new JPanel ();  
	 leftMainPanel.setLayout(new GridLayout(0,1));
	 
	 //---------------------------------------
	 
	 JPanel leftTopPanel = new JPanel ();                                       //leftTopPanel Declared
	 leftTopPanel.setLayout(new GridLayout(0,1)); 
	 
	
	 
	 leftTopPanel.add(inputField);
     leftTopPanel.add(outputField);	
	 
     leftMainPanel.add(leftTopPanel);                                         //(leftTopPanel) added -> to leftMainPanel
	 
 
	 //---------------------------------------
	
     
	 JPanel leftMiddlePanel = new JPanel ();            
	 leftMiddlePanel.setLayout(new GridLayout(0,3));                         //leftMiddlePanel Declared
	 
	 sevenButton = new JButton ("7");
	 sevenButton.setFont(sevenButton.getFont().deriveFont(22.0f));
	 sevenButton.setActionCommand("seven");
	 sevenButton.addActionListener(new NumberPadListener());
	 leftMiddlePanel.add(sevenButton);
	 
	 eightButton = new JButton ("8");
	 eightButton.setFont(eightButton.getFont().deriveFont(22.0f));
	 eightButton.setActionCommand("eight");
	 eightButton.addActionListener(new NumberPadListener());
	 leftMiddlePanel.add(eightButton);
	 
	 nineButton = new JButton ("9");
	 nineButton.setFont(nineButton.getFont().deriveFont(22.0f));
	 nineButton.setActionCommand("nine");
	 nineButton.addActionListener(new NumberPadListener());
	 leftMiddlePanel.add(nineButton);
	 
	 fourButton = new JButton ("4");
	 fourButton.setFont(fourButton.getFont().deriveFont(22.0f));
	 fourButton.setActionCommand("four");
	 fourButton.addActionListener(new NumberPadListener());
	 leftMiddlePanel.add(fourButton);
   
     fiveButton = new JButton ("5");
     fiveButton.setFont(fiveButton.getFont().deriveFont(22.0f));
     fiveButton.setActionCommand("five");
     fiveButton.addActionListener(new NumberPadListener());
     leftMiddlePanel.add(fiveButton);
   
     sixButton = new JButton ("6");
     sixButton.setFont(sixButton.getFont().deriveFont(22.0f));
     sixButton.setActionCommand("six");
     sixButton.addActionListener(new NumberPadListener());
     leftMiddlePanel.add(sixButton);
   
     threeButton = new JButton ("3");
     threeButton.setActionCommand("three");
     threeButton.setFont(threeButton.getFont().deriveFont(22.0f));
     threeButton.addActionListener(new NumberPadListener());
     leftMiddlePanel.add(threeButton);
   
     twoButton = new JButton ("2");
     twoButton.setActionCommand("two");
     twoButton.setFont(twoButton.getFont().deriveFont(22.0f));
     twoButton.addActionListener(new NumberPadListener());
     leftMiddlePanel.add(twoButton);
   
     oneButton = new JButton ("1");
     oneButton.setFont(oneButton.getFont().deriveFont(22.0f));
     oneButton.setActionCommand("one");
     oneButton.addActionListener(new NumberPadListener());
     leftMiddlePanel.add(oneButton);
   
     leftMainPanel.add(leftMiddlePanel);                                         // (leftMiddlePanel) added -> to leftMainPanel
   
     
     
     //-----------------------------------------
     
     
     JPanel leftBottomPanel = new JPanel ();                                   // leftBottomPanel declared   
     leftBottomPanel.setLayout(new GridLayout(0,1));  
   
     JPanel leftBottomTopPanel = new JPanel();  
     leftBottomTopPanel.setLayout(new GridLayout(1,0) );
     
     JPanel leftBottomBottomPanel = new JPanel ();
     leftBottomBottomPanel.setLayout(new GridLayout(1,0));
     
     pointButton = new JButton (".");
     pointButton.setFont(pointButton.getFont().deriveFont(30.0f));
     pointButton.setActionCommand("point");
     pointButton.addActionListener(new NumberPadListener ());
     leftBottomTopPanel.add(pointButton);
     
     zeroButton = new JButton ("0");
     zeroButton.setFont(zeroButton.getFont().deriveFont(20.0f));
     zeroButton.setActionCommand("zero");
     zeroButton.addActionListener(new NumberPadListener());
     leftBottomTopPanel.add(zeroButton);
     
     equalsButton = new JButton ("=");
     equalsButton.setFont(equalsButton.getFont().deriveFont(30.0f));
     equalsButton.setActionCommand("equals");
     equalsButton.addActionListener(new OperatorListener());
     leftBottomTopPanel.add(equalsButton);
   
     leftBottomPanel.add(leftBottomTopPanel);
     
     aboutCalculator = new JButton("About");
     aboutCalculator.setFont(aboutCalculator.getFont().deriveFont(14.0f));
     aboutCalculator.setActionCommand("About");
     aboutCalculator.addActionListener(new FunctionKeyListener ());
     leftBottomBottomPanel.add(aboutCalculator);
     
     AnsButton = new JButton ("Ans");
     AnsButton.setFont(AnsButton.getFont().deriveFont(20.0f));
     AnsButton.setActionCommand("Ans");
     AnsButton.addActionListener(new FunctionKeyListener ());
     
     leftBottomBottomPanel.add(AnsButton);
     
     leftBottomPanel.add(leftBottomBottomPanel);
     
     leftMainPanel.add(leftBottomPanel);                             //(leftBottomPanel) added -> to leftMainPanel
   
     add(leftMainPanel);                                           //LEFT MAIN PANEL added to Frame
     
     
     //--------------------------------------     
     
     JPanel rightMainPanel = new JPanel ();
     rightMainPanel.setLayout(new GridLayout(1,0));
     
     JPanel rightFirstPanel = new JPanel ();           
     rightFirstPanel.setLayout(new GridLayout(0,1));
   
     clearButton = new JButton ("Clear");
     clearButton.setFont(clearButton.getFont().deriveFont(17.0f));
     clearButton.setActionCommand("Clear");
     clearButton.addActionListener(new FunctionKeyListener ());
     rightFirstPanel.add(clearButton);
     
     resetButton = new JButton ("Reset");
     resetButton.setFont(resetButton.getFont().deriveFont(17.0f));
     resetButton.setActionCommand("Reset");
     resetButton.addActionListener(new FunctionKeyListener ());
     rightFirstPanel.add(resetButton);
   
     divisionButton = new JButton ("/");
     divisionButton.setFont(divisionButton.getFont().deriveFont(25.0f));
     divisionButton.setActionCommand("division");
     divisionButton.addActionListener(new OperatorListener());
     rightFirstPanel.add(divisionButton);
   
     timesButton = new JButton ("*");
     timesButton.setFont(timesButton.getFont().deriveFont(28.0f));
     timesButton.setActionCommand("times");
     timesButton.addActionListener(new OperatorListener ());
     rightFirstPanel.add(timesButton);
   
     minusButton = new JButton ("-");
     minusButton.setFont(minusButton.getFont().deriveFont(28.0f));
     minusButton.setActionCommand("minus");
     minusButton.addActionListener(new OperatorListener());
     rightFirstPanel.add(minusButton);
   
     plusButton = new JButton ("+");
     plusButton.setActionCommand("add");
     plusButton.setFont(plusButton.getFont().deriveFont(25.0f));
     plusButton.addActionListener(new OperatorListener());
     rightFirstPanel.add(plusButton);
   
     rightMainPanel.add(rightFirstPanel);
     
     
     JPanel rightSecondPanel = new JPanel ();
     rightSecondPanel.setLayout(new GridLayout(0,1));
     
     changeGreen = new JButton("Green");
     changeGreen.setFont(changeGreen.getFont().deriveFont(14.0f));
     changeGreen.addActionListener(new ColorKeyListener ());
     rightSecondPanel.add(changeGreen);
     
     changeMagenta = new JButton ("Magenta");
     changeMagenta.setFont(changeMagenta.getFont().deriveFont(14.0f));
     changeMagenta.addActionListener(new ColorKeyListener ());
     rightSecondPanel.add(changeMagenta);
     
     changeBlue = new JButton ("Blue");
     changeBlue.setFont(changeBlue.getFont().deriveFont(14.0f));
     changeBlue.addActionListener(new ColorKeyListener ());
     rightSecondPanel.add(changeBlue);
     
     changeRed = new JButton ("Red");
     changeRed.setFont(changeRed.getFont().deriveFont(14.0f));
     changeRed.addActionListener(new ColorKeyListener ());
     rightSecondPanel.add(changeRed);
     
     changeOrange = new JButton ("Orange");
     changeOrange.setFont(changeOrange.getFont().deriveFont(14.0f));
     changeOrange.addActionListener(new ColorKeyListener ());
     rightSecondPanel.add(changeOrange);
     
     changeDefault = new JButton ("Default");
     changeDefault.setFont(changeDefault.getFont().deriveFont(14.0f));
     changeDefault.addActionListener(new ColorKeyListener ());
     rightSecondPanel.add(changeDefault);
     
         
     rightMainPanel.add(rightSecondPanel);
       
     add(rightMainPanel);                                             //RIGHT MAIN PANEL added to FRAME
 
     colorChanger(Color.BLACK);
 }
 
    
 private class NumberPadListener implements ActionListener  
  {
   public void actionPerformed (ActionEvent e)
   {
       String event = e.getActionCommand();	  
               
    if(keyLock == false)
    {  
        if(event.equals("one"))
         {
          if(inputField.getText().equals("0"))
          {
            preValue = "";
        	inputField.setText(preValue + "1");
            preValue += "1";
            minusCheck = true;
            plusCheck = true;
            operatorCheck = true;
          }
          else
          {
            inputField.setText(inputField.getText() + "1");
            preValue += "1";
            minusCheck = true;
            plusCheck = true;
            operatorCheck = true;
          } 
         }
        
        else if(event.equals("two"))  
         {  
        	if(inputField.getText().equals("0"))
            {
              preValue = "";
        	  inputField.setText(preValue + "2");
              preValue += "2";
              minusCheck = true;
              plusCheck = true;
              operatorCheck = true;
            }
            else
            {
              inputField.setText(inputField.getText() + "2");
              preValue += "2";
              minusCheck = true;
              plusCheck = true;
              operatorCheck = true;
            } 
         }  
       
        else if(event.equals("three"))
         {
    	   if(inputField.getText().equals("0"))
           {
             preValue = "";
    		 inputField.setText(preValue + "3");
             preValue += "3";
             minusCheck = true;
             plusCheck = true;
             operatorCheck = true;
           }
           else
           {
             inputField.setText(inputField.getText() + "3");
             preValue += "3";
             minusCheck = true;
             plusCheck = true;
             operatorCheck = true;
           } 
         }  
       
       else if(event.equals("four"))
        {
    	   if(inputField.getText().equals("0"))
           {
             preValue = "";
    		 inputField.setText(preValue + "4");
             preValue += "4";
             minusCheck = true;
             plusCheck = true;
             operatorCheck = true;
           }
           else
           {
             inputField.setText(inputField.getText() + "4");
             preValue += "4";
             minusCheck = true;
             plusCheck = true;
             operatorCheck = true;
           } 
        }
      
      else if(event.equals("five"))
       {
    	  if(inputField.getText().equals("0"))
          {
            preValue = "";
    		inputField.setText(preValue + "5");
            preValue += "5"; 
            minusCheck = true;
            plusCheck = true;
            operatorCheck = true;
          }
          else
          {
            inputField.setText(inputField.getText() + "5");
            preValue += "5";
            minusCheck = true;
            plusCheck = true;
            operatorCheck = true;
          } 
       }
      
      else if(event.equals("six"))
       {   
    	  if(inputField.getText().equals("0"))
          {
            preValue = "";
    		inputField.setText(preValue + "6");
            preValue += "6";
            minusCheck = true;
            plusCheck = true;
            operatorCheck = true;
          }
          else
          {
            inputField.setText(inputField.getText() + "6");
            preValue += "6";
            minusCheck = true;
            plusCheck = true;
            operatorCheck = true;
          } 
       } 
      
      else if(event.equals("seven"))
       {    
    	  if(inputField.getText().equals("0"))
          {
            preValue = "";
    		inputField.setText(preValue + "7");
            preValue += "7";
            minusCheck = true;
            plusCheck = true;
            operatorCheck = true;
          }
          else
          {
            inputField.setText(inputField.getText() + "7");
            preValue += "7";
            operatorCheck = true;
            minusCheck = true;
            plusCheck = true;
          } 
       }
     
     else if(event.equals("eight"))
       {   
    	  if(inputField.getText().equals("0"))
          {
            preValue = "";
    		inputField.setText(preValue + "8");
            preValue += "8" ;
            minusCheck = true;
            plusCheck = true;
            operatorCheck = true;
          }
          else
          {
            inputField.setText(inputField.getText() + "8");
            preValue += "8";
            minusCheck = true;
            plusCheck = true;
            operatorCheck = true;
          } 
       }
      else if(event.equals("nine"))
       { 
    	  if(inputField.getText().equals("0"))
          {
             preValue = "";
    		 inputField.setText(preValue + "9");
             preValue += "9";
             minusCheck = true;
             plusCheck = true;
             operatorCheck = true;
          }
          else
          {
            inputField.setText(inputField.getText() + "9");
            preValue += "9" ;
            minusCheck = true;
            plusCheck = true;
            operatorCheck = true;
          } 
       }
      else if(event.equals("zero"))
      {
    	  if(inputField.getText().equals("0"))
          {
             inputField.setText(inputField.getText());
             minusCheck = true;
             plusCheck = true;
             operatorCheck = true;
          }
          else
          {
            inputField.setText(inputField.getText() + "0");
            preValue += "0";
            minusCheck = true;
            plusCheck = true;
            operatorCheck = true;
          } 
      }
    
     else if(event.equals("point"))
      {
    	 char lastValue;
       if(pointCheck == true)	 
       {
    	 if(preValue.equals("")) 
    	 {
    	  inputField.setText("0.");
    	  preValue += "0.";
    	  pointCheck = false;
    	  operatorCheck = true;
    	  minusCheck = true;
          plusCheck = true;
    	 }	 
    	else
    	 {
    	   lastValue = preValue.charAt((preValue.length() - 1));
    	   if(lastValue == '/' || lastValue == '*' || lastValue == '+' || lastValue == '-' || lastValue == '.')
    	    {
             inputField.setText(inputField.getText() + "0.");		
             preValue += "0." ;
             pointCheck = false;
    	     operatorCheck = true;
    	     minusCheck = true;
             plusCheck = true;
    	    } 
    	   else if(lastValue == '.')
    	   {
    	    pointCheck = false;
    	    operatorCheck = true;
    	    minusCheck = true;
            plusCheck = true;
    	   }
    	  else
    	   {
            inputField.setText(inputField.getText() + ".");		
            preValue += ".";
            pointCheck = false;
    	    operatorCheck = true;
    	    minusCheck = true;
            plusCheck = true;
    	   } 
    	 }
     }
 }
     else 
      inputField.setText("use key Pad To enter Value");
      }
   } 
 }   
 
  //------------------------------------------------------
 
 
private class OperatorListener implements ActionListener 
 {
   public void actionPerformed (ActionEvent e)
   {
	 String event = e.getActionCommand();  
	  
 if(keyLock == false)	
 {
	if(event.equals("add"))   
	 {  
	  if(plusCheck == true)  
	  {
	   if(preValue.equals(""))
	    {
		 inputField.setText(inputField.getText() + " + ");
		 preValue = "0+";
		 pointCheck = true;
	     minusCheck = true;
		 plusCheck = false;
		 operatorCheck = false;
	    }
	   else if(preValue.charAt(preValue.length()- 1) == '.')
	   {
		inputField.setText(inputField.getText() + "0" + " + ");   
	    preValue += "0+";
	    pointCheck = true;
	    minusCheck = true;
	    operatorCheck = false;
	    plusCheck = false;
	   }
	   else if(preValue.charAt(preValue.length()- 1) == '-')
	   {
	     if(preValue.charAt(preValue.length()- 2) != '*' && preValue.charAt(preValue.length()- 2) != '/')
	     {  
		   inputField.setText(inputField.getText().substring(0,(inputField.getText().length() - 3)) + " + ");  
	       preValue = (preValue.substring(0,preValue.length() - 1) + "+");
	       pointCheck = true; 
	       minusCheck = true;
	       operatorCheck = false;
	       plusCheck = false;
	     }
	   }    
	   else
	   { 
		inputField.setText(inputField.getText() + " + ");
		preValue += "+";
	    pointCheck = true;
	    minusCheck = true;
	    plusCheck = false;
	    operatorCheck = false;
	   }
	  } 
	 }
	 else if(event.equals("minus"))
	 {
	  if(minusCheck == true)
	  {
	   if(preValue.equals(""))
		{
	      inputField.setText(inputField.getText() + " - ");
		  preValue = "0-";
		  pointCheck = true;
		  plusCheck = true;
		  operatorCheck = false;
		  minusCheck = false;
		  System.out.println(minusCheck);
		}
	   else if(preValue.charAt(preValue.length()- 1) == '.')
		{
	     inputField.setText(inputField.getText() + "0" + " - ");   
		 preValue += "0-";
		 pointCheck = true;
		 plusCheck = true;
		 operatorCheck = false;
		 minusCheck = false;
		}
	   else if(preValue.charAt(preValue.length()- 1) == '+')
	   {
	    inputField.setText(inputField.getText().substring(0,(inputField.getText().length() - 3)) + " - ");  
	    preValue = (preValue.substring(0,preValue.length() - 1) + "-");
	    pointCheck = true; 
	    plusCheck = true;
	    operatorCheck = false;
	    minusCheck = false;
	   } 
	   else if(preValue.charAt(preValue.length()- 1) == '/' || preValue.charAt(preValue.length()- 1) == '*')
	   {
		 inputField.setText(inputField.getText() + "- ");
		 preValue += "-";
	     pointCheck = true;
		 plusCheck = true;
		 operatorCheck = false;
		 minusCheck = false;  
	   }
	   else
	   { 
	    inputField.setText(inputField.getText() + " - ");
		preValue += "-";
		pointCheck = true;
		plusCheck = true;
		operatorCheck = false;
	    minusCheck = false;
	   }
	  }
	 }
	
   else if(event.equals("division"))
	{
     if(operatorCheck == true)
	  {
       if(preValue.equals(""))
 		{
 	      inputField.setText(inputField.getText() + " / ");
 		  preValue = "0/";
 		  pointCheck = true;
 		  operatorCheck = false;
 		  minusCheck = true;
 		  plusCheck = false;
 		}
 	   else if(preValue.charAt(preValue.length()- 1) == '.')
 		{
 	     inputField.setText(inputField.getText() + "0" + " / ");   
 		 preValue += "0/";
 		 pointCheck = true;
 		 operatorCheck = false;
 		 minusCheck = true;
 		 plusCheck = false;
 		}
 	   else
 	   { 
 	    inputField.setText(inputField.getText() + " / ");
 		preValue += "/";
 		pointCheck = true;
 		operatorCheck = false;
 		minusCheck = true;
 		plusCheck = false;
 	   }  
	  }	  
	}  
   else if(event.equals("times"))	 
   {
	   if(operatorCheck == true)
		{
		   if(preValue.equals(""))
			{
		      inputField.setText(inputField.getText() + " * ");
			  preValue = "0*";
			  pointCheck = true;
			  operatorCheck = false;
			  minusCheck = true;
	 		  plusCheck = false;
			}
		   else if(preValue.charAt(preValue.length()- 1) == '.')
			{
		     inputField.setText(inputField.getText() + "0" + " * ");   
			 preValue += "0*";
			 pointCheck = true;
			 operatorCheck = false;
			 minusCheck = true;
	 		 plusCheck = false;
			}
		  else
		   { 
		    inputField.setText(inputField.getText() + " * ");
			preValue += "*";
			pointCheck = true;
			operatorCheck = false;
			minusCheck = true;
	 		plusCheck = false;
		   }
		}   
   }
  else if (event.equals("equals"))
   { 
    if((!(preValue.equals(""))))                                                                                                               
    {
       populateArray();
       inputCorrecter();
     
     
     System.out.println(preValue);  
     if((!(inputField.getText().equals("Can't divide By Zero!"))))
      {
    	 String format = Double.toString(result);
    	 int k = 0,n = 0;
    	
       outerloop:
       for(int i = 0; i < format.length(); i ++)  
    	{
    	  if(format.charAt(i) == '.')	
    	  {
    		k = i + 1;
    		n = i;
    		
    		while(k < format.length())
    		{
    		  if(format.charAt(k) != '0') 
    		  {
    		   k = 1;
    		   break outerloop;
    		  }
    		  else
    	       k ++;
    	    }
    	  }
    	}
    	 
    
    if(k == 1)   
     outputField.setText(format);    
    else  
     outputField.setText(format.substring(0, n));
     
   result = 0;
     }
    }
   }
  }
 }
}
//---------------------------------------------------------

private class FunctionKeyListener implements ActionListener
{
  public void actionPerformed (ActionEvent e)
   {
	  String event = e.getActionCommand();
  	 
	 if(event.equals("Clear"))
	 {
	    int length = inputField.getText().length(); 
		 
	  if((!(inputField.getText().equals("0"))) && keyLock == false)
	   {
		 if( length - 1 > 0 )
		 {
		   if(inputField.getText().charAt(length - 1) == ' ')
		   {
			   if(inputField.getText().charAt(length - 2) == '-' )
			   {
				 if(Character.isDigit(inputField.getText().charAt(length - 4)))
				 {
				  inputField.setText(inputField.getText().substring(0,(length - 3))); 
				  preValue = preValue.substring(0,preValue.length() - 1);	 
				 }
				 else
				 {
				  inputField.setText(inputField.getText().substring(0,(length - 2))); 
			      preValue = preValue.substring(0,preValue.length() - 1);	
				 }
			    }
			   else
			   { 
			    inputField.setText(inputField.getText().substring(0,(length - 3))); 
		        preValue = preValue.substring(0,preValue.length() - 1);
			   }	   
		   }
		   else 
		   {
			inputField.setText(inputField.getText().substring(0,(length - 1)));  
			preValue = preValue.substring(0,preValue.length() - 1);      
		   }
		}
	  else if( length  - 1 == 0 )
	   {
		 inputField.setText("0");
		 preValue = "";
	   }
	 	   
	   pointCheck = true; 
	   operatorCheck = true;
	   minusCheck = true;
	   plusCheck = true;
	   length = inputField.getText().length();
	   

		if(inputField.getText().charAt(length - 1) == ' ')   
		{
		   if(inputField.getText().charAt(length - 2) == '/' || inputField.getText().charAt(length - 2) == '*')	
		   {
		     operatorCheck = false;	
		     plusCheck = false;	
		   }
		   if(inputField.getText().charAt(length - 2) == '+')
		   {
			operatorCheck = false;  
			plusCheck = false;   
		   }
		  if(inputField.getText().charAt(length - 2) == '-')	
		  {
           operatorCheck = false;			  
		   minusCheck = false;	  

		  }		
	   }
	  else if (inputField.getText().charAt(length - 1) == '.')   
	  {
		pointCheck = false;
	  }
	  else if(Character.isDigit(inputField.getText().charAt(length - 1))) 
	  {
		if(length - 2 >= 0)
		{  
		  length -= 2; 
		  while(length >= 0 && (inputField.getText().charAt(length) != ' '))
		  {
			if(inputField.getText().charAt(length) == '.')  
			 {
			  pointCheck =  false;
			  break;
			 }
		   length --;
		  } 
		} 
	 }
	  
   		   
  }
}  
  else if(event.equals("Reset"))	 
    {
	  inputField.setText("0");	
	  outputField.setText("");
	  preValue = "";	
  	  result = 0;
	  operatorCheck = true;
	  pointCheck = true;
	  minusCheck = true;
	  plusCheck = true;
	  keyLock = false;
	  inputField.setFont(inputField.getFont().deriveFont(20.0f));
      inputField.setBackground(Color.WHITE);
      inputField.setForeground(Color.BLACK);
    }
   else if(event.equals("Ans"))		  
   {
	int k = 0;
	   
	if(keyLock == false && (!(outputField.getText().equals(""))))  
	{ 
	  inputField.setText(outputField.getText()); 
      preValue = inputField.getText();
	  outputField.setText("");	
	
	  operatorCheck = true;
	  minusCheck = true;
	  plusCheck = true;
	  pointCheck = true;
	  
	while( k < inputField.getText().length())
	{
	  if(inputField.getText().charAt(k) == '.')
	  {
        pointCheck = false;
	    break;
	  }	
	  k++;
	}
   }
  } 
   else if(event.equals("About"))		  
   { 
	if(keyLock == false)
	{ 
	  inputField.setFont(inputField.getFont().deriveFont(15.0f));
	  inputField.setForeground(Color.ORANGE);
	  inputField.setBackground(Color.BLUE);
	  inputField.setText("Developer@ frezersirak8@gmail.com");   
	  outputField.setText("");
      keyLock = true;
	} 
  }
 }
}
private class ColorKeyListener implements ActionListener 	
{
  public void actionPerformed (ActionEvent e)
  {
    String event = e.getActionCommand(); 	 
	  
	if(event.equals("Green"))
	   colorChanger(Color.GREEN);  
    
	else if(event.equals("Magenta")) 
	   colorChanger(Color.MAGENTA);
  
	else if(event.equals("Blue"))
       colorChanger(Color.BLUE);
    
	else if(event.equals("Red"))
       colorChanger(Color.RED);
  
   else if (event.equals("Orange"))
       colorChanger(Color.ORANGE);
   
   else
	 colorChanger(Color.BLACK);

  }	
}
	
//==================================================================
//==================================================================

private static void populateArray ()
{
   int k = preValue.length();
   
   for(int i = k - 1; i >= 0; i --)
   { 
	if(Character.isDigit(preValue.charAt(i)))   
	 {
	   k = i;	 
	   break;
	 }
   }
	
   preValue = preValue.substring(0,k + 1);		
   
   String arr [] = new String [preValue.length()];
	
	for(int i = 0; i < arr.length ; i++)
  	   arr[i] = preValue.charAt(i) + "";
  	
  	division(arr);
}


//--------------------------------------------------------
private static void division (String [] arr)	   
{	   
	 int j = 0,k = 0,n = 0;
	 String num = "",num2 = "";
	 
	  while(j < arr.length)
	   {   
		 if(arr[j].equals("/") )  
		 {
		    k = j - 1;	 

		   while((!(arr[k].equals("+"))) && (!(arr[k].equals("*"))) && (!(arr[k].equals("/"))) && (!(arr[k].equals(""))))
		    {
		       if(k > 0 && arr[k].equals("-") && arr[k - 1].equals("E")) 
		        {	
		          if(k - 2 >= 0)
		        	k -= 2;
		          else
		           break;
		        }	
		       else if(arr[k].equals("-"))
		         break;
		       else
		        {
		          if(k - 1 >= 0)	
		            k--;
		          else
		           break; 
		        }
		     }  
		    
		     if(arr[k].equals("-") || (k - 1) < 0)
			   n = k;
			  else
			   n = k + 1;
		      
			  while(n < j)
			  {
			   num = num + arr[n];
			   arr[n] = "";
			   n++;
			  }
	         
			 if(arr[j + 1].equals("-"))
			 {
			  num2 = "-";	 
			  arr[j + 1] = "";
			  k = j + 2;	 
			 }
			 else
			  k = j + 1;
			
		  while((!(arr[k].equals("+"))) && (!(arr[k].equals("*"))) && (!(arr[k].equals("/"))) && (!(arr[k].equals("-"))))
		   {
			 if(arr[k].equals("E") && arr[k + 1].equals("-"))
		       {
  	    	     num2 = num2 + arr[k] + "-";
  	    	     arr[k] = "";
  	    	     arr[k + 1] = "";
  	     	 
  	    	     if(k + 2 < arr.length)  
			       k += 2;
			      else
			        break;
		         }
		       else	
		       {
  	    	      num2 = num2 + arr[k];
			      arr[k] = "";
				 
			      if(k + 1 < arr.length)  
		             k++;
		          else
		    	    break;
		       }   	
		   } 
		  
		   if(Double.parseDouble(num2) == 0)
		   {
		    inputField.setText("Can't dvide by Zero");
		    keyLock = true;
		    return;
		   }
		 
		  arr[k - 1] = Double.toString((Double.parseDouble(num)) / (Double.parseDouble(num2)));	
		  
		  if(arr[j].equals("/"))
		   arr[j] = "";
		 
		   num = "";
		   num2 = "";
		 }
		   
		   j++;   
	   }
		  
multiplication(arr);
}					
		
//-------------------------------------------------------	
private static void multiplication (String [] arr)			
{		
	 int j = 0,k = 0,n = 0;
	 String num = "",num2 = "";
   
   while( j < arr.length)	
	{
	  if(arr[j].equals("*") && arr[j + 1].equals(""))	
	  {
		 k = j - 1;
		 
		 while((!(arr[k].equals("+"))) && (!(arr[k].equals("*"))) && (!(arr[k].equals(""))))
		  { 
			if(k > 0 && arr[k].equals("-") && arr[k - 1].equals("E")) 
        	 {	
        	   if(k - 2 >= 0)
        		k -= 2;
        	   else
        	    break;
        	 }	
        	 else if(arr[k].equals("-"))
        	  break;
        	 
        	 else
        	 {
        	  if(k - 1 >= 0)	
        		k--;
        	  else
        		break;
           	 } 
		  }
		
		 if(arr[k].equals("-") || k - 1 < 0)
		     n = k;
		   else
			 n = k + 1;
		  
		  while(n < j)	  
           {
        	num = num + arr[n];
        	arr[n] = "";
        	n++;	   
           }
          
           k = j + 1;
	  
           while(arr[k].equals("") || arr[k].equals("-"))
           {
        	 if(k + 1 < arr.length)  
        	   k++;
        	 else
        	   break;
           }
	  
          
        arr[k] = Double.toString(Double.parseDouble(num) * Double.parseDouble(arr[k]));
         
         arr[j] = "";
	     num = "";
	}
    else
    {
          if(arr[j].equals("*"))	
          {
        	
        	  k = j - 1;
        	  
        	while((!(arr[k].equals("+"))) && (!(arr[k].equals(""))))  
        	{
        	 if(k > 0 && arr[k].equals("-") && arr[k - 1].equals("E")) 
        	 {	
        	   if(k - 2 >= 0)
        		k -= 2;
        	   else
        	    break;
        	 }	
        	 else if(arr[k].equals("-"))
        	  break;
        	 
        	 else
        	 {
        	  if(k - 1 >= 0)	
        		k--;
        	  else
        		break;
           	}
           }
        	  
           if(arr[k].equals("-") || (k - 1) < 0)  
        	  n = k;
        	else
        	  n = k + 1;
        	  
            while(n < j)
            {
              num = num + arr[n]; 	
              arr[n] = "";	
              n++;	 	
            }
            
            
			 if(arr[j + 1].equals("-"))
			 {
			  num2 = "-";	 
			  arr[j + 1] = "";
			  k = j + 2;	 
			 }
			 else
			  k = j + 1;
            
           while ((!(arr[k].equals("+"))) && (!(arr[k].equals("*"))) && (!(arr[k].equals("-"))) && (!(arr[k].equals(""))))
           {
        	   if(arr[k].equals("E") && arr[k + 1].equals("-"))
		       {
    	    	 num2 = num2 + arr[k] + "-";
    	    	 arr[k] = "";
    	    	 arr[k + 1] = "";
    	     	 
    	    	 if(k + 2 < arr.length)  
			          k += 2;
			      else
			        break;
		       }
		       else	
		       {
    	    	num2 = num2 + arr[k];
			    arr[k] = "";
				 
			   if(k + 1 < arr.length)  
		          k++;
		       else
		    	 break;
		       }   
           }
          
           
            arr[k - 1] = Double.toString(Double.parseDouble(num) * Double.parseDouble(num2));
           
       
           if(arr[j].equals("*"))
            arr[j] = "";
        	   
           num = "";   
           num2 = "";   
       }
   }
		j ++;
}                     
   
addition (arr);
} 		
  
//-----------------------------------------------------
private static void addition (String [] arr)   
{  
	 int j = 0,k = 0,n = 0;
	 String num = "",num2 = "";

  while(j < arr.length)	
	{
	  if(j == 0)
	  {
	    for(int i = 0 ; i < arr.length; i++)
	    {
	       if(arr[i].equals("."))
	       {
	    	  k = i - 1;  
	    	  
	    	 while((!(arr[k].equals("+"))) && (!(arr[k].equals("-"))) && (!(arr[k].equals(""))))  
	           {
	        	  if(k - 1 >= 0)	
	        		k--;
	        	  else
	        		break;
	        	}
	        	if(arr[k].equals("-") || (k - 1) < 0)  
	        	  n = k;
	        	else
	        	  n = k + 1;
	           
	        	while(n < i)
	            {
	             num = num + arr[n]; 	
	             arr[n] = "";	
	             n++;	 	
	            }
	    	    num = num + ".";
	    	    k = i + 1;
	    	     
	    	    while((!(arr[k].equals("+"))) && (!(arr[k].equals("-"))) && (!(arr[k].equals(""))))
			     {
			       if(arr[k].equals("E") && arr[k + 1].equals("-"))
			       {
	    	    	 num2 = num2 + arr[k] + "-";
	    	    	 arr[k] = "";
	    	    	 arr[k + 1] = "";
	    	     	 
	    	         if(k + 2 < arr.length)  
				       k += 2;
				     else
				       break;
			       }
			       else	
			       {
	    	    	 num2 = num2 + arr[k];
				     arr[k] = "";
					 
				     if(k + 1 < arr.length)  
			           k++;
			         else
			    	  break;
			       }        
			    }
	    	    arr[i] = num + num2;
	            num = "";
	            num2 = "";  	      
	      }
	   }
	  
	  for(int i = 0; i < arr.length; i++)
	   {
		if((!(arr[i].equals("+"))) && (!(arr[i].equals("-"))) && (!(arr[i].equals(""))))
		{
	       k = i; 
		  
	      if(i - 1 >= 0)
	      { 
	        if(arr[i - 1].equals("-"))		
	        {
	         num = num + arr[i - 1];
	         arr[i - 1] = "";
	         }
	      }	
	      while((!(arr[k].equals("+"))) && (!(arr[k].equals("-"))) && (!(arr[k].equals(""))))
		   {
			 num = num + arr[k];	
			 arr[k] = "";
			 if(k + 1 < arr.length)
			  k++;
			 else
			  break;
		   }
			
		   arr[i] = num;	
	       num = "";
		}
     }
   }   
	 
	   
  if(((!(arr[j].equals("+"))) && (!(arr[j].equals("-"))) && (!(arr[j].equals("")))))
  {
	result += Double.parseDouble(arr[j]);   
  }	

  j++;
}		   
} 
    
//=======================**==========================
static void inputCorrecter ()
{
  int k = inputField.getText().length() - 1;
	
  for(int i = k; i >= 0; i --)	
  {
	if(Character.isDigit(inputField.getText().charAt(i)))  
     { 
	  k = i;
      break;
     }     
  }
	
  inputField.setText(inputField.getText().substring(0, k + 1));		

  k = inputField.getText().length() - 1;
  pointCheck = true;
   
  for(int i = k; (i >= 0 && (inputField.getText().charAt(i) != ' ')); i--)
   {
	 if(inputField.getText().charAt(i) == '.')  
	 {
	  pointCheck = false;	 
	  break;
	 }
	   
   }
  
  minusCheck = true;
  plusCheck = true;
  operatorCheck = true;
}

private void colorChanger (Color color)
{
 if(keyLock == false)
 {	
   oneButton.setForeground(color);	
   oneButton.setBackground(Color.WHITE);
   twoButton.setForeground(color);	
   twoButton.setBackground(Color.WHITE);
   threeButton.setForeground(color);	
   threeButton.setBackground(Color.WHITE);
   fourButton.setForeground(color);	
   fourButton.setBackground(Color.WHITE);
   fiveButton.setForeground(color);	
   fiveButton.setBackground(Color.WHITE);
   sixButton.setForeground(color);	
   sixButton.setBackground(Color.WHITE);
   sevenButton.setForeground(color);	
   sevenButton.setBackground(Color.WHITE);
   eightButton.setForeground(color);	
   eightButton.setBackground(Color.WHITE);
   nineButton.setForeground(color);	
   nineButton.setBackground(Color.WHITE);
   zeroButton.setForeground(color);	
   zeroButton.setBackground(Color.WHITE);
   pointButton.setForeground(color);
   pointButton.setBackground(Color.WHITE);
   equalsButton.setForeground(color);
   equalsButton.setBackground(Color.WHITE);
   AnsButton.setForeground(color);
   AnsButton.setBackground(Color.WHITE);
   aboutCalculator.setForeground(color);
   aboutCalculator.setBackground(Color.WHITE);
   clearButton.setForeground(color);
   clearButton.setBackground(Color.WHITE);
   resetButton.setForeground(color);
   resetButton.setBackground(Color.WHITE);
   divisionButton.setForeground(color);
   divisionButton.setBackground(Color.WHITE);
   timesButton.setForeground(color);
   timesButton.setBackground(Color.WHITE);
   plusButton.setForeground(color);
   plusButton.setBackground(Color.WHITE);
   minusButton.setForeground(color);
   minusButton.setBackground(Color.WHITE);
   changeGreen.setForeground(color);
   changeGreen.setBackground(Color.WHITE);
   changeMagenta.setForeground(color);
   changeMagenta.setBackground(Color.WHITE);
   changeBlue.setForeground(color);
   changeBlue.setBackground(Color.WHITE);
   changeRed.setForeground(color);
   changeRed.setBackground(Color.WHITE);
   changeDefault.setForeground(color);
   changeDefault.setBackground(Color.WHITE);
   changeOrange.setForeground(color);
   changeOrange.setBackground(Color.WHITE);
  }
}
//================================================ END ================================================//

public static void main (String [] args)
    {
      Calculator calculator = new Calculator ("ColorCalc V3.1");   
      calculator.setVisible(true);
    }

}
