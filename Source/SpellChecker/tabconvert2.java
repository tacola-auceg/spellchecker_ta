package SpellChecker;
// TAB CONVERTER

// In this file Converter will return array of byte i.e byte[]




import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class tabconvert2
	{

   public static void main(String s[])
   {
       try
       {

            BufferedReader in = new BufferedReader( new FileReader( s[0]) );
            String s1="";
            String s2 = new String();
            String se = new String();
            FileOutputStream fout = new FileOutputStream("tabcode.txt");
  	         PrintStream ps = new PrintStream(fout);

  	         FileOutputStream out = new FileOutputStream("mycode.txt");
  	         PrintStream pt = new PrintStream(out);

            StringBuffer sb = new StringBuffer();

            while( (s1 =in.readLine() )!=null)
                 s2 +=s1;

            StringTokenizer stk= new StringTokenizer(s2);

            try
          	{
               while( stk.hasMoreTokens() )
         		   {

									     // System.out.println("");
            	   	   String sg= stk.nextToken() ;

                     byte get[]= tabconvert2.convert(sg);

                     se = tabconvert2.revert(get);


                     //ps.print(se);
                     pt.write(get);
                     pt.write((byte)40);// 40 for blank space
                     //out.write(get);

                     sb.append(se);
                     sb.append(" ");
                //     System.out.print("before : ");
                     //System.out.println(sg);
//                     System.out.println("after  : "+se);

               }
//               System.out.println("Buffer : "+sb);
               ps.print(sb);
               //pt.write(get);


       		}catch(Exception e)
       		{
       		 	//System.out.println("e   aaat within main: "+e);
       		}


        }
        catch(Exception e)
        {
         //System.out.println("e at main : "+e);
         e.printStackTrace();
        }

    }   //  end of main


  public static  String revert( byte b[] )
  {
  	 //  System.out.println("with in rrrevert");
  	   short tab =0;
  	   short temp =0;
  	   short prefix =0;
  	   boolean puttemp = false;
      boolean tamil = false;
      boolean zero = false;
      boolean putprefix = false;
  	   int i=0;
  	   ArrayList al= new ArrayList();


  	 //  System.out.p1rintln("Byte length : "+b.length);

  	   if( b[0] == 0)
  	   {
  	   	      zero = true;
   	   	      i++;
  	   }
  	   else
  	   	      zero = false;

  	   for(  ; i<b.length; i++)
  	   {
  	   	    //System.out.println("dina :"+i+" char : "+(char)(b[i]+218)+" int :"+b[i]);
           if(zero)
  	   	    {   // Nontamil
  	   	    	    tab = (short)b[i];

  	   	    }
  	   	    else
  	   	    {  // Tamil

  	   	    	    if(  ( b[i] <= 12) && ( b[i] >=1 )  )
  	   	    	    {
  	   	    	    	     //System.out.println(" vol");
  	   	    	    	     tab =(short)( b[i]+219 ) ;

  	   	    	    }
  	   	    	    else if( b[i] == 13)
  	   	    	    {	     // System.out.println("akku ");
  	   	    	    	  	  tab =(short)( b[i]+218 ) ;
  	   	    	    }
  	   	    	    else if( 	(b[i] >= 14)  &&  (b[i] <= 36)  )
  	   	    	    {	 //else if
  	   	    	    	     if( i+1<b.length )
  	   	    	    	     {  //inner if
  	   	    	    	     	  //  System.out.println("thumbiasai");
  	   	    	    	           switch( b[i+1] )
  	   	    	    	     	    {
  	   	    	    	     	    	     case 1:
  	   	    	    	                 	      // System.out.println(" mono.");
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
  	   	    	    	     	    	      	       if( b[i] == 18 )
  	   	    	    	     	    	              {
  	   	    	    	     	    	              	  tab = (short) 174;
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
                                  	       if( b[i] == 18 )
  	   	    	    	     	    	              {
  	   	    	    	     	    	              	  tab = (short) 175;
  	   	    	    	     	    	              }
  	   	    	    	     	    	      	       else
  	   	    	    	     	    	              {
 	  		   	    	    	     	    	      	       tab = (short)( b[i]+218 ) ;
  			   	    	    	     	    	              temp =(short) 166;
  	   		  	  	    	     	    	              puttemp = true;
  	   	    	    	     	    	              }
  	   	  	  	    	     	    	            i++;
  	   	    	    	     	    	              break;

                                  case 5:
                                  	       //System.out.println("fin ");
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
  	   	    	    	     	    	      	 //      //System.out.println("kamal:");
  	   	    	    	     	    	      	       if( (b[i] >= 14)  &&  (b[i] <= 20)  )
  	   	    	    	     	    	             {
  	   	    	    	     	    	             	      tab = (short)( b[i]+181 ) ;
  	   	    	    	     	    	                   i++;
  	   	    	    	     	    	          //          //System.out.println("gani:"+(char) tab);
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
                                  	     //  System.out.println("rathna:");
                                  	       prefix = (short) 171; // 34 hat to be 171.This is due to softview 171-34 problem
  	   	    	    	     	    	      	       tab = (short)( b[i]+218 ) ;
  	   	    	    	     	    	      	       temp = (short) 163;
  	   	    	    	     	    	      	       putprefix = true;
  	   	    	    	     	    	      	       puttemp= true;
  	   	    	    	     	    	      	       i++;
  	   	    	    	     	    	      	       break;

  	   	    	    	     	    	      case 12 :
                                  	       //System.out.println("rathna:");
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
  	   	    	    	  	  //System.out.println("                 yes: "+(char)tab);
  	   	    	    } //end else if

  	   	    	    else if(b[i] == 37)
  	   	    	       tab= (short) 255;

                //System.out.println(" tamil "+tab+" char : "+(char)( (int)tab));

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

  	   	   //al.add(  new Character( (char) ((short)5) )  ) ;


	         if( (i+1<b.length) && (b[i+1] == 0) )
  	   	    {
  	   	    	  //  System.out.println(" zero ");
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
  	   {
	       ret = ret+( (Character)(al.get(j)) ).charValue() ;

	     	// System.out.println("  saran "+( (Character)(al.get(j)) ).charValue() );

  	    }
    //   System.out.println(" whole ret: "+ret);
//  	   	System.out.println(" Final : "+al);
  	   	return ret;


  }	 //end of revert








  public static byte[] convert(String p)
  {
     byte mycode = 0;//= new Byte( (byte) 0);
     byte temp=0; //= new Byte( (byte) 0);
     boolean puttemp= false;
     boolean tamil = false;
     boolean zero = false;
     ArrayList al = new ArrayList();

    // System.out.println("  "+p+" length "+p.length());

     if(p==null)
  	  {
       byte[] as = null;
       return as;
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
     	       	//  System.out.println("            "+p.charAt(i)+" mycode "+ mycode+" int "+ (int) p.charAt(i)+"  byte "+(byte)p.charAt(i) );
     	       	  continue ;
     	       }


        			else if(tamil)
     	 				{	// 123
     	 					  //System.out.println("                             1 ");
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

              		else if(  (  p.charAt(i)>=  214 )  &&  (  p.charAt(i)<=  219 ) )
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
     	       			      //System.out.println(" 						2");

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
     	       	             	      			          //System.out.println(" 						2.1");

																									if( i+3<p.length() )
     	       	            			                  {
     	       	            			                  	 //System.out.println("           2.1.1");
																										 if(!checkLa(p.charAt(i+3)))
     	       	            														{
																										 		   mycode =  (byte)(p.charAt(i+1) - 218 );
     	       	     	              	         							 temp =   7 ;
     	       	     	              	         							 puttemp = true;
     	       	     	              	         							 i++;
     	       	     	              	         							 break;
																										  }
     	       	            			                  }
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
     	       		{
     	       			//   System.out.println("              yes");
     	       	    		if( (i+2<p.length()) &&  (  p.charAt(i+2) == 163) )
     	       	    		{
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
     	  		/*     else if( (  p.charAt(i) == 40 ) && ( i+2<p.length() ) && (  p.charAt(i+2) == 41) )
     	       		{	  // this contidtion is actuly wrong this is due to alcrypt
     	       	    		mycode =   18;
     	       	    		temp =   3 ;
     	       	    		puttemp = true;
     	       	    		i+=2;
     	       		}  */

		     	       else if(  p.charAt(i) == 175 )
     	       		{
     	       	    		mycode =   18;
     	       	    		temp =   4 ;
     	       	    		puttemp = true;
     	       		}
     	       		else if(  p.charAt(i) == 255 )
     	 					 		 	     mycode = 37;



     	  		}//123
		     	     //  else
    	         //     mycode = (byte)p.charAt(i);




     	       //System.out.println("--->" + mycode);
              		al.add( new Byte( mycode ) );
              		if(puttemp)
         	    		{
         	    	    		//System.out.println(" raj : "+al+"   "+al.size());
     	        	    		al.add( new Byte( temp ));
     	        	    		//System.out.println(" babu : "+al+"   "+al.size());

     	    	       		puttemp = false;
     	        		}

     	        		/* al.add(  new Byte( (byte) 0)  ) ;
     	        		al.add(  new Byte( (byte) 33)  ) ;
	               al.add(  new Byte( (byte) 0)  ) ;  */


						 		// //System.out.println("array list : "+al);
						  			//System.out.println("            "+p.charAt(i)+" mycode "+ mycode+" int "+ (int) p.charAt(i)+"  byte "+(byte)p.charAt(i) );



      		}

   //   System.out.println("No. of characters given    :"+p.length());
  //    System.out.println("No. of characters returned :"+al.size());

   //   System.out.print(" aaaaaaasaithambi : "+al);


     // System.out.print(" returned  : ");

      byte ret[] = new byte[al.size()];

      //byte by = ((Byte) al.get(2));
      //((Byte) al.get(2)).byteValue();
   	   for(int l=0; l<al.size() ;l++ )
  	   {
  	       	ret[l] =((Byte) al.get(l)).byteValue(); //(Byte)al.get(l);
          //  System.out.print(ret[l]+"  ");
  	   }
    //  System.out.println();

      return ret;
  }


public static boolean checkLa(char nexttola)
{     // this method is to check the la character(29) comes as a combination three letters or separate letter

    //System.out.println("     chencking the la");
 		switch(nexttola)
	  {
	  	   case 162:   return false;
	  	   case 163:   return false;
	  	   case 164:
	  	   	{    // System.out.println("  		164");
	  	   		    return false;
	  	   	}

	  	   case 166:   return false;
	  	   default :   return true;

	  }
 }


}

