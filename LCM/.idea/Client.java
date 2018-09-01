import java.io.*;
import java.net.*;

public class Client
{
	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	public Client()
	{
		try 
		{
			s= new Socket("127.0.0.1",10);
			din= new DataInputStream(s.getInputStream());
			dout= new DataOutputStream(s.getOutputStream());
			clientChat();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void clientChat() throws IOException
	{
		My m = new My(din);
		Thread t1 = new Thread(m);
		t1.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1="";
		do
		{
			s1=br.readLine();
			dout.writeUTF(s1);
			dout.flush();
		}
		while(!s1.equals("stop"));
	}
	public static void main(String args[])
	{
		new Client();
	}
}
class My implements Runnable
{
	DataInputStream din;
	My(DataInputStream din)
	{
		this.din=din;
	}
	public void run()
	{
		String s2="";
		do
		{
			try 
			{
				s2=din.readUTF();
				System.out.println(s2);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		while(!s2.equals("stop"));
	}
}
		