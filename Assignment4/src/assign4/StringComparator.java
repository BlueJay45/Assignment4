package assign4;

import java.util.Comparator;

public class StringComparator implements Comparator<String>
{
	public int compare(String s1, String s2)
	{
		if (AnagramUtil.areAnagrams(s1, s2))
		{
			return -1;
		} 
		else
		{
			return 1;
		}
	}
}
