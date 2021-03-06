package assign4;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * JUnit class that tests the functionality of the AnagrumUtil class.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @version 9/24/2015
 */
public class AnagramUtilTester {
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	  
	//////// sort(String s) ////////
	@Test
	public void testSortNullInput() {
		// Passing null to AnagramUtil.sort(String s) should throw an exception
		exception.expect(NullPointerException.class);
		AnagramUtil.sort(null);
	}
	
	@Test
	public void testSortNonAlphabetInput() {
		// Passing a string containing characters other than a to z and A to Z
		// to AnagramUtil.sort(String s) should throw an exception
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("ab%bc");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("ab bc");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("ab1bc");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort(" ");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("1234");
	}
	
	@Test
	public void testSortWithShortInput() {
		// Passing a string containing less than two characters
		// to AnagramUtil.sort(String s) should throw an exception
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("a");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("A");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sort("");
	}
	
	@Test
	public void testSortWithValidIdenticalInput() {
		assertEquals("abcd", AnagramUtil.sort("abcd"));
		assertEquals("abcd", AnagramUtil.sort("ABCD"));
	}
	
	@Test
	public void testSortWithValidReverseInput() {
		assertEquals("abcd", AnagramUtil.sort("dcba"));
		assertEquals("abcd", AnagramUtil.sort("DCBA"));
	}
	
	@Test
	public void testSortWithTwoCharIdenticalInput() {
		assertEquals("ab", AnagramUtil.sort("ab"));
		assertEquals("ab", AnagramUtil.sort("AB"));
	}
	
	@Test
	public void testSortWithTwoCharReverseInput() {
		assertEquals("ab", AnagramUtil.sort("ba"));
		assertEquals("ab", AnagramUtil.sort("BA"));
	}
	
	@Test
	public void testSortWithFullAlphabet() {
		assertEquals("abcdefghijklmnopqrstuvwxyz", AnagramUtil.sort("zyxwvutsrqponmlkjihgfedcba"));
		assertEquals("abcdefghijklmnopqrstuvwxyz", AnagramUtil.sort("ZYXWVUTSRQPONMLKJIHGFEDCBA"));
	}
	
	//////// sortUsingArraySortMethod(String s) ////////
	@Test
	public void testSortUsingArraySortMethodNullInput() {
		// Passing null to AnagramUtil.sort(String s) should throw an exception
		exception.expect(NullPointerException.class);
		AnagramUtil.sortUsingArraySortMethod(null);
	}
	
	@Test
	public void testSortUsingArraySortMethodNonAlphabetInput() {
		// Passing a string containing characters other than a to z and A to Z
		// to AnagramUtil.sort(String s) should throw an exception
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sortUsingArraySortMethod("ab%bc");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sortUsingArraySortMethod("ab bc");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sortUsingArraySortMethod("ab1bc");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sortUsingArraySortMethod(" ");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sortUsingArraySortMethod("1234");
	}
	
	@Test
	public void testSortUsingArraySortMethodWithShortInput() {
		// Passing a string containing less than two characters
		// to AnagramUtil.sort(String s) should throw an exception
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sortUsingArraySortMethod("a");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sortUsingArraySortMethod("A");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.sortUsingArraySortMethod("");
	}
	
	@Test
	public void testSortUsingArraySortMethodWithValidIdenticalInput() {
		assertEquals("abcd", AnagramUtil.sortUsingArraySortMethod("abcd"));
		assertEquals("abcd", AnagramUtil.sortUsingArraySortMethod("ABCD"));
	}
	
	@Test
	public void testSortUsingArraySortMethodWithValidReverseInput() {
		assertEquals("abcd", AnagramUtil.sortUsingArraySortMethod("dcba"));
		assertEquals("abcd", AnagramUtil.sortUsingArraySortMethod("DCBA"));
	}
	
	@Test
	public void testSortUsingArraySortMethodWithTwoCharIdenticalInput() {
		assertEquals("ab", AnagramUtil.sortUsingArraySortMethod("ab"));
		assertEquals("ab", AnagramUtil.sortUsingArraySortMethod("AB"));
	}
	
	@Test
	public void testSortUsingArraySortMethodWithTwoCharReverseInput() {
		assertEquals("ab", AnagramUtil.sortUsingArraySortMethod("ba"));
		assertEquals("ab", AnagramUtil.sortUsingArraySortMethod("BA"));
	}
	
