package by.museum.service.drive;

/**
 * Описывает способ взаимодействия с облачными хранилищами для загрузки в оные фотографий.
 * @author Pisetskiy Vladislav, 25.03.2016
 */
public interface CloudPhotoStorageService {

    /**
     * Метод позволяет сохранить фотографию в каком-либо(зависит от реализации) облачном хранилище.
     * @param fileName    �?мя файла с расширением
     * @param fileContent Содержимое файла
     * @return Прямая ссылка на загруженное фото
     */
    String savePhotoAndGetDirectLink(String fileName, String fileContent);

    /**
     * Метод позволяет удалить фото с облачного хранилища по его прямой ссылке.
     * @param photoLink    Прямая ссылка на фото
     */
    void deletePhotoByDirectLink(String photoLink);
}