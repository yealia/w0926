package com.example.w0926.controller;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet(name = "LottoServlet", value = {"/lotto","/lotto2"})
public class LottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpg");

        BufferedImage image =
                new BufferedImage(500,300,BufferedImage.TYPE_INT_RGB);

        //붓
        Graphics graphics = image.getGraphics();
        //물감
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,500,300);

        graphics.setColor(Color.black);

        //int value =(int)(Math.random()*10000);
        //int a = (int)(Math.random()*45)+1;

        int a[]= new int[6];

        for(int i=0; i<6; i++){
            a[i] = (int)(Math.random()*45)+1;

            for(int j=0; j<i; j++){
                if(a[i] == a[j]){
                    i--;
                    break;
                }

            }

            System.out.print(a[i]+ " ");
        }
        for(int i=0; i<6; i++){
            Font plainFont = new Font("Serif", Font.BOLD, 20);
            graphics.setFont(plainFont);

            graphics.drawString(""+a[i],50+(i*30),140);

        }

        OutputStream os = response.getOutputStream();

        ImageIO.write(image,"gif",os);
//
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("LottoServlet.......GET");
//        System.out.println(this);
//        System.out.println(Thread.currentThread().getName());
//        System.out.println("---------------------");




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=======");
    }
}
