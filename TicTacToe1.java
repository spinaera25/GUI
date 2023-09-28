/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tictactoe1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class TicTacToe1 {
    
    static ArraysList<Integer> playerPositions = new ArraysList<Integer>();
    static ArraysList<Integer> cpuPositions = new ArraysList<Integer>();
    
    public static void main(String[] args) {
        
        char[][]gameBoard = {{' ','|', ' ', '|', ' '}, 
        {'-','+', '-', '+', '-'},
        {' ','|', ' ', '|', ' '},
        {'-','+', '-', '+', '-'},
        {' ','|', ' ', '|', ' '}};
        
        printGameBoard(gameBoard);
        
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int playerPos = scan.nextInt();
            while(playerPositions.contains(playerPos)|| cpuPositions.contains(playePositions)){
                System.out.println("Positions taken! Enter a correct position");
                playerPos = scan.nextInt();
            }

            placePie(gameBoard, playerPos, "player");
            
            String result = checkWinner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9)+1;
            while(playerPositions.contains(cpuPos)|| cpuPositions.contains(cpuPos)){
                cpuPos = rand.nextInt(9)+1;
            }
            placePie(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);
            
            result = checkWinner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }
            System.out.println(result);
        }
        
    }
    
    public static void printGameBoard(char[][] gameBoard){
        for(char[] row: gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    
    public static void placePiece(char[][] gameBoard, int pos, String user){
        
        char symbol = ' ';
        
        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(pos);
        }else if (user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(pos);
        }
        
        switch(pos){
            case 1:
                gameBoard[0][0]= symbol;
                break;   
            case 2:
                gameBoard[0][2]= symbol;
                break;
            case 3:
                gameBoard[0][4]= symbol;
                break;
            case 4:
                gameBoard[2][0]= symbol;
                break;
            case 5:
                gameBoard[2][2]= symbol;
                break;
            case 6:
                gameBoard[2][4]= symbol;
                break;
            case 7:
                gameBoard[4][0]= symbol;
                break;
            case 8:
                gameBoard[4][2]= symbol;
                break;
            case 9:
                gameBoard[4][4]= symbol;
                break;      
        }
    }
    
    public static String checkWinner(){
        
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);
        
        
        
        List<List>winning = new ArraysList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);
        
        for (List l : winning){
            if(playerPositions.containsAll(l)){
                return "Congratulation you won!";
            }else if(cpuPositions.contains(l)){
                return"CPU wins! Sorry :(";
            }else if(playerPositions.size()+cpuPositions.size()==9){
                return "CAT!";
            }
        }
        
        return "";
    }

    private static void placePie(char[][] gameBoard, int cpuPos, String cpu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}