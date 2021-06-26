package com.maarouf.simpleJavaBlockchain;

public class MyChain {
	
	public static void main(String[] args) {
	
		Block genesisBlock = new Block("0","Hello, I'm the first block");
		System.out.println("Hash for block 1: "+genesisBlock.hash);
		
		Block secondBlock = new Block(genesisBlock.hash,"Hello, I'm the second block");
		System.out.println("Hash for block 2: "+secondBlock.hash);
		
		Block thirdBlock = new Block(secondBlock.hash,"Hello, I'm the first block");
		System.out.println("Hash for block 3: "+thirdBlock.hash);
	}	
}
