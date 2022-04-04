package main;

import java.util.Arrays;
import java.util.Scanner;

import model.Person;
import model.Tower;

public class Main {
	
	public static Scanner rd=new Scanner(System.in);

	public static void main(String[] args) {
		
		String exc="Excepciones: \n";
		String msg="";
		int n=rd.nextInt();
		rd.nextLine();
		Tower[] twrs=new Tower[n];
		for(int i=0;i<n;i++) {
			
			String line=rd.nextLine();
			String[] in=line.split(" ");
			String ltr=in[0];
			int people,flrs,off;
			people=Integer.parseInt(in[1]);
			flrs=Integer.parseInt(in[2]);
			off=Integer.parseInt(in[3]);
			twrs[i]=new Tower(ltr, flrs, off);
			Person[] prsn=new Person[people];	
			int prInv=0;
			
			for(int j=0;j<people;j++) {
				String ppl=rd.nextLine();
				String[] inf=ppl.split(" ");
				int dstnyFlr=((((flrs*off)-Integer.parseInt(inf[2]))/off)+1);
				int direct=dstnyFlr-Integer.parseInt(inf[1]);
				Person pr=new Person(inf[0], Integer.parseInt(inf[1]), Integer.parseInt(inf[2]), direct, dstnyFlr);
				if(pr.getIniFloor()>flrs || pr.getDstnyOff()>(flrs*off)) {
					exc+=pr.getName()+" no tiene un movimiento valido en el edificio.\n";
					prInv++;
				}else {
					prsn[j]=pr;
				}

			}
			
			if(prInv>0) {
				int k=0;
				Person[] prsn1=new Person[people-prInv];	
				for(int j=0;j<prsn.length;j++) {
					if(prsn[j]!=null) {
						prsn1[k]=prsn[j];
						k++;
					}
				}
				Arrays.sort(prsn1);
				for(int j=0;j<people-prInv;j++) {
					twrs[i].addPPl(prsn1[j]);
				}
			}else {
				Arrays.sort(prsn);
				for(int j=0;j<people;j++) {
					twrs[i].addPPl(prsn[j]);
				}
			}
				
			twrs[i].order();
			msg+="\n--------------------\n\n"+twrs[i].toString();
		}
		
		System.out.println(exc+msg);
	}

}
