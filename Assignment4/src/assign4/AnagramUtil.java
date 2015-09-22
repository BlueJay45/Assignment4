package assign4;

import static assign4.AnagramUtil.insertionSort;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Determines if two words are anagrams and finds the largest groups of anagrams
 * in a list of words. Two words are anagrams if they contain the same letters
 * in the same frequency.
 * 
 * @author Jay Mendez, jaym
 *
 */
public class AnagramUtil
{
	public static void main(String[] args)
	{
	}
	
	/**
	 * Returns the sorted version of the input string. Uses insertion sort.
	 * 
	 * @param word
	 * @return
	 */
	public static String sort(String s)
	{
		char[] sorted = s.toLowerCase().toCharArray();	
		for(int i = 1; i < sorted.length; i++)
		{
			char val = sorted[i];
			int j;
			
			for(j = i-1; j >= 0 && sorted[j] > val; j--)
			{
				sorted[j+1] = sorted[j];
			}
			sorted[j+1] = val;
		}
		return new String(sorted);
	}

	/**
	 * Sorts the input array using an insertion sort and the input Comparator
	 * object.
	 * 
	 * @param sort
	 * @param comp
	 */
	public static <T> void insertionSort(T[] sorted, Comparator<? super T> comp)
	{
		for(int i = 1; i < sorted.length; i++)
		{
			T val = sorted[i];
			int j;
			
			for(j = i-1; j >= 0 && comp.compare(sorted[j], val) > 0; j--)
			{
				sorted[j+1] = sorted[j];
			}
			sorted[j+1] = val;
		}
	}

	/**
	 * Returns true if the two input strings are anagrams of each other,
	 * otherwise returns false.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean areAnagrams(String s1, String s2)
	{
		if(sort(s1).equals(sort(s2)))
		{
			return true;
		}
		return false;
	}

	/**
	 * Returns the largest group of anagrams in the input array of words, in no
	 * particular order. Returns an empty array if there are no anagrams in the
	 * input array.
	 * 
	 * @param filename
	 * @return
	 */
	public static String[] getLargestAnagramGroup(String[] s)
	{
		if(s.length == 0)
		{
			return null;
		}
		
		insertionSort(s, new StringComparator());
		
		String mode = s[0];
		int current = 1;
		int highest = 1;
		
		for(int i = 1; i < s.length; i++)
		{
			if(areAnagrams(s[i-1], s[i]))
			{
				current++;
			}
			else
			{
				current = 1;
			}
			
			if(current >= highest)
			{
				mode = s[i];
				highest = current;
			}
		}
		
		ArrayList<String> largestAnagramGroup = new ArrayList<String>();
		for(int i = 0; i < s.length; i++)
		{
			if(areAnagrams(mode, s[i]))
			{
				largestAnagramGroup.add(s[i]);
			}
		}
		
		return largestAnagramGroup.toArray(new String[largestAnagramGroup.size()]);
	}

	/**
	 * Returns the largest group of anagrams in the input array of words from
	 * the input filename, in no particular order. Returns an empty array if
	 * there are no anagrams in the input array.
	 * 
	 * @param filename
	 * @return
	 */
	public static String[] getLargestAnagramGroup(String filename)
	{
		return null;
	}
}
