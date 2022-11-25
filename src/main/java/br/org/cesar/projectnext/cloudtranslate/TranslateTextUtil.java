package br.org.cesar.projectnext.cloudtranslate;

import java.io.IOException;

//Classe com as funções de tradução
public class TranslateTextUtil {

    //função para tradução de textos de inglês para português
    public static String translateTextEn(String text) throws IOException {
        String projectId = "project-next-369319";
        String targetLanguage = "pt";
        return TranslateTextService.translateText(projectId, targetLanguage, text);
    }
    //função para tradução de textos de inglês para português
    public static String translateTextPt(String text) throws IOException {
        String projectId = "project-next-369319";
        String targetLanguage = "en";
        return TranslateTextService.translateText(projectId, targetLanguage, text);
    }
}
