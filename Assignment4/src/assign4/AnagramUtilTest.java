package assign4;

import static org.junit.Assert.*;

import static assign4.AnagramUtil.*;

import org.junit.Test;

public class AnagramUtilTest
{

	@Test
	public void testSort()
	{
		assertEquals("abcd", sort("dcba"));
		assertEquals("abcdefg", sort("abcdefg"));
		assertEquals("abcdefg", sort("gfedcba"));
		assertEquals("abcdefg", sort("AbCdeFg"));
		assertEquals("aaaaaaabbbbbbb", sort("AbAbAbAbaBaBaB"));
		assertEquals("abcdefghijklmnopqrstuvwxyz", sort("cwmfjordbankglyphsvextquiz"));

	}

	@Test
	public void testAreAnagrams()
	{
		assertTrue(areAnagrams("actors", "costar"));
		assertTrue(areAnagrams("acre", "care"));
		assertFalse(areAnagrams("book", "california"));
//		assertFalse(areAnagrams("a", "c"));
//		assertFalse(areAnagrams("1", "2"));
	}

	@Test
	public void testInsertionSort()
	{
		//List of 9 not angagrams
		String[] noAnagrams = new String[9];
		noAnagrams[0] = "there";
		noAnagrams[1] = "are";
		noAnagrams[2] = "absolutely";
		noAnagrams[3] = "no";
		noAnagrams[4] = "anagrams";
		noAnagrams[5] = "here";
		noAnagrams[6] = "not";
		noAnagrams[7] = "even";
		noAnagrams[8] = "close";
		insertionSort(noAnagrams, new StringComparator());
		
		int indexNA = 1;
		assertFalse(areAnagrams(noAnagrams[indexNA], noAnagrams[indexNA-1]));
		assertFalse(areAnagrams(noAnagrams[indexNA], noAnagrams[indexNA+1]));	
		indexNA += 3;
		assertFalse(areAnagrams(noAnagrams[indexNA], noAnagrams[indexNA-1]));
		assertFalse(areAnagrams(noAnagrams[indexNA], noAnagrams[indexNA+1]));
		indexNA+=3;
		assertFalse(areAnagrams(noAnagrams[indexNA], noAnagrams[indexNA-1]));
		assertFalse(areAnagrams(noAnagrams[indexNA], noAnagrams[indexNA+1]));
		
		//List of 9 anagrams
		String[] s = new String[9];
		s[0] = "marines";
		s[1] = "trap";
		s[2] = "now";
		s[3] = "own";
		s[4] = "won";
		s[5] = "seminar";
		s[6] = "part";
		s[7] = "remains";
		s[8] = "rapt";
		insertionSort(s, new StringComparator());
		
		int index = 1;
		assertTrue(areAnagrams(s[index], s[index-1]));
		assertTrue(areAnagrams(s[index], s[index+1]));	
		index += 3;
		assertTrue(areAnagrams(s[index], s[index-1]));
		assertTrue(areAnagrams(s[index], s[index+1]));
		index+=3;
		assertTrue(areAnagrams(s[index], s[index-1]));
		assertTrue(areAnagrams(s[index], s[index+1]));
	}

	@Test
	public void testGetLargestAnagramGroupArray()
	{
		String[] empty = {};
		assertNull(getLargestAnagramGroup(empty));

		String[] noAnagrams = new String[5];
		noAnagrams[0] = "there";
		noAnagrams[1] = "are";
		noAnagrams[2] = "no";
		noAnagrams[3] = "anagrams";
		noAnagrams[4] = "here";
		String[] noAnagrams2 = getLargestAnagramGroup(noAnagrams);
		assertEquals(0, noAnagrams2.length);
		
		String[] s = new String[11];
		s[0] = "ideals";
		s[1] = "kale";
		s[2] = "rail";
		s[3] = "lair";
		s[4] = "inks";
		s[5] = "lake";
		s[6] = "ladies";
		s[7] = "liar";
		s[8] = "sink";
		s[9] = "skin";
		s[10] = "niks";
		String[] s2 = getLargestAnagramGroup(s);
		assertEquals("inks", s2[0]);
		assertEquals("sink", s2[1]);
		assertEquals("skin", s2[2]);
		assertEquals("niks", s2[3]);
		assertEquals(4, s2.length);
	}

	@Test
	public void testGetLargestAnagramGroupFilename()
	{
		String[] s = getLargestAnagramGroup("sample_word_list.txt");
		// for(int i = 0; i < s.length; i++)
		// {
		// System.out.println(s[i]);
		// }
	}
}
