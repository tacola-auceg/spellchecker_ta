package analyser;

import java.util.Set;
import java.util.HashSet;
import java.util.Hashtable;

public class Constant
{
	/*
	PRONOUN
	OBLIQUE_PRONOUN
	PAST_TM_HUMAN
	CLITIC_1
	CLITIC_2
	CLITIC_3
	CLITIC_4
	CLITIC_5
	CLITIC_6
	CLITIC_7
	CLITIC_8
	DOUBLING_LETTER
	*/

	static byte ththAn[] = {20,20,2,31};
	static byte n_thAn[] = {21,20,2,31};
	static byte kayil[] = {14,9,24,3,26};
	//static byte vENtum[] = {27,8,19,18,5,23};

	//sandhi
	static byte ARR[] = {2,30,30};
	static byte athth[] = {1,20,20};

	static byte Anavai[] = {2,31,1,27,9};

	//Adv Particle
	static byte appa[] = {1,22,22,1};

	//PNG
	static byte van[] = {27,1,31};
	static byte vaL[] =	{27,1,29};
	static byte varkaL[] = {27,1,25,14,1,29};
	static byte vaikaL[] = {27,9,14,1,29};
	static byte aL[] =	{1,29};
	static byte arkaL[] = {1,25,14,1,29};
	static byte aikaL[] = {9,14,1,29};

	//POSTPOSITION
	static byte aRk[] = {1,30,14};

	static byte vaiththu[] = TabConverter.convert("¬õî¢¶");
	static byte udaiya[] = TabConverter.convert("à¬ìò");
	static byte koNdu[] = TabConverter.convert("ªè£í¢´");
	static byte ethirE[] = TabConverter.convert("âî¤«ó");
	static byte bathilAka[] = TabConverter.convert("ðî¤ô£è");
	static byte padi[] = TabConverter.convert("ð®");
	static byte paRRiya[] = TabConverter.convert("ðø¢ø¤ò");
	static byte mUlamAka[] = TabConverter.convert("Íôñ£è");
	static byte varaikkum[] = TabConverter.convert("õ¬óè¢°ñ¢");
	static byte irun_thu[] = TabConverter.convert("Þ¼ï¢¶");
	static byte aLavukku[] = TabConverter.convert("Ü÷¾è¢°");
	static byte avarai[] = TabConverter.convert("Üõ¬ó");

	static byte n_InggalAka[] = {21,4,15,14,1,29,2,14,1};
	static byte kAttilum[] = {14,2,18,18,3,26,5,23};
	static byte ERpa[] = {8,30,22,1};
	static byte n_ikar[] = {21,3,14,1,25};
	static byte n_igarAka[] = {21,3,14,1,25,2,14,1};
	static byte mERpatta[] = {23,8,30,22,1,18,18,1};
	static byte viLaivAka[] = {27,3,29,9,27,2,14,1};
	static byte pEril[] = {22,8,25,3,26};
	static byte pOl[] = {22,11,26};
	static byte allAtha[] = {1,26,26,2,20,1};
	static byte sArbAka[] = {16,2,25,22,2,14,1};
	static byte sArbil[] = {16,2,25,22,3,26};
	static byte pAl[] = {22,2,26};
	static byte adiyil[] = {1,18,3,24,3,26};
	static byte idaiyil[] = {3,18,9,24,3,26};
	static byte idaiyE[] = {3,18,9,24,8};
	static byte utpuRaththil[] = {5,18,22,5,30,1,20,20,3,26};
	static byte utpuRam[] = {5,18,22,5,30,1,23};
	static byte uLLAga[] = {5,29,29,2,14,1};
	static byte kIzE[] = {14,4,28,8};
	static byte n_aduvil[] = {21,1,18,5,27,3,26};
	static byte munnE[] = {23,5,31,31,8};
	static byte munnar[] = {23,5,31,31,1,25};
	static byte uLLitta[] = {5,29,29,3,18,18,1};
	static byte appuRam[] = {1,22,22,5,30,1,23};

	static byte kAttil[] = {14,2,18,18,3,26};

	//RP
	static byte Atha[] = {2,20,1};

	//init
	static byte vel[] = {27,7,26};

