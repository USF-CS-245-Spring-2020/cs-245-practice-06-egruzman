/**
* Linked List
* @author Eli Gruzman
* 
*/

import java.util.*;
import java.io.*;

public class LinkedList<T> implements List<T>
{
	protected Node<T> head;
	protected int size;

	public LinkedList()
	{
		size = 0;
	}

	public void add(T item)
	{
		Node<T> newNode = new Node<T>(item);

		if(head == null)
		{
			head = newNode;
			size++;
		}

		else
		{
			Node<T> current = head;
			while(current.next != null)
					current = current.next;
		
			current.next = newNode;
			size++;
		}
	}

	public void add(int pos, T item)
	{
    	Node<T> newNode = new Node(item);

		if (pos > size || pos < 0)
			throw new NoSuchElementException();

		if(pos == 0)
		{
			head = newNode;
			size++;
		}

    	else
    	{
    		Node<T> current = head;

    		while (--pos > 0)
				current = current.next;

    		newNode.next = current.next;
    		current.next = newNode;
    		size++;
    	}
    }

	public T get(int pos)
	{
		if (pos > size || pos < 0)
            throw new IndexOutOfBoundsException();

        Node<T> current = head;

        if (head == null)
        	throw new IndexOutOfBoundsException();
        else if (current == null)
        	throw new IndexOutOfBoundsException();

      	for (int i = 0; i < pos; i++)
      		current = current.next;

      	return current.item;
   	}

	public T remove(int pos)
	{
		Node<T> current = head;
    	Node<T> prev = null;
    	int skip = 0;

		if (pos > size || pos < 0)
			throw new NoSuchElementException();

		if (pos == 0)
			head = null;	

		else
		{
			while (skip <= pos-1)
			{
				prev = current;
				current = current.next; 
				skip++;
			}
		}
		if (prev != null)
			prev.next = current.next;
		size--;
		return current.item;
	}

	public int size()
	{
		return size;
	}

	private class Node<T>
	{
   		Node<T> next;
        T item;

        public Node(T item)
		{
			this.item = item;
			this.next = null;
		}
    }
}