package br.org.cesar.projectnext.cloudtranslate;

import java.io.IOException;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslateTextRequest;
import com.google.cloud.translate.v3.TranslateTextResponse;
import com.google.cloud.translate.v3.Translation;
import com.google.cloud.translate.v3.TranslationServiceClient;

//Classe de serviço da API Google Cloud Translate
public class TranslateTextService {

    public static String translateText(String projectId, String targetLanguage, String text)
            throws IOException {

        String translationResult = ""; //Variável para armazenar a string com a tradução
        
        //Função padrão da API
        try (TranslationServiceClient client = TranslationServiceClient.create()) {
            LocationName parent = LocationName.of(projectId, "global");

            TranslateTextRequest request = TranslateTextRequest.newBuilder()
                    .setParent(parent.toString())
                    .setMimeType("text/plain")
                    .setTargetLanguageCode(targetLanguage)
                    .addContents(text)
                    .build();

            TranslateTextResponse response = client.translateText(request);
            
            //Atribuíndo o resultado da tradução na variável
            for (Translation translation : response.getTranslationsList()) {
                translationResult = translation.getTranslatedText();
            }
        }
        return translationResult;
    }
}