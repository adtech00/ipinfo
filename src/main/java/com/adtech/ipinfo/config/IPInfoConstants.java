package com.adtech.ipinfo.config;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class IPInfoConstants {
    public static final String geoLiteDBLocation = "/adtech/resources/ipinfo/geolocation/GeoLite2-City.mmdb";
    public static final String RESPONSE_PAGE1="<!DOCTYPE html>\n" +
            "<html>\n" +
            "    <body style=\"background-image: url(https://images.pexels.com/photos/1526/dark-blur-blurred-gradient.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940);\">\n" +
            "        <div class=\"row jumbotron vertical-center-row\">\n" +
            "            <h1 style=\"font-size:40px; font-family:'Courier New'\" align=\"center\">IpInfo</h1>\n" +
            "            <br>\n" +
            "            <br>\n" +
            "            <div class=\"row\">\n" +
            "                <div class = \"panel panel-default panel-cust\" style=\"width:100%;\">\n" +
            "                    <div>\n" +
            "                        <h2 align=\"center\">Ip Address</h2>\n" +
            "                        <h4 align=\"center\">ipAddress</h4>\n" +
            "                    </div>\n" +
            "                    <br>\n" +
            "                    <br>\n" +
            "                    <div>\n" +
            "                        <h2 class=\"desc\" align=\"center\">Description</h2>\n" +
            "                        <p align=\"center\">ipDetails</p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "        <br>\n" +
            "        <br>\n" +
            "        <br>\n" +
            "        <br>\n" +
            "        <br>\n" +
            "        <br>\n" +
            "\n" +
            "        <footer align=\"center\" style=\"position: fixed;\n" +
            "  left: 0;\n" +
            "  bottom: 0;\n" +
            "  width: 100%;\">\n" +
            "            <div class=\"creditSection\">\n" +
            "                <div class=\"col-md-12 text-center mt-4\">\n" +
            "                    <p>Designed with <span class=\"heart\" style=\"color: red; font-size: 22px;\"> &hearts; </span> by AD Tech</p>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            \n" +
            "            <div class=\"copyrightSection\">\n" +
            "                <div class=\"col-md-12 text-center\">\n" +
            "                    <p>&copy; 2020 AD Tech Pvt. Ltd., All Rights Reserved.</p>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </footer>\n" +
            "    </body>\n" +
            "</html>";

    public static String RESPONSE_PAGE;
    static {
        try {
            RESPONSE_PAGE = new String(Files.readAllBytes(Paths.get("src/main/resources/templates/ipres/ipinfo.html")));
        } catch (IOException e) {
            e.printStackTrace();
            RESPONSE_PAGE = RESPONSE_PAGE1;
        }
    }
}
