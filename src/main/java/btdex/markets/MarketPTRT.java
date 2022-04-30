package btdex.markets;

import java.util.ArrayList;
import java.util.HashMap;

import btdex.core.Globals;
import btdex.core.Market;
import btdex.core.NumberFormatting;
import signumj.entity.SignumID;

public class MarketPTRT extends Market {
	
	public String getTicker() {
		return "PTRT";
	}
	
	@Override
	public String getChainDetails() {
		return "PTRT on signum chain";
	}
	
	@Override
	public String getExplorerLink() {
		return "https://explorer.signum.network/?action=token_inspect&id=11321999869010741514";
	}
	
	@Override
	public String toString() {
		return // Constants.BURST_TICKER + "-" + 
				getTicker();
	}
	
	@Override
	public SignumID getTokenID() {		
		return SignumID.fromLong("11321999869010741514");
	}
	
	@Override
	public NumberFormatting getNumberFormat() {
		return NumberFormatting.TOKEN;
	}
	
	@Override
	public long getFactor() {
		return 10000L;
	}
	
	public String format(long value) {
		double dvalue = (double)value/getFactor();
		return getNumberFormat().format(dvalue);
	}
	
	@Override
	public long getID() {
		// Tokens do not use the market ID, but the token ID
		return 0;
	}
	
	@Override
	public int getUCA_ID() {
		return 0;
	}
	
	@Override
	public ArrayList<String> getFieldKeys(){
		return null;
	}
	
	@Override
	public void validate(HashMap<String, String> fields) throws Exception {
		// not needed for a token
	}
	
	@Override
	public String simpleFormat(HashMap<String, String> fields) {
		return getTokenID().getID();
	}
}
