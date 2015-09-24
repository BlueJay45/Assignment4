package assign4;

import static assign4.AnagramUtil.getLargestAnagramGroup;
import static assign4.AnagramUtil.insertionSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

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
		if (s == null)
		{
			throw new NullPointerException();
		} else if (!s.matches("[a-zA-Z]+"))
		{
			throw new IllegalArgumentException("Input string contains non-alphabetized characters");
		} else if (s.length() < 2)
		{
			throw new IllegalArgumentException("Input string is too short(< 2 characters) to be considered an anagram");
		}

		char[] sorted = s.toLowerCase().toCharArray();
		for (int i = 1; i < sorted.length; i++)
		{
			char val = sorted[i];
			int j;

			for (j = i - 1; j >= 0 && sorted[j] > val; j--)
			{
				sorted[j + 1] = sorted[j];
			}
			sorted[j + 1] = val;
		}
		return new String(sorted);
	}

	/**
	 * Returns the sorted version of an input string using the
	 * Arrays.sort(char[] c) method
	 * 
	 * @param s
	 *            The string to be sorted
	 */
	public static String sortUsingArraySortMethod(String s)
	{
		// Check that the input string is valid
		if (s == null)
		{
			throw new NullPointerException();
		} else if (!s.matches("[a-zA-Z]+"))
		{
			throw new IllegalArgumentException("Input string contains non-alphabetized characters");
		} else if (s.length() < 2)
		{
			throw new IllegalArgumentException("Input string is too short(< 2 characters) to be considered an anagram");
		}

		// Impose that all strings are lower case, assume that anagrams are
		// case-insensitive
		s = s.toLowerCase();

		// Copy individual letters from input string into an char array
		char[] letters = s.toCharArray();

		// Sort the character array using Arrays.sort(char[] c)
		Arrays.sort(letters);

		// Return the character array reassembled as a single string
		return new String(letters);
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
		for (int i = 1; i < sorted.length; i++)
		{
			T val = sorted[i];
			int j;

			for (j = i - 1; j >= 0 && comp.compare(sorted[j], val) > 0; j--)
			{
				sorted[j + 1] = sorted[j];
			}
			sorted[j + 1] = val;
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
		if (sort(s1).equals(sort(s2)))
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
		if (s == null)
		{
			return new String[0];
		}

		insertionSort(s, new StringComparator());

		String mode = s[0];
		int current = 1;
		int highest = 1;

		for (int i = 1; i < s.length; i++)
		{
			if (areAnagrams(s[i - 1], s[i]))
			{
				current++;
			} else
			{
				current = 1;
			}

			if (current >= highest)
			{
				mode = s[i];
				highest = current;
			}
		}
		
		if(highest == 1)
		{
			return new String[0];
		}

		ArrayList<String> largestAnagramGroup = new ArrayList<String>();
		for (int i = 0; i < s.length; i++)
		{
			if (areAnagrams(mode, s[i]))
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
		ArrayList<String> words = new ArrayList<String>();

		try (Scanner input = new Scanner(new File(filename));)
		{
			if(!input.hasNext())
			{
				return new String[0];
			}
			while (input.hasNext())
			{
				words.add(input.nextLine());
			}

			String[] arr = words.toArray(new String[words.size()]);
			return getLargestAnagramGroup(arr);

		} catch (FileNotFoundException e)
		{
			return words.toArray(new String[words.size()]);
		}
	}

	/**
	 * Returns the largest group of anagrams of a list inside of a text file
	 * Returns an empty array if the file is empty or does not exist
	 * 
	 * It is assumed that the file contains one word per line. Utilizes
	 * getLargestAnagramGroup(String[] s)
	 * 
	 * @param filename
	 *            Name of text file containing a list of words
	 */
	public static String[] getLargestAnagramGroupUsingSortMethod(String filename)
	{
		ArrayList<String> words = new ArrayList<String>();

		try (Scanner input = new Scanner(new File(filename));)
		{
			if(!input.hasNext())
			{
				return new String[0];
			}
			while (input.hasNext())
			{
				words.add(input.nextLine());
			}

			String[] arr = words.toArray(new String[words.size()]);
			return getLargestAnagramGroupUsingSortMethod(arr);

		} catch (FileNotFoundException e)
		{
			return words.toArray(new String[words.size()]);
		}
	}

	/**
	 * Returns the largest group of anagrams in the input array of words, in no
	 * particular order. Returns an empty array if there are no anagrams in the
	 * input array.
	 * 
	 * If multiple groups of anagrams are of equal size, return the first group
	 * of anagrams.
	 * 
	 * Utilizes areAnagrams(String s1, String s2) and Arrays.sort() with the
	 * included custom StringComparator class
	 * 
	 * @param s
	 *            String array of words to be analyzed
	 */
	public static String[] getLargestAnagramGroupUsingSortMethod(String[] s)
	{
		if (s == null)
		{
			return new String[0];
		}

		Arrays.sort(s, new ArraySortStringComparator());

		String mode = s[0];
		int current = 1;
		int highest = 1;

		for (int i = 1; i < s.length; i++)
		{
			if (areAnagrams(s[i - 1], s[i]))
			{
				current++;
			} else
			{
				current = 1;
			}

			if (current >= highest)
			{
				mode = s[i];
				highest = current;
			}
		}
		
		if(highest == 1)
		{
			return new String[0];
		}

		ArrayList<String> largestAnagramGroup = new ArrayList<String>();
		for (int i = 0; i < s.length; i++)
		{
			if (areAnagrams(mode, s[i]))
			{
				largestAnagramGroup.add(s[i]);
			}
		}

		return largestAnagramGroup.toArray(new String[largestAnagramGroup.size()]);
	}
}
