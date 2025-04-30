public class Person implements Comparable
{
	/***** TODO: (Part 2) create helper inner class for Identity*****/
	private class Identity {
		private String pronouns, background;

		public Identity(String pronouns, String background) {
			this.pronouns = pronouns;
			this.background = background;
		}

		public Identity() {
			this(Person.DEFAULT_PRONOUNS, Person.DEFAULT_BACKGROUND);
		}

		@Override
		public String toString() {
			return "My personal pronouns are " + this.pronouns + " and" + this.background;
		}

		@Override
		public boolean equals(Object other) {
			if(other == null || (this.getClass() != other.getClass())) {
				return false;
			}

			Identity otherIdentity = (Identity) other;
			return this.pronouns.equals(otherIdentity.pronouns) && this.background.equals(otherIdentity.background);
		}

	}//End of Identity inner class

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_PRONOUNS =  "They/Them";
	public static final String DEFAULT_BACKGROUND =  "Unknown";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name;
	private Identity story = new Identity();
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, String pronouns, String background, int privilege) {
		this.setAll(name, pronouns, background, privilege);
	}
		
	public Person() {
		this(DEFAULT_NAME, DEFAULT_PRONOUNS, DEFAULT_BACKGROUND, DEFAULT_PRIVILEGE);
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null object in Person copy constructor");
		} else {
			this.setAll(original.name, original.story.pronouns, original.story.background, original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {

		this.name = name;
	}

	public void setPronouns(String pronouns) {

		this.story.pronouns = pronouns;
	}

	public void setBackground(String background) {

		this.story.background = background;
	}

	public void setPrivilege(int privilege) {

		this.privilege = privilege;
	}

	public void setAll(String name, String pronouns, String background, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setPronouns(pronouns);
		this.setBackground(background);
	}

	// ACCESSORS / GETTERS
	public String getName() {

		return this.name;
	}
		
	public String getPronouns() {
		return this.story.pronouns;
	}

	public String getBackground() {
		return this.story.background;
	}

	public int getPrivilege() {

		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + " my pronouns are " + this.story.pronouns + " and " + this.story.background + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(other == null || (!(other instanceof Person))) {
		      return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.story.equals(otherPerson.story) &&
			this.privilege == otherPerson.privilege;	
	}

	// INTERFACE METHODS

	/***** TODO: (Part 1) override compareTo method to implement Comparable interface*****/
	@Override
	public int compareTo(Object other) {
		if (other == null || (!(other instanceof Person))) {
			throw new IllegalArgumentException("null given to compareTo method in Person, or not a Person type");
		}
		Person otherPerson = (Person)other;

		return this.privilege - otherPerson.privilege;
	}
}