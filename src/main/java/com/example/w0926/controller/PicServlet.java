package com.example.w0926.controller;

import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "PicServlet", value = "/pic1")
public class PicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpg");

        BufferedImage image =
                new BufferedImage(400,300,BufferedImage.TYPE_INT_RGB);

        //붓
        Graphics graphics = image.getGraphics();
        //물감
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,400,300);

        graphics.setColor(Color.black);

        int value =(int)(Math.random()*10000);


        Font plainFont = new Font("Serif", Font.BOLD, 50);
        graphics.setFont(plainFont);

        graphics.drawString(""+value,50,140);
        OutputStream os = response.getOutputStream();

        ImageIO.write(image,"gif",os);
    }

}
