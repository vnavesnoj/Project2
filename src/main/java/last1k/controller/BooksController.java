package last1k.controller;

import last1k.ReadDto.BookReadDto;
import last1k.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"book"})
public class BooksController {
    @Autowired
    private BooksService booksService;
    @GetMapping("/books/new")
    public String createBookPage() {
        return "createBook";
    }

    @PostMapping("/books/new")
    public String createBook(BookReadDto bookReadDto, Model model) {
        model.addAttribute("book", booksService.createBook(bookReadDto));
        return "redirect:/books/%s/edit".formatted(bookReadDto.getName());
    }
    @GetMapping("/books/{name}/edit")
    public String editBookPage(@PathVariable String name, Model model) {
        model.addAttribute("book", booksService.findByName(name));
        return "editBook";
    }
    @PostMapping("/books/{name}/edit")
    public String editBook(BookReadDto bookReadDto, Model model) {
        model.addAttribute("book", booksService.updateBook(bookReadDto));
        return "redirect:/books/%s/edit".formatted(bookReadDto.getName());
    }

    @GetMapping("/books/{name}")
    public String bookPage(@PathVariable String name, Model model) {
        model.addAttribute("book", booksService.findByName(name));
        return "bookPage";
    }

}
