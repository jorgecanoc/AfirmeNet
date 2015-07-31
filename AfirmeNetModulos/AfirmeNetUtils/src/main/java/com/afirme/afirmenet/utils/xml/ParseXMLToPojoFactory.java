package com.afirme.afirmenet.utils.xml;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ParseXMLToPojoFactory {
	public static <T> T transform(String xml, Class<T> type) {
		JAXBContext jaxbContext;
		T returnObj = null;
		try {
			StringReader reader = new StringReader(xml);
			jaxbContext = JAXBContext.newInstance(type);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			returnObj = type.cast(jaxbUnmarshaller.unmarshal(reader));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return returnObj;
	}
}
