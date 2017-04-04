package analyser;

/**
 * This class defines some methods which are
 * specific to byte arrays
 */
public class ByteMeth
{
	/**
	 * It checks the given byte arrays are equal or not
	 */
	public static boolean isEqual(byte[] b,byte[] c)
	{
		if(b.length != c.length)
			return false;
		for(int i=0;i<b.length;i++)
		{
			if(b[i]==c[i]);
			else
				return false;
		}
		return true;
	}

	/**
	 * It merges two byte arrays into one byte array
	 */
	public static byte[] addArray(byte b[],byte[] c)
	{
		byte a[]= new byte[b.length+c.length];

		System.arraycopy(b,0,a,0,b.length);
		System.arraycopy(c,0,a,b.length,c.length);

		return a;
	}

	//replace last r.len chars of b with r
	public static byte[] replace(byte b[],byte[] r,int c)
	{
		byte a[]= new byte[b.length-c+r.length];

		System.arraycopy(b,0,a,0,b.length-c);
		System.arraycopy(r,0,a,b.length-c,r.length);

		return a;
	}

	/** This function adds two arrays using sandhi rules*/
	public static byte[] addArrayRules(byte b[],byte[] c)
	{
		byte[] a=null;
		if(b.length==1 && b[0]==0)
			a=c;
		else if(c.length==1 && c[0]==0)
			a=b;

		//if first "u" next "a" "A" "i" "ii" "u" "uu" "i" "ee" "ai" "O" "O" "aw"
		else if((b[b.length-1]==5) && (c[0]>0 && c[0]<13))  //rule 1 first endsWith u and second starts with i or u removedPart the first u
		{
			a= new byte[b.length+c.length-1];

			System.arraycopy(b,0,a,0,b.length-1);
			System.arraycopy(c,0,a,b.length-1,c.length);

		}
		else if(((b[b.length-1]==1)||(b[b.length-1]==2)||(b[b.length-1]==6)||(b[b.length-1]==7)||(b[b.length-1]==10)||(b[b.length-1]==12)) && ((c[0]>0 && c[0]<13)))
		{
			a= new byte[b.length+c.length+1];

			System.arraycopy(b,0,a,0,b.length);
			a[b.length]=27;//v
			System.arraycopy(c,0,a,b.length+1,c.length);

		}
		else if(((b[b.length-1]==3)||(b[b.length-1]==4)||(b[b.length-1]==9)||(b[b.length-1]==11)||(b[b.length-1]==24)) && (c[0]>0 && c[0]<13))
		{
			a= new byte[b.length+c.length+1];

			System.arraycopy(b,0,a,0,b.length);
			a[b.length]=24;
			System.arraycopy(c,0,a,b.length+1,c.length);
		}
		else if( ((b[b.length-1]==19) || (b[b.length-1]==26)) && (c[0]==1 || c[0]==3))
		{
			a=new byte[b.length+1+c.length];

			System.arraycopy(b,0,a,0,b.length);
			a[b.length]=b[b.length-1];
			System.arraycopy(c,0,a,b.length+1,c.length);
		}
		else if(  (b[b.length-1]>0 && b[b.length-1]<13)  && ((c[0]==14)||(c[0]==16)||(c[0]==20)||(c[0]==22)) && (c[1]>0 && c[1]<13))
		{
			a= new byte[b.length+c.length+1];
			System.arraycopy(b,0,a,0,b.length);
			a[b.length] = c[0];
			System.arraycopy(c,0,a,b.length+1,c.length);
		}
		else
		{
			a = addArray(b,c);
		}

		return a;
	}
	/**
	 * It returns the subArray of the given array
	 * using the starting and ending positions of
	 * the required array
	 */
	public static byte[] subArray(byte[] b,int c,int d)
	{
		byte[] a=new byte[d-c];

		for(int i=c;i<d;i++)
		{
			a[i-c]=b[i];
		}

		return a;
	}

	/**
	 * It checks the first given  array is starting
	 * with the the second or not
	 */
	public static boolean startsWith(byte[] b,byte[] c)
	{
		int len1=0,len2=0;
		if(b.length>c.length)
		{
			len1=b.length;
			len2=c.length;
		}
		else
		{
			len1=c.length;
			len2=b.length;
		}
		for(int i=0;i<len2;i++)
			if(b[i]==c[i])
				;
			else
				return false;
		return true;
	}

	/**
	 * It checks the first given  array is ending
	 * with the the second or not
	 */
	public static boolean endsWith(byte[] b,byte[] c)
	{
		int len1=0,len2=0;
		if(b.length<=c.length)
			return false;
		if(b.length>c.length)
		{
			len1=b.length;
			len2=c.length;
		}
		else
		{
			len1=c.length;
			len2=b.length;
		}
		for(int i=len1-1,j=len2-1;j!=-1 && i!=-1;j--,i--)
			if(b[i]==c[j])
				;
			else
				return false;
		return true;
	}

	public static boolean contains(byte[] b,byte[] c)
	{
		int len1=0,len2=0;
		if(b.length<c.length)
			return false;
		if(b.length>=c.length)
		{
			len1=b.length;
			len2=c.length;
		}
		else
		{
			len1=c.length;
			len2=b.length;
		}
		for(int i=len1-1,j=len2-1;j!=-1 && i!=-1;j--,i--)
			if(b[i]==c[j])
				;
			else
				return false;
		return true;
	}

	public static boolean before_endswith(byte[] b,byte[] c,byte[] d)
	{
		if(endsWith(b,addArray(c,d)))
			return true;
		else
			return false;
	}
}
