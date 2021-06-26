package com.maarouf.simpleJavaBlockchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class MyChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	
	
	public static void main(String[] args) {
	
		blockchain.add(new Block("0","Hello, I'm the first block"));
		
		blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash,"Hello, I'm the second block"));
		
		blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash,"Hello, I'm the first block"));
		
		String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println(blockChainJson);
	}	
}
