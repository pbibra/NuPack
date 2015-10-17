package my.nulogy.sample;

public class NuPackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double result;
		double expected;
		final String sWrong = "Cost calculated was incorrect";
		
		try {
			
			Package pkg = new Package();
			
			//Test 1
			expected = 1591.58;
			System.out.println(String.format("Test 1 - Expected Output: %.2f", expected));

			pkg.setBasePrice(1299.99);
			pkg.setMaterial("food");
			pkg.setNumPeople(3);
			
			result = pkg.calculateQuote();
			assert result == expected : sWrong;
			System.out.println(String.format("Output 1: $%.2f", result));
			
			//Test 2
			expected = 6199.81;
			System.out.println(String.format("\nTest 2 - Expected Output: %.2f", expected));
			
			pkg.setBasePrice(5432.00);
			pkg.setMaterial("drugs");
			pkg.setNumPeople(1);
			
			result = pkg.calculateQuote();
			assert result == expected : sWrong;
			System.out.println(String.format("Output 2: $%.2f", result));
			
			//Test 3
			expected = 13707.63;
			System.out.println(String.format("\nTest 3 - Expected Output: %.2f", expected));
			
			pkg.setBasePrice(12456.95);
			pkg.setMaterial("books");
			pkg.setNumPeople(4);
			
			result = pkg.calculateQuote();
			assert result == expected : sWrong;
			System.out.println(String.format("Output 3: $%.2f", result));
			
		} catch (Exception e) {
			
			System.out.println("An unexpected error occurred: " + e.getMessage());
			
		}
		

	}

}
