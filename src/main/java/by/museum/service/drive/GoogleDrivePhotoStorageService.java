package by.museum.service.drive;

import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.services.drive.model.File;
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
     * @param fileName    �?мя файла с расширением
     * @param fileContent     Содержимое файла
     * @return Прямая ссылка на загруженное фото
     */
    @Override
    public String savePhotoAndGetDirectLink(String fileName, String fileContent) {

        File file = new File().setTitle(fileName);
        File.Thumbnail thumbnail = new File.Thumbnail();
        thumbnail.setImage(fileContent);
        thumbnail.setMimeType("image/png");
        file.setThumbnail(thumbnail);
        File uploadedFile = drive.uploadFile(file);
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
