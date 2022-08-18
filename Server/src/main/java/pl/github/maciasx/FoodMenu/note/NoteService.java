package pl.github.maciasx.FoodMenu.note;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteService {

private NoteRepository noteRepository;

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public Note findNote(Note note) {
        return noteRepository.findNoteByDateMenuAndMealAndUser();
    }
}
