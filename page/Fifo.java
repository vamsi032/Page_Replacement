import java.io.*;
public class Fifo {
	public static void main(String[] args) throws Exception
	{
		int fault=0,i,p,j,num=0,f;
		int page[];
		int frame[];
		boolean k=true;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Give No of Frames");
 		f=Integer.parseInt(br.readLine());
		System.out.println("Give no of pages:");
 		p=Integer.parseInt(br.readLine());
 		page=new int[p];
 		frame=new int[f];
 		System.out.println("Enter Numbers:");
 		for(i=0;i<p;i++)
 		{
 			page[i]=Integer.parseInt(br.readLine());
 		}
 		for(i=0;i<f;i++)
 		{
 			frame[i]=-1;
 		}
 		for(i=0; i<p ;i++)
 		{
 		    k=true;
 			for(j=0;j<f;j++)
 			{	
 				if(frame[j]==page[i])
 				{
 					k=false;
 					break;
 				}
 			}
 			if (num==f)
 			{
 				num=0;
 			}
 			if(k==true)
 			{
 				frame[num]=page[i];
 				num++;
 				fault++;
 			}
 			System.out.print("Frame Changes as follows:");
 			for(int y=0;y<f;y++)
 				System.out.print(frame[y]+" ");
 			System.out.println();
 		}
	
 			System.out.println("No of PageFaults:"+fault);
	}
}