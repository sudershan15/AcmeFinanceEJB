package com.foo.Client;

 

import java.io.*;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.jms.*;



public class StockSenderClient {

	Queue queue = null;
	QueueConnectionFactory factory = null;
	QueueConnection connection = null;
	QueueSender sender = null;
	QueueSession session = null;


	public void sendMessage(String msg) {
		try {

			Properties props = new Properties();
			props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			Context ctx = new InitialContext(props);
			factory = (QueueConnectionFactory) ctx.lookup("XAConnectionFactory");
			connection = factory.createQueueConnection();
			session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			queue = (Queue) ctx.lookup("queue/MyStocks");
			sender = session.createSender(queue);
			//create and set a message to send
			TextMessage message = session.createTextMessage(msg);


			sender.send(message);
			System.out.println("Sending message");   
			session.close ();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upload(String path)
	{
		try 
		{
    		File file = new File("path");
        	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        	String line = null;
			while( (line = br.readLine())!= null ){
			      
			    //String [] tokens = line.split(",");
			    //String var_1 = tokens[0];
			    //String var_2 = tokens[1];
			    //String var_3 = tokens[2];
			    //System.out.println("var_1"+var_1);
			    //System.out.println("var_2"+var_2);
			    //System.out.println("var_3"+var_3);
				System.out.println(line);
				StockSenderClient r=new StockSenderClient();
				r.sendMessage(line);
				System.out.println("message sent.."+line);
}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
	/*public static void main(String... args)
	{
		
    	try {
    		File file = new File("C:/MyFiles/Spring 2012/CMPE 275/project1/full_set/sp080522.txt");
        	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        	String line = null;
			while( (line = br.readLine())!= null ){
			      
			    //String [] tokens = line.split(",");
			    //String var_1 = tokens[0];
			    //String var_2 = tokens[1];
			    //String var_3 = tokens[2];
			    //System.out.println("var_1"+var_1);
			    //System.out.println("var_2"+var_2);
			    //System.out.println("var_3"+var_3);
				System.out.println(line);
				StockSenderClient r=new StockSenderClient();
				r.sendMessage(line);
				System.out.println("message sent.."+line);
}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	}*/
