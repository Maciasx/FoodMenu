package pl.github.maciasx.FoodMenu.note;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("note")
@AllArgsConstructor
public class NoteController {

    private NoteService noteService;

    @PostMapping("/get")
    public ResponseEntity<Note> getNote(@RequestBody NoteRequest note) {
        Note getNote = noteService.findNote(note);
        return new ResponseEntity<>(getNote, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Note> addNote(@RequestBody NoteRequest note) {
        Note newNote = noteService.addNote(note);
        return new ResponseEntity<>(newNote, HttpStatus.CREATED);
    }
}
