package pl.github.maciasx.FoodMenu.note;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.github.maciasx.FoodMenu.food.Food;
import pl.github.maciasx.FoodMenu.menu.Menu;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("note")
@AllArgsConstructor
public class NoteController {

    private NoteService noteService;

    @GetMapping
    public ResponseEntity<Note> getAllMenu(@RequestBody Note note) {
        Note getNote = noteService.findNote(note);
        return new ResponseEntity<>(getNote, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Note> addFood(@RequestBody Note note) {
        Note newNote = noteService.addNote(note);
        return new ResponseEntity<>(newNote, HttpStatus.CREATED);
    }
}