	//IPM
	static byte aru[] = {1,25,5};
	static byte vAr[] = {27,2,25};
	static byte thAr[] = {20,2,25};

	//Aux Verb
	//VP/Inf
	static byte nEr[] = {21,8,25};
	static byte piti[] = {22,3,18,3};
	static byte peRu[] = {22,7,30,5};
	static byte pEsu[] = {22,8,16,5};

	//VP
	static byte ati[] = {1,18,3};
	static byte aruL[] = {1,25,5,29};
	static byte Akku[] = {2,14,14,5};
	static byte Aku[] = {2,14,5};
	static byte itu[] = {3,18,5};
	static byte etu[] = {7,18,5};
	static byte ezu[] = {7,28,5};
	static byte eri[] = {7,25,3};
	static byte ozi[] = {10,28,3};
	static byte Ongku[] = {11,15,14,5};
	static byte kAnpi[] = {14,2,19,22,3};
	static byte kuvi[] = {14,5,27,3};
	static byte kUtu[] = {14,6,18,5};
	static byte sey[] = {16,7,24};
	static byte thA[] = {20,2};
	static byte thiri[] = {20,3,25,3};
	static byte n_il[] = {21,3,26};

	//INFINITIVE Suffix
	static byte lAm[] = {26,2,23};
	static byte ttum[] = {18,18,5,23};
	static byte vittAl[] = {27,3,18,18,2,26};
	static byte Amalum[] = {2,23,1,26,5,23};
	static byte AvittAlum[] = {2,27,3,18,18,2,26,5,23};
	static byte ena[] = {7,31,1};
	static byte enRu[] = {7,31,30,5};
	static byte AnAl[] = {2,31,2,26};
	static byte vENtumAnAl[] = {27,8,19,18,5,23,2,31,2,26};
	static byte vENtumena[] = {27,8,19,18,5,23,7,31,1};
	static byte vENtumenRu[] = {27,8,19,18,5,23,7,31,30,5};
	static byte pata[] = {22,1,18,1};
	static byte vENtAm[] =	{27,8,19,18,2,23};
	static byte mutiyAthu[] = {23,5,18,3,24,2,20,5};
	static byte vitAthu[] = {27,3,18,2,20,5};
	static byte Avitil[] = {2,27,3,18,3,26};
	static byte AthE[] = {2,20,8};
	static byte patt[] = {22,1,18,18};
	static byte pattu[] = {22,1,18,18,5};
	static byte pat[] = {22,1,18};

	//VP
	static byte viR[] = {27,3,30};

	//TENSE
	static byte kiR[] = {14,3,30};
	static byte kiRu[] = {14,3,30,5};
	static byte kkiRu[] = {14,14,3,30,5};
	static byte kinR[] = {14,3,31,30};
	static byte kinRu[] = {14,3,31,30,5};
	static byte kkinRu[] = {14,14,3,31,30,5};
	static byte kkiR[] = {14,14,3,30};
	static byte kkinR[] = {14,14,3,31,30};

	static byte n_th[] = {21,20};
	static byte thth[]  = {20,20};
	static byte th[] = {20};
	static byte ath[] = {1,20};

	static byte viRk[] = {27,3,30,14};
	static byte n_iRk[] = {21,3,30,14};

	//Sandhi
	static byte AN[] = {2,19};
	static byte thin[] = {20,3,31};
	static byte uN[] = {5,19};
	static byte pUN[] = {22,6,19};

	static byte p[] = {22};
	static byte v[] = {27};
	static byte vu[] = {27,5};
	static byte ththu[] = {20,20,5};
	static byte n_thu[] = {21,20,5};
	static byte thu[] = {20,5};
	static byte n_[] = {21};
	static byte tt[] = {18,18};
	static byte tu[] = {18,5};
	static byte n[] = {31};
	static byte pp[] = {22,22};
	static byte in[] = {3,31};
	static byte an[] = {1,31};
	static byte RR[] = {30,30};
	static byte Ru[] = {30,5};
	static byte RRu[] = {30,30,5};
	static byte Rk[] = {30,14};
	static byte R[] = {30};
	static byte nn[] = {31,31};
	static byte m[] = {23};

