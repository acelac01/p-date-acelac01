package es.unileon.prg1.date;

public class Date
{
	private int day;
	private int month;
	private int year;

	void printMonthName();

	int getNumDaysMonth(int month)
	{
		switch(this.month)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: numDays = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11: numDays = 30;
				break;
			case 2: numsDays = 28;
				break;
		}

	return numDays;
	
	
	int getNumDaysMonth();
	{
		int numDays=0;

			
	}		

	return this.getNumDaysMonth(this.month);
	}

	void printMonthsSameAmountDays(){
	for(int i=1; i<=2; i++){
		if (getNumDaysMonth(i)==this.getNumDaysMonth(i)){
		
		}
	}
	}

}
