package br.org.cesar.projectnext.cloudtranslate;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Rotas para tradução de textos
@RestController
class TranslateTextController {

    //Rota para traduzir textos de inglês para português
    @PostMapping("/EnToPt")
    public ResponseEntity<String> translateEnToPt(@RequestBody String text) throws IOException {
        String translatedText = TranslateTextUtil.translateTextEn(text);
        return new ResponseEntity<String>(translatedText, HttpStatus.OK);
    }

    //Rota para traduzir textos de português para inglês
    @PostMapping("/PtToEn")
    public ResponseEntity<String> translatePtToEn(@RequestBody String text) throws IOException {
        String translatedText = TranslateTextUtil.translateTextPt(text);
        return new ResponseEntity<String>(translatedText, HttpStatus.OK);
    }

}
