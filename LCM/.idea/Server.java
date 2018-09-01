import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{
	ArrayList al = new ArrayList();
	ServerSocket ss;
	Socket s;
	public Server()
	{
		try
		{
			ss = new ServerSocket(10);
			while(true)
			{
				s = ss.accept();
				System.out.println("Client Connected");
				al.add(s);
				Runnable r = new MyThread(s, al);
				Thread t = new Thread(r);
				t.start();
			} 
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
	}
	public static void main(String args[])
	{
		new Server();
	}
}
class MyThread implements Runnable
{
	Socket s;
	ArrayList al;
	MyThread(Socket s, ArrayList al)
	{
		this.s=s;
		this.al=al;
	}
	public void run()
	{
		String s1;
		try
		{
			DataInputStream din = new DataInputStream(s.getInputStream());
			do 
			{
				s1=din.readUTF();
				System.out.println(s1);
				if(!s1.equals("stop"))
				{
					tellEveryOne(s1);
				}
				else 
				{
					DataOutputStream dout=new DataOutputStream(s.getOutputStream());
					dout.writeUTF(s1);
					dout.flush();
					al.remove(s);
				}
			}
			while(!s1.equals("stop"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void tellEveryOne(String s1)
	{
		Iterator i = al.iterator();
		while(i.hasNext())
		{
			try
			{
				Socket sc = (Socket)i.next();
				DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				dout.writeUTF(s1);
				dout.flush();
				System.out.println("Client");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
