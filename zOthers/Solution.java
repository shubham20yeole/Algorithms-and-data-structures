package zOthers;

class Solution {
	
	public static void main(String[] args) {
		System.out.println(removeKdigits("496789", 3));
	}
  
  public static int smallestDigit(String s,int k,int indx)
  {
      int i=0,min=Integer.MAX_VALUE,index=-22;
      for(i=indx;i<s.length()&&i<=indx+k;i++)
      {
          if((int)s.charAt(i)-48<min)
          {
              min=(int)s.charAt(i)-48;
              index=i;
          }   
      }
                                  //Sytem.out.println((int)s.charAt(index)-48+","+index);

      return index;
  }
  public static String removeKdigits(String num, int k) {
      StringBuffer sb=new StringBuffer(num);
      int len=num.length();
      int i,j,nl=len,indx=0;
      for(i=0;i<nl&&k>0;i++)
      {
          if(nl==k)
              return "0";
          indx=smallestDigit(new String(sb),k,i);
          if(nl-i==k)
              sb.delete(nl-k,nl);
          else
         sb.delete(i,indx);
          k=k-(indx-i);
          nl=sb.length();
         // System.out.println(num);
      }
      while(sb.length()>1&&sb.charAt(0)=='0')
      {
          sb.deleteCharAt(0);
      }
      return new String(sb);    
  }
}