package hw6;

public class ForeignStockHolding extends StockHolding
{
	float conversionRate;

	public ForeignStockHolding() {
		super();
		conversionRate = (float)1.30;
	}
	
	float costInDollars()
	{
		return conversionRate * purchaseSharePrice * numberOfShares;
	}
	
	float valueInDollars()
	{
		return conversionRate * currentSharePrice * numberOfShares;
	}
	
}
