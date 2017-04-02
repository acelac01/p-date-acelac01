//Álvaro Celada Celada

package es.unileon.prg1.date;

public class Date
{
	private int day;
	private int month;
	private int year;

	public Date(){

		this.day = 1;
		this.month = 1;
		this.year = 2016;
	}	



	public Date(int day, int month, int year) throws DateException{

		StringBuffer message = new StringBuffer();

		if (day <= 0){

			message.append("Negative days are not allowed - wrong value for day: " + day + "\n");
		}

		if (month <= 0){

			message.append("Negative months are not allowed - wrong value for month: " + month + "\n");			
		} else {

			if (month > 12){

				message.append("There are only 12 months - wrong value for month: " + month + "\n");							
			} else {

				if (day > this.daysOfMonth(month)){

					message.append("Day/Month wrong combination: " + day + "/" + month + "\n");						
				}				
			}
		}

		if (year<0){

			message.append("Negative years are not allowed - wrong value for year: " + year + "\n");			
		}
		
		if (message.length() != 0){

			throw new dateException(message.toString());
		} else {

			this.day = day;
			this.month = month;
			this.year = year;
		}
	}

	
	public Date(Date another){
		this.day = another.getDay();
		this.month = another.getMonth();
		this.year = another.getYear();
	}


	public int getDay(){
		
		return day;
	}
	
	
	public void setDay(int day) throws DateException{
		if ( day <= 0) {
			throw new dateException("Negative days are not allowed - wrong value for day: " + day);			
		} else {
			if ( !this.isDayRight(day) ){
				throw new dateException("Day/Month wrong combination: " + day + "/" + this.month);
			} else {
				this.day = day;
			}
		}
	}


	public int getMonth() {

		return month;
	}

	public void setMonth(int month) throws dateException{

		if (month <= 0) {

			throw new dateException("Negative months are not allowed - wrong value for month: " + month + "\n");			
		} else {

			if (month > 12){

				throw new dateException("There are only 12 months - wrong value for month: " + month + "\n");
			} else {

				this.month = month;
			}
		}
	}


	public int getYear() {

		return year;
	}

	public void setYear(int year) throws dateException{

		if (year < 0) {

			throw new dateException("Negative years are not allowed - wrong value for year: " + year + "\n");			
		} else {

			this.year = year;
		}
	}


	public Date tomorrow(){

		Date tomorrow = null;
		int d, m, y;
				
		d = this.day;
		m = this.month;
		y = this.year;
		
		d++;
		if ( d > this.daysOfMonth(month) ) {
			d = 1;
			m++;
			if ( m > 12 ) {
				m = 1;
				y++;
			}	
		}
		
		try{
			tomorrow = new Date(d, m, y);
		} catch (DateException e){
			System.err.println("Date.tomorrow: " + e.getMessage());
		}

		return tomorrow;
	}


	public boolean isSameDay(Date other){
		
		if (this.day == other.getDay()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isSameMonth(Date other){
		
		if (this.month == other.getMonth()) {

			return true;
		}else{

			return false;
		}
	}

	public boolean isSameYear(Date other){
		
		return this.year == other.getYear();
	}

	
	boolean isSame(){

			return this.isSameDay(other) && this.isSameMonth(other) && this.isSameYear(other);
	}



	public String nameOfMonth(int month)
	{

		String nameMonth = null;

		switch(this.month)
		{
			case 1: nameMonth = "January";
				break;
			case 2: nameMonth = "February";
				break;
			case 3: nameMonth = "March";
				break;
			case 4: nameMonth = "April";
				break;
			case 5: nameMonth = "May";
				break;
			case 6: nameMonth = "June";
				break;
			case 7: nameMonth = "July";
				break;
			case 8: nameMonth = "August";
				break;
			case 9: nameMonth = "September";
				break;
			case 10: nameMonth = "October";
				break;
			case 11: nameMonth = "November";
				break;
			case 12: nameMonth = "December";
				break;
		}

		return name;

	}


	private boolean isDayRight(int day){

		return ((day > 0) && (day <= this.daysOfMonth(this.month)));
	}
	
	public int daysOfMonth(){

		return this.daysOfMonth(this.month);
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

		String season = null;

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


	public String getMonthsLeft(){

		Date aux = new Date(this);
		StringBuffer monthsLeft = new StringBuffer();
		
		try{
			for (int i = this.month + 1; i <= 12; i++){
				aux.setMonth(i);
				monthsLeft.append(aux.getMonthName() + " ");
			}
		} catch (DateException e){
			System.err.println("Date.getMonthsLeft: " + e.getMessage());
		}
		return monthsLeft.toString();
	}
	

	public String getDaysLeftOfMonth(){
		Date aux = tomorrow();
		StringBuffer daysLeft = new StringBuffer();
		
		try{
			for (int i = aux.getDay(); isDayRight(i); i++) {
				aux.setDay(i);
				daysLeft.append(aux.toString() + " ");
			}
		} catch (DateException e){
			System.err.println("Date.getDaysLeftOfMonth: " + e.getMessage());
		}
		return daysLeft.toString();
	}
	
	public String getMonthsSameDays(){

		Date aux = new Date(this);
		StringBuffer months = new StringBuffer();

		try{
			for (int i = 1; i <= 12; i++){
				aux.setMonth(i);
				if (aux.daysOfMonth() == this.daysOfMonth()){

					months.append(aux.getMonthName() + " ");
				}
			}
		}catch(DateException e){

			System.err.println("Date.getMonthsSameDays: " + e.getMessage());
		}
		return months.toString();
	}


	public int daysPast(){

		int result;
		result = 0;
		
		try{
			Date aux = new Date(1,1,this.year);
		
			for (int i = 1; i < this.month; i++){

				result += aux.daysOfMonth();
				aux.setMonth(i + 1);
			}
		} catch (DateException e){

			System.err.println("Date.daysPast: " + e.getMessage());
		}
		
		return result + this.day - 1;
	}


	public int numRandomTriesEqualDate(){
        int tries, d, m, y;
        tries = 0;
        
        try{
        	do{
        		m = (int) (Math.random()*12) + 1;
        		d = (int) (Math.random()*this.daysOfMonth(m) ) + 1;
        		y = this.year;
        		tries++;
        	} while ( !this.isSame(new Date(d,m,y) ) );
		} catch (DateException e){
			System.err.println("Date.numRandomTriesEqualsDate: " + e.getMessage());
		}

        return tries;
    	}

	
	private String nameOfDay(int day) {
		String dayName;
		switch (day) {
		case 1: 
			dayName = "Monday";
			break;
		case 2: 
			dayName = "Tuesday";
			break;
		case 3: 
			dayName = "Wednesday";
			break;
		case 4: 
			dayName = "Thursday";
			break;
		case 5: 
			dayName = "Friday";
			break;
		case 6: 
			dayName = "Saturday";
			break;
		case 7: 
			dayName = "Sunday";
			break;
		default:
			dayName = "Wrong day";
		}
		return dayName;
	}


	public String dayOfWeek(int firstOfJanuary){

		int dayNumber;
		
		dayNumber = (daysPast()%7 + firstOfJanuary)%7;
		
		return nameOfDay(dayNumber);
	}
	
	public String toString(){

		return this.day + "/" + this.month + "/" + this.year;
	}

}
