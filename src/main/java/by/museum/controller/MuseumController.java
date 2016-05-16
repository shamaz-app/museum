package by.museum.controller;

import by.museum.entities.MuseumBuild;
import by.museum.service.MuseumService;
import by.museum.service.drive.GoogleDrivePhotoStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shamaz on 06.05.2016.
 */
@RestController
@RequestMapping("/museum")
public class MuseumController extends GenericController<MuseumBuild, MuseumService>{

    @Autowired
    public MuseumController(MuseumService service) {
        super(service);
    }

    @Autowired
    public GoogleDrivePhotoStorageService googleDrivePhotoStorageService;


    @RequestMapping(value = "/cityId/{cityId}", method = RequestMethod.GET)
    public List<MuseumBuild> getCityById(@PathVariable("cityId") Long cityId) {
        return service.getMuseumListByCityId(cityId);
    }

    @Override
    protected void addOrUpdate(@RequestBody MuseumBuild entity) {
        entity.setImageUrl(saveImageIfNeed(entity));
        super.addOrUpdate(entity);
    }

    /**
     * Сохраняет если нужно изображение и возвращает
     *
     * @param entity
     * @return
     */
    private String saveImageIfNeed(MuseumBuild entity) {
        if (entity.getId() != null) {
            if (entity.getImage() != null) {
                if (service.get(entity.getId()).getImageUrl() != null && (entity.getImageUrl() == null || entity.getImageUrl().equals(entity.getImageUrl()))) {
                    googleDrivePhotoStorageService.deletePhotoByDirectLink(entity.getImageUrl());
                }
                byte[] byteArray = googleDrivePhotoStorageService.getByteArrayFromString(entity.getImage());
                return googleDrivePhotoStorageService.savePhotoAndGetDirectLink(entity.getName(), byteArray);
            } else if (service.get(entity.getId()).getImageUrl() != null && entity.getImageUrl() == null) {
                googleDrivePhotoStorageService.deletePhotoByDirectLink(entity.getImageUrl());
            }
            return entity.getImageUrl();
        } else {

            byte[] byteArray = googleDrivePhotoStorageService.getByteArrayFromString(entity.getImage());
            return googleDrivePhotoStorageService.savePhotoAndGetDirectLink(entity.getName(), byteArray);
        }
    }
}
