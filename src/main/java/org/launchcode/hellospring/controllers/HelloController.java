package org.launchcode.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }

        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name =='name' />" +
                "<select id='greeting' greeting == greeting>" +
                    "<option value='English'>English</option>" +
                    "<option value='French'>French</option>" +
                    "<option value='Spanish'>Spanish</option>" +
                    "<option value='Hawaiian'>Hawaiian</option>" +
                    "<option value='German'>German</option>" +
                    "<option value='Italian'>Italian</option>" +
                    "<option value='Latin'>Latin</option>" +
                "<input type='submit' value='Greet Me!'" +
                "</form>";

        return html;
    }


    @RequestMapping(value = "greeting", method= RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {

        String greeting = request.getParameter("greeting");
        String name = request.getParameter("name");

            if (greeting == "English") {
            return "Hello, " + name;

            }else if (greeting == "French"){
            return "Bonjour, " + name;

            }else if (greeting == "Spanish") {
            return "Hola, " + name;

            }else if (greeting == "Hawaiian") {
            return "Aloha, " + name;

            }else if (greeting == "German") {
            return "Hallo, " + name;

            }else if (greeting == "Italian") {
            return "Ciao, " + name;

            }else if (greeting == "Latin") {
            return "Ave, " + name;
            }

            else {
                return "Hello, " + name;
            }

    }



//    @ResponseBody
//    public String helloPost(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        return "Hello, " + name;
//    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello, " + name;

    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }
}

