package com.yedam.notice.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Command;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeListJson implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		NoticeService service = new NoticeServiceImpl();
		List<NoticeVO> list = service.noticeList();
		// NoticeVO => ArrayList<String>
		List<String> innerList = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		
		Gson gson = new GsonBuilder().create();

		return gson.toJson(map) + ".json";
	}

}