	@Test
	public void testSortUsingArraySortMethodWithFullAlphabet() {
		assertEquals("abcdefghijklmnopqrstuvwxyz", AnagramUtil.sortUsingArraySortMethod("zyxwvutsrqponmlkjihgfedcba"));
		assertEquals("abcdefghijklmnopqrstuvwxyz", AnagramUtil.sortUsingArraySortMethod("ZYXWVUTSRQPONMLKJIHGFEDCBA"));
	}
	
	//////// areAnagrams(String s1, String s2) ////////
	@Test
	public void testAreAnagramsNullInput() {
		// Passing null to AnagramUtil.sort(String s) should throw an exception
		exception.expect(NullPointerException.class);
		AnagramUtil.areAnagrams(null, null);
	}
	
	@Test
	public void testAreAnagramsNonAlphabetInput() {
		// Passing a string containing characters other than a to z and A to Z
		// to AnagramUtil.sort(String s) should throw an exception
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("ab%bc", "cb%ba");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("ab bc", "cb ba");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("ab1bc", "cb1ba");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams(" ", " ");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("1234", "4321");
	}
	
	@Test
	public void testAreAnagramsWithShortInput() {
		// Passing a string containing less than two characters
		// to AnagramUtil.sort(String s) should throw an exception
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("a", "a");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("A", "A");
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.areAnagrams("", "");
	}
	
	//////// getLargestAnagramGroup(String[] s) ////////
	@Test
	public void testGetLargestAnagramGroupWithValidInput() {
		String[] list = {"abe", "bea", "eba", "ok", "ko"};
		String[] anagrams = {"abe", "bea", "eba"};
		
		assertArrayEquals(anagrams, AnagramUtil.getLargestAnagramGroup(list));
	}
	
	@Test
	public void testGetLargestAnagramGroupWithValidInputNoAnagrams() {
		String[] list = {"dog", "cat", "lemur", "cow", "llama"};
		String[] anagrams = new String[0];
		
		assertArrayEquals(anagrams, AnagramUtil.getLargestAnagramGroup(list));
	}
	
	@Test
	public void testGetLargestAnagramGroupWithNullInput() {
		String[] list = null;
		
		assertArrayEquals(new String[0], AnagramUtil.getLargestAnagramGroup(list));
	}
	
	@Test
	public void testGetLargestAnagramGroupWithInvalidInput() {
		String[] list = {"", "ih", "ok", "ko"};
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.getLargestAnagramGroup(list);
	}
	
	//////// getLargestAnagramGroup(String filename) ////////
	@Test
	public void testGetLargestAnagramGroupWithValidFileInput() {
		
		String[] anagrams = {"carets", "Caters", "caster", "crates", "Reacts", "recast", "traces"};
		
		assertArrayEquals(anagrams, AnagramUtil.getLargestAnagramGroup("sample_word_list.txt"));
	}
	
	@Test
	public void testGetLargestAnagramGroupWithEmptyFileInput() {

		// Returns an empty array if the file exists but is empty
		assertArrayEquals(new String[0], AnagramUtil.getLargestAnagramGroup("EmptyFile.txt"));
	}
	
	@Test
	public void testGetLargestAnagramGroupWithInvalidFileInput() {

		// Returns an empty array if the file is not found
		assertArrayEquals(new String[0], AnagramUtil.getLargestAnagramGroup("DoesNotExist.txt"));
	}
	
	////////getLargestAnagramGroupUsingSortMethod(String filename) ////////
	@Test
	public void testGetLargestAnagramGroupUsingSortMethodWithValidFileInput() {
	
		String[] anagrams = {"carets", "Caters", "caster", "crates", "Reacts", "recast", "traces"};
	
		assertArrayEquals(anagrams, AnagramUtil.getLargestAnagramGroupUsingSortMethod("sample_word_list.txt"));
	}
	
	@Test
	public void testGetLargestAnagramGroupUsingSortMethodWithEmptyFileInput() {

		// Returns an empty array if the file exists but is empty
		assertArrayEquals(new String[0], AnagramUtil.getLargestAnagramGroupUsingSortMethod("EmptyFile.txt"));
	}

