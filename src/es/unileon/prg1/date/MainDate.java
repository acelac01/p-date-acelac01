//Álvaro Celada Celada

package es.unileon.prg1.date;

public class MainDate
{
	public static void main(String args[])
	{
		Date today;
		today = new Date (22,3,2017);
		today.printMonthsSameAmountDate();
		today.getNumsDayMonth();	

		Date today;

		try{
			today = new Date(99, 13, 2017);
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	}
}



