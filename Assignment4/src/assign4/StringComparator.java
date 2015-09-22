package assign4;

import java.util.Comparator;

public class StringComparator implements Comparator<String>
{
	public int compare(String s1, String s2)
	{
		if(AnagramUtil.sort(s1).compareTo(s2) < 0)
		{
			return -1;
		} 
		else
		{
			return 1;
		}
	}
}
