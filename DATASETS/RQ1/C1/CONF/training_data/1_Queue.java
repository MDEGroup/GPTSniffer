package ch_10.exercise10_10;

//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 							 Queue  								|
 *------------------------------------------------------------------|
 *                     -elements : int[]          					|
 *					   -size : int                                  |
 *                     +capacity:int								|
 *------------------------------------------------------------------|
 *          	     +Queue()										|
 * 	 																|
 * 	              +enqueue(int) : void				       			|
 * 																	|
 * 	              +dequeue():  void    					    		|
 * 	 																|
 * 	               +empty(): boolean								|
 *  																|
 * 	               getSize():int   									|
 * 																	|
 * _________________________________________________________________|  */

import java.util.Arrays;


public class Queue {
    int[] elements;
    int size;
    static final int DEFAULT_CAPACITY = 8;

    public Queue() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    void enqueue(int v) {
        if ((size + 1) > elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size] = v;
        size++;
    }

    int dequeue() {
        int res = -1;
        if (size > 0) {
            res = elements[0];
            for (int i = 1; i < size; i++) {
                elements[i - 1] = elements[i];
            }
            size--;
        }
        return res;
    }

    boolean empty() {
        return size == 0;
    }

    int getSize() {
        return size;
    }


}
