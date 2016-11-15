import java.util.*;

public class formula
{
	static double rateOfWork = .25;
	static double kiloJoule = 4186;

	public static void main(String args [])
	{
		Scanner input = new Scanner(System.in);
		double calories,joules,watts,time,actualCals;

		// System.out.println("Enter amount of time in minutes");
		// time = input.nextDouble();
		// time *=60;
		

		//**********************************************************
		System.out.println("This piece will convert calories into watts... \n");
		System.out.println("Enter Calories:");
		calories = input.nextDouble();
		System.out.println("Enter amount of time in minutes, it took to use them calories:");
		time = input.nextDouble();
		time *=60;
		joules = calsToJoules(calories);  // calories to watts
		watts = joules/time;
		System.out.println("Using "+calories+" calories of energy in "+time/60+" minutes produces "+watts+" watts of power.");
		//**********************************************************
		
		System.out.println("\n\n*********************************\n\n"); // new line
		time = 0;

		//**********************************************************
		System.out.println("This piece of code will cnovert watts to calories...\n");
		System.out.println("Enter watts:");
		watts = input.nextDouble();
		System.out.println("Enter amount of time in minutes, it took to use the wattage:");
		time = input.nextDouble();
		time *=60;
		joules= wattsToJoules(watts,time);  //watts to calories
		calories = joulesToCals(joules);
		System.out.println(watts + " watts converting into calories = " +calories);
		//**********************************************************
		
		System.out.println();
		time =0;

		// actualCals = actualCalsUsed(calories);
		// System.out.println("Actual calories used working at an average rate = " + actualCals);
	
		/*for(int i =0; i<mant.length;++i)
		{

		}
		Random rand = new Random();
		double x = rand.nextDouble(1000)+1;
		mant[0] = "How many watts does running "+x+" miles produce?";
		mant[1] = System.out.println();;
		mant[2] = "";
		mant[3] = "";
		mant[4] = "";
		mant[5] = "";
		mant[6] = "";
		mant[7] = "";
		mant[8] = "";
		mant[9] = "";

		*/



		System.out.println("Lets try a quiz:\n");

		//.75 of a calorie burned per push-up

		String mant[] = new String[20];
		mant[0] = "How many push-ups does it take to power a 60 watt bulb for an hour?";
		System.out.println(mant[0]);
		System.out.println("a: 69");
		System.out.println("b: 6");
		System.out.println("c: 600");
		System.out.println("d: 1");
		char a = input.next().charAt(0);  //i know this is retarded i was  just messing around a bit
		
			if(a == 'a')
			{
				System.out.println("yeowwww");
			}
			else if(a=='b')
			{
				System.out.println("nope");
			}
			else if(a=='c')
			{
				System.out.println("nah");
			}
			else if(a=='d')
			{
				System.out.println("no");
			}
			else
			{
				System.out.println("Please enter either a,b,c,d:");
			}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");



	}

	public static double wattsToJoules(double watts, double time)
	{
		return watts*time;
	}
	
	public static double actualCalsUsed(double calories)
	{
		return calories/rateOfWork;
	}
	
	public static double calsToJoules(double cals)
	{
		return cals*kiloJoule;
	}
	
	public static double joulesToCals(double joules)
	{
		return joules/kiloJoule;
	}
}