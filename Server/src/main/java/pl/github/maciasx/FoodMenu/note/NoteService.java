package pl.github.maciasx.FoodMenu.note;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.maciasx.FoodMenu.exception.ApiRequestException;

@Service
@AllArgsConstructor
public class NoteService {

private NoteRepository noteRepository;

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public Note findNote(Note note) {
        return noteRepository.findById(note.getId()).orElseThrow(() -> new ApiRequestException("Nie ma takiej notatki"));
    }
}
