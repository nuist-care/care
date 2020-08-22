
package com.neuedu.care.util;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.kerberos.KerberosKey;
import javax.xml.bind.DatatypeConverter;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;

import com.neuedu.care.config.Audience;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//jwt工具类（抽象类，无需实例化）：生成token，验证token
public abstract class JWTTokenUtil {
	public static final String AUTH_HEAD_KEY="Authorization";
	
	public static String createJWT(String userid,String username,Audience audience) {
		//使用HAS256加密算法
		SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
		//获取当前时间
		long begin_millis=System.currentTimeMillis();
		//实例化java.util.Date对象
		Date begin_date=new Date(begin_millis);
		//生成签名密钥
		byte[] api=DatatypeConverter.parseBase64Binary(audience.getBase64Secret());
		Key key=new SecretKeySpec(api,signatureAlgorithm.getJcaName());
		Map<String, Object> header=new HashMap<String, Object>();
		header.put("alg",SignatureAlgorithm.HS256.getValue() );
		header.put("typ","JWT" );
		JwtBuilder builder=Jwts.builder().setHeader(header)//设置头信息
				.claim("userid", userid)//将特定的用户信息存储在cliam中，敏感数据需要加密
				.setSubject(username)//设置JWT主体body
				.setIssuer(audience.getClientid())//设置JWT签发主体
				.setIssuedAt(new Date())//设置签发时间
				.setAudience(audience.getName())//设置接收者
				.signWith(signatureAlgorithm, key);//设置签名
		int time=audience.getExpiresSecond();
		if(time>0) {
			long exp=begin_millis+time*1000;
            Date exp_date=new Date(exp);
            builder.setExpiration(exp_date)//是一个时间戳，exp_date代表是过期时间
               .setNotBefore(begin_date);//是一个时间戳，begin_date开始生效时间，在此之前验证
		}
		//简单说就是生成token
	    return builder.compact();//生成序列化安全url字符串
	}
	public static Claims parseJWT(String token,String base64Security) {
		Claims claims=Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
				.parseClaimsJws(token)
				.getBody();
		return claims;
	}
	
	public static String getUserName(String token,String base64Security) {
		return parseJWT(token, base64Security).getSubject();
	}
	
	public static String getUserIdString(String token,String base64Security) {
		return parseJWT(token, base64Security).get("userid",String.class);
	}
	
	public static boolean isExpiration(String token,String base64Security) {
		return parseJWT(token, base64Security).getExpiration().before(new Date());
	}
  
}