	static byte ng[] = {15};
	static byte nj[] = {17};
	static byte z[] = {28};
	static byte Otu[] = {11,18,5};
	static byte AL[] = {2,29};
	static byte An[] = {2,31};
	static byte Ar[] = {2,25};
	static byte adA[] = {1,18,2};
	static byte adi[] = {1,18,3};
	static byte E[] = {8};
	static byte kaL[] = {14,1,29};
	static byte thAn[] = {20,2,31};
	static byte avan[] = {1,27,1,31};
	static byte avaL[] = {1,27,1,29};
	static byte avar[] = {1,27,1,25};
	static byte avai[] = {1,27,9};

	static byte avaikaL[] = {1,27,9,14,1,29};
	static byte n_I[] = {21,4};
	static byte n_IngkaL[] = {21,4,15,14,1,29};
	static byte n_Ir[] = {21,4,25};
	static byte n_IvIr[] = {21,4,27,4,25};
	static byte n_An[] = {21,2,31};
	static byte n_Am[] = {21,2,23};
	static byte n_AngkaL[] = {21,2,15,14,1,29};
	static byte thAngkaL[] = {20,2,15,14,1,29};
	static byte thAm[] = {20,1,23};

	static byte ithu[] = {3,20,5};
	static byte ivaikaL[] = {3,27,1,25,14,1,29};
	static byte ivai[] = {3,27,9};
	static byte em[] = {7,23};
	static byte engkaL[] = {7,15,14,1,29};

	static byte um[] = {5,23};
	static byte iru[] = {3,25,5};
	static byte ar[] = {1,25};
	static byte En[] = {8,31};
	static byte Om[] = {11,23};
	static byte ana[] = {1,31,1};
	static byte anar[] = {1,31,1,25};
	static byte Ana[] = {2,31,1};
	static byte Aka[] = {2,14,1};
	static byte athu[] = {1,20,5};
	static byte Ay[] = {2,24};
	static byte ArkaL[] = {2,25,14,1,29};
	static byte mArkaL[] = {23,2,25,14,1,29};
	static byte mAr[] = {23,2,25};
	static byte IrkaL[] = {4,25,14,1,29};
	static byte Ir[] ={4,25};
	static byte Or[] ={11,25};
	static byte Al[] = {2,26};
	static byte a[] = {1};
	static byte au[] = {12};
	static byte A[] = {2};
	static byte O[] = {11};
	static byte ka[] = {14,1};
	static byte i[] = {3};
	static byte u[] = {5};
	static byte thal[] = {20,1,26};
	static byte t[] = {18};
	static byte koNt[] = {14,10,19,18};
	static byte koNtu[] = {14,10,19,18,5};
	static byte vitu[] = {27,3,18,5};
	static byte kUda[] = {14,6,18,1};
	static byte ai[] = {9};
	static byte pOyiRRu[] = {22,11,24,3,30,30,5};
	static byte AyiRRu[] = {2,24,3,30,30,5};
	static byte thIr[] = {20,4,25};
	static byte kattu[] = {14,1,18,18,5};
	static byte L[] = {29};
	static byte LL[] = {29,29};
	static byte k[] = {14};
	static byte tk[] = {18,14};
	static byte l[] = {26};
	static byte ll[] = {26,26};
	static byte y[] = {24};
	static byte Amal[] = {2,23,1,26};

	static byte va[] = {27,1};
	static byte N[] = {19};
	static byte kaN[] = {14,1,19};
	static byte kAN[] = {14,2,19};
	static byte koN[] = {14,10,19};

	static byte kaR[] = {14,1,30};
	static byte kaRk[] = {14,1,30,14};
	static byte tha[] = {20,1};
	static byte kEL[] = {14,8,29};
	static byte kEt[] = {14,8,18};
	static byte kEtk[] = {14,8,18,14};
	static byte kal[] = {14,1,26};

