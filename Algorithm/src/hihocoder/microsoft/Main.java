package hihocoder.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main{
    
    public int maxBallNumber(String ballSeq, int[] xyz){
        if(ballSeq == null)
            return 0;
        Arrays.sort(xyz);
        int Cr = 0, Cy = 0, Cb = 0;
        int[] diff = new int[]{0, 0, 0};
        int maxBallCnt = 0, ballCnt = 0;
        for(int i = 0; i < ballSeq.length(); i++){
            char ch = ballSeq.charAt(i);
            ballCnt++;
            if(ch == 'R')
                Cr++;
            else if(ch == 'Y')
                Cy++;
            else
                Cb++;
            diff[0] = Cr-Cy > 0 ? Cr-Cy : -(Cr-Cy);
            diff[1] = Cr-Cb > 0 ? Cr-Cb : -(Cr-Cb);
            diff[2] = Cy-Cb > 0 ? Cy-Cb : -(Cy-Cb);
            Arrays.sort(diff);
            
            if(diff[0] == xyz[0] && diff[1] == xyz[1] 
                && diff[2] == xyz[2]){
                    if(maxBallCnt < ballCnt){
                        maxBallCnt = ballCnt;
                        ballCnt = 0;
                        Cr = 0;
                        Cy = 0;
                        Cb = 0;
                    }
                }
        }
        if(maxBallCnt < ballCnt){
            maxBallCnt = ballCnt;
        }
        return maxBallCnt;
    }
    
    public static void main(String[] args) throws IOException{
        
        //Scanner in = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 20001);
    	String data = br.readLine();
    	String[] sdata = data.split(" ");
        int[] xyz = new int[3];
        xyz[0] = Integer.parseInt(sdata[0]);
        xyz[1] = Integer.parseInt(sdata[1]);
        xyz[2] = Integer.parseInt(sdata[2]);
        String seq = br.readLine();
        System.out.println(new Main().maxBallNumber(seq, xyz));
    }
}


/*import java.util.*;
import java.io.*;
public class Main{
    private LinkedList<Integer>[] tr;
    private int[] cntModule;
    private int[] sigToModule = new int[100000];
    
    public Main(int n){
        cntModule = new int[n+1];
        tr = (LinkedList<Integer>[])new LinkedList[n+1];
        for(int i = 0; i < n; i++)
            tr[i] = new LinkedList<>();
    }
    
    public int[] lineToInt(String s){
        if(s == null)
            return null;
        String[] tmp = s.split(" ");
        int[] arr = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }
        return arr;
    }
    
    
    public void breadthVist(int signal){
        if(sigToModule[signal] == 0)
            return ;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(sigToModule[signal]);
        while(!queue.isEmpty()){
            int node = queue.poll();
            cntModule[node]++;
            Iterator<Integer> it = tr[node].iterator();
            while(it.hasNext()){
                int nSig = it.next();
                if(sigToModule[nSig] != 0)
                    queue.offer(sigToModule[nSig]);
            }
        }
    }
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
            
        String sT = br.readLine();
        int T = Integer.parseInt(sT);
        for(int t = 0; t < T; t++){
            int N, numOfInitSig;
            int[] tmpData = lineToInt(br.readLine());
            N = tmpData[0];
            numOfInitSig = tmpData[1];
            int[] signal = lineToInt(br.readLine());
            
            //read data of each module
            int[] moduleData;
            for(int i = 0; i < N; i++){
                moduleData = lineToInt(br.readLine());
                sigToModule[moduleData[0]] = i+1;
                tr[i+1].add(moduleData[0]);
                // construct linked nodes
                for(int j = 0; j < moduleData[1]; j++){
                    tr[i+1].add(moduleData[j+2]);
                    //sigToModule[moduleData[j+2]] = 0;
                }
            }
            
            // visit
            for(int i = 0; i < numOfInitSig; i++){
                breadthVist(signal[i]);
            }
            
            for(int i = 0; i < N; i++){
                System.out.print(cntModule[sigToModule[tr[i+1].getNext()]] + " ");
            }
            System.out.println();
            
        }
            
    }
    
}*/