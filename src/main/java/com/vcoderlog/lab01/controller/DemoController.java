package com.vcoderlog.lab01.controller;

import com.vcoderlog.lab01.reponsitory.models.response.EditByName;
import com.vcoderlog.lab01.reponsitory.models.response.SearchDemoByNameRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("demo")
public class DemoController {

    List<String> demos = new ArrayList<>();


    @GetMapping("init-demo-list")
    List<String> initDemoList() {
        demos.add("Demo 1");
        demos.add("Demo 2");
        demos.add("Demo 3");
        demos.add("Demo 4");

        return this.demos;
    }

    @GetMapping("get-demo-list")
    List<String> getDemoList() {

        return this.demos;
    }


    @GetMapping("get-demo-list-by-index/{index}")
    String getDemoList(@PathVariable int index) {
        if (index > demos.size() - 1) {
            return "";
        }
        return this.demos.get(index);
    }

    @PostMapping("search-by-name")
    List<String> getDemoByBodyRequest(@RequestBody SearchDemoByNameRequest request) {

        return demos.stream().filter(r -> r.equals(request.getName())).collect(Collectors.toList());
    }

    @PutMapping("edit/{index}")
    Boolean editList(@PathVariable int index, @RequestBody EditByName request) {
        if (index > demos.size() - 1) {
            return false;
        }

        this.demos.set(index, request.getName());
        return true;
    }


    @DeleteMapping("delete/{index}")
    Boolean deleteItem(@PathVariable int index) {
        if (index > demos.size() - 1) {
            return false;
        }

        this.demos.remove(index);
        return true;
    }
}
