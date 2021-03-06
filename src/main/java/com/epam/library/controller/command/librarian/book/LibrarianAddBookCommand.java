package com.epam.library.controller.command.librarian.book;

import com.epam.library.controller.command.Command;
import com.epam.library.controller.command.PageLocation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibrarianAddBookCommand implements Command {

    /**
     * @param request  from the jsp
     * @param response to the jsp
     * @return page which when the librarian needs to add book, this page will hold an empty form
     * so the librarian can fill it then submit it to the database
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PageLocation.LIBRARIAN_ADD_BOOK;
    }
}
