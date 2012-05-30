package com.foo.Stocks;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 * Message-Driven Bean implementation class for: StockRecorder
 *
 */
@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
				@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/MyStocks")})
public class StockRecorder implements MessageListener {

	@Resource // used for rollback of the message in case of any inconsistency. 
	MessageDrivenContext mdc;
	
	@PersistenceContext(unitName="stocksdata") // Entity Manager for persisting data into the database.
	EntityManager em;
	Stocks stocks=null;
    /**
     * Default constructor. 
     */
    public StockRecorder() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	try{
    		TextMessage msg = (TextMessage) message;
    		// The message is extracted and split based on the comma delimiter
    		String[] data = msg.getText().split(",");
    	
    		stocks = new Stocks();
    		stocks.setDate(data[0]);
    		//stocks.setDate((data[0]));
    		stocks.setOpen(Float.parseFloat(data[2]));
    		stocks.setHigh(Float.parseFloat(data[3]));
    		stocks.setLow(Float.parseFloat(data[4]));
    		stocks.setClose(Float.parseFloat(data[5]));
    		stocks.setCap(Long.parseLong(data[6]));
    		stocks.setSymbol(data[1]);
    		
    		/* If you had queried the data from database and altered the object, 
    		it will be an update operation, 
    		since this is a new object JPA will consider this as insert. 
    		More details in JPA Queries link provided in the tutorial*/
    		em.persist(stocks);
    	}
    	catch(Exception e)
    	{
    		// Rollback the message bean in case of exception.
    		mdc.setRollbackOnly();
    	}
        
        
    }

}
