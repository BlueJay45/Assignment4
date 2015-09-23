package assign4;

import java.util.Comparator;

public class StringComparator implements Comparator<String>
{
	public int compare(String s1, String s2)
	{
		String a1 = AnagramUtil.sort(s1);
		String a2 = AnagramUtil.sort(s2);
		
		if (a1.compareToIgnoreCase(a2) > 0)
		{
			return 1;
		}
		else if (a1.compareToIgnoreCase(a2) < 0)
		{
			return -1;
		} 
		else
			return 0;
	}
	// public int compare(String s1, String s2)
	// {
	// if(AnagramUtil.sort(s1).compareTo(s2) < 0)
	// {
	// return -1;
	// }
	// else
	// {
	// return 1;
	// }
	// }
}
