package br.org.cesar.projectnext.cloudtranscription;

// Imports the Google Cloud client library
import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;

import java.io.IOException;
import java.util.List;

//Classe que faz a função de transcrição do audio que foi feito o upload
public class CloudTranscriptionService {
  static String transcription = ""; //Variável para guardar a string da transcrição
  
  //Função de transcrição do áudio
  public static String transcriptionFile(String fileName) throws IOException{
      SpeechClient speechClient = SpeechClient.create();
      String gcsUri = "gs://bucket-quickstart_project-next-369319/" + fileName; //Endereço do arquivo na GC Storage

       //Configuração para áudios .flac e .wav
      RecognitionConfig config = RecognitionConfig.newBuilder()
          .setLanguageCode("en") //Difinição do idioma do áudio
          .setEnableAutomaticPunctuation(true) //Ativando pontuação da transcrição
          .build();

      //Padrão da API
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();
      RecognizeResponse response = speechClient.recognize(config, audio);
      List<SpeechRecognitionResult> results = response.getResultsList();

      for (SpeechRecognitionResult result : results) {
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        transcription = alternative.getTranscript(); //Atribuíndo o resultado da transcrição na variável
      }

    return transcription;
  }
}