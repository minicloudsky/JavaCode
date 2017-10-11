//字符串
class StringDemo
{
	public static void main(String[] args)
	{
		String s = "abcde";
		String p = new String("abcde");
		String t = "abcde";
		System.out.println(s==t);
		System.out.println("p==t"+p==t);
		System.out.println("s.equals(p)"+s.equals(p));
		System.out.println("s.equals(t)"+s.equals(t));
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("d",5));
		System.out.println("length of s"+s.length());
		System.out.println(s.lastIndexOf("a"));

	}
}