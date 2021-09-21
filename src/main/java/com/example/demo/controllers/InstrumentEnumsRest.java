package com.example.demo.controllers;


import com.example.demo.enums.InstrumentEnum;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin
@RestController
public class InstrumentEnumsRest {


    @RequestMapping("/get-all-instrument-enums")
    public Collection<String> getAllInstrumentEnums() {
        Collection<String> instrumentEnums = new ArrayList<>();
        for (InstrumentEnum instrumentEnum : InstrumentEnum.values()) {
            instrumentEnums.add(instrumentEnum.toString());
        }
        return instrumentEnums;
    }


}
