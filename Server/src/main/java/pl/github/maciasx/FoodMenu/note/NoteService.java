package pl.github.maciasx.FoodMenu.note;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.github.maciasx.FoodMenu.exception.ApiRequestException;
import pl.github.maciasx.FoodMenu.model.Meal;
import pl.github.maciasx.FoodMenu.user.User;
import pl.github.maciasx.FoodMenu.user.UserService;

@Service
@AllArgsConstructor
public class NoteService {

    private NoteRepository noteRepository;
    private UserService userService;

    public Note addNote(NoteRequest note) {
        Note newNote = new Note();
        User user = userService.getUserById(note.getUser());
        if(note.getId() != null)
            newNote.setId(note.getId());
        newNote.setNote(note.getNote());
        newNote.setDateMenu(note.getDateMenu());
        newNote.setMeal(note.getMeal());
        newNote.setUser(user);
        return noteRepository.save(newNote);
    }

    public Note findNote(NoteRequest note) {
        User user = userService.getUserById(note.getUser());
        return noteRepository.findNoteByDateMenuAndUserAndMeal(note.getDateMenu(),user,note.getMeal());
    }
}
