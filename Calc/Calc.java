import java.awt.*;
import java.awt.event.*; 
class Calc implements ActionListener
{
	static String str="";
	static String buffer="";
	static int ch=18;
	static double result=0;
	Frame f;
	TextField tf;
	//{{"MC","MR","MS","M+","M-"},{"<-","CE","C","+-","SQRT"},{"7","8","9","/","%"},{"4","5","6","*","1/x"},{"1","2","3","-","="},{"0","0",".","+","="}}
	Button mc,mr,ms,madd,msub,bac,ce,c,pm,sqrt,b7,b8,b9,div,per,b4,b5,b6,mul,fra,b1,b2,b3,sub,equ,b0,dot,add;
	Label l;
	Calc(String s)
	{
/**************************************************************************************************************************************************************************
																		AWT UI
**************************************************************************************************************************************************************************/
		f=new Frame(s);
		
		int i, j, x, y;
		String[] ll={"View","Edit","Help"};
		for(i=0,x=10,y=20;i<3;i++,x=x+50)
		{
			l=new Label(ll[i]);
			l.setBounds(x,y,40,40);
			f.add(l);
		}
	/*
		String[][] bl = {{"MC","MR","MS","M+","M-"},{"<-","CE","C","+-","SQRT"},{"7","8","9","/","%"},{"4","5","6","*","1/x"},{"1","2","3","-","="},{"0","0",".","+","="}};	
		for(i=0,y=100;i<6;i++,y=y+50) 
		{
			for(j=0,x=10;j<5;j++,x=x+50)
			{
				b=new Button(bl[i][j]);
				b.setBounds(x,y,40,40);
				b.addActionListener(this);
				f.add(b);
			}
		}
	*/ 
		tf=new TextField();
		tf.setBounds(10,60,240,30);
		tf.setText("0");
		f.add(tf);
		String[][] bl = {{"MC","MR","MS","M+","M-"},{"<-","CE","C","+-","SQRT"},{"7","8","9","/","%"},{"4","5","6","*","1/x"},{"1","2","3","-","="},{"0","0",".","+","="}};	
		
		//{"MC","MR","MS","M+","M-"}
		y=100;
		x=10;
		i=0;
		j=0;
		mc=new Button(bl[i][j]);
		mc.setBounds(x,y,40,40);
		mc.addActionListener(this);
		f.add(mc);
		x+=50;
		j+=1;
		mr=new Button(bl[i][j]);
		mr.setBounds(x,y,40,40);
		mr.addActionListener(this);
		f.add(mr);
		x+=50;
		j+=1;
		ms=new Button(bl[i][j]);
		ms.setBounds(x,y,40,40);
		ms.addActionListener(this);
		f.add(ms);
		x+=50;
		j+=1;
		madd=new Button(bl[i][j]);
		madd.setBounds(x,y,40,40);
		madd.addActionListener(this);
		f.add(madd);
		x+=50;
		j+=1;
		msub=new Button(bl[i][j]);
		msub.setBounds(x,y,40,40);
		msub.addActionListener(this);
		f.add(msub);
		
		//{"<-","CE","C","+-","SQRT"}
		x=10;
		j=0;
		y+=50;
		i+=1;
		bac=new Button(bl[i][j]);
		bac.setBounds(x,y,40,40);
		bac.addActionListener(this);
		f.add(bac);
		x+=50;
		j+=1;
		ce=new Button(bl[i][j]);
		ce.setBounds(x,y,40,40);
		ce.addActionListener(this);
		f.add(ce);
		x+=50;
		j+=1;
		c=new Button(bl[i][j]);
		c.setBounds(x,y,40,40);
		c.addActionListener(this);
		f.add(c);
		x+=50;
		j+=1;
		pm=new Button(bl[i][j]);
		pm.setBounds(x,y,40,40);
		pm.addActionListener(this);
		f.add(pm);
		x+=50;
		j+=1;
		sqrt=new Button(bl[i][j]);
		sqrt.setBounds(x,y,40,40);
		sqrt.addActionListener(this);
		f.add(sqrt);
		
		//{"7","8","9","/","%"}
		x=10;
		j=0;
		y+=50;
		i+=1;
		b7=new Button(bl[i][j]);
		b7.setBounds(x,y,40,40);
		b7.addActionListener(this);
		f.add(b7);
		x+=50;
		j+=1;
		b8=new Button(bl[i][j]);
		b8.setBounds(x,y,40,40);
		b8.addActionListener(this);
		f.add(b8);
		x+=50;
		j+=1;
		b9=new Button(bl[i][j]);
		b9.setBounds(x,y,40,40);
		b9.addActionListener(this);
		f.add(b9);
		x+=50;
		j+=1;
		div=new Button(bl[i][j]);
		div.setBounds(x,y,40,40);
		div.addActionListener(this);
		f.add(div);
		x+=50;
		j+=1;
		per=new Button(bl[i][j]);
		per.setBounds(x,y,40,40);
		per.addActionListener(this);
		f.add(per);
		
		//{"4","5","6","*","1/x"}
		x=10;
		j=0;
		y+=50;
		i+=1;
		b4=new Button(bl[i][j]);
		b4.setBounds(x,y,40,40);
		b4.addActionListener(this);
		f.add(b4);
		x+=50;
		j+=1;
		b5=new Button(bl[i][j]);
		b5.setBounds(x,y,40,40);
		b5.addActionListener(this);
		f.add(b5);
		x+=50;
		j+=1;
		b6=new Button(bl[i][j]);
		b6.setBounds(x,y,40,40);
		b6.addActionListener(this);
		f.add(b6);
		x+=50;
		j+=1;
		mul=new Button(bl[i][j]);
		mul.setBounds(x,y,40,40);
		mul.addActionListener(this);
		f.add(mul);
		x+=50;
		j+=1;
		fra=new Button(bl[i][j]);
		fra.setBounds(x,y,40,40);
		fra.addActionListener(this);
		f.add(fra);
		
		//{"1","2","3","-","="}
		x=10;
		j=0;
		y+=50;
		i+=1;
		b1=new Button(bl[i][j]);
		b1.setBounds(x,y,40,40);
		b1.addActionListener(this);
		f.add(b1);
		x+=50;
		j+=1;
		b2=new Button(bl[i][j]);
		b2.setBounds(x,y,40,40);
		b2.addActionListener(this);
		f.add(b2);
		x+=50;
		j+=1;
		b3=new Button(bl[i][j]);
		b3.setBounds(x,y,40,40);
		b3.addActionListener(this);
		f.add(b3);
		x+=50;
		j+=1;
		sub=new Button(bl[i][j]);
		sub.setBounds(x,y,40,40);
		sub.addActionListener(this);
		f.add(sub);
		x+=50;
		j+=1;
		equ=new Button(bl[i][j]);
		equ.setBounds(x,y,40,90);
		equ.addActionListener(this);
		f.add(equ);
		
		//{"0","0",".","+","="}
		x=10;
		j=0;
		y+=50;
		i+=1;
		b0=new Button(bl[i][j]);
		b0.setBounds(x,y,90,40);
		b0.addActionListener(this);
		f.add(b0);
		x+=100;
		j+=2;
		dot=new Button(bl[i][j]);
		dot.setBounds(x,y,40,40);
		dot.addActionListener(this);
		f.add(dot);
		x+=50;
		j+=1;
		add=new Button(bl[i][j]);
		add.setBounds(x,y,40,40);
		add.addActionListener(this);
		f.add(add);
		x+=50;
		j+=1;
		
		f.setLayout(null);
		f.setSize(260,400);
		f.setVisible(true);
	}
/**************************************************************************************************************************************************************************
																		Event Handling
**************************************************************************************************************************************************************************/
	public void actionPerformed(ActionEvent e)
	{
//Invalid
		if(e.getSource()==mc)
		{
			ch=18;
			str="";
			buffer="";
			result=0;
			tf.setText("Invalid MC");
		}
		if(e.getSource()==mr)
		{
			ch=18;
			str="";
			buffer="";
			result=0;
			tf.setText("Invalid MR");
		}
		if(e.getSource()==ms)
		{
			ch=18;
			str="";
			buffer="";
			result=0;
			tf.setText("Invalid MS");
		}
		if(e.getSource()==madd)
		{
			ch=18;
			str="";
			buffer="";
			result=0;
			tf.setText("Invalid M+");
		}
		if(e.getSource()==msub)
		{
			ch=18;
			str="";
			buffer="";
			result=0;
			tf.setText("Invalid M-");
		}
		if(e.getSource()==ce)
		{
			ch=18;
			str="";
			buffer="";
			result=0;
			tf.setText("Invalid CE");
		}
		if(e.getSource()==pm)
		{
			ch=18;
			str="";
			buffer="";
			result=0;
			tf.setText("Invalid +-");
		}
		if(e.getSource()==per)
		{
			ch=18;
			str="";
			buffer="";
			result=0;
			tf.setText("Invalid %");
		}
//0,1,2,3,4,5,6,7,8,9
		if(e.getSource()==b7)
		{
			str=str+"7";
			buffer=buffer+"7";
			tf.setText(str);
		}
		if(e.getSource()==b8)
		{
			str=str+"8";
			buffer=buffer+"8";
			tf.setText(str);
		}
		if(e.getSource()==b9)
		{
			str=str+"9";
			buffer=buffer+"9";
			tf.setText(str);
		}
		if(e.getSource()==b4)
		{
			str=str+"4";
			buffer=buffer+"4";
			tf.setText(str);
		}
		if(e.getSource()==b5)
		{
			str=str+"5";
			buffer=buffer+"5";
			tf.setText(str);
		}
		if(e.getSource()==b6)
		{
			str=str+"6";
			buffer=buffer+"6";
			tf.setText(str);
		}
		if(e.getSource()==b1)
		{
			str=str+"1";
			buffer=buffer+"1";
			tf.setText(str);
		}
		if(e.getSource()==b2)
		{
			str=str+"2";
			buffer=buffer+"2";
			tf.setText(str);
		}
		if(e.getSource()==b3)
		{
			str=str+"3";
			buffer=buffer+"3";
			tf.setText(str);
		}
		if(e.getSource()==b0)
		{
			str=str+"0";
			buffer=buffer+"0";
			tf.setText(str);
		}
//Back Clear
		if(e.getSource()==bac)
		{
			try 
			{    
				str=str.substring(0,str.length()-1);
				buffer=buffer.substring(0,buffer.length()-1);
				tf.setText(str);
            } 
			catch(Exception except) 
			{
                System.out.println("Exception Handle"+except);
				tf.setText(str);
            }
		}
		if(e.getSource()==c)
		{
			ch=18;
			str="";
			buffer="";
			result=0;
			tf.setText("0");
		}
//*,/,+,-
		if(e.getSource()==mul)
		{
			try 
			{    
				calculate(ch);
				ch=1;
				str=str+"*";
				buffer="";
				tf.setText(str);
            } 
			catch(Exception except) 
			{
                System.out.println("Exception Handle"+except);
				tf.setText(str);
            }
		}
		if(e.getSource()==div)
		{
			try 
			{    
				calculate(ch);
				ch=2;
				str=str+"/";
				buffer="";
				tf.setText(str);
            } 
			catch(Exception except) 
			{
                System.out.println("Exception Handle"+except);
				tf.setText(str);
            }
		}
		if(e.getSource()==add)
		{
			try 
			{    
				calculate(ch);
				ch=3;
				str=str+"+";
				buffer="";
				tf.setText(str);
            } 
			catch(Exception except) 
			{
                System.out.println("Exception Handle"+except);
				tf.setText(str);
            }
		}
		if(e.getSource()==sub)
		{
			try 
			{    
				calculate(ch);
				ch=2;
				str=str+"-";
				buffer="";
				tf.setText(str);
            } 
			catch(Exception except) 
			{
                System.out.println("Exception Handle"+except);
				tf.setText(str);
            }
		}
//=
		if(e.getSource()==equ)
		{
			try 
			{    
				calculate(ch);
				tf.setText(String.valueOf(result));
            } 
			catch(Exception except) 
			{
                System.out.println("Exception Handle"+except);
				tf.setText(String.valueOf(result));
            }
			ch=18;
			str="";
			buffer="";
		}
//.
		if(e.getSource()==dot)
		{ 
			if(buffer.indexOf(".")==-1)
			{    
				str=str+".";
				buffer=buffer+".";
				tf.setText(str);
            }
			else
			{
				tf.setText(str);
			}						
		}
//sqrt,1/x
		if(e.getSource()==sqrt)
		{
			str="";
			buffer="";
			result=0;
			tf.setText("Invalid sqrt");
		}
		if(e.getSource()==fra)
		{
			str="";
			buffer="";
			result=0;
			tf.setText("Invalid 1/x");
		}
	}
/**************************************************************************************************************************************************************************
																		Calculation
**************************************************************************************************************************************************************************/
	static void calculate(int n)
	{
		double a;
		double r=0;
		if(n==1)
		{
			a=Double.parseDouble(buffer);
			System.out.println("a"+a+"ch"+n);
			r=result*a;
			System.out.println("*"+r);
		}
		else if(n==2)
		{
			a=Double.parseDouble(buffer);
			System.out.println("a"+a+"ch"+n);
			try
			{
				r=result/a;
			}
			catch(ArithmeticException except)
			{
				r=0;
				ch=18;
				str="";
				buffer="";
				System.out.println("Exception Handle"+except);
			}
			System.out.println("result"+r);
		}
		else if(n==3)
		{
			a=Double.parseDouble(buffer);
			System.out.println("a"+a+"ch"+n);
			r=result+a;
			System.out.println("+"+r);
		}
		else if(n==4)
		{
			a=Double.parseDouble(buffer);
			System.out.println("a"+a+"ch"+n);
			r=result-a;
			System.out.println("-"+r);
		}
		else if(n==18)
		{
			a=Double.parseDouble(buffer);
			System.out.println("a"+a+"ch"+n);
			r=a;
			System.out.println(""+r);
		}
		result=r;
	}
	public static void main(String args[])
	{
		new Calc("Calculator");
	}
}