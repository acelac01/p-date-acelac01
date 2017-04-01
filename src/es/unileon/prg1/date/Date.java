//Álvaro Celada Celada

package es.unileon.prg1.date;

public class Date
{
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) throw.DateExceptions{

	this.day = day;
	
		if(month<1 || month>12){
			throw new DateException ("Month "+ month +" invalid");
		}else{
			this.month = month;
		}

	this.year = year;
	
	}

	public int getDay(){

	}


	boolean isSameDay(int day){

		boolean isSameDay=false;

		if (this.day=day){
			isSameDay=true;
		}

	}

	boolean isSameMonth(){
		
		boolean isSameMonth=false;

		if (this.month=month){
			isSameMonth=true;
		}
	}

	boolean isSameYear(){
		
		boolean isSameYear=false;

		if (this.year=year){
			isSameYear=true;
		}
	}

	
	boolean isSame(){
		
		boolean isSame=false;

		if(this.date=date){
			isSame=true;
		}
	}



	public String nameOfMonth(int month)
	{

		String nameMonth = "";

		switch(this.month)
		{
			case 1: nameMonth = January;
				break;
			case 2: nameMonth = February;
				break;
			case 3: nameMonth = March;
				break;
			case 4: nameMonth = April;
				break;
			case 5: nameMonth = May;
				break;
			case 6: nameMonth = June;
				break;
			case 7: nameMonth = July;
				break;
			case 8: nameMonth = August;
				break;
			case 9: nameMonth = September;
				break;
			case 10: nameMonth = October;
				break;
			case 11: nameMonth = November;
				break;
			case 12: nameMonth = December;
				break;
		}

		return name;

	}

	int daysOfMonth(int month)
	{

		int numDays = 0;

		switch(this.month)
		{
			case 1: //next
			case 3: //next
			case 5: //next
			case 7: //next
			case 8: //next
			case 10: //next
			case 12: numDays = 31;
				break;
			case 4: //next
			case 6: //next
			case 9: //next
			case 11: numDays = 30;
				break;
			case 2: numsDays = 28;
				break;
		}

		return numDays;
	}

	public String getSeason(){

		String season = "";

		switch(this.month){
			case 1:	//next
			case 2: season = "Winter";
				break;
			case 3:
				if(this.day<21){
					season = "Winter";				
				}else{
					season = "Spring";
				}
				break;
			case 4:	//next
			case 5: season = "Spring";
				break;
			case 6: 
				if(this.day<21){
					season = "Spring";
				}else{
					season = "Summer";
				}
				break;
			case 7:	//next
			case 8: season = "Summer";
				break;
			case 9: 
				if(this.day<21){
					season = "Summer";
				}else{
					season = "Autum";	
				}
				break;
			case 10: //next
			case 11: season = "Autum";
				break;
			case 12: 
				if(this.day<21){
					season = "Autum";
				}else{
					season = "Winter";
				}
								
		}

		return season;
	}
	
	
	/*void printMonthsSameAmountDays(){
	for(int i=1; i<=2; i++){
		if (getNumDaysMonth(i)==this.getNumDaysMonth(i)){
		
		}
	}
	}*/

}