	static byte vi[] = {27,3};
	static byte se[] = {16,7};
	static byte sA[] = {16,2};
	static byte yy[] = {24,24};
	static byte kk[] = {14,14};
	static byte r[] = {25};
	static byte vENtum[] = {27,8,19,18,5,23};
	static byte veNtAm[] = {27,8,19,18,2,23};
	static byte kUtum[] = {14,6,18,5,23};
	static byte kUtAthu[] = {14,6,18,2,20,5};
	static byte illai[] = {3,26,26,9};
	static byte kka[] = {14,14,1};
	static byte patu[] = {22,1,18,5};
	static byte koL[] = {14,10,29};
	static byte avarkaL[] = {1,27,1,25,14,1,29};
	static byte kAttu[] = {  14, 2, 18, 18, 5};
	static byte tholai[] = {  20, 10, 26, 9};
	static byte azu[] = { 1, 28, 5};
	static byte kotu[] = {14, 10, 18, 5};
	static byte kita[] = { 14, 3, 18, 1};
	static byte kizi[] = {14, 3, 28, 3};
	static byte thaLLu[] = {20, 1, 29, 29, 5};
	static byte pOtu[] = {22, 11, 18, 5};
	static byte pO[] = {22,11};
	static byte pOk[] = {22,11,14};
	static byte sAk[] = {16,2,14};
	static byte vA[] = {27,2};
	static byte cey[] = {16,7,24};
	static byte vai[] = {27,9};
	static byte muti[] = {23,5,18,3};
	static byte pAr[] = {22,2,25};
	static byte zh[] = {28};
	static byte Athey[] = {2,20,8};
	static byte AthIrkaL[] = {2,20,4,25,14,1,29};
	static byte Athu[] = {2,20,5};
	static byte AvittAl[] = {2,27,3,18,18,2,26};
	static byte var[] = {27,1,25};
	static byte thar[] = {20,1,25};
	static byte nRu[] = {31,30,5};
	static byte Ntu[] = {19,18,5};
	static byte NN[]={19,19};
	static byte nR[] = {31,30};
	static byte ttu[] = {18,18,5};
	static byte varu[] = {27,1,25,5};
	static byte tharu[] = {20,1,25,5};
	static byte kAran[] ={14,2,25,1,31};
	static byte kAri[] = {14,2,25,3};
	static byte kAr[] = {14,2,25};

	//post positions
	static byte[] mUlam = {23,6,26,1,23};
	static byte[] illAmal = {3,26,26,2,23,1,26};
	static byte[] vasam = {27,1,16,1,23};
	static byte[] thORum = {20,11,30,5,23};
	static byte[] maththiyil = {23,1,20,20,3,24,3,26};
	static byte[] pakkam = {22,1,14,14,1,23};
	static byte[] mEl = {23,8,26};
	static byte[] kIz = {14,4,28};
	static byte[] muthal = {23,5,20,1,26};
	static byte[] vaziyAka = {27,1,28,3,24,2,14,1};
	static byte[] pArththu = {22,2,25,20,20,5};
	static byte[] n_Okki = {21,11,14,14,3};
	static byte[] suRRi = {16,5,30,30,3};
	static byte[] thANti = {20,2,19,18,3};
	static byte[] thavira = {20,1,27,3,25,1};
	static byte[] Otti = {11,18,18,3};
	static byte[] appAl = {1,22,22,2,26};
	static byte[] appuram = {1,22,22,5,30,1,23};
	static byte[] uL = {5,29};
	static byte[] uLLE = {5,29,29,8};
	static byte[] pinnE = {22,3,31,31,8};
	static byte[] veLiyE = {27,12,27,24,8};
	static byte[] itaiyE = {3,18,9,24,8};
	static byte[] vittu = {27,3,18,18,5};
	static byte[] pOla  = {22,11,26,1};
	static byte[] vita  = {27,3,18,1};
	static byte[] munnittu = {23,5,31,31,3,18,18,5};
	static byte[] poruththavarai = {22,10,30,5,20,20,1,27,1,25,9};
	static byte[] mAththiram  = {23,2,20,20,3,25,1,23};
	static byte[] n_aduvE = {21,1,18,5,27,8};
	static byte[] arukil = {1,25,5,14,3,26};
	static byte[] pathil  = {22,1,20,3,26};
	static byte[] uriya = {5,25,3,24,1};
	static byte[] thakun_tha  = {20,1,14,5,21,20,1};
	static byte[] mARAka = {23,2,30,2,14,1};
	static byte[] n_IrAka = {21,8,25,2,14,1};
	static byte[] kuRukkE = {14,5,30,5,14,14,8};
	static byte[] paRRi  = {22,1,30,30,3};
	static byte[] kuRiththu  = {14,5,30,3,20,20,5};
	static byte[] kuRiththa  = {14,5,30,3,20,20,1};
	static byte[] mAthiri  = {23,2,20,3,25,3};
	static byte[] otti  = {10,18,18,3};
	static byte[] ottiya  = {10,18,18,3,24,1};
	static byte[] aNmaiyil  = {1,19,23,9,24,3,26};

