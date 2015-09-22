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
		assertFalse(areAnagrams("a", "c"));
		assertFalse(areAnagrams("1", "2"));
	}
	
	@Test
	public void testInsertionSort()
	{
		String[] s = {"ideals", "kale", "rail", "lair", "inks", "lake", "ladies", "liar", "sink", "skin", "niks" };
		s[3] = "lair";
		s[4] = "inks";
		s[5] = "lake";
		s[6] = "ladies";
		s[7] = "liar";
		s[8] = "sink";
		s[9] = "skin";
		s[10] = "niks";
		insertionSort(s, new StringComparator());
	}
	
	@Test
	public void testGetLargestAnagramGroup()
	{
		String[] empty = {};
		assertNull(getLargestAnagramGroup(empty));
		
		String[] noAnagrams = new String[5];
		noAnagrams[0] = "there";
		noAnagrams[1] = "are";
		noAnagrams[2] = "no";
		noAnagrams[3] = "anagrams";
		noAnagrams[3] = "here";
		assertNull(getLargestAnagramGroup(noAnagrams));
		
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
}
