package com.example.consumeapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//@Controller
public class UserController {

    @GetMapping("/hello")
    //@ResponseBody
    private String hello(){
        return "Hello";
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    private ModelAndView getUser(@PathVariable Integer id, Model model) {
        String uri = "https://jsonplaceholder.typicode.com/users/" + id;
        RestTemplate restTemplate = new RestTemplate();

        User user = restTemplate.getForObject(uri, User.class);
        /*System.out.println("User: " + user);

        System.out.println("Userid: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());

        Address address = user.getAddress();
        System.out.println("Address: "
                + address.getStreet() + ", "
                + address.getCity() + ", "
                + address.getZipcode()
        );

        Geo geo = address.getGeo();
        System.out.println("Geo Lat: "
                + geo.getLat() + ", Geo Lng: "
                + geo.getLng()
        );

        Company company = user.getCompany();
        System.out.println("Company: "
                + company.getName() + ", "
                + company.getCatchPhrase() + ", "
                + company.getBs()
        );

        return "User detail page.";*/
        Address address = user.getAddress();
        Geo geo = address.getGeo();
        Company company = user.getCompany();
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        modelAndView.addObject("address", address);
        modelAndView.addObject("geo", geo);
        modelAndView.addObject("company", company);

        return modelAndView;
    }

    /*public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }*/

}

