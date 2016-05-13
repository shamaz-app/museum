package by.museum.service.drive;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

/**
 * Обертка над клиентской библиотекой GoogleDrive реализующая все методы необходиме
 * для загрузки фотографиий.
 * @author
 */
@Service
public class GoogleDriveService {

    private static final Log LOGGER = LogFactory.getLog(GoogleDriveService.class);
    private String secretFileName = "C:\\museum-secret.json";
    private Drive drive;


    /**
     * Метод для загрузки файлов на GoogleDrive.
     * @param fileMetadata Метаданные файла,например: имя, MIME тип и т.д.
     * @param fileContent  Содержимое файла
     * @return Метаданные файла после загрузки
     */
    public File uploadFile(File fileMetadata, AbstractInputStreamContent fileContent){
        try{
            if(fileContent != null){
                return drive.files().insert(fileMetadata, fileContent).execute();
            } else {
                return drive.files().insert(fileMetadata).execute();
            }
        } catch(IOException e) {
            LOGGER.error(e);
            throw new RuntimeException("Unable upload file on GoogleDrive", e.getCause());
        }
    }
    /**
     * Метод для удаления файла на GoogleDrive.
     * @param deletedFileId    �?дентификатор удаляемого файла
     */
    public void deleteFile(String deletedFileId) {
        try{
            drive.files().delete(deletedFileId).execute();
        } catch (IOException e) {
            LOGGER.debug(e);
            throw new RuntimeException("Unable delete file on GoogleDrive", e.getCause());
        }
    }

    /**
     * Метод для расширения доступа к файлу.
     * @param sharedFile    Метаданные файла к которому необходимо предоставить доступ
     * @return Новые метаданные файла после расширения доступа
     */
    public File shareFileToAnyone(File sharedFile) {
        try{
            Permission sharingPermission = new Permission();
            sharingPermission.setRole("reader").setType("anyone");
            drive.permissions().insert(sharedFile.getId(), sharingPermission).execute();
            return drive.files().get(sharedFile.getId()).execute();
        } catch (IOException e) {
            LOGGER.debug(e);
            throw new RuntimeException("Unable share file on GoogleDrive");
        }
    }

    private static HttpTransport getTransport(){
        try{
            return GoogleNetHttpTransport.newTrustedTransport();
        } catch(GeneralSecurityException | IOException e) {
            LOGGER.error(e);
            throw new RuntimeException("Unable to create new trusted http transport", e.getCause());
        }
    }

    private static JsonFactory getJsonFactory(){
        return JacksonFactory.getDefaultInstance();
    }

    @PostConstruct
    private void initDrive() {
        drive = new Drive.Builder(getTransport(), getJsonFactory(), authorize())
                .setApplicationName("museum-images")
                .build();
    }

    private GoogleCredential authorize(){
        if(! new java.io.File(secretFileName).exists()){
            LOGGER.warn("Unable found secret file with Google Drive private key. It's would be " + secretFileName);
            throw new RuntimeException("GoogleDriveService unable found secret file.");
        }
        try{
            return GoogleCredential.fromStream(
                    new FileInputStream(secretFileName), getTransport(), getJsonFactory())
                    .createScoped(Collections.singleton(DriveScopes.DRIVE_FILE));
        } catch (IOException e) {
            LOGGER.error(e);
            throw new RuntimeException("Authorization on GoogleDrive failed", e.getCause());
        }
    }



    /**
     * Возвращает путь к файлу с серкетным ключом от сервисного аккаунта на GoogleDrive.
     * @return путь к файлу с секретным ключом
     */
    public String getSecretFileName() {
        return secretFileName;
    }

    /**
     * Задает путь к файлу с секретным ключом от сервисного аккаунта на GoogleDrive.
     * @param secretFileName    Путь к файлу с секретным ключом
     */
    public void setSecretFileName(String secretFileName) {
        this.secretFileName = secretFileName;
    }
}
