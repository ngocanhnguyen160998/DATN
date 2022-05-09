package com.controller.api;

import com.model.response.UtilResponse;
import com.service.CommuneService;
import com.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AddressAPI {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private CommuneService wardService;

    @PostMapping("/api/province")
    private void chageProvince(@RequestBody UtilResponse utilResponse, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String> stringMap = districtService.findById(utilResponse.getProvinceId());
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<option value=\"0\" style=\"font-weight:bold; color: black\">-- Chọn Quận/Huyện--</option>");
        for (Map.Entry<String, String> stringMap1 : stringMap.entrySet()
        ) {
            printWriter.println("<option value=\""+stringMap1.getKey()+"\" style=\"font-weight:bold; color: black\">"+stringMap1.getValue()+"</option>");

        }
    }

    @PostMapping("/api/district")
    private void chageDistrict(@RequestBody UtilResponse utilResponse,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String> stringMap = wardService.findAllByDistrictId(utilResponse.getDistrictId());
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<option value=\"0\" style=\"font-weight:bold; color: black\">-- Chọn Xã/Phường--</option>");
        for (Map.Entry<String, String> stringMap1 : stringMap.entrySet()) {
            printWriter.println("<option value=\""+stringMap1.getKey()+"\" style=\"font-weight:bold; color: black\">"+stringMap1.getValue()+"</option>");

        }
    }
}
