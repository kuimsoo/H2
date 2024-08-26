package com.cinema.cinema;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CinemaController {
	@Autowired CinemaDAO cdao;  
	
	@GetMapping("/cinema")
	public String cinema() {
		return "cinema/cinema";
	}
	
	@GetMapping("/park")
	public String park() {
		return "cinema/park";
	}
	
	@PostMapping("/getmoviename")
	@ResponseBody
	public String getmoviename(HttpServletRequest req,Model model) {
		String mdate = req.getParameter("mdate");
		ArrayList<MovienameDTO> mlist = cdao.Moviename(mdate);
		JSONArray Mli = new JSONArray();
		for(MovienameDTO Mdto : mlist) {
			JSONObject T = new JSONObject();
			T.put("mname",Mdto.getMname());
			T.put("runningtime",Mdto.getRunningtime());
			T.put("age",Mdto.getAge());
			Mli.put(T);
		}
		return Mli.toString();
	}
	@PostMapping("/getroom")
	@ResponseBody
	public String getroom(HttpServletRequest req,Model model) {
		String mdate = req.getParameter("mdate");
		String mname = req.getParameter("mname");
		ArrayList<RoominfoDTO> mlist = cdao.Roominfo(mdate,mname);
		JSONArray Mli = new JSONArray();
		for(RoominfoDTO Mdto : mlist) {
			JSONObject T = new JSONObject();
			T.put("Sname",Mdto.getSname());
			T.put("seatlevel",Mdto.getSeatlevel());
			T.put("allseat",Mdto.getAllseat());
			Mli.put(T);
		}
		return Mli.toString();
	}
	@PostMapping("/getroom2")
	@ResponseBody 
	public String getroom2(HttpServletRequest req,Model model) {
		String mdate = req.getParameter("mdate");
		
		ArrayList<Roominfo2DTO> mlist = cdao.Roominfo2(mdate);
		JSONArray Mli = new JSONArray();
		for(Roominfo2DTO Mdto : mlist) {
			JSONObject T = new JSONObject();
			T.put("Sname",Mdto.getSname());
			T.put("seatlevel",Mdto.getSeatlevel());
			T.put("allseat",Mdto.getAllseat());
			T.put("mname",Mdto.getMname());
			Mli.put(T);
		}
		return Mli.toString();
	}
	
	@PostMapping("/moviedate")
	@ResponseBody
	public String moviedate(HttpServletRequest req,Model model) {
		String mdate = req.getParameter("mdate");
		System.out.println(mdate);
		ArrayList<MoviedateDTO> mlist = cdao.Moviedate(mdate);
		JSONArray Mli = new JSONArray();
		for(MoviedateDTO Mdto : mlist) {
			JSONObject T = new JSONObject();
			T.put("mname",Mdto.getMname());
			T.put("runningtime",Mdto.getRunningtime());
			T.put("age",Mdto.getAge());
			T.put("allseat",Mdto.getAllseat());
			T.put("Sname",Mdto.getSname());
			T.put("seatlevel",Mdto.getSeatlevel());
			T.put("moviedate",Mdto.getMoviedate());
			T.put("lestseat",Mdto.getLestseat());
			T.put("begintime",Mdto.getBegintime());
			T.put("endtime",Mdto.getEndtime());
			Mli.put(T);
		}
		return Mli.toString();
	}
	
}