	@Test
	public void testGetLargestAnagramGroupUsingSortMethodWithInvalidFileInput() {

		// Returns an empty array if the file is not found
		assertArrayEquals(new String[0], AnagramUtil.getLargestAnagramGroupUsingSortMethod("DoesNotExist.txt"));
	}
	
	//////// getLargestAnagramGroupUsingSort(String[] s) ////////
	@Test
	public void testGetLargestAnagramGroupUsingSortWithValidInput() {
		String[] list = {"abe", "bea", "eba", "ok", "ko"};
		String[] anagrams = {"abe", "bea", "eba"};
		
		assertArrayEquals(anagrams, AnagramUtil.getLargestAnagramGroupUsingSortMethod(list));
	}
	
	@Test
	public void testGetLargestAnagramGroupUsingSortWithValidInputNoAnagrams() {
		String[] list = {"dog", "cat", "lemur", "cow", "llama"};
		String[] anagrams = new String[0];
		
		assertArrayEquals(anagrams, AnagramUtil.getLargestAnagramGroupUsingSortMethod(list));
	}
	
	@Test
	public void testGetLargestAnagramGroupUsingSortWithNullInput() {
		String[] list = null;
		
		assertArrayEquals(new String[0], AnagramUtil.getLargestAnagramGroupUsingSortMethod(list));
	}
	
	@Test
	public void testGetLargestAnagramGroupUsingSortWithInvalidInput() {
		String[] list = {"", "ih", "ok", "ko"};
		
		exception.expect(IllegalArgumentException.class);
		AnagramUtil.getLargestAnagramGroupUsingSortMethod(list);
	}
	
	//////// StringComparator ////////
	@Test
	public void testInsertionSortWithInsertionSortComparatorWithStringType() {

		// Testing the insertion sort method using the StringComparator class
		String[] unsorted = {"carets", "Caller", "eat", "cellar", "recall", "Caters", "Ate", "caster", "aspired", 
				"allergy", "despair", "asp", "pas", "least", "sap", "spa", "diapers", "praised", "crates", "Reacts", 
				"bats", "tea", "Stab", "stale", "tabs", "recast", "darters", "Gallery", "retards", "starred", "code", 
				"Coed", "deco", "traders", "traces"};
		
		String[] sorted = {"bats", "Stab", "tabs", "Caller", "cellar", "recall", "carets", "Caters", "caster",
				"crates", "Reacts", "recast", "traces", "aspired", "despair", "diapers", "praised", "darters",
				"retards", "starred", "traders", "allergy", "Gallery", "least", "stale", "eat", "Ate", "tea",
				"asp", "pas", "sap", "spa", "code", "Coed", "deco"};
		
		AnagramUtil.insertionSort(unsorted, new StringComparator());
		
		assertArrayEquals(unsorted, sorted);
	}
	
	//////// ArraySortStringComparator() ////////
	@Test
	public void testInsertionSortWithArraySortWithStringType() {

		// Testing the insertion sort method using the ArraySortStringComparator
		String[] unsorted = {"carets", "Caller", "eat", "cellar", "recall", "Caters", "Ate", "caster", "aspired", 
				"allergy", "despair", "asp", "pas", "least", "sap", "spa", "diapers", "praised", "crates", "Reacts", 
				"bats", "tea", "Stab", "stale", "tabs", "recast", "darters", "Gallery", "retards", "starred", "code", 
				"Coed", "deco", "traders", "traces"};
		
		String[] sorted = {"bats", "Stab", "tabs", "Caller", "cellar", "recall", "carets", "Caters", "caster",
				"crates", "Reacts", "recast", "traces", "aspired", "despair", "diapers", "praised", "darters",
				"retards", "starred", "traders", "allergy", "Gallery", "least", "stale", "eat", "Ate", "tea",
				"asp", "pas", "sap", "spa", "code", "Coed", "deco"};
		
		AnagramUtil.insertionSort(unsorted, new ArraySortStringComparator());
		
		assertArrayEquals(unsorted, sorted);
	}
	
	//////// IntegerComparator() ////////
	@Test
	public void testInsertionSortWithIntegerType() {

		// Testing the insertion sort method using the IntegerComparator
		Integer[] unsorted = {4, 5, 2, 7, 3, 9, 8, 1, 6};
		Integer[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		AnagramUtil.insertionSort(unsorted, new IntegerComparator());
		
		assertArrayEquals(unsorted, sorted);
	}
}
