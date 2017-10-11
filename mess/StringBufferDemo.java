class StringBufferDemo
{
	public static void main(String[] args)
	{
		StringBuffer sb = new StringBuffer("abcde");
		/*
		sb.append("dgf");
		sb.append("hello");
		sb.append("apple");
		sb.insert(0,"*****");
		System.out.println(sb.toString());
		System.out.println(sb.delete(0,6));
		System.out.println(sb.charAt(7));
		System.out.println(sb.toString());
		System.out.println("delete"+sb.delete(0,sb.length()));
		sb = new StringBuffer();
		System.out.println("sb"+sb.toString());
		*/
		char[] chs  = new char[4];
		sb.getChars(1,4,chs,1);
		for(int x=0; x<chs.length;x++)
		{
			System.out.println("chs["+x+"]="+chs[x]);
		}
	}
}