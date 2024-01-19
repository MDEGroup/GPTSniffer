
package ch_10.exercise10_14;

import java.util.GregorianCalendar;

//_________________________UML DIAGRAM______________________________*
/*																	|
 * 			    		      MyDate         			    		|
 *------------------------------------------------------------------|
 *                     	   -day : int	                       		|
 *                         -month : int  							|
 * 							-year:int   					 		|
 *------------------------------------------------------------------|
 *                     +MyDate()            	    				|
 *                     +MyDate(int, int,int)          		    	|
 *                     +MyDate(long)                       	    	|
 * 	 																|
 * 	 			        setDate(long):void 							|
 * 						                                        	|
 * 	 			    	getters and setters 						|
 * 																	|
 *__________________________________________________________________|  */


public class MyDate {
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    private int year;
    private int month;
    private int day;

    public MyDate() {
        this(System.currentTimeMillis());
    }

    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public void setDate(long elapsedTime) {
        gregorianCalendar.setTimeInMillis(elapsedTime);
        this.year = gregorianCalendar.get(GregorianCalendar.YEAR);
        this.month = gregorianCalendar.get(GregorianCalendar.MONTH);
        this.day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public int getYear() {
        return year;
    }

    public MyDate setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public MyDate setMonth(int month) {
        this.month = month;
        return this;
    }

    public int getDay() {
        return day;
    }

    public MyDate setDay(int day) {
        this.day = day;
        return this;
    }
}
