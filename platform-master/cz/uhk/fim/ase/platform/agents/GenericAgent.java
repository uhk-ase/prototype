package cz.uhk.fim.ase.platform.agents;

import cz.uhk.fim.ase.platform.core.Platform;
import cz.uhk.fim.ase.platform.core.Registry;
import cz.uhk.fim.ase.platform.model.Agent;
import cz.uhk.fim.ase.platform.model.Message;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public abstract class GenericAgent implements Runnable {

    private Agent identity;
    private Platform platform;
    
    public GenericAgent(Platform platform, Agent identity) {
        this.platform = platform;
        this.identity = identity;
    }

    public Agent getIdentity() {
        return identity;
    }

    public Registry getRegistry() {
        return platform.getRegistry();
    }

    public void send(Message message) {
        if (message.getSender() == null) {
            message.setSender(getIdentity());
        }
        platform.getSender().send(message);
    }

    public Message receive() {
        return platform.getQueue().get(getIdentity());
    }

    public abstract void run();
    
    public Message Shop() {
    	//TODO sjednotit do metody kde se bude jen m�nit produkt, quntity, price, a �asem p�ev�st do decision
    	//beter switch
    	Message request = new Message();
		Agent a;
		
		if (identity.getProdukt() == "food" && identity.getInventory().getFood()>1) {
			a=FindAgent("food");
			
			request.setRecipient(a);
			request.setFipa_type("offer");
			request.setBuy_sell("sell");
			request.setProdukt("food");
			request.setQuantity(10);
			request.setPrice(1000);
			
			return request;
		}
		if (identity.getProdukt() == "painkiller" && identity.getInventory().getPainkiller()>1) {
			a=FindAgent("painkiller");
			
			request.setRecipient(a);
			request.setFipa_type("offer");
			request.setBuy_sell("sell");
			request.setProdukt("painkiller");
			request.setQuantity(10);
			request.setPrice(1000);
			
			return request;
		}
		if (identity.getProdukt() == "tool" && identity.getInventory().getTool()>1) {
			a=FindAgent("tool");
			
			request.setRecipient(a);
			request.setFipa_type("offer");
			request.setBuy_sell("sell");
			request.setProdukt("tool");
			request.setQuantity(10);
			request.setPrice(1000);
			
			return request;
		}
		else {
			request.setFipa_type("fail");
		}
		return request;
	}
    
    public Agent FindAgent(String filter) {
    	
		Agent a = null;
		
		if (filter=="food")
		for (Agent agent : identity.getPartners()) {
			if(agent.getInventory().getFood()<=50 && agent.getProdukt()!="food" && agent.getInventory().getFinance()>=1){
				return a;
			}
		}
		if (filter=="painkiller")
			for (Agent agent : identity.getPartners()) {
				if(agent.getInventory().getPainkiller()<=15 && agent.getProdukt()!="painkiller" && agent.getInventory().getFinance()>=10){
					return a;
				}
			}
		if (filter=="tool")
			for (Agent agent : identity.getPartners()) {
				if(agent.getInventory().getTool()<=5 && agent.getProdukt()!="tool" && agent.getInventory().getFinance()>=50){
					return a;
				}
			}
				return a;
	}
    public void Work() {
    	
		if (identity.getProdukt() == "food") {
			if (identity.getInventory().getFood() <= 50)
				identity.getInventory().workFood();
			else
				identity.getInventory().rest();
		}
		if (identity.getProdukt() == "painkiller") {
			if (identity.getInventory().getPainkiller() <= 15)
				identity.getInventory().workPainkiller();
			else
				identity.getInventory().rest();
		}
		if (identity.getProdukt() == "tool") {
			if (identity.getInventory().getTool() <= 5)
				identity.getInventory().workTool();
			else
				identity.getInventory().rest();
		}
	}
    
    public void Repair() {
    	
		if (identity.getInventory().getToolHealth() < 10 && identity.getInventory().getTool() > 0)
			identity.getInventory().useTool();
		else if (identity.getInventory().getHealth() <= 90 && identity.getInventory().getPainkiller() > 0)
			identity.getInventory().usePainkiller();
		else if (identity.getInventory().getHunger() <= 97 && identity.getInventory().getFood() > 0)
			identity.getInventory().useFood();
	}
    
    public Message decision(Message messege) {
    	// rozhodov�n� se �asem rozroste a d�me ho do samostatn� t��dy
    	if (messege.getFipa_type() == "offer") {
    		if (messege.getBuy_sell() == "sell") {
				switch (messege.getProdukt()) {
				case "food":
					identity.getInventory().buyFood(messege.getQuantity(), messege.getPrice());
					messege.setFipa_type("Accept");
					break;
				case "tool":
					identity.getInventory().buyTool(messege.getQuantity(), messege.getPrice());
					messege.setFipa_type("Accept");
					break;
				case "painkiler":
					identity.getInventory().buyPainkiller(messege.getQuantity(), messege.getPrice());
					messege.setFipa_type("Accept");
					break;

				default:
					messege.setFipa_type("Fail");
					break;
				}
			}
		}
		return messege;
	}
}
