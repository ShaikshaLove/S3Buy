package io.ibm.app.controller;

import io.ibm.app.model.Product;
import io.ibm.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;
    
    @RequestMapping("/regProduct")
    public String getReg(){
        return "ProductReg";
    }

    @RequestMapping(value="saveProduct",method=RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute Product product, @RequestParam("image")MultipartFile file){
        String fileName=file.getOriginalFilename();
        StringTokenizer tokens=new StringTokenizer(fileName,".");
        String extention=null;
        while(tokens.hasMoreTokens()){
           String fileExt= tokens.nextToken();
           if(fileExt.equals("png")){
               extention=".png";
           }
            if(fileExt.equals("jpg")){
                extention=".jpg";
            }
           }
        String id= productService.saveProduct(product);
        String imgName=id+extention;
        System.out.println(id);
        System.out.println(imgName);
        product.setImagName(imgName);
        productService.updateProduct(product);
        File f=new File("src/main/webapp/images/products");
        File fname=new File(f,id+extention);
        FileOutputStream fos=null;
        try {
            fname.createNewFile();
            fos=new FileOutputStream(fname,false);
            fos.write(file.getBytes());
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return new ModelAndView("ProductReg","msg","Product has been saved with id "+id);
    }
}
