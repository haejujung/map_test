package com.tenco.map.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgis.PGgeometry;
import org.postgresql.PGConnection;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tenco.map.dto.NodeDTO;

@Controller
public class maincontroller {
	
	
	@GetMapping({"/main-page" , "/index"})
	public String mainPage(Model model) throws ClassNotFoundException, SQLException {
		System.out.println("mainPage() 호출 확인");

	
		return "getCordinates";
	}
	
	@GetMapping("/requestdata")
	@ResponseBody
	public List<NodeDTO> requestData() {
		
		List<NodeDTO> nodeDtoList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()){
			((PGConnection)conn).addDataType("geometry", PGgeometry.class);
			PreparedStatement pstmt = conn.prepareStatement(" select * from nodes  ");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				NodeDTO nodeDTO = NodeDTO.builder()
								  .id(rs.getInt("id"))
								  .name(rs.getString("name"))
								  .x(rs.getDouble("x"))
								  .y(rs.getDouble("y"))
								  .build();
						
				nodeDtoList.add(nodeDTO);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nodeDtoList;
		
	}
	

}
