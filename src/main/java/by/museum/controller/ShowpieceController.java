package by.museum.controller;

import by.museum.entities.Showpiece;
import by.museum.service.MuseumService;
import by.museum.service.ShowpieceService;
import by.museum.service.drive.GoogleDrivePhotoStorageService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Анастасия on 06.04.2016.
 */
@RestController
@RequestMapping("/showpieces")
public class ShowpieceController extends GenericController<Showpiece, ShowpieceService> {

    @Autowired
    private MuseumService museumService;

    @Autowired
    public ShowpieceController(ShowpieceService service) {
        super(service);
    }

    @Autowired
    public GoogleDrivePhotoStorageService googleDrivePhotoStorageService;


    @Override
    protected void addOrUpdate(@RequestBody Showpiece entity) {
        entity.setMuseum(museumService.get(1l));
        entity.setImageUrl(saveImageIfNeed(entity));
        super.addOrUpdate(entity);
    }

    /**
     * Сохраняет если нужно изображение и возвращает
     *
     * @param entity
     * @return
     */
    private String saveImageIfNeed(Showpiece entity) {
        if (entity.getId() != null) {
            if (entity.getImage() != null) {
                if (service.get(entity.getId()).getImageUrl() != null && (entity.getImageUrl() == null || entity.getImageUrl().equals(entity.getImageUrl()))) {
                    googleDrivePhotoStorageService.deletePhotoByDirectLink(entity.getImageUrl());
                }
                return googleDrivePhotoStorageService.savePhotoAndGetDirectLink(entity.getName(), entity.getImage());
            } else if (service.get(entity.getId()).getImageUrl() != null && entity.getImageUrl() == null) {
                googleDrivePhotoStorageService.deletePhotoByDirectLink(entity.getImageUrl());
            }
            return entity.getImageUrl();
        } else {
            return googleDrivePhotoStorageService.savePhotoAndGetDirectLink(entity.getName(), entity.getImage());
        }
    }
}
