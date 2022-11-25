
package br.org.cesar.projectnext.cloudstorage;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

//Classe que faz o upload do arquivo enviado na requisição para a Google Cloud Storage.
public class UploadFileToStorageService {

  public static void uploadFile(MultipartFile file) throws IOException{ //Função de upload
    String projectId = "project-next-369319"; //Id do projeto da Google Cloud
    String bucketName = "bucket-quickstart_project-next-369319"; //Id do bucket criado na Google Cloud Storage.
    String objectName = file.getOriginalFilename(); //Nome do arquivo que será feito o upload

    InputStream inputStream = file.getInputStream(); //Leitura do arquivo que será feito o upload

    //Padrão da API Storage para upload 
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    BlobId blobId = BlobId.of(bucketName, objectName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
    storage.create(blobInfo, inputStream);
  }
}