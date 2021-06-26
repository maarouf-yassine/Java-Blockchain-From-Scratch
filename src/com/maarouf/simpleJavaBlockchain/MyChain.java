package com.maarouf.simpleJavaBlockchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class MyChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty=5;
	
	public static void main(String[] args) {
	
		blockchain.add(new Block("0","Hello, I'm the first block"));
		System.out.println("Trying to Mine block 1 ...");
		blockchain.get(0).mineBlock(difficulty);
		
		blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash,"Hello, I'm the second block"));
		System.out.println("Trying to Mine block 2 ...");
		blockchain.get(1).mineBlock(difficulty);
		
		blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash,"Hello, I'm the first block"));
		System.out.println("Trying to Mine block 3 ...");
		blockchain.get(2).mineBlock(difficulty);
		
		System.out.println("\nBlockchain is valid: "+ isChainValid());
		
		String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: \n"+blockChainJson);
	}

	private static Boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		//check hashes by looping through entire blockchain
		
		for(int i=1;i<blockchain.size();i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			
			//compare object hash with the calculated hash
			if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Problem Detected in block number: "+i+"! Hashes are not equal!");
				return false;
			}
			
			//compare previous block's hash with its registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash)) {
				System.out.println("Problem Detected in block number: "+i+"! Previous hash is not equal!");
				return false;
			}
			
			//check if the hash is correct according to difficulty
			if(!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
				System.out.println("Block number: "+i+"hasn't been mined");
				return false;
			}
		}
		return true;
	}	
}
