package project1.test;


class Dog implements Comparable<Dog> {
	public Integer age;

	public Dog(int a) {
		age = a;
	}

	@Override
	public int compareTo(Dog o) {
		if(age < o.age) 
			return -1;
		if(age > o.age) 
			return 1;
		
		return 0;
		
	}

	@Override
	public String toString() {
		return "Dog Age = " + age;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Dog))
			return false;
		else
			return age == ((Dog) o).age;
	}
}