import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class give ellaboration of different functions of stream.
 * <ol>
 * <li>Creation of Stream</li>
 * <li>Iteration of stream using forEach(), forEachOrdered()</li>
 * <li>Appling Stream filter()</li>
 * <li>Appling Stream limit()</li>
 * <li>Appling Stream sorted()</li>
 * </ol>
 * @author durgeshkumar
 *
 */
public class StreamAPI {
	List<String> listHeroes = new ArrayList<>();

	public StreamAPI() {
		this.listHeroes.add("AntMan");
		this.listHeroes.add("IronMan");
		this.listHeroes.add("SuperMan");
		this.listHeroes.add("Thor");
		this.listHeroes.add("Batman");
		this.listHeroes.add("AquaMan");
		this.listHeroes.add("");
		this.listHeroes.add("Flash");

	}

	public static void main(String args[]) {
		// creating the streams
		createStream();
		iterateByForEach();
		streamFilter();
		streamLimit();
		streamMap();
		streamSort();
	}

	static void iterateByForEach() {
		Stream<String> s = getListHeroes().stream();
	}

	/**
	 * This method will ellborate different ways of creating the java stream from collection and Arrays
	 * 
	 */
	static void createStream() {
		// getting stream from collection.
		Stream<String> strmFromCollection = getListHeroes().stream();
		// streamIterator(strmFromCollection);
		streamFilter();

		// getting stream from array
		Stream<String> strmFromArray1 = Stream.of(new String[] { "x", "y", "z", "a", "", "R" });
		streamIterator();
		// Stream<String> strmFromArray2= Arrays.stream(new String[]{"x","y","z","a","","R"});
		// streamIterator();

		// Stream using generate method
		// Stream<String> StrmFromGenerate =Stream.generate(()->{return "Durgesh";});
		// streamIterator(StrmFromGenerate);

	}

	/**
	 * This method will ellaborate itetration of stream.
	 * 
	 * @param stream
	 */
	static void streamIterator() {
		System.out.println("Iterating with ForEach");

		// iterating stream using for each
		getListHeroes().stream().forEach(o -> {
			System.out.print(o + ", ");
		});
		System.out.println();
		// iterating stream using forEachOrdered
		System.out.println("Iterating with ForEachOrdered");
		getListHeroes().stream().forEachOrdered(o -> {
			System.out.print(o + ", ");
		});

		System.out.println();
	}

	/**
	 * This method will ellborate ways to apply filter on stream.
	 * 
	 * @param stream
	 */
	static void streamFilter() {
		// Appliying filter for removing empty element
		System.out.println("Appliying filter for removing empty element");
		getListHeroes().stream().filter(str -> !((String) str).isEmpty()).forEach(o -> {
			System.out.print(o + ", ");
		});
		System.out.println();

	}

	/**
	 * Ading limit in Stream. Limit will restrict the no of iteration
	 */
	static void streamLimit() {
		// Limiting the stream to just three element
		System.out.println("Restricting the stream for 3 element");
		getListHeroes().stream().limit(3).forEach(o -> {
			System.out.print(o + ", ");
		});
		System.out.println();

	}

	/**
	 * Ellaboration of Stream map() Map is used to perform mnupulation of each element of the stream. E.g converting
	 * each element ot UPPERCASE
	 */
	static void streamMap() {
		// Convertng stream element to upper case
		System.out.println("Convertng element of the stream to upper case by using map()");
		getListHeroes().stream().map(o -> (String) o.toUpperCase()).forEach(o -> {
			System.out.print(o + ", ");
		});
		System.out.println();

	}

	/**
	 * Ellaboration of Stream sorted()
	 * 
	 */
	static void streamSort() {
		System.out.println("Sorting stream");
		// sorting the stream
		getListHeroes().stream().sorted().forEach(o -> {
			System.out.print(o + ", ");
		});
		System.out.println();
		
		//Sorting using comparator in assending
		System.out.println("Sorting stream using comparator in assending");
		getListHeroes().stream().sorted((o1, o2) -> {
			return ((String) o1).compareTo((String) o2);
		}).forEach(o -> {
			System.out.print(o + ", ");
		});
		System.out.println();
		
		//Sorting using comparator in descending
		System.out.println("Sorting stream using comparator in descending");
		getListHeroes().stream().sorted((o1, o2) -> {
			return ((String) o2).compareTo((String) o1);
		}).forEach(o -> {
			System.out.print(o + ", ");
		});
		System.out.println();

	}

	static List<String> getListHeroes() {
		return new StreamAPI().listHeroes;

	}

}
