package serdeser.serdeser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.tuple.MutablePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SerdeserApplicationTests {

	private ObjectMapper objectMapper = new ObjectMapper();

	private Encja createEncja() {
		Encja encja = new Encja();
		encja.setId("1234");

		List<MutablePair<String, String>> lista = new ArrayList<>();
		lista.add(new MutablePair<>("ak", "av"));
		lista.add(new MutablePair<>("bk", "bv"));
		encja.setListapar(lista);

		return encja;
	}

	@Test
	public void contextLoads() {

		Encja encja = createEncja();

		try {
			String str = objectMapper.writeValueAsString(encja);
			System.out.println(str);

			Encja ser = objectMapper.readValue(str, Encja.class);

			System.out.printf("");
		} catch (Exception e) {
			System.out.println("zesralo sie");
			e.printStackTrace();
		}

	}

}
