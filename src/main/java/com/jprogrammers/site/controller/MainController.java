package com.jprogrammers.site.controller;

import com.jprogrammers.site.util.FileUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) throws IOException {
        model.addAttribute("menu", getMenuItems());
        return "index";
    }

    private List<String> getMenuItems() throws IOException {

        List<String> folders = new ArrayList<>();

        Files.walk(Paths.get(FileUtil.HOME), 1)
                .filter(Files::isDirectory)
                .forEach(folder -> folders.add(folder.toFile().getName()));

        return folders;
    }

}
