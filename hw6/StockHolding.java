package hw6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StockHolding
{
	float purchaseSharePrice;
	float currentSharePrice;
	int numberOfShares;
	String companyName;
	
	public StockHolding() {
		super();
	}

	public StockHolding(float purchaseSharePrice, float currentSharePrice, int numberOfShares, String companyName) {
		super();
		this.purchaseSharePrice = purchaseSharePrice;
		this.currentSharePrice = currentSharePrice;
		this.numberOfShares = numberOfShares;
		this.companyName = companyName;
	}

	public float getPurchaseSharePrice() {
		return purchaseSharePrice;
	} 
	
	public void setPurchaseSharePrice(float purchaseSharePrice) {
		this.purchaseSharePrice = purchaseSharePrice;
	}
	
	public float getCurrentSharePrice() {
		return currentSharePrice;
	}
	
	public void setCurrentSharePrice(float currentSharePrice) {
		this.currentSharePrice = currentSharePrice;
	}
	
	public int getNumberOfShares() {
		return numberOfShares;
	}
	
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	float costInDollars()
	{
		return purchaseSharePrice * numberOfShares;
	}
	
	float valueInDollars()
	{
		return currentSharePrice * numberOfShares;
	}
	
	public static void main(String args[])
	{
		StockHolding[] NSMutableArray = new StockHolding[3];
		NSMutableArray[0] = new StockHolding();
		NSMutableArray[0].setPurchaseSharePrice((float)2.30);
		NSMutableArray[0].setCurrentSharePrice((float)4.50);
		NSMutableArray[0].setNumberOfShares(40);
		NSMutableArray[0].setCompanyName("B");
		NSMutableArray[1] = new StockHolding();
		NSMutableArray[1].setPurchaseSharePrice((float)12.19);
		NSMutableArray[1].setCurrentSharePrice((float)10.56);
		NSMutableArray[1].setNumberOfShares(90);
		NSMutableArray[1].setCompanyName("A");
		NSMutableArray[2] = new StockHolding();
		NSMutableArray[2].setPurchaseSharePrice((float)45.10);
		NSMutableArray[2].setCurrentSharePrice((float)49.51);
		NSMutableArray[2].setNumberOfShares(210);
		NSMutableArray[2].setCompanyName("M");
		// NSMutableArray[4].setCurrentSharePrice(54); It gives 'ArrayIndexOutOfBoundsException'.
		
		// Bubble-sort the array of instances.
		for(int i = 0; i < NSMutableArray.length - 1; i++)
		{
			for(int j = 0; j < NSMutableArray.length - 1 - i; j++)
			{
				if(NSMutableArray[j].getCompanyName().compareTo(NSMutableArray[j + 1].getCompanyName()) > 0)
				{
					StockHolding temp = NSMutableArray[j];
					NSMutableArray[j] = NSMutableArray[j + 1];
					NSMutableArray[j + 1] = temp;
				}
			}
		}
		
		for(int i = 0; i < NSMutableArray.length; i++)
		{
			System.out.println(NSMutableArray[i].getPurchaseSharePrice());
			System.out.println(NSMutableArray[i].getCurrentSharePrice());
			System.out.println(NSMutableArray[i].getNumberOfShares());
			System.out.println(NSMutableArray[i].getCompanyName());
			System.out.println(NSMutableArray[i].costInDollars());
			System.out.println(NSMutableArray[i].valueInDollars());
		}
		
		// Adding new objects of 'ForeignStockHolding' class to 'NSMutableArray' array.
		ArrayList<StockHolding> myList = new ArrayList<StockHolding>(Arrays.asList(NSMutableArray)); // It shows 'constructor undefined' error if we do 'ArrayList<ForeignStockHolding>'.
		ForeignStockHolding fsh1 = new ForeignStockHolding();
		fsh1.setPurchaseSharePrice((float)2.30);
		fsh1.setCurrentSharePrice((float)4.50);
		fsh1.setNumberOfShares(40);
		fsh1.setCompanyName("Y");
		myList.add(fsh1);
		ForeignStockHolding fsh2 = new ForeignStockHolding();
		fsh2.setPurchaseSharePrice((float)1.30);
		fsh2.setCurrentSharePrice((float)19);
		fsh2.setNumberOfShares(210);
		fsh2.setCompanyName("C");
		myList.add(fsh2);
		NSMutableArray = myList.toArray(NSMutableArray);
		
		// Bubble-sort the array of instances in reverse order.
		for(int i = 0; i < NSMutableArray.length - 1; i++)
		{
			for(int j = 0; j < NSMutableArray.length - 1 - i; j++)
			{
				if(NSMutableArray[j].getCompanyName().compareTo(NSMutableArray[j + 1].getCompanyName()) < 0)
				{
					StockHolding temp = NSMutableArray[j];
					NSMutableArray[j] = NSMutableArray[j + 1];
					NSMutableArray[j + 1] = temp;
				}
			}
		}
		
		System.out.println();
		System.out.println("The array in reverse order : ");
		System.out.println();
		
		for(int i = 0; i < NSMutableArray.length; i++)
		{
			System.out.println(NSMutableArray[i].getPurchaseSharePrice());
			System.out.println(NSMutableArray[i].getCurrentSharePrice());
			System.out.println(NSMutableArray[i].getNumberOfShares());
			System.out.println(NSMutableArray[i].getCompanyName());
			System.out.println(NSMutableArray[i].costInDollars());
			System.out.println(NSMutableArray[i].valueInDollars());
		}	
		
		// Part 3 of the question.
		
		// Taking input for the stocks.
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the no. of stocks you want (maximum 8) : ");
		int n = input.nextInt();
		System.out.println("Enter the type of stock you want (1 for 'StockHolding' and 2 for 'ForeignStockHolding') : ");
		int t = input.nextInt();
		if(t == 1)
		{
			StockHolding[] sArray = new StockHolding[n];
			for(int i = 0; i < n; i++)
			{
				sArray[i] = new StockHolding();
				System.out.println("Enter purchase share price : ");
				float psp = input.nextFloat();
				System.out.println("Enter current share price : ");
				float csp = input.nextFloat();
				System.out.println("Enter no. of shares : ");
				int nos = input.nextInt();
				System.out.println("Enter company name : ");
				String cn = input.next();
				sArray[i].setPurchaseSharePrice(psp);
				sArray[i].setCurrentSharePrice(csp);
				sArray[i].setNumberOfShares(nos);
				sArray[i].setCompanyName(cn);
			}

			// Displaying the menu and performing operations on the array of stocks.
			System.out.println();
			System.out.println("1)	Display stock information with the lowest value\r\n" + 
					"2)	Display stock with the highest value\r\n" + 
					"3)	Display the most profitable stock\r\n" + 
					"4)	Display the least profitable stock\r\n" + 
					"5)	List all stocks sorted by company name (A-Z)\r\n" + 
					"6)	List all stocks sorted from the lowest value to the highest value\r\n" + 
					"7)	Exit\r\n");
			while(true)
			{
				System.out.println();
				System.out.println("Enter your choice of operation : ");
				int ch = input.nextInt();
				System.out.println();
				 
				// Using the switch case for the operations.
				switch(ch)
				{
				case 1 :
					float min = sArray[0].valueInDollars();
					int minPos = 0;
					for(int i = 0; i < sArray.length; i++)
					{
						if(min > sArray[i].valueInDollars())
						{
							min = sArray[i].valueInDollars();
							minPos = i;
						}
					}
					System.out.println("Lowest value is : " + min);
					System.out.println("Stock information : ");
					System.out.println(sArray[minPos].getPurchaseSharePrice());
					System.out.println(sArray[minPos].getCurrentSharePrice());
					System.out.println(sArray[minPos].getNumberOfShares());
					System.out.println(sArray[minPos].getCompanyName());
					System.out.println(sArray[minPos].costInDollars());
					System.out.println(sArray[minPos].valueInDollars());
					break;
				case 2 :
					float max = sArray[0].valueInDollars();
					int maxPos = 0;
					for(int i = 0; i < sArray.length; i++)
					{
						if(max < sArray[i].valueInDollars())
						{
							max = sArray[i].valueInDollars();
							maxPos = i;
						}
					}
					System.out.println("Highest value is : " + max);
					System.out.println("Stock information : ");
					System.out.println(sArray[maxPos].getPurchaseSharePrice());
					System.out.println(sArray[maxPos].getCurrentSharePrice());
					System.out.println(sArray[maxPos].getNumberOfShares());
					System.out.println(sArray[maxPos].getCompanyName());
					System.out.println(sArray[maxPos].costInDollars());
					System.out.println(sArray[maxPos].valueInDollars());
					break;
				case 3 :
					float maxProfit = sArray[0].valueInDollars() - sArray[0].costInDollars();
					int maxPPos = 0;
					for(int i = 0; i < sArray.length; i++)
					{
						if(maxProfit < (sArray[i].valueInDollars() - sArray[i].costInDollars()))
						{
							maxProfit = sArray[i].valueInDollars() - sArray[i].costInDollars();
							maxPPos = i;
						}
					}
					System.out.println("Maximum profit is : " + maxProfit);
					System.out.println("Stock information : ");
					System.out.println(sArray[maxPPos].getPurchaseSharePrice());
					System.out.println(sArray[maxPPos].getCurrentSharePrice());
					System.out.println(sArray[maxPPos].getNumberOfShares());
					System.out.println(sArray[maxPPos].getCompanyName());
					System.out.println(sArray[maxPPos].costInDollars());
					System.out.println(sArray[maxPPos].valueInDollars());
					break;
				case 4 :
					float minProfit = sArray[0].valueInDollars() - sArray[0].costInDollars();
					int minPPos = 0;
					for(int i = 0; i < sArray.length; i++)
					{
						if(minProfit > (sArray[i].valueInDollars() - sArray[i].costInDollars()))
						{
							minProfit = sArray[i].valueInDollars() - sArray[i].costInDollars();
							minPPos = i;
						}
					}
					System.out.println("Minimum profit is : " + minProfit);
					System.out.println("Stock information : ");
					System.out.println(sArray[minPPos].getPurchaseSharePrice());
					System.out.println(sArray[minPPos].getCurrentSharePrice());
					System.out.println(sArray[minPPos].getNumberOfShares());
					System.out.println(sArray[minPPos].getCompanyName());
					System.out.println(sArray[minPPos].costInDollars());
					System.out.println(sArray[minPPos].valueInDollars());
					break;
				case 5 :
					for(int i = 0; i < sArray.length - 1; i++)
					{
						for(int j = 0; j < sArray.length - 1 - i; j++)
						{
							if(sArray[j].getCompanyName().compareTo(sArray[j + 1].getCompanyName()) > 0)
							{
								StockHolding temp = sArray[j];
								sArray[j] = sArray[j + 1];
								sArray[j + 1] = temp;
							}
						}
					}
					for(int i = 0; i < sArray.length; i++)
					{
						System.out.println(sArray[i].getPurchaseSharePrice());
						System.out.println(sArray[i].getCurrentSharePrice());
						System.out.println(sArray[i].getNumberOfShares());
						System.out.println(sArray[i].getCompanyName());
						System.out.println(sArray[i].costInDollars());
						System.out.println(sArray[i].valueInDollars());
					}
					break;
				case 6 :
					for(int i = 0; i < sArray.length - 1; i++)
					{
						for(int j = 0; j < sArray.length - 1 - i; j++)
						{
							if(sArray[j].valueInDollars() > sArray[j + 1].valueInDollars())
							{
								StockHolding temp = sArray[j];
								sArray[j] = sArray[j + 1];
								sArray[j + 1] = temp;
							}
						}
					}
					for(int i = 0; i < sArray.length; i++)
					{
						System.out.println(sArray[i].getPurchaseSharePrice());
						System.out.println(sArray[i].getCurrentSharePrice());
						System.out.println(sArray[i].getNumberOfShares());
						System.out.println(sArray[i].getCompanyName());
						System.out.println(sArray[i].costInDollars());
						System.out.println(sArray[i].valueInDollars());
					}
					break;
				case 7 :
					input.close();
					return;
				default :
					System.out.println("Invalid input.");
				}
			}
			
		}
		else
		{
			ForeignStockHolding[] sArray = new ForeignStockHolding[n];
			for(int i = 0; i < n; i++)
			{
				sArray[i] = new ForeignStockHolding();
				System.out.println("Enter purchase share price : ");
				float psp = input.nextFloat();
				System.out.println("Enter current share price : ");
				float csp = input.nextFloat();
				System.out.println("Enter no. of shares : ");
				int nos = input.nextInt();
				System.out.println("Enter company name : ");
				String cn = input.next();
				sArray[i].setPurchaseSharePrice(psp);
				sArray[i].setCurrentSharePrice(csp);
				sArray[i].setNumberOfShares(nos);
				sArray[i].setCompanyName(cn);
			}
			
			// Displaying the menu and performing operations on the array of stocks.
						System.out.println();
						System.out.println("1)	Display stock information with the lowest value\r\n" + 
								"2)	Display stock with the highest value\r\n" + 
								"3)	Display the most profitable stock\r\n" + 
								"4)	Display the least profitable stock\r\n" + 
								"5)	List all stocks sorted by company name (A-Z)\r\n" + 
								"6)	List all stocks sorted from the lowest value to the highest value\r\n" + 
								"7)	Exit\r\n");
						System.out.println();
						while(true)
						{
							System.out.println("Enter your choice of operation : ");
							int ch = input.nextInt();
							System.out.println();
							 
							// Using the switch case for the operations.
							switch(ch)
							{
							case 1 :
								float min = sArray[0].valueInDollars();
								int minPos = 0;
								for(int i = 0; i < sArray.length; i++)
								{
									if(min > sArray[i].valueInDollars())
									{
										min = sArray[i].valueInDollars();
										minPos = i;
									}
								}
								System.out.println("Lowest value is : " + min);
								System.out.println("Stock information : ");
								System.out.println(sArray[minPos].getPurchaseSharePrice());
								System.out.println(sArray[minPos].getCurrentSharePrice());
								System.out.println(sArray[minPos].getNumberOfShares());
								System.out.println(sArray[minPos].getCompanyName());
								System.out.println(sArray[minPos].costInDollars());
								System.out.println(sArray[minPos].valueInDollars());
								break;
							case 2 :
								float max = sArray[0].valueInDollars();
								int maxPos = 0;
								for(int i = 0; i < sArray.length; i++)
								{
									if(max < sArray[i].valueInDollars())
									{
										max = sArray[i].valueInDollars();
										maxPos = i;
									}
								}
								System.out.println("Highest value is : " + max);
								System.out.println("Stock information : ");
								System.out.println(sArray[maxPos].getPurchaseSharePrice());
								System.out.println(sArray[maxPos].getCurrentSharePrice());
								System.out.println(sArray[maxPos].getNumberOfShares());
								System.out.println(sArray[maxPos].getCompanyName());
								System.out.println(sArray[maxPos].costInDollars());
								System.out.println(sArray[maxPos].valueInDollars());
								break;
							case 3 :
								float maxProfit = sArray[0].valueInDollars() - sArray[0].costInDollars();
								int maxPPos = 0;
								for(int i = 0; i < sArray.length; i++)
								{
									if(maxProfit < (sArray[i].valueInDollars() - sArray[i].costInDollars()))
									{
										maxProfit = sArray[i].valueInDollars() - sArray[i].costInDollars();
										maxPPos = i;
									}
								}
								System.out.println("Maximum profit is : " + maxProfit);
								System.out.println("Stock information : ");
								System.out.println(sArray[maxPPos].getPurchaseSharePrice());
								System.out.println(sArray[maxPPos].getCurrentSharePrice());
								System.out.println(sArray[maxPPos].getNumberOfShares());
								System.out.println(sArray[maxPPos].getCompanyName());
								System.out.println(sArray[maxPPos].costInDollars());
								System.out.println(sArray[maxPPos].valueInDollars());
								break;
							case 4 :
								float minProfit = sArray[0].valueInDollars() - sArray[0].costInDollars();
								int minPPos = 0;
								for(int i = 0; i < sArray.length; i++)
								{
									if(minProfit > (sArray[i].valueInDollars() - sArray[i].costInDollars()))
									{
										minProfit = sArray[i].valueInDollars() - sArray[i].costInDollars();
										minPPos = i;
									}
								}
								System.out.println("Minimum profit is : " + minProfit);
								System.out.println("Stock information : ");
								System.out.println(sArray[minPPos].getPurchaseSharePrice());
								System.out.println(sArray[minPPos].getCurrentSharePrice());
								System.out.println(sArray[minPPos].getNumberOfShares());
								System.out.println(sArray[minPPos].getCompanyName());
								System.out.println(sArray[minPPos].costInDollars());
								System.out.println(sArray[minPPos].valueInDollars());
								break;
							case 5 :
								for(int i = 0; i < sArray.length - 1; i++)
								{
									for(int j = 0; j < sArray.length - 1 - i; j++)
									{
										if(sArray[j].getCompanyName().compareTo(sArray[j + 1].getCompanyName()) > 0)
										{
											ForeignStockHolding temp = sArray[j];
											sArray[j] = sArray[j + 1];
											sArray[j + 1] = temp;
										}
									}
								}
								for(int i = 0; i < sArray.length; i++)
								{
									System.out.println(sArray[i].getPurchaseSharePrice());
									System.out.println(sArray[i].getCurrentSharePrice());
									System.out.println(sArray[i].getNumberOfShares());
									System.out.println(sArray[i].getCompanyName());
									System.out.println(sArray[i].costInDollars());
									System.out.println(sArray[i].valueInDollars());
								}
								break;
							case 6 :
								for(int i = 0; i < sArray.length - 1; i++)
								{
									for(int j = 0; j < sArray.length - 1 - i; j++)
									{
										if(sArray[j].valueInDollars() > sArray[j + 1].valueInDollars())
										{
											ForeignStockHolding temp = sArray[j];
											sArray[j] = sArray[j + 1];
											sArray[j + 1] = temp;
										}
									}
								}
								for(int i = 0; i < sArray.length; i++)
								{
									System.out.println(sArray[i].getPurchaseSharePrice());
									System.out.println(sArray[i].getCurrentSharePrice());
									System.out.println(sArray[i].getNumberOfShares());
									System.out.println(sArray[i].getCompanyName());
									System.out.println(sArray[i].costInDollars());
									System.out.println(sArray[i].valueInDollars());
								}
								break;
							case 7 :
								input.close();
								return;
							default :
								System.out.println("Invalid input.");
							}
						}
		}
		// input.close(); It gives 'Unreachable code' error due to 'return' statement of 'case 7'. 
	}
	
}

