package com.yedam.myserver.cart.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.cart.mapper.CartMapper;
import com.yedam.myserver.cart.vo.CartVO;

@RestController
public class CartController {
	
	@Autowired CartMapper mapper;
	
	//�옣諛붽뎄�땲 �쟾泥댁“�쉶
	@RequestMapping("/cartSelectList")
	public List<CartVO> cartSelectList() {
		return mapper.findAll();
	}	
	
	//�옣諛붽뎄�땲 �떒嫄댁궘�젣
	@RequestMapping("/cartDelete")
	public CartVO cartDelete(CartVO vo) {
		mapper.remove(vo);
		return vo;
	}
	
	//�옣諛붽뎄�땲 �꽑�깮�궘�젣
	@RequestMapping("/cartDeleteCheck")
	public boolean cartDelete(String[] nos) {
		for(String no : nos) {
			CartVO vo = new CartVO();
			vo.setNo(no);
			mapper.remove(vo);
		}
		return true;
	}
	
	//�옣諛붽뎄�땲 �쟾泥댁궘�젣
	@RequestMapping("/cartDeleteAll")
	public boolean cartDeleteAll() {
		mapper.removeAll();
		return true;
	}

}
