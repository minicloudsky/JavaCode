package com.cbh.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {

	private static JedisPool pool = null;
	static {
		InputStream in =JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
		Properties props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(Integer.parseInt(props.getProperty("redis.maxIdle")));
		poolConfig.setMinIdle(Integer.parseInt(props.getProperty("redis.minIdle")));
		poolConfig.setMaxTotal(Integer.parseInt(props.getProperty("redis.maxTotal")));
		
		String url = props.getProperty("redis.url");
		int port = Integer.parseInt(props.getProperty("redis.port"));
		
		pool = new JedisPool(poolConfig,url,port);
	}
	public static Jedis getJedis() {
		Jedis jedis = pool.getResource();
		//jedis.auth("redis1234");
		return jedis;
	}
	
	public static void main(String[] args) {
		Jedis jedis = getJedis();
		System.out.println(jedis.get("姓名"));
	}
}
