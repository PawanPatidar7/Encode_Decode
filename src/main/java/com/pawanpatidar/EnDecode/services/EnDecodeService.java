package com.pawanpatidar.EnDecode.services;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class EnDecodeService {

	public String decoderHandler(String Str) {
		
		String strDecoded=URLDecoder.decode(Str);
		
		return strDecoded;
	}
	
     public String encodeHandler(String Str) {
		
		String strEncoded=URLEncoder.encode(Str);
		
		return strEncoded;
	}
}
