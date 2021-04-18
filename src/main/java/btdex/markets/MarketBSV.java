package btdex.markets;

public class MarketBSV extends MarketBCH {
	
	public String getTicker() {
		return "BSV";
	}
	
	@Override
	public long getID() {
		return MARKET_BSV;
	}
	
	@Override
	public int getUCA_ID() {
		return 3602;
	}
}