	static byte[] thottu  = {20,10,18,18,5};
	static byte[] mAtt = {23,2,18,18};
	static byte[] mAttu = {23,2,18,18,5};
	static byte[] mAttAn ={23,2,18,18,2,31};

	//clitic
	static byte[] ennum = {7,31,31,5,23};
	static byte[] Akilum = {2,14,3,26,5,23};
	static byte[] Ayinum = {2,24,3,31,5,23};
	static byte[] Avathu = {2,27,1,20,5};
	static byte[] ammA = {1,23,23,2};
	static byte[] appA = {1,22,22,2};
	static byte[] ayyA = {1,24,24,2};

	//adverbial participles
	static byte[] pozuthu = {22,10,28,5,20,5};
	static byte[] pOthu = {22,11,20,5};
	static byte[] mun = {23,5,31};
	static byte[] munpu = {23,5,31,22,5};
	static byte[] munnAl = {23,5,31,31,2,26};
	static byte[] pin  = {22,3,31};
	static byte[] pinpu = {22,3,31,22,5};
	static byte[] pinnAl ={22,3,31,31,2,26};
	static byte[] piRaku = {22,3,30,1,14,5};
	static byte[] utanE = {5,18,1,31,8};
	static byte[] utan = {5,18,1,31};
	static byte[] vaNNam = {27,1,19,19,1,23};
	static byte[] vARu = {27,2,30,5};
	static byte[] pati = {22,1,18,3};
	static byte[] mattum = {23,1,18,18,5,23};
	static byte[] mattilum = {23,1,18,18,3,26,5,23};
	static byte[] varai = {27,1,25,9};
	static byte[] varaiyil = {27,1,25,9,24,3,26};
	static byte[] Ath = {2,20};

	//potential suffixes
	static byte[] alAm = {1,26,2,23};
	static byte[] kalAm = {14,1,26,2,23};
	static byte[] kkalAm = {14,14,1,26,2,23};
	static byte[] makkaL = {23,1,14,14,29};
	static byte[] makaL = {23,1,14,29};

	static byte[] ivar = {3,27,1,25};
	static byte[] ina = {3, 31, 1};

	static byte il[] = {3,26};
	static byte itam[] = {3,18,1,23};
	static byte ukku[] = {5,14,14,5};
	static byte ukk[] = {5,14,14};
	static byte iRku[] = {3,30,14,5};
	static byte iRkAka[] = {3,30,14,2,14,1};
	static byte aRkAka[] = {1,30,14,2,14,1};
	static byte aRku[] = {1,30,14,5};
	static byte iRk[] = {3,30,14};
	static byte kku[] = {14,14,5};
	static byte akku[] = {1,14,14,5};
	static byte akk[] = {1,14,14};
	static byte kkaL[] = {14,14,1,29};

	static byte ilirun_thu[] = {3,26,3,25,5,21,20,5};
	static byte itamirun_thu[] = {3,18,1,23,3,25,5,21,20,5};
	static byte ilirun_th[] = {3,26,3,25,5,21,20};
	static byte itamirun_th[] = {3,18,1,23,3,25,5,21,20};
	static byte utaiya[] = {5,18,9,24,1};
	static byte aRRu[] = {1,30,30,5};
	static byte aRRa[] = {1,30,30,1};
	static byte ev[] = {7,27};
	static byte ku[] = {14,5};
	static byte I[] = {4};
	static byte s[] = {16};
	static byte ss[] = {16,16};
	static byte U[] = {6};
	static byte utaiyathu[] = {5,18,9,24,1,20,5};

