package com.example.library_service.service;

import com.example.library_service.dto.LibraryDto;
import com.example.library_service.exception.LibraryNotFoundException;
import com.example.library_service.model.Library;
import com.example.library_service.repository.LibraryRepository;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository=libraryRepository;
    }
    public LibraryDto getAllBooksInLibraryById(String id){
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found bu id: " + id));
        LibraryDto libraryDto = new LibraryDto(library.getId());
        return libraryDto;
    }
    public LibraryDto createLibrary(){
        Library newLibrary =libraryRepository.save(new Library());
        return new LibraryDto(newLibrary.getId());
    }

}
