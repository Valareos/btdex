package btdex.core;

import java.util.ArrayList;

import btdex.markets.MarketHIVE;
import btdex.markets.MarketSSIGNA;
import signumj.service.NodeService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Markets {
    private static ArrayList<Market> markets = new ArrayList<>();
    private static ArrayList<Market> userMarkets = new ArrayList<>();
    private static Market token;

    private static Logger logger = LogManager.getLogger();

    public static void loadStandardMarkets(Boolean testnet, NodeService NS) {
        markets.add(token = new MarketTRT());
        
//        markets.add(new MarketEUR());
//        markets.add(new MarketBRL());
        
		markets.add(new MarketHIVE());
		markets.add(new MarketSSIGNA());
    }

    public static void addUserMarket(Market m) {
    	// Add after TRT in the beginning of the list
    	markets.add(userMarkets.size()+1, m);
    	userMarkets.add(m);
		logger.info("User market {} added", m.getID());
    }

    public static void removeUserMarket(Market m) {
    	markets.remove(m);
    	userMarkets.remove(m);
		logger.info("User market {} removed", m.getID());
    }

    public static ArrayList<Market> getMarkets(){
        return markets;
    }

    public static ArrayList<Market> getUserMarkets(){
        return userMarkets;
    }

    public static Market getToken() {
        return token;
    }

    public static Market findMarket(long id) {
    	for(Market m : markets) {
    		if(m.getID() == id)
    			return m;
    	}
    	return null;
    }
}
