package assignment2;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.Translate.Translations;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;

public class TranslateToEnglish {
	
	public static String translate(String input) throws IOException, GeneralSecurityException {
		
		Translate t = new Translate.Builder(GoogleNetHttpTransport.newTrustedTransport(), GsonFactory.getDefaultInstance(), null).setApplicationName("Gym-Chatbot").build();
        Translate.Translations.List list = t.new Translations().list(Arrays.asList(input),"EN");
        
        list.setKey("Enter API key here");
        TranslationsListResponse response = list.execute();
		return (String) response.getTranslations().get(0).get("translatedText");
	}
}
