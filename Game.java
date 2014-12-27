package textGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Game 
{
	private static final String CAMPUS_NAME = "Truman State";
	
	private static final String[] COMMANDS = {"help, ", "commands, ", "drop, ", 
		"enter, ", "examine, ", "exit, ", "goto, ", "hello, ", "inventory, ", 
		"take"};
		
	private static Player player;
	private static Outside outside;
	private static ArrayList<Building> buildings = new ArrayList<Building>();
	private static boolean canGraduate = false;
	private static boolean gameOver = false;
	
	
	public static void main(String[] args)
	{
		initialize();
		playGame();
	}
	
	private static void playGame()
	{
		listCommands();
		tellStory();
		while(canGraduate == false)
		{
			takeInput();
			
			if(player.getRecLetters() >= 3)
			{
				canGraduate = true;
			}
		}
		
		System.out.println("Hey you can graduate now! Go talk to T. Paine in " +
			"Jazzman's to get your diploma!");
		
		while(gameOver == false)
		{
			takeInput();
		}
		
		endGameStory();
	}
	
	public static void setGameOver(boolean status)
	{
		gameOver = status;
	}
	
	public static void takeInput()
	{
		Scanner in = new Scanner(System.in);
		String input = in.nextLine().trim();
		
		if (input.contains(" "))
		{
			String[] parts = input.split(" ");
			String part1 = parts[0]; // the command
			String part2 = parts[1].toLowerCase(); // what is being "commanded" on
			
			if (part1.equals("take"))
			{
				takeSomething(part2);
			}
			else if (part1.equals("drop"))
			{
				dropSomething(part2);
			}
			//You cannot examine a room if you are not in a room
			else if (part1.equals("examine") && player.getCurrentRoom() != null)
			{
				examineSomething(part2);
			}
			else if (part1.equals("hello"))
			{
				player.speak(part2); //Call player speak to a specific faculty/student
			}
			//You can only enter a building if you are outside
			else if (part1.equals("enter") && player.getCurrentBuilding() == null)
			{
				enter(part2);
			}
			
			else if (part1.equals("goto"))
			{
				gotoRoom(part2);
			}
			else
			{
				System.out.println("Sorry that is not a valid game command. If you need"
					+ " a list of commands type: commands");
			}
		}
		
		else if(input.equals("commands"))
		{
			listCommands();
		}
		else if (input.equals("inventory"))
		{
			player.listItems();
		}
		//If the player types exit and is "Not outside"/"In a building" they can exit
		else if (input.equals("exit") && (player.getCurrentBuilding() != null))
		{
			outside.entry();
			player.setBuilding(null);
			player.setLocation(null);
		}
		else if (input.equals("help"))
		{
			help();
		}
		else
		{
			System.out.println("Sorry that is not a game command. If you need"
				+ " a list of commands type: commands");
		}
	}
	
	//COMMAND METHODS	
	public static void help()
	{
		System.out.println("Type \"commands\" for a list of game commands.");
		System.out.print("The buildings you can go to are: ");
		for (Building b : buildings)
		{
			System.out.print(b.getName());
			if (b != buildings.get(buildings.size() - 1))
			{
				System.out.print(", ");
			}
		}
		
		System.out.println(".");
	}
	
	public static void enter(String part)
	{
		for(Building b : buildings)
		{
			if (b.getName().toLowerCase().equals(part.toLowerCase()))
			{
				//If entering pickler you need 3 coffees. Otherwise it doesnt matter.
				if((b.getName().toLowerCase().equals("pickler") 
						&& (player.calcCoffee() >= 3)) 
					|| !b.getName().toLowerCase().equals("pickler"))
				{
					b.entry(b.getName());
					player.setBuilding(b);
				}
				else
				{
					System.out.println("You need 3 coffees to enter Pickler Library.");
				}
			}
		}
	}
	
	public static void gotoRoom(String part)
	{
		ArrayList<Room> where = player.getCurrentBuilding().getRoomList();
		boolean found = false;
		for (Room r : where)
		{
			if (r.getName().toLowerCase().equals(part.toLowerCase()))
			{
				found = true;
				player.setLocation(r);
				r.entry();
			}
		}
		
		if (!found)
		{
			System.out.println("That is not a room.");
		}
	}
	
	public static void takeSomething(String part)
	{
		if ( (player.getCurrentRoom().getItemsInRoom().contains(player.
			getCurrentRoom().getItemInRoom(part)) 
				&& (player.getCurrentRoom().getItemInRoom(part) instanceof PortableItem )))
		{
			player.addItem(player.getCurrentRoom().getItemInRoom(part));
			System.out.println("You put the " + part + " in your backpack.");
			player.getCurrentRoom().removeItem(player.getCurrentRoom().
				getItemInRoom(part)); //Remove 
		}
		else
		{
			System.out.println("I'm afraid you cannot take that.");
		}
	}
	
	public static void dropSomething(String part)
	{
		if (part.equals("pamphlet"))
		{
			player.removeItem(part);
			player.setPamphlets(false);
			System.out.println("You dropped a pamphlet. You feel much better.");
		}
		else
		{
			System.out.println("Hmm, that is not a good idea.");
		}
	}
	
	public static void examineSomething(String part)
	{
		if(part.equals("room"))
		{
			player.getCurrentRoom().listContents();
		}
		else
		{
			if(player.getCurrentRoom().getItemsInRoom().contains(part))
			{
				System.out.println(player.getCurrentRoom().getItemInRoom(part).
					getDescription());	
			}
		}
	}
	
	public static void listCommands()
	{
		System.out.print("The commands are: ");
		for (String e : COMMANDS)
		{
			System.out.print(e);
		}
		
		System.out.println();
	}
	//END OF COMMAND METHODS
	
	public static void tellStory()
	{
		System.out.println("It's your final year at " + CAMPUS_NAME + " and you "
			+ "need to prepare for graduation!");
		System.out.println("This means a ton of finals, a lot of student "
			+ "collaboration, and as much coffee as you");
		System.out.println("can get your hands on. Talk to as many students "
			+ "as you can to get information, and speak");
		System.out.println("with your professors to get letters of recommendation "
			+ "so you can graduate on time");
		System.out.println("Good luck!");
		System.out.println();
		System.out.println("Important info: You need at least 3 letters of " 
			+ "recommendation to win the game");
		System.out.println("                The library requires you to have "
			+ "coffee to enter");
		System.out.println();
		System.out.println();
		System.out.println("You are currently in your room in Ryle. Take a "
			+ "look around by typing \"examine room\".");
	}
	
	public static void endGameStory()
	{
		System.out.println("Congratulations student! You have graduated from " 
			+ CAMPUS_NAME + "!");
		System.out.println("Your hard work and dedication has paid off and now "
			+ "you're ready to make");
		System.out.println("a name for yourself in the real world working in a "
			+ "sweat shop for code.");
		System.out.println();
		System.out.println("Here are some interesting statistics about your "
			+ "playthrough:");
		System.out.println("You picked up " + player.getBackPackSize() + "items!");
		float correctness = (float)(player.getCorrectTotal())/(float)(player.
			getTotalQuestions());
		float gpa = correctness * (float)4.0;
		System.out.println("You answered " + correctness + "correctly. " + 
			"Your gpa is: " + gpa);
		System.out.println("Thanks for playing!");
	}
	
	private static void initialize()
	{
		player = new Player(new Room(""), new Building(""));
		
		//Initialize Students
		Student student1 = new Student("Tom","I heard if you get 3 recommendation "
			+ "letters you can graduate.");
		Student student2 = new Student("Joe","I bet if you talked to the professors "
			+ "you could get a letter of recommendation.");
		Student student3 = new Student("Ben","*cough* Coffee is the KEY to success "
			+ "maaan.");
		Student student4 = new Student("Sarah","If you talk to an 'Outsider' "
			+ "they'll hand you a pamphlet. You should throw those away.");
		Student student5 = new Student("Jacky","Take everything you can! You may "
			+ "need it later! *sniffles*");
		
		
		//Initialize Faculty
		TrueFalseQ qOne = 
			new TrueFalseQ("What does the expression (5+3>7) evaluate to in java? ",
				true);
		Faculty fac1 = new Faculty("Neitzke", qOne, player);
		
		TrueFalseQ qTwo = 
			new TrueFalseQ("There are 6 CS professors at " + CAMPUS_NAME + 
				". True or False? ", false);
		Faculty fac2 = new Faculty("Matthews", qTwo, player);
		
		String[] ansListQThree = {
			"1. CS250: Systems Programming", "2. CS291: Models of Computation",
			"3. CS380: Programming Languages", "4. CS310: Data Structures/Algorithms"};
		String correct = "3";
		MultiChoiceQ qThree = 
			new MultiChoiceQ("Which course is NOT a prereq for Compilers " +
			"(enter the option number)? ", ansListQThree, correct);
		Faculty fac3 = new Faculty("Burton", qThree, player);
		
		String[] ansListQFour = {"1. 3", "2. 4", "3. 5", "4. 7"};
		correct = "2";
		MultiChoiceQ qFour = 
			new MultiChoiceQ("How many times does the loop " + 
			"\"for(int i=6; i<10; i++);\" iterate? (enter the option number)", 
			ansListQFour, correct);
		Faculty fac4 = new Faculty("Seiffert", qFour, player);
		
		ShortAnswerQ qFive = 
			new ShortAnswerQ("What is the OOP term for the relationship between "
			+ "a Parent and Child class? ", "Inheritance");
		Faculty fac5 = new Faculty("Lewis", qFive, player);
		
		ShortAnswerQ qSix =
			new ShortAnswerQ("Which computer language was this game written in? ", 
			"Java");
		Faculty fac6 = new Faculty("Beck", qSix, player);
				
		TrueFalseQ lastQ =
			new TrueFalseQ("Hello! You want to graduate. True or False? ", true);
		Faculty tPaine = new Faculty("Paino", lastQ, player);
		
		String defaultDesc = "There is nothing interesting about this.";
		//Initialize Outside
		outside = new Outside("Outside");
		PortableItem stick = new PortableItem("stick", defaultDesc);
		PortableItem walnut = new PortableItem("walnut", defaultDesc);
		PortableItem fiveDollarBill = 
			new PortableItem("Five Dollar Bill", defaultDesc);
		PortableItem pneumonia = new PortableItem("pneumonia", defaultDesc);
		FixedItem squirrels = new FixedItem("squirrels", defaultDesc);
		FixedItem trees = new FixedItem("trees", defaultDesc);
		outside.addArtifacts(stick);
		outside.addArtifacts(walnut);
		outside.addArtifacts(fiveDollarBill);
		outside.addArtifacts(pneumonia);
		outside.addArtifacts(squirrels);
		outside.addArtifacts(trees); 

		//Initialize All Game Items that are in Buildings/Rooms
		
	    PortableItem coffee = new PortableItem("coffee", defaultDesc);
	    PortableItem pencil = new PortableItem("pencil", defaultDesc);
	    PortableItem notebook = new PortableItem("notebook", defaultDesc);
	    PortableItem apple = new PortableItem("apple", defaultDesc);
	    PortableItem donut = new PortableItem("donut", defaultDesc);
	    PortableItem bills = new PortableItem("bills", defaultDesc);
	    PortableItem hw = new PortableItem("homework", defaultDesc);
	    PortableItem chalk = new PortableItem("chalk", defaultDesc);
	    PortableItem cookies = new PortableItem("cookies","They look tasty");
	    FixedItem smoothieMachine = new FixedItem("Smoothie Machine",defaultDesc);
	    FixedItem bed = new FixedItem("bed", defaultDesc);
	    FixedItem desk = new FixedItem("desk", defaultDesc);
	    FixedItem desks = new FixedItem("desks", defaultDesc);
	    FixedItem computer = new FixedItem("computer", defaultDesc);
	    FixedItem computers = new FixedItem("computers", defaultDesc);
	    FixedItem tables = new FixedItem("tables", defaultDesc);
	    FixedItem chairs = new FixedItem("chairs", defaultDesc);
	    FixedItem comfyChairs = new FixedItem("comfy chairs", defaultDesc);
	    FixedItem couches = new FixedItem("couches", defaultDesc);
	    FixedItem booths = new FixedItem("booths", defaultDesc);
	    FixedItem ansKeys = new FixedItem("answer keys", defaultDesc);
	    FixedItem balletShoes = new FixedItem("ballet shoes", defaultDesc);
	    FixedItem moneyOrders = new FixedItem("money orders", defaultDesc);
	    FixedItem blimpie = new FixedItem("Blimpie", defaultDesc);
	    FixedItem originalBurger = new FixedItem("Original Burger", defaultDesc);
	    FixedItem projector = new FixedItem("projector", defaultDesc);
	    FixedItem screen = new FixedItem("screen", defaultDesc);
	    FixedItem trashCan = new FixedItem("trash can", defaultDesc);
	    FixedItem chalkboard = new FixedItem("chalkboard", defaultDesc);
	    FixedItem shelves = new FixedItem("shelves", defaultDesc);
	    FixedItem textBooks = new FixedItem("textbooks", defaultDesc);
	    FixedItem books = new FixedItem("books", defaultDesc);
	    FixedItem trumanApparel = new FixedItem("truman apparel", defaultDesc);


		//Initialize BUILDING McClain
		Building mcclain = new Building("McClain");
		
		//Initialize "Financial Office" <3
		Room finOffice = new Room("FinancialOffice");
		finOffice.addItems(moneyOrders);
		finOffice.addItems(bills);
		mcclain.addRoom(finOffice);
		
		//Initialize "Prof. Burton's Office"
		Room burtonOffice = new Room("Burton'sOffice");
		burtonOffice.addItems(ansKeys);
		burtonOffice.addItems(pencil);
		burtonOffice.addItems(desk);
		burtonOffice.addItems(balletShoes);
		burtonOffice.addPerson(fac3); //ADD FACULTY Burton
		mcclain.addRoom(burtonOffice);
		
		buildings.add(mcclain);
		
		
		//Initialize BUILDING Violette
		Building violette = new Building("Violette");
		
		//Initialize "Nerdery"
		Room nerdery = new Room("Nerdery");
		nerdery.addItems(chairs);
		nerdery.addItems(tables);
		nerdery.addItems(computers);
		nerdery.addItems(hw);
		nerdery.addItems(trashCan);
		nerdery.addPerson(student3); //ADD STUDENT 3
		violette.addRoom(nerdery);
		
		//Initialize "Room 1216"
		Room room1216 = new Room("Room1216");
		room1216.addItems(desks);
		room1216.addItems(screen);
		room1216.addItems(projector);
	    room1216.addItems(chalkboard);
	    room1216.addItems(chalk);
	    room1216.addItems(trashCan);
	    room1216.addPerson(fac1);
		violette.addRoom(room1216);
		
		//Initialize "Room 1000"
		Room room1000 = new Room("Room1000");
		room1000.addItems(projector);
		room1000.addItems(screen);
		room1000.addItems(comfyChairs);
		room1000.addItems(trashCan);
		room1000.addPerson(fac2);
		room1000.addPerson(fac4);
		violette.addRoom(room1000);
		
		buildings.add(violette);
		
		
		//Initialize BUILDING Pickler
		Building library = new Building("Pickler");
		
		//Initialize "Jazzmans"
		Room jazzmans = new Room("Jazzman's");
		jazzmans.addItems(coffee);
		jazzmans.addItems(cookies);
		jazzmans.addItems(chairs);
		jazzmans.addItems(tables);
		jazzmans.addPerson(tPaine);
		library.addRoom(jazzmans);
		
		//Initialize "Reading Room"
		Room readingRoom = new Room("ReadingRoom");
		readingRoom.addItems(comfyChairs);
		readingRoom.addItems(desks);
		readingRoom.addItems(chairs);
		readingRoom.addItems(books);
		readingRoom.addPerson(fac6);
		library.addRoom(readingRoom);
		
		//Initialize "Computer Lab"
		Room computerLab = new Room("ComputerLab");
		computerLab.addItems(chairs);
		computerLab.addItems(desks);
		computerLab.addItems(computers);
		computerLab.addPerson(fac5);
		library.addRoom(computerLab);
		
		buildings.add(library);
		
		
		//Initialize BUILDING SUB
		Building sub = new Building("SUB");
		
		//Initialize "Mainstreet Market"
		Room mainstreetMarket = new Room("MainstreetMarket");
		mainstreetMarket.addItems(coffee);
		mainstreetMarket.addItems(smoothieMachine);
		mainstreetMarket.addItems(blimpie);
		mainstreetMarket.addItems(originalBurger);
	    mainstreetMarket.addItems(booths);
	    mainstreetMarket.addItems(comfyChairs);
	    mainstreetMarket.addItems(trashCan);
	    mainstreetMarket.addPerson(student4); //ADD STUDENT 4
		sub.addRoom(mainstreetMarket);

		//Initialize "Book Store"
		Room bookStore = new Room("Bookstore");
	    bookStore.addItems(shelves);
	    bookStore.addItems(textBooks);
	    bookStore.addItems(trumanApparel);
	    bookStore.addPerson(student5); //ADD STUDENT 5
		sub.addRoom(bookStore);
		
		buildings.add(sub);
		
		
		//Initialize BUILDING Ryle
		Building ryle = new Building("Ryle");
		
		//Initialize "Main Lounge"
		Room mainLounge = new Room("MainLounge");
	    mainLounge.addItems(tables);
	    mainLounge.addItems(comfyChairs);
	    mainLounge.addItems(couches);
	    mainLounge.addPerson(student1); //ADD STUDENT 1
		ryle.addRoom(mainLounge);
		
		//Initialize "Dining Hall"
		Room diningHall = new Room("DiningHall");
	    diningHall.addItems(coffee);
	    diningHall.addItems(apple);
	    diningHall.addItems(donut);
	    diningHall.addItems(tables);
	    diningHall.addItems(chairs);
	    diningHall.addItems(trashCan);
	    diningHall.addPerson(student2); //ADD STUDENT 2
		ryle.addRoom(diningHall);
		
		//Initialize "Your Room"
		Room yourRoom = new Room("YourRoom");
	    yourRoom.addItems(coffee);
	    yourRoom.addItems(pencil);
	    yourRoom.addItems(notebook);
	    yourRoom.addItems(bed);
	    yourRoom.addItems(desk);
	    yourRoom.addItems(computer);
	    yourRoom.addItems(trashCan);
		ryle.addRoom(yourRoom);
		
		buildings.add(ryle);
		
		//Player created and starts in their room.
		player = new Player(buildings.get(4).getRoom(2), ryle);
	}
}