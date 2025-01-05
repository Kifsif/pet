package gift.academic.pet.controllers;

import gift.academic.pet.services.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final StorageService storageService;

    @Autowired
    public PetController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value= {"/new", "/new/"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, Map<String, Object>> newPet(@RequestParam("productAvailable") String productAvailable,
                                                   @RequestParam("stockQuantity") int stockQuantity,
                                                   @RequestPart("imageFile") MultipartFile imageFile){ // @RequestPart
        return null;
    }
}
