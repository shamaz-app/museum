package by.museum.service.drive;

import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.services.drive.model.File;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Реализация CloudPhotoStorageService для GoogleDrive с использованием GoogleDrive REST API.
 * @author Pisetskiy Vladislav, 25.03.2016
 */
@Service
public class GoogleDrivePhotoStorageService implements CloudPhotoStorageService {

    @Autowired
    private GoogleDriveService drive;

    /**
     * Метод позволяет загрузить фото на GoogleDrive и сделать его доступным всем в интернете.
     * @param fileName    Имя файла с расширением
     * @param fileContent     Содержимое файла
     * @return Прямая ссылка на загруженное фото
     */
    @Override
    public String savePhotoAndGetDirectLink(String fileName, byte[] fileContent) {
        File uploadFileMetadata = new File().setTitle(fileName);
        AbstractInputStreamContent uploadFileContent = new ByteArrayContent("image/jpeg", fileContent);
        File uploadedFile = drive.uploadFile(uploadFileMetadata, uploadFileContent);
        File sharedFile = drive.shareFileToAnyone(uploadedFile);
        return sharedFile.getWebContentLink();
    }

    /**
     * Метод позволяет удалить фото с GoogleDrive имея прямую ссылку на него.
     * @param photoLink    Прямая ссылка на удаляемое фото
     */
    @Override
    public void deletePhotoByDirectLink(String photoLink) {
        if(photoLink != null && !photoLink.isEmpty()){
            String deleteFileId = getFileIdFromPhotoLink(photoLink);
            drive.deleteFile(deleteFileId);
        }
    }

    @Override
    public byte[] getByteArrayFromString(String string){
        return Base64.decodeBase64(string.split("base64,")[1]);
    }

    private static String getFileIdFromPhotoLink(String photoLink) {
        String idWithOtherParam = photoLink.split("id=")[1];
        return idWithOtherParam.split("&")[0];
    }

    public GoogleDriveService getDrive() {
        return drive;
    }

    public void setDrive(GoogleDriveService drive) {
        this.drive = drive;
    }
}
