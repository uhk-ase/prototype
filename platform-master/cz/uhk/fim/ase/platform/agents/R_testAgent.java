package cz.uhk.fim.ase.platform.agents;

import java.security.Identity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cz.uhk.fim.ase.platform.communication.direct.MessageQueue;
import cz.uhk.fim.ase.platform.core.Platform;
import cz.uhk.fim.ase.platform.model.Agent;
import cz.uhk.fim.ase.platform.model.Message;

/**
 * @author Tomáš Kolinger <tomas@kolinger.name>
 */
public class R_testAgent extends GenericAgent {

	private int stuff = 0;
    private Random random = new Random();
    private ArrayList<Message> offerList;
    
    public R_testAgent(Platform platform, Agent identity) {
        super(platform, identity);
        identity.getAttributes().put("seller", "true");
        
        //TODO
        ArrayList<Agent> partners = null;
        List<Agent> agents = getRegistry().getAgents();
        for (int i = 0; i < 10; i++) {
        	Agent a = agents.get(random.nextInt(agents.size() - 1));
        	partners.add(a);
        	//poslat zpr�vu druh�mu otom �e se zanj�
		}
    }

    @Override
    public void run() {
    	//Agent standart work. He made his produkt. Repair him self. And try meke some busnis.
    	Work();
		Repair();
		
		for (int i = 0; i < 5; i++) {
			Message offer_for_someone = Shop();
			offer_for_someone.setSender(getIdentity());
			send(offer_for_someone);	
		}
		
		
        //Agent respond on offer from other agent.
		while (receive() != null) {
			Message offer_for_me = receive();
			Message offer_respond = decision(offer_for_me);
			offer_respond.setSender(getIdentity());
			send(offer_respond);			
		}
    }
}
