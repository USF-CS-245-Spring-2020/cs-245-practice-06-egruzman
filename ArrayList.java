/**
* Array List
* @author Eli Gruzman
* 
*/

import java.util.*;
import java.io.*;

public class ArrayList<T> implements List<T>
{
	protected T[] arr;
	protected int size;
	protected int cap;
	protected final int DEFAULT_CAPACITY = 10;
	
	public ArrayList()
	{
		cap = DEFAULT_CAPACITY;
		arr = (T[])new Object[cap];
		size = 0;
	}

	public void add(T item)
	{
		if (size >= arr.length)
			capacityIncrease();

		arr[size++] = item;
	}

	public void add(int pos, T item)
	{
		if (pos > size || pos < 0)
			throw new IndexOutOfBoundsException();

		if (pos == size)
		{
			add(item);
		}
		else
		{
	        if(size >= arr.length)
	            capacityIncrease();

	        for (int i = size; i > pos; i--)
	            arr[i] = arr[i-1];

	        arr[pos] = item;
	        size++;
    	}
	}

	@SuppressWarnings("unchecked")
	public T get(int pos)
	{
        if (pos > size || pos < 0)
            throw new IndexOutOfBoundsException();
        else
        	return arr[pos];
	}

	@SuppressWarnings("unchecked")
	public T remove(int pos)
	{
		T t = arr[pos];

	    if (pos > size || pos < 0)
	    	throw new RuntimeException("Invalid index");

        else
        {
            arr[pos] = null;
            int temp = pos;
            while(temp < size-1)
            {
                arr[temp] = arr[temp+1];
                arr[temp+1] = null;
                temp++;
        	}
        }
	    size--;
	    return t;
	}

	@SuppressWarnings("unchecked")
	public int size()
	{
		return size;
	}

	public void capacityIncrease()
	{
        arr = Arrays.copyOf(arr, arr.length*2);
	}
}