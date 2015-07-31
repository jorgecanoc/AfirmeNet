package afirme.afirmenet.model.pagos.impuestos;

import java.text.Normalizer;

import org.junit.Test;

public class NormalizerTest {

	@Test
	public void test(){
		String subjectString = "ˆ √Å ¸".toUpperCase();
		subjectString = Normalizer.normalize(subjectString, Normalizer.Form.NFD);
		String resultString = subjectString.replaceAll("[^\\x00-\\x7F]", "");
		resultString = resultString.replaceAll("\\s+","");
		System.out.println(resultString);
	}
}
