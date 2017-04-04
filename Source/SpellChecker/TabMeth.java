package SpellChecker;
// In this file Converter will return array of byte i.e byte[

import java.io.*;
import java.util.*;
class TabMeth
	{
public String revert( byte b[] )
  {
  	  short tab =0;
  	  short temp =0;
  	  short prefix =0;

  	  boolean puttemp = false;
        boolean tamil = false;
        boolean zero = false;
        boolean putprefix = false;

  	  int i=0;
  	  ArrayList al= new ArrayList();

  	 if( b[0] == 0)
  	   {
  	     zero = true;
   	     i++;
  	   }
  	 else
  	   zero = false;
       for(  ; i<b.length; i++)
  	   {
           if(zero)
  	   	// Nontamil
  	   	   tab = (short)b[i];
  	     else
  	   	 {  // Tamil
  	   	   if(  ( b[i] <= 12) && ( b[i] >=1 )  )
  	   	     {
   	    	      tab =(short)( b[i]+219 ) ;
 	   	      }
  	   	   else if( b[i] == 13)
  	   	      {
  	   	    	  tab =(short)( b[i]+218 ) ;
  	   	      }
  	   	   else if((b[i] >= 14)  &&  (b[i] <= 36)  )
  	   	    	{	 //else if
  	   	    	   if( i+1<b.length )
  	   	    	     {  //inner if
  	   	    	         switch( b[i+1] )
  	   	    	    	    {
  	   	    	    	     case 1:
  	   	    	                   tab = (short)(b[i]+218 ) ;
			                   i++;
			                   break;
				     case 2:
				             tab = (short)( b[i]+218 ) ;
  	   	    	    	  	       temp =(short) 163;
  	   	    	    	     	       puttemp = true;
  	   	    	    	     	       i++;
  	   	    	    	     	       break;
 	    	     	    	     case 3:
						if(b[i] == 18)
						 {  tab =(short)174;
                                    //System.out.println("saravanan   ; "+tab);

						 }
						else
						{
    	     	    	      	       tab = (short)( b[i]+218 ) ;
                                     temp =(short) 164;
  	   	    	    	             puttemp = true;
						}
  	   	    	    	             i++;
  	   	    	                   break;
                             case 4:
						 tab = (short)( b[i]+218 ) ;
  	   	    	    	     	       temp =(short) 166;
  	   	    	    	     	       puttemp = true;
  	   	    	    	     	       i++;
  	   	    	    	     	       break;

                             case 5:
                                     if( (b[i] >= 14)  &&  (b[i] <= 20)  )
  	   	    	    	     	           {
  	   	    	    	     	              tab = (short)( b[i]+162 ) ;
  	   	    	    	     	    	        i++;
  	   	    	    	     	    	      }
 						 else if( (b[i] >= 21)  &&  (b[i] <= 31)  )
  	   	    	    	     	    	      {
  	   	    	    	     	    	         tab = (short)( b[i]+163 ) ;
  	   	    	    	     	    	         i++;
  	   	    	    	     	    	      }
  	   	    	    	     	    	 else if(  (b[i] >= 32)  &&  (b[i] <= 36)  )
  	   	    	    	     	    	      {
  	   	    	    	     	    	          tab = (short)( b[i]+218 ) ;
        	   	    	    	     	          temp =(short) 167;
  	       	    	    	     	          puttemp = true;
  	   	         	    	     	          i++;
  	   	    	    	     	    	       }
  	   	    	    	     	    	  break;
  	   	    	    	     	  case 6:
  	   	    	    	     	        if( (b[i] >= 14)  &&  (b[i] <= 20)  )
  	   	    	    	     	          {
  	   	    	    	     	              tab = (short)( b[i]+181 ) ;
  	   	    	    	     	    	        i++;
  	   	    	    	     	           }
  	   	    	    	     	        else if( (b[i] >= 21)  &&  (b[i] <= 25)  )
  	   	    	    	     	           {
  	   	    	    	     	               tab = (short)( b[i]+182 ) ;
  	   	    	    	     	    	         i++;
  	   	    	    	     	    	      }
  	   	    	    	     	    	  else if( (b[i] >= 26)  &&  (b[i] <= 31)  )
  	   	    	    	     	    	      {
  	   	    	    	     	    	         tab = (short)( b[i]+188 ) ;
  	   	    	    	     	    	         i++;
  	   	    	    	     	    	       }
  	   	    	    	     	    	  else if( (b[i] >= 32)  &&  (b[i] <= 36)  )
  	   	    	    	     	    	       {
  	   	    	    	     	    	          tab = (short)( b[i]+218 ) ;
  	   	    	    	     	    	          temp = (short) 168;
  	   	    	    	     	    	          puttemp = true;
  	   	    	    	     	    	          i++;
  	   	    	    	     	    	       }
  	   	    	    	     	    	   break;
  	   	    	    	     	    case 7 :
  	   	    	    	     	                 prefix = (short) 170;
  	   	    	    	     	    	           tab = (short)( b[i]+218 ) ;
  	   	    	    	     	    	           putprefix = true;
  	   	    	    	     	    	           i++;
  	   	    	    	     	    	           break;

  	   	    	    	     	    case 8 :
  	   	    	    	     	                 prefix = (short) 171; // 34 has to be 171 .This is due to softview problem
  	   	    	    	     	    	           tab = (short)( b[i]+218 ) ;
  	   	    	    	     	    	           putprefix = true;
  	   	    	    	     	    	           i++;
  	   	    	    	     	    	           break;
	                            case 9 :
                                               prefix = (short) 172;
  	   	    	    	     	    	           tab = (short)( b[i]+218 ) ;
  	   	    	    	     	    	           putprefix = true;
  	   	    	    	     	    	           i++;
  	   	    	    	     	    	           break;
                                   case 10 :
                                               prefix = (short) 170;
  	   	    	    	     	    	           tab = (short)( b[i]+218 ) ;
  	   	    	    	     	    	           temp = (short) 163;
  	   	    	    	     	    	           putprefix = true;
  	   	    	    	     	    	           puttemp= true;
  	   	    	    	     	    	           i++;
  	   	    	    	     	    	           break;
	   	    	    	     	     case 11 :
                                                prefix = (short) 171; // 34 has to be 171.This is due to softview 171-34 problem
  	   	    	    	     	    	            tab = (short)( b[i]+218 ) ;
  	   	    	    	     	    	            temp = (short) 163;
  	   	    	    	     	    	            putprefix = true;
  	   	    	    	     	    	            puttemp= true;
  	   	    	    	     	    	            i++;
  	   	    	    	     	    	            break;
  	   	    	    	     	    case 12 :
                                                prefix = (short) 170;
  	   	    	    	     	    	            tab = (short)( b[i]+218 ) ;
  	   	    	    	     	    	            temp = (short) 247;
  	   	    	    	     	    	            putprefix = true;
  	   	    	    	     	    	            puttemp= true;
  	   	    	    	     	    	            i++;
  	   	    	    	     	    	            break;
 	    	    	     	    	      default :
    	    	    	     	    	      	       tab = (short)( b[i]+218 ) ;
           	   	    	    	        	  	 temp = (short) 162;
    	    	                 	        	  	 puttemp=true;
   	    	                 	        	  	 break;
             	    	     	    }// end of switch
  	      	    	     }  // end inner if
  	     	    	     else
  	                   {
  	      	    	  tab = (short)( b[i]+218 ) ;
  	   	    	   	  temp = (short) 162;
  	   	    	   	  puttemp=true;
  	   	    	        }
  	   	    	    } //end else if
  	   	    	 else if(b[i] == 37)
  	   	    	     tab= (short) 255;
  	   	    }// end of tamil
             if(putprefix)
  	   	   {
  	   	    al.add(new Character( (char) prefix) );
  	   	    putprefix = false;
  	   	   }
	      al.add(new Character((char)tab) );
  	      if(puttemp)
  	   	   {
  	    	    al.add(new Character( (char) temp ) );
  	    	    puttemp = false;
  	   	   }
  	      if( (i+1<b.length) && (b[i+1] == 0) )
  	        {
  	   	     i++;
  	           if(zero)
  	   	       {
  	   		   zero = false;
  	   		   continue;
  	   	    	 }
  	   	     else
  	   	       {
  	   		    zero = true;
  	   		    continue;
  	   	    	 }

  	   	    }
	       }// end of for
  	   String ret = new String();
  	   for(int j=0; j<al.size();j++)
	       ret = ret+( (Character)(al.get(j)) ).charValue() ;
         return ret;
    }	 //end of revert


public byte[] convert(String p)
  {
     byte mycode = 0;
     byte temp=0;
     boolean puttemp= false;
     boolean tamil = false;
     boolean zero = false;
     ArrayList al = new ArrayList();

   if(p.length()==0)
    {
        byte rettemp[]={0};
        return rettemp;
     }

   for(int i=0 ; i<p.length() ; i++ )
     {
       if(  ( p.charAt(i) <=127 )  && ( p.charAt(i) >=0 )  )
         tamil = false;
       else if( p.charAt(i) >= 128)
         tamil = true;
     	 if( p.charAt(i) == 34)  // This condition is only for Softview due to that 171-34 interchange problem.
     	    tamil = true;
     	 if( (!tamil) && (!zero) )
     	   {
     	   	 al.add( new Byte( (byte) 0 ) );
     	     	 zero = true;
     	   }
     	 else if( (tamil) && (zero) )
     	   {
     	      al.add( new Byte( (byte) 0 ) );
     	      zero = false;
     	   }
     	if(!tamil)
     	  {
     	    mycode = ( byte ) p.charAt(i);
     	    al.add( new Byte( mycode) );
    	    continue ;
     	  }
     	else if(tamil)
     	  {	// 123
          if(  ( p.charAt(i)>= 220 )  &&  (  p.charAt(i)<=  231 ) )
     	      {
     	        if( (  p.charAt(i) ==   229 ) && ( i+1<p.length() )  &&  (  p.charAt(i+1) ==   247 ) )
     	          {
          	       mycode =   12;
            	 i++;
     	          }
    	        else if( p.charAt(i) == 231 )
     	          {
     	          	mycode =  13;
     	          }
              else
     	          {
                 	mycode =  (byte)(p.charAt(i) - 219);
     	          }
            }
	   else if(  (  p.charAt(i)>=  176 )  &&  (  p.charAt(i)<=  182 ) )
     	   	{
              mycode =  (byte)(p.charAt(i) - 162);
		  temp = 5;
		  puttemp = true;
     	      }
	   else if(  (  p.charAt(i)>=  184 )  &&  (  p.charAt(i)<=  194 ) )
     	   	{
	        mycode =  (byte)(p.charAt(i) - 163);
		  temp =  5;
		  puttemp = true;
     	      }
        else if(  (  p.charAt(i)>=  195 )  &&  (  p.charAt(i)<=  201 ) )
     	  	{
     	         mycode =  (byte)(p.charAt(i) - 181);
		   temp =   6;
		   puttemp = true;
     	      }
	  else if(  (  p.charAt(i)>=  203 )  &&  (  p.charAt(i)<=  207 ) )
     	    {
     	      mycode =  (byte)(p.charAt(i) - 182);
		temp =   6;
		puttemp = true;
     	    }
       else if(  (  p.charAt(i)>=  214 )  &&  (  p.charAt(i)<=  218 ) )
     	   {
           mycode =  (byte)(p.charAt(i) - 188);
	     temp =   6;
	     puttemp = true;
     	   }
	else if(  (  p.charAt(i)>=  232 )  &&  (  p.charAt(i)<=  254 ) )
     	  {
     	    if( i+1<p.length() )
     	      {
             switch(  p.charAt(i+1) )
     	         {
     	          case 162:
     	       	        mycode =  (byte)(p.charAt(i) - 218);
     	       	        i++;
     	       	        break;
     	          case 163:
     	       	        mycode =  (byte)(p.charAt(i) - 218);
     	       	        i++;
     	       	        temp =   2;
     	       	        puttemp = true;
     	       	        break;
          	    case 164:
     	       	        mycode =  (byte)(p.charAt(i) - 218);
     	       	        i++;
     	       	        temp =   3;
     	       	        puttemp = true;
     	       	        break;
	         case 166:
     	                    mycode =  (byte)(p.charAt(i) - 218);
		     	        i++;
     	       	        temp =   4;
     	       	        puttemp = true;
     	       	        break;
     	        case 167:
     	                    mycode =  (byte)(p.charAt(i) - 218);
		     	        i++;
     	       	        temp =  5 ;
     	       	        puttemp = true;
     	       	        break;
     	        case 168:
     	                    mycode =  (byte)(p.charAt(i) - 218);
		     	        i++;
     	       	        temp =  6 ;
     	       	        puttemp = true;
     	       	        break;
             default :
     	                    mycode =  (byte)(p.charAt(i) - 218);
     	       	        temp =   1;
     	       	        puttemp = true;
     	       	        break;
		} // end of switch
     	    }
     	  else
     	    {
     	      mycode =  (byte)(p.charAt(i) - 218);
            temp =   1;
            puttemp = true;
     	    }
       }
     else if(  p.charAt(i) == 172)
       {
     	   mycode = (byte)( p.charAt(i+1) - 218);
    	   i++;
    	   temp =   9 ;
    	   puttemp = true;
     	}
    else if(  p.charAt(i) == 170)
    	{
        if( i+2<p.length() )
     	    switch(  p.charAt(i+2) )
     	    	{
     	       case 163 :
     	                  mycode =  (byte)(p.charAt(i+1) - 218);
     	       		temp =   10 ;
     	       		puttemp = true;
     	       		i+=2;
     	       		break;
     	      case 247 :
     	             	mycode = (byte)(p.charAt(i+1) - 218 );
     	       	      temp =   12 ;
     	       	      puttemp = true;
     	       	      i+=2;
     	       	      break;
     	      default :
     	                  mycode =  (byte)(p.charAt(i+1) - 218 );
     	       	      temp =   7 ;
     	       	     	puttemp = true;
     	       	     	i++;
     	       	     	break;
     	     } // end of switch
     	  else
     	    {
     	       mycode =  (byte)(p.charAt(i+1) -218);
     	       temp =   7 ;
     	       puttemp = true;
     	       i++;
     	    }
     	 }
     else if(  p.charAt(i) == 171 )   // this 34 is wrong actualy it has to be 171 due to the mistake of alscrypt
     	 { if( (i+2<p.length()) &&  (  p.charAt(i+2) == 163) )
     	     {
            System.out.println("lskdf");
     	     	mycode =  (byte)(p.charAt(i+1) - 218);
    	     	temp =   11 ;
    	     	puttemp = true;
    	     	i+=2;
     	     }
         else
	     {
    	       mycode =  (byte)(p.charAt(i+1) - 218 );
    	       temp =   8 ;
    	       puttemp = true;
    	       i++;
 	     }
      }
   else if(  p.charAt(i) == 174 )
     {
       mycode =   18;
     	 temp =   3 ;
     	 puttemp = true;
     }
   else if(  p.charAt(i) == 175 )
   	{
       mycode =   18;
     	 temp =   4 ;
     	 puttemp = true;
     	}
   else if(  p.charAt(i) == 255 )
       mycode = 37;
   }//123
   al.add( new Byte( mycode ) );
   if(puttemp)
    	{
        al.add( new Byte( temp ));
     	  puttemp = false;
     	}
  }
  byte ret[] = new byte[al.size()];
  for(int l=0; l<al.size() ;l++ )
    {
     	ret[l] =((Byte) al.get(l)).byteValue(); //(Byte)al.get(l);
    }
  return ret;
}
}
