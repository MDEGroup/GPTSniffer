


//_________________________UML DIAGRAM______________________________*
/*																	|
 * 						   StopWatch								|
 *------------------------------------------------------------------|
 * 	-startTime : long			                                   	|
 * 															 		|
 *  -endTime : long			    									|
 *------------------------------------------------------------------|
 * 	 +StopWatch():                          						|
 * 	 																|
 * 	  start():void	                                                |
 * 						    					    				|
 * 	  stop():void						    						|
 *  																|
 * 	+getEndTime() : long					    					|
 * 																	|
 * 	+getStartTime() : long				`   						|
 * 																	|
 * 	+getElapsedTime() : long										|
 *__________________________________________________________________|  */

public class StopWatch {

    /* ■ Private data fields startTime and endTime with getter methods. */
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    
    void start() {
        startTime = System.currentTimeMillis();
    }

    
    void stop() {
        endTime = System.currentTimeMillis();
    }

    
    public long getElapsedTime() {
        return (endTime - startTime);
    }


}
