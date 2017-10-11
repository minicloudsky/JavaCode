//
class StringTest3
{
	public static String getMaxSubString(String s1,String s2)
	{
		String max = "",min = "";
		max = (s1.length()>s2.length()) ? s1:s2;
		min = (max==s1) ? s2:s1;
		for(int x=0;x<s2.length();x++)
		{
			for(int y=0,z = s2.length()-x;z!=s2.length()+1;y++,z++)
			{
				String temp = s2.substring(y,z);
				sop(temp);
			}
		}
		return "";
	}
	public static void main(String[] args)
	{
		String s1 = "abcwerthellloyuiodef";
		String s2 = "cvhellobnm";
		sop(getMaxSubString(s2,s1));
	}
	public static void sop(String str)
	{
		System.out.println(str);
	}
}