	static byte kE[] = {14,8};
	static byte en[] = {7,31};
	static byte un[] = {5,31};
	static byte ivan[] = {3,27,1,31};
	static byte ivaL[] = {3,27,1,29};
	static byte n_am[] = {21,1,23};
	static byte yAn[] = {24,2,31};
	static byte yAm[] = {24,2,23};
	static byte than[] = {20,1,31};
	static byte tham[] = {20,1,23};
	static byte ivarkaL[] = {3,27,1,25,14,1,29};
	static byte e[] = {7};
	static byte o[] = {10};
	static byte vaRR[] = {27,1,30,30};
	static byte aththu[] = {1,20,20,5};
	static byte ellA[] = {7,26,26,2};
	static byte nAyanmArkaL[] = {21,2,24,1,31,23,2,25,14,1,29};

	static byte sumArkaL[] = {16,5,23,2,25,14,1,29};
	static byte iya[] = {3,24,1};
	static byte uLLa[] = {5,29,29,1};
	static byte angku[] = {1,15,14,5};
	static byte ingku[] = {3,15,14,5};
	static byte engku[] = {7,15,14,5};
	static byte umpadi[] = {5,23,22,1,18,3};
	static byte athan[] = {1,20,1,31};
	static byte ithan[] = {3,20,1,31};
	static byte ethan[] = {7,20,1,31};

	//ISM
	static byte tA[] = {18,2};
	static byte ti[] = {18,3};
	static byte mmA[] = {23,23,2};
	static byte ppA[] = {22,22,2};
	static byte yyA[] = {24,24,2};

	static byte utA[] = {5,18,2};
	static byte uti[] = {5,18,3};
	static byte ummA[] = {5,23,23,2};
	static byte uppA[] = {5,22,22,2};
	static byte uyyA[] = {5,24,24,2};

	//IPM
	static byte ngkaL[] = {15,14,1,29};
	static byte ungkaL[] = {5,15,14,1,29};

	static byte irukkattum[] = {3,25,5,14,14,1,18,18,5,23};
	static byte uNtu[] = {5,19,18,5};
	static byte uLLathu[] = {5,29,29,1,20,5};
	static byte Anathu[] = {2,31,1,20,5};
	static byte Akum[] = {2,14,5,23};
	static byte AkiRathu[] = {2,14,3,30,1,20,5};
	static byte AkAthu[] = {2,14,2,20,5};
	static byte iLLai[] = {3,26,26,9};

	static byte[][] PRONOUN =
						{
							avan,
							avaL,
							avai,
							avarkaL,
							avar,
							athu,
							avaikaL,
							ivan,
							ivaL,
							ivarkaL,
							ivar,
							ithu,
							ivaikaL,
							ivai,
							en,
							em,
							engkaL,
							n_am,
							tham,
							than,
							un,
							ungkaL,
							um,
							a,//later
							i,
							yAm,
							yAn
						};

	static byte[][] OBLIQUE_PRONOUN =
						{
							n_I,
							n_IngkaL,
							n_IvIr,
							n_Ir,
							n_An,
							n_Am,
							n_AngkaL,
							thAngkaL,
							thAn,
							thAm
						};

	static byte[][] PAST_TM_HUMAN =
						{
							in,
							i,
							n_th,
							thth,
							th,
							n,
							t,
							R
						};

	static byte[][] CLITIC_1 =
						{
							A,
							O,
							E,
						};

	static byte[][] CLITIC_2 =
						{
							thAn,
						};

	static byte[][] CLITIC_3 =
						{
							mattum,
							mAththiram,
						};

	static byte[][] CLITIC_4 =
						{
							ennum,
							Akilum,
							Ayinum,
						};

	static byte[][] CLITIC_5 =
						{
							kUda,
						};

	static byte[][] CLITIC_6 =
						{
							um,
						};

	static byte[][] CLITIC_7 =
						{
							Avathu,
						};

	static byte[][] CLITIC_8 =
						{
							adA,
							adi,
							ammA,
							appA,
							ayyA,
						};

	static byte[][] DOUBLING_LETTER =
						{
							N,
							n,
							m,
							l,
							L,
							y
						};

	static byte[][] ADJECTIVE =
						{
							Ana,
							iya,
							uLLa,
							aRRa
						};


}
