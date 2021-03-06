package assign4;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * This class uses formulas to compare and display the empirically observed
 * running time of a method/algorithm to the expected Big-O behavior.
 * 
 * Let T(N) be the running time observed, and let F(N) be the Big-O expected.
 * 
 * If T(N) / F(N) converges to a positive value, then F(N) correctly represents
 * the growth rate of the running times.
 * 
 * If T(N) / F(N) converges to 0, then F(N) is an overestimate of the growth
 * rate of the running times.
 * 
 * If T(N) / F(N) converges to infinity, then F(N) is an underestimate of the
 * growth rate of the running times.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @author Erin Parker
 * @version 9/24/2015
 */
public class TimingAnalysis
{

	public static void main(String[] args)
	{
		// Run timing analysis on areAnagrams(String s1, String s2)
		timeAreAnagrams();

		// Run timing analysis on getLargestAnagramGroup
		timeGetLargestAnagramGroup();

		// Run timing analysis on getLargestAnagramGroupUsingSortMethod
		timeGetLargestAnagramGroupUsingSortMethod();
	}

	/**
	 * Runs a timing analysis on the areAnagrams method with an increasing
	 * problem size
	 */
	private static void timeAreAnagrams()
	{
		long startTime, midptTime, stopTime;
		long timesToLoop = 100;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println(
				"--------------------  Timing Analysis: areAnagrams(String s1, String s2)  ----------------------");
		System.out.println("\t\t\t    timesToLoop: " + timesToLoop + " | Should be O(N^2)");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int N = 1000; N <= 20000; N += 1000)
		{

			String wordList1 = generateString(N);
			String wordList2 = generateString(N);

			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// time the routine areAnagrams
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++)
			{
				AnagramUtil.areAnagrams(wordList1, wordList2);
			}
			midptTime = System.nanoTime();

			// time the empty loops
			for (int i = 0; i < timesToLoop; i++)
			{
			}

			stopTime = System.nanoTime();

			// compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t\t"
							+ formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N)) + "\t\t"
							+ formatter.format(avgTime / (N * N * N)));
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------");
	}

	/**
	 * Runs a timing analysis on the getLargestAnagramGroup method with an
	 * increasing problem size
	 * 
	 * The size of the array defines N for this method
	 */
	private static void timeGetLargestAnagramGroup()
	{
		long startTime, midptTime, stopTime;
		long timesToLoop = 5;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println(
				"--------------------  Timing Analysis: getLargestAnagramGroup(String[] s))  --------------------");
		System.out.println("\t\t\t\ttimesToLoop: " + timesToLoop + " | Should be O(N^2)");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int N = 1000; N <= 20000; N += 1000)
		{

			String[] wordList1 = generateStringArray(N);

			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// time the routine getLargestAnagramGroup
			startTime = System.nanoTime();
			for (long i = 0; i < timesToLoop; i++)
			{
				AnagramUtil.getLargestAnagramGroup(wordList1);
			}

			midptTime = System.nanoTime();

			// time the empty loop
			for (int i = 0; i < timesToLoop; i++)
			{
			}

			stopTime = System.nanoTime();

			// compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t\t"
							+ formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N)) + "\t\t"
							+ formatter.format(avgTime / (N * N * N)));
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------");
	}

	/**
	 * Runs a timing analysis on the getLargestAnagramGroup method with an
	 * increasing problem size
	 */
	private static void timeGetLargestAnagramGroupUsingSortMethod()
	{
		long startTime, midptTime, stopTime;
		long timesToLoop = 20;

		// try computing T(N)/F(N), see if it converges
		DecimalFormat formatter = new DecimalFormat("0000E0");

		System.out.println(
				"-----------  Timing Analysis: getLargestAnagramGroupUsingSortMethod(String[] s))  --------------");
		System.out.println("\t\t\t\t     timesToLoop: " + timesToLoop + " | Should be O(NlogN)");
		System.out.println("\nN\tT(N)  \t|\tT(N)/logN\tT(N)/NlogN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int N = 10000; N <= 200000; N += 10000)
		{

			String[] wordList1 = generateStringArray(N);

			System.out.print(N + "\t");

			// let things stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
				;

			// time the routine getLargestAnagramGroup
			startTime = System.nanoTime();
			for (long i = 0; i < timesToLoop; i++)
			{
				AnagramUtil.getLargestAnagramGroupUsingSortMethod(wordList1);
			}

			midptTime = System.nanoTime();

			// time the empty loop
			for (int i = 0; i < timesToLoop; i++)
			{
			}

			stopTime = System.nanoTime();

			// compute the average time
			double avgTime = ((midptTime - startTime) - (stopTime - midptTime)) / timesToLoop;

			System.out.println(
					formatter.format(avgTime) + "\t|\t" + formatter.format(avgTime / (Math.log10(N) / Math.log10(2)))
							+ "\t\t" + formatter.format(avgTime / (N * (Math.log10(N) / Math.log10(2)))) + "\t\t"
							+ formatter.format(avgTime / N) + "\t\t" + formatter.format(avgTime / (N * N)) + "\t\t"
							+ formatter.format(avgTime / (N * N * N)));
		}

		System.out.println(
				"------------------------------------------------------------------------------------------------");
	}

	/**
	 * Returns a string array of a specified size, filled with randomly
	 * generated strings ranging from 4 to 6 characters in length. Characters
	 * range from a to z
	 * 
	 * @param size
	 *            Number of words to generate and return in a string array
	 */
	private static String[] generateStringArray(int size)
	{

		String[] arr = new String[size];
		Random rn = new Random();
		int randNum;
		int randLength;
		char c;

		// Number of words to generate
		for (int i = 0; i < arr.length; i++)
		{
			// Initialize value at i to non-null
			arr[i] = "";

			// Length of word to generate
			randLength = rn.nextInt(6 - 4 + 1) + 4;
			for (int j = 0; j < randLength; j++)
			{
				randNum = (rn.nextInt(122 - 97 + 1) + 97);
				c = (char) randNum;
				arr[i] += c;
			}
		}

		return arr;
	}

	/**
	 * Returns a randomly generated string of a specified length. Characters
	 * range from a to z
	 * 
	 * @param length
	 *            The number of characters to generate and append to the return
	 *            string
	 */
	private static String generateString(int length)
	{

		String arr = "";
		Random rn = new Random();
		int randNum;
		char c;

		// Length of word to generate
		for (int i = 0; i < length; i++)
		{
			randNum = (rn.nextInt(122 - 97 + 1) + 97);
			c = (char) randNum;
			arr += c;
		}

		return arr;
	}
}
