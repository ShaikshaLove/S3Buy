package io.ibm.app.controller;

import io.ibm.app.model.Rice;
import io.ibm.app.service.IRiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RiceController {

    @Autowired
    private IRiceService riceService;
    @RequestMapping("/insertRice")
    public String saveRice(@ModelAttribute Rice rice, ModelMap map){
        int id=riceService.saveRice(rice);
        map.put("message","Voila!! The Data has been Saved with id "+id);
        return "RiceRegister";
    }

    @RequestMapping("/regRice")
    private String getRiceReg(){
        return "RiceRegister";
    }


}
