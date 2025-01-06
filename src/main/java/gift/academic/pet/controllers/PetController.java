package gift.academic.pet.controllers;

import gift.academic.pet.dtos.PetDto;
import gift.academic.pet.dtos.PetDtoRegisterUser;
import gift.academic.pet.exceptions.ValidationException;
import gift.academic.pet.services.storage.StorageFileNotFoundException;
import gift.academic.pet.services.storage.StorageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public Map<String, Map<String, Object>> newPet(@ModelAttribute @Valid PetDtoRegisterUser petDto,
                                                   BindingResult bindingResult) throws ValidationException {

        if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult);
        }

        return null;
    }


    @PostMapping(value= {"/new", "/new/"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, Map<String, Object>> newPet(@ModelAttribute @Valid PetDto petDto,
                                                   BindingResult bindingResult) throws ValidationException {

        if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult);
        }

        return null;
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
