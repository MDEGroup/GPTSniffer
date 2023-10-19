package ch_10.exercise10_01;


//_________________________UML DIAGRAM______________________________*
/*																	|
 * 							  Time  								|
 *-------------------------------------------------------------------|
 * 	-hour : long		(defaults are current time)					|
 * 															 		|
 *   -minute : long													|
 * 																	|
 * 	-second : long													|
 * 																	|
 * 	-theTime: long													|
 * 																	|
 *-------------------------------------------------------------------|
 * 	 -Time(): (System.currentTime.Millis()) 						|
 * 	 																|
 * 	 -Time(long):   												|
 * 																	|
 * 	 -Time(hour:long,min:long,second:long)							|
 * 																	|
 * 	+setTime():void													|
 *  																	|
 * 	+getHour() : long												|
 * 																	|
 * 	+getSec() : long												|
 * 																	|
 * 	+getMin() : long												|
 * 	 																|
 * 																	|
 *___________________________________________________________________|  */


public class Time {

    private long hour;
    private long min;
    private long second;

    public Time() {

        long theTime = System.currentTimeMillis();

        this.setTime(theTime);
    }

    public Time(long newTime) {

        this.setTime(newTime);

    }

    public Time(long newHour, long newMin, long newSec) {

        second = newSec;

        min = newMin;

        hour = newHour;

    }

    public void setTime(long elapsedTime) {

        hour = (((elapsedTime / 1000) / 60) / 60) % 24;

        second = (elapsedTime / 1000) % 60;

        min = ((elapsedTime / 1000) / 60) % 60;


    }

    public long getHour() {

        return hour;

    }

    public long getMin() {

        return min;
    }

    public long getSec() {

        return second;
    }


}
