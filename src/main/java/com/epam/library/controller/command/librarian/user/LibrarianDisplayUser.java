package com.epam.library.controller.command.librarian.user;

import com.epam.library.controller.command.Command;
import com.epam.library.entity.User;
import com.epam.library.model.service.ServiceException;
import com.epam.library.model.service.ServiceFactory;
import com.epam.library.model.service.UserService;
import com.epam.library.util.PageLocation;
import com.epam.library.util.constant.UserConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LibrarianDisplayUser implements Command {
    private UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        User user = (User) request.getSession(false).getAttribute(UserConstant.USER_ATTRIBUTE);
        try {
            if(user != null){
                request.setAttribute(UserConstant.USER_ATTRIBUTE, user);
                List<User> users = userService.getAllUsers();
                request.setAttribute(UserConstant.USER_LIST, users);
                page = PageLocation.LIBRARIAN_DISPLAY_READERS;

            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}